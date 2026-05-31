package br.edu.ifsc.criacional.builder;
import lombok.*;
@Builder
@Data
@Getter
public class Aluno implements Entidade{
    private String nome;
    private int codigo;
    private String cpf;
    public static void main(String[] args) {
        Aluno aluno = Aluno.builder()
                .nome("José")
                .codigo(123)
                .cpf("78945612322").build();
        System.out.println(aluno);
        System.out.println(aluno.getNome());
        System.out.println(aluno.getCodigo());
        System.out.println(aluno.getCpf());
        System.out.println(aluno);
        Aluno aluno2 = Aluno.builder()
                .nome("Maria")
                .codigo(123)
                .cpf("78945612322").build();
        System.out.println(aluno2);
        System.out.println(aluno2.getNome());
        System.out.println(aluno2.getCodigo());
        System.out.println(aluno2.getCpf());
        System.out.println(aluno2);

    }

    @Override
    public Aluno clone() {
        try {
            return (Aluno) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e); // Convert to unchecked for cleaner code
        }
    }
}
