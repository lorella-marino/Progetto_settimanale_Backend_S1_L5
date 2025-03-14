package it.epicode.progettosettimanaleS1L5;

public class Video extends ElementoMultimediale implements EseguiMultimedia, Luminosita, Volume {
    int volume;
    int durata;
    int luminosita;

    Video(String titolo, int durata, int volume, int luminosita){
        super(titolo);
        this.durata = durata;
        this.volume = volume;
        this.luminosita = luminosita;
    }

    @Override
    public void alzaVolume(){
        volume++;
    }

    @Override
    public void abbassaVolume(){
        volume--;
    }

    @Override
    public void aumentaLuminosita(){
        luminosita++;
    }

    @Override
    public void diminuisciLuminosita(){
        luminosita--;
    }

    @Override
    public void play() {
        for (int i = 0; i < durata; i++) {
            System.out.println(titolo + " " + "!".repeat(volume) + " " + "*".repeat(luminosita));
        }
    }

}
