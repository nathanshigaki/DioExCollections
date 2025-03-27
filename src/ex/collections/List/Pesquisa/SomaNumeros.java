package ex.collections.List.Pesquisa;

import java.util.ArrayList;
import java.util.List;

public class SomaNumeros {
    private List<Integer> num;

    private SomaNumeros(){
        this.num = new ArrayList<>();
    }

    public void adicionarNumero(int numero){
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

        SomaNumeros somaNumeros = new SomaNumeros();

        // Adicionando números à lista
        somaNumeros.adicionarNumero(5);
        somaNumeros.adicionarNumero(0);
        somaNumeros.adicionarNumero(0);
        somaNumeros.adicionarNumero(-2);
        somaNumeros.adicionarNumero(10);

        // Exibindo a lista de números adicionados
        System.out.print("Números adicionados: ");
        somaNumeros.exibirNumeros();

        // Calculando e exibindo a soma dos números na lista
        System.out.println("Soma dos números = " + somaNumeros.calcularSoma());

        // Encontrando e exibindo o maior número na lista
        System.out.println("Maior número = " + somaNumeros.encontrarMaiorNumero());

        // Encontrando e exibindo o menor número na lista
        System.out.println("Menor número = " + somaNumeros.encontrarMenorNumero());
    }
}
