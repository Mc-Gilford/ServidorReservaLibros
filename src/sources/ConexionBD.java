/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sources;

import java.sql.Connection;
import java.sql.DriverManager;



/**
 *
 * @author chuch
 */
public class ConexionBD{
    public static final String URLReloj = "jdbc:mysql://localhost:3306/reloj?serverTimezone=UTC";
    public static final String URLLibros = "jdbc:mysql://localhost:3306/libros?serverTimezone=UTC";
    public static final String USER = "root";
    public static final String PASSWORD = "chucho61997";
    
    public static Connection ConexionReloj()
    {
        Connection con = null;
        try{
        //Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(URLReloj, USER, PASSWORD);
        System.out.println("Conexion Reloj realizada");
        }
        catch(Exception e){
            System.out.println(e);
        }
        return con;
    }
    public static Connection ConexionLibros()
    {
        Connection con = null;
        try{
        //Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(URLLibros, USER, PASSWORD);
        System.out.println("Conexion Liros realizada");
        }
        catch(Exception e){
            System.out.println(e);
        }
        return con;
    }
}
