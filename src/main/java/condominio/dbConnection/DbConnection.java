package condominio.dbConnection;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;

import java.util.Properties;

public class DbConnection {
    private static final Properties prop = new Properties();
    public static Connection getConnection() {
        try {
            prop.load(new FileInputStream("config.properties"));
            String jdbcUrl = prop.getProperty("jdbcUrl");
            String user = prop.getProperty("user");
            String password = prop.getProperty("password");

            Connection con = DriverManager.getConnection(jdbcUrl, user, password);
            System.out.println("Conectado ao banco de dados " + con.toString());

            return con;

        } catch (
                Exception e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }

        return null;
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Conexão fechada com sucesso.");
            } catch (Exception e) {
                System.out.println("Erro ao fechar conexão com banco de dados: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
