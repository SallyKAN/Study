package java.mail;

import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;

public class mailTest {
    public static void main (String[] agrs) throws IOException, MessagingException {
        final String username ="snapekang@gmail.com";
        final String password = "kangjiayuan1119";
        Properties props = new Properties();
        try(InputStream in = Files.newInputStream(Paths.get("resources/mail.properties")))
        {
            props.load(in);
        }
        List<String> lines = Files.readAllLines(Paths.get(agrs[0]), Charset.forName("UTF-8"));
        String from = lines.get(0);
        String to = lines.get(1);
        String subject = lines.get(2);

        StringBuilder builder = new StringBuilder();
        for(int i =1; i < lines.size();i++)
        {
            builder.append(lines.get(i));
            builder.append("\n");
        }
//        System.out.print("input:");
////        Console console = System.console();
//        Scanner in = new Scanner(System.in);
////        String password = new String(readPassword("Password:"));
//        String password = in.nextLine();
        Session mailSession = Session.getDefaultInstance(props);
        try{
        mailSession.setDebug(true);
        MimeMessage message = new MimeMessage(mailSession);
        message.setFrom(new InternetAddress(from));
        message.addRecipient(RecipientType.TO , new InternetAddress(to));
        message.setSubject(subject);
        message.setText(builder.toString());
        Transport tr = mailSession.getTransport();
        tr.connect(username,password);
        tr.send(message,message.getAllRecipients());
            tr.close();
        }catch (MessagingException e){
            throw new RuntimeException(e);
        }
//        if (agrs.length > 0)
//            InputStream inputStream = Files.newInputStream(Paths.get(agrs[0]));
//        else
//            InputStream inputStream = Files.newInputStream(Paths.get("resources/message.txt"));
    }
}
