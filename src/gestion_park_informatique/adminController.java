/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_park_informatique;

import java.io.File;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author Miandry
 */
public class adminController implements Initializable {

    @FXML
    private Button bt_deconnecter;

    @FXML
    private Button bt_utilisateur;

    @FXML
    private Button bt_materiel;

    @FXML
    private Button bt_panne;

    @FXML
    private Button bt_demmande;

    @FXML
    private Button bt_acceuil;

    @FXML
    private AnchorPane acceuil_pannel;

    @FXML
    private Label acceuil_total_utilisateur;

    @FXML
    private Label acceuil_total_materiel;

    @FXML
    private Label acceuil_total_panne;

    @FXML
    private Label acceuil_username;

    @FXML
    private AnchorPane maine_forme;

    @FXML
    private AnchorPane utilisateur_pannel;

    @FXML
    private TextField uitl_id;

    @FXML
    private TextField uitl_nom;

    @FXML
    private TextField util_mail;

    @FXML
    private TextField util_adresse;

    @FXML
    private TextField util_telephone;

    @FXML
    private TextField util_user;

    @FXML
    private TextField util_mdp;

    @FXML
    private ComboBox<?> util_poste;

    @FXML
    private ImageView photos;

    @FXML
    private Button bt_photos_util;

    @FXML
    private Button bt_ajouter_util;

    @FXML
    private Button bt_modifier_util;

    @FXML
    private Button bt_sepprimer_util;

    @FXML
    private TextField recherche_util;

    @FXML
    private TableView<adminData> table_utilisateur;

    @FXML
    private TableColumn<adminData, String> table_utilisateur_col_id;

    @FXML
    private TableColumn<adminData, String> table_utilisateur_col_nom;

    @FXML
    private TableColumn<adminData, String> table_utilisateur_col_email;

    @FXML
    private TableColumn<adminData, String> table_utilisateur_col_adresse;

    @FXML
    private TableColumn<adminData, String> table_utilisateur_col_telephone;

    @FXML
    private TableColumn<adminData, String> table_utilisateur_col_user;

    @FXML
    private TableColumn<adminData, String> table_utilisateur_col_mdp;

    @FXML
    private TableColumn<adminData, String> table_utilisateur_col_poste;
    
    @FXML
    private TableColumn<adminData, String> table_utilisateur_col_photos;

    @FXML
    private AnchorPane materiel_pannel;

    @FXML
    private TextField recherche_materiel;

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
    private AnchorPane panne_pannel;

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
    private TextField recherche_panne;

    @FXML
    private AnchorPane demmande_pannel;

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
    private TextField recherche_demmande;
// element de connection
    private Connection con;
    private PreparedStatement pst;
    private Statement st;
    private ResultSet rs;

    private Image image;

    // combo box remplissage
    private String[] PosteListe = {"Administrateur", "Technicien", "Utilisateur"};

    public void ajoutListePoste() {
        List<String> listType = new ArrayList<>();

        for (String data : PosteListe) {
            listType.add(data);
        }

        ObservableList listD = FXCollections.observableArrayList(listType);
        util_poste.setItems(listD);
    }

    // importation image
    public void importerPhotos() {
        FileChooser openFile = new FileChooser();
        openFile.getExtensionFilters().add(new FileChooser.ExtensionFilter("open Image File", " *png", " *jpg"));
        File file = openFile.showOpenDialog(maine_forme.getScene().getWindow());
        if (file != null) {
            getData.path = file.getAbsolutePath();
            image = new Image(file.toURI().toString(), 160, 170, false, true);

            photos.setImage(image);
        }
    }

    //: ajoutmateriel dans la base de donne
    public void ajoutUtilisateurAdd() {

        String sql = "INSERT INTO utilisateur(id, nom, email, adresse, telephone, user, mdp, poste, photos) VALUES (?,?,?,?,?,?,?,?,?)";

        con = Database.connectdb();

        try {
            Alert alert;
            if (uitl_id.getText().isEmpty()
                    || uitl_nom.getText().isEmpty()
                    || util_user.getText().isEmpty()
                    || util_mdp.getText().isEmpty()) {

                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Message d'erreur");
                alert.setHeaderText(null);
                alert.setContentText("remplir les formulaire");
                alert.showAndWait();
            } else {

                String checkData = "SELECT id FROM utilisateur WHERE id = '"
                        + uitl_id.getText() + "'";

                st = con.createStatement();
                rs = st.executeQuery(checkData);

                if (rs.next()) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Message d'erreur");
                    alert.setHeaderText(null);
                    alert.setContentText("ID : " + uitl_id.getText() + "  déja existe");
                    alert.showAndWait();
                } else {

                    pst = con.prepareStatement(sql);
                    pst.setString(1, uitl_id.getText());

                    pst.setString(2, uitl_nom.getText());
                    pst.setString(3, util_mail.getText());
                    pst.setString(4, util_adresse.getText());

                    pst.setString(5, util_telephone.getText());
                    pst.setString(6, util_user.getText());
                    pst.setString(7, util_mdp.getText());
                    pst.setString(8, (String) util_poste.getSelectionModel().getSelectedItem());

                    String uri = getData.path;
                    uri = uri.replace("\\", "\\\\");

                    pst.setString(9, uri);

                    pst.executeUpdate();

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Message d'information");
                    alert.setHeaderText(null);
                    alert.setContentText("Ajout UTILISATEUR avec succée");
                    alert.showAndWait();

                    ajoutUtilisateurTable();

                    uitl_id.setText("");
                    uitl_nom.setText("");
                    util_mail.setText("");
                    util_adresse.setText("");
                    util_telephone.setText("");
                    util_user.setText("");
                    util_mdp.setText("");
                    util_poste.getSelectionModel().clearSelection();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // modifieer les utilisateur
    public void modifierUtilisateur() {

        String sql = "UPDATE utilisateur SET nom = '"
                + uitl_nom.getText() + "', email = '"
                + util_mail.getText() + "', adresse = '"
                + util_adresse.getText() + "', telephone = '"
                + util_telephone.getText() + "', user = '"
                + util_user.getText() + "', mdp = '"
                + util_mdp.getText() + "', poste = '"
                + util_poste.getSelectionModel().getSelectedItem() + "', photos = '"
                +photos.getImage()+"' WHERE id = '"
                + uitl_id.getText() + "'";
        con = Database.connectdb();

        try {
            Alert alert;
            if (uitl_id.getText().isEmpty()
                    || uitl_nom.getText().isEmpty()
                    || util_user.getText().isEmpty()
                    || util_poste.getSelectionModel().getSelectedItem() == null
                    || util_mdp.getText().isEmpty()) {

                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Message d'erreur");
                alert.setHeaderText(null);
                alert.setContentText("remplir les formulaire");
                alert.showAndWait();
            } else {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Message de confirmation");
                alert.setHeaderText(null);
                alert.setContentText("Voulez vous vraiement modifier " + uitl_id.getText() + "???");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    st = con.createStatement();
                    st.executeUpdate(sql);

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Message d'information");
                    alert.setHeaderText(null);
                    alert.setContentText("Utilisateur modifier avec succée");
                    alert.showAndWait();

                    ajoutUtilisateurTable();

                    uitl_id.setText("");
                    uitl_nom.setText("");
                    util_mail.setText("");
                    util_adresse.setText("");
                    util_telephone.setText("");
                    util_user.setText("");
                    util_mdp.setText("");
                    util_poste.getSelectionModel().clearSelection();
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // data d'un element ajouter utilisateur
    public ObservableList<adminData> AjoutUtilisateur() {
        ObservableList<adminData> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM utilisateur ";
        con = Database.connectdb();

        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            adminData admdata;

            while (rs.next()) {
                admdata = new adminData(rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("email"),
                        rs.getString("adresse"),
                        rs.getString("telephone"),
                        rs.getString("user"),
                        rs.getString("mdp"),
                        rs.getString("poste"),
                        rs.getString("photos")
                );

                listData.add(admdata);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return listData;
    }
    // ajout dans la table
    public ObservableList<adminData> ajoutTableUtilisateur;

    public void ajoutUtilisateurTable() {
        ajoutTableUtilisateur = AjoutUtilisateur();

        table_utilisateur_col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        table_utilisateur_col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        table_utilisateur_col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        table_utilisateur_col_adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        table_utilisateur_col_telephone.setCellValueFactory(new PropertyValueFactory<>("telephone"));
        table_utilisateur_col_user.setCellValueFactory(new PropertyValueFactory<>("user"));
        table_utilisateur_col_mdp.setCellValueFactory(new PropertyValueFactory<>("mdp"));
        table_utilisateur_col_poste.setCellValueFactory(new PropertyValueFactory<>("poste"));
        table_utilisateur_col_photos.setCellValueFactory(new PropertyValueFactory<>("photos"));
        table_utilisateur.setItems(ajoutTableUtilisateur);
    }

    // recherche table mutilisateur
    public void rechercheTableUtilisateur() {
        FilteredList<adminData> filter = new FilteredList<>(ajoutTableUtilisateur, e -> true);
        recherche_util.textProperty().addListener((observable, oldValue, newValue) -> {

            filter.setPredicate(predicateadminData -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String searchKey = newValue.toLowerCase();
                if (predicateadminData.getId().toString().contains(searchKey)) {
                    return true;
                } else if (predicateadminData.getNom().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateadminData.getAdresse().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateadminData.getUser().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateadminData.getPoste().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateadminData.getTelephone().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateadminData.getEmail().toLowerCase().contains(searchKey)) {
                    return true;
                } else {
                    return false;
                }

            });
        });

        SortedList<adminData> sortList = new SortedList<>(filter);
        sortList.comparatorProperty().bind(table_utilisateur.comparatorProperty());
        table_utilisateur.setItems(sortList);
    }

    //:/ affichage Jpanel
    public void afficherUtilisateur() {

        adminData admdata = table_utilisateur.getSelectionModel().getSelectedItem();
        int select = table_utilisateur.getSelectionModel().getSelectedIndex();

        if ((select - 1) < -1) {
            return;
        }

        uitl_id.setText(String.valueOf(admdata.getId()));

        uitl_nom.setText(String.valueOf(admdata.getNom()));
        util_mail.setText(String.valueOf(admdata.getEmail()));
        util_adresse.setText(String.valueOf(admdata.getAdresse()));
        util_telephone.setText(String.valueOf(admdata.getTelephone()));
        util_user.setText(String.valueOf(admdata.getUser()));
        util_mdp.setText(String.valueOf(admdata.getMdp()));

    }

    // materiel
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
                matdata = new materielData(rs.getInt("id"), rs.getString("type"), rs.getString("marque"), rs.getString("serie"), rs.getString("model"), rs.getString("status"), rs.getString("system"));

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
        recherche_materiel.textProperty().addListener((observable, oldValue, newValue) -> {

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

    // recherche table panne
    public void rechercheTableDemmande() {
        FilteredList<demmadeData> filter = new FilteredList<>(ajoutTabledemmande, e -> true);
        recherche_demmande.textProperty().addListener((observable, oldValue, newValue) -> {

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
                } else {
                    return false;
                }

            });
        });

        SortedList<demmadeData> sortList = new SortedList<>(filter);
        sortList.comparatorProperty().bind(demmande_table.comparatorProperty());
        demmande_table.setItems(sortList);
    }

    // panne
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

    // recherche table panne
    public void rechercheTablePAnne() {
        FilteredList<panneData> filter = new FilteredList<>(ajoutTablepanne, e -> true);
        recherche_panne.textProperty().addListener((observable, oldValue, newValue) -> {

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

    // compte a la page d'acceil
    public void totalUtilisateur_acceuil() {
        String sql = "SELECT COUNT(id) FROM utilisateur ";

        con = Database.connectdb();
        int countMat = 0;
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                countMat = rs.getInt("COUNT(id)");
            }
            acceuil_total_utilisateur.setText(String.valueOf(countMat));
        } catch (Exception e) {
            e.printStackTrace();
        }
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
            acceuil_total_materiel.setText(String.valueOf(countMat));
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
            acceuil_total_panne.setText(String.valueOf(countPN));
        } catch (Exception e) {
            e.printStackTrace();
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

    public void displayUsername() {
        String user = getData.username;

        acceuil_username.setText(user.substring(0, 1).toUpperCase() + user.substring(1));
    }

    //  menu dynamique
    public void switchForm(ActionEvent event) {

        if (event.getSource() == bt_acceuil) {
            acceuil_pannel.setVisible(true);
            utilisateur_pannel.setVisible(false);
            materiel_pannel.setVisible(false);
            panne_pannel.setVisible(false);
            demmande_pannel.setVisible(false);
            totalMateriel_acceuil();
            totalpanne_acceuil();
            totalUtilisateur_acceuil();

            // mise en actif de bouton
            bt_acceuil.setStyle(" -fx-background-color: #c5745b  ");
            bt_utilisateur.setStyle(" -fx-background-color: transparent ");
            bt_materiel.setStyle(" -fx-background-color: transparent ");
            bt_demmande.setStyle(" -fx-background-color: transparent ");
            bt_panne.setStyle(" -fx-background-color: transparent ");
        } else if (event.getSource() == bt_utilisateur) {
            acceuil_pannel.setVisible(false);
            utilisateur_pannel.setVisible(true);
            materiel_pannel.setVisible(false);
            panne_pannel.setVisible(false);
            demmande_pannel.setVisible(false);

            ajoutUtilisateurTable();
            ajoutListePoste();

            // mise en actif de bouton
            bt_acceuil.setStyle(" -fx-background-color: transparent  ");
            bt_utilisateur.setStyle(" -fx-background-color: #c5745b ");
            bt_materiel.setStyle(" -fx-background-color: transparent ");
            bt_demmande.setStyle(" -fx-background-color: transparent ");
            bt_panne.setStyle(" -fx-background-color: transparent ");
        } else if (event.getSource() == bt_materiel) {
            acceuil_pannel.setVisible(false);
            utilisateur_pannel.setVisible(false);
            materiel_pannel.setVisible(true);
            panne_pannel.setVisible(false);
            demmande_pannel.setVisible(false);

            ajoutMaterielTable();

            bt_acceuil.setStyle(" -fx-background-color: transparent  ");
            bt_utilisateur.setStyle(" -fx-background-color: transparent ");
            bt_materiel.setStyle(" -fx-background-color: #c5745b  ");
            bt_demmande.setStyle(" -fx-background-color: transparent ");
            bt_panne.setStyle(" -fx-background-color: transparent ");
        } else if (event.getSource() == bt_panne) {
            acceuil_pannel.setVisible(false);
            utilisateur_pannel.setVisible(false);
            materiel_pannel.setVisible(false);
            panne_pannel.setVisible(true);
            demmande_pannel.setVisible(false);

            ajoutPanneTable();

            // mise en actif de bouton
            bt_acceuil.setStyle(" -fx-background-color: transparent  ");
            bt_utilisateur.setStyle(" -fx-background-color: transparent ");
            bt_materiel.setStyle(" -fx-background-color: transparent ");
            bt_demmande.setStyle(" -fx-background-color: transparent ");
            bt_panne.setStyle(" -fx-background-color: #c5745b ");
        } else if (event.getSource() == bt_demmande) {
            acceuil_pannel.setVisible(false);
            utilisateur_pannel.setVisible(false);
            materiel_pannel.setVisible(false);
            panne_pannel.setVisible(false);
            demmande_pannel.setVisible(true);
            ajoutDemmandeTable();

            // mise en actif de bouton
            bt_acceuil.setStyle(" -fx-background-color: transparent  ");
            bt_utilisateur.setStyle(" -fx-background-color: transparent ");
            bt_materiel.setStyle(" -fx-background-color: transparent ");
            bt_demmande.setStyle(" -fx-background-color:  #c5745b ");
            bt_panne.setStyle(" -fx-background-color:transparent ");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ajoutUtilisateurTable();
        ajoutListePoste();
        ajoutMaterielTable();
        ajoutDemmandeTable();
        ajoutPanneTable();

        totalMateriel_acceuil();
        totalpanne_acceuil();
        totalUtilisateur_acceuil();

        displayUsername();
    }

}
