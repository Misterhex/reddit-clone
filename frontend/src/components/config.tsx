declare var NODE_ENV: string;

export class Config {
    public serverUrl: string

    constructor(){
        if (NODE_ENV === "production")
            this.serverUrl = "";
        else            
            this.serverUrl = "http://localhost:3000/";
    }
}