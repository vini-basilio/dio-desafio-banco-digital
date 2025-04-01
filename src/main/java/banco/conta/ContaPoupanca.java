package banco.conta;

import banco.cliente.Cliente;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(Cliente cliente, int agencia, int numero) {
        super(cliente, agencia, numero);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("====== Extrato: Conta.Conta poupanca ======");
        super.imprimir();
    }
}
