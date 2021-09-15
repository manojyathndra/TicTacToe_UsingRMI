
import java.rmi.*;
import java.rmi.server.*;
import java.util.*;
@SuppressWarnings("serial")
public class HelloImpl extends UnicastRemoteObject implements HelloInterface { 
	public HelloImpl() throws RemoteException {
    super( );
  }
  	static void printBoard(char[] b) 
	{ 
		System.out.println("\t" + b[0] + "   " + b[1] + "   " + b[2] + "   "); 
		System.out.println("\t" + b[3] + "   " + b[4] + "   " + b[5] + "   "); 
		System.out.println("\t" + b[6] + "   " + b[7] + "   " + b[8] + "   "); 
	}
  	@SuppressWarnings("resource")
    public char[] board(char[] a) throws RemoteException {
		Scanner in=new Scanner(System.in);
		printBoard(a);
			System.out.println("Enter Cell Number");
			int val=in.nextInt();
			if (a[val] !='X' && a[val]!='O') { 		
				a[val]='O';
			}
			else{
				System.out.println( "cell is already taken");
				val=in.nextInt();
				a[val]='O';
			}
		return a;
	}   
}



