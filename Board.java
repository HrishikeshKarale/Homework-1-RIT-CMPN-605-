/**
* Board.java
*
* @version   $Id: Board.java,v_1.0 2014/09/02 20:24:00
*
* @author    hhk9433
* @author    ap8185
*
* Revisions:
*      Initial revision
*/

	/* This program places maximum number of kings on the given board
	 * without them attacking each other.
	 *  
	 *  @aurthor	Hrishikesh Karale
	 *  @aurthor	Atir Petkar
	 */

public class Board {
	
	static char mattrix[][]= new char[10][10];	//mattrix is the 10x10 board
	static int p, k;							/*p, k are row and
	 											column number respectively*/ 
	static Board board= new Board();			//object board is created
	static int counter=0;						//counts no of kings placed
	
	public void display()
	{
		/*
		 * displays the board
		 */
		
		for(int i=0; i<10; i++)
		{
			System.out.println();
			for(int j=0; j<10; j++)
				System.out.print("  "+mattrix[i][j]);
		}
	}
	
	public void initialize()
	{
		/*
		 * initializes board as per the given conditions
		 */
		
		for(int i=0; i<10; i++)
		{
			for(int j=0; j<10; j++)
			{
				mattrix[i][j]='o';
			}
		mattrix[3][3]=mattrix[3][6]=mattrix[6][6]=mattrix[6][3]='K';
		mattrix[0][4]=mattrix[4][0]=mattrix[0][5]=mattrix[5][0]=' ';
		mattrix[1][1]=mattrix[1][2]=mattrix[1][3]=mattrix[1][4]=' ';
		mattrix[1][5]=mattrix[1][6]=mattrix[1][7]=mattrix[1][8]=' ';
		mattrix[5][4]=mattrix[4][5]=mattrix[5][5]=mattrix[4][4]=' ';
		mattrix[9][4]=mattrix[9][5]=mattrix[4][9]=mattrix[5][9]=' ';
		mattrix[8][1]=mattrix[8][2]=mattrix[8][3]=mattrix[8][4]=' ';
		mattrix[8][5]=mattrix[8][6]=mattrix[8][7]=mattrix[8][8]=' ';
		 }
	 }
	
	public void block(int i, int j)
	{
		/*
		 * blocks the adjoining cells on the chess board
		 */
		
		if(i>0 && mattrix[i-1][j]!=' ')
			mattrix[i-1][j]='-';
		if(i>0 && j<9 && mattrix[i-1][j+1]!=' ')
			mattrix[i-1][j+1]='-';
		if(j>0 && i<9 && mattrix[i+1][j-1]!=' ')
			mattrix[i+1][j-1]='-';
		if(j>0 && mattrix[i][j-1]!=' ')
			mattrix[i][j-1]='-';
		if(i<9 && j<9 && mattrix[i+1][j+1]!=' ')
			mattrix[i+1][j+1]='-';
		if(j<9 && mattrix[i][j+1]!=' ')
			mattrix[i][j+1]='-';
		if(i<9 && mattrix[i+1][j]!=' ')
			mattrix[i+1][j]='-';
		if(i>1 &&j>1 && mattrix[i-1][j-1]!=' ')
			mattrix[i-1][j-1]='-';
	}
	
	public void placeKing()
	{
		/*
		 *Places the king on the board 
		 */
		
		while(p<10 && k<10)
		{
			if(mattrix[p][k]=='o')			/*o is the red/orange square
											on given board*/
			{
				mattrix[p][k]='k';
				counter++;
				board.block(p,k);			/*method block called
				 							on board(object of class Board)*/
				if(++k==10)
				{
					p++;
					k=0;
				}
				placeKing();				/* recursion (method is called
											from within)*/
			}
			else if(mattrix[p][k]=='-' || mattrix[p][k]==' ' 
														|| mattrix[p][k]=='K')
			{
				if(++k==10)
				{
					p++;
					k=0;
				}
				placeKing();
			}
		}
	}
	
	public static void main (String args[])
	{
		/*
		 * main method
		 */
		
		p=0;k=0;							// initializes p and k
		board.initialize();
		System.out.println("Initial Board:");
		board.display();					//method call
		System.out.println("\nK= Fixed King positions\no= Orange/Red space\n");
		System.out.print("\n\nNew King positions 'k' are as follows:");
		for(int i=0; i<10; i++)
			for( int j=0; j<10; j++)
				if(mattrix[i][j]=='K')
					board.block(i,j);		/* blocks adjoining cells
											of initial Kings*/
		board.placeKing();
		System.out.println("\n");
		board.display();
		System.out.println("\n\nThe total number of kings that can be placed "
				+ "on the board are: "+counter+"\nThe total number of kings"
						+ " on the board are: "+(counter+4)+"\n");
	}
}
