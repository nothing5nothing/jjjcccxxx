package reflact;


import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class ReflectTest implements Serializable {

    String name;

    public ReflectTest() {

    }

    public ReflectTest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ReflectTest{" +
                "name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, CloneNotSupportedException {

        Class<?> clazz = ReflectTest.class;

        Object obj = clazz.getConstructor().newInstance();
        Field[] fields = clazz.getDeclaredFields();
        for(Field field :fields) {
            field.setAccessible(true);
            field.set(obj, "jay");
        }
        System.out.println(obj.toString());
//        ReflectTest r1 = (ReflectTest)(new ReflectTest().clone());
//        r1.toString();
    }

}
