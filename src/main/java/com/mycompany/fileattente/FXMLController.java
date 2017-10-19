package com.mycompany.fileattente;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

public class FXMLController implements Initializable {
    
    @FXML
    private Label label_libeleChoix;
    @FXML
    private RadioButton radioButton_MM1;
    @FXML
    private RadioButton radioButton_MM1K;
    @FXML
    private RadioButton radioButton_MMS;
    @FXML
    private Button bouton_validerType;
    @FXML
    private Label label_choix;
    
    @FXML
    private void handleChoice1Action(ActionEvent event) {
        if (radioButton_MM1.isSelected()) {
            label_choix.setText("Choix : 1");
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
            label_choix.setText("Choix : 2");
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
            label_choix.setText("Choix : 3");
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
        System.out.println("Choix : ");
        label_choix.setText("Choix : ");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
}
