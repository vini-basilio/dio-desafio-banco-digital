package banco.conta;
import banco.cliente.Cliente;
import banco.utils.OperacoesBancarias;
import lombok.Getter;
import lombok.ToString;

@ToString
public abstract class Conta implements iConta {


    @Getter
    protected int agencia;
    @Getter
    protected int numero;
    @Getter
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente, int agencia, int numero) {

        this.agencia = agencia;
        this.numero = numero;
        this.cliente = cliente;
    }

    @Override
    public void sacar(double valor) {
        if (valor <= 0) throw new OperacoesBancarias("O valor deve ser acima de 0.00");
        if(saldo < valor)throw new OperacoesBancarias("Saldo insuficiente.");
        saldo -= valor;
        System.out.println("Novo saldo: " + saldo);
    }

    @Override
    public void depositar(double valor) {
        if (valor <= 0) throw new OperacoesBancarias("O valor deve ser acima de 0.00");
        saldo += valor;
        System.out.println("Novo saldo: " + saldo);
    }

    @Override
    public void transferir(iConta contaDestino, double valor) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    protected void imprimir() {
        System.out.println("Agencia: " + this.agencia);
        System.out.println("Conta.Conta: " + this.numero);
        System.out.println("Saldo: " + this.saldo);
    }

}
