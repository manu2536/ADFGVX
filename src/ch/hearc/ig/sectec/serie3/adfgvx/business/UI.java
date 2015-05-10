package ch.hearc.ig.sectec.serie3.adfgvx.business;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;

public class UI {

	/**
	 * 
	 * @param table
	 */
        public void AfficheSubMessage(String[] subMessage){
            StringBuilder sb = new StringBuilder(); 
            for(String s : subMessage){
                sb.append(s);
            }
            System.out.println(sb.toString());
        }
	
	public void AfficheSubstTable(HashMap<String, String[]> substTable) {
            
            StringBuilder sb = new StringBuilder(); 
            
            for (Entry<String, String[]> coupleLettres : substTable.entrySet()) {
                sb.append(coupleLettres.getKey()).append(" ");
                sb.append(coupleLettres.getValue()[0]+ coupleLettres.getValue()[1]); 
                sb.append("\n");
            }
            
            System.out.println(sb.toString()); 

   
            
            /*
            Iterator iterator = substTable.keySet().iterator();  

            System.out.println("coufcouss"); 
                while(iterator.hasNext()){
                    String key = (String) iterator.next();

                    System.out.println("UI : Coucou "); 
                    //System.out.println(substTable.get(key)[0].toString() + substTable.get(key)[1].toString()); 
                }*/
	}
        
        public void AfficheTable(LinkedList table){
            StringBuilder sb = new StringBuilder(); 
            int nbLineTable = ((ColonneTable)table.getFirst()).getNbLine();
            //Prepare en-têtes
            for(int col=0;col<table.size();col++){
                    String lettre =  ((ColonneTable)table.get(col)).getLetterKey();
                    sb.append(lettre);
                    sb.append(" ");
                }
            sb.append(System.getProperty("line.separator"));
            //Tableau
            for(int line=0;line<nbLineTable;line++){
                //Impression Ligne
                for(int col=0;col<table.size();col++){
                    String lettre =  ((ColonneTable)table.get(col)).getLetterAtLine(line);
                    sb.append(lettre);
                    sb.append(" ");
                }
                sb.append(System.getProperty("line.separator"));
            }
            System.out.println(sb.toString());
        }   

}
