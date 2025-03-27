package ex.collections.List.Basico;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarrinhoDeCompras {
    private List<Item> itemLista;

    public CarrinhoDeCompras(){
        this.itemLista = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade){
        itemLista.add(new Item(nome, preco, quantidade));
        System.out.println("Item adicionado com sucesso");
    }

    public void removerItem(String nome){
        if (!itemLista.isEmpty()){
            List<Item> remover = new ArrayList<>();
            for (Item item : itemLista) {
                if (item.getNome().equalsIgnoreCase(nome)) {
                    remover.add(item);
                }
            }
            itemLista.removeAll(remover);
        } else {
            System.out.println("Lista vazia.");
        }
    }

    public double calcularValorTotal(){
        if (!itemLista.isEmpty()){
            double valorTotal = 0;
            for (Item item : itemLista) {
                double valor = item.getPreco() * item.getQuantidade();
                valorTotal += valor;
            }
            return valorTotal;
        } else {
            System.out.println("Lista vazia");
            return 0;
        }
    }

    public void exibirItens(){
        if (!itemLista.isEmpty()) {
            for (Item item : itemLista) {
                System.out.println(item.getNome() +" R$"+ item.getPreco() +" Quantidade: "+ item.getQuantidade());
            }
        } else {
            System.out.println("Lista vazia");
        }
    }

    public static void main(String[] args) {
        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();
        Item item = new Item(null, 0, 0);
        Scanner scanner = new Scanner(System.in);
        
        int n = 0;
        
        while (n != 5){
            System.out.println("""
                Escolha uma opção:

                [ 0 ] Adicionar item automaticamente.
                [ 1 ] Adicionar item manualmente.
                [ 2 ] Exibir itens.
                [ 3 ] Remover item.
                [ 4 ] Finalizar compra.
            """);
            
            n = scanner.nextInt();
            scanner.nextLine();

            switch (n) {
                case 0: 
                    carrinhoDeCompras.adicionarItem("Lápis", 2, 3);
                    carrinhoDeCompras.adicionarItem("Lápis", 2, 3);
                    carrinhoDeCompras.adicionarItem("Caderno", 35, 1);
                    carrinhoDeCompras.adicionarItem("Borracha", 2, 2);
                    break;
                case 1: //preguiça de por as exceptions
                    System.out.print("Digite o nome do item: ");
                    String nome = scanner.nextLine();
                    item.setNome(nome);
                    System.out.print("Digite o valor do item: ");
                    double valor = scanner.nextDouble();
                    item.setPreco(valor);
                    System.out.print("Digite a quantidade do item: ");
                    int quantidade = scanner.nextInt();
                    item.setQuantidade(quantidade);
                    carrinhoDeCompras.adicionarItem(item.getNome(), item.getPreco(), item.getQuantidade());
                default:
                    break;
            }
        
            carrinhoDeCompras.exibirItens();
        
            carrinhoDeCompras.removerItem("Lápis");
        
            carrinhoDeCompras.exibirItens();
        
            System.out.println("O valor total da compra é = " + carrinhoDeCompras.calcularValorTotal());
        }
        scanner.close();
    }
}
