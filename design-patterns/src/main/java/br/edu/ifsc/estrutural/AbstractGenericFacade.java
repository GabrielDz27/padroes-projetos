package br.edu.ifsc.estrutural;

import br.edu.ifsc.criacional.builder.Entidade;

import java.util.ArrayList;

public abstract class AbstractGenericFacade<E extends Entidade> {
    private ArrayList<E> db = new ArrayList<>();
    private int cont=1;

    public E add(E e){
        e.setCodigo(cont++);
        db.add(e);
        return e;
    }

    public void delete(int codigo){
        E find = null;
        for(E e: db){
            if(e.getCodigo()==codigo){
                find = e;
                break;
            }
        }
        if(find !=null)
            db.remove(find);
    }
    public ArrayList<E> getByNome(String nome){
        ArrayList<E> results = new ArrayList<>();
        for(E e: db){
            if(e.getNome().contains(nome)){
                results.add(e);
            }
        }
        return results;
    }

    public ArrayList<E> getAll(){
        ArrayList<E> copia = new ArrayList<>();
        for(E c: db){
            E clone = (E) c.clone();
            copia.add(clone);
        }
        return copia;
    }
}
