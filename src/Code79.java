public class Code79 {

    public static boolean exist = false;

    public static int[][] arr = new int[][]{
            {-1,0},{1,0},{0,1},{0,-1}
    };

    public static boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++) {
                dfs(board, new int[board.length][board[0].length],"", word, 0, 0);
            }
        }
        return exist;

    }

    public static void dfs(char[][] board, int[][] index ,String str, String word, int i, int j) {
        if (i < 0 || j < 0 || i > board.length-1 || j > board[0].length-1 || index[i][j] ==1) {
            return;
        }
        str = str + board[i][j];
        index[i][j] =1;
        if (!word.startsWith(str)) {
            return;
        }
        if(word.equals(str)) {
            exist=true;
        }
        for (int[] in : arr) {
            int ii = i + in[0];
            int jj = j + in[1];
            dfs(board, index, str, word, ii, jj);
            if (ii < 0 || jj < 0 || ii > board.length-1 || jj > board[0].length-1 ) {
                continue;
            }
            index[ii][jj] = 0;
        }
    }


    public static void main(String[] args) {

        System.out.println(exist(new char[][]{
                {'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}
        }, "ABCB"));
    }

}
