package model;

import java.time.LocalDateTime;

public class Direct {
    private int id;
    private int remetenteId;
    private int destinatarioId;
    private String mensagem;
    private LocalDateTime dataEnvio;

    // Construtor
    public Direct(int remetenteId, int destinatarioId, String mensagem) {
        this.remetenteId = remetenteId;
        this.destinatarioId = destinatarioId;
        this.mensagem = mensagem;
        this.dataEnvio = LocalDateTime.now();
    }

    // Construtor completo
    public Direct(int id, int remetenteId, int destinatarioId, String mensagem, LocalDateTime dataEnvio) {
        this.id = id;
        this.remetenteId = remetenteId;
        this.destinatarioId = destinatarioId;
        this.mensagem = mensagem;
        this.dataEnvio = dataEnvio;
    }

    // Métodos de Ação
    public void implementarEnviarMensagem() {
        System.out.println("Mensagem enviada de " + this.remetenteId + " para " + this.destinatarioId);
    }

    public void implementarListarMensagensEntreUsuarios() {
        System.out.println("Listando mensagens entre " + this.remetenteId + " e " + this.destinatarioId);
    }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getRemetenteId() { return remetenteId; }
    public void setRemetenteId(int remetenteId) { this.remetenteId = remetenteId; }

    public int getDestinatarioId() { return destinatarioId; }
    public void setDestinatarioId(int destinatarioId) { this.destinatarioId = destinatarioId; }

    public String getMensagem() { return mensagem; }
    public void setMensagem(String mensagem) { this.mensagem = mensagem; }

    public LocalDateTime getDataEnvio() { return dataEnvio; }
    public void setDataEnvio(LocalDateTime dataEnvio) { this.dataEnvio = dataEnvio; }
}