package JDBC;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Properties;

public class TestDB {
    public static void main(String arg[])throws IOException
    {
        try
        {
            runTest();
        }catch (SQLException ex)
        {
            for (Throwable t: ex)
                t.printStackTrace();
        }
    }
    public static void runTest()throws IOException , SQLException{
        try(Connection conn = jdbcUtils.getConnection();
            Statement stat = conn.createStatement())
        {
            stat.executeUpdate("CREATE TABLE Greetings(Message CHAR(20))");
            stat.executeUpdate("INSERT INTO Greetings VALUES ('hello,world!')");
            try (ResultSet result = stat.executeQuery("SELECT * FROM Greetings"))
            {
                if (result.next())
                    System.out.println(result.getString(1));
            }
            //stat.executeUpdate("DROP TABLE Greetings");
        }
    }

}

