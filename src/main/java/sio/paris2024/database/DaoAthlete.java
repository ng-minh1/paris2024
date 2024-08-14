/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sio.paris2024.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
            requeteSql = cnx.prepareStatement("select a.id as a_id, a.nom as a_nom,  p.id as p_id, p.nom as p_nom " +
                         " from athlete a inner join pays p " +
                         " on a.pays_id = p.id ");
            //System.out.println("REQ="+ requeteSql);
            resultatRequete = requeteSql.executeQuery();
            
            while (resultatRequete.next()){
                
                Athlete a = new Athlete();
                   a.setId(resultatRequete.getInt("a_id"));
                   a.setNom(resultatRequete.getString("a_nom"));
                    
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
            requeteSql = cnx.prepareStatement("select a.id as a_id, a.nom as a_nom,  p.id as p_id, p.nom as p_nom " +
                         " from athlete a inner join pays p " +
                         " on a.pays_id = p.id " + 
                         " where a.id = ? ");
            //System.out.println("REQ="+ requeteSql);
            requeteSql.setInt(1, idAthlete);
            resultatRequete = requeteSql.executeQuery();
            
            if (resultatRequete.next()){
                
                   a.setId(resultatRequete.getInt("a_id"));
                   a.setNom(resultatRequete.getString("a_nom"));
                    
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
}
