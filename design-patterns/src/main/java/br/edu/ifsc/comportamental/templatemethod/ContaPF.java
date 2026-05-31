package br.edu.ifsc.comportamental.templatemethod;

public class ContaPF extends AbstractConta{
    @Override
    public String getTipo() {
        return "PF";
    }

    @Override
    public double getImposto() {
        return 0.15;
    }

    @Override
    public double limiteIsencao() {
        return 5000;
    }
}
