package SudokuPuzzle;

public class Sudoku {
    int [][] board;
    int inner = 3;
	public Sudoku(int[][] board)
	{
		this.board = board;
		
	}
	public void print(int[][] board)
	{
		for(int i=0; i<board.length; i++)
		{
			if(i%inner ==0) System.out.println();
			for(int j=0; j<board[0].length;j++)
			{
				if(j % inner == 0 )System.out.print("  ");
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public boolean solve(int row, int col) {
		
		if(row == board.length)
		{
			col++;
			if(col== board.length)
			{
				return true;
			}
			else
			{
				row=0;
			}
		}
		
		if(board[row][col] != 0) return solve(row+1,col);
		
		for(int num=1; num<=board.length; num++)
		{
			if(isVailed(row,col,num))
			{
				board[row][col] = num;
				if(solve(row+1,col))return true;
				board[row][col] = 0;
			}
		}
		return false;
	}
	
	public boolean isVailed(int row,int col, int num)
	{
		for(int i=0; i<board.length; i++)
		{
			if(board[i][col] == num )
				return false;
		}
		
		for(int i=0; i<board.length; i++)
		{
			if(board[row][i] == num )
				return false;
		}
		
		int rowSta = (row/inner) * inner;
		int colSta = (col/inner) * inner;
		
		for(int i=rowSta; i<rowSta+inner ; i++)
		{
			for(int j=colSta; j<colSta+inner; j++)
			{
				if(board[i][j] == num )
					return false;
			}
			
		}
		
		return true;
	}
	
}
