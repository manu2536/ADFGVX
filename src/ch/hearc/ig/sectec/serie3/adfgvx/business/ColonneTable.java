/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.sectec.serie3.adfgvx.business;

import java.util.LinkedList;

/**
 *
 * @author Emmanuel.rondez
 */
public class ColonneTable {
    private String letterKey;
    private LinkedList colonne;
    
    // Méthode travaille
    public void addNextLetter(String letter){
        this.colonne.add(letter);
    }
    
    public String getLetterAtLine(int line){
        return (String) this.colonne.get(line);
    }
    
    public int getNbLine(){
        return this.colonne.size();
    }
    
    
    
    
    // Standart getter setter
    public String getLetterKey() {
        return letterKey;
    }

    public void setLetterKey(String letterKey) {
        this.letterKey = letterKey;
    }

    public LinkedList getColonne() {
        return colonne;
    }

    public void setColonne(LinkedList colonne) {
        this.colonne = colonne;
    }
    

    public ColonneTable(String letterKey) {
        this.letterKey = letterKey;
        this.colonne = new LinkedList();
    }

    public char getCharLetterKey() {
        return this.letterKey.charAt(0);
    }
    
    
    
    
}
