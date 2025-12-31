package game;

import java.util.Scanner;

public class Main {


    static boolean checkMove() {
        char[] move = {'X', 'O'};

        for (char player : move) {
            for (int i= 0; i < 3; i++) {
                if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                    System.out.println("победа игрока " + player);
                    return true;
                }
            }

            for (int i = 0; i < 3; i++) {
                if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                    System.out.println("победа игрока " + player);
                    return true;
                }
            }

            if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
                System.out.println("победа игрока " + player);
                return true;
            }

            if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
                System.out.println("победа игрока " + player);
                return true;
            }
        }

        return false;
    }


    static void printBoard() {
            System.out.println(" 0  1  2");
            for (int i = 0; i < 3; i++) {
                System.out.print(i + " ");
                for (int j = 0; j < 3; j++) {
                    System.out.print(board[i][j]);
                    if (j < 2) {
                        System.out.print("|");
                    }
                }
                System.out.println();
                if (i < 2) {
                    System.out.println(" -------");
                }
            }
        }

        static void initializationBoard() {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j ++) {
                    board[i][j] = ' ';
                }
            }
        }

        static void makeMove() {
            
            boolean trueMove = false;

            while (!trueMove) {
                System.out.println("очередь игрока - " + correctPlayer);
                System.out.print("Введите ваш столбец: ");
                int col = scanner.nextInt();
                System.out.print("введите вашу строчку: ");
                int line = scanner.nextInt();

                if (col < 0 || col > 2 || line < 0 || line > 2) {
                    System.out.println("неверный выбор координат");
                    continue;
                }

                if (board[line][col] != ' ') {
                    System.out.println("клетка уже занята");
                    continue;
                }

                board[line][col] = correctPlayer;
                trueMove = true;

                if (correctPlayer == 'X') {
                    correctPlayer = 'O';
                }
                else {
                    correctPlayer = 'X';
                }
            }

            

        }

    private static char[][] board = new char[3][3];
    private static char correctPlayer = 'X';
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        
        initializationBoard();
        printBoard();

        while (true) {
            makeMove();

            printBoard();
        }

    }
}