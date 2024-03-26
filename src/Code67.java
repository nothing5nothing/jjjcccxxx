public class Code67 {


    public static String addBinary(String a, String b) {
        int alen = a.length();
        int blen = b.length();

        int count =1 ;
        String value = "";
        boolean in = false;
        while (count <= alen || count <= blen) {
            char achar = count <= alen?a.charAt(alen-count):'0';
            char bchar = count <= blen?b.charAt(blen-count):'0';
            if(achar == '1' && bchar=='1'){
                String temp = in ? "1" : "0";
                in = true;
                value = temp + value;
            }else if(achar == '0' && bchar =='0') {
                String temp = in ? "1" : "0";
                in = false;
                value = temp + value;
            }else{
                String temp = in ? "0" : "1";
                value = temp + value;
            }
            count++;
        }
        if(in) {
            value = "1" + value;
        }

        return value;

    }

    public static void main(String[] args) {
        System.out.println( addBinary("1010","1011"));
        int a = 00000000000000000000000000001011;
        String s= String.valueOf(a);
        System.out.println(s+" " +a);
    }


}
