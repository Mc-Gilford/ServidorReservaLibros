/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sources;

import java.util.Calendar;
import javax.swing.JTextArea;

/**
 *
 * @author chuch
 */
public class Timer extends Thread{
    
    private int m;
    private int h;
    private int s;
    public Timer ()
    {
        Calendar calendario = Calendar.getInstance();
        this.h=calendario.get(Calendar.HOUR);
        this.m=calendario.get(Calendar.MINUTE);
        this.s=calendario.get(Calendar.SECOND);
        
    }
    
    public void run()
    {
        //System.out.println(getH()+":"+getM()+":"+getS());
    }

    public int getM() {
        return m;
    }

    public int getH() {
        return h;
    }

    public int getS() {
        return s;
    }
    
    
}
