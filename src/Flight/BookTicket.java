package Flight;
import java.util.*;
public class BookTicket {
	
	public static void book(Flight currentFlight, int ticket, int passengerId)
	{
		String passengerDetail ="";
		passengerDetail = "PassengerId " +passengerId +  "     " + "Number of ticket Booked " +ticket + "     " +"Total Amount " + currentFlight.price * ticket ;
		
		currentFlight.addPassengerDetails(passengerDetail,ticket,passengerId);
	}
	
	public static void cancel(Flight currentFlight,int id)
	{
		currentFlight.cancelTicket(id);
	}
	
	public static void print(Flight f)
	{
		f.printDetails();
		
	}
	
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		ArrayList<Flight> flights = new ArrayList<>();
		
		for(int i=0; i<2; i++)
		{
		    flights.add(new Flight());
		}
		
		int passengerId =1;
		
		while(true)
		{
			System.out.println("1.book \n 2.cancel \n 3.print ");
			int check = sc.nextInt();
			
			switch(check)
			{
			    case 1:
			    {
			    	System.out.println("Enter the Flight Id");
			    	int fid= sc.nextInt();
			    	
			    	if(fid > flights.size()) 
			    	{
			    		System.out.println("you enter the worng flight id");
			    		break;
			    	}
			    	
			    	Flight currentFlight = null;
			    	
			    	for(Flight f : flights)
			    	{
			    		if(f.flightId == fid)
			    		{
			    			currentFlight = f;
			    			//f.flightSummary();
			    			break;
			    		}
			    		
			    	}
			    	System.out.print("enter the ticket");
			    	
			    	int t= sc.nextInt();
			    	
			    	if(t > currentFlight.ticket)
			    	{
			    		System.out.println("no ticket available");
			    		break;
			    	}
			    	
			    	book(currentFlight,t,passengerId);
			    	passengerId +=1;
			    	break;
			    	
			    	
			    }
			    case 2:
			    {
			    	System.out.println("Enter the Flight Id");
			    	int fid= sc.nextInt();
			    	
			    	if(fid > flights.size()) 
			    	{
			    		System.out.println("you enter the worng flight id");
			    		break;
			    	}
			    	
			    	Flight currentFlight = null;
			    	
			    	for(Flight f : flights)
			    	{
			    		if(f.flightId == fid)
			    		{
			    			currentFlight = f;
			    			//f.flightSummary();
			    			break;
			    		}
			    		
			    	}
			    	System.out.println("Enter the PassengerID");
			    	int id=sc.nextInt();
			    	
			    	cancel(currentFlight,id);
			    	break;
			    	
			    }
			    //break;
			    case 3:
			    {
			    	for(Flight f:flights)
			    	{
			    		if(f.passengerDetail.size()==0)
			    		{
			    			System.out.println("no passenger");
			    		}
			    		else
			    		print(f);
			    		
			    	}
			    	
			    }
			    break;
			    default:
			    break;
			    
				
			
			}
		}
		
	}

}
