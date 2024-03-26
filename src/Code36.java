import com.sun.jdi.PathSearchingVirtualMachine;

public class Code36 {

    public static boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][9];
        int[][] col = new int[9][9];
        int[][][] index = new int[3][3][9];

        for (int i =0;i<9;i++) {
            for(int j=0;j<9;j++) {
                char c = board[i][j];
                if('.' == c) {
                    continue;
                }
                int value = c-'0'-1;
                row[i][value] += 1;
                col[value][j] += 1;
                index[i/3][j/3][value] +=1;
                if(row[i][value]>1 || col[value][j]>1 || index[i/3][j/3][value]>1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
