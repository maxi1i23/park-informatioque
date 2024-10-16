/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_park_informatique;

import com.sun.glass.events.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.ConditionalFeature.FXML;
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
public class utilisateurController implements Initializable {

    @FXML
    private AnchorPane acceuil_pannel;

    @FXML
    private AnchorPane demmande_pannel;

    @FXML
    private Button bt_acceuil;

    @FXML
    private Button bt_demmande;

    @FXML
    private Button bt_panne;

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
    private TextField materiel_recherche;

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
    private Button bt_envoyer_panne;
    @FXML
    private TextField panne_id;

    @FXML
    private TextField panne_materiel;

    @FXML
    private TextField panne_serie;

    @FXML
    private TextField panne_declaration;

    @FXML
    private TextField panne_nom;

    @FXML
    private TextField panne_matricule;

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
    private Label materiel_id;

    @FXML
    private Label materiel_type;

    @FXML
    private Label materiel_marque;

    @FXML
    private Label materiel_numserie;

    @FXML
    private Label materiel_model;

    @FXML
    private Label materiel_system;

     @FXML
    private Label acceuil_username;
    
    @FXML
    private Label acceil_ttotal_materie;

    @FXML
    private TextField dmd_nom;

    @FXML
    private TextField dmd_matricule;

    @FXML
    private TextField dmd_porte;

    @FXML
    private ComboBox<?> dmd_poste;

    @FXML
    private Button dmd_bt_actualiser;

    @FXML
    private Button dmd_bt_lancer;

    @FXML
    private Button bt_deconnecter;

    @FXML
    private TextField dmd_message;

    @FXML
    private AnchorPane panne_pannel;

    @FXML
    private Label acceuil_total_pane;

    @FXML
    private Label acceuil_total_demmande;

    @FXML
    void afficherMateriel(MouseEvent event) {

    }

    @FXML
    void rechercheTableMateriel(KeyEvent event) {

    }

    // element de connection
    private Connection con;
    private PreparedStatement pst;
    private Statement st;
    private ResultSet rs;

    // combo box remplissage
    private String[] PosteListe = {"Administrateur", "Technicien", "Utilisateur"};

    public void ajoutListePoste() {
        List<String> listType = new ArrayList<>();

        for (String data : PosteListe) {
            listType.add(data);
        }

        ObservableList listD = FXCollections.observableArrayList(listType);
        dmd_poste.setItems(listD);
    }

    //: ajoutmateriel dans la base de donne
    public void ajoutDemmandeAdd() {

        String sql = "INSERT INTO demmande(id, type, marque, serie, model, system, nom, matricule, poste, porte, message ) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

        con = Database.connectdb();

        try {
            Alert alert;
            if (materiel_id.getText().isEmpty()
                    || materiel_type.getText().isEmpty()
                    || dmd_nom.getText().isEmpty()
                    || dmd_matricule.getText().isEmpty()
                    || dmd_porte.getText().isEmpty()
                    || dmd_poste.getSelectionModel().getSelectedItem() == null
                    || dmd_message.getText().isEmpty()) {

                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Message d'erreur");
                alert.setHeaderText(null);
                alert.setContentText("remplir les formulaire");
                alert.showAndWait();
            } else {

                String checkData = "SELECT id FROM demmande WHERE id = '"
                        + materiel_id.getText() + "'";

                st = con.createStatement();
                rs = st.executeQuery(checkData);

                if (rs.next()) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Message d'erreur");
                    alert.setHeaderText(null);
                    alert.setContentText("ID : " + materiel_id.getText() + "  déja existe");
                    alert.showAndWait();
                } else {

                    pst = con.prepareStatement(sql);
                    pst.setString(1, materiel_id.getText());
                    pst.setString(2, materiel_type.getText());
                    pst.setString(3, materiel_marque.getText());
                    pst.setString(4, materiel_numserie.getText());
                    pst.setString(5, materiel_model.getText());
                    pst.setString(6, materiel_system.getText());

                    pst.setString(7, dmd_nom.getText());
                    pst.setString(8, dmd_matricule.getText());

                    pst.setString(9, (String) dmd_poste.getSelectionModel().getSelectedItem());
                    pst.setString(10, dmd_porte.getText());
                    pst.setString(11, dmd_message.getText());
                    pst.executeUpdate();

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Message d'information");
                    alert.setHeaderText(null);
                    alert.setContentText("Ajout demmande avec succée");
                    alert.showAndWait();

                    ajoutDemmandeTable();
                    actualiserdemmande();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

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

    public void actualiserdemmande() {
        materiel_id.setText("");
        materiel_type.setText("");
        materiel_marque.setText("");
        materiel_model.setText("");
        materiel_system.setText("");
        materiel_numserie.setText("");
        dmd_nom.setText("");
        dmd_matricule.setText("");
        dmd_porte.setText("");
        dmd_message.setText("");
        dmd_poste.getSelectionModel().clearSelection();
    }

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

    //: ajoutmateriel dans la base de donne
    public void ajoutPanneAdd() {

        String sql = "INSERT INTO panne(id, materiel, serie, declaration, nom, matricule) VALUES (?,?,?,?,?,?)";

        con = Database.connectdb();

        try {
            Alert alert;
            if (panne_id.getText().isEmpty()
                    || panne_materiel.getText().isEmpty()
                    || panne_serie.getText().isEmpty()
                    || panne_nom.getText().isEmpty()) {

                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Message d'erreur");
                alert.setHeaderText(null);
                alert.setContentText("remplir les formulaire");
                alert.showAndWait();
            } else {

                String checkData = "SELECT id FROM panne WHERE id = '"
                        + panne_id.getText() + "'";

                st = con.createStatement();
                rs = st.executeQuery(checkData);

                if (rs.next()) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Message d'erreur");
                    alert.setHeaderText(null);
                    alert.setContentText("ID : " + panne_id.getText() + "  déja existe");
                    alert.showAndWait();
                } else {

                    pst = con.prepareStatement(sql);
                    pst.setString(1, panne_id.getText());

                    pst.setString(2, panne_materiel.getText());
                    pst.setString(3, panne_serie.getText());
                    pst.setString(4, panne_declaration.getText());

                    pst.setString(5, panne_nom.getText());
                    pst.setString(6, panne_matricule.getText());
                    pst.executeUpdate();

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Message d'information");
                    alert.setHeaderText(null);
                    alert.setContentText("Ajout PANNE avec succée");
                    alert.showAndWait();

                    ajoutPanneTable();

                    panne_id.setText("");
                    panne_materiel.setText("");
                    panne_serie.setText("");
                    panne_declaration.setText("");
                    panne_nom.setText("");
                    panne_matricule.setText("");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

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

    // data d'un element materiel
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
        materiel_type.setText(String.valueOf(matdata.getType()));
    }

    // recherche table maeriel
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
            acceuil_pannel.setVisible(true);
            demmande_pannel.setVisible(false);
            panne_pannel.setVisible(false);

            totalMateriel_acceuil();
            totalpanne_acceuil();
            totalDemmande_acceuil();

            // mise en actif de bouton
            bt_acceuil.setStyle(" -fx-background-color: #c5745b  ");

            bt_demmande.setStyle(" -fx-background-color: transparent ");
            bt_panne.setStyle(" -fx-background-color: transparent ");

        } else if (event.getSource() == bt_demmande) {
            acceuil_pannel.setVisible(false);
            demmande_pannel.setVisible(true);
            panne_pannel.setVisible(false);

            ajoutDemmandeTable();
            actualiserdemmande();

            // mise en actif de bouton
            bt_acceuil.setStyle(" -fx-background-color: transparent ");

            bt_demmande.setStyle(" -fx-background-color: #c5745b  ");
            bt_panne.setStyle(" -fx-background-color: transparent ");
        } else if (event.getSource() == bt_panne) {
            acceuil_pannel.setVisible(false);
            demmande_pannel.setVisible(false);
            panne_pannel.setVisible(true);

            bt_acceuil.setStyle(" -fx-background-color: transparent ");

            bt_demmande.setStyle(" -fx-background-color: transparent ");
            bt_panne.setStyle(" -fx-background-color: #c5745b  ");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ajoutListePoste();
        ajoutMaterielTable();
        ajoutDemmandeTable();
        ajoutDemmandeTable();
        actualiserdemmande();
        totalMateriel_acceuil();
        totalpanne_acceuil();
        totalDemmande_acceuil();
        
        displayUsername();

    }

}
