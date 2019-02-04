/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Threads;

import dao.Backup;
import fachada.Fachada;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Configuracoes;
import model.Reserva;
import util.Util;

/**
 *
 * @author Elvis Nogueira
 */
public class Rotinas extends Thread{
    boolean flag;
    Configuracoes c = Fachada.getInstance().getAllConfiguracoes().get(0);
    
    @Override
    public void run() {
        while(true){
            if(c.getHoraBackup().equals(Util.horaAtual())){
                try {
                    Backup.realizaBackup();
                } catch (IOException ex) {
                    Logger.getLogger(Rotinas.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Rotinas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            ArrayList<Reserva> reservas = Fachada.getInstance().getAllReserva();
            for(Reserva r : reservas){
                if(r.getHora_retirada().before(Util.horaAtual()))
                    Fachada.getInstance().removeReserva(r);
            }
            
            try {
                Thread.sleep(60000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Rotinas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
