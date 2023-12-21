package TrainTicketBooking;
import java.util.Scanner;
public class Main {
	
		public static void bookTicket(passenger p)
		{
			TicketBooker booker = new TicketBooker();
			
			if(TicketBooker.availableWaitingList==0)
			{
				System.out.println("No ticket Avaiable");
				return ;
			}
			
			if((p.berthPreference.equals("L") && TicketBooker.availableLowerBerths >0)||
					(p.berthPreference.equals("M") && TicketBooker.availableMiddleBerths >0)||
					(p.berthPreference.equals("L") && TicketBooker.availableUpperBerths >0))
			{
				System.out.println("Preferred berth Avaiable ");
				
				if(p.berthPreference.equals("L"))
				{
					System.out.println(" Lower berth Given");
					
					booker.bookTicket(p,(TicketBooker.lowerBerthsPositions.get(0)),"L");
					TicketBooker.lowerBerthsPositions.remove(0);
					TicketBooker.availableLowerBerths--;
					
				}
				else if(p.berthPreference.equals("M"))
				{
					System.out.print(" Middle berth Given");
					
					booker.bookTicket(p,(TicketBooker.middleBerthsPositions.get(0)),"M");
					TicketBooker.middleBerthsPositions.remove(0);
					TicketBooker.availableMiddleBerths--;
					
				}
				else if(p.berthPreference.equals("U"))
				{
					System.out.print(" Upper berth Given");
					
					booker.bookTicket(p,(TicketBooker.upperBerthsPositions.get(0)),"U");
					TicketBooker.upperBerthsPositions.remove(0);
					TicketBooker.availableUpperBerths--;
					
				}
			}
			
			//available ticket booking
			
			else if(TicketBooker.availableLowerBerths > 0)
				{
					System.out.println(" Lower berth Given");
					
					booker.bookTicket(p,(TicketBooker.lowerBerthsPositions.get(0)),"L");
					TicketBooker.lowerBerthsPositions.remove(0);
					TicketBooker.availableLowerBerths--;
					
				}
				else if(TicketBooker.availableMiddleBerths > 0)
				{
					System.out.println(" Middle berth Given");
					
					booker.bookTicket(p,(TicketBooker.middleBerthsPositions.get(0)),"M");
					TicketBooker.middleBerthsPositions.remove(0);
					TicketBooker.availableMiddleBerths--;
					
				}
				else if(TicketBooker.availableUpperBerths > 0)
				{
					System.out.println(" Upper berth Given");
					
					booker.bookTicket(p,(TicketBooker.upperBerthsPositions.get(0)),"U");
					TicketBooker.upperBerthsPositions.remove(0);
					TicketBooker.availableUpperBerths--;
					
				}
				else if(TicketBooker.availableRacTickets > 0)
				{
					System.out.println("RAC Avaiable");
					booker.addToRAC(p,(TicketBooker.racPositions.get(0)),"RAC");
				}
				else if(TicketBooker.availableWaitingList>0)
				{
					System.out.println("WaitingList Avaiable");
					booker.addToWaitingList(p,(TicketBooker.waitingListPositions.get(0)),"WL");
				}
		
			
			
		}
	
		
		public static void cancelTicket(int id)
		{
			TicketBooker booker = new TicketBooker();
			
			if(!booker.passengers.containsKey(id))
			{
				System.out.println("passenger deetail Unknown");
			}
			else
			{
				booker.cancelTicket(id);
			}
		}
	
	
	
	
	
	
	
	
	
public static void main(String [] args)
{
	Scanner s = new Scanner(System.in);
	boolean loop=true;
	
	while(loop)
	{
		System.out.println("1.Book Ticker \n 2.Cancel Ticket \n 3.Avaiable Ticket \n 4.Booked Ticket \n 5.Eixt");
		int choice = s.nextInt();
		
		switch(choice)
		{
			case 1:
			{
				System.out.println("Enter the Passenger Detailes ");
				String name = s.next();
				int age = s.nextInt();
				String berthPreference = s.next();
				
				passenger p = new passenger(name,age,berthPreference);
				
				bookTicket(p);
			}
			break;
			case 2:
			{
				System.out.println("Enter the passenger id");
				int id = s.nextInt();
				cancelTicket(id);
			}
			break;
			case 3:
			{
				TicketBooker booker = new TicketBooker();
				booker.printAvailable();
			}
			break;
			case 4:
			{
				TicketBooker booker = new TicketBooker();
				booker.printPassengers();
			}
			break;
			case 5:
			{
				loop = false;
			}
			break;
			default:
			break;
		}
		
		
		
		
	}
			
}
}
