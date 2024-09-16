/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sio.paris2024.database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import sio.paris2024.model.Athlete;
import sio.paris2024.model.Pays;

/**
 *
 * @author zakina
 */
public class DaoAthlete {
    
    Connection cnx;
    static PreparedStatement requeteSql = null;
    static ResultSet resultatRequete = null;
    
    public static ArrayList<Athlete> getLesAthletes(Connection cnx){
        
        ArrayList<Athlete> lesAthletes = new ArrayList<Athlete>();
        try{
            requeteSql = cnx.prepareStatement("select a.id as a_id, a.nom as a_nom, a.prenom as a_prenom, a.dateNaiss as a_dateNaiss, p.id as p_id, p.nom as p_nom " +
                         " from athlete a inner join pays p " +
                         " on a.pays_id = p.id ");
            //System.out.println("REQ="+ requeteSql);
            resultatRequete = requeteSql.executeQuery();
            
            while (resultatRequete.next()){
                
                Athlete a = new Athlete();
                   a.setId(resultatRequete.getInt("a_id"));
                   a.setNom(resultatRequete.getString("a_nom"));
                   a.setPrenom(resultatRequete.getString("a_prenom"));
                    
                   Date date = resultatRequete.getDate("a_dateNaiss");
                   a.setDateNaiss(date.toLocalDate());
                   
                   Pays p = new Pays();
                   p.setId(resultatRequete.getInt("p_id"));
                   p.setNom(resultatRequete.getString("p_nom"));
                
                    a.setPays(p);
                
                lesAthletes.add(a);
            }
           
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("La requête de getLesPompiers e généré une erreur");
        }
        return lesAthletes;
    }
    
    public static Athlete getAthleteById(Connection cnx, int idAthlete){
        
        Athlete a = new Athlete();
        try{
            requeteSql = cnx.prepareStatement("select a.id as a_id, a.nom as a_nom, a.prenom as a_prenom, a.datenaiss as a_datenaiss, p.id as p_id, p.nom as p_nom " +
                         " from athlete a inner join pays p " +
                         " on a.pays_id = p.id " + 
                         " where a.id = ? ");
            //System.out.println("REQ="+ requeteSql);
            requeteSql.setInt(1, idAthlete);
            resultatRequete = requeteSql.executeQuery();
            
            if (resultatRequete.next()){
                
                   a.setId(resultatRequete.getInt("a_id"));
                   a.setNom(resultatRequete.getString("a_nom"));
                   
                   a.setId(resultatRequete.getInt("a_id"));
                   a.setPrenom(resultatRequete.getString("a_prenom"));
                                      
                   Date date = resultatRequete.getDate("a_dateNaiss");
                   a.setDateNaiss(date.toLocalDate());
                    
                   Pays p = new Pays();
                   p.setId(resultatRequete.getInt("p_id"));
                   p.setNom(resultatRequete.getString("p_nom"));
                
                    a.setPays(p);
                
            }
           
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("La requête de getLesPompiers e généré une erreur");
        }
        return a;
    }
    
     public static Athlete addAthlete(Connection connection, Athlete ath){      
        int idGenere = -1;
        try
        {
            //preparation de la requete
            // id (clé primaire de la table athlete) est en auto_increment,donc on ne renseigne pas cette valeur
            // la paramètre RETURN_GENERATED_KEYS est ajouté à la requête afin de pouvoir récupérer l'id généré par la bdd (voir ci-dessous)
            // supprimer ce paramètre en cas de requête sans auto_increment.
            requeteSql=connection.prepareStatement("INSERT INTO athlete (nom, prenom, datenaiss, pays_id)\n" +
                    "VALUES (?,?,?,?)", requeteSql.RETURN_GENERATED_KEYS );
            requeteSql.setString(1, ath.getNom());
            requeteSql.setString(2, ath.getPrenom());
            
            LocalDate dateNaissance = ath.getDateNaiss();
            Date dateNaiss = Date.valueOf(dateNaissance);
            requeteSql.setDate(3,dateNaiss);
            
            requeteSql.setInt(4, ath.getPays().getId());

           /* Exécution de la requête */
            requeteSql.executeUpdate();
            
             // Récupération de id auto-généré par la bdd dans la table client
            resultatRequete = requeteSql.getGeneratedKeys();
            while ( resultatRequete.next() ) {
                idGenere = resultatRequete.getInt( 1 );
                ath.setId(idGenere);
                
                ath = DaoAthlete.getAthleteById(connection, ath.getId());
            }
            
         
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return ath ;    
    }
    
    
}
