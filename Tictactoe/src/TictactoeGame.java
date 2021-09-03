import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class TictactoeGame {
	static int counter = 1;
	static HashMap<Integer, Coordinate> coordinate = new HashMap<Integer, Coordinate>();
	public static void main(String[] args) {
		
		String[][] board = {{" ","|"," ","|"," "},
				          {"-"," ","-"," ","-"},
				          {" ","|"," ","|"," "},
				          {"-"," ","-"," ","-"},
				          {" ","|"," ","|"," "},};
		printBoard(board);
		System.out.println("Please press 1-9 to placepiece on gameboard!");
		Scanner input = new Scanner(System.in);
		do{
			if(counter%2==1) {
				System.out.println("Please USER1 placepiece on gameboard!");
				int key = input.nextInt();
				placePiece(board, "user1", key);
				printBoard(board);
				if(check(board,coordinate.get(key).getCol(),coordinate.get(key).getRow())) {
					System.out.println("USER1 win !");
					break;
				}
			}
			else {
				System.out.println("Please USER2 placepiece on gameboard!");
				int key = input.nextInt();
				placePiece(board, "user2", key);
				printBoard(board);
				if(check(board,coordinate.get(key).getCol(),coordinate.get(key).getRow())) {
					System.out.println("USER2 win !");
					break;
				}
			}
			
			if(counter == 10) {
				System.out.println("Game Over, Nobody Win!");
			}
			
		}while(counter<=9);
	}
	
	public static void printBoard(String[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println("");
		}
	}
	
	public static void placePiece(String[][] board, String user, int position) {
		String symbol = "";
		
		coordinate.put(1, new Coordinate(4,0));
		coordinate.put(2, new Coordinate(4,2));
		coordinate.put(3, new Coordinate(4,4));
		coordinate.put(4, new Coordinate(2,0));
		coordinate.put(5, new Coordinate(2,2));
		coordinate.put(6, new Coordinate(2,4));
		coordinate.put(7, new Coordinate(0,0));
		coordinate.put(8, new Coordinate(0,2));
		coordinate.put(9, new Coordinate(0,4));
		symbol = (user.equals("user1")) ? "X" : "O";
		String pos = board[coordinate.get(position).getCol()][coordinate.get(position).getRow()];
		if(pos.equals(" ")) {
			board[coordinate.get(position).getCol()][coordinate.get(position).getRow()] = symbol;
			counter++;
		}else {
			System.out.println("The position has been taken!");
		}

	}
	
	public static boolean check(String[][] board, int x, int y) {
		String col = "";
		String row = "";
		String leftCross = "";
		String rightCross = "";
        boolean flag = false;
		//check column
		for (int i = 0; i < board.length; i++) {
			if(i%2==0) {
		     col += board[x][i];
			}
		}
		if(col.equals("OOO") || col.equals("XXX")) {
			flag = true;
		}
		
		//check row
		for (int i = 0; i < board.length; i++) {
			if(i%2==0) {
			  row += board[i][y];
			}
		}
		if(row.equals("OOO") || row.equals("XXX")) {
			flag = true;
		}
		
		//check leftCross
		leftCross = board[4][0]+board[2][2]+board[0][4];
		if(leftCross.equals("OOO") || leftCross.equals("XXX")) {
			flag = true;
		}
		
		//check rightCross
		rightCross = board[0][0]+board[2][2]+board[4][4];
		if(rightCross.equals("OOO") || rightCross.equals("XXX")) {
			flag = true;
		}
		
		return flag;
	}
	
}

class Coordinate{
	private int col;
	private int row;
	
	public Coordinate(int col, int row) {
		setCol(col);
		setRow(row);
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}
	
	
}
