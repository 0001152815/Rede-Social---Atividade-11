package dao;

import model.Usuario;
import util.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date; // Para manipular data

public class UsuarioDAO {

    /**
     * Implementa salvar(Usuario usuario).
     * Insere um novo usuário no banco de dados.
     */
    public boolean salvar(Usuario usuario) {
        // SQL para INSERT: nome, email, senha, dataCadastro
        String sql = "INSERT INTO usuario (nome, email, senha, dataCadastro) VALUES (?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = ConexaoBD.getConnection();
            if (conn == null) return false;

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());
            // Converte LocalDate para java.sql.Date
            stmt.setDate(4, Date.valueOf(usuario.getDataCadastro()));

            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Erro ao salvar usuário: " + e.getMessage());
            e.printStackTrace();
            return false;
        } finally {
            // Fecha os recursos: Statement e Connection
            ConexaoBD.fechar(conn, stmt);
        }
    }

    /**
     * Implementa atualizar(Usuario usuario).
     * Atualiza o nome, email e/ou senha de um usuário existente.
     */
    public boolean atualizar(Usuario usuario) {
        String sql = "UPDATE usuario SET nome = ?, email = ?, senha = ? WHERE id = ?";
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = ConexaoBD.getConnection();
            if (conn == null) return false;

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());
            stmt.setInt(4, usuario.getId()); // Usado para identificar o registro a ser atualizado

            int rowsAffected = stmt.executeUpdate();

            // Retorna true se pelo menos uma linha foi afetada (atualizada)
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar usuário: " + e.getMessage());
            e.printStackTrace();
            return false;
        } finally {
            ConexaoBD.fechar(conn, stmt);
        }
    }

