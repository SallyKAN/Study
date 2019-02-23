package java.JDBC;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class readLOB {
    public static void main(String args[])throws SQLException,IOException{
        Connection conn = jdbcUtils.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        InputStream inputStream = null;
        try{
            statement = conn.createStatement();
            String sql = "select p.photo from photo p where id = 1";
            resultSet = statement.executeQuery(sql);
            resultSet.next();
            inputStream = resultSet.getBinaryStream("photo");
            imageUtils.readBlob(inputStream,"D:\\test.png");

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                if (inputStream!= null)
                    inputStream.close();
            }catch (IOException e){
                e.printStackTrace();
            }finally {
                try {
                    if (resultSet != null)
                        resultSet.close();
                }catch (SQLException e ){
                    e.printStackTrace();
                }finally {
                    if (statement != null)
                        if (statement != null)
                            try{
                                statement.close();
                            }catch (SQLException e){
                                e.printStackTrace();
                            }finally {
                                if (conn != null)
                                    try {
                                        conn.close();
                                    }catch (SQLException e){
                                       e.printStackTrace();
                                    }
                            }
                }
            }
        }

    }
}
