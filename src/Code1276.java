import java.util.ArrayList;
import java.util.List;

public class Code1276 {


    public static List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {

        int a = tomatoSlices;
        int b = cheeseSlices;
        List<Integer> value = new ArrayList<>();
        if((a-2*b)%2 !=0 || (4*b-a)%2 != 0) {
            return value;
        }
        if ((a-2*b)/2 < 0 || (4*b-a)/2 < 0) {
            return value;
        }
        value.add((a-2*b)/2);
        value.add((4*b-a)/2);


        return value;
    }


    public static void main(String[] args) {
        numOfBurgers(17,4).forEach(System.out::println);
    }
}
