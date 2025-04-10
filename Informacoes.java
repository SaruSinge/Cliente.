public class Informacoes {
    private int id; // este é o id do cliente
    private String name; // esse é o nome do cliente
    private String address; // esse é o endereço do cliente
    private String city; // essa é a cidade do cliente

    public Informacoes(int id, String name, String address, String city) {
            this.id = id;
            this.name = name;
            this.address = address;
            this.city = city;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public String getCity() { //is é igual ao comando get, mas é comumente usado para casos de true ou false (boolean)
        return this.city;
    }

    public void toPro(int id) { //O samuel inventou esse aqui pra fazer o link com o caso 4 por que o toString não tava funcionando
        System.out.println(" - Nome: " + name); 
        System.out.println(" - Endereço: " + address);
        System.out.println(" - Cidade: " + city);
        System.out.println(" ");
    }

    @Override
    public String toString() {
        return name + ", id= " + id + " \n" +
               "Enderço: " + address + " \n" +
               "Cidade : " + city + "\n";
               

    }

}