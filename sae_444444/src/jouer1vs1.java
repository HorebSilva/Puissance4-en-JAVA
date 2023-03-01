import java.util.Scanner;

public class jouer1vs1 {

	//constante pour le jeu
	public static final int NB_LIGNES = 6;
	public static final int NB_COLONNES = 7;

	public static final char JOUEUR_1 = 'R';
	public static final char JOUEUR_2 = 'J';
	public static final char VIDE = '.';

	public static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		//		char[][] test = initialisationPlateau();
		//		afficherPlateau(test);
		//		System.out.println(placer(test));

	}

	//méthode qui est appelé dans le menu pour lancer le jeu
	public static void debut() {
		char[][] plateau = initialisationPlateau();
		saisirJeton(plateau);

	}



	/* Cette méthode permet d'initialiser le Plateau pour le jeu */

	public static char[][] initialisationPlateau() {
		char[][] plateau = new char[NB_LIGNES][NB_COLONNES];
		for (int i = 0; i < NB_LIGNES; i++) {
			for (int j = 0; j < NB_COLONNES; j++) {
				plateau[i][j] = VIDE;

			}
		}
		return plateau;
	}

	/* Cette méthode est le coeur du jeu. Elle permet de saisir le jeton et annonce le gagnant */
	public static void saisirJeton(char[][] plateau) {
		int tour = 1;
		int colonne;
		String nomJoueur1,nomJoueur2,commence,joueurActuel;
		char jeton = JOUEUR_1;
		boolean gagnant = false;

		do {
			//pseudo joueur 1
			do {
				System.out.println("Joueur 1, quelle pseudo voulez-vous?: ");
				nomJoueur1 = scanner.nextLine();
			} while (nomJoueur1.length() == 0);

			//pseudo joueur2
			do {
				System.out.println("Joueur 2, quelle pseudo voulez-vous?: ");
				nomJoueur2 = scanner.nextLine();
			} while (nomJoueur2.length() == 0);
			if (stringEgal(nomJoueur1,nomJoueur2)) {
				System.out.println("Saisissez des pseudos différents !");
			}
		}	while (stringEgal(nomJoueur1,nomJoueur2));
		// qui commence?
		System.out.println("Qui souhaite commencer," + nomJoueur1 + " ou " + nomJoueur2 + "?");
		commence = scanner.nextLine();

		// verifie la saisie
		while (!stringEgal(commence, nomJoueur1) && !stringEgal(commence, nomJoueur2)) {
			System.out.println("Saisissez un pseudo valide !");
			commence = scanner.nextLine();
		}

		joueurActuel = commence;

		//boucle de jeu
		while (!gagnant && tour <= NB_LIGNES * NB_COLONNES) {

			afficherPlateau(plateau);
			System.out.println(joueurActuel + ", choisissez une colonne (0-" + NB_LIGNES + ") :");
			colonne = placer(plateau);


			//fait tomber le jeton
			for (int ligne = NB_LIGNES - 1; ligne >= 0; ligne--) {
				if (plateau[ligne][colonne] == VIDE) {
					if (joueurActuel.equals(nomJoueur1)) {
						plateau[ligne][colonne] = jeton;
					} else {
						jeton = JOUEUR_2;
						plateau[ligne][colonne] = jeton;
					}
					break;
				}
			}
			//regarder s'il ya un gagnant à chaque tour
			gagnant = estGagnant(jeton, plateau);

			//changement de joueur à chaque tour
			if (joueurActuel.equals(nomJoueur1))
				joueurActuel = nomJoueur2;
			else {
				joueurActuel = nomJoueur1;
			}

			//permutation des jetons
			if (jeton == JOUEUR_1) {
				jeton = JOUEUR_2;
			} else {
				jeton = JOUEUR_1;
			}

			tour++;
		}

		// affiche le plateau à chaque fois que quelqu'un joue
		afficherPlateau(plateau);

		//annonce du gagnant s'il y en a un
		if (gagnant) {
			if (jeton == JOUEUR_2) {
				if (commence.equals(nomJoueur1)) {
					System.out.println(nomJoueur1 + " a gagné !!");
				}
			} 
			else {
				System.out.println(nomJoueur2 + " a gagné !!");
			}
		} 
		else {
			System.out.println("Quelle belle partie !! Match nul !");
		}

	}

	// choisir le numéro de la colonne
	public static int placer(char[][] plateau) {
		int colonne;
		colonne = scanner.nextInt();
		while (colonne < 0 || colonne >= NB_COLONNES || plateau[0][colonne] != VIDE) {
			System.out.println("Nombre incorrect, saissisez une colonne (0-" + NB_LIGNES + ") :");
			colonne = scanner.nextInt();
		}
		return colonne;
	}

	// vérifie si 2 pseudos sont identiques
	public static boolean stringEgal(String pseudo1, String pseudo2) {
		return (pseudo1.equalsIgnoreCase(pseudo2));
	}

	/* Cette méthode permet d'afficher le plateau pour le jeu */

	public static void afficherPlateau(char[][] plateau) {
		System.out.println("-------------------------------------------------");
		for (int i = 0; i < NB_LIGNES; i++) {
			for (int j = 0; j < NB_COLONNES; j++) {
				System.out.print(plateau[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.print(0 + "\t" + 1 + "\t" + 2 + "\t" + 3 + "\t" + 4 + "\t" + 5 + "\t" + 6);
		System.out.println();
	}


	// toutes les conditions pour pouvoir gagner
	public static boolean estGagnant(char joueur, char[][] plateau) {

		//horizontale
		for (int ligne = 0; ligne < NB_LIGNES; ligne++) {
			for (int colonne = 0; colonne < NB_COLONNES - 3; colonne++) {
				if (plateau[ligne][colonne] == joueur &&
						plateau[ligne][colonne + 1] == joueur &&
						plateau[ligne][colonne + 2] == joueur &&
						plateau[ligne][colonne + 3] == joueur) {
					return true;
				}
			}
		}
		//verticale
		for (int ligne = 0; ligne < NB_LIGNES - 3; ligne++) {
			for (int colonne = 0; colonne < NB_COLONNES; colonne++) {
				if (plateau[ligne][colonne] == joueur &&
						plateau[ligne + 1][colonne] == joueur &&
						plateau[ligne + 2][colonne] == joueur &&
						plateau[ligne + 3][colonne] == joueur) {
					return true;
				}
			}
		}
		//diagonale ascendante
		for (int ligne = 3; ligne < NB_LIGNES; ligne++) {
			for (int colonne = 0; colonne < NB_COLONNES - 3; colonne++) {
				if (plateau[ligne][colonne] == joueur &&
						plateau[ligne - 1][colonne + 1] == joueur &&
						plateau[ligne - 2][colonne + 2] == joueur &&
						plateau[ligne - 3][colonne + 3] == joueur) {
					return true;
				}
			}
		}

		//diagonale descendante
		for (int ligne = 0; ligne < NB_LIGNES - 3; ligne++) {
			for (int colonne = 0; colonne < NB_COLONNES - 3; colonne++) {
				if (plateau[ligne][colonne] == joueur &&
						plateau[ligne + 1][colonne + 1] == joueur &&
						plateau[ligne + 2][colonne + 2] == joueur &&
						plateau[ligne + 3][colonne + 3] == joueur) {
					return true;
				}
			}
		}
		return false;
	}
}