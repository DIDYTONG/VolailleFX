package fr.angers.volaillefx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class VolaillePasAbattre implements Initializable {
    @FXML
    private Button btnClose;

    public void handlebtnClose(ActionEvent actionEvent) {
        ((Stage)(((Button)actionEvent.getSource()).getScene().getWindow())).close();
    }

    @FXML
    private TextArea textAreaP;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        textAreaP.setEditable(false);
        textAreaP.appendText("");
    }
}
