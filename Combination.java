/**
* Combination.java
*
* @version   $Id: Combination.java,v_1.4 2014/09/02 19:37:00
*
* @author    hhk9433
* @author    ap8185
*
* Revisions:
* 
*		Initial revision
*		1.1  -  Stored binary numbers in array to denote
*				presence or absence of an object in set.
*		1.2  -  Removed storage of binary number in array
*				and tried to directly print sets.
*		1.3  -  Again added binary number to store presence
*				and absence of an object in the set.
*		1.4  -  final touch ups and re arranging of output
*				and other components of program
*/

	/* this program should produce all possible combination
	 *  of subsets of system generated objects( no of objects are hard coded )
	 *  
	 *  @aurthor	Hrishikesh Karale
	 *  @aurthor	Atir Petkar
	 */

import java.lang.Math;
class Combination
{	
	static int n=4, a;					// n=no of objects
	static int temp=0;					// used to generate initial objects
	static int d;						// d is max no of combinations
	static String s[];					// string array to hold objects
	static int [] binarchy;				/* used to store position of objects
	 									in set*/ 

	public void combi(int d, String[] s)
	{
		
		/* 
		 * This method generates and prints the objects of a subset
		 */
		
		int cc;							/* initialized to i in 'for' loop
										for decrementing without i getting
										affected*/
		binarchy = new int[n];			// used to store availability of object
		for( int i=0; i<n; i++)
			binarchy[i]=0;
		System.out.print("{ ");
		for( int i=0; i<d; i++)
		{
			cc=n-1;
			a=i;
			System.out.print(" {");
			do
			{
				binarchy[cc]=a%2;
				cc--;
				a=a/2;
			}while (a!=0);
			int count=0;
			for(int j=n-1; j>=0; j--)
			{
				if(binarchy[j]==1)
				{
					System.out.print
							(new Character( (char)(count+97) ).toString());
										// converts to string using ascii value
				}
				count++;
			}
			System.out.print("}");
		}
		System.out.print(" }");
	}
		

	public void objConstruct (int n)
	{
		/*
		 *auto generates required no of objects 
		 */
		
		int i=0;						// used to generate diff objects
		int checker=0;					/* used to generate unique
										initial objects*/
		for( int k=0; k<n; k++)
		{			
			s[k] = new Character( (char)(k+97) ).toString();// ascii to string
			if(temp==0 && k<26)
			{
				System.out.println( s[k]);
			}
			else
			{
				temp=1; 
				System.out.println( s[checker++]+i);
				if(checker==26)
				{
					i++;
					checker=0;
				}
			}
			
		}
	}

	public static void main (String args[])
	{		
		/*
		 * main method
		 */
		
		s= new String[n];					// stores objects
		d= (int)Math.pow( 2.0, n);			// no of combinations
		Combination cc = new Combination ();
		System.out.println("The objects automatically"
								+" generated are as follows: ");
		cc.objConstruct(n);					// call method objectConstruct
		System.out.println("Their Combinations are as follows:");
		cc.combi(d, s);						// calls method combi
	}
}		