/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.sectec.serie3.adfgvx.main;

import ch.hearc.ig.sectec.serie3.adfgvx.business.Message;
import ch.hearc.ig.sectec.serie3.adfgvx.business.UI;

/**
 *
 * @author emmanuel.rondez et moi :)  :) 
 */
public class main_ADFGVX {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String cle = "marcel";
        String mes = "objectif Arras 15h28";
        
        Message m = new Message();
        m.setMessage(mes);
        m.setCle(cle);
        System.out.println(m.substitue());
        UI.AfficheTable(m.getIntermediateTable());
        
    }
    
}
