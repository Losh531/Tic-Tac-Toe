import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.util.Scanner;
/*

  The board:

    | |
  -------
    | |
  -------
    | |

  Player 1, X or O? X
  Player 1, where? 1,1

  Player 2, X or O?

  Core Challenges:
   - Remember how to take user input
   - How do we store the current board?
   - Don't allow someone to fill in a square that's filled in;
         give an error message and let them retry

  Nice to haves:
   - Clear the screen before redrawing the board
   - How do we detect that someone won?
   - Allow player 1 to choose what symbol they are

 */
class Main {
  public static void main(String[] args) {
    // Uncomment to run the main game
     runGame();

    // Uncomment to test the BoardPrinter
    // BoardPrinter.test();

    // Uncomment to test the BoardWinnerChecker
    //BoardWinnerChecker.test();
  }

  private static void runGame() {
        // Opening a Scanner to get user input
    try (Scanner input = new Scanner(System.in)) {
      // The board is a 3x3 grid
      String[][] board = new String[3][3];  
        boolean hasTheGameEnded = false;
      // Looping until we've determined that a player has won
      System.out.println("Welcome to tic tac toe...");
      while (!hasTheGameEnded){
          // TODO Prevent players from overwriting each other

          // Handler player 1
          System.out.println("(Player 1): Which column (0-2, left to right)?");
          int player1Spot1 = input.nextInt();
          System.out.println("(Player 1) Which row (0-2, top to bottom)?");
          int player1Spot2 = input.nextInt();
          try {
            if (board[player1Spot1][player1Spot2] == "O"){
                System.out.println("Player 2 has already gone here so you lose your turn :((((");
            } else {
              board[player1Spot1][player1Spot2] = "X";
              BoardPrinter.printBoard(board);
            }
          } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Player 1 doesn't understand numbers; LOSE YOUR TURN!");
          }


        if (BoardWinnerChecker.hasAPlayerWon(board)){
            System.out.println("Player 1 has won!");
            hasTheGameEnded = true;
            continue;
        }

        // Handler player 2
        System.out.println("(Player 2): Which column (0-2, left to right)?");
        int player2Spot1 = input.nextInt();
        System.out.println("(Player 2) Which row (0-2, top to bottom)?");
        int player2Spot2 = input.nextInt();
        if (board[player2Spot1][player2Spot2] == "X"){
          System.out.println("Player 1 has already gone here so you lose your turn :((((");
        } else {
          board[player2Spot1][player2Spot2] = "O";
          BoardPrinter.printBoard(board); 
        }
        if (BoardWinnerChecker.hasAPlayerWon(board)){
            System.out.println("Player 2 has won!");
            hasTheGameEnded = true;
            continue;
        }
      }
      System.out.print("And with that...the game is over...");
    }
  }
}

/*
    // {datatype} {variable name} = new 
    String[] weekDays = new String[5];
    System.out.println(weekDays[2]);

    Car car = new Car();
    System.out.println(car.running);

    boolean[] anything = new boolean[5];
    System.out.println(anything[0]);

    int[] numbers = new int[] { 5, 9, 17, -5, 15, 93, 1003 };
    // int[] numbersNotInline = new int[7];
    // numbersNotInline[0] = 5;
    // numbersNotInline[1] = 9;
    // numbersNotInline[2] = 17;
    // numbersNotInline[3] = -5;
    // numbersNotInline[4] = 15;
    // numbersNotInline[5] = 93;
    // numbersNotInline[6] = 1003;

    // int[] zeroArray = new int[] { 0, 0, 0, 0 };
    // int[] otherZeroArray = new int[4];
  
    // System.out.println(numbers.length);

    // Array of arrays.  aka multidimensional array.  2-dimensional array

    // int[][] temperaturesForEachDay = new int[7][2];

    // "jagged array"
    int[][] temperaturesForEachDay = {
      { 45, 65 }, // int array of size 2
      { 44, 64, 84, 92, 43 }, // int array of size 5
      { 42, 67, 75 } // int array of size 3
    };
    int[][] checkerBoard = new int[8][6];
    checkerBoard[0][0] = 5;
    int[] hello = {
        
    };

    temperaturesForEachDay[0][0] = 100; // First entry of the first list
    temperaturesForEachDay[0][1] = 200; // Second entry of the first list
    temperaturesForEachDay[1][0] = 70; // First entry of the second list
    System.out.println(temperaturesForEachDay[2][2]);

    // This array's first dimension is 3: 3 integer arrays

    for (int i = 0; i < temperaturesForEachDay.length; i++){
      System.out.println("Day " + (i+1) + " had " + temperaturesForEachDay[i].length + " temperatures");

        // Loop over each temperature for the given day
        int result = 0;
        for (int b = 0; b < temperaturesForEachDay[i].length; b++){
        //   // Print out the temperature
        // System.out.println(temperaturesForEachDay[i][b]);
        
        // Calculating the total sum for the day
        result = result + temperaturesForEachDay[i][b];
        }

        // Print out the average temperature:
        System.out.println(result /temperaturesForEachDay[i].length);
*/


    // int[] numbers = new int[5];
    // numbers[0] = 5;
    // numbers[1] = 9;
    // numbers[2] = 17;
    // numbers[3] = -5;
    // numbers[4] = 15;



    // Default values:
    // int: 0
    // double: 0.0
    // String: null
    // boolean: false


    // int[] numbers = new int[5];
    // numbers[0] = 5;
    // numbers[1] = 9;
    // numbers[2] = 17;
    // numbers[3] = -5;
    // numbers[4] = 15;
    //
    // // Codingame would just tell you: the number can't be larger than 20,
    // // or smaller than 0

    // int largestNumber = numbers[0];
    // int smallestNumber = numbers[0];
    // int sum = 0;
    // int sumPositive = 0;

    // for (int i = 0; i < numbers.length; i++) {
    //   System.out.println(numbers[i]);
    //   if (numbers[i] > largestNumber) {
    //     largestNumber = numbers[i];
    //   } else if (numbers[i] < smallestNumber) {
    //     smallestNumber = numbers[i];
    //   }
    //   if (numbers[i]> 0){
    //     sumPositive = sumPositive + numbers[i];
    //   }
    //   sum = sum + numbers[i];
      
    // }
    // System.out.println("The largest number: " + largestNumber);
    // System.out.println("The smallest number: " + smallestNumber);
    // System.out.println("The sum is: " + sum);
    // System.out.println("The average is: " + (((double) sum) / numbers.length));
    // System.out.println("The sum of the positive numbers is: " + sumPositive);

/*
 * 
 * o o c \____/
 * 
 */