package model;

import java.time.LocalDate;

public class Usuario {
    private int id;
    private String nome;
    private String email;
    private String senha; // A senha não estava explícita nos atributos, mas é necessária para a função de cadastro/login
    private LocalDate dataCadastro;

    // Construtor
    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dataCadastro = LocalDate.now();
    }

    // Construtor completo (útil ao buscar dados do banco)
    public Usuario(int id, String nome, String email, String senha, LocalDate dataCadastro) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dataCadastro = dataCadastro;
    }

    // Métodos de Ação (Implementação simulada, a lógica real estará no DAO/Service)
    public void implementarCadastrarUsuario() {
        // Lógica de cadastro (será chamada pelo DAO)
        System.out.println("Usuário " + this.nome + " cadastrado.");
    }

    public void implementarAtualizarUsuario() {
        // Lógica de atualização
        System.out.println("Dados do usuário " + this.id + " atualizados.");
    }

    public void implementarExcluirUsuario() {
        // Lógica de exclusão
        System.out.println("Usuário " + this.id + " excluído.");
    }

    public void implementarExibirInformacoes() {
        System.out.println("--- Informações do Usuário ---");
        System.out.println("ID: " + this.id);
        System.out.println("Nome: " + this.nome);
        System.out.println("Email: " + this.email);
        System.out.println("Data de Cadastro: " + this.dataCadastro);
        System.out.println("------------------------------");
    }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public LocalDate getDataCadastro() { return dataCadastro; }
    public void setDataCadastro(LocalDate dataCadastro) { this.dataCadastro = dataCadastro; }
}