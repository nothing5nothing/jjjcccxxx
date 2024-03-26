package clone;

import java.io.*;

public class B implements Cloneable, Serializable{

    private A a;

    private int name;

    public B(A a, int name) {
        this.a = a;
        this.name = name;
    }

    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    @Override
    public B clone(){
        try{
            return (B) super.clone();
        } catch (CloneNotSupportedException e) {
            return  null;
        }
    }

    public B deepClone() {

        try{
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream os= new ObjectOutputStream(bos);
            os.writeObject(this);
            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream obs = new ObjectInputStream(bis);
            return (B) obs.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }


    public static void main(String[] args) {
        B b= new B(new A(10,2), 11);

        B b1 = b.clone();
        b1.getA().setName(100);

        B bDeep = b.deepClone();
        bDeep.getA().setName(101);

        if(b1==null) {
            System.out.println("b1 is null");
        }

    }
}
