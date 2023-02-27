package com.ksfsp.firststudyprojectecommerce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;

import com.ksfsp.firststudyprojectecommerce.adapter.CategoryAdapter;
import com.ksfsp.firststudyprojectecommerce.adapter.GoodsAdapter;
import com.ksfsp.firststudyprojectecommerce.model.Category;
import com.ksfsp.firststudyprojectecommerce.model.Goods;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView categoryRecycler, goodsRecycler;
    CategoryAdapter categoryAdapter;
    GoodsAdapter goodsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Category> categoryList = new ArrayList<>(0);
        categoryList.add(new Category(1, "Games"));
        categoryList.add(new Category(2, "Sites"));
        categoryList.add(new Category(3, "Langs"));
        categoryList.add(new Category(4, "Other"));
        categoryList.add(new Category(5, "Sergey"));
        categoryList.add(new Category(6, "Duraley"));

        setCategoryRecycler(categoryList);

        List<Goods> courseList = new ArrayList<>(0);
        courseList.add(new Goods(1, "ic_java", "Java-Developer\nprofession", "17 June", "intermediate", "#424345", "Программа обучения Джава – рассчитана на новичков в данной сфере.\n\nЗа программу вы изучите построение графических приложений под ПК, разработку веб сайтов на основе Java  Spring Boot, изучите построение  полноценных Андроид приложений и отлично изучите сам язык Джава!"));
        courseList.add(new Goods(2, "ic_python", "Python-Developer\nprofession", "29 July", "beginning", "#9FA52D", "Представляем вам уроки программирования Python для начинающих. Обучение с нуля для чайников. Большой видео курс по изучению языка Питон."));

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
}
//Видео 32ая мин