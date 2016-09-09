package br.com.shussantec.arduinotest;

import br.com.shussantec.arduino.Arduino;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class Controller {

    @FXML
    private Label lPort;
    @FXML
    private Label lBRate;
    @FXML
    private Button bConnect;
    @FXML
    private TextArea tArea;

    private Arduino arduino;

    public Controller() {
        int pin = 13;
        arduino = new Arduino();
        String port = arduino.getPortList()[0];
        arduino.connect(port, Arduino.BR_57600);
        arduino.pinMode(pin, Arduino.INPUT);
        arduino.digitalWrite(pin, "");
    }

    public void setConfigurations() {
        if (bConnect.getText().equals("Connect")) {
            lPort.setText(arduino.getPortList()[0]);
            lBRate.setText("" + arduino.getBauldRate());
            bConnect.setText("Disconnect");
        } else if (bConnect.getText().equals("Disconnect")) {
            lPort.setText("");
            lBRate.setText("");
            bConnect.setText("Connect");
        }
    }

}
