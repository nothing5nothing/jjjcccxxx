package generic.test1;

import java.util.Arrays;

public class Employee {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Pair<T> {
    private T first;
    public T getFirst() {
        return first;
    }
    public void setFirst(T first) {
        this.first = first;
    }
    public void setValue(Manager[] a, Pair<? super Manager> pair) {
        String adr = a[0].getAdress();
        pair.setFirst(new Manager(adr.strip()));
        // pair.setFirst(new Employee());  error
    }

    public static void main(String[] args) {
        Pair<?> pair = new Pair<>();
        Object o = pair.getFirst();


    }
}

class Manager extends Employee {

    public Manager(String adress) {
        this.adress = adress;
    }

    String adress;

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

}
