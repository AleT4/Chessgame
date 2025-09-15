public class Queen{

    public String color;
    private char currentX;
    private int currentY;
    public Chessboard piece;

    public Queen(String color, char currentX, int currentY){
        this.color = color;
        this.currentX = currentX;
        this.currentY = currentY;
        this.piece = new Chessboard(color, currentX, currentY); 

    }

    public boolean validMove(char targetX, int targetY) {   
        // Check bounds first
        if (!piece.bounds(targetX, targetY)) return false;

        int tempCurrentX = charConversion(this.currentX);
        int tempTargetX = charConversion(targetX);
        int deltaX = Math.abs(tempTargetX - tempCurrentX);
        int deltaY = Math.abs(targetY - this.currentY);

        // Vertical move
        if (this.currentX == targetX && this.currentY != targetY) return true;

        // Horizontal move
        if (this.currentY == targetY && this.currentX != targetX) return true;

        // Diagonal move
        if (deltaX == deltaY && deltaX != 0) return true;

        return false;
    }

    private int charConversion(char x){
        switch(x){
            case 'A':
                return 1;
            case 'B':
                return 2;
            case 'C':
                return 3;
            case 'D':
                return 4;  
            case 'E':
                return 5;
            case 'F':
                return 6;
            case 'G':
                return 7;
            case 'H':
                return 8;           
        }return -1;
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