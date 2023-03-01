import java.util.Scanner;

/* Cette classe met à disposition un menu qui gère les interactions avec l'utilisateur.*/
public class menu {
	public static Scanner scanner = new Scanner(System.in);
	public static void menuJeu() {

		int menu;

		//cela permet au joueur de choisir le jeu
		do {
			System.out.println("Bienvenue dans le jeu du Puissance 4 crée par Marouane et Horeb");
			System.out.println("--------------------");
			System.out.println("1. Jouer avec le bot");
			System.out.println("2. Jouer en 1VS1");
			System.out.println("3. Quitter");
			System.out.println("--------------------");
			System.out.print("Saisir votre choix:");
			menu= scanner.nextInt();
		} while (menu < 0 || menu > 3 );

		switch(menu){

		case 1: 
			menuBot();
			break;

		case 2:
			jouer1vs1.debut();
			break;

		}
		if (menu==3)
			System.out.println("A bientôt :)");
	}
	//cela permet au joueur de choisir le niveau de difficulté de l'ordinateur
	public static void menuBot(){
		int choix;
		do {
			System.out.println("--------------------");
			System.out.println("Choisissez la difficulté de l'ordinateur : "+"\n"+"1) Facile"+"\n"+"2) Moyenne"+"\n"+"3) Hardcore"+"\n"+"4) Quitter" );
			System.out.println("--------------------");
			System.out.print("Saisir votre choix:");
			choix=scanner.nextInt();
		} while (choix < 1 || choix > 4);

		switch (choix){
		case 1 :
			niveauFacile.debut();
			break;
		case 2 :
			niveauMoyen.debut();
			break;
		case 3 :
			niveauDifficile.debut();
			break;
		}
		if (choix==4)
			System.out.println("A bientôt :)");
	}

}

