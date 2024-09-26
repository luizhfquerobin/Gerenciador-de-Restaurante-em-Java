package classes;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private Integer id;
    private Integer idMesa;
    private Integer idGarcom;
    private List<ItemPedido> itensPedido;
    private Double valorTotal;

    public Pedido() {
        this.itensPedido = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(Integer idMesa) {
        this.idMesa = idMesa;
    }

    public Integer getIdGarcom() {
        return idGarcom;
    }

    public void setIdGarcom(Integer idGarcom) {
        this.idGarcom = idGarcom;
    }

    public List<ItemPedido> getItensPedido() {
        return itensPedido;
    }

    public void setItensPedido(List<ItemPedido> itensPedido) {
        this.itensPedido = itensPedido;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", idMesa=" + idMesa +
                ", idGarcom=" + idGarcom +
                ", itensPedido=" + itensPedido.toString() +
                ", valorTotal=" + valorTotal +
                '}';
    }
}
