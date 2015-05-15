package ch.hearc.ig.sectec.serie3.adfgvx.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

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
            this.subTable.clear();
            List<String> letter = new ArrayList();
            String alpha = "abcdefghijklmnopqrstuvwxyz0123456789";
            for(char a : alpha.toCharArray()){
                letter.add(Character.toString(a));
            }
            String adfgvx = "AAADAFAGAVAXDADDDFDGDVDXFAFDFFFGFVFXGAGDGFGGGVGXVAVDVFVGVVVXXAXDXFXGXVXX";
            char[] ch = adfgvx.toCharArray();
            int index = 0;
            List<String[]> adf = new ArrayList();
            while(index < ch.length){
                adf.add(new String[]{Character.toString(ch[index]),Character.toString(ch[index+1])});
                index = index + 2;
            }
            for (int i = 0; i<36;i++ ) {
                String key = letter.remove(randInt(0, letter.size() - 1));
                String[] pair = adf.remove(randInt(0, adf.size() - 1));
                this.subTable.put(key,pair);
            }

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

        public String getKeyByString(String[] sub) {
            String result = null;    
            Iterator it = this.subTable.entrySet().iterator();
            while (result == null && it.hasNext()) {
                Map.Entry pair = (Map.Entry)it.next();
                String[] valeur = (String[]) pair.getValue();
                if(valeur[0].equals(sub[0]) && valeur[1].equals(sub[1]) ){
                    result = (String)pair.getKey();
                }
            }

            return result;
        }
    
    private int randInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
    return randomNum;
}


}
