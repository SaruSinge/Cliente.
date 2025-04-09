// Este aq não é valido, usei o chatGPT para gera-lo para poder entender certos métodos que poderiamos usar no nosso modelo.


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