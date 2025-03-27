package ex.collections.List.Ordenação;

import java.util.ArrayList;
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

    
}
