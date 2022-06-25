package com.example.myapplication;

import java.util.ArrayList;
import java.util.List;

public class KatalogFotoUtil {
    private static int[] ridArray = {
            R.drawable.satu,
            R.drawable.dua,
            R.drawable.tiga,
            R.drawable.empat,
            R.drawable.lima,
            R.drawable.enam,
            R.drawable.tujuh,
            R.drawable.delapan,
            R.drawable.sembilan,
    };

    private  static String[] filenameArray ={
            "lofi satu",
            "lofi dua",
            "lofi tiga",
            "lofi empat",
            "lofi lima",
            "lofi enam",
            "lofi tujuh",
            "lofi delapan",
            "lofi sembilan",
    };

    private static List<KatalogFoto> katalogFotoList;

    public static void init(){
        katalogFotoList = new ArrayList<>();
        int nArray = ridArray.length;
        for(int i=0;i<nArray;i++){
            katalogFotoList.add(new KatalogFoto(ridArray[i], filenameArray[i]));
        }
    }
    public static List<KatalogFoto> getKatalogFotoList(){
        return katalogFotoList;
    }
    public static KatalogFoto getKatalogFotoAt(int i){
        return katalogFotoList.get(i);
    }
}
