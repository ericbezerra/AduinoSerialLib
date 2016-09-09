package br.com.shussantec.arduino;

import gnu.io.CommPortIdentifier;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import java.util.Enumeration;

public class Arduino implements SerialPortEventListener {

    /**
     *
     *          //Ports
     *
     */
    private String[] portList;
    private Enumeration searchList;
    private int bauldRate;
    private String port;

    /**
     *
     * Bauld Rates
     *
     */
    public static int BR_300 = 300;
    public static int BR_1200 = 1200;
    public static int BR_2400 = 2400;
    public static int BR_4800 = 4800;
    public static int BR_9600 = 9600;
    public static int BR_19200 = 19200;
    public static int BR_38400 = 38400;
    public static int BR_57600 = 57600;
    public static int BR_115200 = 115200;
    public static int BR_230400 = 230400;
    public static int BR_250000 = 250000;

    /**
     *
     * PinMode Configuration
     *
     */
    public static int HIGH;
    public static int LOW;
    public static int OUTPUT;
    public static int INPUT;
    
    /**
     *
     * Construtors
     *
     */
    public Arduino() {
        if (bauldRate == 0) {
            this.bauldRate = BR_57600;
        }
    }

    public Arduino(String port) {
        if (bauldRate == 0) {
            this.bauldRate = BR_57600;
        } else {
            this.bauldRate = bauldRate;
        }
    }

    public Arduino(String port, int bauldRate) {
        this.bauldRate = bauldRate;
        this.port = port;
    }

    /**
     *
     * Conection
     *
     */
    public void connect(String port, int bauldRate) {
        this.setPort(port);
    }
    
    public void pinMode(int pin, int mode){
    
    }

    /**
     *
     * Digital input output
     *
     */
    public void digitalWrite(int pin, String input) {
        System.out.println("Unimplemented Method - digitalWrite");
    }

    public String digitalRead(int pin) {
        String output = null;
        System.out.println("Unimplemented Method - digitalRead");
        return output;
    }

    /**
     *
     * Analog input output
     *
     */
    public void analogWrite(int pin, String input) {
        System.out.println("Unimplemented Method - analogWrite");
    }

    public String analogRead(int pin) {
        String output = null;
        System.out.println("Unimplemented Method - analogRead");
        return output;
    }

    /**
     *
     * Getters Setters
     *
     */
    public void setPort(String port) {
        this.port = port;
    }

    public String[] getPortList() {
        int i = 0;
        searchList = CommPortIdentifier.getPortIdentifiers();
        portList = new String[10];

        while (searchList.hasMoreElements()) {
            CommPortIdentifier atualPort = 
                    (CommPortIdentifier) searchList.nextElement();
            portList[i] = atualPort.getName();
            i++;
        }
        return portList;
    }

    public int getBauldRate(){
        return this.bauldRate;
    }
    /**
     *
     * Auxiliar methods
     *
     */
    public String toString() {
        return "[Port: " + port + " Bauld Rate: " + bauldRate + "]";
    }

    @Override
    public void serialEvent(SerialPortEvent spe) {
        throw new 
        UnsupportedOperationException("Not supported yet."); 
//To change body of generated methods, choose Tools | Templates.
    }

}
