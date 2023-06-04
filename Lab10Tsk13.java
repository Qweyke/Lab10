import java.io.*;
import java.util.*;
public class Lab10Tsk13 {
    public static void main(String[] args) throws IOException {
        int k = 2; int p = 2; int n = 3;
        int[][][] array1 = new int[k][n][n];
        Scanner in = new Scanner(new File("C:\\Users\\Rirva\\Desktop\\filexsi\\t13.1.txt"));
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < n; l++) {
                    array1[i][j][l] = in.nextInt();
                }
            }
        }
        System.out.println("Содержимое первого файла:");
        for (int[][] matrix : array1) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
        int[][][] array2 = new int[p][n][n];
        Scanner in1 = new Scanner(new File("C:\\Users\\Rirva\\Desktop\\filexsi\\t13.2.txt"));
        for (int i = 0; i < p; i++) {
            for (int j = 0; j < n; j++) {
                for (int m = 0; m < n; m++) {
                    array2[i][j][m] = in1.nextInt();
                }
            }
        }
        System.out.println("Содержимое второго файла:");
        for (int[][] matrix : array2) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
        int minSum = Integer.MAX_VALUE;
        int[][] minMatrix = null;
        for (int[][] matrix : array1) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += matrix[i][i];
            }
            if (sum < minSum) {
                minSum = sum;
                minMatrix = matrix;
            }
        }
        boolean flag = true;
        for (int[][] matrix : array2) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += matrix[i][i];
            }
            if (sum <= minSum) {
                flag = false;
                break;
            }
        }
        if (flag) {
            PrintWriter fwr = new PrintWriter(new FileWriter("C:\\Users\\Rirva\\Desktop\\filexsi\\t13.2.txt", true));
            fwr.write("\nВывод\n");
            fwr.println();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    fwr.print(minMatrix[i][j] + " ");
                }
                fwr.println();
            }
            fwr.flush();
            fwr.close();
        }
    }
}
