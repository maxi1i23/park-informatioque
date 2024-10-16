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
public class adminData {

    public adminData(Integer id, String nom, String email, String adresse, String telephone, String user, String mdp, String poste, String photos) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.adresse = adresse;
        this.telephone = telephone;
        this.user = user;
        this.mdp = mdp;
        this.poste = poste;
        this.photos = photos;
    }

    public Integer getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getEmail() {
        return email;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getUser() {
        return user;
    }

    public String getMdp() {
        return mdp;
    }

    public String getPoste() {
        return poste;
    }

    public String getPhotos() {
        return photos;
    }

    private Integer id;
    private String nom;
    private String email;
    private String adresse;
    private String telephone;
    private String user;
    private String mdp;
    private String poste;
    private String photos;

}
