import java.util.ArrayList;
import java.util.List;

public class Code202 {
    public boolean isHappy(int n) {
        List<Integer> list = new ArrayList<>();
        int value = n;
        while(value != 1 && !list.contains(value)) {
            list.add(value);
            value = getValue(value);
        }
        return value==1;
    }

    public static int getValue(int n) {
        int sum =0;
        while(n!=0) {
            int x = n%10;
            sum += x*x;
            n=n/10;
        }
        return sum;
    }

    public static void main(String[] args) {

    }

}
