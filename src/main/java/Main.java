import banco.Banco;

public class Main {

    public static void main(String[] args) {

        Banco DIO = new Banco("Digital Innovation One");

        DIO.abrirConta("Bob", "1111", true);
//        DIO.abrirConta("Bob 2", "1111", true);


        DIO.depositarContaCorrente(1, 20);
        DIO.sacarContaCorrente(1, 10);
        //        DIO.sacarContaCorrente(1, 100);

        DIO.abrirConta("Eve", "1112", true);
        DIO.transferirEntreContasCorrente(2,1, 2);

    }
}