public class Knight {
    public PieceColor color;
    private char currentX;
    private int currentY;

    public Knight(PieceColor color, char currentX, int currentY){
        this.color = color;
        this.currentX = currentX;
        this.currentY = currentY;
    }
    
    public boolean validMove(char targetX, int targetY){
        if(this.currentY == targetY + 2 || this.currentY == targetY - 2 
            || this.currentX == targetX + 2 || this.currentX == targetX - 2){
            
            if(this.currentY == targetY + 1 || this.currentY == targetY - 1 
                || this.currentX == targetX + 1 || this.currentX == targetX - 1){
                return true;
            }
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