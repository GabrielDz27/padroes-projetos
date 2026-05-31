package br.edu.ifsc.poo;

public abstract class MediaMagnetica extends AbstractMedia{
    public MediaMagnetica(String descricao, String nomeArtista, String nomeAlbum, Integer duracao) {
        super(descricao, nomeArtista, nomeAlbum, duracao);
    }

    @Override
    public TipoEnum getTipo() {
        return TipoEnum.MAGNETICA;
    }
}
