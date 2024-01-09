package fr.angers.volaillefx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class VolaillePasAbattre {
        @FXML
        private Button btnClose;

        public void handlebtnClose(ActionEvent actionEvent) {
            ((Stage)(((Button)actionEvent.getSource()).getScene().getWindow())).close();
        }
}
