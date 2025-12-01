package model;

import java.time.LocalDateTime;

public class Curtida {
    private int id;
    private int postagemId;
    private int usuarioId;
    private LocalDateTime dataCurtida;

    // Construtor
    public Curtida(int usuarioId, int postagemId) {
        this.usuarioId = usuarioId;
        this.postagemId = postagemId;
        this.dataCurtida = LocalDateTime.now();
    }

    // Construtor completo
    public Curtida(int id, int postagemId, int usuarioId, LocalDateTime dataCurtida) {
        this.id = id;
        this.postagemId = postagemId;
        this.usuarioId = usuarioId;
        this.dataCurtida = dataCurtida;
    }

    // Getters e Setters (Os métodos de ação estarão no DAO)
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getPostagemId() { return postagemId; }
    public void setPostagemId(int postagemId) { this.postagemId = postagemId; }

    public int getUsuarioId() { return usuarioId; }
    public void setUsuarioId(int usuarioId) { this.usuarioId = usuarioId; }

    public LocalDateTime getDataCurtida() { return dataCurtida; }
    public void setDataCurtida(LocalDateTime dataCurtida) { this.dataCurtida = dataCurtida; }
}