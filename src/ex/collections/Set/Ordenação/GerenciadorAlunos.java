package ex.collections.Set.Ordenação;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class GerenciadorAlunos {
    private Set<Aluno> alunosSet;

    public GerenciadorAlunos() {
        this.alunosSet = new HashSet<>();
    }

    public void adicionarAluno(String nome, Long matricula, double media) {
        alunosSet.add(new Aluno(nome, matricula, media));
        System.out.print("Aluno adicionado com sucesso.");
    }

    public void removerAlunoPorMatricula(long matricula) {
        Aluno alunoParaRemover = null;
        if (!alunosSet.isEmpty()) {
            for (Aluno a : alunosSet) {
                if (a.getMatricula() == matricula) {
                alunoParaRemover = a;
                break;
                }
            }
            alunosSet.remove(alunoParaRemover);
        } else {
            throw new RuntimeException("O conjunto está vazio!");
        }

        if (alunoParaRemover == null) {
            System.out.println("Matricula não encontrada!");
        }
    }

    public void exibirAlunosPorNome() {
        Set<Aluno> alunosPorNome = new TreeSet<>(alunosSet);
        if (!alunosSet.isEmpty()) {
            System.out.println(alunosPorNome);
        } else {
            System.out.println("O conjunto está vazio!");
        }
    }

    public void exibirAlunosPorNota() {
        Set<Aluno> alunosPorNota = new TreeSet<>(new ComparatorNota());
        if (!alunosSet.isEmpty()) {
            alunosPorNota.addAll(alunosSet);
            System.out.println(alunosPorNota);
        } else {
            System.out.println("O conjunto está vazio!");
        }
    }

    public static void main(String[] args) {
        GerenciadorAlunos gerenciadorAlunos = new GerenciadorAlunos();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("""
                
                [ 1 ] Adicionar aluno.
                [ 2 ] Remover Aluno.
                [ 3 ] Exibir lista de alunos por nome.
                [ 4 ] Exibir lista de alunos por nota.
                [ 0 ] Sair do programa.
                
                Escolha uma opção: """);

            try {
                int n = scanner.nextInt();
                scanner.nextLine();

                switch (n) {
                    case 1 -> {
                        System.out.print("Digite nome do aluno: ");
                        String nome = scanner.nextLine();
                        System.out.print("Digite matricula do aluno: ");
                        long matricula = scanner.nextLong();
                        System.out.print("Digite média do aluno: ");
                        double media = scanner.nextDouble();
                        gerenciadorAlunos.adicionarAluno(nome, matricula, media);
                    }
                    case 2 -> {
                        System.out.print("Digite matricula do aluno: ");
                        long matricula = scanner.nextLong();
                        gerenciadorAlunos.removerAlunoPorMatricula(matricula);
                    }
                    case 3 -> gerenciadorAlunos.exibirAlunosPorNome();
                    case 4 ->  gerenciadorAlunos.exibirAlunosPorNota();
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
