import java.util.Scanner;

public class Sudoku {

    public static final int SIZE = 9;

    public static boolean isValid(int row, int col, int[][] mat, int num) {

        for(int i=0; i<9; i++) {

            // Check the entire row
            if(mat[row][i] == num)
                return false;

            // check the entire column
            if(mat[i][col] == num)
                return false;

            // check the sub-board of 3 * 3
            if(mat[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == num)
                return false;
        }

        return true;
    }

    public static boolean sudokuSolver(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;

        for(int i=0; i<n; i++) {

            for(int j=0; j<m; j++) {

                if(mat[i][j] == 0) {

                    for(int num=1; num<=9; num++) {

                        if(isValid(i, j, mat, num)) {
                            mat[i][j] = num;

                            if (sudokuSolver(mat))
                                return true;

                            else
                                mat[i][j] = 0;
                        }
                    }

                    return false;
                }
            }
        }

        return true;
    }

    public static void displayBoard(int mat[][]) {

        int n = mat.length;
        int m = mat[0].length;

        for(int i=0; i<n; i++) {

            if(i % 3 == 0 && i != 0) {
                System.out.println("-----------------------");
            }

            for(int j=0; j<m; j++) {

                if(j % 3 == 0 && j != 0) {
                    System.out.print("| ");
                }

                System.out.print(mat[i][j] + " ");
            }

            System.out.println();
        }

    }

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the Sudoku puzzle (9x9 grid)");
        System.out.println("Enter 0 for empty cells");
        System.out.println("Enter numbers row by row, Separated by spaces");

        int[][] board = new int[SIZE][SIZE];

        for(int i=0; i<SIZE; i++) {

            System.out.print("ROW " + (i+1) + ": ");
            String[] row = sc.nextLine().trim().split("\\s+");

            for(int j=0; j<SIZE; j++) {
                board[i][j] = Integer.parseInt(row[j]);
            }

        }

        System.out.println('\n' + "Input Sudoku: " + '\n');
        displayBoard(board);

        if(sudokuSolver(board)) {
            System.out.println('\n' + "Output Sudoku: " + '\n');
            displayBoard(board);
        }

        else {
            System.out.println("Invalid board...");
        }



    }
}