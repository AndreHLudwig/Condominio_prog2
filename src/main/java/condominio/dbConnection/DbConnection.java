package condominio.dbConnection;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DbConnection {
    private Properties prop = new Properties();
    public Connection getConnection() {
        try {
            prop.load(new FileInputStream("config.properties"));
            String jdbcUrl = prop.getProperty("jdbcUrl");
            String user = prop.getProperty("user");
            String password = prop.getProperty("password");

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(jdbcUrl, user, password);
            System.out.println("Conectado ao banco de dados " + con.toString());

            return con;

        } catch (
                Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
