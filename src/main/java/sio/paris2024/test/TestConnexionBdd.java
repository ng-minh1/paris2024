/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sio.paris2024.test;

import java.sql.Connection;
import sio.paris2024.database.ConnexionBdd;

/**
 *
 * @author zakina
 */
public class TestConnexionBdd {
      public static void main (String args[]){
        
        Connection cnx = ConnexionBdd.ouvrirConnexion();
        
        
    }
}
