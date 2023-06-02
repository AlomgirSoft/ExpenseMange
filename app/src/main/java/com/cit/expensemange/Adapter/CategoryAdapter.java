package com.cit.expensemange.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.cit.expensemange.Model.SimpleCategoryModel;
import com.cit.expensemange.R;
import com.cit.expensemange.databinding.SimpleCatagoryItemBinding;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    private Context context;
    private List<SimpleCategoryModel>simpleCategoryModelList;

    public CategoryAdapter(Context context, List<SimpleCategoryModel> simpleCategoryModelList) {
        this.context = context;
        this.simpleCategoryModelList = simpleCategoryModelList;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CategoryViewHolder(LayoutInflater.from(context).inflate(R.layout.simple_catagory_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {

        SimpleCategoryModel simpleCategoryModel =simpleCategoryModelList.get(position);
        holder.binding.simpleCatagoryBiTv.setText(simpleCategoryModel.getCategoryName());

        holder.binding.imageView.setImageResource(simpleCategoryModel.getCategoryImage());
       // Glide.with(context).load(simpleCategoryModel.getCategoryImage()).into(holder.binding.imageView);

    }

    @Override
    public int getItemCount() {
        return simpleCategoryModelList.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {

      SimpleCatagoryItemBinding binding;
        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            binding=SimpleCatagoryItemBinding.bind(itemView);

        }
    }
}
