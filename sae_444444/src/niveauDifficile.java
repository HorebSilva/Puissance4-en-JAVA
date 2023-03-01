import java.util.Scanner;

//programme avec bot difficile, le bot bloque dans la verticale et l'horizontale

public class niveauDifficile {
	//constante pour le jeu
	public static final int NB_LIGNES = 6;
	public static final int NB_COLONNES = 7;

	public static final char JOUEUR_1 = 'R';
	public static final char JOUEUR_2 = 'J';
	public static final char VIDE = '.';

	public static final Scanner scanner= new Scanner(System.in);

	public static void main(String[] args) {
		//		System.out.println(choisirColonneVerticale(0));
		//		System.out.println(choisirColonneHorizontaleAdroite(5));
		//		System.out.println(choisirColonneHorizontaleAgauche(4));
	}

	//méthode qui est appelé dans le menu
	public static void debut() {
		char [][]plateau= jouer1vs1.initialisationPlateau();
		saisirJeton(plateau);
	}

	/* Cette méthode permet de placer une couleur dans le tableau et annonce le gagnant */

	public static void saisirJeton (char[][] plateau) {
		int tour = 1;
		int colonne = 0;
		int choix = 0;
		String nomJoueur1,joueurActuel;
		String bot="Bot";
		char jeton=JOUEUR_1;
		boolean gagnant = false;

		//pseudo du joueur 1
		do {
			System.out.println("Joueur 1, quelle pseudo voulez-vous?: ");
			nomJoueur1=scanner.nextLine();
		}while(nomJoueur1.length()==0);


		joueurActuel=nomJoueur1;

		//boucle de jeu
		while (!gagnant && tour <= NB_LIGNES*NB_COLONNES){
			jouer1vs1.afficherPlateau(plateau);


			//utilisateur qui joue
			if (joueurActuel.equals(nomJoueur1)) {
				System.out.println(joueurActuel+ ", choisissez une colonne (0-"+NB_LIGNES+") :");
				colonne=jouer1vs1.placer(plateau);
			}
			//ordinateur qui joue
			else {
				// regarde si la case est vide
				if (plateau[0][colonne] == VIDE)
					//si le choix est égal à 0, l'ordinateur joue sur la verticale
					if (choix == 0){
						colonne = choisirColonneVerticale(colonne);
						System.out.println(joueurActuel + " a joué dans la colonne " + colonne);
						choix =  1;
					}

				//si le choix est égal à 1, l'ordinateur joue sur l'horizontale de droite
					else if (choix == 1) {
						colonne = choisirColonneHorizontaleAdroite(colonne);
						while (plateau[0][colonne] != VIDE){
							if(colonne ==6) {
								colonne=-1;
							}
							colonne++;
						}
						System.out.println(joueurActuel + " a joué dans la colonne " + colonne);
						choix = 2;
					}
				//si le choix est égal à 2, l'ordinateur joue sur l'horizontale de gauche
					else {
						colonne = choisirColonneHorizontaleAgauche(colonne);
						if(colonne==6) {
							while(plateau[0][colonne] != VIDE){
								colonne--;
							}
						}
						while (plateau[0][colonne] != VIDE){
							colonne++;
						}
						System.out.println(joueurActuel + " a joué dans la colonne " + colonne);
						choix = 0;
					}

				// si la case n'est pas vide
				else {
					//initialise la variable colonne à 0 pour pas sortir du plateau
					colonne = 0;
					// mets le jeton sur la colonne suivante tant que la colonne choisie est rempli
					while (plateau[0][colonne] != VIDE){
						colonne++;
					}
					System.out.println(joueurActuel + " a joué dans la colonne " + colonne);
				}

			}

			//fait tomber le jeton sur le plateau
			for (int ligne = NB_LIGNES-1; ligne>=0; ligne--) {
				if(plateau[ligne][colonne]==VIDE) {
					plateau[ligne][colonne] = jeton;
					break;
				}
			}
			//regarder s'il y a un gagnant à chaque tour
			gagnant = jouer1vs1.estGagnant(jeton,plateau);

			//changement de joueur à chaque tour
			if(joueurActuel.equals(nomJoueur1))
				joueurActuel=bot;
			else {
				joueurActuel=nomJoueur1;
			}

			//permutation des jetons
			if (jeton == JOUEUR_1){
				jeton = JOUEUR_2;
			}else{
				jeton = JOUEUR_1;
			}

			tour++;
		}

		// affiche le jeu à la fin
		jouer1vs1.afficherPlateau(plateau);

		//vérifie le résultat à la fin du jeu
		if (gagnant){
			if (jeton==JOUEUR_2){
				System.out.println(nomJoueur1+ " a gagné !!");
			}
			else{
				System.out.println(bot +" a gagné !!");
			}
		}
		else{
			System.out.println("Quelle belle partie !! Match nul !");
		}


	}

	//reçois la colonne choisie par le joueur et la retourne
	public static int choisirColonneVerticale(int dernièreColonne){
		return dernièreColonne;
	}

	//reçois la colonne choisie par le joueur et retourne la colonne suivante
	public static int choisirColonneHorizontaleAdroite(int dernièreColonne){
		int colonneAdroite;
		if (dernièreColonne == 6 ){
			dernièreColonne = -1;
		}
		colonneAdroite = dernièreColonne+1;
		return colonneAdroite;
	}

	//reçois la colonne choisie par le joueur et retourne la colonne précédente
	public static int choisirColonneHorizontaleAgauche(int dernièreColonne){
		int colonneAgauche;
		if (dernièreColonne==0){
			dernièreColonne=7;
		}
		colonneAgauche = dernièreColonne-1;
		return colonneAgauche;
	}
}