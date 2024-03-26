public class Code45 {

    public static void main(String[] args) {
        System.out.println(jump1(new int[]{2,2,3,5,0,1,4}));
    }

    public static int jump(int[] nums) {
        int k = nums[0];
        int len = nums.length;
        int count = 0;
        int start=0;
        int end = 1;
        // 需要清晰地区分start, end在循环中的定义
        // start 是某一轮的开始,end是某一轮的结束
//        while (end < len) {
//            // 循环的是每一轮，
//            for(int j=start;j<end;j++) {
//                k = Math.max(k, nums[j] + j);
//            }
//            //后面一轮的开始从前一轮的结束起
//            start = end;
//            end = k + 1;
//            count++;
//        }

        for (;end<len;) {
            // 循环的是每一轮，
            for(int j=start;j<end;j++) {
                k = Math.max(k, nums[j] + j);
            }
            //后面一轮的开始从前一轮的结束起
            start = end;
            end = k + 1;
            count++;
        }
        return count;

    }


    public static int jump1(int[] nums) {
        int k = nums[0];
        int len = nums.length;
        int count = 0;
        int end = 0;
        for (int i =0; i< len; i++) {
            k = Math.max(k, nums[i] + i);
            // 到达其中一轮的结束
            // 记录数据
            if (i == end) {
                end = k;
                count ++;
            }
        }
        return count;

    }



}
