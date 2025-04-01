package banco;
import banco.cliente.Cliente;
import banco.conta.Conta;
import banco.conta.ContaCorrente;
import banco.conta.ContaPoupanca;
import banco.utils.CadastroCliente;
import banco.utils.OperacoesEnum;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
public class Banco {
    protected static final int AGENCIA_PADRAO = 1;
    protected static int CONTACORRENTE = 0;
    protected static int CONTAPOUPANCA = 0;

    private final String nome;
    private List<Cliente> clientes;
    private List<Conta> contasCorrente;
    private List<Conta> contasPoupanca;

    public Banco(String nome) {
        this.contasPoupanca = new ArrayList<>();
        this.contasCorrente = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.nome = nome;
    }

    public void abrirConta(String nomeCliente, String cpf, boolean poupanca) {

        //Verifica se o cliente existe
        boolean jaExiste = clientes.stream().anyMatch( c-> Objects.equals(c.getCpf(), cpf));
        if(jaExiste){
            throw new CadastroCliente("Este cliente já consta na base de dados");
        } else {
            CONTACORRENTE++;
            var cliente = new Cliente(nomeCliente, cpf);
            Conta contaCorrente = new ContaCorrente(cliente, AGENCIA_PADRAO, CONTACORRENTE);

            clientes.add(cliente);
            contasCorrente.add(contaCorrente);

            System.out.println("Conta corrente criado com o numero: " + contaCorrente.getNumero());

            if(poupanca){
                CONTAPOUPANCA++;
                var contaPoupanca = new ContaPoupanca(cliente, AGENCIA_PADRAO, CONTAPOUPANCA);
                contasPoupanca.add(contaPoupanca);
                System.out.println("Conta poupanca criado com o numero: " + contaCorrente.getNumero());
            }
        }

    }
    private void operacoes(int numeroConta, double valor, OperacoesEnum operacoes, List<Conta> contas){
        var retornoDB = contas.stream().filter(c -> c.getNumero() == numeroConta).toList();
        if(retornoDB.isEmpty()){
            throw new CadastroCliente("Cliente não encontrado");
        } else {
            var conta = retornoDB.getFirst();
            switch (operacoes){
                case SACAR -> conta.sacar(valor);
                case DEPOSITO -> conta.depositar(valor);
            }
        }
    }

    public void depositarContaCorrente(int numeroConta, double valor){
        operacoes(numeroConta, valor, OperacoesEnum.DEPOSITO, contasCorrente);
    }
    public void depositarContaPoupanca(int numeroConta, double valor){
        operacoes(numeroConta, valor,OperacoesEnum.DEPOSITO, contasPoupanca);
    }
    public void sacarContaCorrente(int numeroConta, double valor){
        operacoes(numeroConta, valor, OperacoesEnum.SACAR, contasCorrente);
    }
    public void sacarContaPoupanca(int numeroConta, double valor){
        operacoes(numeroConta, valor, OperacoesEnum.SACAR,contasPoupanca);
    }
    public void transferirEntreContasCorrente(int numeroContaDestino, int numeroContaEnvio, double valor){
        if(numeroContaEnvio == numeroContaDestino) throw  new RuntimeException("A mesma conta foi passada duas vezes");
        operacoes(numeroContaEnvio, valor, OperacoesEnum.SACAR, contasCorrente);
        operacoes(numeroContaDestino, valor, OperacoesEnum.DEPOSITO, contasCorrente);
    }
    public void transferirEntreContasPoupanca(int numeroContaDestino, int numeroContaEnvio, double valor){
        if(numeroContaEnvio == numeroContaDestino) throw  new RuntimeException("A mesma conta foi passada duas vezes");
        operacoes(numeroContaEnvio, valor, OperacoesEnum.SACAR, contasPoupanca);
        operacoes(numeroContaDestino, valor, OperacoesEnum.DEPOSITO, contasPoupanca);
    }
}