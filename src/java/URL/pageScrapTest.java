package URL;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URLConnection;
import java.net.URL;
import java.util.Scanner;

public class pageScrapTest {
    public static void main(String[] args) throws IOException {
        String urlString = "https://www.douban.com";
        URL url = new URL(urlString);
        URLConnection connection = url.openConnection();
        InputStream inputStream = connection.getInputStream();
        Scanner in = new Scanner(inputStream,"UTF-8");
        StringBuilder result = new StringBuilder();
        while (in.hasNextLine())
        {
          result.append(in.nextLine());
          result.append("\n");
        }
        PrintWriter out = new PrintWriter("douban.html","UTF-8");
        out.println(result);
//        System.out.println(System.getProperty("user.dir"));
    }
}
