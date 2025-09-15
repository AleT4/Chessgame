public class Pawn {
    public String color;
    private char currentX;
    private int currentY;
    public Chessboard piece;

    public Pawn(String color, char currentX, int currentY){
        this.color = color;
        this.currentX = currentX;
        this.currentY = currentY;
        this.piece = new Chessboard(color, currentX, currentY); 
    }

    public boolean validMove(char targetX, int targetY) {
        if (this.piece.bounds(targetX, targetY)) {
            if (this.currentX == targetX) {
                if (this.color.equals("black")) {
                    return targetY - this.currentY == -1;
                } else { // white
                    return targetY - this.currentY == 1;
                }
            }
        }
        return false;
    }

    public void setColor(String color){
        this.color = color;
    }

    public String getColor(){
        return this.color;
    }

    public void setCurrentX(char x){
        this.currentX = x;
    }

    public char getCurrentX(){
        return this.currentX;
    }

    public void setCurrenty(int y){
        this.currentY = y;
    }

    public int getCurrenty(){
        return this.currentY;
    }
    
}