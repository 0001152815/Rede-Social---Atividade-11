package model;

import java.time.LocalDate;

public class Direct {

    // --- Atributos (Attributes) ---
    // Correspondentes a: int id, int remetenteId, int destinatarioId, String mensagem, LocalDate dataEnvio
    private int id; // Identificador único da mensagem direta
    private int remetenteId; // ID do Usuário que enviou a mensagem
    private int destinatarioId; // ID do Usuário que recebeu a mensagem
    private String mensagem; // Conteúdo da mensagem
    private LocalDate dataEnvio; // Data em que a mensagem foi enviada

    // --- Construtor Padrão ---
    public Direct() {
        // Construtor vazio
    }

    // --- Construtor Completo (Para recuperar dados do banco) ---
    public Direct(int id, int remetenteId, int destinatarioId, String mensagem, LocalDate dataEnvio) {
        this.id = id;
        this.remetenteId = remetenteId;
        this.destinatarioId = destinatarioId;
        this.mensagem = mensagem;
        this.dataEnvio = dataEnvio;
    }

    // ------------------------------------
    // --- Getters (Métodos de Acesso aos Atributos) ---
    // ------------------------------------

    public int getId() {
        return id;
    }

    public int getRemetenteId() {
        return remetenteId;
    }

    public int getDestinatarioId() {
        return destinatarioId;
    }

    public String getMensagem() {
        return mensagem;
    }

    public LocalDate getDataEnvio() {
        return dataEnvio;
    }

    // ------------------------------------
    // --- Setters (Métodos de Modificação dos Atributos) ---
    // ------------------------------------

    public void setId(int id) {
        this.id = id;
    }

    public void setRemetenteId(int remetenteId) {
        this.remetenteId = remetenteId;
    }

    public void setDestinatarioId(int destinatarioId) {
        this.destinatarioId = destinatarioId;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public void setDataEnvio(LocalDate dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    // ------------------------------------
    // --- Métodos de Negócio (Declaração sem Implementação) ---
    // ------------------------------------

    /**
     * Implementar enviarMensagem() para enviar uma direct.
     * (Lógica para registrar a nova mensagem direta na base de dados.)
     */
    public void enviarMensagem(int remetenteId, int destinatarioId, String mensagem) {
        // Lógica de implementação para enviar a mensagem.
    }

    /**
     * Implementar listarMensagensEntreUsuarios() para mostrar mensagens em ordem cronológica.
     * (Lógica para buscar e retornar o histórico de mensagens entre dois usuários.)
     */
    public void listarMensagensEntreUsuarios(int usuario1Id, int usuario2Id) {
        // Lógica de implementação para listar as mensagens.
    }
}