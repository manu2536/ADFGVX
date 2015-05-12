/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.sectec.serie3.adfgvx.main;

import ch.hearc.ig.sectec.serie3.adfgvx.business.Message;
import ch.hearc.ig.sectec.serie3.adfgvx.business.TableauSubstitution;
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
        
        //Test genere substitution
        /*
        TableauSubstitution tab = new TableauSubstitution(); 
        
        System.out.println("Tableau sub de base");
        ui.AfficheSubstTable(tab.getSubTable());
        System.out.println("Tableau aleatoire");
        tab.generateTable();
        ui.AfficheSubstTable(tab.getSubTable());
        */
        
        // TODO code application logic here
        String cle = "marcels";
        String mes = "objectif arras 15h28";
        
        Message mCode = new Message();
        mCode.setMessage(mes);
        mCode.setCle(cle);
        //mCode.getTabSub().generateTable();
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
        //Recupere tableau substitution
        
        
        System.out.println("Final en String");
        String messCode = mCode.getMessageChiffrer();
        System.out.println(messCode);
        
        TableauSubstitution tabSubCode = mCode.getTabSub();
        System.out.println("DECODAGE");
        Message mDecode = new Message();
        mDecode.setCle(cle);
        mDecode.setTabSub(tabSubCode);
        //String messCode = "FVAXADDADFVAAGFFFADDFFXXXDDGFAVGFVGF";
        mDecode.setMessageADechiffrer(messCode);
        //mDecode.setFinaleTable(mCode.getFinaleTable());
        
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
