package br.edu.ifsc.criacional.builder;

public class Main {
    public static void main(String[] args) {
        Usuario usuario = new
                Usuario.Builder()
                .withTelefone("99788998")
                .withCPF("78945612322")
                .withDataNascimento("10/05/1992")
                .withNome("João da Silva")
                .build();
        usuario.print();
    }
}
