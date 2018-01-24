package com.example.yashpandya.practice;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Yash Pandya on 1/2/2018.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.Viewholder>{
    private Context context;
    private List<Listitem> listitems;
    private OnItemClickListener mListener;

    //method for getting data inside
    public interface OnItemClickListener {
        void onItemClick(View v, int position);
    }
    //method for setup onclick on items
    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    //constructor
    public Adapter(Context context, List<Listitem> listitems) {
        this.context = context;
        this.listitems = listitems;
    }

    //create view for single row
    @Override
    public Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.listitem,null);
        return new Viewholder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    //bind data to each single view
    public void onBindViewHolder(Viewholder holder, int position) {
        Listitem bindlist=listitems.get(position);
        holder.title.setText(bindlist.getName());
        holder.desc.setText(bindlist.getTeam());
        holder.rating.setText(String.valueOf(bindlist.getPublisher()));
        Picasso.with(context).load(bindlist.getImage()).into(holder.imageView);
//   Glide.with(context)
//             .load(bindlist.getImage())
//                .into(holder.imageView) ;
        //holder.imageView.setImageDrawable(context.getResources().getDrawable(bindlist.getImage()));
    }

    //get item count by item size
    @Override
    public int getItemCount() {
        return listitems.size();
    }

    class Viewholder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView title, desc, rating, bio;

        public Viewholder(final View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.textViewTitle);
            desc = (TextView) itemView.findViewById(R.id.textViewShortDesc);
            rating = (TextView) itemView.findViewById(R.id.textViewRating);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
        }

    }
}

