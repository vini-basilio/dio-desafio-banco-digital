package banco.conta;

public interface iConta {
     void sacar(double valor);

     void depositar(double valor);

     void imprimirExtrato();

     void transferir(iConta contaDestino, double valor);
}
