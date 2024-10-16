/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_park_informatique;

import com.sun.javafx.scene.control.skin.Utils;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author Miandry
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private AnchorPane main_form;

    @FXML
    private Button bt_close;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Button bt_login;

    @FXML
    private ComboBox<?> login_poste;

    // element de connection
    private Connection con;
    private PreparedStatement pst;
    private ResultSet rs;

    // combo box remplissage
    private String[] PosteListe = {"Administrateur", "Technicien", "Utilisateur"};

    public void ajoutListePoste() {
        List<String> listType = new ArrayList<>();

        for (String data : PosteListe) {
            listType.add(data);
        }

        ObservableList listD = FXCollections.observableArrayList(listType);
        login_poste.setItems(listD);
    }

    public void adminLogin() {
        String sql = "SELECT * FROM utilisateur WHERE user = ? AND mdp = ? AND poste = ?";
        con = Database.connectdb();

        try {
            if (username.getText().isEmpty() || password.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "completer les formulaires");

            } else {
                pst = con.prepareStatement(sql);
                pst.setString(1, username.getText());
                pst.setString(2, password.getText());
                pst.setString(3, (String) login_poste.getSelectionModel().getSelectedItem());

                rs = pst.executeQuery();
                
           
                if (rs.next()) {

                    getData.username = username.getText();
                    // bouton vers               
                    bt_login.getScene().getWindow().hide();

                    // lien de connection
                    try {
                        Parent root = null;
                        if (login_poste.getSelectionModel().getSelectedItem().equals("Administrateur")) {
                            root = FXMLLoader.load(getClass().getResource("dasbord3.fxml"));
                        } else if (login_poste.getSelectionModel().getSelectedItem().equals("Technicien")) {
                            root = FXMLLoader.load(getClass().getResource("dasbord.fxml"));
                        } else if (login_poste.getSelectionModel().getSelectedItem().equals("Utilisateur")) {
                            root = FXMLLoader.load(getClass().getResource("dasbord2.fxml"));
                        }
                        Stage stage = new Stage();
                        Scene scene = new Scene(root);

                        stage.setScene(scene);
                        stage.show();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    // JOptionPane.showMessageDialog(null, "Connection établie");
                } else {
                    JOptionPane.showMessageDialog(null, "identifiant incorrect, verifier vos informations");

                }

            }
        } catch (Exception e) {
        }
    }

    public void close() {
        System.exit(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ajoutListePoste();
    }

}
