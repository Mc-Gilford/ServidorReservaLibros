/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sources;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chuch
 */
public class Insertar extends Thread{
    Connection c;
    private int id;
    private int idc;
    private String hm;
    private String hs;
    private String IP;
    private String user;
    private int ids;
    private String latencia;

    public Insertar(Connection c, int id, int idc, String hm, String hs, String IP, String user, int ids, String latencia) {
        this.c = c;
        this.id = id;
        this.idc = idc;
        this.hm = hm;
        this.hs = hs;
        this.IP = IP;
        this.user = user;
        this.ids = ids;
        this.latencia = latencia;
    }

    @Override
    public void run() {
        PreparedStatement ps1,ps2,ps3;
        int res1,res2,res3;
        System.out.println("Insertar id "+ this.id);
        if(this.id==0) //Hora central
        {
            try {
                ps1 = this.c.prepareStatement("INSERT INTO horacentral VALUES(?,?,?)");
                ps1.setString(1, ""+this.idc);
                ps1.setString(2, ""+this.hs);
                ps1.setString(3, ""+this.hm);
                res1 = ps1.executeUpdate();
                if(res1>0)
                {
                    System.out.println("Guardado");
                }
                else{
                    System.out.println("No guardado");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Insertar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       else if(this.id==1)//Equipos
        {
            try {
                ps2 = this.c.prepareStatement("INSERT INTO equipo VALUES(?,?,?,?)");
                ps2.setInt(1, this.ids);
                ps2.setString(2, ""+this.IP);
                ps2.setString(3, ""+this.user);
                ps2.setString(4, ""+this.latencia);
                res2 = ps2.executeUpdate();
                if(res2>0)
                {
                    System.out.println("Guardado");
                }
                else{
                    System.out.println("No guardado");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Insertar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(this.id==2)
        {
            try {
                ps3 = this.c.prepareStatement("INSERT INTO horaequipos VALUES(?,?,?,?,?)");
                ps3.setInt(1, this.idc);
                ps3.setInt(2, this.ids);
                ps3.setString(3, ""+this.hs);
                ps3.setString(4, ""+this.hm);
                ps3.setString(5, ""+this.latencia);
                res3 = ps3.executeUpdate();
                if(res3>0)
                {
                    System.out.println("Guardado");
                }
                else{
                    System.out.println("No guardado");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Insertar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
