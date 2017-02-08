
public class Grille 
{
	private char[][] grille = {
			{'▢','▢','▢','▢','▢','▢','▢'},
			{'▢','▢','▢','▢','▢','▢','▢'},
			{'▢','▢','▢','▢','▢','▢','▢'},
			{'▢','▢','▢','▢','▢','▢','▢'},
			{'▢','▢','▢','▢','▢','▢','▢'},
			{'▢','▢','▢','▢','▢','▢','▢'}
			};
	private final int NB_LIGNE = 5;
	private final int NB_COLONNE = 6;
	
	public int getNB_LIGNE() {
		return NB_LIGNE;
	}
	public int getNB_COLONNE() {
		return NB_COLONNE;
	}
	
	
	public char[][] getGrille() 
	{
		return grille;
	}
	public void setGrille(char[][] grille) 
	{
		this.grille = grille;
	}
	public char getCase(int ligne, int colonne)
	{
		return this.grille[ligne][colonne];
	}
	public void setCase(int ligne, int colonne,char car)
	{
		this.grille[ligne][colonne] = car;
	}
	public void display()
	{
		for(char[] i : this.getGrille())
		{
			for(char i2 : i )
			{
				System.out.print(i2);
			}
			System.out.println();
		}
	}
	public boolean insertToken(int colonne, char token)
	{
		int l = NB_LIGNE;
		char elCase = 'a';
		while(elCase != '▢')
		{
			elCase = this.getCase(l, colonne);
			if(elCase != '▢')
				l--;
			if(l < 0)
				return false;
		}
		this.setCase(l,colonne,token);
		return true;
	}
}