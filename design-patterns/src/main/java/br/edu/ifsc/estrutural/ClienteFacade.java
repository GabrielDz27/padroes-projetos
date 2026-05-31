package br.edu.ifsc.estrutural;

import br.edu.ifsc.criacional.builder.Cliente;

import java.util.ArrayList;

public class ClienteFacade extends AbstractGenericFacade<Cliente> {
    private static ClienteFacade instance;

    private ClienteFacade(){

    }
    public static ClienteFacade getInstance() {
        if(instance == null)
            instance = new ClienteFacade();
        return instance;
    }
}
