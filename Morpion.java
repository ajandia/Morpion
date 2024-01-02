package com.morpion;

import java.util.Scanner;

public class Morpion {

	static void afficherGrille(char[][] grille) {
		System.out.println("\n  ╔═ GRILLE DE JEU ═╗");
		System.out.println("  ║     1   2   3   ║");
		
		for(int i = 0 ; i < 3 ; i++) {
			System.out.println("  ║    --- --- ---  ║");
			System.out.print("  ║ " + (i + 1) + " | " + grille[i][0]);
			for(int j = 1 ; j < 3 ; j++) {
				System.out.print(" | " + grille[i][j]);
			}
			
			System.out.println(" | ║");
		}
		System.out.println("  ║    --- --- ---  ║");

		System.out.println("  ╚═════════════════╝");
	}
	
	static boolean conditionArret(char[][] grille) {
		// TODO 2.1. Vérifier si au moins une des lignes a été complétée par une croix 'X'

		// TODO 2.3. Vérifier si au moins une des colonnes a été complétée par une croix 'X'
		
		// TODO 2.5. Vérifier si au moins une des diagonales a été complétée par une croix 'X'	

		// TODO 2.2. Vérifier si au moins une des lignes a été complétée par un rond 'O'
		
		// TODO 2.4. Vérifier si au moins une des colonnes a été complétée par un rond 'O'
		
		// TODO 2.6. Vérifier si au moins une des diagonales a été complétée par un rond 'O'
		
		return false;
	}
	
	static byte verifierTourJoueur(byte numeroTour) {
		// TODO 1. Vérifier si numeroTour est un nombre pair (oui : retourner 2 / sinon retourner 1)
		return 0;
	}
	
	static boolean estCaseOccupee(char[][] grille, int ligne, int colonne) {
		// TODO 6. Vérifie si une case est occupée par une croix 'X' ou un rond 'O'
		return false;
	}
	
	static char[][] affecterValeur(char[][] grille, int ligne, int colonne, char valeur) {
		// TODO 3. Affecte une valeur à l'élément de la grille dont la position est (ligne;colonne)
		return grille;
	}
	
	static char[][] dessinerCroix(char[][] grille, int ligne, int colonne) {
		// TODO 4. Affecter un rond 'X' à l'aide de la méthode affecterValeur()
		return grille;
	}
	
	static char[][] dessinerRond(char[][] grille, int ligne, int colonne) {
		// TODO 5. Affecter un rond 'O' à l'aide de la méthode affecterValeur()
		return grille;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char grille[][] = new char[3][3];
		byte numeroTour = 0;
		byte ligne, colonne;
		
		System.out.println("***************************************************");
		System.out.println("**** JEU DU MORPION * ÉVALUATION DU 31/07/2023 ****");
		System.out.println("***************************************************");

		System.out.println(" ╔════════════════╗");
		System.out.println(" ║  JOUEUR 1 : X  ║");
		System.out.println(" ║  JOUEUR 2 : O  ║");
		System.out.println(" ╚════════════════╝");
		
		while(!conditionArret(grille) && numeroTour != 9) {
			numeroTour++;
			
			byte joueur = verifierTourJoueur(numeroTour);
			
			afficherGrille(grille);
			
			System.out.println();
			
			System.out.println(" >>> Au tour du Joueur " + joueur);
			
			do {
				System.out.print(" >>> Numéro de la ligne (1 à 3) : ");
				ligne = sc.nextByte();
				System.out.print(" >>> Numéro de la colonne (1 à 3) : ");
				colonne = sc.nextByte();
				
				if(estCaseOccupee(grille, ligne, colonne)) {
					System.out.println(" /!\\ La case (" + ligne + "," + colonne + ") n'est pas vide !\n");
				}
			} while(estCaseOccupee(grille, ligne, colonne));
			
			switch(verifierTourJoueur(numeroTour)) {
				// TODO 7. Ajouter les deux cas possibles du switch
			}
		}
		
		System.out.println();
		
		if(conditionArret(grille)) {
			afficherGrille(grille);
			System.out.println(" >>> Jeu teriminé en " + numeroTour + " tours.");
			System.out.println("\tLe gagnant est le Joueur " + verifierTourJoueur(numeroTour) + ".");
		} else {
			System.out.println(" >>> Jeu terminé par un match nul !");
		}
		
		sc.close();
	}
	
}
