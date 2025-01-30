package Bircks;
import java.util.*;

public class BrickBreaker {
	
	private static String wall = "w";
	private static String brick = "1";
	private static String ground = "g";
	private static String ball = "o";
	
	private static Map<Integer,Integer> bricksWithLife = new HashMap<>();
	
	private static int[] ballPos = null;
	private static int ballLife = 5;
	
	private String[][] gameBord = null;
	
	BrickBreaker(int row, int col)
	{
		gameBord = new String[row][col];
		prepareBoard();
		
		gameBord[row-1][col/2] = ball;
		ballPos = new int[] {row-1,col/2};
	}
	
	public void prepareBoard()
	{
		for(int i=0; i<gameBord.length; i++)
		{
			for(int j=0; j<gameBord[0].length; j++)
			{
				if(i==0||j==0|| j == gameBord[0].length -1)
				{
					gameBord[i][j]=wall;
				}
				else if(i == gameBord.length -1)
				{
					gameBord[i][j]=ground;
				}
				else
				{
					gameBord[i][j]=" ";
				}
			}
		}
		
		//print(row,col);
	}
	
	public void placeBricks(int row,int col, int life)
	{
		gameBord[row][col] = brick;
		int exactPosition = getExactBallPosition(row,col);
		
		bricksWithLife.put(exactPosition, life);
	}
	
	
	public void initiateBall(int row,int col, int rowDir,int colDir)
	{
		moveDir(row,col,rowDir,colDir);
		
		if(!gameBord[row][col].equals(ball))
		{
			gameBord[row][col]=ground;
		}
		
		
	}
	private void moveDir(int row,int col, int rowDir,int colDir)
	{
		while(!gameBord[row][col].equals(wall))
		{
			if(gameBord[row][col].equals(brick))
			{
				ballGoesDown(row,col);
				return;
			}
			movingIllusion(row,col);
			row += rowDir;
			col += colDir;
		}
		
		wallHit(row,col);
		
		rowDir = 0;
		colDir = colDir*-1;
		
		if(colDir == 0)
		{
			ballGoesDown(row+1,col);
		}
		else
		{
			moveDir(row,col+colDir,rowDir,colDir);
		}
		
	}
	private void wallHit(int row, int col)
	{
		gameBord[row][col] = ball;
		print();
		sleepOneSec();
		gameBord[row][col] = wall;
		
	}
	private void movingIllusion(int row,int col)
	{
		if(gameBord[row][col].equals(brick))
		{
			reduceBrickAndBallLife(row,col);
			if(bricksWithLife.get(getExactBallPosition(row,col)) == 0)
			{
				gameBord[row][col] =" ";
			}
		}
			else
			{
				gameBord[row][col] =ball;
				print();
				gameBord[row][col] =" ";
				sleepOneSec();
			}
		
		
	}
	public void sleepOneSec()
	{
		try
		{
			Thread.sleep(1000);
		}
		catch(InterruptedException e)
		{
			e.getCause();
		}
	}
	public void reduceBrickAndBallLife(int row,int col)
	{
		int exactPos = getExactBallPosition(row , col);
		ballLife--;
		if(ballLife > 0)
		{
			bricksWithLife.put(exactPos, bricksWithLife.get(exactPos) -1);
		}
		
	}
	private void ballGoesDown(int row,int col)
	{
		while(row != gameBord.length) {
			movingIllusion(row,col);
			row++;
		}
		ballPos = new int[] {row-1,col};
		gameBord[ballPos[0]][ballPos[1]] = ball;
	}
	
	public void print() {
        for(String[] str : gameBord) {
            for(String s : str) {
                System.out.print(s+" ");
            }
            System.out.println();
        }
    }	
	public int getExactBallPosition(int row, int col)
	{
		return (row * gameBord[0].length) + col +1;
	}
    public int getBallLife()
    {
    	return ballLife;
    }
    public int[] getBallPosition()
    {
    	return ballPos;
    }

}
