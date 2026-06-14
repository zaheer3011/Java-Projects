package com.example.dungeonGame;

import java.util.*;

public class DungeonGame {

    public static void displayGrid(char dungeon[][], int n, int m) {

        for(int r=0; r<n; r++) {

            for(int c=0; c<m; c++) {

                System.out.print(dungeon[r][c] + " ");
            }

            System.out.println();
        }
    }

    public static boolean isValidPosition(char dungeon[][], int row, int col) {

        int n = dungeon.length;
        int m = dungeon[0].length;

        if(row >= 0 && row < n && col >= 0 && col < m && dungeon[row][col] == '.')
            return true;

        return false;
    }

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of the Grid : (Row & Column) ");
        int rows = sc.nextInt();
        int cols = sc.nextInt();

        char dungeon[][] = new char[rows][cols];

        for(int i=0; i<rows; i++) {

            for(int j=0; j<cols; j++) {

                dungeon[i][j] = '.';
            }
        }

        // Adventure
        System.out.println("Enter the Adventure Position : (Row & Column) ");
        int adRow = sc.nextInt();
        int adCol = sc.nextInt();

        if(isValidPosition(dungeon, adRow, adCol)) {
            dungeon[adRow][adCol] = 'A';
        }

        // Monster
        System.out.println("Enter the Monster Position : (Row & Column) ");
        int mRow = sc.nextInt();
        int mCol = sc.nextInt();

        if(isValidPosition(dungeon, mRow, mCol)) {
            dungeon[mRow][mCol] = 'M';
        }

        // Treasure
        System.out.println("Enter the Treasure Position : (Row & Column) ");
        int tsRow = sc.nextInt();
        int tsCol = sc.nextInt();

        if(isValidPosition(dungeon, tsRow, tsCol)) {
            dungeon[tsRow][tsCol] = 'T';
        }

        // Trigger
        System.out.println("Enter the Trigger Position : (Row & Column) ");
        int tRow = sc.nextInt();
        int tCol = sc.nextInt();

        if(isValidPosition(dungeon, tRow, tCol)) {
            dungeon[tRow][tCol] = 'T';
        }

        // Pits
        System.out.println("Enter the Number of Pits : ");
        int nPits = sc.nextInt();

        for(int i=0; i<nPits; i++) {

            System.out.println("Enter the Pit " + (i+1) + " Position : (Row & Column)");
            int pRow = sc.nextInt();
            int pCol = sc.nextInt();

            if(isValidPosition(dungeon, pRow, pCol)) {
                dungeon[pRow][pCol] = 'P';
            }
        }

        int adventureToTreasureDist = Math.abs(adRow - tsRow) + Math.abs(adCol - tsCol);
        int monsterToTreasureDist = Math.abs(mRow - tsRow) + Math.abs(mCol - tsCol);
        int adventureToTriggerDist = Math.abs(adRow - tRow) + Math.abs(adCol - tCol);
        int monsterToTriggerDist = Math.abs(mRow - tRow) + Math.abs(mCol - tCol);

        displayGrid(dungeon, rows, cols);

        System.out.println("Result : ");

        if(adventureToTriggerDist < monsterToTriggerDist) {
            System.out.println("Adventure can reach the Trigger First");
            System.out.println("Monster are frozen...");
            System.out.println("Adventure can safely reach to Treasure");
        }

        else if(monsterToTriggerDist < adventureToTriggerDist) {
            System.out.println("Monster can reach the Trigger first");

            if(adventureToTreasureDist < monsterToTreasureDist) {
                System.out.println("Adventure can still have a chance to reach Treasure");
            }

            else {
                System.out.println("Monster will reach the Treasure");
            }
        }

        else {
            if(adventureToTreasureDist < monsterToTreasureDist) {
                System.out.println("Adventure will catch the Treasure");
            }

            else {
                System.out.println("Monster will catch the Treasure");
            }
        }
    }
}