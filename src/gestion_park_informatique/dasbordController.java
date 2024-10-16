/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_park_informatique;

import java.io.IOException;
import java.net.URL;
import java.security.cert.PKIXRevocationChecker.Option;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author Miandry
 */
public class dasbordController implements Initializable {

    @FXML
    private Label username;

    @FXML
    private Button bt_acceuil;

    @FXML
    private Button bt_materiel;

    @FXML
    private Button bt_pane;

    @FXML
    private Button bt_suivie;

    @FXML
    private Button bt_deconnecter;

    @FXML
    private AnchorPane acceuil_panel;

    @FXML
    private Label acceil_ttotal_materie;

    @FXML
    private Label acceuil_total_pane;

    @FXML
    private Label acceuil_total_demmande;

    @FXML
    private AreaChart<?, ?> acceuil_carte;

    @FXML
    private AnchorPane materiel_form;

    @FXML
    private TextField materiel_id;

    @FXML
    private TextField materiel_marque;

    @FXML
    private TextField materiel_numserie;

    @FXML
    private TextField materiel_model;

    @FXML
    private TextField materiel_system;

    @FXML
    private ComboBox<?> materiel_status;

    @FXML
    private Button materiel_bt_ajouter;

    @FXML
    private Button materiel_bt_modifier;

    @FXML
    private Button materiel_bt_suprimer;

    @FXML
    private ComboBox<?> materiel_type;

    @FXML
    private TextField materiel_recherche;

    @FXML
    private TableView<materielData> materiel_table;

    @FXML
    private TableColumn<materielData, String> materiel_table_col_id;

    @FXML
    private TableColumn<materielData, String> materiel_table_col_type;

    @FXML
    private TableColumn<materielData, String> materiel_table_col_marque;

    @FXML
    private TableColumn<materielData, String> materiel_table_col_num;

    @FXML
    private TableColumn<materielData, String> materiel_table_col_model;

    @FXML
    private TableColumn<materielData, String> materiel_table_col_status;

    @FXML
    private TableColumn<materielData, String> materiel_table_col_system;

    @FXML
    private AnchorPane panne_panel;

    @FXML
    private TableView<panneData> table_panne;

    @FXML
    private TableColumn<panneData, String> table_panne_col_id;

    @FXML
    private TableColumn<panneData, String> table_panne_col_nom_materiel;

    @FXML
    private TableColumn<panneData, String> table_panne_col_numserie_materiel;

    @FXML
    private TableColumn<panneData, String> table_panne_col_declaration_materiel;

    @FXML
    private TableColumn<panneData, String> table_panne_col_nom;

    @FXML
    private TableColumn<panneData, String> table_panne_col_matricule;
@FXML
    private Label panne_id;

    @FXML
    private Label panne_materiel;

    @FXML
    private Label panne_serie;

    @FXML
    private Label panne_declaration;

    @FXML
    private Label panne_nom;

    @FXML
    private Label pannematricule;

    @FXML
    private TextField txt_recherche;
    
    @FXML
    private AnchorPane suivi_panel;
    
     @FXML
    private Label dmd_id;

    @FXML
    private Label dmd_type;

    @FXML
    private Label dmd_marque;

    @FXML
    private Label dmd_numserie;

    @FXML
    private Label dmd_model;

    @FXML
    private Label dmd_system;

    @FXML
    private Label dmd_nom;

    @FXML
    private Label dmd_matricule;

    @FXML
    private Label dmd_poste;

    @FXML
    private Label dmd_porte;

    @FXML
    private Label dmd_message;
    
    @FXML
    private Label acceuil_username;
    
    @FXML
    private TableView<demmadeData> demmande_table;

    @FXML
    private TableColumn<demmadeData, String> demmande_table_col_id;

    @FXML
    private TableColumn<demmadeData, String> demmande_table_col_type;

    @FXML
    private TableColumn<demmadeData, String> demmande_table_col_marque;

    @FXML
    private TableColumn<demmadeData, String> demmande_table_col_num_serie;

    @FXML
    private TableColumn<demmadeData, String> demmande_table_col_model;

    @FXML
    private TableColumn<demmadeData, String> demmande_table_col_system;

    @FXML
    private TableColumn<demmadeData, String> demmande_table_col_nom;

    @FXML
    private TableColumn<demmadeData, String> demmande_table_col_matricule;

    @FXML
    private TableColumn<demmadeData, String> demmande_table_col_poste;

    @FXML
    private TableColumn<demmadeData, String> demmande_table_col_porte;

    @FXML
    private TableColumn<demmadeData, String> demmande_table_col_message;


    @FXML
    private TextField recherche_dmd;


    // element de connection
    private Connection con;
    private PreparedStatement pst;
    private Statement st;
    private ResultSet rs;

    // combo box remplissage
    private String[] typeListe = {"Ordinateur bureau", "ordinateur portable", "imprimante", "scaner", "routeur", "serveur"};

    public void ajoutListeType() {
        List<String> listType = new ArrayList<>();

        for (String data : typeListe) {
            listType.add(data);
        }

        ObservableList listD = FXCollections.observableArrayList(listType);
        materiel_type.setItems(listD);
    }

    private String[] StatusListe = {"bien", "critaire", "en panne"};

    public void ajoutListeStatus() {
        List<String> listType = new ArrayList<>();

        for (String data : StatusListe) {
            listType.add(data);
        }

        ObservableList listD = FXCollections.observableArrayList(listType);
        materiel_status.setItems(listD);
    }

    //: ajoutmateriel dans la base de donne
    public void ajoutMaterielAdd() {

        String sql = "INSERT INTO materiel(id, type, marque, serie, model, status, system ) VALUES (?,?,?,?,?,?,?)";

        con = Database.connectdb();

        try {
            Alert alert;
            if (materiel_id.getText().isEmpty()
                    || materiel_type.getSelectionModel().getSelectedItem() == null
                    || materiel_marque.getText().isEmpty()
                    || materiel_model.getText().isEmpty()
                    || materiel_status.getSelectionModel().getSelectedItem() == null
                    || materiel_system.getText().isEmpty()) {

                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Message d'erreur");
                alert.setHeaderText(null);
                alert.setContentText("remplir les formulaire");
                alert.showAndWait();
            } else {

                String checkData = "SELECT id FROM materiel WHERE id = '"
                        + materiel_id.getText() + "'";

                st = con.createStatement();
                rs = st.executeQuery(checkData);

                if (rs.next()) {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Message d'erreur");
                    alert.setHeaderText(null);
                    alert.setContentText("ID : " + materiel_id.getText() + "  déja existe");
                    alert.showAndWait();
                } else {

                    pst = con.prepareStatement(sql);
                    pst.setString(1, materiel_id.getText());
                    pst.setString(2, (String) materiel_type.getSelectionModel().getSelectedItem());
                    pst.setString(3, materiel_marque.getText());
                    pst.setString(4, materiel_numserie.getText());
                    pst.setString(5, materiel_model.getText());
                    pst.setString(6, (String) materiel_status.getSelectionModel().getSelectedItem());
                    pst.setString(7, materiel_system.getText());

                    pst.executeUpdate();

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Message d'information");
                    alert.setHeaderText(null);
                    alert.setContentText("Ajout matériel avec succée");
                    alert.showAndWait();

                    ajoutMaterielTable();
                     actualiser();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // modifieer les donne
    public void modifierMateriel() {

        String sql = "UPDATE materiel SET type = '"
                + materiel_type.getSelectionModel().getSelectedItem() + "', marque = '"
                + materiel_marque.getText() + "', serie = '"
                + materiel_numserie.getText() + "', model = '"
                + materiel_model.getText() + "', status = '"
                + materiel_status.getSelectionModel().getSelectedItem() + "', system ='"
                + materiel_system.getText() + "' WHERE id = '"
                + materiel_id.getText() + "'";
        con = Database.connectdb();

        try {
            Alert alert;
            if (materiel_id.getText().isEmpty()
                    || materiel_type.getSelectionModel().getSelectedItem() == null
                    || materiel_marque.getText().isEmpty()
                    || materiel_model.getText().isEmpty()
                    || materiel_status.getSelectionModel().getSelectedItem() == null
                    || materiel_system.getText().isEmpty()) {

                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Message d'erreur");
                alert.setHeaderText(null);
                alert.setContentText("remplir les formulaire");
                alert.showAndWait();
            } else {
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Message de confirmation");
                alert.setHeaderText(null);
                alert.setContentText("Voulez vous vraiement modifier " + materiel_id.getText() + "???");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    st = con.createStatement();
                    st.executeUpdate(sql);

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Message d'information");
                    alert.setHeaderText(null);
                    alert.setContentText("Materiel modifier avec succée");
                    alert.showAndWait();

                    ajoutMaterielTable();
                    actualiser();
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void actualiser() {
        materiel_id.setText("");
        materiel_type.getSelectionModel().clearSelection();
        materiel_marque.setText("");
        materiel_model.setText("");
        materiel_system.setText("");
        materiel_status.getSelectionModel().clearSelection();
        materiel_numserie.setText("");
    }

    // supprimer 
    public void supprimerMateriel() {
        String sql = "DELETE  FROM materiel WHERE id= '" + materiel_id.getText() + "'";
        con = Database.connectdb();

        try {

            Alert alert;
            if (materiel_id.getText().isEmpty()
                   ) {

                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Message d'erreur");
                alert.setHeaderText(null);
                alert.setContentText("remplir les formulaire");
                alert.showAndWait();
            } else {
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Message de confirmation");
                alert.setHeaderText(null);
                alert.setContentText("Voulez vous vraiement supprimer " + materiel_id.getText() + "???");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    st = con.createStatement();
                    st.executeUpdate(sql);

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Message d'information");
                    alert.setHeaderText(null);
                    alert.setContentText("Materiel supprimer avec succée");
                    alert.showAndWait();

                    ajoutMaterielTable();
                    actualiser();
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // data d'un element ajouter
    public ObservableList<materielData> Ajoutmateriel() {
        ObservableList<materielData> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM materiel ";
        con = Database.connectdb();

        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            materielData matdata;

            while (rs.next()) {
                matdata = new materielData(rs.getInt("id"),
                        rs.getString("type"),
                        rs.getString("marque"),
                        rs.getString("serie"), 
                        rs.getString("model"), 
                        rs.getString("status"),
                        rs.getString("system"));

                listData.add(matdata);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return listData;
    }

    // ajout dans la table
    public ObservableList<materielData> ajoutTableMateriel;

    public void ajoutMaterielTable() {
        ajoutTableMateriel = Ajoutmateriel();

        materiel_table_col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        materiel_table_col_type.setCellValueFactory(new PropertyValueFactory<>("type"));
        materiel_table_col_marque.setCellValueFactory(new PropertyValueFactory<>("marque"));
        materiel_table_col_num.setCellValueFactory(new PropertyValueFactory<>("num_serie"));
        materiel_table_col_model.setCellValueFactory(new PropertyValueFactory<>("model"));
        materiel_table_col_status.setCellValueFactory(new PropertyValueFactory<>("status"));
        materiel_table_col_system.setCellValueFactory(new PropertyValueFactory<>("system"));

        materiel_table.setItems(ajoutTableMateriel);
    }

    // recherche dans la table
    public void rechercheTableMateriel() {
        FilteredList<materielData> filter = new FilteredList<>(ajoutTableMateriel, e -> true);
        materiel_recherche.textProperty().addListener((observable, oldValue, newValue) -> {

            filter.setPredicate(predicatematerielData -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String searchKey = newValue.toLowerCase();
                if (predicatematerielData.getId().toString().contains(searchKey)) {
                    return true;
                } else if (predicatematerielData.getType().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicatematerielData.getMarque().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicatematerielData.getNum_serie().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicatematerielData.getModel().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicatematerielData.getStatus().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicatematerielData.getSystem().toLowerCase().contains(searchKey)) {
                    return true;
                } else {
                    return false;
                }

            });
        });

        SortedList<materielData> sortList = new SortedList<>(filter);
        sortList.comparatorProperty().bind(materiel_table.comparatorProperty());
        materiel_table.setItems(sortList);
    }

    //:/ affichage Jpanel
    public void afficherMateriel() {

        materielData matdata = materiel_table.getSelectionModel().getSelectedItem();
        int select = materiel_table.getSelectionModel().getSelectedIndex();

        if ((select - 1) < -1) {
            return;
        }

        materiel_id.setText(String.valueOf(matdata.getId()));

        materiel_marque.setText(String.valueOf(matdata.getMarque()));
        materiel_numserie.setText(String.valueOf(matdata.getNum_serie()));
        materiel_model.setText(String.valueOf(matdata.getModel()));
        materiel_system.setText(String.valueOf(matdata.getSystem()));
        materiel_type.getSelectionModel().getSelectedIndex();
    }

    //panne
    
    
    // ajout dans la table panne
    public ObservableList<panneData> ajoutTablepanne;

    public void ajoutPanneTable() {
        ajoutTablepanne = Ajoutpanne();

        table_panne_col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        table_panne_col_nom_materiel.setCellValueFactory(new PropertyValueFactory<>("materiel"));
        table_panne_col_numserie_materiel.setCellValueFactory(new PropertyValueFactory<>("num_serie"));
        table_panne_col_declaration_materiel.setCellValueFactory(new PropertyValueFactory<>("declaration"));
        table_panne_col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        table_panne_col_matricule.setCellValueFactory(new PropertyValueFactory<>("matricule"));

        table_panne.setItems(ajoutTablepanne);
    }
    
       //:/ affichage Jpanel
    public void afficherPanne() {

        panneData pndata = table_panne.getSelectionModel().getSelectedItem();
        int select = table_panne.getSelectionModel().getSelectedIndex();

        if ((select - 1) < -1) {
            return;
        }

        panne_id.setText(String.valueOf(pndata.getId()));

        panne_materiel.setText(String.valueOf(pndata.getMateriel()));
        panne_serie.setText(String.valueOf(pndata.getNum_serie()));
        panne_declaration.setText(String.valueOf(pndata.getDeclaration()));
        panne_nom.setText(String.valueOf(pndata.getNom()));
        pannematricule.setText(String.valueOf(pndata.getMatricule()));
        
    }

    //// elemts de panne
    // data d'un element ajouter
    public ObservableList<panneData> Ajoutpanne() {
        ObservableList<panneData> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM panne ";
        con = Database.connectdb();

        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            panneData pndata;

            while (rs.next()) {
                pndata = new panneData(rs.getInt("id"),
                        rs.getString("materiel"),
                        rs.getString("serie"),
                        rs.getString("declaration"),
                        rs.getString("nom"),
                        rs.getString("matricule"));

                listData.add(pndata);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return listData;
    }
    
    public void acctualisetPanne(){
        panne_id.setText("");
        panne_materiel.setText("");
        panne_serie.setText("");
        panne_nom.setText("");
        pannematricule.setText("");
        panne_declaration.setText("");
    }
    
    // recherche table panne
        public void rechercheTablePAnne() {
        FilteredList<panneData> filter = new FilteredList<>(ajoutTablepanne, e -> true);
        txt_recherche.textProperty().addListener((observable, oldValue, newValue) -> {

            filter.setPredicate(predicatepanneData -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String searchKey = newValue.toLowerCase();
                if (predicatepanneData.getId().toString().contains(searchKey)) {
                    return true;
                } else if (predicatepanneData.getMateriel().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicatepanneData.getNum_serie().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicatepanneData.getDeclaration().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicatepanneData.getNom().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicatepanneData.getMatricule().toLowerCase().contains(searchKey)) {
                    return true;
                
                } else {
                    return false;
                }

            });
        });

        SortedList<panneData> sortList = new SortedList<>(filter);
        sortList.comparatorProperty().bind(table_panne.comparatorProperty());
        table_panne.setItems(sortList);
    }

    // demmande
    
    
    // data d'un element ajouterdemande
    public ObservableList<demmadeData> AjoutDemmande() {
        ObservableList<demmadeData> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM demmande ";
        con = Database.connectdb();

        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            demmadeData dmddata;

            while (rs.next()) {
                dmddata = new demmadeData(rs.getInt("id"),
                        rs.getString("type"),
                        rs.getString("marque"),
                        rs.getString("serie"),
                        rs.getString("model"),
                        rs.getString("system"),
                        rs.getString("nom"),
                        rs.getString("matricule"),
                        rs.getString("poste"),
                        rs.getString("porte"),
                        rs.getString("message"));

                listData.add(dmddata);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return listData;
    }
    
    // ajout dans la table demmande
    public ObservableList<demmadeData> ajoutTabledemmande;
    
     public void ajoutDemmandeTable() {
        ajoutTabledemmande = AjoutDemmande();

        demmande_table_col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        demmande_table_col_type.setCellValueFactory(new PropertyValueFactory<>("type"));
        demmande_table_col_marque.setCellValueFactory(new PropertyValueFactory<>("marque"));
        demmande_table_col_num_serie.setCellValueFactory(new PropertyValueFactory<>("num_serie"));
        demmande_table_col_model.setCellValueFactory(new PropertyValueFactory<>("model"));
        demmande_table_col_system.setCellValueFactory(new PropertyValueFactory<>("system"));

        demmande_table_col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        demmande_table_col_matricule.setCellValueFactory(new PropertyValueFactory<>("matricule"));
        demmande_table_col_poste.setCellValueFactory(new PropertyValueFactory<>("poste"));
        demmande_table_col_porte.setCellValueFactory(new PropertyValueFactory<>("porte"));
        demmande_table_col_message.setCellValueFactory(new PropertyValueFactory<>("message"));

        demmande_table.setItems(ajoutTabledemmande);
    }
     
         //:/ affichage Jpanel
    public void afficherDemmande() {

        demmadeData dmddata = demmande_table.getSelectionModel().getSelectedItem();
        int select = demmande_table.getSelectionModel().getSelectedIndex();

        if ((select - 1) < -1) {
            return;
        }

        dmd_id.setText(String.valueOf(dmddata .getId()));

        dmd_type.setText(String.valueOf(dmddata .getType()));
        dmd_marque.setText(String.valueOf(dmddata .getMarque()));
        dmd_numserie.setText(String.valueOf(dmddata .getNum_serie()));
        dmd_model.setText(String.valueOf(dmddata .getModel()));
        dmd_system.setText(String.valueOf(dmddata .getSystem()));
        dmd_nom.setText(String.valueOf(dmddata .getNom()));
        dmd_matricule.setText(String.valueOf(dmddata .getMatricule()));
        dmd_poste.setText(String.valueOf(dmddata .getPoste()));
        dmd_porte.setText(String.valueOf(dmddata .getPorte()));
        dmd_message.setText(String.valueOf(dmddata .getMessage()));
        
    }
    public void actualiserDemmande(){
        dmd_id.setText("");
        dmd_type.setText("");
        dmd_marque.setText("");
        dmd_numserie.setText("");
        dmd_model.setText("");
        dmd_system.setText("");
        dmd_nom.setText("");
        dmd_matricule.setText("");
        dmd_poste.setText("");
        dmd_porte.setText("");
        dmd_message.setText("");
        
        
    }
    
    // recherche table panne
        public void rechercheTableDemmande() {
        FilteredList<demmadeData> filter = new FilteredList<>(ajoutTabledemmande, e -> true);
        recherche_dmd.textProperty().addListener((observable, oldValue, newValue) -> {

            filter.setPredicate(predicatedemmadeData -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String searchKey = newValue.toLowerCase();
                if (predicatedemmadeData.getId().toString().contains(searchKey)) {
                    return true;
                } else if (predicatedemmadeData.getType().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicatedemmadeData.getMarque().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicatedemmadeData.getNum_serie().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicatedemmadeData.getModel().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicatedemmadeData.getSystem().toLowerCase().contains(searchKey)) {
                    return true;
                
                } else if (predicatedemmadeData.getNom().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicatedemmadeData.getMatricule().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicatedemmadeData.getPoste().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicatedemmadeData.getPorte().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicatedemmadeData.getMessage().toLowerCase().contains(searchKey)) {
                    return true;
                }else{
                    return false;
                }

            });
        });

        SortedList<demmadeData> sortList = new SortedList<>(filter);
        sortList.comparatorProperty().bind(demmande_table.comparatorProperty());
        demmande_table.setItems(sortList);
    }

    
    // compte a la page d'acceil
    public void totalMateriel_acceuil() {
        String sql = "SELECT COUNT(id) FROM materiel ";

        con = Database.connectdb();
        int countMat = 0;
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                countMat = rs.getInt("COUNT(id)");
            }
            acceil_ttotal_materie.setText(String.valueOf(countMat));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
      public void totalpanne_acceuil() {
        String sql = "SELECT COUNT(id) FROM panne ";

        con = Database.connectdb();
        int countPN = 0;
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                countPN = rs.getInt("COUNT(id)");
            }
            acceuil_total_pane.setText(String.valueOf(countPN));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
      
       public void totalDemmande_acceuil() {
        String sql = "SELECT COUNT(id) FROM demmande ";

        con = Database.connectdb();
        int countDm = 0;
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                countDm = rs.getInt("COUNT(id)");
            }
            acceuil_total_demmande.setText(String.valueOf(countDm));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
       
        public void displayUsername(){
         String user = getData.username;
         
         acceuil_username.setText(user.substring(0, 1).toUpperCase()+ user.substring(1));
    }

    //  menu dynamique
    public void switchForm(ActionEvent event) {

        if (event.getSource() == bt_acceuil) {
            acceuil_panel.setVisible(true);
            materiel_form.setVisible(false);
            panne_panel.setVisible(false);
            suivi_panel.setVisible(false);

            // mise en actif de bouton
            bt_acceuil.setStyle(" -fx-background-color:  #c5745b ");
            bt_materiel.setStyle(" -fx-background-color: transparent ");
            bt_pane.setStyle(" -fx-background-color: transparent ");
            bt_suivie.setStyle(" -fx-background-color: transparent ");
            totalMateriel_acceuil();
            totalDemmande_acceuil();
            totalpanne_acceuil();

        } else if (event.getSource() == bt_materiel) {
            acceuil_panel.setVisible(false);
            materiel_form.setVisible(true);
            panne_panel.setVisible(false);
            suivi_panel.setVisible(false);

            // mise en actif de bouton
            bt_acceuil.setStyle(" -fx-background-color:  transparent ");
            bt_materiel.setStyle(" -fx-background-color: #c5745b ");
            bt_pane.setStyle(" -fx-background-color: transparent ");
            bt_suivie.setStyle(" -fx-background-color: transparent ");

            ajoutMaterielTable();
            ajoutListeType();
            ajoutListeStatus();
            rechercheTableMateriel();
            actualiser();

        } else if (event.getSource() == bt_pane) {
            acceuil_panel.setVisible(false);
            materiel_form.setVisible(false);
            panne_panel.setVisible(true);
            suivi_panel.setVisible(false);
            ajoutPanneTable();
            acctualisetPanne();

            // mise en actif de bouton
            bt_acceuil.setStyle(" -fx-background-color:  transparent ");
            bt_materiel.setStyle(" -fx-background-color: transparent ");
            bt_pane.setStyle(" -fx-background-color: #c5745b ");
            bt_suivie.setStyle(" -fx-background-color: transparent ");

        } else if (event.getSource() == bt_suivie) {
            acceuil_panel.setVisible(false);
            materiel_form.setVisible(false);
            panne_panel.setVisible(false);
            suivi_panel.setVisible(true);

            ajoutDemmandeTable();
            actualiserDemmande();
            // mise en actif de bouton
            bt_acceuil.setStyle(" -fx-background-color: transparent  ");
            bt_materiel.setStyle(" -fx-background-color: transparent ");
            bt_pane.setStyle(" -fx-background-color: transparent ");
            bt_suivie.setStyle(" -fx-background-color: #c5745b ");
        }
    }

    public void deconnecter() {
        int option = JOptionPane.showConfirmDialog(null, "vouler vous se deconnecter ?", "deconnecter", JOptionPane.YES_NO_OPTION);

        if (option == 0) {
            try {
                bt_deconnecter.getScene().getWindow().hide();// pour fermer l'autre fenettre  et ouvrer une autre fenetre
                Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);

                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(dasbordController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ajoutMaterielTable();
        ajoutListeType();
        ajoutListeStatus();
        actualiser();
        totalMateriel_acceuil();
        totalDemmande_acceuil();
        totalpanne_acceuil();
        ajoutPanneTable();
        ajoutDemmandeTable();
        acctualisetPanne();
        actualiserDemmande();
        
        displayUsername();
    }

}
