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
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Calendar;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chuch
 */
public class Servidor extends Observable implements Runnable{

    private int puerto;
    private int puerto_cliente;
    public Servidor (int puerto)
    {
        this.puerto=puerto;
    }

    public int getPuerto_cliente() {
        return puerto_cliente;
    }

    
    
    @Override
    public void run() {
    final int PUERTO = puerto;
    byte[] buffer = new byte[1024];
    try{
    //System.out.println("Servidor Iniciado");
    DatagramSocket socketUDP = new DatagramSocket(PUERTO);
    while(true)
    {
    DatagramPacket peticion= new DatagramPacket(buffer,buffer.length);
        try {
           // System.out.println("Recibo informacion cliente");
            socketUDP.receive(peticion);
            String mensaje= new String(peticion.getData());
            //System.out.println(mensaje);
            
            this.setChanged();
            this.notifyObservers(mensaje);
            this.clearChanged();
            
            puerto_cliente = peticion.getPort();
            InetAddress direccion = peticion.getAddress();
            //mensaje ="Hola mundo desde el servidor";
            //buffer = mensaje.getBytes();
            ///DatagramPacket respuestaServer = new DatagramPacket(buffer,buffer.length,direccion, puertoCliente);
            //System.out.println("Envio informacion al cliente");
            //socketUDP.send(respuestaServer);
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }
    catch(SocketException ex){
        Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE,null,ex);
    }
    }
    
}
