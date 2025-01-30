package Train_2;

public class Passengers {
	
	static int id =1;
	int passengerId ;
	String source;
	String distination;
	int ticket;
	
	public Passengers(String source, String distination, int ticket)
	{
		this.source = source;
		this.distination = distination;
		this.ticket = ticket;
		this.passengerId = id++;
		
	}
	

}
