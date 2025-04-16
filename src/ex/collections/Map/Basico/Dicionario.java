package ex.collections.Map.Basico;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Dicionario {
    private Map<String, String> dicionario;

    public Dicionario() {
        this.dicionario = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, String definicao) {
        dicionario.put(palavra, definicao);
    }

    public void removerPalavra(String palavra) {
        if (!dicionario.isEmpty()) {
            dicionario.remove(palavra);
        } else {
            System.out.println("O dicionário está vazio.");
        }
    }

    public String pesquisarPorPalavra(String palavra) {
        String definicao = dicionario.get(palavra);
        if (definicao != null) {
            return definicao;
        }
        return "Linguagem não encontrada no dicionário.";
    }

    public void exibirPalavras() {
        if (!dicionario.isEmpty()) {
            System.out.println(dicionario);
        } else {
            System.out.println("O dicionário está vazio.");
        }
    }

    public static void main(String[] args) {
        Dicionario dicionario = new Dicionario();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("""
                
                [ 1 ] Adicionar palavra.
                [ 2 ] Remover palavra.
                [ 3 ] Pesquisar palavra.
                [ 4 ] Exibir dicionário.
                [ 0 ] Sair do programa.
                
                Escolha uma opção: """);

            try {
                int n = scanner.nextInt();
                scanner.nextLine();

                switch (n) {
                    case 1 -> {
                        System.out.print("Digite a palavra: ");
                        String nome = scanner.nextLine();
                        System.out.print("Digite a definição: ");
                        String definicao = scanner.nextLine();
                        dicionario.adicionarPalavra(nome, definicao);
                    }
                    case 2 -> {
                        System.out.print("Digite a palavra: ");
                        String nome = scanner.nextLine();
                        dicionario.removerPalavra(nome);
                    }
                    case 3 -> {
                        System.out.print("Digite a palavra: ");
                        String nome = scanner.nextLine();
                        String pesquisa = dicionario.pesquisarPorPalavra(nome);
                        System.out.printf("Definição da palavra %s: %s\n", nome, pesquisa);
                    }
                    case 4 -> dicionario.exibirPalavras();
                    case 0 -> {
                        System.out.println("Saindo do programa.");
                        scanner.close();
                        return;
                    }
                    default -> System.out.println("Opção inválida, tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro. Opção inválida, insira um número entre 0 e 4.");
                scanner.nextLine();
            }
        }
    }
}
