package br.com.shussantec.view;

import br.com.shussantec.arduino.Arduino;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class Controller {

    @FXML
    private ComboBox cPort, cBRate;
    @FXML
    private Button bConnect;
    @FXML
    private Label status;

    private final Arduino arduino;
    private final ArrayList<String> ports;
    private final int[] brlist;

    public Controller() {
        arduino = new Arduino();
        ports = arduino.getPortList();
        brlist = arduino.getBauldRateList();
    }

    public void setConfiguration() {
        if (arduino.getPortList().isEmpty()) {
            status.setText("Ports not found!");
            bConnect.setDisable(true);
        } else {
            switch (bConnect.getText()) {
                case "Search Ports":
                    for (int i = 0; i < ports.size(); i++) {
                        cPort.getItems().add(ports.get(i));
                    }
                    for (int i = 0; i < brlist.length; i++) {
                        cBRate.getItems().add(brlist[i]);
                    }
                    cPort.setPromptText(ports.get(0));
                    cBRate.setPromptText("" + arduino.getBauldRate());
                    cPort.setDisable(false);
                    cBRate.setDisable(false);
                    bConnect.setText("Connect");
                    break;
                case "Connect":
                    cPort.setDisable(true);
                    cBRate.setDisable(true);
                    status.setText("Online");
                    bConnect.setText("Disconnect");
                    break;
                case "Disconnect":
                    bConnect.setText("Search Ports");
                    status.setText("Offiline");
                    cPort.getItems().clear();
                    cBRate.getItems().clear();
                    break;
                default:
                    break;
            }
        }
    }
}
