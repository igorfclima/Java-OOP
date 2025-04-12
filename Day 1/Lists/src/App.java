import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class App {
    static Scanner teclado;
    public static void main(String[] args) throws Exception {
        List<Funcionario> lista = new ArrayList<>();
        teclado = new Scanner(System.in);
        System.out.println("How many employees will be registered today: ");
        int quant = teclado.nextInt();

        for(int i = 0;i < quant;i++){
            System.out.printf("Employee #%d:\n", i + 1);
            lista.add(cadastrarFuncionario());
        }

        System.out.println("Enter the employee id that will have the salary increase: ");
        int id = teclado.nextInt();
        Funcionario func = lista.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        if (func != null) {
            System.out.println("Enter the percentage: ");
            double percentage = teclado.nextDouble();
            func.increaseSalary(percentage);
        } else
            System.out.println("This id does not exists");

        for(Funcionario funcionario : lista){
            System.out.println(funcionario.toString());
        }

        teclado.close();
    }

    public static Funcionario cadastrarFuncionario(){
        teclado = new Scanner(System.in);
        System.out.print("Id: ");
        int id = teclado.nextInt();
        teclado.nextLine();
        System.out.print("Nome: ");
        String nome = teclado.nextLine();
        System.out.print("Salario: ");
        double salario = teclado.nextDouble();
        Funcionario funcionario = new Funcionario(id, nome, salario);
        return funcionario;
    }

    public static boolean hasId(List<Funcionario> list, int id){
        Funcionario func = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        return func != null;
    }
}
