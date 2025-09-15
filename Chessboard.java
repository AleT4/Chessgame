public class Chessboard{

    String color;
    char destX;
    int destY;

    Chessboard(String color, char destX, int destY){
        this.color = color;
        this.destX = destX;
        this.destY = destY;
    }

    public boolean bounds(char destX , int destY){

        if((destX > 64 && destX < 73) || (destY > 0 && destY < 9)){
            return true;
        }else{
            System.out.println("Your move is outside the ChessBoard, try again.");
            return false;
        } 
    }
}