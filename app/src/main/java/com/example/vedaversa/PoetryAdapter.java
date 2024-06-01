package com.example.vedaversa;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PoetryAdapter extends RecyclerView.Adapter<PoetryAdapter.viewHolder> {
    Context context;
    List<poetryModel> poetryModelList;

    public PoetryAdapter(MainActivity context, List<poetryModel> poetryModelList) {
        this.context = context;
        this.poetryModelList = poetryModelList;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         View view =  LayoutInflater.from(context).inflate(R.layout.view , parent , false);
          return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
          holder.poetry.setText(poetryModelList.get(position).getPoetry_data());
          holder.poetname.setText(poetryModelList.get(position).getPoet_name());
          holder.datetime.setText(poetryModelList.get(position).getDate_time());
    }

    @Override
    public int getItemCount() {
        return poetryModelList.size();
    }

    public  class viewHolder extends RecyclerView.ViewHolder{
        TextView poetry , poetname , datetime;
        Button updbtn ,delbtn;
        public viewHolder(@NonNull View itemView) {
            super(itemView);

            poetry = itemView.findViewById(R.id.poetData_text);
            poetname = itemView.findViewById(R.id.poetname_text);
            datetime = itemView.findViewById(R.id.datetime_text);
            updbtn = itemView.findViewById(R.id.updatebtn);
            delbtn =itemView.findViewById(R.id.deletbtn);
        }
    }
}
