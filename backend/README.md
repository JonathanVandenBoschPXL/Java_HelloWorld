# PRiSMA backend

Deze folder bevat de broncode van de backend applicatie.
## Voorwaarden

- JDK 17+ met Maven
- Docker met docker-compose
- IntelliJ IDEA of andere IDE met Java ondersteuning

## Architectuur

De backend is opgebouwd in twee modules:

- prisma-service  
    Deze bevat de logica van de daadwerkelijke PRiSMA applicatie.
- identity-server  
    Deze bevat de implementatie van een identity server voor authenticatie. (TBD)

## Lokale deployment prisma-service

Om de applicatie lokaal te runnen zijn er volgende stappen nodig:

### .env file

- Kopieer de inhoud van de .env.sample file naar een nieuwe file genaamd: .env
- Vul achter het = teken de juiste waardes in.
- Editeer de configuratie van de PrismaServiceApplication:

    Services -> PrismaServiceApplication -> rechtermuisklik -> Edit configuration
    ![](/Users/maude/School/2022-2023/Semester 1/IT-project/PRiSMA/backend/configuratie_env.png)


**!Opmerking!: De .env file staat in de .gitignore file. Deze file bevat paswoorden
en mag **nooit** commit worden.**

### prisma-service-db

Er wordt gebruik gemaakt van een MySQL database in een docker container.   
Om deze op te starten:

`cd backend/prisma-service`   
`docker-compose up`

De database wordt gestart op poort **3308**.  
Om te connecteren met de database via IntelliJ kan deze als data source worden toegevoegd.  
Selecteer MySQL met de correct poort en database naam.

Deze database zal initieel leeg zijn. Bij het starten van de prisma-service applicatie zal deze worden
opgevuld aan de hand van Flyway scripts.

### Opstarten prisma-service

(IntelliJ)  
Open de folder backend in IntelliJ.  
Via View -> Tool Windows -> Services kan het services venster geopend worden.  
In Services kan de PrismaServiceApplication gestart worden.  

Hierbij worden ook de Flyway scripts gecheckt en wordt er een database-migratie gedaan indien nodig. 

### Beschikbaarheid prisma-service

De prisma-service is bereikbaar op poort **7000** met prefix /api.

### Documentatie

Er is een swagger documentatie beschikbaar via:
[http://localhost:7000/api/swagger-ui/index.html](http://localhost:7000/api/swagger-ui/index.html)
