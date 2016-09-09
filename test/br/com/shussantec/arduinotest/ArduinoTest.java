package br.com.shussantec.arduinotest;

import br.com.shussantec.arduino.Arduino;
import javax.swing.JOptionPane;

public class ArduinoTest {

    public static void main(String[] args) {
        Arduino arduino = new Arduino();
        String port = arduino.getPortList()[0];
        arduino.connect(port, Arduino.BR_57600);
        JOptionPane.showMessageDialog(null, arduino.toString(), "Arduino Log", JOptionPane.PLAIN_MESSAGE);
        
    }
}
