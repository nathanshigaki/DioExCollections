package ex.collections.Set.Pesquisa;

import java.util.HashSet;
import java.util.Set;

public class ListaTarefas {
    Set<Tarefa> setTarefas;

    public ListaTarefas(){
        this.setTarefas = new HashSet<>();
    }

    public void adicionarTarefa(String descricao){
        setTarefas.add(new Tarefa(descricao, false));
    }

    public void removerTarefa(String descricao){
        if (!setTarefas.isEmpty()){
            for (Tarefa tarefa : setTarefas) {
                if (tarefa.getDescricao().equals(descricao)){
                    
                }
            }
        }
    }

    public static void main(String[] args) {
        ListaTarefas setTarefas = new ListaTarefas();

        setTarefas.adicionarTarefa("a");
    }
}
