package Snake;
import java.util.*;
public class Snake {
	
    static char[][] snakeBoard = null;
    Queue<Node> queue = new LinkedList<>();
    
     Snake(int row, int col)
	{
		this.snakeBoard = new char [row][col];
		this.queue.add(new Node(0,0));
		for(int i=0; i<row; i++)
		{
			for(int j=0; j<col; j++)
			{
				this.snakeBoard[i][j]='0';
			}
		}
		this.snakeBoard[1][0] = 'X';
		this.snakeBoard[2][2] = 'X';
		this.snakeBoard[3][4] = 'X';
		this.snakeBoard[5][2] = 'X';
	}
	
	public void snakeMove(int row, int col)
	{
		if(row >= 0 && col >= 0 && row < snakeBoard.length && col < snakeBoard.length)
		{
			if(snakeBoard[row][col] == '.')
			{
				System.out.println("Game Over");
				System.exit(0);
			}
			
			queue.add(new Node(row,col));
			
			if(snakeBoard[row][col] != 'X')
			{
				Node node  = queue.poll();
				int row1 = node.getRow();
				int col1 = node.getCol();
				snakeBoard[row1][col1] = '0';
			}
			snakeBoard[row][col] = '.';
			
			while(!queue.isEmpty())
			{
				print();
				System.out.print("Enter the position : ");
				Scanner s  = new Scanner(System.in);
				char direction = s.next().charAt(0);
				
				if(direction =='U')
				{
					snakeMove(--row,col);
				}
				if(direction =='D')
				{
					snakeMove(++row,col);
				}
				if(direction =='R')
				{
					snakeMove(row,++col);
				}
				if(direction =='L')
				{
					snakeMove(row,--col);
				}
				
			}
		}
		else
		{
			 System.out.println("Invalid move");
	            System.exit(0);
			
		}
		
	}
	
	public void print()
	{
		for(char[] chars : snakeBoard)
		{
			for(int i=0;i<snakeBoard[0].length; i++)
			{
				System.out.print(chars[i]+" ");
			}
			System.out.println();
		}
	}
}
