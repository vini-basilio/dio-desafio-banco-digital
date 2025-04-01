package banco.conta;

import banco.cliente.Cliente;

public class ContaCorrente extends Conta {
    public ContaCorrente(Cliente cliente, int agencia, int numero) {
        super(cliente, agencia, numero);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("====== Extrato: Conta.Conta corrente ======");
        super.imprimir();
    }
}
