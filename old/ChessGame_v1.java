import java.util.InputMismatchException;
import java.util.Scanner;

public class ChessGame {
	public static void main(String[] args) {
		newPiece();
	}
	
    //newPiece Method to start the program (questions)
	public static void newPiece() {
		Scanner input = new Scanner(System.in);
		boolean newPiece = true;
        boolean continuePiece = true;
		
		while(newPiece) {
			
			try {
				//Object piece;
				
				char targetX;
				int targetY;
				
				piece = pieceInfo(input);
				printPieceInfo(piece);
				
				System.out.println("Enter the target column (A-H): ");
				targetX = input.next().toUpperCase().charAt(0);
				
				if(!isLetter(targetX)) {
					continue;
				}
				
				System.out.println("Enter the target row (1-8): ");
				targetY = input.nextInt();
				
				while (continuePiece) {
                    char currentX = 'A';
                    int currentY = 1;
    
                    System.out.println("Please enter the new Destination for X (A to H):");
                    String checkDesX = input.nextLine().trim().toUpperCase();
    
                    if (checkDesX.length() == 1) {
                        char boundsDesX = checkDesX.charAt(0);
                        if (boundsDesX >= 'A' && boundsDesX <= 'H') {
                            currentX = boundsDesX;
                        } else {
                            System.out.println("Invalid input. Destination X must be between A and H.");
                            continue;
                        }
                    } else {
                        System.out.println("Invalid input. Please enter a single character (A to H).");
                        continue;
                    }
    
                    System.out.println("Please enter the new Destination for Y (number):");
    
                    try {
                        currentY = input.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a whole number.");
                        input.nextLine();
                        continue;
                    }
    
                    input.nextLine();
       
                    if ((name)piece.validMove(currentX, currentY)) {
                        System.out.println(piece.getName() + " at " + piece.getPosX() + piece.getPosY() + " can move to " + currentX + currentY);
                    } else {
                        System.out.println(piece.getName() + " at " + piece.getPosX() + piece.getPosY() + " cannot move to " + currentX + currentY);
                    }
    
                    System.out.println("Do you want to continue with this piece? (Y/N)");
                    String cont = input.nextLine().trim().toUpperCase();
                    continuePiece = cont.equals("Y") || cont.equals("YES");
                }
    
                System.out.println("Do you want to select another piece? (Y/N)");
                String contPiece = input.nextLine().trim().toUpperCase();
    
                if (contPiece.equals("Y") || contPiece.equals("YES")) {
                    newPiece = true;
                } else {
                    newPiece = false;
                }
				while(true) {
					System.out.println("Would you like to choose a new piece to try (Yes or No)?");
					if(input.nextLine().toUpperCase().equals("NO")) newPiece = false;	
					if(input.nextLine().toUpperCase().equals("Yes")) break;
				}
				input.nextLine();
			
			}
			catch(InputMismatchException e) {
				System.out.println("Please enter a number (1-8)");
				input.nextLine();
				continue;
			}
			catch(Exception e) {
				System.out.println("Something went wrong: " + e);
				input.nextLine();
			}
		}	
	}
	// public static boolean validPiece(String pieceType) {
		
	// 	try {
	// 		Pieces piece = Pieces.valueOf(pieceType);
	// 		switch(piece) {
	// 			case ROOK, PAWN, BISHOP, QUEEN, KING, KNIGHT:
	// 				return true;
	// 		}
	// 	}catch(IllegalArgumentException e) {
	// 		System.out.println("Please enter a valid chess piece.");
	// 	}
	// 	return false;
	// }
	
	// public static Object createChessPiece(String name, String color, char x, int y) {
		
	// 	try {
	// 		Pieces piece = Pieces.valueOf(name);
			
	// 		switch(piece) {
	// 			case KING:
	// 				return new King(name, color, x, y);
	// 			case QUEEN:
	// 				return new Queen(name, color, x, y);
	// 			case BISHOP:
	// 				return new Bishop(name, color, x, y);
	// 			case KNIGHT:
	// 				return new Knight(name, color, x, y);
	// 			case ROOK:
	// 				return new Rook(name, color, x, y);
	// 			case PAWN:
	// 				return new Pawn(name, color, x, y);
	// 		}
	// 	}
	// 	catch(IllegalArgumentException e) {
	// 		System.out.println("Couldn't create chess piece.");
	// 	}
	// 	return null;
	// }
	
	// public static void printPieceInfo(Object piece) {
	// 	if(piece instanceof Pawn) {
	// 		((Pawn)piece).printPieceInfo();
	// 	}
	// 	else if (piece instanceof Knight) {
	// 		((Knight)piece).printPieceInfo();
	// 	}
	// 	else if (piece instanceof Rook) {
	// 		((Rook)piece).printPieceInfo();
	// 	}
	// 	else if (piece instanceof Bishop) {
	// 		((Bishop)piece).printPieceInfo();
	// 	}
	// 	else if (piece instanceof Queen) {
	// 		((Queen)piece).printPieceInfo();
	// 	}
	// 	else if (piece instanceof King) {
	// 		((King)piece).printPieceInfo();
	// 	}
	// }

	// public static boolean validColor(String color) {
	// 	if(color.equals("BLACK") || color.equals("WHITE")) return true;
	// 	System.out.println("Please choose either Black or White.");
	// 	return false;
	// }
	// public static boolean isLetter(char col) {
	// 	if(!Character.isLetter(col)) {
	// 		System.out.println("Please enter a valid column (A-H)");
	// 		return false;
	// 	}
	// 	return true;
	// }
	// public static Object pieceInfo(Scanner input) {
		
	// 	String pieceType;
	// 	String pieceColor;
	// 	char pieceColumn;
	// 	int pieceRow;
		
	// 	while(true) {
	// 		System.out.println("Please enter the piece you'd like to use (ex. King, Queen, etc...): ");
	// 		pieceType = input.nextLine().toUpperCase().trim();
			
	// 		if(!validPiece(pieceType)) {
	// 			continue;
	// 		}
			
	// 		System.out.println("Enter the " + pieceType + "'s color (Black or White): ");
	// 		pieceColor = input.nextLine().toUpperCase().trim();
			
	// 		if(!validColor(pieceColor)) {
	// 			continue;
	// 		}
			
	// 		System.out.println("Enter the column you want your " + pieceType + " at (A-H): ");
	// 		String temp = input.next().toUpperCase();
			
	// 		if(temp.length() > 1) {
	// 			System.out.println("Please enter a valid column (A-H)");
	// 			input.nextLine();
	// 			continue;
	// 		}
			
	// 		pieceColumn = temp.charAt(0);
			
	// 		if(!isLetter(pieceColumn)) {
	// 			input.nextLine();
	// 			continue;
	// 		}
			
	// 		System.out.println("Enter the row you want your " + pieceType + " at (1-8): ");
	// 		pieceRow = input.nextInt();
			
	// 		return createChessPiece(pieceType, pieceColor, pieceColumn, pieceRow);
	// 	}
	// }
	
}
