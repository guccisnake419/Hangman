package Hangman;

import java.lang.reflect.Array;
import java.util.*;

public class Category implements Categories {

    public String category;
    public Stack<String> list;



    public Category(String category){
        this.category= category;
        list = new Stack<>();
    }
    public Category(String category,List<String> list ){

        this.category= category;
        this.list = new Stack<>();
        this.populateCategory(list);
    }
    public Category(String category, String list[]){
        this.category= category;
        this.list = new Stack<>();
        this.populateCategory(list);
    }
    @Override
    public void populateCategory(ArrayList<String> list) {
        for (var a : list
             ) {
            this.list.push(a);
        }
    }
    public void populateCategory(List<String> list) {
        for (var a : list
        ) {
            this.list.push(a);
        }
    }
    public void populateCategory(String[] list) {
        for (var a : list
        ) {
            this.list.push(a);
        }
    }
}
