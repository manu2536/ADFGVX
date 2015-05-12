package ch.hearc.ig.sectec.serie3.adfgvx.business;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Scanner;

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
        
        
        /*
        L'utilisateur doit pouvoir choisir :
            • l'action : chiffrer ou déchiffrer
            • le texte à traiter
            • la clé
            • le tableau de substitution (définir ou aléatoire)
        */
        
        public void menuAffiche(){
            System.out.println("-- -- ADFGVX -- -- ");
            System.out.println("---- MENU ---- ");
        }
        
        public int saisieChiffrerDechiffrer(){
            System.out.println("Que voulez-vous faire? (1/2)");
            System.out.println(" 1. Chiffrer un message");
            System.out.println(" 2. Déchiffrer un message");
            System.out.print("(Saisir 1 ou 2) : ");
            
            Scanner sc = new Scanner(System.in);
            int i = sc.nextInt();
            return i; 
        }
        
        public String saisieMessage(String chiffreDechiffre){
            Scanner sc = new Scanner(System.in);
            System.out.print("Message à "+chiffreDechiffre+" : ");
            String message = sc.nextLine(); 
            return message; 
        }
        
        public String saisieCle(){
            Scanner sc = new Scanner(System.in);
            System.out.print("Clé : ");
            String cle = sc.next(); 
            return cle; 
        }
        
        public void afficheLigneVide(int nbLigne){
            for (int i=0; i<nbLigne; i++){
                System.out.println(); 
            }   
        }
        
        public Boolean continuer() {
            String reponse; 
            Scanner sc = new Scanner(System.in);
            System.out.print("Voulez-vous quitter le programme? (Q pour Quitter) ");
            reponse = sc.next(); 
            if(reponse.equals("q") || reponse.equals("Q")){
                return false; 
            }else{
                return true; 
            }
        }
        
        public void auRevoir(){
            System.out.print("Au revoir et à bientôt!");
        }
}
