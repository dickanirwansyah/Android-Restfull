package com.dicka.spring.restfullandroid.services;

import com.dicka.spring.restfullandroid.entities.Product;

import org.json.JSONObject;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by java-spring on 01/12/17.
 */

public class ProductServices {

    private final static String URI_LIST_PRODUCT = "http://192.168.43.68:8080/java-api/api/products/";
    private final static String URI_ID_PRODUCT = "http://192.168.43.68:8080/java-api/api/products/";
    private final static String URI_INSERT_PRODUCT = "http://192.168.43.68:8080/java-api/api/insertProduct";
    private final static String URI_UPDATE_PRODUCT = "http://192.168.43.68:8080/java-api/api/updateProduct/";
    private final static String URI_DELETE_PRODUCT = "http://192.168.43.68:8080/java-api/api/deleteProduct/";

    private RestTemplate restTemplate = new RestTemplate();

    public List<Product> getProductList(){
        try{
            return restTemplate.exchange(
                    URI_LIST_PRODUCT,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<Product>>() {
                    }
            ).getBody();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public Product getProductById(int idproduct){
        try{
            return restTemplate.exchange(
                    URI_ID_PRODUCT + idproduct,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<Product>() {
                    }
            ).getBody();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public boolean getCreatedProduct(Product product){
        try{
            Map<String, String> values = new HashMap<String, String>();
            values.put("nama", String.valueOf(product.getNama()));
            values.put("jumlah", String.valueOf(product.getJumlah()));
            values.put("price", String.valueOf(product.getPrice()));

            JSONObject JSON_PARSE = new JSONObject(values);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> entity = new HttpEntity<String>(JSON_PARSE.toString(), headers);
            restTemplate.postForEntity(URI_INSERT_PRODUCT, entity, null);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean getUpdateProduct(Product product, int idproduct){
        try{
            Map<String, String> values = new HashMap<String, String>();
            values.put("idproduct", String.valueOf(product.getIdproduct()));
            values.put("nama", String.valueOf(product.getNama()));
            values.put("jumlah", String.valueOf(product.getJumlah()));
            values.put("price", String.valueOf(product.getPrice()));

            JSONObject JSON_PARSE = new JSONObject(values);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> entity = new HttpEntity<String>(JSON_PARSE.toString(), headers);
            restTemplate.postForEntity(URI_UPDATE_PRODUCT+idproduct, entity, null);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean getDeleteProduct(int idproduct){
        try{
            restTemplate.delete(URI_DELETE_PRODUCT+idproduct);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
