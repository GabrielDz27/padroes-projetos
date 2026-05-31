package br.edu.ifsc.criacional.builder;

public class Usuario {
    private String nome;
    private String telefone;
    private String dataNascimento;
    private String cpf;

    private Usuario(Builder builder) {
        this.nome = builder.nome;
        this.telefone = builder.telefone;
        this.dataNascimento = builder.dataNascimento;
        this.cpf = builder.cpf;
    }

    public void print(){
        System.out.println("Nome: " +nome);
        System.out.println("Telefone: " +telefone);
        System.out.println("Data nascimento: " +dataNascimento);
        System.out.println("CPF: " +cpf);
    }
    public static class Builder{
        private String nome;
        private String telefone;
        private String dataNascimento;
        private String cpf;
        public Builder withNome(String nome){
            this.nome = nome;
            return this;
        }
        public Builder withTelefone(String telefone){
            this.telefone = telefone;
            return this;
        }
        public Builder withDataNascimento(String dataNascimento){
            this.dataNascimento = dataNascimento;
            return this;
        }
        public Builder withCPF(String cpf){
            this.cpf = cpf;
            return this;
        }
        public Usuario build(){
            if (this.nome.trim().isEmpty()){
                throw new IllegalArgumentException("Nome obrigatório");
            }
            return new Usuario(this);
        }
    }
}
