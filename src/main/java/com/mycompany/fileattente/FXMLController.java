package com.mycompany.fileattente;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class FXMLController implements Initializable {
    
    // 1st tab
    @FXML private Label label_libeleChoix;
    @FXML private RadioButton radioButton_MM1;
    @FXML private RadioButton radioButton_MM1K;
    @FXML private RadioButton radioButton_MMS;
    @FXML private Button bouton_validerType;
    @FXML private Label label_choix;
    private int choix;
    // 2nd tab
    @FXML private Label label_libeleParametres;
    @FXML private Label label_lambda;
    @FXML private TextField textField_lambda;
    @FXML private Label label_mu;
    @FXML private TextField textField_mu;
    @FXML private Label label_K;
    @FXML private TextField textField_K;
    @FXML private Label label_S;
    @FXML private TextField textField_S;
    @FXML private Button bouton_validerParametres;
    
    @FXML
    private void handleChoice1Action(ActionEvent event) {
        if (radioButton_MM1.isSelected()) {
            choix = 1;
            label_choix.setText("Choix : " + choix);
            radioButton_MM1K.setSelected(false);
            radioButton_MMS.setSelected(false);
            bouton_validerType.setDisable(false);
        } else {
            label_choix.setText("");
            bouton_validerType.setDisable(true);
        }
    }
    
    @FXML
    private void handleChoice2Action(ActionEvent event) {
        if (radioButton_MM1K.isSelected()) {
            choix = 2;
            label_choix.setText("Choix : " + choix);
            radioButton_MM1.setSelected(false);
            radioButton_MMS.setSelected(false);
            bouton_validerType.setDisable(false);
        } else {
            label_choix.setText("");
            bouton_validerType.setDisable(true);
        }
    }
    
    @FXML
    private void handleChoice3Action(ActionEvent event) {
        if (radioButton_MMS.isSelected()) {
            choix = 3;
            label_choix.setText("Choix : " + choix);
            radioButton_MM1.setSelected(false);
            radioButton_MM1K.setSelected(false);
            bouton_validerType.setDisable(false);
        } else {
            label_choix.setText("");
            bouton_validerType.setDisable(true);
        }
    }
    
    @FXML
    private void handleSubmitAction(ActionEvent event) {
        System.out.println("Choix : " + choix);
        label_choix.setText("Choix : " + choix);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
}
