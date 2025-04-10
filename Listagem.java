
public class Listagem {

    public final int MAX_TASKS = 100;
    private Informacoes[] tasks; // manteremos o termo "tasks" para polpar esforço
    private int count;
    private int nextId;

    public Listagem() {
        this.tasks = new Informacoes[MAX_TASKS];
        this.count = 0;
        this.nextId = 1;
    }

    public void addCliente(String name, String address, String city) {
        if (this.count >= MAX_TASKS) {
            System.out.println("Limite de clientes atingido.   o _ o");
            return;
        }
        Informacoes newTask = new Informacoes(this.nextId, name, address, city);
        this.tasks[this.count] = newTask;
        this.count = this.count + 1;
        this.nextId++;
        System.out.println("\n======================================");
        System.out.println("\nDADOS DO CLIENTE: ");
        System.out.println("\nNome: " + newTask);
    }

    public void removeTask(int id) {
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (tasks[i].getId() == id) {
                found = true;
                for (int j = i; j < count - 1; j++) {
                    tasks[j] = tasks[j + 1];
                }
                tasks[count - 1] = null;
                this.count -= 1;
                System.out.println("Cliente " + id + " removido da listagem!");
                break;

            }
        }
        if (!found) {
            System.out.println("Esse cliente não foi encontrado.");
        }
    }

    public void listTasks() { // Esse método é para listar os cadastros feitos dos clientes
        for (int i = 0; i < count; i++) {
            System.out.println(tasks[i]);
        }
    }

    public Informacoes searchById(int id) { //Esse método é para pesquisar por Id
        for (int i = 0; i < count; i++) {
            if (tasks[i].getId() == id) {
                return tasks[i];
            }
        }
        return null;
    }
}
