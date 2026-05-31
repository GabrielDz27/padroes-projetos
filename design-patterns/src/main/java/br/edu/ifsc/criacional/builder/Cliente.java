package br.edu.ifsc.criacional.builder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Cliente implements Entidade{
    private int codigo;
    private String nome;
    private String telefone;
    private String email;

    @Override
    public Cliente clone() {
        try {
            return (Cliente) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e); // Convert to unchecked for cleaner code
        }
    }
}
