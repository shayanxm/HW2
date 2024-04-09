import java.util.Scanner;

public class Rain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("how many nummbers you want to enter?");
        int lenghtOfNumbers = scanner.nextInt();
        int[] numbers = new int[lenghtOfNumbers];
        for (int i = 0; i < lenghtOfNumbers; i++) {
            System.out.println("enteer number " + i);
            numbers[i] = scanner.nextInt();

        }
        int rain = getRain(numbers);
        System.out.println("total Rain amount " + rain);
    }

    /**
     * defs: block = numbers
     * logic : ignore first and last block
     * amount of rain for each block is = smaller block in neaboorhood- number of exisiting block
     * block minmum is golbal min and refresh with smaller block amount
     * <p>
     * chap o rast barabar ->> in vasat harchi hast ekhtlaf ye taraf ba block khodesh
     * nabarabar khochik tarin az rast o chap - block
     * <p>
     * for right side countinue finding bigest till  the end
     *
     * @param numbers
     * @return rainAmount
     */
    private static int getRain(int[] numbers) {
        int rainAmount = 0;
        int leftSideMaxBlock = 0;
        int rightSideMinBlock = 0;
        for (int i = 1; i < numbers.length - 1; i++) {
            //RESET IT WHEN WE PASS THAT MAXIMUM
            leftSideMaxBlock = 0;

            if (leftSideMaxBlock < numbers[i - 1]) leftSideMaxBlock = numbers[i - 1];
            for (int j = i + 1; j < numbers.length; j++) {
                if (rightSideMinBlock < numbers[j]) rightSideMinBlock = numbers[j];

            }

            int minOfNearboorhood = Math.min(leftSideMaxBlock, rightSideMinBlock);
            int tempRainAmount = minOfNearboorhood - numbers[i];


            if (tempRainAmount > 0) {
                System.out.println();
                System.out.println("BLOCK NUMMBER   ____ " + (i + 1));
                System.out.println("leftside maxt  ____ " + leftSideMaxBlock);
                System.out.println("rightside maxt  ____ " + rightSideMinBlock);
                System.out.println("current nearhood  " + minOfNearboorhood);
                System.out.println("current block has " + numbers[i] + " blocks");
                System.out.println("rain in block numbber " + (i + 1) + " 13is :" + tempRainAmount);
                rainAmount += tempRainAmount;
            }
        }
        return rainAmount;
    }
}
