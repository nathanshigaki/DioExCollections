package ex.collections.List.Pesquisa;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class SomaNumeros {
    private List<Integer> num;

    private SomaNumeros(){
        this.num = new ArrayList<>();
    }

    public void adicionarNumeroPesquisa(int numero){
        num.add(numero);
        System.out.println("Número adicionado com sucesso");
    }

    public int calcularSoma(){
        int total = 0;
        if (!num.isEmpty()){
            for (Integer i : num) {
                total += i;
            }
            return total;
        }
        return total;
    }

    public int encontrarMaiorNumero(){
        int maior = Integer.MIN_VALUE;
        if (!num.isEmpty()){
            for (Integer i : num) {
                if (i >= maior){
                    maior = i;
                }
            }
            return maior;
        } else {
            throw new RuntimeException("Lista vazia");
        }
    }

    public int encontrarMenorNumero(){
        int menor = Integer.MAX_VALUE;
        if (!num.isEmpty()){
            for (Integer i : num) {
                if (i <= menor){
                    menor = i;
                }
            }
            return menor;
        } else {
            throw new RuntimeException("Lista vazia");
        }
    }

    public void exibirNumeros(){
        if (!num.isEmpty()){
            System.out.println(this.num);
        } else {
            System.out.println("Lista vazia");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SomaNumeros somaNumeros = new SomaNumeros();

        while (true) { 
            System.out.println("""

            [ 1 ] Adicionar número.
            [ 2 ] Exibir números.
            [ 3 ] Somar números.
            [ 4 ] Maior número.
            [ 5 ] Menor número
            [ 6 ] Sair do programa.

            Escolha uma opção: """);
            
            int n = scanner.nextInt();
            scanner.nextLine();

            switch (n){
                case 1 -> {
                    try {
                        System.out.print("\nDigite um número: ");
                        int numero = scanner.nextInt();
                        scanner.nextLine(); 
                        somaNumeros.adicionarNumeroPesquisa(numero);;
                    } catch (InputMismatchException e) {
                        System.out.println("Erro: Deve ser um número inteiro.");
                        scanner.nextLine(); 
                    }
                }
                case 2 -> somaNumeros.exibirNumeros();
                case 3 -> System.out.println("Soma dos números = " + somaNumeros.calcularSoma());
                case 4 -> System.out.println("Maior número = " + somaNumeros.encontrarMaiorNumero());
                case 5 -> System.out.println("Menor número = " + somaNumeros.encontrarMenorNumero());
                case 6 -> System.out.println("Saindo do programa.");
                default -> System.out.println("Opção inválida, tente novamente.");
            }
            if (n == 6){
                break;
            }
        }
        scanner.close();
    }
}
