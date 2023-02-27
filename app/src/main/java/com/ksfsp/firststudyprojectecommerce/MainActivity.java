package com.ksfsp.firststudyprojectecommerce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.ksfsp.firststudyprojectecommerce.adapter.CategoryAdapter;
import com.ksfsp.firststudyprojectecommerce.adapter.GoodsAdapter;
import com.ksfsp.firststudyprojectecommerce.model.Category;
import com.ksfsp.firststudyprojectecommerce.model.Goods;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView categoryRecycler, goodsRecycler;
    CategoryAdapter categoryAdapter;
    static GoodsAdapter goodsAdapter;
    static List<Goods> courseList = new ArrayList<>(0);
    static final List<Goods> allCourseList = new ArrayList<>(0);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Category> categoryList = new ArrayList<>(0);
        categoryList.add(new Category(1, "Java"));
        categoryList.add(new Category(2, "Python"));
        categoryList.add(new Category(3, "All"));
        categoryList.add(new Category(4, "NoOne"));
        categoryList.add(new Category(5, "Sergey"));
        categoryList.add(new Category(6, "Duraley"));

        setCategoryRecycler(categoryList);

        allCourseList.add(new Goods(1, 1, "ic_java", "Java-Developer\nprofession", "17 June", "intermediate", "#424345", "Программа обучения Джава – рассчитана на новичков в данной сфере.\n\nЗа программу вы изучите построение графических приложений под ПК, разработку веб сайтов на основе Java  Spring Boot, изучите построение  полноценных Андроид приложений и отлично изучите сам язык Джава!"));
        allCourseList.add(new Goods(2, 2,"ic_python", "Python-Developer\nprofession", "29 July", "beginning", "#9FA52D", "Представляем вам уроки программирования Python для начинающих. Обучение с нуля для чайников. Большой видео курс по изучению языка Питон."));
        allCourseList.add(new Goods(3, 1, "ic_java", "Java-Developer\nprofession", "18 June", "intermediate", "#424345", "Программа обучения Джава – рассчитана на новичков в данной сфере.\nЗа программу вы изучите построение графических приложений под ПК, разработку веб сайтов на основе Java  Spring Boot, изучите построение  полноценных Андроид приложений и отлично изучите сам язык Джава!"));
        allCourseList.add(new Goods(4, 2,"ic_python", "Python-Developer\nprofession", "28 July", "beginning", "#9FA52D", "Представляем вам уроки программирования Python для начинающих.\nОбучение с нуля для чайников. Большой видео курс по изучению языка Питон."));
        allCourseList.add(new Goods(5, 1, "ic_java", "Java-Developer\nprofession", "19 June", "intermediate", "#424345", "Программа обучения Джава – рассчитана на новичков в данной сфере. За программу вы изучите построение графических приложений под ПК, разработку веб сайтов на основе Java  Spring Boot, изучите построение  полноценных Андроид приложений и отлично изучите сам язык Джава!"));
        allCourseList.add(new Goods(6, 2,"ic_python", "Python-Developer\nprofession", "27 July", "beginning", "#9FA52D", "Представляем вам уроки программирования Python для начинающих.\nОбучение с нуля для чайников.\nБольшой видео курс по изучению языка Питон."));

        courseList.addAll(allCourseList);
        setCourseRecycler(courseList);
    }

    private void setCourseRecycler(List<Goods> courseList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        goodsRecycler = findViewById(R.id.goodsRecycler);
        goodsRecycler.setLayoutManager(layoutManager);

        goodsAdapter = new GoodsAdapter(this, courseList);
        goodsRecycler.setAdapter(goodsAdapter);
    }

    private void setCategoryRecycler(List<Category> categoryList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        categoryRecycler = findViewById(R.id.category_recycler);
        categoryRecycler.setLayoutManager(layoutManager);

        categoryAdapter = new CategoryAdapter(this, categoryList);
        categoryRecycler.setAdapter(categoryAdapter);
    }
    @SuppressLint("NotifyDataSetChanged")
    public static void showCoursesByCategory(int categoryId) {
        List<Goods> filterCourses = new ArrayList<>();
        for(Goods g : allCourseList){
            if(g.getCategory() == categoryId || categoryId == 3){
                filterCourses.add(g);
            }
            courseList.clear();
            courseList.addAll(filterCourses);
            goodsAdapter.notifyDataSetChanged();
        }
    }
    public void showCart(View view){
        Intent intent = new Intent(this, ShoppingCart.class);
        startActivity(intent);
    }
}