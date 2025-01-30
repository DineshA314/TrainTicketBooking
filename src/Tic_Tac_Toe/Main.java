package Tic_Tac_Toe;
import java.util.*;
public class Main {
	static char[][] board ;
	static int n;
	static char currentPlayer;
	
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		System.out.print("Matrix n : ");
		n = s.nextInt();
		fix(n);
		int rowX =0;
		int colX = 0;
		int rowO =0;
		int colO=0;
		int move=0;
		boolean loop = true;
		boolean find = true;
		while(loop)
		{
			print();
			find = true;
			while(find)
			{
				System.out.printf("Player X, enter your move (row and col) : ");
				rowX = s.nextInt();
				colX = s.nextInt();
				find = check(rowX,colX);
			}
			set(rowX,colX,'X');
			print();
			move+=1;
			if(move >= 5 && win('X'))
			{
				System.out.print("Player X is ***** WINNER *****");
				break;
			}
			if(move >= n*n)
			{
				break;
			}
			find = true;
			while(find)
			{
				System.out.print("Player O, enter your move (row and col) : ");
				rowO = s.nextInt();
				colO = s.nextInt();
				find = check(rowO,colO);
			}
			set(rowO,colO,'O');
			move+=1;
			if(move >= 5 && win('O'))
			{
				System.out.print("Player O is ***** WINNER *****");
				break;
			}
			
	
		
				
				
		}
		
		
		
		
	}
	
	public static boolean win(char c)
	{
		int count =0;
		for(int i=0; i<board.length; i++)
		{
			for(int j=0; j<board[0].length; j++)
			{
				if(board[i][j] == c)
				{
					count++;
				}
				else
				{
					count =0;
					break;
				}
				
			}
			if(count == 3)
			{
				return true;
			}
		}
		
		
		count =0;
		for(int i=0; i<board.length; i++)
		{
			for(int j=0; j<board[0].length; j++)
			{
				if(board[j][i] == c)
				{
					count++;
				}
				else
				{
					count =0;
					break;
				}
			}
			if(count == 3)
			{
				return true;
			}
		}
		
		
		count =0;
		for(int i=0; i<board.length; i++)
		{
			if(board[i][i]==c)
			{
				count++;
			}
		}
//		System.out.println(count+ "from");
		if(count == 3)
		{
			return true;
		}
		count =0;
		for(int i=board.length-1; i>=0; i--)
		{
			if(board[i][i]==c)
			{
				count++;
			}	
		}
//		System.out.println(count + "reve");
		if(count == 3)
		{
			return true;
		}
		return false;
	}
	
	public static void set(int i, int j,char c)
	{
		board[i][j] = c;
	}
	
	public static boolean check(int m, int n)
	{
		if(m >= 0 && n >= 0 && m < board.length && n < board[0].length && board[m][n] != 'X' && board[m][n]!='O')
		{
			return false;
		}
		return true;
	
	}
	
	
	public static void fix(int n)
	{
		board = new char[n][n]; 
		
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<n; j++)
			{
				board[i][j]= '_';
			}
		}
	}
	
	public static void print()
	{
		for(int i=0; i<board.length; i++)
		{
			for(int j=0; j<board[0].length; j++)
			{
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
		
	}


}
