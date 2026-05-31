package br.edu.ifsc.poo;

public abstract class AbstractMedia {

    public enum TipoEnum{
        MAGNETICA, OPTICA
    }

    private String descricao;
    private Integer segundos;
    private String nomeArtista;
    private String nomeAlbum;

    public AbstractMedia(String descricao, String nomeArtista, String nomeAlbum, Integer duracao){
        setDescricao(descricao);
        setNomeAlbum(nomeAlbum);
        setNomeArtista(nomeArtista);
        setSegundos(duracao);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getSegundos() {
        return segundos;
    }

    public void setSegundos(Integer segundos) {
        this.segundos = segundos;
    }

    public String getNomeArtista() {
        return nomeArtista;
    }

    public void setNomeArtista(String nomeArtista) {
        this.nomeArtista = nomeArtista;
    }

    public String getNomeAlbum() {
        return nomeAlbum;
    }

    public void setNomeAlbum(String nomeAlbum) {
        this.nomeAlbum = nomeAlbum;
    }

    public abstract TipoEnum getTipo();

    @Override
    public String toString() {
        return getNomeArtista() +" " + getNomeAlbum() + " "+ getDescricao() +" - " + getSegundos() + " segundos";
    }
}
