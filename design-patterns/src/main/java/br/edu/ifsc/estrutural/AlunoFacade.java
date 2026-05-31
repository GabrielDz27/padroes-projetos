package br.edu.ifsc.estrutural;

import br.edu.ifsc.criacional.builder.Aluno;

public class AlunoFacade extends AbstractGenericFacade<Aluno> {
    private static AlunoFacade instance;

    private AlunoFacade(){

    }
    public static AlunoFacade getInstance() {
        if(instance == null)
            instance = new AlunoFacade();
        return instance;
    }
}

