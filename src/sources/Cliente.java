/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sources;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chuch
 */
public class Cliente implements Runnable{
   private int puerto;
    private String msj;
    private String IP="";
    private int status; //1 marca disponible, 0 marca apagado
    public Cliente(int puerto,String msj,String IP)
    {
        this.puerto = puerto;
        this.msj = msj;
        this.IP=IP;
    }

    public int getStatus() {
        return status;
    }
    
    @Override
    public void run() {
    final int PUERTO_SERVIDOR = puerto;
    byte[] buffer = new byte[1024];
    Arrays.fill(buffer, (byte)0);
    try{
    //System.out.println("Cliente Iniciado");
    InetAddress direccion;
        try {
            direccion = InetAddress.getByName(this.IP);
            //direccion = InetAddress.getByName("localhost");
            InetAddress address = InetAddress.getLocalHost();
            String []ip_local = address.toString().split("/");
            
            //System.out.println("Address "+ ip_local[1]);
            DatagramSocket socketUDP = new DatagramSocket();//Asigan una direccion 
            msj+=ip_local[1];
            buffer = msj.getBytes();
            DatagramPacket pregunta = new DatagramPacket(buffer, buffer.length, direccion, PUERTO_SERVIDOR);
            try {
                //System.out.println("Envio datagrama");
                socketUDP.send(pregunta);
                
                DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);
                
                //System.out.println("Recibo peticion");
                //socketUDP.receive(peticion);
                //msj = new String (peticion.getData());
                
                //System.out.println(msj);
                socketUDP.close();

            } catch (IOException ex) {
                //System.out.println("1");
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (UnknownHostException ex) {
            //System.out.println("2");
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    catch(SocketException ex){
        //System.out.println("3");
        Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE,null,ex);
    }
    }
}
