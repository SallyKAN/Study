package URL;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class postTest {
    public static void main(String[] args) throws IOException {
        String propsFileName = args.length > 0 ? args[0]:"resources/post.properties";
        Properties props = new Properties();
        try (InputStream inputStream = Files.newInputStream(Paths.get(propsFileName))){
            props.load(inputStream);
        }
        String url = props.remove("url").toString();
        Object userAgent = props.remove("User-Agent");
//      System.out.println(props.toString());
        Object redirects = props.remove("redirects");
//        System.out.println(props.toString());
//        System.out.println(url);
//        System.out.println(userAgent.toString());
//        System.out.println(redirects.toString());
        }
}
