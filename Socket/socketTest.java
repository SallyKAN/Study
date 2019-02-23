package java.Socket;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class socketTest {
    public static void main(String args[])throws IOException{
        try(Socket s = new Socket("time-a.nist.gov",13);
            Scanner in = new Scanner(s.getInputStream(),"UTF-8"))
        {
            while (in.hasNextLine())
            {
                String line = in.nextLine();
                System.out.print(line);
            }
        }
        InetAddress[] addresses = InetAddress.getAllByName("google.com");
        for (InetAddress a: addresses) {
            System.out.println(a);
        }
        InetAddress localAddress = InetAddress.getLocalHost();
        System.out.println(localAddress);
    }
}
