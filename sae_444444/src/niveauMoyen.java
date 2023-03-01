import java.util.Scanner;

//programme avec bot moyen, il bloque que les verticales
public class niveauMoyen {
	//constante pour le jeu
	
	public static final int NB_LIGNES = 6;
	public static final int NB_COLONNES = 7;

	public static final char JOUEUR_1 = 'R';
	public static final char JOUEUR_2 = 'J';
	public static final char VIDE = '.';

	public static final Scanner scanner= new Scanner(System.in);

	//méthode qui est appelé dans le menu
	public static void debut() {
		char [][]plateau=jouer1vs1.initialisationPlateau();
		saisirJeton(plateau);
	}
	/* Cette méthode permet de placer une couleur dans le tableau et annonce le gagnant */

	public static void saisirJeton (char[][] plateau) {
		int tour = 1;
		int colonne = 0 ;
		String nomJoueur1,joueurActuel;
		String bot="Bot";
		char jeton=JOUEUR_1;
		boolean gagnant = false;		
		
		//pseudo joueur1
		do {
			System.out.println("Joueur 1, quelle pseudo voulez-vous?: ");
			nomJoueur1=scanner.nextLine();
		}while(nomJoueur1.length()==0);

		joueurActuel=nomJoueur1;
		
		//boucle de jeu
		while (!gagnant && tour <= NB_LIGNES*NB_COLONNES){
			jouer1vs1.afficherPlateau(plateau);
			
			//si c'est le tour du joueur, il saisie la colonne
			if(joueurActuel.equals(nomJoueur1)) {
				System.out.println( joueurActuel+ ", choisissez une colonne (0-"+NB_LIGNES+") :");
				colonne=jouer1vs1.placer(plateau);
			}
			//sinon c'est le bot qui saisie la même valeur que le joueur
			else {
				if(plateau[0][colonne]==VIDE) {
					colonne=niveauDifficile.choisirColonneVerticale(colonne);
					System.out.println( joueurActuel+ " a joué dans la colonne: "+ colonne);
				}
			}

			//fait tomber le jeton sur le plateau
			for (int ligne = NB_LIGNES-1; ligne>=0; ligne--) {
				if(plateau[ligne][colonne]==VIDE) {
					plateau[ligne][colonne] = jeton;
					break;
				}
			}
			//regarder si il ya un gagnant à chaque tour
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
		
		// afiche le jeu à la fin
		jouer1vs1.afficherPlateau(plateau);

		//verifieResultat à la fin du jeu
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

}