package ex.collections.Set.Pesquisa;

public class Tarefa {
    private String descricao;
    private boolean estaConcluida = false;
    
    public Tarefa(String descricao, boolean estaConcluida) {
        this.descricao = descricao;
        this.estaConcluida = estaConcluida;
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
