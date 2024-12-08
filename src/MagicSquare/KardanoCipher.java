package MagicSquare;

import java.util.*;

public class KardanoCipher {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the size of the square (even number): ");
        int n = scanner.nextInt();
        if (n % 2 != 0) {
            System.out.println("Size must be an even number.");
            return;
        }

        int[][] grid = new int[n][n];
        int totalOnes = (n * n) / 4;
        fillGridWithRandomOnes(grid, totalOnes);

        System.out.println("Generated Cardano grid:");
        printGrid(grid);
    }

    public static void fillGridWithRandomOnes(int[][] grid, int count) {
        Random random = new Random();
        int n = grid.length;
        int placed = 0;

        while (placed < count) {
            int row = random.nextInt(n);
            int col = random.nextInt(n);

            if (grid[row][col] == 0) {
                grid[row][col] = 1;
                placed++;
            }
        }
    }

    public static int[][] rotateGrid(int[][] grid) {
        int n = grid.length;
        int[][] rotated = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][n - i - 1] = grid[i][j];
            }
        }
        return rotated;
    }

    public static void printGrid(int[][] grid) {
        for (int[] row : grid) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
