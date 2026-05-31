package br.edu.ifsc.comportamental.templatemethod;

public abstract class AbstractConta {
    private double saldo=0;

    public final void credito(double valor){
        if(valor>=limiteIsencao()){
            System.out.println("Aplicando imposto: " + getImposto());
            saldo+=valor - (valor * getImposto());
        }else{
            saldo+=valor;
        }
    }
    public final void debito(double valor){
        saldo-=valor - (valor * getImposto());
    }

    public final double getSaldo() {
        return saldo;
    }

    public void mostrarSaldo(){
        System.out.println("====================");
        System.out.println("Saldo: " + getSaldo());
        System.out.println("Tipo: " + getTipo());
        System.out.printf("Aliquota: %.2f%%\n", (getImposto()*100));
        System.out.println("====================");
    }
    public abstract double limiteIsencao();
    public abstract String getTipo();
    public abstract double getImposto();
}
