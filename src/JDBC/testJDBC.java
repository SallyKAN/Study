package JDBC;

public class testJDBC{
    public static void main(String args[])throw IOException{
        try{
            runTest()
        }catch (SQLException e){
            for (Throwable t:e)
                t.printStackTrace();
        }
    }
    public static void runTest()throws IOException,SQLException
    {
        try(Connection conn = getConnection();
            Statement stat = conn.createStatement()
        )
        {
            stat.executeUpdate("CREATE TABLE Greetings(Message CHAR(20)");
            stat.executeUpdate("INSERT INTO Greetings VALUES('Hello,world')");
            try (ResultSet result = state.executeQuery("SELECT * FROM Greetings"))
            {
                if (result.next())
                    System.out.println(result.getString(1));
            }
            stat.executeUpdate("DROP TABLE Greetings");
        }
    }

    public static Connection getConnection() throws SQLException, IOException{
        Properties props = new Properties();
        try(InputStream in = Files.newInputStream(Paths.get("database.properties")))
        {
            props.load(in);
        }
        String drivers = props.getProperty("jdbc.drivers");
        if(drivers!=null) System.out.println("jdbc.drivers",drivers);
        String url = props.getProperty("jdbc.url");
        String username = props.getProperty("jdbc.username");
        String password = props.getProperty("jdbc.password");

        return DriverManager.getConnection(url,username,password);

    }


}