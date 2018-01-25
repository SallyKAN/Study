package URL;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class URLConnectionTest {
    public static void main(String[] args) throws IOException {
        String urlname;
        if (args.length > 0) urlname = args[0];
        else urlname = "http://www.sallykang.com";
        URL url = new URL(urlname);
        URLConnection connection = url.openConnection();
        connection.connect();
        System.out.println("getContentType  " + connection.getContentType());
        System.out.println("getContentLength  " + connection.getContentLength());
        System.out.println("getContentEncoding  " + connection.getContentEncoding());
        System.out.println("getData  " + connection.getDate());
        System.out.println("getExpire  " + connection.getExpiration());
        System.out.println("getLastModified  " + connection.getLastModified());
        System.out.println("getUserCaches  " + connection.getUseCaches());
//        String encoding = connection.getContentEncoding();
//        if (encoding == null) encoding = "UTF-8";
//        try (Scanner in = new Scanner(connection.getInputStream(),encoding)){
//            for (int i =1; in.hasNextLine() && i<= 10; i++){
//                System.out.println(in.nextLine());
//            }
//        }
    }
}
