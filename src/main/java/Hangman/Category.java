package Hangman;

import java.util.ArrayList;
import java.util.Stack;

public class Category implements Categories {

    String category;
    Stack<String> list;



    Category(String category){
        this.category= category;
        list = new Stack<>();
    }
    Category(String category,ArrayList<String> list ){
        this.category= category;
        this.populateCategory(list);
    }
    @Override
    public void populateCategory(ArrayList<String> list) {
        for (var a : list
             ) {
            this.list.push(a);
        }
    }
}
