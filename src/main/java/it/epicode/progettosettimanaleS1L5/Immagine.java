package it.epicode.progettosettimanaleS1L5;

public class Immagine extends ElementoMultimediale implements EseguiMultimedia,  Luminosita{
    int luminosita;

    Immagine(String titolo, int luminosita){
        super(titolo);
        this.luminosita = luminosita;
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
    public void show() {
        System.out.println(titolo + " " + "*".repeat(luminosita));
    }
}
