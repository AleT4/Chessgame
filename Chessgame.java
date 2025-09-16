/* Assignment’s title: Lab2 Chess and Objects
   Student’s name: Alejandra Acevedo, Deniss Garcia, Luis Fierro, Marco Alvarez

   Description: 
   The program checks whether a selected chess piece can move from its current position
   to a target position. The program prompts the user for the piece type, color, 
   and starting coordinates, then asks for a destination. It validates the move, provides 
   feedback if it’s invalid, and gives the user the option to try another move or pick 
   a new piece.

   Change Log:
   [09/13/2025] Pseudocode created by the entire team
   [09/14/2025] Classes created by the entire team 
   [09/15/2025] Marco and Luis work in the main method 
   [09/15/2025] Ale and Marco work in the test cases
   [09/15/2025] Deniss work in the description 
   [09/16/2025] Ale implemented Enums on code
*/

import java.util.InputMismatchException;
import java.util.Scanner;

public class ChessGame {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        boolean newPiece = true; // loop until user quits

        while (newPiece) {
            char currentX = 'A';
            char targetX = 'A';
            boolean done = true;
            PieceColor colorEnum = null;
            ChessPiece pieceEnum = null;

            //ask user to select a piece
            System.out.println("Which piece would you like to use? (Pawn, Rook, Bishop, Knight, Queen, King)");
            String pieceName = userInput.nextLine().trim().toUpperCase();
            
            // ----------- CONVERT STRING INPUT TO CHESSPIECE ENUM ----
            switch(pieceName){
                case "PAWN":
                    pieceEnum = ChessPiece.PAWN;
                    break;
                case "ROOK":
                    pieceEnum = ChessPiece.ROOK;
                    break;
                case "BISHOP":
                    pieceEnum = ChessPiece.BISHOP;
                    break;
                case "KNIGHT":
                    pieceEnum = ChessPiece.KNIGHT;
                    break;
                case "QUEEN":
                    pieceEnum = ChessPiece.QUEEN;
                    break;
                case "KING":
                    pieceEnum = ChessPiece.KING;
                    break;
                default:
                    System.out.println("Invalid piece name. Try again.");
                    continue;
            }
            //ask user to select a color and use PieceColor enum
            while(done){
                System.out.println("Which color would you like to use? (Black or White)");
                String pieceColor = userInput.nextLine().trim().toUpperCase();
                if(pieceColor.equals("WHITE")){
                    colorEnum = PieceColor.WHITE; // ---- CHANGE STRING TO ENUM ----
                    done = false;
                } else if(pieceColor.equals("BLACK")){
                    colorEnum = PieceColor.BLACK; // ---- CHANGE STRING TO ENUM ----
                    done = false;
                } else {
                    System.out.println("Invalid input. Enter White or Black.");
                }
            }

            done = true;
            // ---- Ask for starting position ----
            while(done){
                System.out.println("Enter starting X (A to H):");
                String checkDesX = userInput.nextLine().trim().toUpperCase();

                if (checkDesX.length() == 1) {
                    char boundsDesX = checkDesX.charAt(0);
                    if (boundsDesX >= 'A' && boundsDesX <= 'H') {
                        targetX = boundsDesX;
                        done = false; //exit loop
                    } else {
                        System.out.println("Invalid input. Destination X must be between A and H.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a single character (A to H).");
                }
            }
            done = true;
            int currentY = 0;
            while(done){
                System.out.println("Enter starting Y (1 to 8):");
                int tempY = 0;
                try {
                    tempY = userInput.nextInt();
                    if(tempY > 0 && tempY < 9){
                        currentY = tempY;
                        done = false; //exit loop
                    }
                    else{
                        System.out.println("Invalid input. Starting x must be between 1 to 8");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number 1 to 8.");
                    userInput.nextLine(); // clear buffer
                    continue;
                }
            }
            userInput.nextLine(); // consume newline

            // ---- Create chosen piece ----
            Object piece = null;
            switch (pieceEnum) {
                case PAWN:
                    piece = new Pawn(colorEnum, currentX, currentY);
                    break;
                case ROOK:
                    piece = new Rook(colorEnum, currentX, currentY);
                    break;
                case BISHOP:
                    piece = new Bishop(colorEnum, currentX, currentY);
                    break;
                case KNIGHT:
                    piece = new Knight(colorEnum, currentX, currentY);
                    break;
                case QUEEN:
                    piece = new Queen(colorEnum, currentX, currentY);
                    break;
                case KING:
                    piece = new King(colorEnum, currentX, currentY);
                    break;
                default:
                    System.out.println("Invalid piece name. Try again.");
                    continue;
            }

            // ---- Loop for moves with this piece ----
            boolean continuePiece = true;
            while (continuePiece) {
                int targetY = 1;
                done = true;
                // Ask destination X
                while(done){
                System.out.println("Please enter Destination X (A to H):");
                String checkDesX = userInput.nextLine().trim().toUpperCase();

                if (checkDesX.length() == 1) {
                    char boundsDesX = checkDesX.charAt(0);
                    if (boundsDesX >= 'A' && boundsDesX <= 'H') {
                        targetX = boundsDesX;
                        done = false; //exit loop
                    } else {
                        System.out.println("Invalid input. Destination X must be between A and H.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a single character (A to H).");
                }
                }
                // Ask destination Y
                done = true;
                
                while(done){
                    System.out.println("Enter starting Y (1 to 8):");
                    int tempY = 0;
                    try {
                        tempY = userInput.nextInt();
                        if(tempY > 0 && tempY < 9){
                            targetY = tempY;
                            done = false; //exit loop
                        }
                        else{
                            System.out.println("Invalid input. Starting x must be between 1 to 8");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a number 1 to 8.");
                        userInput.nextLine(); // clear buffer
                        continue;
                    }
                }
                userInput.nextLine(); 

                boolean valid = false;
                if (piece instanceof Pawn) {
                    valid = ((Pawn) piece).validMove(targetX, targetY);
                } else if (piece instanceof Rook) {
                    valid = ((Rook) piece).validMove(targetX, targetY);
                } else if (piece instanceof Bishop) {
                    valid = ((Bishop) piece).validMove(targetX, targetY);
                } else if (piece instanceof Knight) {
                    valid = ((Knight) piece).validMove(targetX, targetY);
                } else if (piece instanceof Queen) {
                    valid = ((Queen) piece).validMove(targetX, targetY);
                } else if (piece instanceof King) {
                    valid = ((King) piece).validMove(targetX, targetY);
                }

                if (valid) {
                    System.out.println(pieceEnum + " at " + currentX + currentY +
                            " can move to " + targetX + targetY);
                } else {
                    System.out.println(pieceEnum + " at " + currentX + currentY +
                            " cannot move to " + targetX + targetY);
                }
                
                // Continue with same piece?
                while(!done){
                    System.out.println("Do you want to continue with this piece at location (" + currentX + ", " + currentY + ") ? (Y/N)");
                    String count = userInput.nextLine().trim().toUpperCase();
                    if (continuePiece = count.equals("Y") || count.equals("YES")){
                        continuePiece = true;
                        done = true;
                    }else if(continuePiece = count.equals("N") || count.equals("NO")){
                        continuePiece = false;
                        done = true;
                    }else{
                        System.out.println("Invalid input, please type Yes or No");
                    }
                }
            }

            // Select another piece?
            done = true;
            while(done){
                System.out.println("Do you want to select another piece? (Y/N)");
                String contPiece = userInput.nextLine().trim().toUpperCase();
                if (newPiece = contPiece.equals("Y") || contPiece.equals("YES")){
                    newPiece = true;
                    done = false;
                }else if(newPiece = contPiece.equals("N") || contPiece.equals("NO")){
                    newPiece = false;
                    done = false;
                }else{
                    System.out.println("Invalid input, please type Yes or No");
                }
            }

        }

        System.out.println("Program ended.");
        userInput.close();
    }
}