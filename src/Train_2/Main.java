package Train_2;
import java.util.*;
public class Main 
{
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		boolean loop =true;
		
		while(loop)
		{
			System.out.print("1.book \n2.cancel \n3.print chart \n4.exist \nEnter the choice : ");
			int choice = s.nextInt();
			
			switch(choice)
			{
				case 1:
				{
					System.out.print("Enter the Source : ");
					String source = s.next();
					System.out.print("Enter the Destinations : ");
					String destination = s.next();
					System.out.print("Enter the Ticket : ");
					int ticket = s.nextInt();
					
					
				}
				break;
				case 2:
				{
					
				}
				break;
				case 3:
				{
					
				}
				break;
				case 4:
				{
					loop =false;
				}
				break;	
			
			}
			
		}
		
	}
}
