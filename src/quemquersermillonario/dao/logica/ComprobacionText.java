/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quemquersermillonario.dao.logica;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author alvaro
 */
public class ComprobacionText {

    public static boolean jTextFieldObligatorio(JTextField jt) {
        if (jt.getText().length() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean jTextFieldEmail(JTextField jt) {
        if ((jt.getText().trim().indexOf(" ") == -1) && jt.getText().indexOf("@") != -1) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean jPassword(JPasswordField p1, JPasswordField p2) {
        if (p1.getText().length() > 0 && p2.getText().length() > 0 && (p1.getText().equals(p2.getText()))) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean jAno(JTextField jt) {

        Calendar calendar = new GregorianCalendar();
        calendar.setTime(new Date());
        int actual = calendar.get(Calendar.YEAR);
        
        System.out.println(actual);
        int minimo = actual - 18;
        int maximo = actual - 90;

        try {
            int ano = Integer.parseInt(jt.getText());
            return ano < minimo && ano > maximo;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public static boolean comprobacionTamanoJTextField(JTextField jtf, int maximo){
        if (jtf.getText().length()>maximo){
            jtf.setText(jtf.getText().substring(0, maximo-1));
            return  false;
        }
        else{
            return  true;
        }
    }
}
