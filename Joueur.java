import java.util.Scanner;

public class Joueur 
{
	private String pseudo;
	private int score;
	private char jeton; // + ou -
	
	private static Scanner sc2 = new Scanner(System.in);
	public Joueur(String pseudo, char jeton)
	{
		setPseudo(pseudo);
		setScore(0);
		setJeton(jeton);
	}
	
	public String getPseudo() 
	{
		return this.pseudo;
	}

	public void setPseudo(String pseudo) 
	{
		this.pseudo = pseudo;
	}

	public int getScore() 
	{
		return this.score;
	}

	public void setScore(int score) 
	{
		this.score = score;
	}
	
	public char getJeton() 
	{
		return jeton;
	}

	public void setJeton(char jeton) 
	{
		this.jeton = jeton;
	}

	public void jouer(Grille grille, Jeu jeu)
	{
		int c = 8;
		System.out.println("C'est a " + this.getPseudo() + " de jouer ! Choissisez la colonne où vous voulez mettre votre jeton (1~7) ");
		while(c < 1 || c >7)
			c = sc2.nextInt();
		if(!grille.insertToken(c-1, this.getJeton()))
			System.out.println("La colonne est remplie !, tu viens de perdre ton tour !");
	}
}
