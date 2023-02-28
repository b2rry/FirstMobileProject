package com.ksfsp.firststudyprojectecommerce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ksfsp.firststudyprojectecommerce.model.Order;

public class CoursePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_page);

        ConstraintLayout courseBg = findViewById(R.id.coursePageBg);
        ImageView coursePageImage = findViewById(R.id.coursePageImg);
        TextView coursePageTitle = findViewById(R.id.courseNameTitle);
        TextView coursePageDate = findViewById(R.id.coursePageDate);
        TextView coursePageLevel = findViewById(R.id.coursePageLevel);
        TextView coursePageText = findViewById(R.id.coursePageText);

        courseBg.setBackgroundColor(getIntent().getIntExtra("courseBg", 0));
        coursePageImage.setImageResource(getIntent().getIntExtra("courseImage", 0));
        coursePageTitle.setText(getIntent().getStringExtra("courseTitle"));
        coursePageDate.setText(getIntent().getStringExtra("courseDate"));
        coursePageLevel.setText(getIntent().getStringExtra("courseLevel"));
        coursePageText.setText(getIntent().getStringExtra("courseText"));
    }
    public void addToCart(View view){
        int id = getIntent().getIntExtra("courseId", 0);
        if(Order.itemsId.add(id)) {
            Toast.makeText(getApplicationContext(), "Item successfully added!", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getApplicationContext(), "You added this item yet", Toast.LENGTH_SHORT).show();
        }
    }
    public void goHomePage(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}