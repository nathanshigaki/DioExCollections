package ex.collections.Set.Pesquisa;

public class Tarefa {
    private String descricao;
    private boolean estaConcluida;
    
    public Tarefa(String descricao) {
        this.descricao = descricao;
        this.estaConcluida = false;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isEstaConcluida() {
        return estaConcluida;
    }

    public void setEstaConcluida(boolean estaConcluida) {
        this.estaConcluida = estaConcluida;
    }
}
