package model;

import java.time.LocalDate;

public class Curtida {

    // --- Atributos (Attributes) ---
    // Correspondentes a: int id, int postagemId, int usuarioId, LocalDate dataCurtida
    private int id; // Identificador único da curtida
    private int postagemId; // ID da Postagem que recebeu a curtida
    private int usuarioId; // ID do Usuário que deu a curtida
    private LocalDate dataCurtida; // Data em que a curtida foi registrada

    // --- Construtor Padrão ---
    public Curtida() {
        // Construtor vazio
    }

    // --- Construtor Completo (Para recuperar dados do banco) ---
    public Curtida(int id, int postagemId, int usuarioId, LocalDate dataCurtida) {
        this.id = id;
        this.postagemId = postagemId;
        this.usuarioId = usuarioId;
        this.dataCurtida = dataCurtida;
    }

    // ------------------------------------
    // --- Getters (Métodos de Acesso aos Atributos) ---
    // ------------------------------------

    public int getId() {
        return id;
    }

    public int getPostagemId() {
        return postagemId;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public LocalDate getDataCurtida() {
        return dataCurtida;
    }

    // ------------------------------------
    // --- Setters (Métodos de Modificação dos Atributos) ---
    // ------------------------------------

    public void setId(int id) {
        this.id = id;
    }

    public void setPostagemId(int postagemId) {
        this.postagemId = postagemId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public void setDataCurtida(LocalDate dataCurtida) {
        this.dataCurtida = dataCurtida;
    }

    // ------------------------------------
    // --- Métodos de Negócio (Declaração sem Implementação) ---
    // ------------------------------------

    /**
     * Implementar curtir() para registrar nova curtida.
     * (Lógica para inserir um novo registro de curtida na base de dados.)
     */
    public void curtir() {
        // Lógica de implementação para registrar a curtida.
    }

    /**
     * Implementar descurtir() para remover a curtida.
     * (Lógica para remover o registro de curtida da base de dados.)
     */
    public void descurtir() {
        // Lógica de implementação para remover a curtida.
    }

    /**
     * Implementar contarCurtidas() para retornar total de curtidas da postagem.
     * (Lógica para consultar o número total de curtidas para uma postagem específica.)
     * @return O número total de curtidas.
     */
    public int contarCurtidas(int postId) {
        // Lógica de implementação para contar as curtidas.
        return 0; // Retorno placeholder
    }
}