package br.edu.ifsc.estrutural;

import br.edu.ifsc.criacional.builder.Aluno;
import br.edu.ifsc.criacional.builder.Cliente;
import br.edu.ifsc.criacional.builder.Loja;

import java.util.ArrayList;

public class Main {
    public static void main() {
        AlunoFacade.getInstance().add(Aluno.builder().nome("Renato1").build());
        AlunoFacade.getInstance().add(Aluno.builder().nome("Renato2").build());
        AlunoFacade.getInstance().add(Aluno.builder().nome("Renato3").build());
        AlunoFacade.getInstance().add(Aluno.builder().nome("Renato4").build());
        ClienteFacade.getInstance().add(Cliente.builder().nome("Luis1").build());
        ClienteFacade.getInstance().add(Cliente.builder().nome("Luis2").build());
        ClienteFacade.getInstance().add(Cliente.builder().nome("Luis3").build());
        ClienteFacade.getInstance().add(Cliente.builder().nome("Luis4").build());
        LojaFacade.getInstance().add(Loja.builder().nome("Millium").build());
        LojaFacade.getInstance().add(Loja.builder().nome("Millium").endereco("agua verde").build());
        System.out.println();
    }
}
