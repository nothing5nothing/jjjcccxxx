package Code380;

import java.util.*;

public class RandomizedSet {

    /**
     * 用户数据--对应数组下标
     */
    private Map<Integer,Integer> map;

    private List<Integer> list;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if(map.containsKey(val)) {
            return false;
        }
        int index = list.size();
        map.put(val, index);
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if(!map.containsKey(val)) {
            return false;
        }
        int index = map.get(val);
        int last = list.get(list.size()-1);
        list.set(index, last);
        map.put(last,index);
        map.remove(val);
        list.remove(list.size()-1);
        return true;
    }

    public int getRandom() {
        return  list.get(new Random().nextInt(list.size()));
    }
}
