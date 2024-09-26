package classes;

public class Cardapio {

    private String nome;
    private Integer id;
    private Double preco;
    private Integer quantidade;
    private Boolean isDisponivel;

    public Cardapio() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Boolean getDisponivel() {
        return isDisponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        isDisponivel = disponivel;
    }

    @Override
    public String toString() {
        return "Cardapio{" +
                "nome='" + nome + '\'' +
                ", id=" + id +
                ", preco=" + preco +
                ", quantidade=" + quantidade +
                ", isDisponivel=" + isDisponivel +
                '}';
    }
}
