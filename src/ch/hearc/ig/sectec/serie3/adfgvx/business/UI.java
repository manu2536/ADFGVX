package ch.hearc.ig.sectec.serie3.adfgvx.business;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class UI {

	/**
	 * 
	 * @param table
	 */
	public void AfficheTable(String[][] table) {
		throw new UnsupportedOperationException();
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

}