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
		// Vérifier si au moins une des lignes a été complétée par une croix 'X'
		
		for(int i = 0 ; i < grille.length ; i++) {
			if(grille[i][0] == 'X' && grille[i][1] == 'X' && grille[i][2] == 'X') return true;
		}
		
		// Vérifier si au moins une des colonnes a été complétée par une croix 'X'
		
		for(int i = 0 ; i < grille.length ; i++) {
			if(grille[0][i] == 'X' && grille[1][i] == 'X' && grille[2][i] == 'X') return true;
		}
		
		// Vérifier si au moins une des diagonales a été complétée par une croix 'X'
		
		if(grille[0][0] == 'X' && grille[1][1] == 'X' && grille[2][2] == 'X') return true;
		if(grille[0][2] == 'X' && grille[1][1] == 'X' && grille[2][0] == 'X') return true;

		// Vérifier si au moins une des lignes a été complétée par un rond 'O'
		
		for(int i = 0 ; i < grille.length ; i++) {
			if(grille[i][0] == 'O' && grille[i][1] == 'O' && grille[i][2] == 'O') return true;
		}
		
		// Vérifier si au moins une des colonnes a été complétée par un rond 'O'
		
		for(int i = 0 ; i < grille.length ; i++) {
			if(grille[0][i] == 'O' && grille[1][i] == 'O' && grille[2][i] == 'O') return true;
		}
		
		// Vérifier si au moins une des diagonales a été complétée par un rond 'O'
		
		if(grille[0][0] == 'O' && grille[1][1] == 'O' && grille[2][2] == 'O') return true;
		if(grille[0][2] == 'O' && grille[1][1] == 'O' && grille[2][0] == 'O') return true;
		
		return false;
	}
	
	static byte verifierTourJoueur(byte numeroTour) {
		// Vérifier si numeroTour est un nombre pair (oui : retourner 2 / sinon retourner 1)
		
		if(numeroTour %2 == 0) {
			return 2;
		}else {
			return 1;
		}

	}
	
	static boolean estCaseOccupee(char[][] grille, int ligne, int colonne) {
		// Vérifier si une case est occupée par une croix 'X' ou un rond 'O'
		
		return grille[ligne][colonne] == 'X' || grille[ligne][colonne] == 'O';
	}
	
	static char[][] affecterValeur(char[][] grille, int ligne, int colonne, char valeur) {
		// Affecter une valeur à l'élément de la grille dont la position est (ligne;colonne)
		
		grille[ligne][colonne] = valeur;
		
		return grille;
	}
	
	static char[][] dessinerCroix(char[][] grille, int ligne, int colonne) {
		// Affecter un rond 'X' à l'aide de la méthode affecterValeur()
		
		grille = affecterValeur(grille, ligne, colonne, 'X');
		
		return grille;
	}
	
	static char[][] dessinerRond(char[][] grille, int ligne, int colonne) {
		// Affecter un rond 'O' à l'aide de la méthode affecterValeur()
		
		grille = affecterValeur(grille, ligne, colonne, 'O');
		
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
				
				if(estCaseOccupee(grille, ligne -1, colonne -1)) {
					System.out.println(" /!\\ La case (" + ligne + "," + colonne + ") n'est pas vide !\n");
				}
			} while(estCaseOccupee(grille, ligne -1, colonne -1));
			
			switch(verifierTourJoueur(numeroTour)) {
				// Ajouter les deux cas possibles du switch
			
			case 1 : 
				dessinerCroix(grille, ligne - 1, colonne -1);
				break;
			case 2 :
				dessinerRond(grille, ligne -1, colonne -1);
				break;
			
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
