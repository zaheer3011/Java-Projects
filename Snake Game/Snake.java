package com.example.snake.game;

import java.util.LinkedList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class Snake {

    private int size;
    private char[][] board;
    private Queue<Node> snakeMove;
    private Random random;

    public Snake(int size) {

        this.size = size;
        board = new char[size][size];

        snakeMove = new LinkedList <> ();
        random = new Random();

        int randRow = random.nextInt(size);
        int randCol = random.nextInt(size);

        for(int i=0; i<size; i++) {
            Arrays.fill(board[i], '0');
        }
        // Initializing the Snake Food
        board[randRow][randCol] = 'X';


        snakeMove.add(new Node(0, 0));
    }

    public void initializeGame(int row, int col) {

        if(row >= 0 && row < board.length && col >= 0 && col < board.length) {

            if(board[row][col] == '.') {
                System.out.println("Game Over!");
                System.exit(0);
            }   

            snakeMove.add(new Node(row, col));

            // Generating Sneke Food
            if(board[row][col] == 'X') {

                int randRow, randCol;

                do {
                    randRow = random.nextInt(size);
                    randCol = random.nextInt(size);

                } while(board[randRow][randCol] != '0');

                board[randRow][randCol] = 'X';
            }

            if(board[row][col] != 'X') {
                Node node = snakeMove.poll();
                int r = node.getRow();
                int c = node.getColumn();

                board[r][c] = '\0';
            }

            board[row][col] = '.';

            while(!snakeMove.isEmpty()) {

                displaySnake();

                Scanner sc = new Scanner(System.in);

                System.out.println("Enter the direction : ");
                char direction = sc.nextLine().toUpperCase().charAt(0);

                if(direction == 'U') {
                    initializeGame(row-1, col);
                }

                if(direction == 'R') {
                    initializeGame(row, col+1);
                }

                if(direction == 'L') {
                    initializeGame(row, col-1);
                }

                if(direction == 'D') {
                    initializeGame(row+1, col);
                }
            }
        }

        else {
            System.out.println("Invalid Move");
            System.exit(0);
        }

}
        public void displaySnake() {

            for(int i=0; i< board.length; i++) {

                for(int j=0; j<board[i].length; j++) {

                    System.out.print(board[i][j] + " ");
                }

                System.out.println();
            }
        }
    }
