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
            String color = "";

            System.out.println("Which piece would you like to use? (Pawn, Rook, Bishop, Knight, Queen, King)");
            String pieceName = userInput.nextLine().trim().toLowerCase();


            
            while(done){
            System.out.println("Which color would you like to use? (Black or White)");
            String pieceColor = userInput.nextLine().trim().toLowerCase();
            if(pieceColor.equals("white") || pieceColor.equals("black")){
                color = pieceColor;
                done = false;
            }
            else{
                System.out.println("Invaid input. enter the color White or Black");
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
            switch (pieceName) {
                case "pawn":
                    piece = new Pawn(color, currentX, currentY);
                    break;
                case "rook":
                    piece = new Rook(color, currentX, currentY);
                    break;
                case "bishop":
                    piece = new Bishop(color, currentX, currentY);
                    break;
                case "knight":
                    piece = new Knight(color, currentX, currentY);
                    break;
                case "queen":
                    piece = new Queen(color, currentX, currentY);
                    break;
                case "king":
                    piece = new King(color, currentX, currentY);
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
                    System.out.println(pieceName + " at " + currentX + currentY +
                            " can move to " + targetX + targetY);
                } else {
                    System.out.println(pieceName + " at " + currentX + currentY +
                            " cannot move to " + targetX + targetY);
                }
                
                userInput.nextLine();
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