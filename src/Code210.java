import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Code210 {


    /**
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public static int[] findOrder(int numCourses, int[][] prerequisites) {

        int[] arr = new int[numCourses];
        List<List<Integer>> list = new ArrayList<>();
        // bfs 要计算入度
        int[] index = new int[numCourses];
        for (int i = 0;i<numCourses;i++) {
            list.add(new ArrayList<>());
        }
        for (int i=0;i<prerequisites.length;i++) {
            if(!list.get(prerequisites[i][1]).contains(prerequisites[i][0])) {
                list.get(prerequisites[i][1]).add(prerequisites[i][0]);
            }
            index[prerequisites[i][0]]++;
        }

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0;i<numCourses;i++) {
            if (index[i] == 0) {
                queue.add(i);
            }
        }

        if(queue.isEmpty()) {
            return new int[0];
        }

        List<Integer> ans =  new ArrayList<>();
        while (!queue.isEmpty()) {
            int start = queue.poll();
            ans.add(start);
            for (Integer end: list.get(start)) {
                index[end]--;
                if(index[end] == 0) {
                    queue.add(end);
                }

            }
        }

        if(ans.size() == numCourses) {
            return ans.stream().mapToInt(i->i).toArray();
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] arr = findOrder(2, new int[][]{{1,0}});

        int a = 1;
    }



}
