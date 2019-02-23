package java.JDBC;

import java.io.IOException;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Scanner;

public class execSQLUtils {
    public static void main(String args[]){
        try(Scanner in = (args.length == 0) ? new Scanner(System.in) : new Scanner(Paths.get(args[0]), "UTF-8"))
        {
           try(Connection conn = jdbcUtils.getConnection();
               Statement stat = conn.createStatement())
           {
               while (true){
                   if (args.length == 0) System.out.println("enter command or EXIT to exit:");
                   if (!in.hasNext()) return;

                   String line = in.nextLine().trim();
                   if (line.equalsIgnoreCase("EXIT")) return;
                   if (line.endsWith(";"))
                   {
                       line = line.substring(0,line.length()-1);
                   }
                   try{
                       Boolean result = stat.execute(line);
                       if(result)
                       {
                           try (ResultSet rs = stat.getResultSet())
                           {
                               showResult(rs);
                           }
                       }else
                       {
                           int updateCount = stat.getUpdateCount();
                           System.out.println(updateCount + "rows updated");
                       }
                   }catch (SQLException e){
                       e.printStackTrace();
                   }
               }
           } catch (SQLException e) {
               e.printStackTrace();
           } catch (IOException e) {
               e.printStackTrace();
           }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void showResult(ResultSet resultSet)throws SQLException{
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        int columCount = resultSetMetaData.getColumnCount();
        for(int i=1; i<= columCount;i++)
        {
            if(i>1)System.out.println(",");
            System.out.print(resultSetMetaData.getColumnLabel(i));
        }
        System.out.println();
        while (resultSet.next())
        {
            for (int i=1;i<=columCount;i++)
            {
                if(i>1)System.out.print(",");
                System.out.print(resultSet.getString(i));

            }
            System.out.println();
        }
    }
}
