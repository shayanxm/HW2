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
        int amirsColumnsInStack = 1;
        int alisColumnsInStack = 1;
        findRowWinner:
        for (int i = 0; i < numberOfRows - 1; i++) {
            for (int j = 0; j < numberOfColumns - 1; j++) {
                //this for rows
                if (ticTacToeMatric[i][j] == ticTacToeMatric[i][j + 1]) {
                    if (ticTacToeMatric[i][j] == 'x') {

                        amirsRowsInStack++;
                        System.out.println("hey its " + amirsColumnsInStack + " the same in row for amir");
                    }
                    if (ticTacToeMatric[i][j] == '0') {
                        alisRowsInStack++;
                        System.out.println("hey its " + alisColumnsInStack + " the same in row for ali");

                    }
                }


            }
        }
        /// coulumns
        //reset counters when needed
        coulumncounter:for (int j = 0; j < numberOfColumns - 1; j++) {
            amirsColumnsInStack = 1; // Reset for each column
            alisColumnsInStack = 1;
            for (int i = 0; i < numberOfRows - 1; i++) {
                if (ticTacToeMatric[i][j] == ticTacToeMatric[i + 1][j]) {
                    if (ticTacToeMatric[i][j] == 'x' && ticTacToeMatric[i + 1][j] == 'x') {

                        amirsColumnsInStack++;
                        if (amirsColumnsInStack==4) break coulumncounter;
                        System.out.println("hey its  AMODI " + amirsColumnsInStack + " the same in row for amir");
                    }
                    if (ticTacToeMatric[i][j] == '0' && ticTacToeMatric[i + 1][j] == '0') {
                        alisColumnsInStack++;
                        if (alisColumnsInStack==4)break coulumncounter;
                        System.out.println("hey its AMODI " + alisColumnsInStack + " the same in row for ali");

                    }
                }
            }
        }


        //check for winner
        if (amirsRowsInStack == 4 || amirsColumnsInStack == 4) {
            //  if (ticTacToeMatric[i][j] == 'X') {
            System.out.println("amirscoulmns " + amirsColumnsInStack + " amir rows " + amirsRowsInStack);
            System.out.println("winner winner chicken dinner , Ali won the game");
            gameShouldEnd = true;
            //   break findRowWinner;
        } else if (alisRowsInStack == 4 || alisColumnsInStack == 4) {
            gameShouldEnd = true;
            System.out.println("aliscoulmns " + alisColumnsInStack + "  alis rows " + alisRowsInStack);

            System.out.println("winner winner chicken dinner , Amir won the game");

            //  break findRowWinner;


        }

//            amirsRowsInStack = 1;
//            alisRowsInStack = 1;

        //agar hameye khone ha barabar X ya 0 bashashan mosaiv ast
        for (
                int i = 0;
                i < numberOfRows; i++) {
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




