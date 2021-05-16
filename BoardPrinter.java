public class BoardPrinter {

/*
  The board:


   |   |  
-----------
   |   |
-----------
   |   |
 

 */

  public static void test() {
    String[][] testBoard = {
      { "X", "O", "X" },
      { "O", "O", null },
      { null, "X", null }
    };
    printBoard(testBoard);
  }

  public static void printBoard(String[][] board) {
    printTopMiddleBottom(board[0][0], board[0][1], board[0][2]);
    printDivider();
    printTopMiddleBottom(board[1][0], board[1][1], board[1][2]);
    printDivider();
    printTopMiddleBottom(board[2][0], board[2][1], board[2][2]);
  }


  private static String convertIfNull(String string) {
    if (string == null) {
      return " ";
    }
    return string;
  }

  private static void printTopMiddleBottom(String spot1, String spot2, String spot3) {
    System.out.println(convertIfNull(spot1) + " | " + convertIfNull(spot2) + " | " + convertIfNull(spot3));
  }

  private static void printDivider(){
    System.out.println("----------");
  }
}