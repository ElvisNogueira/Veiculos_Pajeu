/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.sql.Time;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;

/**
 *
 * @author Elvis Nogueira
 */
public class Util {
    private static Pattern pattern;
    private static Matcher matcher;
    public static String PANE_SELEC = "-fx-background-color: #e3e3e3;";
    public static String PANE_DESSELEC = "-fx-background-color:  #ebebeb;";
    public static String TELA_CARROS_HOME = "carrosHome", TELA_CLIENTES_HOME = "clientesHome", 
            TELA_FINANCEIRO_HOME = "financeiroHome", TELA_FUNCIONARIOS_HOME = "funcionariosHome",
            TELA_LOGIN = "login", TELA_HOME = "home";

    private static final String RESTRICOES = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%&*]).{6,11})";

    public static String criptografar(String original) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
        byte messageDigest[] = algorithm.digest(original.getBytes("UTF-8"));

        StringBuilder hexString = new StringBuilder();
        for (byte b : messageDigest) {
            hexString.append(String.format("%02X", 0xFF & b));
        }
        return hexString.toString();
    }

    public static Date getDate(String d) {
        d = d.replaceAll("/", "");
        int ano = (Integer.parseInt(d.substring(4, 8))) - 1900;
        int mes = (Integer.parseInt(d.substring(2, 4)))-1;
        int dia = (Integer.parseInt(d.substring(0, 2)));
        Date data = new Date(ano, mes, dia);
        return data;
    }
    
    public static Date converterCalendarToDate(Calendar cal){
        
        Date d = new Date(cal.getInstance().get(GregorianCalendar.YEAR), cal.getInstance().get(GregorianCalendar.
                MONTH),cal.get(GregorianCalendar.DAY_OF_MONTH));
        int dia = cal.get(GregorianCalendar.DAY_OF_MONTH);
        int mes = cal.getInstance().get(GregorianCalendar.MONTH)+1;
        int ano = cal.getInstance().get(GregorianCalendar.YEAR);
        String c = "";
        if(mes>9)
            c =(dia+"/"+mes+"/"+ano);
        else
            c =(dia+"/0"+mes+"/"+ano);
        if(dia<10)
            c = "0"+c;
        return getDate(c);  
    }
    
    public static  Date dataAtual(){
        Calendar data = Calendar.getInstance();
        Date d2 =  Util.converterCalendarToDate(data);
        return d2;
    }
    
    public static  Time horaAtual(){
        Calendar hora = Calendar.getInstance();
        Time time = new Time(hora.getTime().getHours(), hora.getTime().getMinutes(), hora.getTime().getSeconds());
        System.out.println("util.Util.horaAtual() "+time.toString());
        return time;
    }

    public static boolean validarSenha(String senha) {
        pattern = Pattern.compile(RESTRICOES);
        matcher = pattern.matcher(senha);
        return matcher.matches();
    }
    
    public static int calcularIdade(Date dataNasc){
        Date dataAtual = dataAtual();
        int idade = dataAtual.getYear() - dataNasc.getYear();        
        if (dataAtual.getMonth() < dataNasc.getMonth()) {
            idade--;
        }else if(dataAtual.getMonth()==dataNasc.getMonth() && dataAtual.getDate()<dataNasc.getDate())
            idade--;
        return idade;
    }
    

}
