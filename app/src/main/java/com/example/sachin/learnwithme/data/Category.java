package com.example.sachin.learnwithme.data;

/**
 * Created by sachin on 3/26/2018.
 */

public class Category {

    private String categoryName;
    private String categoryImage;


    public Category(){
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryImage() {
        return categoryImage;
    }

    public void setCategoryImage(String categoryImage) {
        this.categoryImage = categoryImage;
    }

    @Override
    public String toString() {
        return this.getCategoryImage()+ " , "+ this.getCategoryName() ;
    }
}
