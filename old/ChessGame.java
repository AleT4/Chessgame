import java.util.InputMismatchException;
import java.util.Scanner;

public class ChessGame {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        boolean newPiece = true; // loop until user quits

        while (newPiece) {
            char currentX = 'A';
            char targetX = 'A';
            int currentY = 0;
            int targetY = 0;
            boolean done = true;
            PieceColor color = null;   // using enum instead of String
            ChessPiece pieceName = null; // using enum instead of String

            // ---- Ask for piece type ----
            System.out.println("Which piece would you like to use? (Pawn, Rook, Bishop, Knight, Queen, King)");
            String pieceInput = userInput.nextLine().trim().toUpperCase();

            try {
                pieceName = ChessPiece.valueOf(pieceInput);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid piece name. Try again.");
                continue;
            }

            // ---- Ask for piece color ----
            done = true;
            while(done){
                System.out.println("Which color would you like to use? (Black or White)");
                String pieceColor = userInput.nextLine().trim().toUpperCase();
                try {
                    color = PieceColor.valueOf(pieceColor);
                    done = false;
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid input. Enter the color White or Black.");
                }
            }

            // ---- Ask for starting position ----
            done = true;
            while(done){
                System.out.println("Enter starting X (A to H):");
                String checkDesX = userInput.nextLine().trim().toUpperCase();

                if (checkDesX.length() == 1) {
                    char boundsDesX = checkDesX.charAt(0);
                    if (boundsDesX >= 'A' && boundsDesX <= 'H') {

                        System.out.println("Enter starting Y (1 to 8):");
                        int tempY = 0;
                        try {
                            tempY = userInput.nextInt();
                            userInput.nextLine(); // consume newline
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Enter a number 1-8.");
                            userInput.nextLine(); // clear buffer
                            continue;
                        }

                        // ---- Chessboard bounds check for starting position ----
                        if (Chessboard.bounds(boundsDesX, tempY)) {
                            currentX = boundsDesX;
                            currentY = tempY;
                            done = false; // exit loop
                        }
                    } else {
                        System.out.println("Invalid input. Starting X must be between A and H.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a single character (A to H).");
                }
            }

            // ---- Create chosen piece ----
            Object piece = null;
            switch (pieceName) {
                case PAWN:
                    piece = new Pawn(color, currentX, currentY);
                    break;
                case ROOK:
                    piece = new Rook(color, currentX, currentY);
                    break;
                case BISHOP:
                    piece = new Bishop(color, currentX, currentY);
                    break;
                case KNIGHT:
                    piece = new Knight(color, currentX, currentY);
                    break;
                case QUEEN:
                    piece = new Queen(color, currentX, currentY);
                    break;
                case KING:
                    piece = new King(color, currentX, currentY);
                    break;
            }

            // ---- Loop for moves with this piece ----
            boolean continuePiece = true;
            while (continuePiece) {
                int tempTargetY = 0;
                char tempTargetX = 'A';
                boolean validInput = false;

                // ---- Ask destination X and Y ----
                while (!validInput) {
                    // Destination X
                    System.out.println("Please enter Destination X (A to H):");
                    String destXInput = userInput.nextLine().trim().toUpperCase();
                    if (destXInput.length() == 1) {
                        tempTargetX = destXInput.charAt(0);
                    } else {
                        System.out.println("Invalid input. Enter a single character A-H.");
                        continue;
                    }

                    // Destination Y
                    System.out.println("Enter destination Y (1 to 8):");
                    try {
                        tempTargetY = userInput.nextInt();
                        userInput.nextLine(); // consume newline
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Enter a number 1-8.");
                        userInput.nextLine(); // clear buffer
                        continue;
                    }

                    // Check bounds for both X and Y
                    if (Chessboard.bounds(tempTargetX, tempTargetY)) {
                        targetX = tempTargetX;
                        targetY = tempTargetY;
                        validInput = true; // exit loop
                    } else {
                        System.out.println("Destination out of bounds. Try again.");
                    }
                }

                // ---- Check if move is valid ----
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

                // ---- Continue with same piece? ----
                boolean doneContinue = false;
                while (!doneContinue) {
                    System.out.println("Do you want to continue with this piece at location (" + currentX + ", " + currentY + ") ? (Y/N)");
                    String count = userInput.nextLine().trim().toUpperCase();
                    if (count.equals("Y") || count.equals("YES")) {
                        continuePiece = true;
                        doneContinue = true;
                    } else if (count.equals("N") || count.equals("NO")) {
                        continuePiece = false;
                        doneContinue = true;
                    } else {
                        System.out.println("Invalid input, please type Yes or No");
                    }
                }
            }

            // ---- Select another piece? ----
            boolean doneSelectPiece = false;
            while (!doneSelectPiece) {
                System.out.println("Do you want to select another piece? (Y/N)");
                String contPiece = userInput.nextLine().trim().toUpperCase();
                if (contPiece.equals("Y") || contPiece.equals("YES")) {
                    newPiece = true;
                    doneSelectPiece = true;
                } else if (contPiece.equals("N") || contPiece.equals("NO")) {
                    newPiece = false;
                    doneSelectPiece = true;
                } else {
                    System.out.println("Invalid input, please type Yes or No");
                }
            }
        }

        System.out.println("Program ended.");
        userInput.close();
    }
}
