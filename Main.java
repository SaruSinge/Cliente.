import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Listagem cadastro = new Listagem();
        Scanner scanner = new Scanner(System.in);
        Informacoes[] client = new Informacoes[100];
        
        int option;

        do {
            System.out.println("\nMenu:");
            System.out.println("1 - Adicionar cadastro de cliente");
            System.out.println("2 - Remover cadastro de cliente por id");
            System.out.println("3 - Listar Clientes");
            System.out.println("4 - Pesquisar cliente por id");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();
            scanner.nextLine(); 

            switch (option) {
                case 1:
                    System.out.print("Digite o nome do cliente que deseja cadastrar: ");
                    String name = scanner.nextLine();
                    System.out.print("Digite o enderço do cliente: ");
                    String address = scanner.nextLine();
                    System.out.print("Digite a cidade do cliente: ");
                    String city = scanner.nextLine();
                    cadastro.addCliente(name, address, city);
                    break;

                case 2:
                    System.out.print("Digite o id do cliente que deseja remover do cadastro: ");
                    int removeId = scanner.nextInt();
                    cadastro.removeTask(removeId);
                    break;

                case 3:
                    System.out.println("LISTA DE CLIENTES: ");
                    System.out.println("----------------------------------");
                    cadastro.listTasks();
                    break;

                case 4:
                    System.out.print("Digite o id do cliente que quer encontrar: ");
                    int idSearch = scanner.nextInt();
                    scanner.nextLine();

                    if (idSearch >= 0 && idSearch < client.length && client[idSearch] != null) {
                        System.out.println("\nCliente encontrado:");
                        client[idSearch].toPro(idSearch);
                    } else {
                        System.out.println("\nCliente não encontrado.");
                    }
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (option != 0);

        scanner.close();
    }
}