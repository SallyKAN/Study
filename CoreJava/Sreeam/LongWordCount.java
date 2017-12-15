import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongWordCount {

    public static void main(String[] args) throws IOException {
        String contents = new String(Files.readAllBytes(Paths.get("alice30.txt")), StandardCharsets.UTF_8);
        //System.out.println(contents);
        List<String> words = Arrays.asList(contents.split("\\PL+"));
        long cout = words.stream().filter(w -> w.length()>12).count();
        // for(String w:words){
        //   if( w.length()>12)
        // cout++;
        //}
        System.out.println(cout);
    }
}