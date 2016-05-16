/**
* OsNAme.java
*
* @version   $Id: OsName.java,v_1.0 2014/08/29 19:37:00
*
* @author    hhk9433
*
* Revisions:
* 
*		Initial revision
*/

	/* this program gives output as operating system name
	 *  
	 *  @aurthor	Hrishikesh Karale
	*/
 
import java.util.*;

/**
 * This program displays the name of the OS
 *
 * @author	Hrishikesh Karale hhk9433
 */

class OsName{
/**
 * The main program
 *
 * @param args command line arguments(ignored)
 */
	public static void main(String args[]){
		//Print name of os
		System.out.println("Os: "+System.getProperty("os.name"));
	}
}
