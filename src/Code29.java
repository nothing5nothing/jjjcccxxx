import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        List<int[]> power = new ArrayList<int[]>();
        for (int i = 0; i < m; ++i) {
            int l = 0, r = n - 1, pos = -1;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (mat[i][mid] == 0) {
                    r = mid - 1;
                } else {
                    pos = mid;
                    l = mid + 1;
                }
            }
            power.add(new int[]{pos + 1, i});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] pair1, int[] pair2) {
                if (pair1[0] != pair2[0]) {
                    return pair1[0] - pair2[0];
                } else {
                    return pair1[1] - pair2[1];
                }
            }
        });
        for (int[] pair : power) {
            pq.offer(pair);
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; ++i) {
            ans[i] = pq.poll()[1];
        }
        return ans;
    }

    public int[] testMethod(int[][] mat,int k) {
        int m = mat.length, n = mat[0].length;
        List<int[]> list = new ArrayList<>();

        for(int i = 0;i< mat.length;i++) {
            int l = 0, r = n - 1, pos = -1;
            while (l < r) {
                int mid = (l+r)/2;
                if (mat[i][mid] == 0) {
                   r = mid - 1 ;
                }else if(mat[i][mid] == 1) {
                    l = mid +1;
                    pos = mid;
                }
            }
            list.add(new int[]{pos +1,i});
        }
        PriorityQueue<int []> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                }else {
                    return o1[1] - o2[1];
                }
            }
        });

        for(int[] pair: list) {
            pq.offer(pair);
        }

        int ans[] = new int[k];
        for(int i =0;i<k;i++) {
            ans[i] = pq.poll()[1];
        }
        return ans;



    }
}

