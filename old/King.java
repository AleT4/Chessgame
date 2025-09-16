public class King {
    public PieceColor color;
    private char currentX;
    private int currentY;

    public King(PieceColor color, char currentX, int currentY){
        this.color = color;
        this.currentX = currentX;
        this.currentY = currentY;
    }
    
    public boolean validMove(char targetX, int targetY){
        int temp = charConversion(targetX);
        int temp2 = charConversion(this.currentX);

        // King moves 1 square in any direction
        return Math.abs(temp - temp2) <= 1 && Math.abs(targetY - this.currentY) <= 1;
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