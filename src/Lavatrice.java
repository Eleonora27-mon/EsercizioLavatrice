public class Lavatrice {
    private boolean sportelloChiuso;

    public Lavatrice() {
   
        this.sportelloChiuso = false;
        this.stato = Stato.spenta;
        this.detersivoPresente = false;
        this.temperatura = 0;
    }
    public boolean SportelloChiuso() {
        return sportelloChiuso;
    }

    public Stato Stato() {
        return stato;
    }

    public boolean DetersivoPresente() {
        return detersivoPresente;
    }

    public int Temperatura() {
        return temperatura;
    }


    public enum Stato {
        spenta, standby, lavaggio_in_corso
    }

    private boolean detersivoPresente;
    private int temperatura;
    private Stato stato;
    

    public void accendi () {
        if (stato !=Stato.spenta){ //Se la lavatrice non è spenta, allora mostro un messaggio d'errore, altrimenti l'accendo
            System.out.println("La lavatrice è già accesa!");}
        else{
            stato=Stato.standby;   
            System.out.println("Hai acceso la lavatrice!");
        } 
    }

    public void standby (){
        if (stato == Stato.standby){
            System.out.println("La lavatrice è in standby!");}
        else {stato=Stato.standby;
        System.out.println("Lavatrice in standby!");}
    
    }

    public void lavaggio_in_corso(){
        if (stato == Stato.lavaggio_in_corso){
            System.out.println("La lavatrice sta eseguendo il lavaggio!");}}

    public void spenta (){
        if(stato==Stato.lavaggio_in_corso){
            System.out.println("La lavatrice non può essere spenta durante il lavaggio!" );
        }
        else {
        stato=Stato.spenta;
        System.out.println("La lavatrice è spenta!");    
        }
     
    }      
    public void apriSportello (){
        if(stato==Stato.lavaggio_in_corso){
            System.out.println("Lo sportello non può essere aperto durante il lavaggio!");
        }
        else {
            sportelloChiuso = false;
            System.out.println("Lo sportello è aperto!");  
        }

        
    } 
    public void chiudiSportello(){
        sportelloChiuso = true;   
        System.out.println("Lo sportello è chiuso!");
    }

    public void aggiungiDetersivo(){
        if(!sportelloChiuso){
            detersivoPresente = true;
            System.out.println("Detersivo aggiunto!");

        }   
        else {
            System.out.println("Apri lo sportello per aggiungere il detersivo!");    
        }

    }
    public void impostaTemperatura (int temperatura){
        if(stato==Stato.standby){
            this.temperatura = temperatura;
            System.out.println("La temperatura impostata è: " + temperatura + " gradi");

        }   
        else {
            System.out.println("La temperatura può essere impostata solo se la lavatrice è in standby!");
        }
    }
    public void avviaLavaggio (){
        if(stato==Stato.standby && detersivoPresente && sportelloChiuso && temperatura>20){
            stato=Stato.lavaggio_in_corso;
            System.out.println("Lavaggio in corso a " + temperatura + " gradi");

        }
        else if (stato==Stato.spenta) {
            System.out.println("La lavatrice non è in standby!" );
            
        }
        else if (!detersivoPresente) {
            System.out.println("Il detersivo non è presente!");

    
        }
        else if (!sportelloChiuso){
            System.out.println("Lo sportello non è stato chiuso!");
        }
    
        else {
            System.out.println("La temperatura deve essere maggiore di 20 gradi");
        }
    }

    public void terminaLavaggio() {
        if(stato==Stato.lavaggio_in_corso){
            stato=Stato.standby;
            detersivoPresente=false;
            System.out.println("Il ciclo di lavaggio è terminato!");
        }
        else {
            System.out.println("Non c'è nessun lavaggio da terminare");
        }
    }


}
