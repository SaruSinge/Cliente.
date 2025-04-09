import java.util.ArrayList;
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

    public void exibirInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("Endereço: " + endereco);
        System.out.println("Cidade: " + cidade);
    }
}

public class CadastroCliente {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Cliente> listaClientes = new ArrayList<>();

        System.out.print("Quantos clientes deseja cadastrar? ");
        int quantidade = scanner.nextInt();
        scanner.nextLine(); // consumir quebra de linha

        // Cadastro de clientes
        for (int i = 0; i < quantidade; i++) {
            System.out.println("\nCadastro do Cliente " + (i + 1));
            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            System.out.print("Endereço: ");
            String endereco = scanner.nextLine();

            System.out.print("Cidade: ");
            String cidade = scanner.nextLine();

            Cliente cliente = new Cliente(nome, endereco, cidade);
            listaClientes.add(cliente);
        }

        // Pesquisa por nome
        System.out.print("\nDigite o nome do cliente que deseja pesquisar: ");
        String nomeBusca = scanner.nextLine();
        boolean encontrado = false;

        for (Cliente c : listaClientes) {
            if (c.nome.equalsIgnoreCase(nomeBusca)) {
                System.out.println("\nCliente encontrado:");
                c.exibirInformacoes();
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Cliente não encontrado.");
        }

        scanner.close();
    }
}