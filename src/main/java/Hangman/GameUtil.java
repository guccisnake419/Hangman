package Hangman;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GameUtil {
    static String animals[]= {"Elephant", "Buffalo", "Rhinoceros", "Giraffe", "Dragonfly"};
    static String brands[]= {"Microsoft", "Adidas", "Lamborghini"};



    public static HashMap<String, String[]> map= new HashMap<>();

    public static void  run(){
        map.put("Animals", animals);
        map.put("Brands", brands);
    }

}
