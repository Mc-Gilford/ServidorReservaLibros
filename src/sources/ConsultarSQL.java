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
public class ConsultarSQL extends Thread{
    Connection c;
    String bd;
    int id;
    /*Variables libro*/
    String idLibro="";
    String NombreLibro="";
    String Portada="";

    public String getIdLibro() {
        return idLibro;
    }

    public String getNombreLibro() {
        return NombreLibro;
    }

    public String getPortada() {
        return Portada;
    }

    public String getAutor() {
        return Autor;
    }
    String Autor="";
    /*Variables cliente*/
    /*Variable Equipo*/
    /*Variables */
    public ConsultarSQL(Connection con, String base, int ide)
    {
        this.c=con;
        this.bd=base;
        this.id=ide;
    }
    public void run()
    {
        PreparedStatement ps;
        ResultSet res;
        try {
            int random=0;
            if(this.id==0)
            {
            random = (int) (Math.random()*4)+1;
            System.out.println(random);
            ps = this.c.prepareStatement("SELECT * FROM "+this.bd+" WHERE idLibro = " +random);
            res = ps.executeQuery();
                if(res.next()){
                    this.NombreLibro=res.getString("Nombre");
                    this.Autor=res.getString("Autor");
                    this.Portada=res.getString("Portada");
                    this.idLibro=res.getString("idLibro");
                    //System.out.println(res.getString("Nombre"));
                }
            }
            else if(this.id==1){
                random = (int) (Math.random()*4)+1;
                ps = this.c.prepareStatement("SELECT * FROM "+this.bd+" WHERE idCliente = " +random);
                res = ps.executeQuery();
                if(res.next()){
                
                    //System.out.println(res.getString("Nombre"));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConsultarSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
