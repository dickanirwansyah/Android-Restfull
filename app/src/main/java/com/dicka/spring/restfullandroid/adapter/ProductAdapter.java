package com.dicka.spring.restfullandroid.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.dicka.spring.restfullandroid.R;
import com.dicka.spring.restfullandroid.entities.Product;

import java.util.List;

/**
 * Created by java-spring on 01/12/17.
 */

public class ProductAdapter extends ArrayAdapter<Product>{

    private List<Product> products;
    private Context context;


    public ProductAdapter(List<Product> products, Context context){
        super(context, R.layout.product_layout, products);
        this.products = products;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.product_layout, parent, false);
        Product product = this.products.get(position);
        /*
        TextView textViewByNama = (TextView) view.findViewById(R.id.textViewNama);
        textViewByNama.setText(product.getNama());
        TextView textViewByJumlah = (TextView) view.findViewById(R.id.textViewJumlah);
        textViewByJumlah.setText(product.getJumlah());
        */
        TextView textViewNama = (TextView) view.findViewById(R.id.textViewNama);
        TextView textViewJumlah = (TextView) view.findViewById(R.id.textViewJumlah);
        TextView textViewPrice = (TextView) view.findViewById(R.id.textViewPrice);
        textViewNama.setText(String.valueOf(product.getNama()));
        textViewPrice.setText(String.valueOf(product.getPrice()));
        textViewJumlah.setText(String.valueOf(product.getJumlah()));
        return view;

    }


}
