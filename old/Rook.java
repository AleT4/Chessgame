public class Rook{
    public PieceColor color;
    private char currentX;
    private int currentY;

    public Rook(PieceColor color, char currentX, int currentY){
        this.color = color;
        this.currentX = currentX;
        this.currentY = currentY;
    }

    public boolean validMove(char targetX, int targetY){
        if((this.currentX == targetX) || (this.currentY == targetY)){
            return true;
        }
        return false;
    }
    public void setColor(PieceColor color){
        this.color = color;
    }

    public PieceColor getColor(){
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