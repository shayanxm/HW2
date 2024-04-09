import java.util.Scanner;

public class Transpose {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("ENTER YOUR MATRIX LEVEL");
        int matrixlevel = scanner.nextInt();

        int[][] inputedMatrix = new int[matrixlevel][matrixlevel];
        for (int i = 1; i <= matrixlevel; i++) {
            for (int j = 1; j <= matrixlevel; j++) {
                System.out.println("enter leyer" + i + "," + j);
                inputedMatrix[i - 1][j - 1] = scanner.nextInt();
            }
        }
        MatrixPrinter2D(inputedMatrix);
        System.out.println("inputed Matrix");
        int[][] transposeMatrix = getTransposeMatrix(inputedMatrix);
        System.out.println("transpose Matrix");
        MatrixPrinter2D(transposeMatrix);


    }

    private static void MatrixPrinter2D(int[][] inputedMatrix) {
        for (int i = 0; i < inputedMatrix.length; i++) {
            for (int j = 0; j < inputedMatrix[i].length; j++) {
                System.out.print(inputedMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] getTransposeMatrix(int[][] inputedMatrix) {
        int[][] outputMatrix = new int[inputedMatrix.length][inputedMatrix.length];

     //   System.arraycopy(inputedMatrix,0,outputMatrix,0,inputedMatrix.length);
        for (int i = 0; i < inputedMatrix.length; i++) {
            for (int j = 0; j < inputedMatrix[i].length; j++) {
                    outputMatrix[i][j] = inputedMatrix[j][i];

            }
        }
        return outputMatrix;
    }
}
