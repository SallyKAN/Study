package java.Socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MultiThreadServerDemo {
    public static void main(String agrs[]) {
        try (ServerSocket s = new ServerSocket(8189)) {
            int i = 1;
            while (true) {
                Socket incoming = s.accept();
                Runnable r = new ThreadedServerHandler(incoming);
                Thread t = new Thread(r);
                t.start();
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ThreadedServerHandler implements Runnable{
    private Socket incoming;
    public ThreadedServerHandler(Socket incoming){
        this.incoming = incoming;
    }
    public void run(){
        try (InputStream inputStream = incoming.getInputStream();
             OutputStream outputStream = incoming.getOutputStream())
        {
            Scanner in = new Scanner(inputStream,"UTF-8");
            PrintWriter out = new PrintWriter(new OutputStreamWriter(outputStream),true);
            out.println("Hello! enter fxxk to exit:");
            boolean done = false;
            while (!done && in.hasNextLine())
            {
                String line = in.nextLine();
                out.println("ECHO:" + line);
                if(line.trim().equals("fxxk"))
                    done = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
