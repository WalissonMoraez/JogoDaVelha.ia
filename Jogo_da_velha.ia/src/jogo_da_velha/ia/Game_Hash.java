package jogo_da_velha.ia;

import java.util.Scanner;

public class Game_Hash{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] board = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };

        while(true){
            showBoard(board);
            make_Move(board, 'X');

            if (check_Win(board, 'X')) {
                showBoard(board);
                System.out.println("Voce venceu!");
                break;
            }
            if (check_Draw(board)) {
                showBoard(board);
                System.out.println("Empate!");
                break;
            }
            
            make_Move(board, 'O');

            if (check_Win(board, 'O')) {
                showBoard(board);
                System.out.println("O computador venceu!");
                break;
            }
            if (check_Draw(board)) {
                showBoard(board);
                System.out.println("Empate!");
                break;
            }
        }

        scanner.close();
    }

    private static void showBoard(char[][] board) {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    private static void make_Move(char[][] board, char player) {
        Scanner scanner = new Scanner(System.in);
        int line, column;

        if (player == 'X') {
            do {
                System.out.print("Informe a line (0-2) para a sua jogada de " + player + ": ");
                line = scanner.nextInt();
                System.out.print("Informe a column (0-2) para a sua jogada de " + player + ": ");
                column = scanner.nextInt();
                if(board[line][column] != ' '){
                    System.out.println("Posicao Invalida");
                }
            }while(line< 0 || line >= 3 || column < 0 || column >= 3 || board[line][column] != ' ');
        } else {
            int[] bestPlay = minimax(board, 'O');
            line = bestPlay[0];
            column = bestPlay[1];
        }

        board[line][column] = player;
    }


   private static int[] minimax(char[][] board, char player) {
        int[] bestPlay = {-1, -1};
        int bestValue;
        if (player == 'O') {
            bestValue = Integer.MIN_VALUE;
        } else {
            bestValue = Integer.MAX_VALUE;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    board[i][j] = player;
                    int value;
                    if (player == 'X') {
                        value = minimaxHelper(board, 'O');
                    } else {
                        value = minimaxHelper(board, 'X');
                    }
                    board[i][j] = ' ';

                    if ((player == 'O' && value > bestValue) || (player == 'X' && value < bestValue)) {
                        bestValue = value;
                        bestPlay[0] = i;
                        bestPlay[1] = j;
                    }
                }
            }
        } 
        return bestPlay;
    }

    private static int minimaxHelper(char[][] board, char player) {
        if (check_Win(board, 'X')) {
            return -1;
        }
        if (check_Win(board, 'O')) {
            return 1;
        }
        if (check_Draw(board)) {
            return 0;
        }
        
        int bestValue;
        if (player == 'O') {
            bestValue = Integer.MIN_VALUE;
        } else {
            bestValue = Integer.MAX_VALUE;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    board[i][j] = player;
                    int value;
                    if (player == 'X') {
                        value = minimaxHelper(board, 'O');
                    } else {
                        value = minimaxHelper(board, 'X');
                    }
                    board[i][j] = ' ';

                    if (player == 'O') {
                        bestValue = Math.max(bestValue, value);
                    } else {
                        bestValue = Math.min(bestValue, value);
                    }
                }
            }
        }

        return bestValue;
    }

    private static boolean check_Win(char[][] board, char player) { //check Vitoria
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player)
                    || (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                return true;
            }
        } //checking by line and column straight victory
        
        if((board[0][0] == player && board[1][1] == player && board[2][2] == player)
                || (board[0][2] == player && board[1][1] == player && board[2][0] == player)) {
            return true;
        }//checking victory diagonally

        return false; //not win
    }

    private static boolean check_Draw(char[][] board) { //check Empate
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false; //If it's empty, it's not over
                }
            }
        }
        return true; //Draw
    }
}
