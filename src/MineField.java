import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MineField {
	private String[][] field;
	
	public String[][] generateMineField(Scanner sc) {
		int userEntry = Validator.getInt(sc, "How large would you like the mine field?");
		field = new String[userEntry][userEntry];
		for(String[]row: field) {
			Arrays.fill(row, "O");
		}
		return field;
		
	}

	
	public String[][]fillMineField(String[][] arr){
		Random rand = new Random();
		int mines = 20;
		while (mines > 0) {
			 int randomInteger = (int) (rand.nextDouble() * arr.length);
		        int randomInteger2 = (int) (rand.nextDouble() * arr[0].length);
		        if (arr[randomInteger][randomInteger2].equals("X")) {
		        	continue;
		        }else{
		        	  arr[randomInteger][randomInteger2] = "X";
			            mines--;
		        }
		}
		return arr;
		
	}
	
	public String [][] blankBoard(String[][] board){
		String[][] blank = new String[board.length][board.length];
		for(String[]row: blank) {
			Arrays.fill(row, "\u2B1c");
		}
		return blank;
	}
	
	public void displayField(String[][] arr, boolean flag) {
		if(flag == true) {
		for(int i = 0; i< arr.length; i++) {
			System.out.print("   ");
			for(int j = 0; j < arr.length; j++) {
				System.out.printf("%-3s", arr[i][j]);
			}
			System.out.print("\n");
		}}else {
			System.out.print("    ");
			for(int k = 0; k< arr.length; k++) {
				System.out.printf("%-3s",(k + 1));
			}
			System.out.print("\n");
			for(int i = 0; i< arr.length; i++) {
				System.out.printf("%-3s", (i + 1));
				for(int j = 0; j < arr.length; j++) {
					System.out.printf("%-2s",arr[i][j]);
				}
				System.out.print("\n");
		}
		}
		
	}
	
	public void setEqual(int a, int b, String [][]field, String[][]board) {
		board[a][b] = field[a][b];
	}
	
	public boolean checkBox(Scanner sc, String [][]field, String[][]board) {
		String flag = Validator.getString(sc, "Place a flag? (y/n) :");
		if (flag.equals("BlackSheepWall")){
			displayField(field, true);
			return true;
		}
		else if(flag.equals("y")) {
			int row = Validator.getInt(sc, "Please enter the row number: ", 1, field.length);
			int col = Validator.getInt(sc, "Please enter the column number: ", 1, field.length);
			row = row - 1;
			col = col - 1;
			board[row][col] = "\u2690";
			return true;
		}else {
		int row = Validator.getInt(sc, "Please enter the row number: ", 1, field.length);
		int col = Validator.getInt(sc, "Please enter the column number: ", 1, field.length);
		row = row - 1;
		col = col - 1;
		if(field[row][col].equals("X")) {
			System.out.println("Game Over");
			displayField(field, true);
			return false;
		}else if(field[row][col].equals("0")){
			setEqual(row, col, field, board);
			if(row == 0 && col == 0) {
				if(!field[row+1][col].equals("X")) {
					setEqual(row+1, col, field, board);
				}if(!field[row][col+1].equals("X")) {
					setEqual(row, col+1, field, board);
				}if(!field[row+1][col+1].equals("X")) {
					setEqual(row+1, col+1, field, board);;
				}
			}else if(row == 0 && col == (field.length-1)) {
				if(!field[row+1][col].equals("X")) {
					setEqual(row+1, col, field, board);;
				}if(!field[row+1][col-1].equals("X")) {
					setEqual(row+1, col-1, field, board);;
				}if(!field[row][col-1].equals("X")) {
					setEqual(row, col-1, field, board);;
				}
			}else if(row == 0) {
				if(!field[row+1][col].equals("X")) {
					setEqual(row+1, col, field, board);
				}if(!field[row][col+1].equals("X")) {
					setEqual(row, col+1, field, board);
				}if(!field[row+1][col+1].equals("X")) {
					setEqual(row+1, col+1, field, board);
				}if(!field[row][col-1].equals("X")) {
					setEqual(row, col-1, field, board);
				}if(!field[row+1][col-1].equals("X")) {
					setEqual(row+1, col-1, field, board);
				}
			}else if(row == (field.length-1) && col == 0) {
				if(!field[row-1][col].equals("X")) {
					setEqual(row-1, col, field, board);
				}if(!field[row][col+1].equals("X")) {
					setEqual(row, col+1, field, board);
				}if(!field[row-1][col+1].equals("X")) {
					setEqual(row-1, col+1, field, board);;
				}
			}else if (row == (field.length-1) && col == (field.length-1)) {
				if(!field[row-1][col].equals("X")) {
					setEqual(row-1, col, field, board);;
				}if(!field[row-1][col-1].equals("X")) {
					setEqual(row-1, col-1, field, board);
				}if(!field[row][col-1].equals("X")) {
					setEqual(row, col-1, field, board);
				}
			}else if(row == (field.length-1)) {
				if(!field[row+1][col].equals("X")) {
					setEqual(row+1, col, field, board);
				}if(!field[row][col-1].equals("X")) {
					setEqual(row, col-1, field, board);
				}if(!field[row+1][col-1].equals("X")) {
					setEqual(row+1, col-1, field, board);
				}if(!field[row-1][col].equals("X")) {
					setEqual(row-1, col, field, board);
				}if(!field[row-1][col-1].equals("X")) {
					setEqual(row-1, col-1, field, board);
				}
			}else if(col == 0) {
				if(!field[row+1][col].equals("X")) {
					setEqual(row+1, col, field, board);
				}if(!field[row][col+1].equals("X")) {
					setEqual(row, col+1, field, board);
				}if(!field[row+1][col+1].equals("X")) {
					setEqual(row+1, col+1, field, board);
				}if(!field[row-1][col+1].equals("X")) {
					setEqual(row-1, col+1, field, board);
				}if(!field[row-1][col].equals("X")) {
					setEqual(row-1, col, field, board);
				}
			}else if(row == (field.length-1)) {
				if(!field[row][col-1].equals("X")) {
					setEqual(row, col-1, field, board);
				}if(!field[row][col+1].equals("X")) {
					setEqual(row, col+1, field, board);
				}if(!field[row-1][col+1].equals("X")) {
					setEqual(row-1, col+1, field, board);
				}if(!field[row-1][col-1].equals("X")) {
					setEqual(row-1, col-1, field, board);
				}if(!field[row-1][col].equals("X")) {
					setEqual(row-1, col, field, board);
				}
			}else {
				if(!field[row+1][col].equals("X")) {
					setEqual(row+1, col, field, board);
				}if(!field[row-1][col].equals("X")) {
					setEqual(row-1, col, field, board);
				}if(!field[row][col+1].equals("X")) {
					setEqual(row, col+1, field, board);
				}if(!field[row][col-1].equals("X")) {
					setEqual(row, col-1, field, board);
				}if(!field[row-1][col-1].equals("X")) {
					setEqual(row-1, col-1, field, board);
				}if(!field[row-1][col+1].equals("X")) {
					setEqual(row-1, col+1, field, board);
				}if(!field[row+1][col+1].equals("X")) {
					setEqual(row+1, col+1, field, board);
				}if(!field[row+1][col-1].equals("X")) {
					setEqual(row+1, col-1, field, board);
				}
			}
			return true;
		}else {
			board[row][col] = field[row][col];
			return true;
		}
		}
	}
	
	public void numberMineField(String[][] arr) {
		for(int i = 0; i< arr.length; i++) {
			for(int j = 0; j < arr.length; j++) {
				if(arr[i][j].equals("X")) {
					continue;
				}else {
					int counter = 0;
					if(i == 0 && j == 0) {
						if(arr[i+1][j].equals("X")) {
							counter++;
						}if(arr[i][j+1].equals("X")) {
							counter++;
						}if(arr[i+1][j+1].equals("X")) {
							counter++;
						}
					}else if(i == 0 && j == (arr.length-1)) {
						if(arr[i+1][j].equals("X")) {
							counter++;
						}if(arr[i+1][j-1].equals("X")) {
							counter++;
						}if(arr[i][j-1].equals("X")) {
							counter++;
						}
					}else if(i == 0) {
						if(arr[i+1][j].equals("X")) {
							counter++;
						}if(arr[i][j+1].equals("X")) {
							counter++;
						}if(arr[i+1][j+1].equals("X")) {
							counter++;
						}if(arr[i][j-1].equals("X")) {
							counter++;
						}if(arr[i+1][j-1].equals("X")) {
							counter++;
						}
					}else if(i == (arr.length-1) && j == 0) {
						if(arr[i-1][j].equals("X")) {
							counter++;
						}if(arr[i][j+1].equals("X")) {
							counter++;
						}if(arr[i-1][j+1].equals("X")) {
							counter++;
						}
					}else if (i == (arr.length-1) && j == (arr.length-1)) {
						if(arr[i-1][j].equals("X")) {
							counter++;
						}if(arr[i-1][j-1].equals("X")) {
							counter++;
						}if(arr[i][j-1].equals("X")) {
							counter++;
						}
					}else if(j == (arr.length-1)) {
						if(arr[i+1][j].equals("X")) {
							counter++;
						}if(arr[i][j-1].equals("X")) {
							counter++;
						}if(arr[i+1][j-1].equals("X")) {
							counter++;
						}if(arr[i-1][j].equals("X")) {
							counter++;
						}if(arr[i-1][j-1].equals("X")) {
							counter++;
						}
					}else if(j == 0) {
						if(arr[i+1][j].equals("X")) {
							counter++;
						}if(arr[i][j+1].equals("X")) {
							counter++;
						}if(arr[i+1][j+1].equals("X")) {
							counter++;
						}if(arr[i-1][j+1].equals("X")) {
							counter++;
						}if(arr[i-1][j].equals("X")) {
							counter++;
						}
					}else if(i == (arr.length-1)) {
						if(arr[i][j-1].equals("X")) {
							counter++;
						}if(arr[i][j+1].equals("X")) {
							counter++;
						}if(arr[i-1][j+1].equals("X")) {
							counter++;
						}if(arr[i-1][j-1].equals("X")) {
							counter++;
						}if(arr[i-1][j].equals("X")) {
							counter++;
						}
					}else {
						if(arr[i+1][j].equals("X")) {
							counter++;
						}if(arr[i-1][j].equals("X")) {
							counter++;
						}if(arr[i][j+1].equals("X")) {
							counter++;
						}if(arr[i][j-1].equals("X")) {
							counter++;
						}if(arr[i-1][j-1].equals("X")) {
							counter++;
						}if(arr[i-1][j+1].equals("X")) {
							counter++;
						}if(arr[i+1][j+1].equals("X")) {
							counter++;
						}if(arr[i+1][j-1].equals("X")) {
							counter++;
						}
					}
					
					arr[i][j] = Integer.toString(counter);
				}
			}
			
		}
	}

}
