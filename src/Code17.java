import java.util.*;

public class Code17 {

    public static Map<Character, List<String>> map = new HashMap<Character, List<String>>()
    {
        {   put('2', Arrays.asList("a","b","c"));
            put('3', Arrays.asList("d","e","f"));
            put('4', Arrays.asList("g","h","i"));
            put('5', Arrays.asList("j","k","l"));
            put('6', Arrays.asList("m","n","o"));
            put('7', Arrays.asList("p","q","r","s"));
            put('8', Arrays.asList("t","u","v"));
            put('9', Arrays.asList("w","x","y","z"));
        }
    };

    public static List<String> letterCombinations(String digits) {
        if("".equals(digits)){
            return new ArrayList<>();
        }

        List<String> list = new ArrayList<>();
        dfs(digits, 0, "", list);
        return list;
    }


    public static void dfs(String digits, int index, String value,List<String> list) {
        if(index > digits.length() - 1) {
            list.add(value);
            return;
        }
        char c = digits.charAt(index);
        for(String s : map.get(c)) {
            value = value+s;
            dfs(digits, index+1, value, list);
            value = value.substring(0, value.length()-1);
        }
    }

    public static void main(String[] args) {
        List<String > list = letterCombinations("");
        list.stream().forEach(x-> System.out.print(x+" "));

    }
}
