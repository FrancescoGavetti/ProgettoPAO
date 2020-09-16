# ProgettoPAO
## Introduzione

L'applicazione presente nella repository, utilizzando le API (Application Programming Interface) di Dropbox, reperibili nell'apposita sezione di Dropbox dedicata agli sviluppatori (https://www.dropbox.com/developers/documentation/http/documentation), e mediante l'ausilio del framework SpringBoot, opera da Web Service.

Un WebService rappresenta un'interfaccia attraverso la quale due dispositivi possono comunicare tra loro mediante l'utilizzo del protocollo HTTP.In particolare questo consente ai clienti che si collegano mediante apposite applicazioni (browser, Postman, ecc.) di usufruire di alcune funzioni messe a loro disposizione.

La finalità del presente progetto è quella di accedere ad una cartella Dropbox privata, tramite l'utilizzo di una chiave di accesso (token), analizzare le revisioni dei singoli file contenuti in essa ed effettuare sugli stessi statistiche su numerosità e tempi medi.

L'applicazione permette di richiedere mediante API REST (GET) con rotte distinte:
* Connessione al API;
* Restituzione di dati (formato JSON);
* Restituzione di statistiche sui dati (formato JSON) e in particolare statistiche sulle revisioni per singolo file con numero di revisioni giornaliere e settimanali e tempo medio tra le revisioni;

### Tecnologie utilizzate
* GitHub: per versioning dell'applicazione;
* IntellIJ: per lo sviluppo dell'applicazione

## Funzionamento
### Avvio dell'applicazione
Una volta lanciata l'applicazione all'interno di un ambiente di sviluppo (IntellIJ), con JVM (Java Virtual Machine), compilatore e framework SpringBoot correttamente istallati sulla macchina, l'applicazione WebService sarà attiva e in ascolto alla porta: http://localhost:8080 .
### Richieste
Mediante richieste GET con rotte determinate, il client può richiedere determinati dati o statistiche.

* **Restituzione dei dati**:

* **Possibili statistiche**:


## Packaging
L'applicazione è composta da 4 packages:
* **com.progetto.PAO.controllers** contiene la classe DropboxController la quale permette l'interazione tra l'utente e l'applicazione mediante l'utilizzo di metodi mappati mediante @RequestMapping;
* **com.progetto.PAO.models** contiene la classe File che costituisce l'entità in grado di rappresentare le informazioni tornate dalle chiamate;
* **com.progetto.PAO.services** contiene la classe Parser che permette di fare il parsing;
* **com.progetto.PAO.utils**  contiene la classe ConnectDropbox, la quale consente di connettersi a Dropbox e fare le richieste.

## UML
### Class Diagram

### Use Case Diagram

### Activity Diagram

### Sequence Diagram
* **getUsage()**

* **getCount()**

* **getAllFiles**

* **getStatistics()**






