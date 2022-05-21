package lambda_practice;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class C6_Lambdada_ForLoop_Aralik_Kontrolu {

    public static void main(String[] args) {

        sayi1den30asirala(30);
        System.out.println("\n************");
        sayi1den30asiralaDahil(30);
        System.out.println("\n************");
        System.out.println("araliginToplami(3,7) = " + araliginToplami(3, 7));
        System.out.println("\n************");
        System.out.println("araliginOrtalamasi(20,30) = " + araliginOrtalamasi(20, 30));
        System.out.println("\n************");
        System.out.println("sayisi8eBolunen(325,468) = " + sayisi8eBolunen(325, 468));
        System.out.println("\n************");
        sayilardan8eBolunenleriYaz(325,468);
        System.out.println("\n************");
        System.out.println("sayilardan8eBolunenleriTopla(325,468) = " + sayilardan8eBolunenleriTopla(325, 468));
        System.out.println("\n************");
        System.out.println("aradakiSayilariCarp(7,15) = " + aradakiSayilariCarp(7, 15));
        System.out.println("\n************");
        pozTeklerinIlk10Yaz(100 );
        System.out.println("\n************");
        tekler7ninkatlari21denilk10();



    }

    // S1:1 den 30 kadar olan sayilari (30 dahil degil) 1 2 3 .... seklinde siralayalim (for loopsuz)
    //range(int startInclusive, int endExclusive)
    public static void sayi1den30asirala(int a){
        IntStream.range(1,a).forEach(t-> System.out.print(t+" "));
    }


    //S2 1 den 30 kadar olan sayilari (30 dahil ) 1 2 3 .... seklinde siralayalim (for loopsuz)
    //rangeClosed(int startInclusive, int endInclusive)

    public static void sayi1den30asiralaDahil(int a){
        IntStream.rangeClosed(1,a).forEach(t-> System.out.print(t+" "));
    }


    //S3 Istenen iki deger(dahil) arasindaki sayilari toplayalim
    public static int araliginToplami(int start, int finish){
        return IntStream.rangeClosed(start,finish).sum();
    }


    //S4: 30 ile 40 arasindaki sayilarin (dahi) ortalamasini bulalim
    public static OptionalDouble araliginOrtalamasi(int start, int finish){
        return IntStream.rangeClosed(start,finish).average();
    }


    //S5: 325 ile 468 arasinda 8 e bolunen kac sayi vardir?
    public static long sayisi8eBolunen(int basl, int son){
        return IntStream.rangeClosed(basl, son).filter(t->t%8==0).count();
    }


    //S6: 325 ile 468 arasinda 8 e bolunen sayilari yazdiralim
    public static void sayilardan8eBolunenleriYaz(int basl, int son){
         IntStream.rangeClosed(basl, son).filter(t->t%8==0).forEach(Methods::yazInteger);
    }


    // S7:325 ile 468 arasinda 8 e bolunen sayilarin toplamini bulalim
    public static int sayilardan8eBolunenleriTopla(int basl, int son){
        return IntStream.rangeClosed(basl, son).filter(t->t%8==0).sum();
    }


    // S8: 7ile 15 arasindaki tek sayilarin carpimini bulalim
    public static OptionalInt aradakiSayilariCarp(int basl, int son){
        return IntStream.rangeClosed(basl, son).filter(Methods::tekMi).reduce(Math::multiplyExact);
    }


    //S9: pozitif tek sayilarin ilk 10 elemanin yazdiralim
    public static void pozTeklerinIlk10Yaz(int a){
       // IntStream.rangeClosed(1,a).filter(Methods::tekMi).filter(Methods::pozitifMi).limit(10).forEach(Methods::yazInteger);
       IntStream.iterate(1, t->t+2).limit(10).forEach(Methods::yazInteger);
    }


    //S10: 21 den baslayan 7 nin katlarinin tek olanlari ilk 10 teriminin yaziralim
    public static void tekler7ninkatlari21denilk10(){
        IntStream.iterate(21,t->t+7).filter(Methods::tekMi).limit(10).forEach(Methods::yazInteger);
    }



    //S11: 21 den baslayan 7 nin katlarinin ilk 20 teriminin toplayalim

}
//iterate bize sayilari istedigimiz sekilde yineletmeyi saglar yani buradaki ornekte 7ser7ser artmayi saglar
//iterate icin bir baslangic degeri girilmeli ve artisin nasil olacagi belirtilmeli nerede biteceginide
// limit() ile belirliyoruz