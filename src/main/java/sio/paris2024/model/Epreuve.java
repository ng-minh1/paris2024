/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sio.paris2024.model;

/**
 *
 * @author SIO2
 */
public class Epreuve {
    
    private int id;
    private String libelle ;
    private Sport sport ;
    public Epreuve(){
    }
    
    public Epreuve(int id, String libelle) {
            this.id = id;
            this.libelle = libelle;
        }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return libelle;
    }

    public void setNom(String nom) {
        this.libelle = nom;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }
    
}
