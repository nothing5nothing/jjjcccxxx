import java.util.*;

public class Code207 {

    // 超时
    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, List<int[]>> map = new HashMap<>();
        for(int[] arr :prerequisites) {
            if(map.containsKey(arr[0])) {
                List<int[]> list = map.get(arr[0]);
                list.add(arr);
                map.put(arr[0], list);
            } else {
                List<int[]> list = new ArrayList<>();
                list.add(arr);
                map.put(arr[0],list );
            }
        }

        for(int[] arr :prerequisites) {
            List<Integer> list = new ArrayList<>();
            list.add(arr[0]);
            if(!dfs(map, arr, list)){
                return false;
            }
        }
        return true;
    }


    public static boolean dfs(Map<Integer, List<int[]>> map, int[] arr, List<Integer> start) {

        int end = arr[1];
        // 边界
        if(!map.containsKey(end)) {
            return true;
        }
        if(start.contains(end)){
            return false;
        }
        start.add(end);
        List<int[]> nexts = map.get(end);
        for(int[] next : nexts) {
            if(!dfs(map, next, start)){
                return false;
            }
            if(start.contains(end)){
                start.remove(start.indexOf(end));
            }
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println(canFinish(2,new int[][]{
                {1,0},{0,3},{0,2},{3,2},{2,5},{4,5},{5,6},{2,4}
        }));
    }
}
