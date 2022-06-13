import java.io.*;
import java.util.*;

public class knightsTour {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int sz = scn.nextInt();
        int r = scn.nextInt();
        int c = scn.nextInt();
        int[][] chess = new int[sz][sz];
        printKnightsTour(chess, r, c, 1);
    }

    public static void printKnightsTour(int[][] chess, int r, int c, int upcomingMove) {
        if(r < 0 || c < 0 || r >= chess.length || c >= chess.length || chess[r][c] != 0){ // subtle baat 3 -> can lead to array index out of bound
            return;
        } else if(upcomingMove == chess.length * chess.length){
            chess[r][c] = upcomingMove; // subtle baat 1 -> you would see 1 to 24 and 0 in 25th spot
            displayBoard(chess);
            chess[r][c] = 0; // subtle baat 2 -> you would get just one answer
            return;
        }
        
        chess[r][c] = upcomingMove;
        printKnightsTour(chess, r - 2, c + 1, upcomingMove + 1);
        printKnightsTour(chess, r - 1, c + 2, upcomingMove + 1);
        printKnightsTour(chess, r + 1, c + 2, upcomingMove + 1);
        printKnightsTour(chess, r + 2, c + 1, upcomingMove + 1);
        printKnightsTour(chess, r + 2, c - 1, upcomingMove + 1);
        printKnightsTour(chess, r + 1, c - 2, upcomingMove + 1);
        printKnightsTour(chess, r - 1, c - 2, upcomingMove + 1);
        printKnightsTour(chess, r - 2, c - 1, upcomingMove + 1);
        chess[r][c] = 0;
    }

    public static void displayBoard(int[][] chess){
        for(int i = 0; i < chess.length; i++){
            for(int j = 0; j < chess[0].length; j++){
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }
}