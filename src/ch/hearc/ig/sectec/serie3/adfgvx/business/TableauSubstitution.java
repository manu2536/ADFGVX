package ch.hearc.ig.sectec.serie3.adfgvx.business;

import java.util.HashMap;

public class TableauSubstitution {


	private HashMap<String, String[]>  subTable = new HashMap<String, String[]>(); 


	public TableauSubstitution() {

            this.subTable.put("c", new String[]{"A","A"});
            this.subTable.put("1", new String[]{"A","D"});
            this.subTable.put("o", new String[]{"A","F"});
            this.subTable.put("f", new String[]{"A","G"});
            this.subTable.put("w", new String[]{"A","V"});
            this.subTable.put("j", new String[]{"A","X"});
            
            this.subTable.put("y", new String[]{"D","A"});
            this.subTable.put("m", new String[]{"D","D"});
            this.subTable.put("t", new String[]{"D","F"});
            this.subTable.put("5", new String[]{"D","G"});
            this.subTable.put("b", new String[]{"D","V"});
            this.subTable.put("4", new String[]{"D","X"});
            
            this.subTable.put("i", new String[]{"F","A"});
            this.subTable.put("7", new String[]{"F","D"});
            this.subTable.put("a", new String[]{"F","F"});
            this.subTable.put("2", new String[]{"F","G"});
            this.subTable.put("8", new String[]{"F","V"});
            this.subTable.put("s", new String[]{"F","X"});
            
            this.subTable.put("p", new String[]{"G","A"});
            this.subTable.put("3", new String[]{"G","D"});
            this.subTable.put("0", new String[]{"G","F"});
            this.subTable.put("q", new String[]{"G","G"});
            this.subTable.put("h", new String[]{"G","V"});
            this.subTable.put("x", new String[]{"G","X"});
            
            this.subTable.put("k", new String[]{"V","A"});
            this.subTable.put("e", new String[]{"V","D"});
            this.subTable.put("u", new String[]{"V","F"});
            this.subTable.put("l", new String[]{"V","G"});
            this.subTable.put("6", new String[]{"V","V"});
            this.subTable.put("d", new String[]{"V","X"});
            
            this.subTable.put("v", new String[]{"X","A"});
            this.subTable.put("r", new String[]{"X","D"});
            this.subTable.put("g", new String[]{"X","F"});
            this.subTable.put("z", new String[]{"X","G"});
            this.subTable.put("n", new String[]{"X","V"});
            this.subTable.put("9", new String[]{"X","X"});
	}
        
   

	public void generateTable() {
		// TODO - implement TableauSubstitution.generateTable
		throw new UnsupportedOperationException();
	}

	

	public HashMap<String, String[]> getSubTable() {
		return subTable;

	}


	/**
	 * 
	 * @param subTable
	 */
	public void setSubTable(HashMap subTable) {
		this.subTable = subTable;
	}



	/**
	 * 
	 * @param subTable
	 */



}
