package tool.normal;

public class NormalUtil {


    public static void sleep() {
        sleep(1000l);
    }

    public static void sleep(Long time) {
        try{
            Thread.sleep(time);
        } catch (InterruptedException e) {
            System.out.println("sleep wrong " + e.toString());
        }
    }
}
