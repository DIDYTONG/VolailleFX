package fr.angers.volaillefx;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

import static javafx.application.Application.launch;

import javafx.scene.control.TextField;

import javafx.scene.control.Button;
import org.w3c.dom.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Gui extends Application {

    @FXML
    private Button trier;
    @FXML
    private TextArea textArea1;
    private int lastId = 0;

    @FXML
    public TextField quantite;
    @FXML
    public TextField prixKiloCannard;

    @FXML
    private TextField prixKiloPoulet;

    @FXML
    private TextField poidsAbatagePoulet;

    @FXML
    private TextField poidsAbatageCannard;

    @FXML
    private TextField poidsVolaille;

    @FXML
    private Button buttonAjouter;

    @FXML
    private ChoiceBox typeChoiceBox;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Charger le fichier FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Volaille-Main.fxml"));
        Parent root = loader.load();
        Elevage elevage = new Elevage();

        // Initialiser la scène
        Scene scene = new Scene(root);
        primaryStage.setTitle("Votre Application");
        primaryStage.setScene(scene);
        primaryStage.show();


        Gui controller = loader.getController();


        controller.buttonAjouter.setOnAction(event -> {
            String selectedType = (String) controller.typeChoiceBox.getValue();
            String poidsVolailleValue = controller.poidsVolaille.getText();
            String quantiteValue = controller.quantite.getText();

            if (!poidsVolailleValue.isEmpty() && !quantiteValue.isEmpty()) {
                int quantite = Integer.parseInt(quantiteValue);

                for (int i = 0; i < quantite; i++) {
                    String id = "";
                    if ("Poulet".equals(selectedType)) {
                        id = "P" + ++lastId;
                        elevage.ajouterPouletsViaGui(Double.parseDouble(poidsVolailleValue), id);
                        // Append information to the TextArea
                        controller.textArea1.appendText("Nouveau poulet ajouté - ID : " + id + "\n");
                    } else if ("Canard".equals(selectedType)) {
                        id = "C" + ++lastId;
                        elevage.ajouterCanardsViaGui(Double.parseDouble(poidsVolailleValue), id);
                        // Append information to the TextArea
                        controller.textArea1.appendText("Nouveau canard ajouté - ID : " + id + "\n");
                    }
                }

                // Print the information to the console
                System.out.println("Ajout de " + quantite + " volaille(s) : " + elevage.getVolaillesList());
            } else {
                System.out.println("Le champ du poids de la volaille ou de la quantité est vide.");
            }
        });


        controller.trier.setOnAction(event -> {
            Poulet.setPrixJour(Double.parseDouble(controller.prixKiloPoulet.getText()));
            Canard.setPrixJour(Double.parseDouble(controller.prixKiloCannard.getText()));

            Poulet.setPoidsAbattage(Double.parseDouble(controller.poidsAbatagePoulet.getText()));
            Canard.setPoidsAbattage(Double.parseDouble(controller.poidsAbatageCannard.getText()));


            double prixTotalCanards = elevage.trierEtAbattreCanard() * Canard.getPrixJour();
            double prixTotalPoulets = elevage.trierEtAbattrePoulet() * Poulet.getPrixJour();

            System.out.println("Total du prix des canards : " + prixTotalCanards);
            System.out.println("Total du prix des poulets : " + prixTotalPoulets);
            System.out.println("Prix total de l'élevage : " + (prixTotalCanards + prixTotalPoulets));
        });

    }

    @FXML
    private void initialize() {
        textArea1.setEditable(false);
    }

    @FXML
    private Button btnPasAbattre;
    public void handlebtnPasAbattre(ActionEvent actionEvent) throws IOException {
        // Charger le fichier FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Volaille-PAS_Abattre.fxml"));
        Stage primaryStage = new Stage();
        Parent root = loader.load();
        Elevage elevage = new Elevage();

        // Initialiser la scène
        Scene scene = new Scene(root);
        primaryStage.setTitle("Volaille à NE PAS Abattre");
        primaryStage.setScene(scene);

        primaryStage.initModality(Modality.NONE);
        primaryStage.show();
    }
}

