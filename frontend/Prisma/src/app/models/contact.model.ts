export class Contact {
    onderwerp: string;
    verzender: string;
    body: string;
    naam: string;

    constructor(onderwerp: string, verzender: string, emailText: string, naam: string) {
        this.onderwerp = onderwerp;
        this.verzender = verzender;
        this.body = emailText;
        this.naam = naam;
    }
}
