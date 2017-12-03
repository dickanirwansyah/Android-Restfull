package com.dicka.spring.restfullandroid;

import android.app.AlertDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.dicka.spring.restfullandroid.adapter.ProductAdapter;
import com.dicka.spring.restfullandroid.entities.Product;
import com.dicka.spring.restfullandroid.services.ProductServices;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        try{
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            List<Product> products = new HttpRequestProductList().execute().get();
            ListView listViewProducts = (ListView) findViewById(R.id.listViewProducts);
            listViewProducts.setAdapter(new ProductAdapter(products, getApplicationContext()));
        }catch (Exception e){
            AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
            builder.setMessage(e.getMessage());
            builder.create().show();
            e.printStackTrace();
        }
    }


    private class HttpRequestProductList extends AsyncTask<Void, Void, List<Product>>{

        @Override
        protected List<Product> doInBackground(Void... voids) {
            ProductServices productServices = new ProductServices();
            return productServices.getProductList();
        }

        @Override
        protected void onPostExecute(List<Product> products) {
            super.onPostExecute(products);
        }
    }
}
