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
        //Initialissation interface 
        UI ui = new UI();
        
        
        
        
        // TODO code application logic here
        String cle = "marcel";
        String mes = "objectif arras 15h28";
        
        Message mCode = new Message();
        mCode.setMessage(mes);
        mCode.setCle(cle);
        mCode.substitue();
        
        System.out.println("Message substitue");
        ui.AfficheSubMessage(mCode.getSubMessage());
       // UI.AfficheTable(m.getIntermediateTable());
        
        
        mCode.prepareInterTable();
        System.out.println("Intermediate Table");
        ui.AfficheTable(mCode.getIntermediateTable());

        mCode.orderFinalTable();
        System.out.println("Final Table");
        ui.AfficheTable(mCode.getFinaleTable());
     
        System.out.println("DECODAGE");
        Message mDecode = new Message();
        mDecode.setCle(cle);
        mDecode.setFinaleTable(mCode.getFinaleTable());
        
        System.out.println("decode final Table");
        ui.AfficheTable(mDecode.getFinaleTable());
        
        mDecode.finalToIntermediateTable();
        System.out.println("Intermediate Table");
        ui.AfficheTable(mDecode.getIntermediateTable());
        
        System.out.println("Message substitue");
        mDecode.toSubMessage();
        ui.AfficheSubMessage(mDecode.getSubMessage());

        System.out.println("Message decode");
        mDecode.deSubstitue();
        System.out.println(mDecode.getMessage());
    }
    
}
