package it.epicode.progettosettimanaleS1L5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ElementoMultimediale[] elementi = new ElementoMultimediale[5];

        for (int i = 0; i < 5; i++) {
            System.out.println("Inserisci il tipo di elemento --> a = Audio, v = Video, i = Immagine :");
            String tipo = scanner.next();
            scanner.nextLine();
            System.out.println("Inserisci il titolo:");
            String titolo = scanner.nextLine();

            switch (tipo) {
                case "a":
                    System.out.println("Inserisci la durata:");
                    int durata = scanner.nextInt();
                    System.out.println("Inserisci il volume:");
                    int volume = scanner.nextInt();
                    elementi[i] = new Audio(titolo, durata, volume);
                    break;
                case "v":
                    System.out.println("Inserisci la durata:");
                    durata = scanner.nextInt();
                    System.out.println("Inserisci il volume:");
                    volume = scanner.nextInt();
                    System.out.println("Inserisci la luminosità:");
                    int luminosita = scanner.nextInt();
                    elementi[i] = new Video(titolo, durata, volume, luminosita);
                    break;
                case "i":
                    System.out.println("Inserisci la luminosità:");
                    luminosita = scanner.nextInt();
                    elementi[i] = new Immagine(titolo, luminosita);
                    break;
                default:
                    System.out.println("Tipo di elemento non valido.");
                    i--;
                    break;
            }
        }

        int scelta;
        do {
            System.out.println();
            System.out.println("Scegli un elemento da 1 a 5. Scrivi 0 per finire:");
            for (int i = 0; i < elementi.length; i++) {
                if (elementi[i] != null) {
                    System.out.println((i + 1) + ". " + elementi[i].titolo);
                }
            }
            scelta = scanner.nextInt();

            if (scelta >= 1 && scelta <= 5) {
                ElementoMultimediale elemento = elementi[scelta - 1];
                System.out.println();

                if (elemento instanceof Immagine immagine) {
                    immagine.show();
                    System.out.println("Vuoi modificare la luminosità? (+ per aumentare, - per diminuire, scrivi altro per continuare)");
                    String comando = scanner.next();

                    if (comando.equals("+")) immagine.aumentaLuminosita();
                    if (comando.equals("-")) immagine.diminuisciLuminosita();

                } else if (elemento instanceof Video video) {
                    video.play();
                    System.out.println("Vuoi modificare luminosità o volume? (+l, -l per luminosità; +v, -v per volume, scrivi altro per continuare)");
                    String comando = scanner.next();

                    switch (comando) {
                        case "+l" -> video.aumentaLuminosita();
                        case "-l" -> video.diminuisciLuminosita();
                        case "+v" -> video.alzaVolume();
                        case "-v" -> video.abbassaVolume();
                    }
                } else if (elemento instanceof Audio audio) {
                    audio.play();
                    System.out.println("Vuoi modificare il volume? (+ per aumentare, - per diminuire, scrivi altro per continuare)");
                    String comando = scanner.next();

                    if (comando.equals("+")) audio.alzaVolume();
                    if (comando.equals("-")) audio.abbassaVolume();
                } else {
                    elemento.play();
                }
            } else if (scelta != 0) {
                System.out.println("Scelta non valida.");
            }
        } while (scelta != 0);
    }
}
