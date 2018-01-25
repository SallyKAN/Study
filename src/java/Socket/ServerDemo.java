package Socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
*实现一个简单的监听端口8189的服务器demo，返回客户端请求
*
*
 */
public class ServerDemo {
    public static void main (String args[])throws IOException{
        try(ServerSocket s = new ServerSocket(8189))
        {
            try(Socket incoming = s.accept())
            {
                InputStream inputStream = incoming.getInputStream();
                OutputStream outputStream = incoming.getOutputStream();
                try(Scanner in = new Scanner(inputStream,"UTF-8"))
                {
                    PrintWriter out = new PrintWriter(new OutputStreamWriter(outputStream,"UTF-8")
                    ,true);
                    out.println("hello! enter BYE to exit:");
                    boolean done = false;
                    while (!done && in.hasNextLine())
                    {
                        String line = in.nextLine();
                        out.println("ECHO:"+line);
                        if (line.trim().equals("BYE"))
                            done = true;
                    }
                }
            }
        }
    }
}
