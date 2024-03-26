import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Code120 {
    public static int minimumTotal(List<List<Integer>> triangle) {
        int height = triangle.size();
        int k =0;
        List<List<Integer>> index = new ArrayList<>();
        int max = 0;
        while(k < height){
            List<Integer> temp = new ArrayList<>();
            if(k==0) {
                temp.add(triangle.get(k).get(0));
            } else {
                temp.add(triangle.get(k).get(0) + index.get(k-1).get(0));
            }
            index.add(temp);
            if(k == height-1) {
                max = index.get(k).get(0);
            }
            k++;
        }

        for(int i=1;i<height;i++){
            for(int j =1;j<=i;j++){
                if(j==i) {
                    index.get(i).add(index.get(i-1).get(j-1) + triangle.get(i).get(j));
                    if(i == height-1) {
                        max = Math.min(max, index.get(i).get(j));
                    }
                    continue;
                }
                index.get(i).add(Math.min(
                        index.get(i-1).get(j-1) + triangle.get(i).get(j),
                        index.get(i-1).get(j) + triangle.get(i).get(j)
                ));
                if(i == height-1) {
                    max = Math.min(max, index.get(i).get(j));
                }
            }
        }

        return max;


    }

    public static void main(String[] args) {

        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(2));
        list.add(Arrays.asList(3,4));
        list.add(Arrays.asList(6,5,7));
        list.add(Arrays.asList(4,1,3,8));
        System.out.println(minimumTotal(list));

    }



}
