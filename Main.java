
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Listagem cadastro = new Listagem();
        Scanner scanner = new Scanner(System.in);

        int option;

        do { // o "do" tá basicamente fazendo rodar o programa enquanto o while não é executado
            System.out.println("\n=============== | MENU |  ==============="); 
            System.out.println("1 - Adicionar cadastro de cliente");
            System.out.println("2 - Remover cadastro de cliente por id");
            System.out.println("3 - Listar Clientes");
            System.out.println("4 - Pesquisar cliente por id");
            System.out.println("0 - Sair");
            System.out.print("\nEscolha uma opção: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1: // permite cadastrar um cliente
                    System.out.print("\nDigite o nome do cliente que deseja cadastrar: ");
                    String name = scanner.nextLine();
                    System.out.print("Digite o enderço do cliente: ");
                    String address = scanner.nextLine();
                    System.out.print("Digite a cidade do cliente: ");
                    String city = scanner.nextLine();
                    cadastro.addCliente(name, address, city);
                    break;

                case 2: // permite remover o cadastro de um cliente
                    System.out.print("\nDigite o id do cliente que deseja remover do cadastro: ");
                    int removeId = scanner.nextInt();
                    cadastro.removeTask(removeId);
                    break;

                case 3: // Permite listar as informações dos clientes cadastrados
                    System.out.println("\nLISTA DE CLIENTES: ");
                    System.out.println("----------------------------------");
                    cadastro.listTasks();
                    break;

                case 4: // permite pesquisar os clientes cadastrados por seus ids atribuidos.
                    System.out.print("\nDigite o id do cliente que quer encontrar: ");
                    int idSearch = scanner.nextInt();
                    scanner.nextLine();

                    Informacoes clienteEncontrado = cadastro.searchById(idSearch);
                    if (clienteEncontrado != null) {
                        System.out.println("\nCliente de id " + idSearch + " :");
                        clienteEncontrado.toPro(clienteEncontrado.getId());
                    } else {
                        System.out.println("\nCliente não encontrado.");
                    }
                    break;

                case 0:
                    System.out.println("\nSaindo...");
                    break;

                default:
                    System.out.println("\nOpção inválida.");
            }

        } while (option != 0); // esse while faz o programa parar quando é digitado o número 0, porém, como ele está abaixo 
        // do comando "case 0", ele vai primeiro printar aquela saida descrita e depois encerra-lo.

        scanner.close();
    }
}
