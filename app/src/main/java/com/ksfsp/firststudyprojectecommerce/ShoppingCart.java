package com.ksfsp.firststudyprojectecommerce;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.ksfsp.firststudyprojectecommerce.model.Goods;
import com.ksfsp.firststudyprojectecommerce.model.Order;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);

        ListView ordersList = findViewById(R.id.order_list);
        List<String> courseTitles = new ArrayList<>();
        for(int id : Order.itemsId){
            String str = MainActivity.allCourseList.get(id-1).getTitle();
            str = "Id:"+id + " " + str;
            courseTitles.add(str);
        }

        ordersList.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, courseTitles));
    }
}