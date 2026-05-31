package br.edu.ifsc.criacional.singleton;

import br.edu.ifsc.criacional.builder.Aluno;
import br.edu.ifsc.estrutural.AbstractGenericFacade;

public class AlunoFacadeSingleton extends AbstractGenericFacade<Aluno> {

    private AlunoFacadeSingleton() {
        // Construtor privado para evitar instanciação externa
    }

    private static class Holder {
        private static final AlunoFacadeSingleton INSTANCE = new AlunoFacadeSingleton();
    }

    public static AlunoFacadeSingleton getInstance() {
        return Holder.INSTANCE;
    }
}
