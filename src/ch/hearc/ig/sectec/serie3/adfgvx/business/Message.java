package ch.hearc.ig.sectec.serie3.adfgvx.business;

import java.util.Arrays;
import java.util.LinkedList;

public class Message {

    private String cle;
    private String message;
    private String[] subMessage;
    private LinkedList intermediateTable;
    private LinkedList finaleTable;
    private TableauSubstitution tabSub;

    public Message() {
        this.tabSub = new TableauSubstitution();
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

    public String[] getSubMessage() {
        return this.subMessage;
    }

    /**
     *
     * @param subMessage
     */
    public void setSubMessage(String[] subMessage) {
        this.subMessage = subMessage;
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

    public TableauSubstitution getTabSub() {
        return tabSub;
    }

    public void setTabSub(TableauSubstitution tabSub) {
        this.tabSub = tabSub;
    }

    public String[] substitue() {
        StringBuilder subMessage = new StringBuilder();
        String[] subM = {};

        for (char ch : this.message.toCharArray()) {
            //Automatiquement les caractères non pris en charge sont supprimés
            if (this.tabSub.getSubTable().containsKey(Character.toString(ch))) {
                String[] a = this.tabSub.getSubTable().get(Character.toString(ch));
                subM = concat(subM, a);
            }
        }
        this.subMessage = subM;
        return this.subMessage;
    }

    public String deSubstitue() {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index < this.subMessage.length) {
            String[] sub = {this.subMessage[index], this.subMessage[index + 1]};
            String xx = this.tabSub.getKeyByString(sub);
            sb.append(this.tabSub.getKeyByString(sub));
            index = index + 2;
        }
        this.message = sb.toString();
        return this.message;
    }

    // Transforme le message substitué en tableau
    public void prepareInterTable() {
        LinkedList interTable = new LinkedList();
        int sizeSub = this.subMessage.length;
        int sizeCle = this.cle.length();
        int nbLine = 0;
        if ((sizeSub % sizeCle) > 0) {
            nbLine = sizeSub / sizeCle + 1;
        } else {
            nbLine = sizeSub / sizeCle;
        }

        int iColonne = 0;
        for (char charCle : this.cle.toCharArray()) {
            ColonneTable col = new ColonneTable(Character.toString(charCle));
            for (int ligne = 0; ligne < nbLine; ligne++) {
                int selChar = ((sizeCle * ligne) + iColonne);
                //System.out.println("Calcul:"+selChar);
                if (selChar < this.subMessage.length) {
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

    // Tri le tableau par ordre alphabetique
    public void orderFinalTable() {
        //Trie clé
        char[] data = cle.toCharArray();
        Arrays.sort(data);
        LinkedList finalTable = new LinkedList();
        for (char ch : data) {
            finalTable.add(getColonneMessage(ch, this.intermediateTable));
        }
        this.finaleTable = finalTable;
    }

    // Tri le tableau avec la clé
    public void finalToIntermediateTable() {
        //Trie clé
        char[] data = cle.toCharArray();
        LinkedList interTable = new LinkedList();
        for (char ch : data) {
            interTable.add(getColonneMessage(ch, this.finaleTable));
        }
        this.intermediateTable = interTable;
    }

    // Subtitue le message avec tableau de substitution
    public void toSubMessage() {
        int colSize = this.intermediateTable.size();
        int nbLineTable = ((ColonneTable) this.intermediateTable.getFirst()).getNbLine();
        StringBuilder sb = new StringBuilder();
        for (int line = 0; line < nbLineTable; line++) {
            //Impression Ligne
            for (int col = 0; col < colSize; col++) {
                String lettre = ((ColonneTable) this.intermediateTable.get(col)).getLetterAtLine(line);
                sb.append(lettre);

            }

        }
        this.subMessage = sb.toString().split("(?<!\\A)(?=[A-Z])");
    }

    // Fonction concatenation Tableau
    private static <T> T[] concat(T[] first, T[] second) {
        T[] result = Arrays.copyOf(first, first.length + second.length);
        System.arraycopy(second, 0, result, first.length, second.length);
        return result;
    }

    // Retourne la colonne en fonction de la clé
    private ColonneTable getColonneMessage(char letterKey, LinkedList table) {
        int sizeT = table.size();
        ColonneTable colT = null;
        int iColonne = 0;
        while (colT == null && iColonne < sizeT) {
            colT = (ColonneTable) table.get(iColonne);
            if (colT.getCharLetterKey() != letterKey) {
                colT = null;
            }
            iColonne++;
        }
        return colT;

    }

}
