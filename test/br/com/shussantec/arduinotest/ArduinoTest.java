
package br.com.shussantec.arduinotest;

import br.com.shussantec.arduino.Arduino;

public class ArduinoTest {
    public static void main(String[] args) {
        Arduino arduino = new Arduino("com1");
        System.out.println(arduino);
    }
}
