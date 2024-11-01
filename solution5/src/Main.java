public class Main {
    public static void main(String[] args) {
        int n = 100;
        int[][] pascal = new int[n][];

        for (int i = 0; i < n; i++) {
            pascal[i] = new int[i + 1];
            pascal[i][0] = 1;
            pascal[i][i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < i; j++) {
                pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
            }
        }

        boolean flag = false;
        for (int i = 0; i < n; i++) {
            if (flag) {
                break;
            }
            for (int j = 0; j < pascal[i].length; j++) {
                System.out.print(pascal[i][j]);

                if (pascal[i][j] >= 20) {
                    flag = true;
                }
            }
            System.out.println();
        }
    }
}