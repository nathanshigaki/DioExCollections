package ex.collections.Set.Pesquisa;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public class ListaTarefas {
    Set<Tarefa> setTarefas;

    public ListaTarefas(){
        this.setTarefas = new HashSet<>();
    }

    public void adicionarTarefa(String descricao){
        setTarefas.add(new Tarefa(descricao));
        System.out.println("Tarefa adicionada com sucesso.");
    }

    public void removerTarefa(String descricao){
        if (!setTarefas.isEmpty()){
            for (Tarefa tarefa : setTarefas) {
                if (tarefa.getDescricao().equals(descricao)){
                    setTarefas.remove(tarefa);
                    break;
                }
            }
        }
        exibirTarefas();
    }

    public void exibirTarefas(){
        if(!setTarefas.isEmpty()) {
            System.out.println(setTarefas);
        } else {
            System.out.println("Lista de tarefa vazia!");
        }
    }

    public int contarTarefas() {
        return setTarefas.size();
    }

    public Set<Tarefa> obterTarefasConcluidas() {
        Set<Tarefa> tarefasConcluidas = new HashSet<>();
        for (Tarefa t : setTarefas) {
            if (t.isEstaConcluida()) {
                tarefasConcluidas.add(t);
            }
        }
        return tarefasConcluidas;
    }
    
    public Set<Tarefa> obterTarefasPendentes() {
        Set<Tarefa> tarefasNaoConcluidas = new HashSet<>();
        for (Tarefa t : setTarefas) {
            if (!t.isEstaConcluida()) {
                tarefasNaoConcluidas.add(t);
            }
        }
        return tarefasNaoConcluidas;
    }
    
    public void marcarTarefaConcluida(String descricao) {
        for (Tarefa t : setTarefas) {
            if (t.getDescricao().equalsIgnoreCase(descricao)) {
                t.setEstaConcluida(true);
            }
        }
    }
    
    public void marcarTarefaPendente(String descricao) {
        Tarefa tarefaParaMarcarComoPendente = null;
        for (Tarefa t : setTarefas) {
            if (t.getDescricao().equalsIgnoreCase(descricao)) {
                tarefaParaMarcarComoPendente = t;
                break;
            }
        }
    
        if (tarefaParaMarcarComoPendente != null) {
            if(tarefaParaMarcarComoPendente.isEstaConcluida()) {
                tarefaParaMarcarComoPendente.setEstaConcluida(false);
            }
        } else {
            System.out.println("Tarefa não encontrada na lista.");
        }
    }
    
    public void limparListaTarefas() {
        if(setTarefas.isEmpty()) {
            System.out.println("A lista já está vazia!");
        } else {
            setTarefas.clear();
        }
    }
    

    public static void main(String[] args) {
        ListaTarefas setTarefas = new ListaTarefas();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("""
                
                [ 1 ] Adicionar tarefa.
                [ 2 ] Remover tarefa.
                [ 3 ] Contar tarefas.
                [ 4 ] Exibir lista de tarefas.
                [ 5 ] Marcar tarefa concluida.
                [ 6 ] Marcar tarefa pendente.
                [ 7 ] Exibir lista de tarefas concluidas.
                [ 8 ] Exibir lista de tarefas pendentes.
                [ 9 ] Limpar lista de tarefas.
                [ 0 ] Sair do programa.
                
                Escolha uma opção: """);

            try {
                int n = scanner.nextInt();
                scanner.nextLine();

                switch (n) {
                    case 1 -> {
                        System.out.print("Digite uma tarefa: ");
                        String palavra = scanner.nextLine();
                        setTarefas.adicionarTarefa(palavra);
                    }
                    case 2 -> {
                        System.out.print("Digite uma tarefa para ser removida: ");
                        String palavra = scanner.nextLine();
                        setTarefas.removerTarefa(palavra);
                    }
                    case 3 -> System.out.println("Quantidade: "+ setTarefas.contarTarefas());
                    case 4 -> setTarefas.exibirTarefas();
                    case 5 -> {
                        System.out.print("Digite uma tarefa para ser concluida: ");
                        String palavra = scanner.nextLine();
                        setTarefas.marcarTarefaConcluida(palavra);
                    }
                    case 6 -> {
                        System.out.print("Digite uma tarefa para ser pendente: ");
                        String palavra = scanner.nextLine();
                        setTarefas.marcarTarefaPendente(palavra);
                    }
                    case 7 -> System.out.println(setTarefas.obterTarefasConcluidas());
                    case 8 -> System.out.println(setTarefas.obterTarefasPendentes());
                    case 9 -> setTarefas.limparListaTarefas();
                    case 0 -> {
                        System.out.println("Saindo do programa.");
                        scanner.close();
                        return;
                    }
                    default -> System.out.println("Opção inválida, tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro. Opção inválida, insira um número entre 0 e 9.");
                scanner.nextLine();
            }
        }
    }
}
