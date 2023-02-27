package com.ksfsp.firststudyprojectecommerce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

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
}