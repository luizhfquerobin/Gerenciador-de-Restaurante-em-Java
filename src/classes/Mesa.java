package classes;

public class Mesa {

    private Integer id;
    private Integer capacidade;
    private Boolean isDisponivel;

    public Mesa() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }

    public Boolean getDisponivel() {
        return isDisponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        isDisponivel = disponivel;
    }

    @Override
    public String toString() {
        return "Mesa{" +
                "id=" + id +
                ", capacidade=" + capacidade +
                ", isDisponivel=" + isDisponivel +
                '}';
    }

}
