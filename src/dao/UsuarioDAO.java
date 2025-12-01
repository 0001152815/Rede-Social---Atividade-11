package dao;

import model.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe de Acesso a Dados (DAO) para a entidade Aluno.
 * Implementa todas as operações CRUD (Create, Read, Update, Delete).
 */
public class UsuarioDAO {

    /**
     * CREATE: Insere um novo aluno no BD.
     */
    public void inserir(Usuario usuario) {
        // Query SQL usa '?' (placeholders) para segurança (PreparedStatement).
        String sql = "INSERT INTO alunos (nome, email) VALUES (?, ?)";

        // try-with-resources: Garante o fechamento automático da Conexão e do PreparedStatement.
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Mapeamento do objeto Aluno para a Query SQL (1=nome, 2=email).
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());

            // Executa a instrução SQL de modificação (INSERT).
            stmt.executeUpdate();

            System.out.println("Usuario adicionado com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao inserir: " + e.getMessage());
        }
    }


    /**
     * READ ALL: Lista todos os alunos do BD.
     * @return Lista de objetos Aluno.
     */
    public List<Usuario> listar() {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM alunos";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             // executeQuery() retorna o ResultSet (conjunto de resultados).
             ResultSet rs = stmt.executeQuery()) {

            // Itera sobre cada linha retornada pelo banco de dados.
            while (rs.next()) {
                // Mapeamento reverso: Converte a linha do BD em um objeto Aluno.
                Usuario a = new Usuario(
                        rs.getInt("id"), // Pega o valor da coluna 'id'
                        rs.getString("nome"), // Pega o valor da coluna 'nome'
                        rs.getString("email") // Pega o valor da coluna 'email'
                );
                lista.add(a);
            }

        } catch (Exception e) {
            System.out.println("Erro ao listar: " + e.getMessage());
        }

        return lista;
    }


    /**
     * UPDATE: Atualiza os dados de um aluno existente pelo ID.
     */
    public void atualizar(Usuario usuario) {
        // A cláusula WHERE id = ? é essencial para garantir a atualização do registro correto.
        String sql = "UPDATE alunos SET nome = ?, email = ? WHERE id = ?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // 1. Novos valores para Nome e Email.
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());

            // 2. ID do registro a ser atualizado (condição WHERE).
            stmt.setInt(3, usuario.getId());

            stmt.executeUpdate();

            System.out.println("Aluno atualizado!");

        } catch (Exception e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
        }
    }

    /**
     * DELETE: Remove um registro do BD com base no ID.
     */
    public void deletar(int id) {
        String sql = "DELETE FROM alunos WHERE id = ?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Define o ID do aluno a ser deletado.
            stmt.setInt(1, id);

            stmt.executeUpdate();

            System.out.println("Usuario deletado!");

        } catch (Exception e) {
            System.out.println("Erro ao deletar: " + e.getMessage());
        }
    }
}