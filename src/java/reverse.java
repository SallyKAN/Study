public class reverse {
    public static void main(String[] args){
        String s = "hello";
        StringBuilder sb = new StringBuilder(s);
        System.out.println(sb.reverse().toString());
        String str = "";
        long startTime = System.nanoTime();
        for (int i =20000; i<50000;i++){
            str+= (char)i;
        }
        long endTime = System.nanoTime();
        System.out.println("time:"+(endTime-startTime)/1000000d + "ms" );
        StringBuilder xsb = new StringBuilder();
        long start = System.nanoTime();
        for (int i =20000; i<50000;i++){
            xsb.append((char)i);
        }
        long end = System.nanoTime();
        System.out.println("time:" + (end-start)/1000000d + "ms");
    }
}
