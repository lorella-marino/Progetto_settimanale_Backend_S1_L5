package it.epicode.progettosettimanaleS1L5;

public class Audio extends ElementoMultimediale implements EseguiMultimedia, Volume {
    int volume;
    int durata;

    Audio(String titolo, int durata, int volume){
        super(titolo);
        this.durata = durata;
        this.volume = volume;
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
    public void play() {
        for (int i = 0; i < durata; i++) {
            System.out.println(titolo + " " + "!".repeat(volume));
        }
    }

}
