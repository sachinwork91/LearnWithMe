package com.example.sachin.learnwithme.data;

import com.example.sachin.learnwithme.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sachin on 3/26/2018.
 */

public class DataService {


    static List<CategoryData> catData;

    public static List<CategoryData> getData(){

        catData = new ArrayList<CategoryData>();
        catData.add(new CategoryData("Algorithms", "Algorithms", "Algorithms", R.drawable.algo ));
        catData.add(new CategoryData("Data Structures", "Data Structures", "Data Structures", R.drawable.datastructure ));
        catData.add(new CategoryData("Java", "Programming Language", "Programming", R.drawable.java ));
        catData.add(new CategoryData("Python", "Python", "Python", R.drawable.python ));
        catData.add(new CategoryData("Algorithms", "Algorithms", "Algorithms", R.drawable.algo ));
        catData.add(new CategoryData("Data Structures", "Data Structures", "Data Structures", R.drawable.datastructure ));
        catData.add(new CategoryData("Java", "Programming Language", "Programming", R.drawable.java ));
        catData.add(new CategoryData("Python", "Python", "Python", R.drawable.python ));
        return catData;
    }

}
