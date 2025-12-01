package dao;

import model.Direct;
import util.ConexaoBD;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DirectDAO {

    // Método solicitado: enviarMensagem(Direct direct)
    public boolean enviarMensagem(Direct direct) {
        String sql = "INSERT INTO direct (remetenteId, destinatarioId, mensagem, dataEnvio) VALUES (?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = ConexaoBD.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, direct.getRemetenteId());
            stmt.setInt(2, direct.getDestinatarioId());
            stmt.setString(3, direct.getMensagem());
            stmt.setTimestamp(4, Timestamp.valueOf(direct.getDataEnvio()));
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Erro ao enviar mensagem direta: " + e.getMessage());
            return false;
        } finally {
            ConexaoBD.fechar(conn, stmt);
        }
    }

    // Método solicitado: listarMensagens(int usuario1Id, int usuario2Id)
    public List<Direct> listarMensagens(int usuario1Id, int usuario2Id) {
        // Seleciona mensagens enviadas de 1 para 2 OU de 2 para 1
        String sql = "SELECT * FROM direct " +
                "WHERE (remetenteId = ? AND destinatarioId = ?) OR (remetenteId = ? AND destinatarioId = ?) " +
                "ORDER BY dataEnvio ASC"; // Em ordem cronológica

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Direct> mensagens = new ArrayList<>();
        try {
            conn = ConexaoBD.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, usuario1Id);
            stmt.setInt(2, usuario2Id);
            stmt.setInt(3, usuario2Id); // Troca de posição
            stmt.setInt(4, usuario1Id);
            rs = stmt.executeQuery();

            while (rs.next()) {
                mensagens.add(new Direct(
                        rs.getInt("id"),
                        rs.getInt("remetenteId"),
                        rs.getInt("destinatarioId"),
                        rs.getString("mensagem"),
                        rs.getTimestamp("dataEnvio").toLocalDateTime()
                ));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar mensagens diretas: " + e.getMessage());
        } finally {
            ConexaoBD.fechar(conn, stmt, rs);
        }
        return mensagens;
    }
}