package com.ksfsp.firststudyprojectecommerce.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.ksfsp.firststudyprojectecommerce.CoursePage;
import com.ksfsp.firststudyprojectecommerce.R;
import com.ksfsp.firststudyprojectecommerce.model.Goods;

import java.util.List;

public class GoodsAdapter extends RecyclerView.Adapter<GoodsAdapter.GoodsViewHolder> {

    Context context;
    List<Goods> goodsList;

    public GoodsAdapter(Context context, List<Goods> goodsList) {
        this.context = context;
        this.goodsList = goodsList;
    }

    @NonNull
    @Override
    public GoodsAdapter.GoodsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { // в этом меттоде мы указываем какой именно дизайн мы будем использовать для отображения всех элемнтов этого виджета (дизайн - goods_item)
        View goodsItems = LayoutInflater.from(context).inflate(R.layout.goods_item, parent, false);
        return new GoodsAdapter.GoodsViewHolder(goodsItems);
    }

    @Override
    public void onBindViewHolder(@NonNull GoodsAdapter.GoodsViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.courseBg.setCardBackgroundColor(Color.parseColor(goodsList.get(position).getColor()));
        @SuppressLint("DiscouragedApi") int imgId = context.getResources().getIdentifier(goodsList.get(position).getImg(),"drawable", context.getPackageName());
        holder.courseImg.setImageResource(imgId);
        holder.courseTitle.setText(goodsList.get(position).getTitle());
        holder.courseDate.setText(goodsList.get(position).getDate());
        holder.courseLevel.setText(goodsList.get(position).getLevel());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, CoursePage.class);

                intent.putExtra("courseBg", Color.parseColor(goodsList.get(position).getColor()));
                intent.putExtra("courseImage", imgId);
                intent.putExtra("courseTitle", goodsList.get(position).getTitle());
                intent.putExtra("courseDate", goodsList.get(position).getDate());
                intent.putExtra("courseLevel", goodsList.get(position).getLevel());
                intent.putExtra("courseText", goodsList.get(position).getText());
                intent.putExtra("courseId", goodsList.get(position).getId());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return goodsList.size();
    }

    public static final class GoodsViewHolder extends RecyclerView.ViewHolder{

        CardView courseBg;
        ImageView courseImg;
        TextView courseTitle, courseDate, courseLevel;

        public GoodsViewHolder(@NonNull View itemView) {
            super(itemView);

            courseBg = itemView.findViewById(R.id.courseBg); //инициализируем поля их представлением из дизайна
            courseImg = itemView.findViewById(R.id.goodsImage);
            courseTitle = itemView.findViewById(R.id.goodsTitle);
            courseDate = itemView.findViewById(R.id.courseDate);
            courseLevel = itemView.findViewById(R.id.courseLevel);

        }
    }

}
