package 矩阵.LeetCode54螺旋矩阵;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        List<Integer> list = new Solution().spiralOrder(matrix);
        System.out.println(list);
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int a, b, c, d;
        a = 0;
        b = m - 1;
        c = 0;
        d = n - 1;
        int count = 0;
        List<Integer> list = new ArrayList<>();
        while (count != m * n) {
            for (int j = c; j <= d; j++) {
                list.add(matrix[a][j]);
                count++;
            }
            a++;
            if (check(m, n, count)) {
                break;
            }
            for (int i = a; i <= b; i++) {
                list.add(matrix[i][d]);
                count++;
            }
            d--;
            if (check(m, n, count)) {
                break;
            }
            for (int j = d; j >= c; j--) {
                list.add(matrix[b][j]);
                count++;
            }
            b--;
            if (check(m, n, count)) {
                break;
            }
            for (int i = b; i >= a; i--) {
                list.add(matrix[i][c]);
                count++;
            }
            c++;
            if (check(m, n, count)) {
                break;
            }
        }

        return list;
    }

    private boolean check(int m, int n, int count) {
        return count == m * n;
    }
}
