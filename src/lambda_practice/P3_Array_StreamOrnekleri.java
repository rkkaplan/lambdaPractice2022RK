package lambda_practice;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class P3_Array_StreamOrnekleri {
    public static void main(String[] args) {
        // Arraylerde Stream kullanabilmek icin 2 yol vardir
        // 1) Stream <Integer> isim=Stream.Of(cevrilecek olan) -> Stream objesi
        // 2) Arrays.stream(arr).  ->  Array sinifindan yararlanarak
        //Array ler collection sinifinda degillerdir..set ve Map ler gibi degildir..
        // kullanabilmek icin donusum yapilmalidir

        Integer arr1 [] ={1,5,-5,6,12,-8,9,3,4};
        int [] arr2 = {1,5,-5,6,12,-8,9,3,4};

        System.out.println("arrElementleriYaz(arr1) = " + arrElementleriYaz(arr1));
        System.out.println("\n*****************");
        System.out.println("arrleriTopla(arr1) = " + arrleriTopla(arr1));
        System.out.println("\n*****************");
        arrlerinOrtYaz(arr2);
        System.out.println("\n*****************");


    }//main method
    //S1: arrayin elemanlarini bir liste yazdiralim
    public static List<Integer> arrElementleriYaz(Integer [] arr1){
        return Arrays.stream(arr1).collect(Collectors.toList());

    }
    //S2: Arrayin elemanlarini toplamini bulalim
public static Optional<Integer> arrleriTopla(Integer []arr1){
        return Arrays.stream(arr1).reduce(Integer::sum);
}
    // S3: Array in elemanlarinin ortalamasini bulalim yazdir
    public static void arrlerinOrtYaz(int []arr2){
         Arrays.stream(arr2).average().ifPresent(t-> System.out.println(t));
    }


}
