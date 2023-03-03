package com.ksfsp.firststudyprojectecommerce;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

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
    static List<Goods> allCourseList = new ArrayList<>(0);
    private ImageButton imageButton;
    private TextView aboutProgram;
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
        allCourseList.clear();

        allCourseList.add(new Goods(1, 1, "ic_java", "Java-Developer\nprofession", "17 June", "intermediate", "#424345", "Программа обучения Джава – рассчитана на новичков в данной сфере.\n\nЗа программу вы изучите построение графических приложений под ПК, разработку веб сайтов на основе Java  Spring Boot, изучите построение  полноценных Андроид приложений и отлично изучите сам язык Джава!"));
        allCourseList.add(new Goods(2, 2,"ic_python", "Python-Developer\nprofession", "29 July", "beginning", "#9FA52D", "Представляем вам уроки программирования Python для начинающих. Обучение с нуля для чайников. Большой видео курс по изучению языка Питон."));
        allCourseList.add(new Goods(3, 1, "ic_java", "Java-Developer\nprofession", "18 June", "intermediate", "#424345", "Программа обучения Джава – рассчитана на новичков в данной сфере.\nЗа программу вы изучите построение графических приложений под ПК, разработку веб сайтов на основе Java  Spring Boot, изучите построение  полноценных Андроид приложений и отлично изучите сам язык Джава!"));
        allCourseList.add(new Goods(4, 2,"ic_python", "Python-Developer\nprofession", "28 July", "beginning", "#9FA52D", "Представляем вам уроки программирования Python для начинающих.\nОбучение с нуля для чайников. Большой видео курс по изучению языка Питон."));
        allCourseList.add(new Goods(5, 1, "ic_java", "Java-Developer\nprofession", "19 June", "intermediate", "#424345", "Программа обучения Джава – рассчитана на новичков в данной сфере. За программу вы изучите построение графических приложений под ПК, разработку веб сайтов на основе Java  Spring Boot, изучите построение  полноценных Андроид приложений и отлично изучите сам язык Джава!"));
        allCourseList.add(new Goods(6, 2,"ic_python", "Python-Developer\nprofession", "27 July", "beginning", "#9FA52D", "Представляем вам уроки программирования Python для начинающих.\nОбучение с нуля для чайников.\nБольшой видео курс по изучению языка Питон."));

        courseList.clear();
        courseList.addAll(allCourseList);
        setCourseRecycler(courseList);

        imageButton = findViewById(R.id.cart_button);
        aboutProgram = findViewById(R.id.aboutUs);

        imageButton.setOnClickListener(new View.OnClickListener(){//для понимания альтернативной установки слушателя, кроме onClick свойства виджета
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, ShoppingCart.class);
                startActivity(intent);
            }
        } );
        aboutProgram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) { // инжектим меню в активити
        //return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) { // обрабатываем нажатые пункты меню по id (один не указан и обрабатывается методом из свойства onClick) (можно обрабатывать и так и так)
        // получим идентификатор выбранного пункта меню
        int id = item.getItemId();

        // Операции для выбранного пункта меню
        switch (id) {
            case R.id.action_first:
                Toast.makeText(MainActivity.this, "You enter first action", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_second:
                Toast.makeText(getApplicationContext(), "You enter second action", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_third:
                Toast.makeText(getApplicationContext(), "You enter third action", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void onSettingItemClick(@NonNull MenuItem item){ // обработка первого пункта меню
        Toast.makeText(getApplicationContext(), "You enter settings action", Toast.LENGTH_SHORT).show();
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

    public void memAction(View view){
        EditText editText = findViewById(R.id.editMeme);
        TextView textView = findViewById(R.id.memeText);
        textView.setText(editText.getText());
        Log.i("Meme", "appears");
    }

    public void onTestActivityClick(View view) {
        Intent intent = new Intent(MainActivity.this, Test.class);
        startActivity(intent);
    }
}