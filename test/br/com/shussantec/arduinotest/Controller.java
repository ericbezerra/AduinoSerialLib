package br.com.shussantec.arduinotest;

import br.com.shussantec.arduino.Arduino;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class Controller {

    @FXML
    private ComboBox cPort, cBRate;
    @FXML
    private Button bConnect;

    private Arduino arduino;
    private ArrayList<String> ports;
    private int[] brlist;

    public Controller() {
        arduino = new Arduino();
        ports = arduino.getPortList();
        brlist = arduino.getBauldRateList();
    }

    public void setConfigurations() {
        if (bConnect.getText().equals("Search Ports")) {
            
            for(int i = 0; i < ports.size(); i++){
                cPort.getItems().add(ports.get(i));
            }
            for(int i = 0; i < brlist.length; i++){
                cBRate.getItems().add(brlist[i]);
            }
            cPort.setPromptText(ports.get(0));
            cBRate.setPromptText(""+arduino.getBauldRate());
            cPort.setDisable(false);
            cBRate.setDisable(false);
            bConnect.setText("Connect");
        } else if (bConnect.getText().equals("Connect")) {
            cPort.setDisable(true);
            cBRate.setDisable(true);
            bConnect.setText("Disconnect");
        } else if (bConnect.getText().equals("Disconnect")) {
            bConnect.setText("Search Ports");
            cPort.getItems().clear();
            cBRate.getItems().clear();
        }
    }

}
