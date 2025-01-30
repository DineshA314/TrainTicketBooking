package TrainTicketBooking;
import java.util.*;

public class TicketBooker {
	
	static int availableLowerBerths =0;
	static int availableMiddleBerths = 0;
	static int availableUpperBerths = 01;
	static int availableRacTickets = 1;
	static int availableWaitingList = 1;
	
	static Queue<Integer> waitingList = new LinkedList<>();
	static Queue<Integer> racList = new LinkedList<>();
	static List<Integer> bookedTicketList = new ArrayList<>();
	
	static List<Integer> lowerBerthsPositions = new ArrayList<>(Arrays.asList(1));
	static List<Integer> middleBerthsPositions = new ArrayList<>(Arrays.asList(1));
	static List<Integer> upperBerthsPositions = new ArrayList<>(Arrays.asList(1));
	static List<Integer> racPositions = new ArrayList<>(Arrays.asList(1));
	static List<Integer> waitingListPositions = new ArrayList<>(Arrays.asList(1));
	
	static Map<Integer,passenger> passengers = new HashMap<>();
	
	//booking ticket
	public void bookTicket(passenger p, int berthInfo, String allotedberth)
	{
		p.number = berthInfo;
		p.alloted = allotedberth;
		
		passengers.put(p.passengerId, p);
		
		bookedTicketList.add(p.passengerId);
		
		System.out.println("--------------------BOOK SUCCESSFULLY--------");
	}
	
	//adding rac
	public void addToRAC(passenger p, int racInfo, String allotedRac)
	{
		p.number = racInfo;
		p.alloted = allotedRac;
		
		passengers.put(p.passengerId,p);
		racList.add(p.passengerId);
		availableRacTickets--;
		racPositions.remove(0);
		System.out.println("--------------------Added to RAC SUCCESSFULLY--------");
		 System.out.println(racList.size());
		
	}
	public void addToWaitingList(passenger p, int waitingListInfo, String allotedWl)
	{
		p.number = waitingListInfo;
		p.alloted = allotedWl;
		
		passengers.put(p.passengerId,p);
		waitingList.add(p.passengerId);
		availableWaitingList--;
		waitingListPositions.remove(0);
		System.out.println("--------------------Added to WL SUCCESSFULLY--------");
		
	}
	
	public void cancelTicket(int passengerId)
	{
		passenger p = passengers.get(passengerId);
		
		
        passengers.remove(Integer.valueOf(passengerId));
        //remove the booked ticket from the list
        

        //take the booked position which is now free
        int positionBooked = p.number;

        System.out.println("---------------cancelled Successfully");

        //add the free position to the correspoding type of list (either L,M,U)
        if(p.alloted.equals("L")) 
        { 
          availableLowerBerths++;
          lowerBerthsPositions.add(positionBooked);
          bookedTicketList.remove(Integer.valueOf(passengerId));
        }
        else if(p.alloted.equals("M"))
        { 
          availableMiddleBerths++;
          middleBerthsPositions.add(positionBooked);
          bookedTicketList.remove(Integer.valueOf(passengerId));
        }
        else if(p.alloted.equals("U"))
        { 
          availableUpperBerths++;
          upperBerthsPositions.add(positionBooked);
          bookedTicketList.remove(Integer.valueOf(passengerId));
        }
        else if(p.alloted.equals("RAC"))
        {
        	availableRacTickets++;
        	racPositions.add(positionBooked);
        	racList.remove(Integer.valueOf(passengerId));
        }
        else if(p.alloted.equals("WL"))
        {
        	availableWaitingList++;
        	waitingListPositions.add(positionBooked);
        	waitingList.remove(Integer.valueOf(passengerId));
        }
	
	
	
	if(racList.size() > 0)
    {
		
        passenger passengerFromRAC = passengers.get(racList.poll());
        int positionRac = passengerFromRAC.number; 
        racPositions.add(positionRac);

        racList.remove(Integer.valueOf(passengerFromRAC.passengerId));
        availableRacTickets++;

        
        if(waitingList.size()>0)
        {
           
            passenger passengerFromWaitingList = passengers.get(waitingList.poll());
            int positionWL = passengerFromWaitingList.number;
            waitingListPositions.add(positionWL);
            waitingList.remove(Integer.valueOf(passengerFromWaitingList.passengerId));

            passengerFromWaitingList.number = racPositions.get(0);
            passengerFromWaitingList.alloted = "RAC";
            racPositions.remove(0);
            racList.add(passengerFromWaitingList.passengerId);
            
            availableWaitingList++;
            availableRacTickets--;
        }
       
        Main.bookTicket(passengerFromRAC);
    }
	}

	    public void printAvailable()
	    {
	        System.out.println("Available Lower Berths "  + availableLowerBerths);
	        System.out.println("Available Middle Berths "  + availableMiddleBerths);
	        System.out.println("Available Upper Berths "  + availableUpperBerths);
	        System.out.println("Availabel RACs " + availableRacTickets);
	        System.out.println("Available Waiting List " + availableWaitingList);
	        System.out.println("--------------------------");
	    }
	    
	    
	    public void printPassengers()
	    {
	        if(passengers.size() == 0)
	        {
	            System.out.println("No details of passengers");
	            return;
	        }
	        for(passenger p : passengers.values())
	        {
	            System.out.println("PASSENGER ID " + p.passengerId );
	            System.out.println(" Name " + p.name );
	            System.out.println(" Age " + p.age );
	            System.out.println(" Status " + p.number + p.alloted);
	            System.out.println("--------------------------");
	        }
	    }
	 }

	


