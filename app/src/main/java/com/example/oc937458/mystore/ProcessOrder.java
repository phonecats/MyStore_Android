package com.example.oc937458.mystore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class ProcessOrder extends AppCompatActivity {

    private TextView itemName;
    private EditText itemQuantity;
    private Button addItemButton;
    private int arraycount;


    private String itemNameText;
    private double itemPrice;
    TableLayout tableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_process_order);

        itemQuantity = (EditText)findViewById(R.id.orderQuantityView);
        addItemButton = (Button) findViewById(R.id.addItemButton);
        itemName = (TextView) findViewById(R.id.storeItemView);
        itemQuantity = (EditText)findViewById(R.id.orderQuantityView);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            itemNameText = extras.getString("itemName");
            itemPrice = extras.getDouble("itemPrice");
            itemName.setText(itemNameText);
            arraycount = extras.getInt("arrayCount");
        }
        //the table of all current elements
        product[] products = MyStore.getProducts();
        if (products[0] != null) {
            //Toast.makeText(this, "array passed" + "count = " + arraycount,
              //      Toast.LENGTH_LONG).show();

            tableLayout = (TableLayout)findViewById(R.id.table);

            tableLayout.removeAllViews();

            tableLayout.setVerticalScrollBarEnabled(true);

            for (int i = 0; i < arraycount; i++) {

                TableRow tableRow = new TableRow(this);
                TextView textView = new TextView(this);
                textView.setPadding(0,0,15,0);
                TextView textView_quantity = new TextView(this);

                textView_quantity.setText(Integer.toString(products[i].getProductQuantity()));
                textView.setText(products[i].getProductName());

                tableRow.addView(textView);
                tableRow.addView(textView_quantity);
                tableLayout.addView(tableRow);

            }
        }
    }

    public void add(View view){

        int itemQuantityText = Integer.parseInt(itemQuantity.getText().toString());
        Intent intent = new Intent(getApplicationContext(), MyStore.class);

        //send the info back to the array in MyStore.java
        intent.putExtra("itemName", itemNameText);
        intent.putExtra("itemQuantity", itemQuantityText);
        intent.putExtra("itemPrice", itemPrice);
        intent.putExtra("count",arraycount);
        startActivity(intent);
    }
}
