public class BoardWinnerChecker {

  public static void test() {
    String[][] testBoard = {
      { "X", "O", "X" },
      { null, null, null },
      { null, null, null }
    };
    BoardPrinter.printBoard(testBoard);
    System.out.println("A player has won: " + hasAPlayerWon(testBoard));
  }

  // private static void printTopMiddleBottom(String spot1, String spot2, String spot3) {
  //   System.out.println(convertIfNull(spot1) + " | " + convertIfNull(spot2) + " | " + convertIfNull(spot3));
  // }

    // This method returns null if there is no winner
    private static boolean checkForWinner(String spot1, String spot2, String spot3) {
      if (spot1 == null || spot2 == null || spot3 == null) {
        return false;
      }

      // We know that none of the spots are null
      
      if (spot1 == spot2 && spot2 == spot3){
          return true;
      }
      
      return false;
    }

    /**
    * Input: the board
    * Output: whether either player has won
    *
    **/
  public static boolean hasAPlayerWon(String[][] board) {
/*
       Co0 Co1 Co2
Row 0:    |   |  
       -----------
Row 1:    |   |.  
       -----------
Row 2:    |   |
*/
    // Check the three rows
    // String possibleWinner = checkForWinner(board[0][0], board[0][1], board[0][2]);
    // if (possibleWinner != null) {
    //   return possibleWinner;
    // }
    
    // possibleWinner = checkForWinner(board[1][0], board[1][1], board[1][2]);
    // if (possibleWinner != null) {
    //   return possibleWinner;
    // }
    // possibleWinner = checkForWinner(board[2][0], board[2]f[1], board[2][2]);
    // if (possibleWinner != null) {
    //   return possibleWinner;
    // }

    return checkForWinner(board[0][0], board[0][1], board[0][2])
      || checkForWinner(board[1][0], board[1][1], board[1][2])
      || checkForWinner(board[2][0], board[2][1], board[2][2])
    // Check the three columns
      || checkForWinner(board[0][0], board[1][0], board[2][0])
      || checkForWinner(board[0][1], board[1][1], board[2][1])
      || checkForWinner(board[0][2], board[1][2], board[2][2])
    // Check the two diagonals
      || checkForWinner(board[0][0], board[1][1], board[2][2])
      || checkForWinner(board[0][2], board[1][1], board[2][0]);
  }
}