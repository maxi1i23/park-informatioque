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
public class panneData {

    public panneData(Integer id, String materiel, String num_serie, String declaration, String nom, String matricule) {
        this.id = id;
        this.materiel = materiel;
        this.num_serie = num_serie;
        this.declaration = declaration;
        this.nom = nom;
        this.matricule = matricule;
    }

    public Integer getId() {
        return id;
    }

    public String getMateriel() {
        return materiel;
    }

    public String getNum_serie() {
        return num_serie;
    }

    public String getDeclaration() {
        return declaration;
    }

    public String getNom() {
        return nom;
    }

    public String getMatricule() {
        return matricule;
    }
    private Integer id;
    private String materiel;
    private String num_serie;
    private String declaration;
    private String nom;
    private String matricule;
    
}
