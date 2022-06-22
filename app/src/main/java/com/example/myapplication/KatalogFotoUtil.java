package com.example.myapplication;

import java.util.ArrayList;
import java.util.List;

public class KatalogFotoUtil {
    private static int[] ridArray = {
            R.drawable.satu,
            R.drawable.satu,
    };

    private  static String[] filenameArray ={
            "satu",
            "dua"
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
