package ex.collections.List.Ordenação;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Numeros {
    private List<Integer> listaNum;

    private Numeros(){
        this.listaNum = new ArrayList<>();
    }

    public void adicionarNumeroOrdenacao(int numero){
        listaNum.add(numero);
        System.out.println("Número adicionado com sucesso");
    }

    public List<Integer> ordenarAscendente(){
        if (!listaNum.isEmpty()){
            Collections.sort(listaNum);
            return listaNum;
        } else {
            throw new RuntimeException("Lista vazia");
        }
    }

    public List<Integer> ordenarDescendente(){
        if (!listaNum.isEmpty()){
            listaNum.sort(Collections.reverseOrder());
            return listaNum;
        } else {
            throw new RuntimeException("Lista vazia");
        }
    }

    public void exibirNumeros() {
        if (!listaNum.isEmpty()) {
          System.out.println(this.listaNum);
        } else {
          System.out.println("A lista está vazia!");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Numeros numeros = new Numeros();
    
        while (true) { 
            System.out.println("""

            [ 1 ] Adicionar número.
            [ 2 ] Exibir números.
            [ 3 ] Ordenar ascendente.
            [ 4 ] Ordenar descendente.
            [ 5 ] Sair do programa.

            Escolha uma opção: """);
            
            int n = scanner.nextInt();
            scanner.nextLine();

            switch (n){
                case 1 -> {
                    try {
                        System.out.print("\nDigite um número: ");
                        int numero = scanner.nextInt();
                        scanner.nextLine(); 
                        numeros.adicionarNumeroOrdenacao(numero);
                    } catch (InputMismatchException e) {
                        System.out.println("Erro: Deve ser um número inteiro.");
                        scanner.nextLine(); 
                    }
                }
                case 2 -> numeros.exibirNumeros();
                case 3 -> System.out.println(numeros.ordenarAscendente());
                case 4 -> System.out.println(numeros.ordenarDescendente());
                case 5 -> System.out.println("Saindo do programa.");
                default -> System.out.println("Opção inválida, tente novamente.");
            }
            if (n == 5){
                break;
            }
        }
        scanner.close();
    }
}
