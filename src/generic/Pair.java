package generic;

import java.time.LocalDate;
import java.util.Date;

public class Pair<T> {


    T first;
    T secont;

    public Pair(T first, T secont) {
        this.first = first;
        this.secont = secont;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getSecont() {
        return secont;
    }

    public void setSecont(T secont) {
        this.secont = secont;
    }


}

class DateInterval extends Pair<LocalDate> {

    public DateInterval(LocalDate first, LocalDate secont) {
        super(first, secont);
    }

    /*
    类型擦除为
    public void setSecont(LocalDate secont) {
        ...
    }
    而父类Pair类型擦除为：
    public void setSecont(Object secont) {
        ...
    }
    编译器建立桥方法：
    public void setSecont(Object secont) {
        setSecont((LocalDate)secont)
        ...
    }
     */
    @Override
    public void setSecont(LocalDate secont) {
        if(secont.compareTo(getFirst())>0) {
            super.setSecont(secont);
        }
    }

    public static void main(String[] args) {
        Pair[] pair = new Pair[2];
        // 错 不能使用 new Pair<String>[1];初始化数组
        // Pair<String>[] pair = new Pair<String>[1];
        pair[0] = new Pair<String>("1", "2");
        pair[1] = new Pair<Integer>(1,2);
        System.out.println(pair[0].getFirst()); // 1
        System.out.println(pair[1].getFirst()); // 1
    }
}

