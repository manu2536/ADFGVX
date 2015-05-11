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
 * @author anthony.malerba
 */
public class Adfgvx {

    public static void main(String[] args) {
        
        //Initialissation interface 
        UI ui = new UI();
        int i; 
        
        ui.menuAffiche(); 
        i = ui.saisieChiffrerDechiffrer();
        
        String  chiffrerDechiffrer = "Chiffrer"; 
        Boolean chiffrer = true; 
        if (i!=1) {
            chiffrerDechiffrer = "Déchiffrer";
            chiffrer = false; 
        }
          
        String mes;
        String cle; 
        mes = ui.saisieMessage(chiffrerDechiffrer); 
        cle = ui.saisieCle(); 
        
        
        Message mCode = new Message();
        mCode.setMessage(mes);
        mCode.setCle(cle);
        mCode.substitue();
        ui.afficheLigne(2);
        
        
        if(chiffrer){
            System.out.println("Message substitue");
            ui.AfficheSubMessage(mCode.getSubMessage());
            ui.afficheLigne(1);

            mCode.prepareInterTable();
            System.out.println("Intermediate Table");
            ui.AfficheTable(mCode.getIntermediateTable());

            mCode.orderFinalTable();
            System.out.println("Final Table");
            ui.AfficheTable(mCode.getFinaleTable());
        } 
        else {
            System.out.println("DECODAGE");
            Message mDecode = new Message();
            mDecode.setCle(cle);
            mDecode.setFinaleTable(mCode.getFinaleTable());

            System.out.println("decode final Table");
            ui.AfficheTable(mDecode.getFinaleTable());

            mDecode.finalToIntermediateTable();
            System.out.println("Intermediate Table");
            ui.AfficheTable(mDecode.getIntermediateTable());

            mDecode.toSubMessage();
            System.out.println("Message substitue");
            ui.AfficheSubMessage(mDecode.getSubMessage());
        }
    }
    
    
}
