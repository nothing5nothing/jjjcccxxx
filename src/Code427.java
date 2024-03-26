import tool.node4.Node;

public class Code427 {

    public static Node construct(int[][] grid) {
        return creadeNode(grid,0,0,grid.length);
    }

    public static Node creadeNode(int[][] grid, int i0,int j0, int lenx) {
        if(lenx == 1) {
            return new Node(checkValue(grid,i0,j0,i0+1,j0+1).val, true);
        }
        NodeStatus status = checkValue(grid, i0, j0, i0+lenx,j0+lenx);
        if (status.isLeaf) {
            return new Node(status.val, true);
        }

        return new Node(false,false,
                creadeNode(grid,i0,j0,lenx/2),
                creadeNode(grid,i0,j0+lenx/2,lenx/2),
                creadeNode(grid,i0+lenx/2,j0,lenx/2),
                creadeNode(grid,i0+lenx/2,j0+lenx/2,lenx/2));
    }


    public static NodeStatus checkValue(int[][] grid, int i0, int j0, int i1, int j1) {
        int ans =grid[i0][j0];
        for (int i = i0;i<i1;i++){
            for (int j= j0;j<j1;j++) {
                if(grid[i][j] != ans) {
                    return new NodeStatus(false,false);
                }
            }
        }
        return new NodeStatus(true, ans == 1);
    }

    public static void main(String[] args) {
        Node node = construct(new int[][]{
                {1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},{1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1},{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0}
        });
        int i =1;

    }

    static class NodeStatus {
        boolean isLeaf;
        boolean val;

        public NodeStatus(boolean isLeaf, boolean val) {
            this.isLeaf = isLeaf;
            this.val = val;
        }
    }


}
