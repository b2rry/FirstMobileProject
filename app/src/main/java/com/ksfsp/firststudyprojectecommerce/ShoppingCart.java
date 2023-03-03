package com.ksfsp.firststudyprojectecommerce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.ksfsp.firststudyprojectecommerce.dialog.MyDialogFragment;
import com.ksfsp.firststudyprojectecommerce.model.Goods;
import com.ksfsp.firststudyprojectecommerce.model.Order;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);

        fillCart();

    }

    private void fillCart(){
        ListView ordersList = findViewById(R.id.order_list);
        List<String> courseTitles = new ArrayList<>();
        for(int id : Order.itemsId){
            String str = MainActivity.allCourseList.get(id-1).getTitle();
            str = "Id:"+id + " " + str;
            courseTitles.add(str);
        }

        ordersList.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, courseTitles));
    }
    public void goHomePage(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void cleanCart(View view) {
        MyDialogFragment myDialogFragment = new MyDialogFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        myDialogFragment.show(fragmentTransaction, "deleteConfirm");
        fillCart();
    }
}