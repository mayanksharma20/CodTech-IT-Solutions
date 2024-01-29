import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    private static char[][] display = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
    private static char currentPlayer;
    private static final char PLAYER_X = 'X';
    private static final char PLAYER_O = 'O';
    public static void abc(){
        Scanner sc = new Scanner(System.in);
        int ch=0;
        do {
            initializedisplay();
        // Decide who goes first (X or O)
        Random r = new Random();
        currentPlayer = (r.nextBoolean()) ? PLAYER_X : PLAYER_O;
        System.out.println("0: Human VS Computer");
        System.out.println("1: Human VS Human");
        int a=sc.nextInt();
                    

        do {
            printdisplay();
            if(a==1)
            {
                playHumanMove(sc);
            }
            else{
                if (currentPlayer == PLAYER_X) {
                playHumanMove(sc);
                } else {
                playComputerMove();
            }

            }

            if (findwinner()) {
                printdisplay();
                System.out.println("Player " + currentPlayer + " wins!");
                System.out.println("Do you want to Exit");
                System.out.println("1: YES");
                System.out.println("2: NO");
                int demo=sc.nextInt();
                if(demo==1)
                {
                    ch=ch+1;
                }
                else
                {
                   abc();
                }
                

                
            }

            if (isdisplayFull()) {
                printdisplay();
                System.out.println("It's a draw!");
                break;
            }

            switchPlayer();
        }while(ch==0);
    }while (ch==0);
        

        sc.close();
    }

    
    public static void main(String[] args) {

        abc();}
     
        private static void initializedisplay() {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    display[i][j] = ' ';
                }
            }
        }

    private static void printdisplay() {
        System.out.println("    0   1   2");
        System.out.println("  -------------");
        for (int i = 0; i < 3; i++) {
            System.out.print(i+" | ");
            for (int j = 0; j < 3; j++) {
                System.out.print(display[i][j] + " | ");
            }
            System.out.println("\n  -------------");
        }

    }

    private static void playHumanMove(Scanner sc) {
        int row, col;
        do {
            System.out.print("Player " + currentPlayer + ", enter your move (row and column): ");
            row = sc.nextInt();
            col = sc.nextInt();
        } while (!isValidMove(row, col));

        display[row][col] = currentPlayer;
    }

    private static void playComputerMove() {
        Random r = new Random();
        int row, col;
        do {
            row = r.nextInt(3);
            col = r.nextInt(3);
        } while (!isValidMove(row, col));

        System.out.println("Computer chooses: " + row + " " + col);
        display[row][col] = currentPlayer;
    }

    private static boolean isValidMove(int row, int col) {
        if (row < 0 || row >= 3 || col < 0 || col >= 3 || display[row][col] != ' ') {
            System.out.println("Invalid move. Try again.");
            return false;
        }
        return true;
    }

    private static void switchPlayer() {
        currentPlayer = (currentPlayer == PLAYER_X) ? PLAYER_O : PLAYER_X;
    }

    private static boolean findwinner() {
        
        for (int i = 0; i < 3; i++) {
            if (display[i][0] != ' ' && display[i][0] == display[i][1] && display[i][1] == display[i][2]) {
                return true; 
                        }
            if (display[0][i] != ' ' && display[0][i] == display[1][i] && display[1][i] == display[2][i]) {
                return true; 
            }
        }

        // Diagonal wins
        if (display[0][0] != ' ' && display[0][0] == display[1][1] && display[1][1] == display[2][2]) {
            return true; // Top-left to bottom-right diagonal
        }
        if (display[0][2] != ' ' && display[0][2] == display[1][1] && display[1][1] == display[2][0]) {
            return true; // Top-right to bottom-left diagonal
        }

        return false;
    }

    private static boolean isdisplayFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (display[i][j] == ' ') {
                    return false; // If any empty space found, the display is not full
                }
            }
        }
        return true;
    }
}
