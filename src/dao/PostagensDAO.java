package dao;

import model.Postagem;
import util.ConexaoBD;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PostagemDAO {

    // Método solicitado: salvar(Postagem postagem)
    public boolean salvar(Postagem postagem) {
        String sql = "INSERT INTO postagem (usuarioId, conteudo, dataPostagem) VALUES (?, ?, ?)";
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = ConexaoBD.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, postagem.getUsuarioId());
            stmt.setString(2, postagem.getConteudo());
            stmt.setTimestamp(3, Timestamp.valueOf(postagem.getDataPostagem()));
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Erro ao salvar postagem: " + e.getMessage());
            return false;
        } finally {
            ConexaoBD.fechar(conn, stmt);
        }
    }

    // Método solicitado: atualizar(Postagem postagem)
    public boolean atualizar(Postagem postagem) {
        String sql = "UPDATE postagem SET conteudo = ?, dataPostagem = ? WHERE id = ?";
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = ConexaoBD.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, postagem.getConteudo());
            stmt.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now())); // Atualiza a data
            stmt.setInt(3, postagem.getId());
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar postagem: " + e.getMessage());
            return false;
        } finally {
            ConexaoBD.fechar(conn, stmt);
        }
    }

    // Método solicitado: deletar(int id)
    public boolean deletar(int id) {
        String sql = "DELETE FROM postagem WHERE id = ?";
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = ConexaoBD.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Erro ao deletar postagem: " + e.getMessage());
            return false;
        } finally {
            ConexaoBD.fechar(conn, stmt);
        }
    }

    // Método solicitado: buscarPorId(int id)
    public Postagem buscarPorId(int id) {
        String sql = "SELECT * FROM postagem WHERE id = ?";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = ConexaoBD.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                return new Postagem(
                        rs.getInt("id"),
                        rs.getInt("usuarioId"),
                        rs.getString("conteudo"),
                        rs