import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int risposta;
        Lavatrice l = new Lavatrice();
        boolean continua = true;
   
        while (continua) {
            System.out.println("Menù di comandi");
            System.out.println("1: Accendi la lavatrice");
            System.out.println("2: Spegni la lavatrice");
            System.out.println("3: Inserisci il detersivo");
            System.out.println("4: Apri il cestello");
            System.out.println("5: Chiudi il cestello");
            System.out.println("6: Imposta la temperatura");
            System.out.println("7: Avvia il lavaggio");
            System.out.println("8: Termina il lavaggio");
            System.out.println("9: Chiudi il programma");
            System.out.print("Inserisci il comando!: ");
            int comando = sc.nextInt();
            

            switch (comando) {
                case 1:
                    l.accendi();
                    break;
                case 2:
                    l.spenta();
                    break;
                case 3:
                    l.aggiungiDetersivo();
                    break;
                case 4:
                    l.apriSportello();
                    break;
                case 5:
                    l.chiudiSportello();
                    break;
                case 6:
                    System.out.println("Quale temperatura vuoi impostare?");
                    int rispostaTemperatura;
                    rispostaTemperatura=sc.nextInt();
                    l.impostaTemperatura(rispostaTemperatura);
                    break;
                case 7:
                    l.avviaLavaggio();
                    break;
                case 8:
                    l.terminaLavaggio();
                    break;
                case 9:
                continua=false;
                System.out.println("Grazie per aver usato la lavatrice!");
                break;

                

                default:
                System.out.println("Comando non accettato");
                    break;
            }
        }
        sc.close();
    }

}
