package model;

import java.time.LocalDate;
import java.util.Scanner;
public class Usuario {

        Scanner sc = new Scanner(System.in);

    // --- Atributos (Attributes) ---
    private int id; // Identificador único do usuário
    private String nome; // Nome completo ou de exibição do usuário
    private String email; // Endereço de e-mail do usuário (geralmente único)
    private String senha; // Senha do usuário (idealmente armazenada como hash)
    private LocalDate dataCadastro; // Data em que o usuário foi cadastrado

    // --- Construtor para Novo Cadastro (Define a data de cadastro para 'hoje') ---
    public Usuario(int nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        // Atribui a data de cadastro como a data atual do sistema
        this.dataCadastro = LocalDate.now();
    }

    // --- Construtor Completo (Geralmente usado para recuperar dados do banco) ---
    public Usuario(int id, String nome, String email, String senha, LocalDate dataCadastro) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dataCadastro = dataCadastro;
    }

    // ------------------------------------
    // --- Getters (Métodos de Acesso aos Atributos) ---
    // ------------------------------------

    public int getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public String getEmail() {
        return email;
    }
    public String getSenha() {
        return senha;
    }
    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    // ------------------------------------
    // --- Setters (Métodos de Modificação dos Atributos) ---
    // ------------------------------------

    public void setId(int id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    // ------------------------------------
    // --- Métodos de Negócio (Declaração sem Implementação) ---
    // ------------------------------------

    /**
     * Implementar cadastrarUsuario().
     * (Lógica para persistir o novo usuário em uma base de dados.)
     */
    public void cadastrarUsuario(){

        System.out.println("Digite seu nome: ");
        setNome(sc.nextLine());

        System.out.println("Digite seu email: ");
        setEmail(sc.nextLine());

        System.out.println("Digite seu senha: ");
        setSenha(sc.nextLine());

    }

    /**
     * Implementar atualizarUSusario().
     * (Lógica para modificar os dados de um usuário existente na base de dados.)
     */
    public void atualizarUSusario(){
        System.out.println("Gigite seu novo nome: ");
        setNome(sc.nextLine());

        System.out.println("Gigite seu novo email: ");
        setEmail(sc.nextLine());

        System.out.println("Gigite seu nova senha: ");
        setSenha(sc.nextLine());
    }

    /**
     * Implementar excluirUsuario().
     * (Lógica para remover o registro do usuário da base de dados.)
     */
    public void excluirUsuario(){
        try {

        }
    }

    /**
     * Implementar exibirInformacoes(int id).
     * (Lógica para buscar e exibir os dados de um usuário específico.)
     */
    public void exibirInformacoes(int id){
        // Lógica de implementação para exibir as informações do usuário.
    }
}