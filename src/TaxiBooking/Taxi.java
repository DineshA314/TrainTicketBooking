package TaxiBooking;
import java.util.*;

public class Taxi {
	
	static int taxiCount =0;
	int id;
	char currentSpot;
	int freeTime;
	int totalEarning;
	List<String> trips;
	
	public Taxi()
	{
		currentSpot ='A';
		freeTime = 6;
		totalEarning =0;
		taxiCount +=1;
		id=taxiCount;
		trips = new ArrayList<>();
		
	}
	
	public void setDetails(char currentSpot, int freeTime, int totalEarning, String tripDetails)
	{
		this.currentSpot = currentSpot;
		this.freeTime = freeTime ;
		this.totalEarning = totalEarning;
		this.trips.add(tripDetails);
		
	}
	
	public void printDetails()
	{
		System.out.println("taxiId = "+ this.id+"      "+"Earning = "+this.totalEarning);
		System.out.println("TaxiID    BookingId    CusmtorId    From    To    PickupTime    DropTime    Amount");
		
		for(String trip : trips )
		{
			
			System.out.println(id+"       "       + trip);
		}
		
	}
	 public void printTaxiDetails()
	    {
	        //print total earningand taxi details like current location and free time
	        System.out.println("Taxi - "+ this.id + " Total Earnings - " + this.totalEarning + " Current spot - " + this.currentSpot +" Free Time - " + this.freeTime);
	    }
	    
	
		
	


	
	

}
