/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_park_informatique;

/**
 *
 * @author Miandry
 */
public class demmadeData {

    public demmadeData(Integer id, String type, String marque, String num_serie, String model, String system, String nom, String matricule, String poste, String porte, String message) {
        this.id = id;
        this.type = type;
        this.marque = marque;
        this.num_serie = num_serie;
        this.model = model;
        this.system = system;
        this.nom = nom;
        this.matricule = matricule;
        this.poste = poste;
        this.porte = porte;
        this.message = message;
    }

    public Integer getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getMarque() {
        return marque;
    }

    public String getNum_serie() {
        return num_serie;
    }

    public String getModel() {
        return model;
    }

    public String getSystem() {
        return system;
    }

    public String getNom() {
        return nom;
    }

    public String getMatricule() {
        return matricule;
    }

    public String getPoste() {
        return poste;
    }

    public String getPorte() {
        return porte;
    }

    public String getMessage() {
        return message;
    }

    private Integer id;
    private String type;
    private String marque;
    private String num_serie;
    private String model;
    private String system;
    
    private String nom;
    private String matricule;
    private String poste;
    private String porte;
    private String message;

}
