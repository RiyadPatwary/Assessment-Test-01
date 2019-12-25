package com.riyad_patwary.assessmenttest_01;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.riyad_patwary.util.Product;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder>{
    List<Product> productList;

    public ProductAdapter(List<Product> productList) {
        this.productList = productList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_recycler_layout,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.productId_TextView.setText(""+productList.get(position).getProduct_id());
        holder.productName_TextView.setText(""+productList.get(position).getProduct_Name());
        holder.productCategory_TextView.setText(""+productList.get(position).getProduct_Category());
        holder.productDescription_TextView.setText(""+productList.get(position).getProduct_Description());
        holder.productPrice_TextView.setText(""+productList.get(position).getProduct_Price());
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView productId_TextView, productName_TextView, productCategory_TextView, productDescription_TextView, productPrice_TextView ;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            productId_TextView=itemView.findViewById(R.id.item_product_id);
            productName_TextView=itemView.findViewById(R.id.item_product_name_id);
            productCategory_TextView=itemView.findViewById(R.id.item_product_category_id);
            productDescription_TextView=itemView.findViewById(R.id.item_product_description_id);
            productPrice_TextView=itemView.findViewById(R.id.item_product_price_id);
        }
    }
}
