package com.mycompany.fileattente.view;

import com.mycompany.fileattente.model.MM1;
import com.mycompany.fileattente.model.MM1K;
import com.mycompany.fileattente.model.MMS;
import java.net.URL;
import java.text.DecimalFormat;
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
    private DecimalFormat df2 = new DecimalFormat("0.00");
    private DecimalFormat df4 = new DecimalFormat("0.0000");
    
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
    @FXML private Label label_rhoIncorrect;
    //3rd tab
    @FXML private Label label_ResumeFile;
    @FXML private Label label_L;
    @FXML private Label label_Lq;
    @FXML private Label label_W;
    @FXML private Label label_Wq;
    @FXML private Label label_tempsSejour;
    @FXML private Label label_tempsFile;
    @FXML private TextField textField_t;
    @FXML private Label label_tIncorrect;
    @FXML private Label label_Qi;
    @FXML private TextField textField_i;
    @FXML private Label label_iIncorrect;
    
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
        label_rhoIncorrect.setVisible(false);
        label_choix.setText("Choix : " + choix);
        tab_parametres.setDisable(false);
        tabPane_tabs.getSelectionModel().select(tab_parametres);
        label_K.setVisible(true);
        textField_K.setVisible(true);
        label_S.setVisible(true);
        textField_S.setVisible(true);
        label_L.setText("L = ");
        label_Lq.setText("Lq = ");
        label_W.setText("W = ");
        label_Wq.setText("Wq = ");
        textField_lambda.setText("");
        textField_mu.setText("");
        textField_K.setText("");
        textField_S.setText("");
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

        boolean valueError = false;

        try {
            if (textField_lambda.getText().isEmpty() || Double.valueOf(textField_lambda.getText()) <= 0) {
                valueError = true;
                label_rhoIncorrect.setVisible(true);
                label_rhoIncorrect.setText("Valeur de λ incorrecte");
            }
        }
        catch(NumberFormatException e){
            valueError = true;
            label_rhoIncorrect.setVisible(true);
            label_rhoIncorrect.setText("Format de λ incorrect");
        }

        try {
            if (textField_mu.getText().isEmpty() || Double.valueOf(textField_mu.getText()) <= 0) {
                valueError = true;
                label_rhoIncorrect.setVisible(true);
                label_rhoIncorrect.setText("Valeur de μ incorrecte");
            }
        }
        catch(NumberFormatException e){
            valueError = true;
            label_rhoIncorrect.setVisible(true);
            label_rhoIncorrect.setText("Format de μ incorrect");
        }

        try {
            if ("M|M|S".equals(choix) && (textField_S.getText().isEmpty() || Double.valueOf(textField_S.getText()) < 1)) {
                valueError = true;
                label_rhoIncorrect.setVisible(true);
                label_rhoIncorrect.setText("Valeur de S incorrecte");
            }
        }catch(NumberFormatException e){
            valueError = true;
            label_rhoIncorrect.setVisible(true);
            label_rhoIncorrect.setText("Format de S incorrect");
        }

        try {
            if ("M|M|1|K".equals(choix) && (textField_K.getText().isEmpty() || Double.valueOf(textField_K.getText()) < 1)) {
                valueError = true;
                label_rhoIncorrect.setVisible(true);
                label_rhoIncorrect.setText("Valeur de K incorrecte");
            }
        }
        catch(NumberFormatException e){
            valueError = true;
            label_rhoIncorrect.setVisible(true);
            label_rhoIncorrect.setText("Format de K incorrect");
        }


        if (valueError == false){
            double rho;
            if (!"M|M|S".equals(choix)) {
                rho = Double.valueOf(textField_lambda.getText()) / Double.valueOf(textField_mu.getText());
            } else {
                rho = Double.valueOf(textField_lambda.getText()) / (Double.valueOf(textField_mu.getText()) * Integer.valueOf(textField_S.getText()));
            }
            if (("M|M|1|K".equals(choix) && rho > 1) || (!"M|M|1|K".equals(choix) && rho >= 1)) {
                label_rhoIncorrect.setVisible(true);
                if ("M|M|1".equals(choix) && rho >= 1){
                    label_rhoIncorrect.setText("Cas M|M|1 : ϱ doit être inférieur à 1 ! \nVeuiller vous assurer que λ soit inférieur à μ.");
                }
                if ("M|M|S".equals(choix) && rho >= 1){
                    label_rhoIncorrect.setText("Cas M|M|S : ϱ doit être inférieur à 1 ! \nVeuiller vous assurer que λ soit inférieur à S x μ.");
                }
                if ("M|M|1|K".equals(choix) && rho >= 1){
                    label_rhoIncorrect.setText("Cas M|M|1|K : ϱ doit être inférieur ou égal à 1 ! \nVeuiller vous assurer que λ soit inférieur ou égal à μ.");
                }
            } else {
                label_rhoIncorrect.setVisible(false);
                tab_resultats.setDisable(false);
                tabPane_tabs.getSelectionModel().select(tab_resultats);
                if ("M|M|1".equals(choix)) {
                    label_ResumeFile.setText("File M|M|1 (λ=" + textField_lambda.getText() + ", μ=" + textField_mu.getText() + ", ϱ=" + df2.format(rho) + ")");
                    fileMM1 = new MM1(Double.valueOf(textField_lambda.getText()), Double.valueOf(textField_mu.getText()));
                    label_L.setText("Nombre moyen de clients dans le système L : " + df2.format(fileMM1.calculateL()));
                    label_Lq.setText("Nombre moyen de clients dans la file Lq : " + df2.format(fileMM1.calculateLq()));
                    label_W.setText("Durée moyenne d'attente dans le système W : " + df2.format(fileMM1.calculateW()));
                    label_Wq.setText("Durée moyenne d'attente dans la file Wq : " + df2.format(fileMM1.calculateWq()));
                    label_tempsFile.setVisible(true);
                    label_tempsSejour.setText("Temps de séjour dans le système P(T>t) :");
                    label_tempsFile.setText("Temps de séjour dans la file P(Tq>t) :");
                    label_tIncorrect.setVisible(false);
                    label_iIncorrect.setVisible(false);
                }
                if ("M|M|1|K".equals(choix)) {
                    label_ResumeFile.setText("File M|M|1|" + textField_K.getText() + " (λ=" + textField_lambda.getText() + ", μ=" + textField_mu.getText() + ", ϱ=" + df2.format(rho) + ")");
                    fileMM1K = new MM1K(Integer.valueOf(textField_K.getText()), Double.valueOf(textField_lambda.getText()), Double.valueOf(textField_mu.getText()));
                    label_L.setText("Nombre moyen de clients dans le système L : " + df2.format(fileMM1K.calculateL()));
                    label_Lq.setText("Nombre moyen de clients dans la file Lq : " + df2.format(fileMM1K.calculateLq()));
                    label_W.setText("La durée moyenne d'attente dans le système W est indisponible");
                    label_Wq.setText("La durée moyenne d'attente dans la file Wq est indisponible");
                    label_tempsFile.setVisible(false);
                    label_tempsSejour.setText("Temps de séjour dans le système P(T>t) :");
                    label_tIncorrect.setVisible(false);
                    label_iIncorrect.setVisible(false);
                }
                if ("M|M|S".equals(choix)) {
                    label_ResumeFile.setText("File M|M|" + textField_S.getText() + " (λ=" + textField_lambda.getText() + ", μ=" + textField_mu.getText() + ", ϱ=" + df2.format(rho) + ")");
                    fileMMS = new MMS(Integer.valueOf(textField_S.getText()), Double.valueOf(textField_lambda.getText()), Double.valueOf(textField_mu.getText()));
                    label_L.setText("Nombre moyen de clients dans le système L : " + df2.format(fileMMS.calculateL()));
                    label_Lq.setText("Nombre moyen de clients dans la file Lq : " + df2.format(fileMMS.calculateLq()));
                    label_W.setText("Durée moyenne d'attente dans le système W : " + df2.format(fileMMS.calculateW()));
                    label_Wq.setText("Durée moyenne d'attente dans la file Wq : " + df2.format(fileMMS.calculateWq()));
                    label_tempsFile.setVisible(true);
                    label_tempsSejour.setText("Temps de séjour dans le système P(T>t) :");
                    label_tempsFile.setText("Temps de séjour dans la file P(Tq>t) :");
                    label_tIncorrect.setVisible(false);
                    label_iIncorrect.setVisible(false);
                }
            }
        }

    }
    
    @FXML
    private void handleValidertAction(ActionEvent event) {
        try{
            if(textField_t.getText().isEmpty() || Double.valueOf(textField_t.getText())<0){
                label_tIncorrect.setVisible(true);
                label_tIncorrect.setText("Valeur de t incorrecte");
            }
            else {
                label_tIncorrect.setVisible(false);
                if ("M|M|1".equals(choix)) {
                    label_tempsSejour.setVisible(true);
                    label_tempsFile.setVisible(true);
                    label_tempsSejour.setText("Temps de séjour dans le système P(T>" + textField_t.getText() + ") = " + df4.format(fileMM1.calculateProbaTauSupT(Double.valueOf(textField_t.getText()))));
                    label_tempsFile.setText("Temps de séjour dans la file P(Tq>" + textField_t.getText() + ") = " + df4.format(fileMM1.calculateProbaTauQSupT(Double.valueOf(textField_t.getText()))));
                }
                if ("M|M|1|K".equals(choix)) {
                    label_tempsSejour.setVisible(true);
                    label_tempsSejour.setText("Temps de séjour dans le système P(T>" + textField_t.getText() + ") = " + df4.format(fileMM1K.calculateProbaTauSupT(Double.valueOf(textField_t.getText()))));
                }
                if ("M|M|S".equals(choix)) {
                    if((fileMMS.getS()-1-fileMMS.rho()*fileMMS.getS())==0){
                        label_tIncorrect.setVisible(true);
                        label_tIncorrect.setText("Incalculable, \ndivision par 0 pour P(T>t)");
                    }
                    else{
                        label_tempsSejour.setVisible(true);
                        label_tempsFile.setVisible(true);
                        label_tempsSejour.setText("Temps de séjour dans le système P(T>" + textField_t.getText() + ") = " + df4.format(fileMMS.calculateProbaTauSupT(Double.valueOf(textField_t.getText()))));
                        label_tempsFile.setText("Temps de séjour dans la file P(Tq>" + textField_t.getText() + ") = " + df4.format(fileMMS.calculateProbaTauQSupT(Double.valueOf(textField_t.getText()))));
                    }
                }
            }
        }
        catch(NumberFormatException e){
            label_tIncorrect.setVisible(true);
            label_tIncorrect.setText("Format de t incorrecte");
        }


    }
    
    @FXML
    private void handleValideriAction(ActionEvent event) {
        try{
            if(textField_i.getText().isEmpty() || Double.valueOf(textField_i.getText())<0){
                label_iIncorrect.setVisible(true);
                label_iIncorrect.setText("Valeur de i incorrecte");
            }
            else {
                label_iIncorrect.setVisible(false);
                if ("M|M|1".equals(choix)) {
                    label_Qi.setText("Q" + textField_i.getText() + " (Probabilité d'avoir " + textField_i.getText() + " client(s) dans le système) = " + df4.format(fileMM1.calculateQj(Integer.valueOf(textField_i.getText()))));
                }
                if ("M|M|1|K".equals(choix)) {
                    if(Integer.valueOf(textField_i.getText()) > fileMM1K.getK()){
                        label_iIncorrect.setVisible(true);
                        label_iIncorrect.setText("Il ne peut pas y avoir plus de \n"+fileMM1K.getK()+" client(s) dans le système");
                    }
                    else{
                        label_Qi.setText("Q" + textField_i.getText() + " (Probabilité d'avoir " + textField_i.getText() + " client(s) dans le système) = " + df4.format(fileMM1K.calculateQj(Integer.valueOf(textField_i.getText()))));
                    }
                }
                if ("M|M|S".equals(choix)) {
                    label_Qi.setText("Q" + textField_i.getText() + " (Probabilité d'avoir " + textField_i.getText() + " client(s) dans le système) = " + df4.format(fileMMS.calculateQj(Integer.valueOf(textField_i.getText()))));
                }
            }
        }
        catch(NumberFormatException e){
            label_iIncorrect.setVisible(true);
            label_iIncorrect.setText("Format de i incorrect");
        }

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
}
