package view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import dao.UsuarioDAO;
import dao.PostagemDAO;
import dao.CurtidaDAO;
import dao.DirectDAO;

import model.Usuario;
import model.Postagem;
// Importar Direct e Curtida, se necessário, para manipulação direta

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    // Inicialização dos DAOs
    private static final UsuarioDAO usuarioDAO = new UsuarioDAO();
    private static final PostagemDAO postagemDAO = new PostagemDAO();
    private static final CurtidaDAO curtidaDAO = new CurtidaDAO();
    private static final DirectDAO directDAO = new DirectDAO();

    public static void main(String[] args) {
        boolean emExecucao = true;
        System.out.println("--- Sistema de Gerenciamento de Rede Social (JDBC) ---");

        while (emExecucao) {
            exibirMenuPrincipal();

            try {
                if (scanner.hasNextInt()) {
                    int opcao = scanner.nextInt();
                    scanner.nextLine(); // Consumir a nova linha

                    switch (opcao) {
                        // Opções de Usuário (Baseado nas opções 1 a 4)
                        case 1: criarUsuario(); break;
                        case 2: listarUsuarios(); break;
                        case 3: atualizarUsuario(); break;
                        case 4: excluirUsuario(); break;

                        // Opções de Postagem (Baseado nas opções 5, 6, 7)
                        case 5: criarPostagem(); break;
                        case 6: listarPostagensDeUsuario(); break;
                        case 7: excluirPostagem(); break;

                        // Opções de Curtida/Direct
                        case 8: curtirPostagem(); break;
                        case 9: enviarDirect(); break;

                        case 0:
                            emExecucao = false;
                            System.out.println("O sistema será encerrado. Obrigado por utilizar.");
                            break;
                        default:
                            System.out.println("Opção inválida. Por favor, selecione uma opção válida do menu.");
                    }
                } else {
                    scanner.nextLine(); // Limpa o buffer
                    System.out.println("Entrada inválida. Por favor, insira um valor numérico.");
                }
            } catch (InputMismatchException e) {
                scanner.nextLine(); // Limpa o buffer em caso de erro de tipo
                System.out.println("Erro na leitura da entrada. Certifique-se de digitar um número inteiro.");
            } catch (Exception e) {
                System.err.