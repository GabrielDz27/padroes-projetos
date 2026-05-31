package br.edu.ifsc.comportamental.templatemethod;

public class ContaPJ extends AbstractConta{

    @Override
    public String getTipo() {
        return "PJ";
    }

    @Override
    public double getImposto() {
        return 0.30;
    }

    @Override
    public double limiteIsencao() {
        return 2000;
    }
}
