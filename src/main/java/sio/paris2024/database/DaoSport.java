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
import static sio.paris2024.database.DaoSport.requeteSql;
import static sio.paris2024.database.DaoSport.resultatRequete;
import sio.paris2024.model.Sport;
import sio.paris2024.model.Epreuve;

/**
 *
 * @author SIO2
 */
public class DaoSport {
    
    Connection cnx;
    static PreparedStatement requeteSql = null;
    static ResultSet resultatRequete = null;
    
    public static ArrayList<Sport> getLesSports(Connection cnx){
        
        ArrayList<Sport> lesSports = new ArrayList<Sport>();
        try{
            requeteSql = cnx.prepareStatement("select sport.id as s_id, sport.libelle as s_libelle from sport");
            //System.out.println("REQ="+ requeteSql);
            resultatRequete = requeteSql.executeQuery();
            
            while (resultatRequete.next()){
                
                Sport s = new Sport();
                   s.setId(resultatRequete.getInt("s_id"));
                   s.setLibelle(resultatRequete.getString("s_libelle"));
                
                lesSports.add(s);
            }
           
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("La requête de getLesSports e généré une erreur");
        }
        return lesSports;
    }
    
    public static ArrayList<Epreuve> getLesEpreuvesSportById(Connection cnx, int idSport){
       ArrayList<Epreuve> lesEpreuves = new ArrayList<Epreuve>();
        try{
            requeteSql = cnx.prepareStatement("select epreuve.id as e_id, epreuve.nom as e_nom " +
                    "from sport " +
                    "inner join epreuve " +
                    "on sport.id = epreuve.sport_id" +
                    " where sport.id = ?; ");
            //System.out.println("REQ="+ requeteSql);
            requeteSql.setInt(1, idSport);
            resultatRequete = requeteSql.executeQuery();
            
            while(resultatRequete.next()){
                Epreuve e = new Epreuve();
                e.setId(resultatRequete.getInt("e_id"));
                e.setNom(resultatRequete.getString("e_nom"));
                        
                lesEpreuves.add(e);
            }
           
    }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("La requête de getLesPompiers e généré une erreur");
        }
        return lesEpreuves;
    }
}
