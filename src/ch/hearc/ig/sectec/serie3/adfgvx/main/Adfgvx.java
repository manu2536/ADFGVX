/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.sectec.serie3.adfgvx.main;

import ch.hearc.ig.sectec.serie3.adfgvx.business.Message;
import ch.hearc.ig.sectec.serie3.adfgvx.business.UI;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anthony.malerba
 */
public class Adfgvx {

    public static void main(String[] args) {
        
        //Initialissation interface 
        UI ui = new UI();
        int i; 
        Boolean continuer = true; 
        
        while (continuer){

            String  mes;
            String  cle; 
            Message mCode = new Message();
            
            
            ui.menuAffiche(); 
            i = ui.saisieChiffrerDechiffrer();

            String  chiffrerDechiffrer = "Chiffrer"; 
            Boolean chiffrer = true; 
            if (i!=1) {
                chiffrerDechiffrer = "Déchiffrer";
                chiffrer = false; 
            }

            mes = ui.saisieMessage(chiffrerDechiffrer); 
            cle = ui.saisieCle(); 
            

            if (chiffrer) {
                mCode.setMessage(mes);
                mCode.getTabSub().generateTable();
                mCode.substitue();
            } else {
                mCode.setMessageADechiffrer(mes);
            }
            mCode.setCle(cle);
            ui.afficheLigneVide(2);


            if(chiffrer){

                System.out.println("Message substitue");
                ui.AfficheSubMessage(mCode.getSubMessage());
                ui.afficheLigneVide(1);


                mCode.prepareInterTable();
                System.out.println("Intermediate Table");
                ui.AfficheTable(mCode.getIntermediateTable());

                mCode.orderFinalTable();
                System.out.println("Final Table");
                ui.AfficheTable(mCode.getFinaleTable());
                
                System.out.println("Final en String");
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

                System.out.println("Message substitue");
                mDecode.toSubMessage();
                ui.AfficheSubMessage(mDecode.getSubMessage());

                System.out.println("Message decode");
                mDecode.deSubstitue();
                System.out.println(mDecode.getMessage());
            }
            System.out.println("Fin"); 
            continuer = ui.continuer(); 
           
            
        }
    
    }
    
}
