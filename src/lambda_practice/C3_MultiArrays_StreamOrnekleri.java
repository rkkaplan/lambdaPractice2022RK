package lambda_practice;
//multi arrayleri cevirirken flapMap kullaniriz yapilis sekli iki turludur
//1) lambda kullanarak
// Arrays.stream(arr).flatMap(t->Arrays.stream(t))
//2) method ile
// Arrays.stream(arr).flatMap(Arrays::stream)
// BU SEKLIDE ARTIK TUM STREAM METHODLARI KULLANILABILIR

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class C3_MultiArrays_StreamOrnekleri {
    public static void main(String[] args) {
        String arr[][] = {
                {"Elma", "Muz"},
                {"Portakal", "Cilek", "Limon"},
                {"Havuc","Erik"}
        };

        System.out.println("tumElemanlariList(arr) = " + tumElemanlariList(arr));
        System.out.println("\n****************");
        doubleYazElileri(arr);
        System.out.println("\n****************");
        System.out.println("listOlarakYazElileri(arr) = " + listOlarakYazElileri(arr));
        System.out.println("\n****************");
        ekleYildizKbitenSonuna(arr);
        System.out.println("\n****************");
        System.out.println("\n****************");
        System.out.println("\n****************");


    }//main method
    // S1 : tum elemanlari list yapalim
    public static List<String>tumElemanlariList(String arr [][]) {
        return Arrays.stream(arr).flatMap(Arrays::stream).collect(Collectors.toList());
                                //flatMap(t->Arrays.stream(t))
    }




    // S2: E ile baslayan elemanlari double (elmaelma) olarak yazdiralim

    public static void doubleYazElileri(String arr [][]){
        Arrays.stream(arr).
                flatMap(Arrays::stream).
                filter(t->t.toUpperCase().startsWith("E")).
                map(t->t+t).forEach(t-> System.out.println(t));

    }



    // S3: E ile baslayan elemanlari liste olarak yazdiralim
    public static List<String> listOlarakYazElileri(String arr [][]){
        return Arrays.stream(arr).
                flatMap(Arrays::stream).
                filter(t -> t.toUpperCase().startsWith("E")).
                collect(Collectors.toList());

    }



    //S4 : k ile bitenlerin sonuna '*' ekleyelim

    public static void ekleYildizKbitenSonuna(String arr [][]){
        Arrays.stream(arr).
                flatMap(Arrays::stream).
                filter(t->t.toLowerCase().endsWith("k")).
                map(t->t+"*").forEach(t-> System.out.println(t));


}
}
