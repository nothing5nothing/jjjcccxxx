package generic.test1;

public class Test {

    public static int value() {

        int i;
        try{
            i=1;
            return i;

        }catch (Exception e){
            i=2;
            return i;
        }finally {
            i=3;

        }
    }

    public static void main(String[] args) {
        ClassLoader c  = new ClassLoader() {
            @Override
            public String getName() {
                return super.getName();
            }
        };
        System.out.println(value());
    }
}
