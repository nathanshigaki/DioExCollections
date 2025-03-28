package ex.collections.Set.Basico;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public class ConjuntoPalavras {
    private Set<String> palavras;

    public ConjuntoPalavras() {
        this.palavras = new HashSet<>();
    }

    public void adicionarPalavra(String palavra) {
        if (palavras.add(palavra)) {
            System.out.println("Palavra adicionada com sucesso!");
        } else {
            System.out.println("Palavra já existe no conjunto!");
        }
    }

    public void removerPalavra(String palavra) {
        if (palavras.remove(palavra)) {
            System.out.println("Palavra removida com sucesso!");
        } else {
            System.out.println("Palavra não encontrada!");
        }
    }

    public boolean verificarPalavra(String palavra) {
        return palavras.contains(palavra);
    }

    public void exibirPalavrasUnicas() {
        if (!palavras.isEmpty()) {
            System.out.println("Palavras no conjunto: " + palavras);
        } else {
            System.out.println("O conjunto está vazio!");
        }
    }

    public static void main(String[] args) {
        ConjuntoPalavras palavras = new ConjuntoPalavras();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("""
                
                [ 1 ] Adicionar palavra única.
                [ 2 ] Remover palavra única.
                [ 3 ] Exibir conjunto das palavras únicas.
                [ 4 ] Verificar palavra única.
                [ 5 ] Sair do programa.
                
                Escolha uma opção: """);

            try {
                int n = scanner.nextInt();
                scanner.nextLine();

                switch (n) {
                    case 1 -> {
                        System.out.print("Digite uma palavra única: ");
                        String palavra = scanner.nextLine();
                        palavras.adicionarPalavra(palavra);
                    }
                    case 2 -> {
                        System.out.print("Digite uma palavra única para ser removida: ");
                        String palavra = scanner.nextLine();
                        palavras.removerPalavra(palavra);
                    }
                    case 3 -> palavras.exibirPalavrasUnicas();
                    case 4 -> {
                        System.out.print("Digite uma palavra única para verificar: ");
                        String palavra = scanner.nextLine();
                        if (palavras.verificarPalavra(palavra)) {
                            System.out.println("A palavra '" + palavra + "' está no conjunto!");
                        } else {
                            System.out.println("A palavra '" + palavra + "' não está no conjunto!");
                        }
                    }
                    case 5 -> {
                        System.out.println("Saindo do programa.");
                        scanner.close();
                        return;
                    }
                    default -> System.out.println("Opção inválida, tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro. Opção inválida, insira um número entre 1 e 5.");
                scanner.nextLine();
            }
        }
    }
}
