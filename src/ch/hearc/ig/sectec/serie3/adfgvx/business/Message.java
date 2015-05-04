package ch.hearc.ig.sectec.serie3.adfgvx.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Message {

	private String cle;
	private String message;
	private String[][] intermediateTable;
	private int finaleTable;
	private String subMessage;

	public Message() {
		// TODO - implement Message.Message
		throw new UnsupportedOperationException();
	}

	public String substitue() {
		// TODO - implement Message.substitue
                StringBuilder subMessage = new StringBuilder(); 
		TableauSubstitution tasub = new TableauSubstitution();
                for(char ch : this.message.toCharArray()){
                    //Automatiquement les caractères non pris en charge sont supprimés
                    if(tasub.getSubTable().containsKey(ch)){
                      subMessage.append(tasub.getSubTable().get(ch));  
                    }
                }
               this.subMessage = subMessage.toString();
               return this.subMessage;
	}

	public void code() {
		// TODO - implement Message.code
		throw new UnsupportedOperationException();
                
                
	}

	public String getCle() {
		return this.cle;
	}

	/**
	 * 
	 * @param cle
	 */
	public void setCle(String cle) {
		this.cle = cle;
	}

	public String getMessage() {
		return this.message;
	}

	/**
	 * 
	 * @param message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	public String[][] getIntermediateTable() {
		return this.intermediateTable;
	}

	/**
	 * 
	 * @param intermediateTable
	 */
	public void setIntermediateTable(String[][] intermediateTable) {
		this.intermediateTable = intermediateTable;
	}

	public void getFinaleTable() {
		// TODO - implement Message.getFinaleTable
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param finaleTable
	 */
	public void setFinaleTable(int finaleTable) {
		this.finaleTable = finaleTable;
	}

	public void prepareInterTable() {
		// TODO - implement Message.prepareInterTable
		HashMap interTable = new HashMap();
                int sizeCle = this.cle.length();
                int posCharCle = 1;
                for(int posChar=1; posChar == 15;posChar++){
                    char subletter = this.subMessage.charAt(posChar);
                    if(posCharCle > sizeCle){
                       posCharCle = 1; 
                    }
                    LinkedList col = new LinkedList();
                    if(!interTable.containsKey(this.cle.charAt(posCharCle))){
                        interTable.put(this.cle.charAt(posCharCle), col);
                    }
                    col = (LinkedList)interTable.get(this.cle.charAt(posCharCle));
                    col.add(subletter);
                    
                   
                }   
	}

	public String getSubMessage() {
		return this.subMessage;
	}

	/**
	 * 
	 * @param subMessage
	 */
	public void setSubMessage(String subMessage) {
		this.subMessage = subMessage;
	}

}