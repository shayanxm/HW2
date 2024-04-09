import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("pls enter number of rows");
        int numberOfRows = scanner.nextInt();
        System.out.println("pls enter number of columns");
        int numberOfColumns = scanner.nextInt();
        char[][] ticTacToeMatric = new char[numberOfRows][numberOfColumns];
        GameMatrixPreparer(numberOfRows, numberOfColumns, ticTacToeMatric);
        System.out.println("current game Board: ");
        printMatrix(ticTacToeMatric);
        String whosTurnItis = "Amir";

        //game logic starts here
        gamesGoesOn:
        while (true) {
            scanner.nextLine();
            System.out.println("its your turn " + whosTurnItis + " ,enter your column nummber");
            int currentSelectedColumn = scanner.nextInt() - 1;
            int indexOfFirstEmptyRow = numberOfColumns;
            //find last empty i

            findFirstEmptyIndex:
            for (int i = numberOfRows; i > 0; i--) {
                if (ticTacToeMatric[i - 1][currentSelectedColumn] == '-') {
                    indexOfFirstEmptyRow = i - 1;
                    break findFirstEmptyIndex;
                }
            }
            //
            if (whosTurnItis == "Amir") ticTacToeMatric[indexOfFirstEmptyRow][currentSelectedColumn] = 'x';
            if (whosTurnItis == "Ali") ticTacToeMatric[indexOfFirstEmptyRow][currentSelectedColumn] = '0';

            //    ticTacToeMatric[indexOfFirstEmptyRow][currentSelectedColumn]= 'x';

            if (whosTurnItis == "Amir") whosTurnItis = "Ali";
            else whosTurnItis = "Amir";
            printMatrix(ticTacToeMatric);

            if (CheckBoardStatus(numberOfRows, numberOfColumns, ticTacToeMatric)) break gamesGoesOn;

        }

    }

    private static boolean CheckBoardStatus(int numberOfRows, int numberOfColumns, char[][] ticTacToeMatric) {
        //check equal
        boolean equal = false;
        boolean notEqual = false;
        boolean gameShouldEnd = false;
        String winnerName = "equal";

        //iterate in rows and fix 4 in row
        int amirsRowsInStack = 1;
        int alisRowsInStack = 1;
        findRowWinner:
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns - 1; j++) {
                if (ticTacToeMatric[i][j] == ticTacToeMatric[i][j + 1]) {
                    if (ticTacToeMatric[i][j] == 'x') {
                        System.out.println("hey its " + amirsRowsInStack + " before adding new");

                        amirsRowsInStack++;
                        System.out.println("hey its " + amirsRowsInStack + " the same in row for amir");
                    }
                    if (ticTacToeMatric[i][j] == '0') {
                        alisRowsInStack++;
                        System.out.println("hey its " + alisRowsInStack + " the same in row for ali");

                    } else {
                  //      System.out.println("reseting");
//                        alisRowsInStack = 1;
//                        amirsRowsInStack = 1;
                    }
                }
            }
            //else
            //    rowsInStack = 1;
            if (amirsRowsInStack == 4) {
                //  if (ticTacToeMatric[i][j] == 'X') {
                System.out.println("winner winner chicken dinner , Ali won the game");
                gameShouldEnd = true;
                break findRowWinner;
            } else if (alisRowsInStack == 4) {
                gameShouldEnd = true;
                System.out.println("winner winner chicken dinner , Amir won the game");

                break findRowWinner;


            }

        }

//            amirsRowsInStack = 1;
//            alisRowsInStack = 1;

        //agar hameye khone ha barabar X ya 0 bashashan mosaiv ast
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                if (ticTacToeMatric[i][j] == '-') {
                    notEqual = true;
                }
                //else equal=false;
            }
        }
        if (notEqual == false) {
            System.out.println("OOPs Game is even, try harder to win kids");
            gameShouldEnd = true;
        }

        return gameShouldEnd;
    }

    private static void GameMatrixPreparer(int numberOfRows, int numberOfColumns, char[][] TicTacToeMatric) {
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                TicTacToeMatric[i][j] = '-';
            }
        }
    }

    public static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}



