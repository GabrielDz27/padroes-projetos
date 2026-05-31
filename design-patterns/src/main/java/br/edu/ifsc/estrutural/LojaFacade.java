package br.edu.ifsc.estrutural;

import br.edu.ifsc.criacional.builder.Loja;

public class LojaFacade extends AbstractGenericFacade<Loja> {
    private static LojaFacade instance;

    private LojaFacade(){

    }
    public static LojaFacade getInstance() {
        if(instance == null)
            instance = new LojaFacade();
        return instance;
    }
}
