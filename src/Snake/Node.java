package Snake;

public class Node 
{
	private int row;
	private int col;
	Node(int row,int col)
	{
		this.row = row;
		this.col = col;
	}
	public int getRow()
	{
		return row;
	}
	public int getCol()
	{
		return col;
	}
}
