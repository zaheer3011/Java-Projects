import java.util.*;

public class ShortestPath {

    public static void displayGrid(char [][]grid, int n) {

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                System.out.print(grid[i][j] + " ");
            }

            System.out.println();
        }
    }

    public static boolean checkValidIndex(int startX, int startY, int endX, int endY, int n) {

        if(startX >= 0 && endX >= 0 && startY < n && endY < n)
            return true;
        else
            return false;
    }

    public static int findShortedPath(int startX, int startY, int endX, int endY) {

        int shortestPath = Math.max(Math.abs(endX - startX), Math.abs(endY - startY));
        return shortestPath;
    }

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of the grid : (N x N) ");
        int n = sc.nextInt();

        char grid[][] = new char[n][n];

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                grid[i][j] = '.';
            }
        }

        displayGrid(grid, n);

        int startX, startY;
        int endX, endY;

        System.out.println("Enter the starting (Row & COLUMN) : ");
        startX = sc.nextInt();
        startY = sc.nextInt();

        System.out.println("Enter the ending (ROW & COLUMN) : ");
        endX = sc.nextInt();
        endY = sc.nextInt();

        if(checkValidIndex(startX, startY, endX, endY, n)) {
            grid[startX][startY] = 'S';
            grid[endX][endY] = 'D';
            displayGrid(grid, n);
        }

        else {
            System.out.println("Invalid Index!");
        }

        System.out.print("Shortest Path : ");
        System.out.println(findShortedPath(startX, startY, endX, endY));


    }

}
