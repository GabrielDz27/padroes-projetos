package br.edu.ifsc.comportamental.templatemethod;

public class Main {
    static void main() {
        ContaPF pf = new ContaPF();
        ContaPJ pj = new ContaPJ();
        pf.credito(1000);
        pf.credito(1000);
        pf.debito(500);

        pj.credito(1000);
        pj.credito(5000);
        pj.debito(500);

        pf.mostrarSaldo();
        pj.mostrarSaldo();
    }
}
