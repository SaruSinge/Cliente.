// Este aq não é valido, usei o chatGPT para gera-lo para poder entender certos métodos que poderiamos usar no nosso modelo.

import java.util.Scanner;

class Cliente {
    String nome;
    String endereco;
    String cidade;

    public Cliente(String nome, String endereco, String cidade) {
        this.nome = nome;
        this.endereco = endereco;
        this.cidade = cidade;
    }

    public void exibirInformacoes(int id) {
        System.out.println("ID: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("Endereço: " + endereco);
        System.out.println("Cidade: " + cidade);
    }
}

public class SistemaClientes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cliente[] clientes = new Cliente[100];

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Cadastrar novo cliente");
            System.out.println("2 - Listar clientes");
            System.out.println("3 - Pesquisar cliente por ID");
            System.out.println("4 - Remover cliente por ID");
            System.out.println("0 - Encerrar programa");
            System.out.print("Escolha uma opção: ");
            int opcao = -1;

            // Verificação para evitar exceções se usuário digitar algo errado
            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
                scanner.nextLine(); // limpar buffer
            } else {
                scanner.nextLine(); // consumir entrada inválida
                opcao = -1;
            }

            switch (opcao) {
                case 1:
                    int idDisponivel = -1;
                    for (int i = 0; i < clientes.length; i++) {
                        if (clientes[i] == null) {
                            idDisponivel = i;
                            break;
                        }
                    }

                    if (idDisponivel == -1) {
                        System.out.println("Limite de 100 clientes atingido.");
                    } else {
                        System.out.print("Nome: ");
                        String nome = scanner.nextLine();

                        System.out.print("Endereço: ");
                        String endereco = scanner.nextLine();

                        System.out.print("Cidade: ");
                        String cidade = scanner.nextLine();

                        clientes[idDisponivel] = new Cliente(nome, endereco, cidade);
                        System.out.println("\nCliente cadastrado com sucesso!");
                        clientes[idDisponivel].exibirInformacoes(idDisponivel);
                    }
                    break;

                case 2:
                    System.out.println("\n=== Lista de Clientes ===");
                    boolean encontrou = false;
                    for (int i = 0; i < clientes.length; i++) {
                        if (clientes[i] != null) {
                            clientes[i].exibirInformacoes(i);
                            System.out.println("-------------------------");
                            encontrou = true;
                        }
                    }
                    if (!encontrou) {
                        System.out.println("Nenhum cliente cadastrado.");
                    }
                    break;

                case 3:
                    System.out.print("Digite o ID do cliente: ");
                    int idPesquisa = scanner.nextInt();
                    scanner.nextLine();

                    if (idPesquisa >= 0 && idPesquisa < clientes.length && clientes[idPesquisa] != null) {
                        System.out.println("\nCliente encontrado:");
                        clientes[idPesquisa].exibirInformacoes(idPesquisa);
                    } else {
                        System.out.println("Cliente com ID " + idPesquisa + " não encontrado.");
                    }
                    break;

                case 4:
                    System.out.print("Digite o ID do cliente que deseja remover: ");
                    int idRemover = scanner.nextInt();
                    scanner.nextLine();

                    if (idRemover >= 0 && idRemover < clientes.length && clientes[idRemover] != null) {
                        clientes[idRemover] = null;
                        System.out.println("Cliente com ID " + idRemover + " removido com sucesso.");
                    } else {
                        System.out.println("Cliente com ID " + idRemover + " não encontrado.");
                    }
                    break;

                case 0:
                    System.out.println("Encerrando o programa...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Comando não válido.");
            }
        }
    }
}