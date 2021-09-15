
import java.rmi.*;
import java.util.*;
public class HelloClient{
	static String checkWinner(char[] c) 
	{ 
		for (int a = 0; a < 8; a++) { 
			String line = null; 
			switch (a) { 
			case 0: 
				line = String.valueOf(c[0]) + String.valueOf(c[1]) + String.valueOf(c[2]); 
				break; 
			case 1: 
				line = String.valueOf(c[3]) + String.valueOf(c[4]) + String.valueOf(c[5]); 
				break; 
			case 2: 
				line = String.valueOf(c[6]) + String.valueOf(c[7]) + String.valueOf(c[8]); 
				break; 
			case 3: 
				line = String.valueOf(c[0]) + String.valueOf(c[3]) + String.valueOf(c[6]); 
				break; 
			case 4: 
				line = String.valueOf(c[1]) + String.valueOf(c[4]) + String.valueOf(c[7]); 
				break; 
			case 5: 
				line = String.valueOf(c[2]) + String.valueOf(c[5]) + String.valueOf(c[8]); 
				break; 
			case 6: 
				line = String.valueOf(c[0]) + String.valueOf(c[4]) + String.valueOf(c[8]); 
				break; 
			case 7: 
				line = String.valueOf(c[2]) + String.valueOf(c[4]) + String.valueOf(c[6]); 
				break; 
			} 
			//For X winner 
			if (line.equals("XXX")) { 
				return "X"; 
			} 
			// For O winner 
			else if (line.equals("OOO")) { 
				return "O"; 
			} 
		} 
		//For Draw
		if (c[0]!='0' && c[1]!='1' && c[2]!='2' && c[3]!='3' && c[4]!='4' && c[5]!='5' && c[6]!='6' && c[7]!='7' && c[8]!='8'){
				return "draw";
			}
		return null; 
	} 
	static void printBoard(char[] b) 
	{ 
		System.out.println("\t" + b[0] + "   " + b[1] + "   " + b[2] + "   "); 
		System.out.println("\t" + b[3] + "   " + b[4] + "   " + b[5] + "   "); 
		System.out.println("\t" + b[6] + "   " + b[7] + "   " + b[8] + "   "); 
	}
	@SuppressWarnings("resource")
	public static void main(String args[]){
	char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8'};
	  try{
      int port = 16790;         
      String host = "localhost";
      String registryURL = "rmi://" + host + ":" + port + "/hello";
      HelloInterface h = (HelloInterface)Naming.lookup(registryURL);
	  Scanner in=new Scanner(System.in);
	  printBoard(a);
	  String winner=null;
	  while(winner==null){
			System.out.println("Enter Cell Number");
			int val=in.nextInt();
				try { 
					if (!(val >= 0 && val <= 8)) { 
					System.out.println("Invalid Cell number"); 
					continue; 
					} 
				} 
				catch (InputMismatchException e) { 
					System.out.println("Invalid Cell number"); 
					continue; 
				}
		  	if (a[val] !='X' && a[val]!='O') { 		
				a[val]='X';
			}
			else{
				System.out.println( "cell is already taken"); 
				continue;
			}
		  	winner = checkWinner(a);
			if(winner != null) {
				break;
			}
			char[] m=h.board(a);
			a=m;
			printBoard(m);	
		}
		if (winner.equalsIgnoreCase("draw")) { 
			printBoard(a);
			System.out.println( "It is a Tie"); 
			} 
		else { 
			System.out.println( "Winner Is: " + winner); 
			printBoard(a);
		}
	  }
    catch (Exception e){
      e.printStackTrace();
      System.out.println("ERROR");
    } 
  }
}

