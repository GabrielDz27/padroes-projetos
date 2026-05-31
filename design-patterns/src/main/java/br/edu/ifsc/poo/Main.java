package br.edu.ifsc.poo;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() throws Exception{
        CD cd = new CD("Beat it", "Michael Jackson", "Thriller", 350);
        DVD dvd = new DVD("The dark side of the moon", "Pink Floyd", "The dark side of the moon", 700);
        MP3 mp3 = new MP3("Bonde do tigrao", "Tchacabum", "Furacão 2000", 400);

        Player player = new Player();
        player.adicionar(cd);
        player.adicionar(dvd);
        player.adicionar(mp3);
        player.adicionar(mp3);
        player.adicionar(cd);
        player.adicionar(dvd);

        player.listar();
        player.play();
        while(true) {
            player.random();
            Thread.sleep(1000);
        }
    }
}
