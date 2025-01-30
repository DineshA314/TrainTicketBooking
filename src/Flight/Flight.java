package Flight;
import java.util.*;
public class Flight {
	
	static int id =0;
	
	int flightId;
	int ticket;
	int price;
	
	ArrayList<String> passengerDetail = new ArrayList<String>();;
	ArrayList<Integer> passengerID = new ArrayList<>();
	ArrayList<Integer> bookTicketPerPerson = new ArrayList<>();
	ArrayList<Integer> costPrice = new ArrayList<>();
	
	public Flight() 
	{
		ticket = 50;
		price =5000;
		id = id +1;
		flightId = id;
		
	}
	
	public void addPassengerDetails(String passengerDetails, int numticket, int passengerId )
	{
		 passengerDetail.add(passengerDetails);
		 passengerID.add(passengerId);
		 costPrice.add(price*numticket);
		 bookTicketPerPerson.add(numticket);
		 
		 price += 200 * numticket;
		 
		 ticket-= numticket;
		 
		 
		
		 System.out.println("booked is successfully");
		 
		 
	}
	
	public void cancelTicket(int id)
	{
		int indexToRemove= passengerID.indexOf(id);
		
		if(indexToRemove < 0)
		{
			System.out.println("Passenger Id not found");
			return;
		}
		
		int ticketToCancel= bookTicketPerPerson.get(indexToRemove);
		
		ticket += ticketToCancel;
		price -= 200 * ticketToCancel;
		System.out.println("Refund amout is "+costPrice.get(indexToRemove));
		passengerDetail.remove(indexToRemove);
		passengerID.remove(Integer.valueOf(id));
		costPrice.remove(indexToRemove);
		bookTicketPerPerson.remove(indexToRemove);
		System.out.println("Cancel the ticket Successfull");
		
		
	}
	
	public void printDetails()
	{
		System.out.println("flightId " +flightId);
		for(String detail: passengerDetail)
		{
			System.out.println(detail);	
		}
	}
	

}
