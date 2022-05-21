package lambda_practice;

import java.util.*;
import java.util.stream.Collectors;

public class P1_IntList_StreamOrnekleri {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(-5, -8, -2, -12, 0, 1, 12, 5, 6, 9, 15, 8));
        hepsiniYaz(list);
        System.out.println("\n*****************");
        negatifleriYaz(list);
        System.out.println("\n*****************");
        System.out.println("pozitifleriListYap(list) = " + pozitifleriListYap(list));
        System.out.println("\n*****************");
        System.out.println("kareleriListYap(list) = " + kareleriListYap(list));
        System.out.println("\n*****************");
        System.out.println("kareleriTekrarsizListYap(list) = " + kareleriTekrarsizListYap(list));
        System.out.println("\n*****************");
        elemanariKckBykSirala(list);
        System.out.println("\n*****************");
        elemanariBykKckSirala(list);
        System.out.println("\n*****************");
        poziiflerinKupleriniList(list);
        System.out.println("\n*****************");
        poziiflerinKareleriniList(list);
        System.out.println("\n*****************");
        System.out.println("elemanlarinToplaminiYaz(list) = " + elemanlarinToplaminiYaz(list));
        System.out.println("\n*****************");
        System.out.println("negatiflerinKareleriniList(list) = " + negatiflerinKareleriniList(list));
        System.out.println("\n*****************");
        System.out.println("varMi5tenBuyuk(list) = " + varMi5tenBuyuk(list));
        System.out.println("\n*****************");
        System.out.println("hepsi0dankucukmu(list) = " + hepsi0dankucukmu(list));
        System.out.println("\n*****************");
        System.out.println("Hic100eEsitYokMu(list) = " + Hic100eEsitYokMu(list));
        System.out.println("\n*****************");
        System.out.println("Hic0eEsitYokMu(list) = " + Hic0eEsitYokMu(list));
        System.out.println("\n*****************");
        System.out.println("toplaIlk5Elemani(list) = " + toplaIlk5Elemani(list));
        System.out.println("\n*****************");
        System.out.println("listeleSon5Elemani(list) = " + listeleSon5Elemani(list));
        System.out.println("\n*****************");



    }//main method

    // S1:listeyi aralarinda bosluk birakarak yazdiriniz //
    public static void hepsiniYaz(List<Integer> list) {
        list.stream().forEach(t -> System.out.print(t + " "));
    }

    //S2: sadece negatif olanlari yazdir
    public static void negatifleriYaz(List<Integer>list){
        list.stream().filter(t->t<0).forEach(t-> System.out.print(t+ " "));
    }
    //S3: pozitif olanlardan yeni bir liste olustur
    public static List<Integer> pozitifleriListYap(List<Integer>list){
       return list.stream().filter(t -> t > 0).collect(Collectors.toList());

    }
    // S4: list in elemanlarin karelerinden yeni bir list olusturalim
    public static List<Integer> kareleriListYap(List<Integer>list){
        return list.stream().map(t -> t*t ).collect(Collectors.toList());

    }
    //S5 : list in elemanlarin karelerinden tekrarsiz yeni bir list olusturalim
    public static List<Integer> kareleriTekrarsizListYap(List<Integer>list){
        return list.stream().map(t -> t*t ).distinct().collect(Collectors.toList());

    }
    //S6: listin elemanlarini kucukten buyuge siralayalim
    public static void elemanariKckBykSirala(List<Integer>list){
         list.stream().sorted().forEach(t-> System.out.print(t+ " "));

    }
    //S7: listin elemanlarini buyukten kucuge siralayalim
    public static void elemanariBykKckSirala(List<Integer>list){
        list.stream().sorted(Comparator.reverseOrder()).forEach(t-> System.out.print(t+ " "));

    }
    // S8: list pozitif elemanlari icn kuplerini bulup birler basamagi 5 olanlardan yeni bir list olusturalim
    public static void poziiflerinKupleriniList(List<Integer>list){
        System.out.println(list.stream().filter(t->t>0).map(t -> t * t * t).filter(t -> t % 10 == 5).collect(Collectors.toList()));

    }
    //S9: list pozitif elemanlari icn karelerini bulup birler basamagi 5 olmayanlardan yeni bir list olusturalim
    public static void poziiflerinKareleriniList(List<Integer>list){
        System.out.println(list.stream().filter(t->t>0).map(t -> t * t ).filter(t -> t % 10 != 5).collect(Collectors.toList()));

    }
    // S10 :list elemanlarini toplamini bulalim
    public static int elemanlarinToplaminiYaz(List<Integer>list){
     return list.stream().reduce(0,(x,y)->x+y);

    }
    // S11 : peek ornegi cozelim - negatiflerin karelerinden list olusturalim
    public static List<Integer> negatiflerinKareleriniList(List<Integer>list){
          return list.stream().
                  filter(t->t<0).
                  peek(t-> System.out.print("negatifler: " + t+ " ")).
                  map(t -> t * t ).
                  peek(t-> System.out.println("Kareleri: " + t)).
                  collect(Collectors.toList());
    }
    // S12 : listeden 5 den buyuk  sayi var mi?
    public static boolean varMi5tenBuyuk(List<Integer>list){
        return list.stream().anyMatch(t -> t > 5);
    }
    // S13 : listenin tum elemanlari sifirdan kucuk mu?
    public static boolean hepsi0dankucukmu(List<Integer>list){
        return list.stream().allMatch(t -> t < 10);
    }
    // S14: listenin 100 e esit elemani yok mu ?
    public static boolean Hic100eEsitYokMu(List<Integer>list){
        return list.stream().noneMatch(t -> t == 100);
    }
    // S15: listenin sifira esit elemani yok mu?
    public static boolean Hic0eEsitYokMu(List<Integer>list){
        return list.stream().noneMatch(t -> t == 0);
    }
    // S16:  listenin ilk 5 elemanini topla?
    public static Optional<Integer> toplaIlk5Elemani(List<Integer>list){
        return list.stream().limit(5).reduce(Integer::sum);
    }
    //S17: listenin son bes elemaninin  listele
    public static List<Integer> listeleSon5Elemani(List<Integer>list){
        long n = list.size() - 5; //son bes demek ,8 elemanli bir listem var son 5 icin, 5 cikardigimda 3 unu atlayip son besi yazdiracak

        return list.stream().skip(n).collect(Collectors.toList());
    }
















}
