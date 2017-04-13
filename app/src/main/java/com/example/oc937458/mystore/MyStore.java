package com.example.oc937458.mystore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
//Oscar Chavez


public class MyStore extends AppCompatActivity {

    public static final product[] products = new product[100];
    private int count = 0;

    public static product[] getProducts() {
        return products;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_store);
    }

    public void dasaniclick(View view){

        Intent intent = new Intent(getApplicationContext(), ProcessOrder.class);
        intent.putExtra("itemName", "Dasani");
        intent.putExtra("itemPrice", 2.00);
        intent.putExtra("arrayCount", count);
        startActivity(intent);
    }

    public void fruitoatmealclick(View view){

        Intent intent = new Intent(getApplicationContext(), ProcessOrder.class);
        intent.putExtra("itemName", "Fruit Oatmeal");
        intent.putExtra("itemPrice", 2.00);
        intent.putExtra("arrayCount", count);
        startActivity(intent);
    }

    public void hotcakesclick(View view){

        Intent intent = new Intent(getApplicationContext(), ProcessOrder.class);
        intent.putExtra("itemName", "Hotcakes");
        intent.putExtra("itemPrice", 2.00);
        intent.putExtra("arrayCount", count);
        startActivity(intent);
    }

    public void sausagebiscuitclick(View view){

        Intent intent = new Intent(getApplicationContext(), ProcessOrder.class);
        intent.putExtra("itemName", "Sausage Biscuit");
        intent.putExtra("itemPrice", 1.99);
        intent.putExtra("arrayCount", count);
        startActivity(intent);
    }

    public void baconeggbiscuitclick(View view){

        Intent intent = new Intent(getApplicationContext(), ProcessOrder.class);
        intent.putExtra("itemName", "Bacon Egg Biscuit");
        intent.putExtra("itemPrice", 2.00);
        intent.putExtra("arrayCount", count);
        startActivity(intent);
    }

    public void eggsausageclick(View view){

        Intent intent = new Intent(getApplicationContext(), ProcessOrder.class);
        intent.putExtra("itemName", "Egg Sausage");
        intent.putExtra("itemPrice", 2.00);
        intent.putExtra("arrayCount", count);
        startActivity(intent);
    }

    public void sausageburritoclick(View view){

        Intent intent = new Intent(getApplicationContext(), ProcessOrder.class);
        intent.putExtra("itemName", "Sausage Burrito");
        intent.putExtra("itemPrice", 1.75);
        intent.putExtra("arrayCount", count);
        startActivity(intent);
    }

    @Override
    public void onResume(){
        
        super.onResume();

        //Receive the info from the ProcessOrder.class
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String itemNameText = extras.getString("itemName");
            double itemPrice = extras.getDouble("itemPrice");
            int itemQuantity = extras.getInt("itemQuantity");
            count = extras.getInt("count");
            products[count] = new product(itemNameText, itemPrice, itemQuantity);
            //debug
            //Toast.makeText(this, "added " + itemNameText + " quantity " + itemQuantity,
            //        Toast.LENGTH_LONG).show();
            count++;
            getIntent().removeExtra("itemName");
            getIntent().removeExtra("itemPrice");
            getIntent().removeExtra("itemQuantity");
            getIntent().removeExtra("count");
        }
    }

    @Override
    public void onPause(){
        super.onPause();

    }


    public void processOrder(View view){
        Intent intent = new Intent(getApplicationContext(), FinalOrder.class);
        intent.putExtra("arrayCount",count);
        startActivity(intent);


    }

}
