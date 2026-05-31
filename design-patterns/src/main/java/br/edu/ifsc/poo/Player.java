package br.edu.ifsc.poo;

import java.util.ArrayList;
import java.util.Random;

public class Player {
    ArrayList<AbstractMedia> medias = new ArrayList<>();
    private Integer mediaAtual = 0;
    public void adicionar(AbstractMedia media){
        medias.add(media);
    }
    public void remover(Integer idx){
        medias.remove(idx);
    }
    public void play(){
        AbstractMedia media = medias.get(mediaAtual);
        System.out.println((mediaAtual+1));
        System.out.println("Tocando o artista " + media.getNomeArtista());
        System.out.println("                  " + media.getDescricao());
        System.out.println("                  " + media.getTipo());
    }
    public void random(){
        mediaAtual = new Random().nextInt(0, medias.size());
        play();
    }
    public void next(){
        mediaAtual++;
        if(mediaAtual>medias.size()-1){
            mediaAtual=0;
        }
        System.out.println("Próxima música: " + (mediaAtual+1));
        play();
    }
    public void previous(){
        mediaAtual--;
        if(mediaAtual<0){
            mediaAtual = medias.size()-1;
        }
        System.out.println("Música anterior:");
        play();
    }
    public void pause(){
        AbstractMedia media = medias.get(mediaAtual);
        System.out.println("Pausando a media: " + media.getDescricao());
    }
    public void listar(){
        int i=0;
        for(AbstractMedia media: medias){
            System.out.println(++i + " - "+media);
        }
    }
}
