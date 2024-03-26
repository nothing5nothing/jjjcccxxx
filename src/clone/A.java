package clone;

import java.io.Serializable;

public class A implements Serializable {

    int length;

    int name;

    public A(int length, int name) {
        this.length = length;
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public int getName() {
        return name;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setName(int name) {
        this.name = name;
    }
}
