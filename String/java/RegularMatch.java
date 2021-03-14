import java.util.regex.Pattern;

public class RegularMatch {
    public static void main(String[] args){
        String s = "Java now has regular expression";
        Pattern p1 = Pattern.compile("^Java");
        Pattern p2 = Pattern.compile("\\Breg.*");
        Pattern p3 = Pattern.compile("\\n.w\\s+h(a|i)s");
        Pattern p4= Pattern.compile("\\s?");
        Pattern p5 = Pattern.compile("\\s*");
        Pattern p6 = Pattern.compile("\\s+");
        Pattern p7 = Pattern.compile("\\s{4}");
        System.out.println("match1: "+p1.matcher(s).find());
        System.out.println("match2: "+p2.matcher(s).find());
        System.out.println("match3: "+p3.matcher(s).find());
        System.out.println("match4: "+p4.matcher(s).find());
        System.out.println("match5: "+p5.matcher(s).find());
        System.out.println("match6: "+p6.matcher(s).find());
        System.out.println("match7: "+p7.matcher(s).find());
    }
}
