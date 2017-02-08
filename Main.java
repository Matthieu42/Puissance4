import java.util.Scanner;

public class Main 
{

	public static void main(String[] args) 
	{
		Grille mainGrille = new Grille();
		Jeu puissance4 = new Jeu(mainGrille);
		Scanner sc = new Scanner(System.in);
		String nom;
		Joueur[] tabJoueur = new Joueur[2];
		String token = new String("-+");
		int i = 0;
		System.out.println("--------------- Bienvenue dans le jeu de puissance 4 ! ---------------");
		
		for(int j = 1; j <= 2; j++)
		{
			System.out.println("Entrez le nom du joueur "+ j);
			nom = sc.nextLine();
			Joueur joueur = new Joueur(nom,token.charAt(j-1));
			tabJoueur[j-1] = joueur;
		}
		mainGrille.display();
		
		while(true)
		{
			tabJoueur[i].jouer(mainGrille, puissance4);
			mainGrille.display();
			if(puissance4.checkGagne(mainGrille))
			{
				puissance4.finJeu(tabJoueur[i]);
				break;
			}
				
			
			if(i == 0) i++;
			else if(i == 1 ) i--;
		}
		sc.close();
	}

}
