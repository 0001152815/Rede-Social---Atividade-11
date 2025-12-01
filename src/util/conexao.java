package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoBD {

    private static final String URL = "jdbc:mysql://localhost:3306/minitok";
    private static final String USUARIO = "root";
    private static final String SENHA = "";

    /**
     * Implementa getConnection() para abrir conexões com o BD.
     */
    public static Connection getConnection() {
        try {
            Class.forName(DRIVER); // Carrega o driver
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (ClassNotFoundException e) {
            System.err.println("Erro: Driver JDBC não encontrado.");
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Implementa fechar() para encerrar recursos.
     */
    public static void fechar(Connection conn, PreparedStatement stmt, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            System.err.println("Erro ao fechar recursos do BD: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void fechar(Connection conn, PreparedStatement stmt) {
        fechar(conn, stmt, null);
    }

    public static void fechar(Connection conn) {
        fechar(conn, null, null);
    }
}