
package br.com.shussantec.arduino;

import gnu.io.CommPortIdentifier;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import java.util.Enumeration;

public class Arduino implements SerialPortEventListener{
    //Ports
    private String[] portList;
    private Enumeration searchList;
    private int bauldRate;    
    private String port;
    
    //Bauld Rates
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
    
    public Arduino(){
        if(bauldRate == 0) this.bauldRate = BR_57600;
    }
    
    public Arduino(String port){
        if(bauldRate == 0){
            this.bauldRate = BR_57600;
        }else{
            this.bauldRate = bauldRate;
        }
    }
    
    public Arduino(String port, int bauldRate){
        this.bauldRate = bauldRate;
        this.port = port;
    }
    
    public void connect(String port, int bauldRate){
    
    }
    
    public void digitalWrite(){System.out.println("Unimplemented Method");}
    public void digitalRead(){System.out.println("Unimplemented Method");}
    public void analogWrite(){System.out.println("Unimplemented Method");}
    public void analogRead(){System.out.println("Unimplemented Method");}
    
    public String[] getPortList(){
        int i = 0;
        searchList = CommPortIdentifier.getPortIdentifiers();
        portList = new String[10];
        
        while(searchList.hasMoreElements()){
            CommPortIdentifier atualPort = (CommPortIdentifier) searchList.nextElement();
            portList[i] = atualPort.getName();
            i++;
        }
        return portList;
    }
    
    public String toString(){
        return "[Port: "+port+" Bauld Rate: "+bauldRate+"]";
    }
    
    @Override
    public void serialEvent(SerialPortEvent spe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
