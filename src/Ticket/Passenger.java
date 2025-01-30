package Ticket;

public class Passenger {
	
	static int id =0;
	int passengerId ;
	String name;
	int age;
	String berthPreference;
	String alloted;
	int number;
	
	Passenger(String name, int age, String berthPreference )
	{
		this.name = name;
		this.age = age;
		this.berthPreference = berthPreference;
		id = id +1;
		this.passengerId = id;
		this.number = 0;
		this.alloted = "";
	}

}
