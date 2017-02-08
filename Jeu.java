
public class Jeu 
{
	private Grille grille;
	private boolean gagne;

	public Jeu(Grille grille)
	{
		setGrille(grille);
		setGagne(false);
	}
	
	public Grille getGrille() 
	{
		return this.grille;
	}

	public void setGrille(Grille grille) 
	{
		this.grille = grille;
	}
	
	public boolean checkGagne(Grille grille)
	{
		if(this.checkHori(grille) || this.checkVert(grille) || this.checkSlash(grille) || this.checkAntiSlash(grille))
			return true;
		return false;
	}
	public boolean checkHori(Grille grille)
	{
		int countToken1 = 0;
		int countToken2 = 0;
		for(char[] i : grille.getGrille())
		{
			for(char i2 : i )
			{
				switch (i2)
				{
					case '-':
						if(countToken2 > 0)
							countToken2 = 0;
						countToken1++;
						if(countToken1 >= 4 || countToken2 >= 4)
						{
							return true;
						}
						break;
					case '+':
						if(countToken1 > 0)
							countToken1 = 0;
						countToken2++;
						if(countToken1 >= 4 || countToken2 >= 4)
						{
							return true;
						}
						break;
					default:
						countToken1 = 0;
						countToken2 = 0;
				}
			}
			countToken1 = 0;
			countToken2 = 0;
		}

		return false;
	}
	public boolean checkVert(Grille grille)
	{
		int countToken1 = 0;
		int countToken2 = 0;
		for(int c = 0; c<= grille.getNB_COLONNE(); c++)
		{
			for(int l = 0; l<= grille.getNB_LIGNE(); l++)
			{
				switch (grille.getCase(l, c))
				{
					case '-':
						if(countToken2 > 0)
							countToken2 = 0;
						countToken1++;
						if(countToken1 >= 4 || countToken2 >= 4)
						{
							return true;
						}
						break;
					case '+':
						if(countToken1 > 0)
							countToken1 = 0;
						countToken2++;
						if(countToken1 >= 4 || countToken2 >= 4)
						{
							return true;
						}
						break;
					default:
						countToken1 = 0;
						countToken2 = 0;
				}
			}
			countToken1 = 0;
			countToken2 = 0;
		}
		return false;
	}

	public boolean checkSlash(Grille grille)
	{
		int countToken1 = 0;
		int countToken2 = 0;
		int c2,l2;
		for(int l = 3; l <= grille.getNB_LIGNE(); l++)
		{
			for(int c = 0; c <= 3; c++)
			{
				switch (grille.getCase(l, c))
				{
					case '-':
						countToken1 = 0;
						if(countToken2 > 0)
							countToken2 = 0;
						countToken1++;
						c2 = c;
						l2 = l;
						for(int i = 1; i < 4; i++ )
						{
							c2++;
							l2--;
							if(grille.getCase(l2, c2) == '-')
								countToken1++;
							else if(grille.getCase(l2, c2) != '-')
							{
								countToken1 = 0;
								break;
							}
						}
						if(countToken1 >= 4 || countToken2 >= 4)
						{
							return true;
						}
						break;
					case '+':
						countToken2 = 0;
						if(countToken1 > 0)
							countToken1 = 0;
						countToken2++;
						c2 = c;
						l2 = l;
						for(int i = 1; i < 4; i++ )
						{
							c2++;
							l2--;
							if(grille.getCase(l2, c2) == '-')
								countToken2++;
							else if(grille.getCase(l2, c2) != '-')
							{
								countToken2 = 0;
								break;
							}
						}
						if(countToken1 >= 4 || countToken2 >= 4)
						{
							return true;
						}
						break;
					default:
						countToken1 = 0;
						countToken2 = 0;
				}
			}
			countToken1 = 0;
			countToken2 = 0;
		}
		return false;
	}
	public boolean checkAntiSlash(Grille grille)
	{
		int countToken1 = 0;
		int countToken2 = 0;
		int c2,l2;
		for(int l = 3; l <= grille.getNB_LIGNE(); l++)
		{
			for(int c = 3; c <= grille.getNB_COLONNE(); c++)
			{
				switch (grille.getCase(l, c))
				{
					case '-':
						countToken1 = 0;
						if(countToken2 > 0)
							countToken2 = 0;
						countToken1++;
						c2 = c;
						l2 = l;
						for(int i = 1; i < 4; i++ )
						{
							c2--;
							l2--;
							if(grille.getCase(l2, c2) == '-')
								countToken1++;
							else if(grille.getCase(l2, c2) != '-')
							{
								countToken1 = 0;
								break;
							}
						}
						if(countToken1 >= 4 || countToken2 >= 4)
						{
							return true;
						}
						break;
					case '+':
						countToken2 = 0;
						if(countToken1 > 0)
							countToken1 = 0;
						countToken2++;
						c2 = c;
						l2 = l;
						for(int i = 1; i < 4; i++ )
						{
							c2--;
							l2--;
							if(grille.getCase(l2, c2) == '-')
								countToken2++;
							else if(grille.getCase(l2, c2) != '-')
							{
								countToken2 = 0;
								break;
							}
						}
						if(countToken1 >= 4 || countToken2 >= 4)
						{
							return true;
						}
						break;
					default:
						countToken1 = 0;
						countToken2 = 0;
				}
			}
			countToken1 = 0;
			countToken2 = 0;
		}
		return false;
	}
	public boolean isGagne() 
	{
		return this.gagne;
	}

	public void setGagne(boolean gagne) 
	{
		this.gagne = gagne;
	}
	public void finJeu(Joueur joueur)
	{
		System.out.println(joueur.getPseudo() + " a gagné ! ");
		this.setGagne(true);
	}
}