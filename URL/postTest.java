package java.URL;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

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
        CookieHandler.setDefault(new CookieManager(null, CookiePolicy.ACCEPT_ALL));
        String result = doPost(new URL(url),props, userAgent == null ? null : userAgent.toString(),
                redirects == null? -1 : Integer.parseInt(redirects.toString()));
      System.out.println(result);
        }
        public static String doPost(URL url, Map<Object,Object> nameValuePairs, String userAgent,
                                  int redirects) throws IOException {
            HttpsURLConnection connection = (HttpsURLConnection)url.openConnection();
            if(userAgent != null)
                connection.setRequestProperty("User-Agent",userAgent);
            if(redirects >= 0)
                connection.setInstanceFollowRedirects(false);
            connection.setDoOutput(true);
            try(PrintWriter out = new PrintWriter(connection.getOutputStream())){
                boolean first = true;
                for (Map.Entry<Object,Object> pair : nameValuePairs.entrySet()){
                    if(first)
                        first=false;
                    else out.print('&');
                    String name = pair.getKey().toString();
                    String value = pair.getValue().toString();
                    System.out.println(name + "=" + URLEncoder.encode(value,"UTF-8"));
                }
            }
            String encoding = connection.getContentEncoding();
            if (encoding == null)
                encoding = "UTF-8";
            if(redirects > 0 )
            {
                int responseCode = connection.getResponseCode();
                if(responseCode == HttpsURLConnection.HTTP_MOVED_PERM
                        || responseCode == HttpsURLConnection.HTTP_MOVED_TEMP
                        || responseCode == HttpsURLConnection.HTTP_SEE_OTHER)
                {
                    String location = connection.getHeaderField("Location");
                    System.out.println(location);
                    if(location != null)
                    {
                        URL base = connection.getURL();
                        connection.disconnect();
                        return doPost(new URL(base,location),nameValuePairs,userAgent,redirects-1);
                    }
                }
            }
            StringBuilder response = new StringBuilder();
            try(Scanner in = new Scanner(connection.getInputStream(),encoding)){
                while(in.hasNextLine()){
                    String line = in.nextLine();
                    response.append(line);
                    response.append("\n");
                }
            }catch (IOException e){
                InputStream er = connection.getErrorStream();
                if (er == null) throw e;
                try(Scanner in = new Scanner(er)){
                    response.append(in.nextLine());
                    response.append("\n");
                }
            }
            return response.toString();
        }
}
