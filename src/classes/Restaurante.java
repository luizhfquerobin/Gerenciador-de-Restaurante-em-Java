package classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Restaurante {

    static Scanner scanner = new Scanner(System.in);

    List<Funcionario> funcionarios;
    List<Cardapio> cardapios;
    List<Mesa> mesas;
    List<Pedido> pedidos;

    public Restaurante() {
        this.funcionarios = new ArrayList<>();
        this.cardapios = new ArrayList<>();
        this.mesas = new ArrayList<>();
        this.pedidos = new ArrayList<>();
    }

    // -- Iniciando Sistema e Menu -- //

    public void iniciarSistema() {
        System.out.print("Sistema iniciado\n");
        menu();
    }

    private void menu() {
        System.out.println("Selecione a opação (refazer essa parte de seleção): "); //refazer
        int opcao = scanner.nextInt();

        while (true) {
            switch (opcao) {
                case 1:
                    menuFuncionario(); // a fazer o relatorio
                    break;
                case 2:
                    menuCardapio();
                    break;
                case 3:
                    menuMesa();
                    break;
                case 4:
                    menuPedido();
                    break;
                case 5:
                    gerarRelatorioDeFaturamento();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Opção inválida");
            }
            System.out.println();
            menu();
        }
    } // a fazer o print

    // -- Funcionário -- //

    private void menuFuncionario() {
        System.out.println("Selecione uma das opções abaixo:\n1 - Cadastrar\n2 - Editar\n3 - Deletar\n4 - Listar\n5 - Gerar Relatório De Vendas Do Funcionário");
        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                cadastrarFuncionario();
                break;
            case 2:
                editarFuncionario();
                break;
            case 3:
                deletarFuncionario();
                break;
            case 4:
                listarFuncionarios();
                break;
            case 5:
//                gerarRelatorioVendasFuncionario(); a fazer
                break;
            default:
                System.out.println("Opção inválida");
                menuFuncionario();
        }
    }

    private void cadastrarFuncionario() {
        Funcionario funcionario = new Funcionario();
        System.out.println("Digite o nome do funcionário: ");
        funcionario.setNome(scanner.next());
        System.out.println("Selecione o cargo do funcionário:\n1 - Garçom\n2 - Cozinheiro\n3 - Gerente");
        int opcaoCargo = scanner.nextInt();
        switch (opcaoCargo) {
            case 1:
                funcionario.setCargo("Garçom");
                break;
            case 2:
                funcionario.setCargo("Cozinheiro");
                break;
            case 3:
                funcionario.setCargo("Gerente");
                break;
            default:
                System.out.println("Opção inválida");
                cadastrarFuncionario();
                return;
        }
        if (this.funcionarios.isEmpty()) {
            funcionario.setId(1);
        } else {
            funcionario.setId(this.funcionarios.get(funcionarios.size() - 1).getId() + 1);
        }
        this.funcionarios.add(funcionario);
        System.out.println("Adicionado com sucesso");
        System.out.println(funcionario);
    }

    private void editarFuncionario() {
        System.out.println("Digite o ID do funcionário:");
        int id = scanner.nextInt();

        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getId() == id) {
                System.out.println(funcionario);
                System.out.println("Digite o novo nome do funcionário: ");
                funcionario.setNome(scanner.next());
                System.out.println("Selecione o novo cargo do funcionário:\n1 - Garçom\n2 - Cozinheiro\n3 - Gerente");
                int opcaoCargo = scanner.nextInt();
                switch (opcaoCargo) {
                    case 1:
                        funcionario.setCargo("Garçom");
                        break;
                    case 2:
                        funcionario.setCargo("Cozinheiro");
                        break;
                    case 3:
                        funcionario.setCargo("Gerente");
                        break;
                    default:
                        System.out.println("Opção inválida");
                        editarFuncionario();
                        return;
                }

                System.out.println(funcionario);
            }
        }

        System.out.println("Editado com sucesso");
    }

    private void deletarFuncionario() {
        System.out.println("Digite o ID do funcionário:");
        int id = scanner.nextInt();

        this.funcionarios.removeIf(funcionario -> funcionario.getId() == id);
        System.out.println("Deletado com sucesso");
    }

    private void listarFuncionarios() {
        System.out.println("Funcionários cadastrados: ");
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario.toString());
        }
    }

    // gerarRelatorioVendasFuncionario() {} a fazer

    // -- Cardápio -- //

    private void menuCardapio() {
        System.out.println("Selecione uma das opções abaixo:\n1 - Cadastrar\n2 - Editar\n3 - Deletar\n4 - Listar");
        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                cadastrarCardapio();
                break;
            case 2:
                editarCardapio();
                break;
            case 3:
                deletarCardapio();
                break;
            case 4:
                listarCardapio();
                break;
            default:
                System.out.println("Opção inválida");
                menuCardapio();
        }
    }

    private void cadastrarCardapio() {
        Cardapio cardapio = new Cardapio();
        System.out.println("Digite o nome do item do cardápio: ");
        cardapio.setNome(scanner.next());
        System.out.println("Digite o preço do item do cardápio: ");
        cardapio.setPreco(scanner.nextDouble());
        System.out.println("Digite a quantidade do item do cardápio em estoque: ");
        cardapio.setQuantidade(scanner.nextInt());
        cardapio.setDisponivel(cardapio.getQuantidade() != 0);
        if (this.cardapios.isEmpty()) {
            cardapio.setId(1);
        } else {
            cardapio.setId(this.cardapios.get(cardapios.size() - 1).getId() + 1);
        }
        this.cardapios.add(cardapio);
        System.out.println("Adicionado com sucesso");
        System.out.println(cardapio);
    }

    private void editarCardapio() {
        System.out.println("Digite o ID do item do cardápio:");
        int id = scanner.nextInt();

        for (Cardapio cardapio : cardapios) {
            if (cardapio.getId() == id) {
                System.out.println(cardapio);
                System.out.println("Digite o novo nome do item do cardápio: ");
                cardapio.setNome(scanner.next());
                System.out.println("Digite o novo preço do item do cardápio: ");
                cardapio.setPreco(scanner.nextDouble());
                System.out.println("Digite a nova quantidade do item em estoque: ");
                cardapio.setQuantidade(scanner.nextInt());
                cardapio.setDisponivel(cardapio.getQuantidade() != 0);
                System.out.println("Editado com sucesso");
                System.out.println(cardapio);
            }
        }
    }

    private void deletarCardapio() {
        System.out.println("Digite o ID do item do carápio:");
        int id = scanner.nextInt();

        this.cardapios.removeIf(cardapio -> cardapio.getId() == id);
        System.out.println("Deletado com sucesso");
    }

    private void listarCardapio() {
        System.out.println("Itens do cardápio cadastrados: ");
        for (Cardapio cardapio : cardapios) {
            System.out.println(cardapio.toString());
        }
    }

    // -- Mesa -- //

    private void menuMesa() {
        System.out.println("Selecione uma das opções abaixo:\n1 - Cadastrar\n2 - Editar\n3 - Deletar\n4 - Listar");
        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                cadastrarMesa();
                break;
            case 2:
                editarMesa();
                break;
            case 3:
                deletarMesa();
                break;
            case 4:
                listarMesa();
                break;
            default:
                System.out.println("Opção inválida");
                menuMesa();
        }
    }

    private void cadastrarMesa() {
        Mesa mesa = new Mesa();
        System.out.println("Digite a capacidade da mesa: ");
        mesa.setCapacidade(scanner.nextInt());
        mesa.setDisponivel(true);
        if (this.mesas.isEmpty()) {
            mesa.setId(1);
        } else {
            mesa.setId(this.mesas.get(mesas.size() - 1).getId() + 1);
        }
        this.mesas.add(mesa);
        System.out.println("Adicionado com sucesso");
        System.out.println(mesa);
    }

    private void editarMesa() {
        System.out.println("Digite o ID da mesa: (-1 para cancelar)");
        int id = scanner.nextInt();

        if (id == -1) return;

        for (Mesa mesa : mesas) {
            if (mesa.getId() == id) {
                System.out.println(mesa);
                System.out.println("Digite a nova capacidade da mesa: ");
                mesa.setCapacidade(scanner.nextInt());
                System.out.println("Editado com sucesso");
                System.out.println(mesa);
            }
        }
    }

    private void deletarMesa() {
        System.out.println("Digite o ID da mesa (-1 para cancelar):");
        int id = scanner.nextInt();

        if (id == -1) return;

        if (!this.mesas.removeIf(mesa -> mesa.getId() == id)) {
            System.out.println("Opção inválida");
            deletarMesa();
        }
        System.out.println("Deletado com sucesso");
    }

    private void listarMesa() {
        System.out.println("Mesas cadastradas: ");
        for (Mesa mesa : mesas) {
            System.out.println(mesa.toString());
        }
    }

    // -- Pedido -- //

    private void menuPedido() {
        System.out.println("Selecione uma das opções abaixo:\n1 - Cadastrar\n2 - Listar");
        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                cadastrarPedido();
                break;
            case 2:
                listarPedido();
                break;
            default:
                System.out.println("Opção inválida");
                menuPedido();
        }
    }

    private void cadastrarPedido() {
        Pedido pedido = new Pedido();
        System.out.println("Digite o ID do garçom: ");
        pedido.setIdGarcom(scanner.nextInt());
        System.out.println("Digite o ID da mesa: ");
        pedido.setIdGarcom(scanner.nextInt());

        if (this.mesas.isEmpty()) {
            pedido.setId(1);
        } else {
            pedido.setId(this.cardapios.get(cardapios.size() - 1).getId() + 1);
        }

        int opcao = 1;
        do {
            ItemPedido itemPedido = criarItemPedido(pedido.getId());
            if (itemPedido.getIdPedido() != -1) {
                pedido.getItensPedido().add(itemPedido);
                pedido.setItensPedido(pedido.getItensPedido());
                System.out.println("Adicionar mais itens?\n1 - Sim\n2 - Não");
                opcao = scanner.nextInt();
            } else {
                break;
            }
        } while (opcao != 2);

        // fazer o valor total,  tem q verificar se os id existe e bla bla

        this.pedidos.add(pedido);

        System.out.println("Adicionado com sucesso");
        System.out.println(pedido);
    }

    private ItemPedido criarItemPedido(Integer idPedido) {
        ItemPedido itemPedido = new ItemPedido();
        System.out.println("Digite o ID do item do cardápio: (-1 para cancelar)");
        int idCardapio = scanner.nextInt();

        if (idCardapio == -1) {
            itemPedido.setIdPedido(-1);
        } else {
            if (!cardapios.isEmpty()) {
                for (Cardapio cardapio : cardapios) {
                    if (cardapio.getId().equals(idCardapio)) {
                        itemPedido.setIdCardapio(idCardapio);
                    } else {
                        System.out.println("Item do cardápio não existe");
                        return criarItemPedido(idPedido);
                    }
                }
            } else {
                System.out.println("Cardápio está vazio");
                return criarItemPedido(idPedido);
            }

            System.out.println("Digite a quantidade pedida: ");
            int quantidade = scanner.nextInt();
           if (!mesas.isEmpty()) {
               for (Cardapio cardapio : cardapios) {
                   if (cardapio.getQuantidade() >= quantidade ) {
                       itemPedido.setQuantidade(quantidade);
                       cardapio.setQuantidade(cardapio.getQuantidade() - quantidade);
                   } else {
                       System.out.println("Quantidade não disponivel, em estoque: " + cardapio.getQuantidade());
                       return criarItemPedido(idPedido);
                   }
               }
           } else {
               System.out.println("Não há mesas cadastradas");
               return criarItemPedido(idPedido);
           }

            itemPedido.setIdPedido(idPedido);
        }
        return itemPedido;
    }

    private void listarPedido() {
        System.out.println("Pedidos cadastrados: ");
        for (Pedido pedido : pedidos) {
            System.out.println(pedido.toString());
        }
    }

    // -- Restaurante -- //

    private void gerarRelatorioDeFaturamento() {
        // a fazer
    }
}
