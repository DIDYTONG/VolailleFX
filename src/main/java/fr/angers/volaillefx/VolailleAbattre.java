package fr.angers.volaillefx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class VolailleAbattre implements Initializable {




    @FXML
    private Button btnClose;

    @FXML
    private TextArea textAreaA;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        textAreaA.setEditable(false);
    }

    public void setTriResults(String results) {
        textAreaA.appendText(results);
    }



    public void afficherResultatsAbattage(int nombrePoulets, int nombreCanards, int prixTotalCanards, int prixTotalPoulets, int nombrePouletsRestant, int nombreCanardsRestant) {
        textAreaA.appendText("Nombre de poulets à abattre : " + nombrePoulets + "\n");
        textAreaA.appendText("Nombre de canards à abattre : " + nombreCanards + "\n");
        textAreaA.appendText("Prix total poulets : " + prixTotalPoulets + "\n");
        textAreaA.appendText("Prix total canard : " + prixTotalCanards + "\n");
        textAreaA.appendText("Nombre de poulets restant : " + nombrePouletsRestant + "\n");
        textAreaA.appendText("Nombre de canard restant : " + nombreCanardsRestant + "\n");
    }

    @FXML
    public void handlebtnClose(ActionEvent actionEvent) {
        ((Stage)(((Button)actionEvent.getSource()).getScene().getWindow())).close();
    }
}

