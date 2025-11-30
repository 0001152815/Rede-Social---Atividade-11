package model;

import java.time.LocalDate;

public class Postagens{

    // --- Atributos (Attributes) ---
    // Correspondentes a: int id, int usuarioId, String conteudo, LocalDate dataPostagem
    private int id;
    private int usuarioId;
    private String conteudo;
    private LocalDate dataPostagem;

    // --- Construtor Padrão ---
    public Postagens() {
        // Construtor vazio
    }

    // ------------------------------------
    // --- Getters e Setters (Acessores) ---
    // ------------------------------------

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public LocalDate getDataPostagem() {
        return dataPostagem;
    }

    public void setDataPostagem(LocalDate dataPostagem) {
        this.dataPostagem = dataPostagem;
    }

    // ------------------------------------
    // --- Métodos Solicitados (Declaração sem Implementação) ---
    // ------------------------------------

    /**
     * Implementar criarPostagem() para inserir nova postagem.
     * (Apenas a declaração do método, como solicitado.)
     */
    public void criarPostagem(String novoConteudo) {
        // Lógica de implementação para inserção da postagem.
    }

    /**
     * Implementar atualizarPostagem() para editar o conteúdo.
     * (Apenas a declaração do método, como solicitado.)
     */
    public void atualizarPostagem(String novoConteudo) {
        // Lógica de implementação para edição do conteúdo.
    }

    /**
     * Implementar excluirPostagem() para remover a postagem.
     * (Apenas a declaração do método, como solicitado.)
     */
    public void excluirPostagem() {
        // Lógica de implementação para remoção da postagem.
    }

    /**
     * Implementar exibirPostagem() para mostrar o conteúdo.
     * (Apenas a declaração do método, como solicitado.)
     */
    public void exibirPostagem() {
        // Lógica de implementação para exibição do conteúdo.
    }
}