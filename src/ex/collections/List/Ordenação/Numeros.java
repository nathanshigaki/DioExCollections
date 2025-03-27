package ex.collections.List.Ordenação;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
            //List<Integer> numAscendente = new ArrayList<>(this.listaNum);
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
        // Criando uma instância da classe Numeros
        Numeros numeros = new Numeros();
    
        // Adicionando números à lista
        numeros.adicionarNumeroOrdenacao(2);
        numeros.adicionarNumeroOrdenacao(5);
        numeros.adicionarNumeroOrdenacao(4);
        numeros.adicionarNumeroOrdenacao(1);
        numeros.adicionarNumeroOrdenacao(99);
    
        // Exibindo a lista de números adicionados
        numeros.exibirNumeros();
    
        // Ordenando e exibindo em ordem ascendente
        System.out.println(numeros.ordenarAscendente());
    
        // Exibindo a lista
        numeros.exibirNumeros();
    
        // Ordenando e exibindo em ordem descendente
        System.out.println(numeros.ordenarDescendente());
    
        // Exibindo a lista
        numeros.exibirNumeros();
    }
}
