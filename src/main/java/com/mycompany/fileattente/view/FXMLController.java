package com.mycompany.fileattente.view;

import com.mycompany.fileattente.model.MM1;
import com.mycompany.fileattente.model.MM1K;
import com.mycompany.fileattente.model.MMS;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;

public class FXMLController implements Initializable {
    
    private MM1 fileMM1 = null;
    private MM1K fileMM1K = null;
    private MMS fileMMS = null;
    
    @FXML private TabPane tabPane_tabs;
    @FXML private Tab tab_type;
    @FXML private Tab tab_parametres;
    @FXML private Tab tab_resultats;
    // 1st tab
    @FXML private Label label_libeleChoix;
    @FXML private RadioButton radioButton_MM1;
    @FXML private RadioButton radioButton_MM1K;
    @FXML private RadioButton radioButton_MMS;
    @FXML private Button bouton_validerType;
    private String choix;
    // 2nd tab
    @FXML private Label label_choix;
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
    //3rd tab
    @FXML private Label label_L;
    @FXML private Label label_Lq;
    @FXML private Label label_W;
    @FXML private Label label_Wq;
    
    @FXML
    private void handleChoice1Action(ActionEvent event) {
        if (radioButton_MM1.isSelected()) {
            choix = "M|M|1";
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
            choix = "M|M|1|K";
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
            choix = "M|M|S";
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
    private void handleSubmitTypeAction(ActionEvent event) {
        label_choix.setText("Choix : " + choix);
        tab_parametres.setDisable(false);
        tabPane_tabs.getSelectionModel().select(tab_parametres);
            label_K.setVisible(true);
            textField_K.setVisible(true);
            label_S.setVisible(true);
            textField_S.setVisible(true);
        if ("M|M|1".equals(choix)) {
            label_K.setVisible(false);
            textField_K.setVisible(false);
            label_S.setVisible(false);
            textField_S.setVisible(false);
        }
        if ("M|M|1|K".equals(choix)) {
            label_S.setVisible(false);
            textField_S.setVisible(false);
        }
        if ("M|M|S".equals(choix)) {
            label_K.setVisible(false);
            textField_K.setVisible(false);
        }
    }
    
    @FXML
    private void handleMuAction(ActionEvent event) {
        if (!textField_K.isVisible() && !textField_S.isVisible()) {
            bouton_validerParametres.setDisable(false);
        }
    }
    
    @FXML
    private void handleKAction(ActionEvent event) {
        if (!textField_S.isVisible()) {
            bouton_validerParametres.setDisable(false);
        }
    }
    
    @FXML
    private void handleSAction(ActionEvent event) {
        if (!textField_K.isVisible()) {
            bouton_validerParametres.setDisable(false);
        }
    }
    
    @FXML
    private void handleSubmitParametresAction(ActionEvent event) {
        tab_resultats.setDisable(false);
        tabPane_tabs.getSelectionModel().select(tab_resultats);
        if ("M|M|1".equals(choix)) {
            fileMM1 = new MM1(Double.valueOf(textField_lambda.getText()), Double.valueOf(textField_mu.getText()));
            label_L.setText("L = " + String.valueOf(fileMM1.calculateL()));
            label_Lq.setText("Lq = " + String.valueOf(fileMM1.calculateLq()));
            label_W.setText("W = " + String.valueOf(fileMM1.calculateW()));
            label_Wq.setText("Wq = " + String.valueOf(fileMM1.calculateWq()));
        }
        if ("M|M|1|K".equals(choix)) {
            fileMM1K = new MM1K(Integer.valueOf(textField_K.getText()), Double.valueOf(textField_lambda.getText()), Double.valueOf(textField_mu.getText()));
            label_L.setText("L = " + String.valueOf(fileMM1K.calculateL()));
            label_Lq.setText("Lq = " + String.valueOf(fileMM1K.calculateLq()));
            label_W.setText("W = " + String.valueOf(fileMM1K.calculateW()));
            label_Wq.setText("Wq = " + String.valueOf(fileMM1K.calculateWq()));
        }
        if ("M|M|S".equals(choix)) {
            fileMMS = new MMS(Integer.valueOf(textField_S.getText()), Double.valueOf(textField_lambda.getText()), Double.valueOf(textField_mu.getText()));
            label_L.setText("L = " + String.valueOf(fileMMS.calculateL()));
            label_Lq.setText("Lq = " + String.valueOf(fileMMS.calculateLq()));
            label_W.setText("W = " + String.valueOf(fileMMS.calculateW()));
            label_Wq.setText("Wq = " + String.valueOf(fileMMS.calculateWq()));
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
}
