package java.JDBC;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

