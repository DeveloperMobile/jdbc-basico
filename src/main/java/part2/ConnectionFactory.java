package part2;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
    // Construtor declarado como privado. Evitando assim criar instancias da fabrica.
    private ConnectionFactory() {
        throw new UnsupportedOperationException();
    }

    public static Connection getConnectrion() {
        Connection conn = null;
        try(InputStream input = ConnectionFactory.class.getClassLoader().getResourceAsStream("connection.properties")) {
            Properties prop = new Properties();
            prop.load(input);

            String driver  = prop.getProperty("jdbc.driver");
            String dataBaseAddress = prop.getProperty("db.address");
            String dataBaseName = prop.getProperty("db.name");
            String user = prop.getProperty("db.user.login");
            String password = prop.getProperty("db.user.password");

            StringBuilder sb = new StringBuilder("jdbc:")
                    .append(driver).append("://")
                    .append(dataBaseAddress).append("/")
                    .append(dataBaseName);

            String connectionUrl = sb.toString();

            conn = DriverManager.getConnection(connectionUrl, user, password);
        } catch (IOException e) {
            System.out.println("FALHA ao tentar carregar arquivos de propriedades");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("FALHA ao tentar criar conexão");
            throw new RuntimeException(e);
        }

        return conn;
    }
}
