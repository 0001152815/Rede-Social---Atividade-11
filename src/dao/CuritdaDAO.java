package dao;

import model.Curtida;
import util.ConexaoBD;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.List;

public class CurtidaDAO {

    // Método solicitado: curtir(int usuarioId, int postagemId)
    public boolean curtir(int usuarioId, int postagemId) {
        // Verifica se a curtida já existe antes de inserir
        if (verificarSeCurtiu(usuarioId, postagemId)) {
            System.out.println("Usuário já curtiu esta postagem.");
            return false;
        }

        String sql = "INSERT INTO curtida (usuarioId, postagemId, dataCurtida) VALUES (?, ?, ?)";
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = ConexaoBD.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, usuarioId);
            stmt.setInt(2, postagemId);
            stmt.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Erro ao curtir postagem: " + e.getMessage());
            return false;
        } finally {
            ConexaoBD.fechar(conn, stmt);
        }
    }

    // Método solicitado: descurtir(int usuarioId, int postagemId)
    public boolean descurtir(int usuarioId, int postagemId) {
        String sql = "DELETE FROM curtida WHERE usuarioId = ? AND postagemId = ?";
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = ConexaoBD.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, usuarioId);
            stmt.setInt(2, postagemId);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Erro ao descurtir postagem: " + e.getMessage());
            return false;
        } finally {
            ConexaoBD.fechar(conn, stmt);
        }
    }

    // Método solicitado: verificarSeCurtiu(int usuarioId, int postagemId)
    public boolean verificarSeCurtiu(int usuarioId, int postagemId) {
        String sql = "SELECT COUNT(*) FROM curtida WHERE usuarioId = ? AND postagemId = ?";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = ConexaoBD.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, usuarioId);
            stmt.setInt(2, postagemId);
            rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
            return false;
        } catch (SQLException e) {
            System.err.println("Erro ao verificar curtida: " + e.getMessage());
            return false;
        } finally {
            ConexaoBD.fechar(conn, stmt, rs);
        }
    }

    // Método solicitado: contarCurtidas(int postagemId)
    public int contarCurtidas(int postagemId) {
        String sql = "SELECT COUNT(*) AS total FROM curtida WHERE postagemId = ?";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = ConexaoBD.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, postagemId);
            rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt("total");
            }
            return 0;
        } catch (SQLException e) {
            System.err.println("Erro ao contar curtidas: " + e.getMessage());
            return 0;
        } finally {
            ConexaoBD.fechar(conn, stmt, rs);
        }
    }
}