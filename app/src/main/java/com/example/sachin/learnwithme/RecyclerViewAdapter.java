package com.example.sachin.learnwithme;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sachin.learnwithme.data.Category;
import com.example.sachin.learnwithme.data.CategoryData;

import java.util.List;

/**
 * Created by sachin on 3/26/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {


    private Context mContext;
    private List<CategoryData> mData;


    RecyclerViewAdapter(Context context, List<CategoryData> data){
        mContext=context;
        mData=data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view= mInflater.inflate(R.layout.cardview_item_book , parent , false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.tv_category_title.setText(mData.get(position).getTitle());
        holder.img_book_thumbnail.setImageResource(mData.get(position).getThumbnail());


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_category_title ;
        ImageView img_book_thumbnail;

        public MyViewHolder(View itemView){
            super(itemView);


            tv_category_title= (TextView) itemView.findViewById(R.id.category_id_tvw);
            img_book_thumbnail= (ImageView) itemView.findViewById(R.id.category_id_ivw);
        }


    }




}
