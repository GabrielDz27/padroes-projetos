package br.edu.ifsc.criacional.builder;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Loja implements Entidade{
    private int codigo;
    private String nome;
    private String endereco;
    @Override
    public Loja clone() {
        try {
            return (Loja) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e); // Convert to unchecked for cleaner code
        }
    }
}
