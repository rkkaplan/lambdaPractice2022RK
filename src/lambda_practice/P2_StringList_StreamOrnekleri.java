package lambda_practice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class P2_StringList_StreamOrnekleri {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();

        list.add("Java");
        list.add("ogrenmek");
        list.add("cok");
        list.add("eglencelidi");
        list.add("lambda");
        list.add("gelince");
        list.add("Daha");
        list.add("da");
        list.add("Cok");
        list.add("Eglenceli");
        list.add("Oldu");


        System.out.println("dVeyaCleriListele(list) = " + dVeyaCleriListele(list));
        System.out.println("\n********************");
        System.out.println("yildizEkleyerekYazdir(list) = " + yildizEkleyerekYazdir(list));
        System.out.println("\n********************");
        System.out.println("alfabetikSirala(list) = " + alfabetikSirala(list));
        System.out.println("\n********************");
        tumLleriSil(list);
        System.out.println("\n********************");
        System.out.println("tumElilerdenListYap(list) = " + tumElilerdenListYap(list));
        System.out.println("\n********************");
        ilk3HarfiniTekrarlayarakYaz(list);
        System.out.println("\n********************");
        ilkHarfBuyukGerisiKucuk(list);
        System.out.println("\n********************");
        System.out.println("uz4ve6HaricListeOlus(list) = " + uz4ve6HaricListeOlus(list));
        System.out.println("\n********************");
        System.out.println("\n********************");

    }//main method
    // S1: ilk harfi d ve ya c olanlari listeleyelim
public static List<String> dVeyaCleriListele(List<String> list){
    return list.stream().filter(t -> t.startsWith("d") || t.startsWith("c")).collect(Collectors.toList());
}
    //S2: tum stringlerin basina ve sonuna yildiz ekleyerek yazdiralim
    public static List<String> yildizEkleyerekYazdir(List<String> list){
        return list.stream().map(t -> "*" + t +"*").collect(Collectors.toList());
    }
    //S3: alfabetik  olarak siralayalim list olarak
    public static List<String> alfabetikSirala(List<String> list){
        return list.stream().sorted().collect(Collectors.toList());
    }
    //S4: tum 'l' leri silelim yazdiralim
public static void tumLleriSil(List<String> list){
    System.out.println(list.stream().map(t -> t.replaceAll("l", "")).collect(Collectors.toList()));
}
    //S5 : icinde e olanlardan yeni bir list olusturunuz
    public static List<String> tumElilerdenListYap(List<String> list){
        return list.stream().filter(t -> t.contains("e")).collect(Collectors.toList());
    }
    // S6 : ilk harfini 3 kere tekrar edip yazalim ornek jjjava gibi
    public static void ilk3HarfiniTekrarlayarakYaz(List<String> list){
        list.stream().map(t -> t.substring(0,1)+t.substring(0,1)+t).forEach(t-> System.out.print(t+ " "));

    }
    // S7: tum elemanlarin ilk harfini buyuk digerlerini kucuk yaziniz
public static void ilkHarfBuyukGerisiKucuk(List<String>list){
        list.stream().map(t->t.substring(0,1).toUpperCase()+t.substring(1).toLowerCase()).forEach(t-> System.out.print(t+ " "));
}
    // S8: uzunlugu 4 ve 6 olanlar haric bir liste olusturunuz
public static List<String> uz4ve6HaricListeOlus(List<String> list){
        return list.stream().filter(t->t.length()!=4 && t.length()!=6).collect(Collectors.toList());
}







}
