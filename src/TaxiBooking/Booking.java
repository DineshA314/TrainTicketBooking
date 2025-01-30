package TaxiBooking;
import java.util.*;
public class Booking {
	
	
	
	public static List<Taxi> createTaxi(int n)
	{
		List<Taxi> taxis = new ArrayList<>();
		for(int i=1; i<=n; i++ )
		{
			Taxi t = new Taxi();
			taxis.add(t);
			
		}
		return taxis;
	}
	
	public static List<Taxi> getFreeTaxis(List<Taxi> taxis,char pickUp, int time )
	{
		List<Taxi> freeTaxis = new ArrayList<>();
		for(Taxi t : taxis)
		{
			if(t.freeTime <= time && (Math.abs((t.currentSpot -'0')-(pickUp - '0')) <= time - t.freeTime ))
				freeTaxis.add(t);
		}
		return freeTaxis;
	}
	
	public static void bookTaxi(int id,char pickUp, int time, char drop, List<Taxi> freeTaxis)
	{
		int min=999;
		int distanceBetweenpickAnddrop=0;
		int earning=0;
		int nextFreeTime=0;
		char nextSpot ='\0';
		String tripDetails="";
		Taxi bookedTaxi = null;
		
		for(Taxi t : freeTaxis)
		{
			int distanceBetweenCustomerAndTaxi = Math.abs((t.currentSpot-'0')- (pickUp-'0'))*15;
			if(distanceBetweenCustomerAndTaxi< min)
			{
				bookedTaxi=t;
				
				distanceBetweenpickAnddrop = Math.abs((drop-'0') - (pickUp -'0'))*15;
				
				earning = (distanceBetweenpickAnddrop-5) * 10 + 100;
				
			    int dropTime = time + distanceBetweenpickAnddrop/15;
				
				nextFreeTime = dropTime;
				
				nextSpot = drop;
				
				
				tripDetails = id +"    "+ id +"    "+ pickUp +"    "+ drop +"    "+ time +"    "+ dropTime +"    "+ earning;
			}
		}
		bookedTaxi.setDetails(nextSpot, nextFreeTime,bookedTaxi.totalEarning + earning, tripDetails);
		
		System.out.println("Taxi " + bookedTaxi.id +" booked");
		
		
	}
	
	
	public static void main(String[] args)
	{
		List<Taxi> taxis = createTaxi(4);
		
		Scanner sc = new Scanner(System.in);
		int id=1;
		
		while(true)
		{
			System.out.println("1.Booking \n 2.print");
			int check = sc.nextInt();
			
			switch(check)
			{
			
				case 1:
				{
					int customerId = id;
					System.out.print("Pickup point = ");
					char pickUp = sc.next().charAt(0);
					System.out.print("drop point = ");
					char drop = sc.next().charAt(0);
					System.out.print("time  = ");
					int time = sc.nextInt();
					
					if( pickUp < 'A' || drop > 'F'|| pickUp>'F' || drop <'A' )
					{
						System.out.println("Enter the worng alphbet");
						return;
					}
					
					List<Taxi> freeTaxis = getFreeTaxis(taxis,pickUp,time);
					
					if(freeTaxis.size()==0)
					{
						System.out.println("no free taxis ");
						return ;
					}
					
					Collections.sort(freeTaxis,(a,b)-> a.totalEarning - b.totalEarning);
					
					bookTaxi(id,pickUp,time,drop, freeTaxis);
					id++;
					break;
						
					
				}
				case 2:
				{
					for(Taxi t : taxis)
					{
						t.printTaxiDetails();
					}
					for(Taxi t : taxis)
					{
						t.printDetails();
					}
					
				}
				default:
					return;
					
			
			}
			 
		}
	}

}
