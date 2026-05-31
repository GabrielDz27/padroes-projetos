package br.edu.ifsc.criacional.builder;

public interface Entidade extends Cloneable{
    public String getNome();
    public void setCodigo(int codigo);
    public int getCodigo();
    public Object clone();
}
