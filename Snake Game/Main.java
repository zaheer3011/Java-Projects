package com.example.snake.game;

import java.util.Scanner;

public class Main {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of the board : (row/col) ");
        int size = sc.nextInt();

        Snake snake = new Snake(size);
        snake.initializeGame(0, 0);
    }
}
