public class isMatrixContains {
    public static boolean isContains(int[][] matrix, int k) {
        if (matrix.length == 0 || matrix == null) {
            return false;
        }
        int rows = 0;
        int coms = matrix[rows].length - 1;
        while (rows < matrix.length && coms > -1) {
            if (matrix[rows][coms] > k) {
                coms--;
            } else if (matrix[rows][coms] < k) {
                rows++;
            } else {
                return true;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        int[][] test = new int[][]{{1,2,3},{4,5,10},{7,8,14}};
        System.out.println(isContains(test,14));
    }
}

