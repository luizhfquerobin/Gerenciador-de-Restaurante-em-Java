package classes;

public class ItemPedido {

    private Integer idCardapio;
    private Integer idPedido;
    private Integer quantidade;

    public ItemPedido() {
    }

    public Integer getIdCardapio() {
        return idCardapio;
    }

    public void setIdCardapio(Integer idCardapio) {
        this.idCardapio = idCardapio;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "ItemPedido{" +
                "idCardapio=" + idCardapio +
                ", idPedido=" + idPedido +
                ", quantidade=" + quantidade +
                '}';
    }
}
