package snooker;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Snooker {

    public static void main(String[] args) {
        //1-2 feladat
        ArrayList<Data> lista=new ArrayList<>();
        String fejlec;
        try{
            BufferedReader br=new BufferedReader(new FileReader("snooker.txt"));
            String sor;
            fejlec=br.readLine(); //a fájl elején a oszlopok elnevezése van ezt külön tároljuk (Helyezes;Nev;Orszag;Nyeremeny)
            while((sor=br.readLine())!=null) // beolvassuk a következő sort és megnézzük hogy van e értéke
                lista.add(new Data(sor));
            
            br.close();
        }
        catch(IOException e){
            System.err.println(e.getMessage());
        }
        
        //3.feladat
        System.out.println("3. feladat: A világranglistán "+lista.size() +" versenyző szerepel.");
        
        //4.feladat
        int sum=0;
        for(Data d:lista)// foreach -> végigmegyünk a listán
            sum+=d.getNyeremeny();// összeadjuk a nyereményeket
        //átlag számítás: sum lessz az összes nyeremény, lista.size pedig a darabszám
        System.out.printf("4. feladat: A versenyzők átlagosan %.2f fontot kerestek.\n",(double)sum/lista.size());
        
        //5.feladat
        //380 Ft-os angol font árfolyammal dolgozzon!
        int max=0,index=0,maxIndex=0;
        for(Data d:lista){// foreach amivel végigmegyünk a lista sorain, d <- lista egy sora
            if(d.getOrszag().equals("K�na")){// megnézük hogy az adott versenyző Kinai származásu
                if(d.getNyeremeny()>max){ // max kereséss a legnagyobb nyeremény megtalálására
                    max=d.getNyeremeny();
                    maxIndex=index; // elmentjük hogy hanyadik sorban van ez a versenyző
                }
            }
            index++;
        }
        Data kinaiVersenyzo=lista.get(maxIndex); // kivesszük a listából a versenyző adatait 
        System.out.println("5. feladat: A legjobban kereső kínai versenyző: "
                                + "\n\tHelyezés:  "+kinaiVersenyzo.getHelyezes()
                                + "\n\tNév:  "+kinaiVersenyzo.getNev()
                                + "\n\tOrszág:  " +kinaiVersenyzo.getOrszag()
                                + "\n\tNyeremény összege: "+kinaiVersenyzo.getNyeremeny()*380 +" Ft"); 
                                //*380 font/forint átváltás
        
        //6.feladat
        System.out.print("6. feladat: ");
        boolean van=false;
        for(Data d:lista){
            if(d.getOrszag().equals("Norv�gia")){
                van=true;
                break;// ha norvég a versenyző akkor nem kell tovább keressünk kilépünk a ciklusból
            }
        }
        if(van)
            System.out.println("A versenyzők között van norvég versenyző.");
        else
            System.out.println("A versenyzők között nincs norvég versenyző.");
        
        //7. feladat 
        System.out.println("7. feladat: Statisztika");
        ArrayList<String> orszagok=new ArrayList<>();// eltároljuk az országokat
        for(Data d:lista){//végigmegyünk a listán
            if(orszagok.indexOf(d.getOrszag())==-1){// indexOf fügvény ha már benne van a listában visszatér a helyével
                            //ha nincs akkor -1 et ad vissza, tehát ha az érték -1 nincs a listában ezért beletesszük
                orszagok.add(d.getOrszag());
            }
        }
        int db=0;// db változó az adott országhoz tartozó versenyzők megszámlálására
        for(String orszag:orszagok){// egyesével végigmegyünk az országokon
            for(Data d:lista){// az összes versenyző listája
                if(d.getOrszag().equals(orszag)){// ha a versenyző az adott országból származik akkor növeljük db-t
                    db++;
                }
            }
            if(db>4){ // feladatmegadás: ha 4 nél több versenyző van írjuk ki
                System.out.println("\t"+orszag+" "+db+" fő");
            }
            db=0;//nullázuk a db-t hogy a következő ország számlálásánál 0 tól kezdjük
        }
    }//main
    
}//class
