package Bircks;
import java.util.*;
public class Main {
	public static void main(String[] args)
	{
		BrickBreaker b = new BrickBreaker(7,7);
		b.placeBricks(2,2,2);
		b.placeBricks(2,3,2);
		b.placeBricks(2,4,2);
		b.placeBricks(3,2,2);
		b.placeBricks(3,3,2);
		b.placeBricks(3,4,2);
		
		while(true)
		{
			b.print();
			
			if(b.getBallLife() <= 0)
			{
				System.out.println("Ball life Over");
				System.exit(0);
			}
			
			System.out.print("Enter the Direction for the ball : ");
			Scanner s  = new Scanner(System.in);
			String direction = s.nextLine();
			
			switch(direction)
			{
			case "lt":
			{
				int[] ballPos = b.getBallPosition();
				b.initiateBall(ballPos[0],ballPos[1],-1,-1);
			}
			break;
			case "rt":
			{
				int[] ballPos = b.getBallPosition();
				b.initiateBall(ballPos[0],ballPos[1],-1,1);
			}
			break;
			case "st":
			{
				int[] ballPos = b.getBallPosition();
				b.initiateBall(ballPos[0],ballPos[1],-1,0);
			}
			break;
			default:
			{
				System.out.println("Enter the Correct Oppsition");
			}
			break;
			}
		}
	}

}
