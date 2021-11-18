package snooker;

public class Data {
    private int helyezes,nyeremeny;
    private String nev,orszag;
    
    //fájlbeolvasásnál használt konstruktor
    public Data(String sor){
        //sor -> fájlból beolvasott egy sor pl:52;Akani Sunny;Thaiföld;118500
        String adatok[]=sor.split(";"); // <- tagolás ; 
        this.helyezes=Integer.parseInt(adatok[0]);
        this.nev=adatok[1];
        this.orszag=adatok[2];
        this.nyeremeny=Integer.parseInt(adatok[3]);
    }

    //konstruktor ha kézzel kell új értéket bevinni
    public Data(int helyezes, int nyeremeny, String nev, String orszag) {
        this.helyezes = helyezes;
        this.nyeremeny = nyeremeny;
        this.nev = nev;
        this.orszag = orszag;
    }

    public int getHelyezes() {
        return helyezes;
    }

    public int getNyeremeny() {
        return nyeremeny;
    }

    public String getNev() {
        return nev;
    }

    public String getOrszag() {
        return orszag;
    }
    
    
    
}
