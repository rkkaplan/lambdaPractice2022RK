package lambda_practice;

// lambda da method kullanimi :
//ilk olarak class adi yazilir
//sonra  :: noktalar konur
//son olarak method secilir
//String class i sayesinde length gibi toUpperCase gibi methodlari kullanabiliriz
//Math classi sayesinde de sum vb methodlar kullanabiliriz

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class C4_Method_Refarance_Int {
    public static void main(String[] args) {
        List<Integer> intL= Arrays.asList(-2,-8,-5,0,2,5,6,7,15,6,8);

        tekleriBoslukluYaz(intL);
        System.out.println("\n********");
        System.out.println("ciftlerinCarpimiBul(intL) = " + ciftlerinCarpimiBul(intL));
        System.out.println("\n********");
        System.out.println("negatiflerinKareToplamminiBul(intL) = " + negatiflerinKareToplamminiBul(intL));
        System.out.println("\n********");
        pozKuplerininMaxiYazdir(intL);
        System.out.println("\n********");
        System.out.println("\n********");
        System.out.println("\n********");
        System.out.println("\n********");


    }
    // S1: tekleri aralarinda bir bosluk birakarak yazdiralim
    public static void tekleriBoslukluYaz(List<Integer>intL){
        intL.stream().filter(Methods::tekMi).forEach(Methods::yazInteger);
                    //filter(t->t%2 != 0)   //forEach(t-> System.out.print(t+" "))
    }


    // S2: ciftlerin carpimini bulalim
    public static Optional<Integer> ciftlerinCarpimiBul(List<Integer>intL){
        return intL.stream().filter(Methods::ciftMi).reduce(Math::multiplyExact);
    }


    // S3: negatiflerin kare toplamlarini  bulalim
    public static Optional<Integer> negatiflerinKareToplamminiBul(List<Integer>intL){
        return intL.stream().filter(Methods::negatifMi).map(Methods::kareBul).reduce(Methods::toplam);
    }


    // S4: poziflerin kuplerinden max olani yazdiralim
    public static void pozKuplerininMaxiYazdir(List<Integer>intL){
        System.out.println(intL.stream().filter(Methods::pozitifMi).map(Methods::kupBul).reduce(Math::max));
    }



}
