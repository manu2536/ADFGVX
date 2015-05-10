package ch.hearc.ig.sectec.serie3.adfgvx.business;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class Message {
        
	private String cle;
	private String message;
	private LinkedList intermediateTable;
	private LinkedList finaleTable;
	private String[] subMessage;

	public Message() {

	}

	public String[] substitue() {
		// TODO - implement Message.substitue
                StringBuilder subMessage = new StringBuilder(); 
                String[] subM = {};
		TableauSubstitution tasub = new TableauSubstitution();
                for(char ch : this.message.toCharArray()){
                    //Automatiquement les caractères non pris en charge sont supprimés
                    if(tasub.getSubTable().containsKey(Character.toString(ch))){
                        String[] a = tasub.getSubTable().get(Character.toString(ch));
                        subM =  concat(subM, a);
                    }
                }
               this.subMessage = subM;
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

	public LinkedList getIntermediateTable() {
		return this.intermediateTable;
	}

	/**
	 * 
	 * @param intermediateTable
	 */
	public void setIntermediateTable(LinkedList intermediateTable) {
		this.intermediateTable = intermediateTable;
	}

	public LinkedList getFinaleTable() {
		return this.finaleTable;
	}

	/**
	 * 
	 * @param finaleTable
	 */
	public void setFinaleTable(LinkedList finaleTable) {
		this.finaleTable = finaleTable;
	}

	public void prepareInterTable() {
		// TODO - implement Message.prepareInterTable
		LinkedList interTable = new LinkedList();
                int sizeSub = this.subMessage.length;
                int sizeCle = this.cle.length();
                int nbLine = 0;
                if((sizeSub%sizeCle)>0){
                    nbLine = sizeSub/sizeCle + 1;
                } else {
                    nbLine = sizeSub/sizeCle + 1;
                }
                
                int iColonne = 0;
                for(char charCle : this.cle.toCharArray()){
                    ColonneTable col = new ColonneTable(Character.toString(charCle));
                    for(int ligne=0;ligne<=nbLine;ligne++){
                        int selChar = ((sizeCle*ligne)+iColonne);
                        //System.out.println("Calcul:"+selChar);
                        if(selChar < this.subMessage.length){
                            //System.out.println("Char:"+this.subMessage[selChar]);
                            col.addNextLetter(this.subMessage[selChar]);
                        } else { 
                            col.addNextLetter("A");
                        }
                    }
                    iColonne++;
                    interTable.add(col);
                }
                this.intermediateTable = interTable;
                
	}
        
        public void orderFinalTable(){
            //Trie clé
            char[] data = cle.toCharArray();
            Arrays.sort(data);
            LinkedList finalTable = new LinkedList();
            for(char ch : data){
                finalTable.add(getColonneMessage(ch,this.intermediateTable));
            }
            this.finaleTable = finalTable;
        }
        
        public void finalToIntermediateTable(){
            //Trie clé
            char[] data = cle.toCharArray();
            LinkedList interTable = new LinkedList();
            for(char ch : data){
                interTable.add(getColonneMessage(ch,this.finaleTable));
            }
            this.intermediateTable = interTable;
        }

	public String[] getSubMessage() {
		return this.subMessage;
	}
        
        public void toSubMessage(){
            int colSize = this.intermediateTable.size();
            int nbLineTable = ((ColonneTable)this.intermediateTable.getFirst()).getNbLine();
            StringBuilder sb = new StringBuilder();
             for(int line=0;line<nbLineTable;line++){
                //Impression Ligne
                for(int col=0;col<colSize;col++){
                    String lettre =  ((ColonneTable)this.intermediateTable.get(col)).getLetterAtLine(line);
                    sb.append(lettre);
                   
                }
                
            }
            this.subMessage = sb.toString().split("");
        }

	/**
	 * 
	 * @param subMessage
	 */
	public void setSubMessage(String[] subMessage) {
		this.subMessage = subMessage;
	}
        
        private static <T> T[] concat(T[] first, T[] second) {
            T[] result = Arrays.copyOf(first, first.length + second.length);
            System.arraycopy(second, 0, result, first.length, second.length);
            return result;
            }
        
        private ColonneTable getColonneMessage(char letterKey,LinkedList table){         
            int sizeT = table.size();
            ColonneTable colT = null;
            int iColonne = 0;
            while(colT == null && iColonne<sizeT){
                colT = (ColonneTable)table.get(iColonne);
                if(colT.getCharLetterKey() != letterKey){
                    colT = null;
                }
                iColonne++;
            }
            return colT;  
  
        }

}