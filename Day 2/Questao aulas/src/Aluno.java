import java.util.Scanner;

public class Aluno {
    private int notas = 0;
    private int frequencia;
    private final int maxFaltas = 10;
    private int trabalhoPratico;


    Scanner teclado;
    private void calcProvas(int nota1, int nota2){
        int nota = (nota1 + nota2) / 2;
        notas += (nota / 100) * 60;
    }

    private void calcExercicios(int nota1,int nota2,int nota3,int nota4){
        int nota = (nota1 + nota2 + nota3 + nota4) / 4;
        notas += (nota / 100) * 20;
    }

    private int calcNotas(){
        teclado = new Scanner(System.in);
        System.out.println("Digite as notas das 2 provas: ");
        int nota1 = teclado.nextInt();
        int nota2 = teclado.nextInt();
        calcProvas(nota1, nota2);
        System.out.println("Digite as notas dos 4 exercicios: ");
        nota1 = teclado.nextInt();
        nota2 = teclado.nextInt();
        int nota3 = teclado.nextInt();
        int nota4 = teclado.nextInt();
        calcExercicios(nota1, nota2, nota3, nota4);
        System.out.println("Digite a nota do trabalho: ");
        trabalhoPratico =  teclado.nextInt();
        return notas + trabalhoPratico;
    }

    private int calcFrequencia(){
        teclado = new Scanner(System.in);
        System.out.println("Quantas faltas obteve: ");
        frequencia = teclado.nextInt();
        return frequencia;
    }

    public boolean calcAprovacao(){
        if(calcNotas() >= 60 && calcFrequencia() < maxFaltas){
            return true;
        } else
            return false;
    }
}
