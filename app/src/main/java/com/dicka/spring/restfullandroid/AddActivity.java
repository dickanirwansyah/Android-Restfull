package com.dicka.spring.restfullandroid;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dicka.spring.restfullandroid.entities.Product;
import com.dicka.spring.restfullandroid.services.ProductServices;

public class AddActivity extends AppCompatActivity {

    //deklarasi komponen activity_add.xml\\
    private EditText editTextNamaProduct;
    private EditText editTextJumlahProduct;
    private EditText editTextPriceProduct;
    private Button buttonSaved;
    private Button buttonCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        try{
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_add);


            editTextNamaProduct = (EditText) findViewById(R.id.editTextNama);
            editTextJumlahProduct = (EditText) findViewById(R.id.editTextJumlah);
            editTextPriceProduct = (EditText) findViewById(R.id.editTextPrice);
            buttonSaved = (Button) findViewById(R.id.btnSimpanProduct);
            buttonCancel = (Button) findViewById(R.id.btnCancelProduct);

            //action save button
            buttonSaved.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try{
                        Product product = new Product();
                        product.setNama(String.valueOf(editTextNamaProduct.getText().toString()));
                        product.setJumlah(Integer.valueOf(editTextJumlahProduct.getText().toString()));
                        product.setPrice(Integer.valueOf(editTextJumlahProduct.getText().toString()));

                        boolean result = new HttpRequestAdd().execute(product).get();
                        if(result){
                            Intent intent_kembali = new Intent(AddActivity.this, MainActivity.class);
                            startActivity(intent_kembali);
                        }else{
                            AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
                            builder.setMessage("Data gagal disimpan, cek codingan mungkin ada " +
                                    "yang error !");
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                        AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
                        builder.setMessage(e.getMessage());
                        builder.create().show();
                    }
                }
            });

            //action cancel button
            buttonCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent inten_kembali = new Intent(AddActivity.this, MainActivity.class);
                    startActivity(inten_kembali);
                }
            });

        }catch (Exception e){
            e.printStackTrace();
            AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
            builder.setMessage(e.getMessage());
            builder.create().show();
        }
    }

    private class HttpRequestAdd extends AsyncTask<Product, Void, Boolean>{

        @Override
        protected Boolean doInBackground(Product... products) {
            ProductServices productServices = new ProductServices();
            return productServices.getCreatedProduct(products[0]);
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
        }
    }
}
