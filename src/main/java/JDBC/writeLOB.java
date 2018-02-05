package JDBC;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class writeLOB {

    public static void main(String args[]) throws IOException, SQLException {
        Connection conn = jdbcUtils.getConnection();
        PreparedStatement preparedStatement = null;
        InputStream inputStream = null;
        inputStream = imageUtils.getImageByte("C:\\Users\\v_kangjiayuan\\IdeaProjects\\Study\\src\\java\\JDBC\\shixi.png");
        try{
            String sql = "insert into photo(id,name,photo) values(?,?,?)";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, "shixi");
            preparedStatement.setBinaryStream(3, inputStream,
                    inputStream.available());
            preparedStatement.execute();
        } catch (SQLException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if (inputStream != null)
                    inputStream.close();
            }catch (IOException e){
                e.printStackTrace();
            }finally {
                try {
                    conn.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }

    }
}
