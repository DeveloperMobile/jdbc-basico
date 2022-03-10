package part1;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionJDBC {
    public static void main(String[] args) {
        String driver = "mysql";
        String dataBaseAddress = "localhost";
        String dataBaseName = "digital_innovation_one";
        String user = "root";
        String password = "developer";

        StringBuilder sb = new StringBuilder("jdbc:")
                .append(driver).append("://")
                .append(dataBaseAddress).append("/")
                .append(dataBaseName);

        String connectionUrl = sb.toString();

        Connection conn = null;

        try {
            conn = DriverManager.getConnection(connectionUrl, user, password);
            System.out.println("SUCESSO ao se concetar ao banco MySQL!");
            JOptionPane.showMessageDialog(null,"SUCESSO ao se concetar ao banco MySQL!", "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "FALHA ao se conectar ao banco MySQL!", "ERRO", JOptionPane.ERROR_MESSAGE);
            System.out.println("FALHA ao se concetar ao banco MySQL!");
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
