public class Code274 {

    public static int hIndex(int[] citations) {
        int len = citations.length;

        int begin = 0;
        int end = len;

        while (begin < end) {
            int mid = (begin+end+1)/2;
            int count = 0;
            for(int i : citations) {
                if(i>=mid) {
                    count ++;
                }
            }
            if( count>=mid) {
                //[ ]
                begin = mid;
            }else{
                //[ )
                end = mid-1;
            }
        }
        return begin;
    }

    public static void main(String[] args) {
        System.out.println(hIndex(new int[]{11,15}));
    }



}
