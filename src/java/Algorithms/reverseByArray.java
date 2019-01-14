package java.Algorithms;

public class reverseByArray {
    public static void main(String[] agrs){
        String st = "hello";
        long start = System.nanoTime();
        char[] strArray = st.toCharArray();
        for (int i=0; i<strArray.length/2;i++){
             char temp = strArray[i];
             strArray[i] = strArray[strArray.length - i -1];
            strArray[strArray.length - i -1] = temp;
        }
        String newstr = new String(strArray);
        long end = System.nanoTime();
        System.out.println(newstr+" " + "time:"+ (end-start)/1000000d + "ms");

//        compare with StringBuilder reverse method
        long start1 = System.nanoTime();
        StringBuilder sb = new StringBuilder(st);
        String newStr = sb.reverse().toString();
        long end1 = System.nanoTime();
        System.out.println(newStr+" " + "time:"+ (end1-start1)/1000000d + "ms");

    }

}
