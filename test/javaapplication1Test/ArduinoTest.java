
package javaapplication1Test;

import javaapplication1.Arduino;

public class ArduinoTest {
    public static void main(String[] args) {
        Arduino arduino = new Arduino("com1");
        System.out.println(arduino);
    }
}
