package com.example.oc937458.mystore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class FinalOrder extends AppCompatActivity {


    private double arraycount;
    TableLayout tableLayout;
    double subTotal= 0;
    double tax = .0825;
    double total =0 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_order);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            arraycount = extras.getInt("arrayCount");
        }
        product[] products = MyStore.getProducts();
        if (products[0] != null) {
            //Toast.makeText(this, "array passed" + "count = " + arraycount,
             //       Toast.LENGTH_LONG).show();

            tableLayout = (TableLayout)findViewById(R.id.tableFinalOrder);

            tableLayout.removeAllViews();

            tableLayout.setVerticalScrollBarEnabled(true);


            for (int i = 0; i < arraycount; i++) {


                DecimalFormat df1 = new DecimalFormat("$#.##");


                TableRow tableRow = new TableRow(this);
                TextView textView = new TextView(this);
                TextView textView_quantity = new TextView(this);
                TextView textViewPrice = new TextView(this);
                textView.setPadding(0, 0, 15, 0);
                textView_quantity.setPadding(0, 0, 25, 0);
                textView.setText(products[i].getProductName());
                textView_quantity.setText(Integer.toString(products[i].getProductQuantity()));

                if (df1.format(products[i].getProductPrice()).contains(".")){
                    textViewPrice.setText(df1.format(products[i].getProductPrice()));
                }
                else {
                    textViewPrice.setText(df1.format(products[i].getProductPrice())+".00");
                }

                tableRow.addView(textView);
                tableRow.addView(textView_quantity);
                tableRow.addView(textViewPrice);
                tableLayout.addView(tableRow);


                //logic of calculation
                subTotal = subTotal + (products[i].getProductPrice() * products[i].getProductQuantity());

            }
            DecimalFormat df = new DecimalFormat("#.##");

            //logic of calculation continued
            tax = subTotal * tax;
            total = subTotal + tax;

            subTotal = Double.valueOf(df.format(subTotal));
            tax = Double.valueOf(df.format(tax));
            total = Double.valueOf(df.format(total));

            TableRow tableRowSubTotal = new TableRow(this);
            TableRow tableRowTax = new TableRow(this);
            TableRow tableRowTotal = new TableRow(this);

            TextView textViewSubtotal = new TextView(this);
            textViewSubtotal.setText("Sub Total");

            ;
            DecimalFormat df1 = new DecimalFormat("$#.##");

            TextView textViewSubTotalAmount = new TextView(this);

            if (df1.format(subTotal).contains(".")){
                textViewSubTotalAmount.setText(df1.format(subTotal));
            }
            else{
                textViewSubTotalAmount.setText(df1.format(subTotal)+".00");
            }




            TextView textViewTax = new TextView(this);
            textViewTax.setText("Tax (8.25%)");

            TextView textViewTaxAmount = new TextView(this);
            textViewTaxAmount.setText(df1.format(tax));

            TextView textViewTotal = new TextView(this);
            textViewTotal.setText("Total");

            TextView textViewTotalAmount = new TextView(this);
            textViewTotalAmount.setText(df1.format(total));

            TextView textViewBlank = new TextView(this);
            TextView textViewBlank2 = new TextView(this);
            TextView textViewBlank3 = new TextView(this);



            tableRowSubTotal.addView(textViewSubtotal);
            tableRowSubTotal.addView(textViewBlank);
            tableRowSubTotal.addView(textViewSubTotalAmount);
            tableRowTax.addView(textViewTax);
            tableRowTax.addView(textViewBlank2);
            tableRowTax.addView(textViewTaxAmount);
            tableRowTotal.addView(textViewTotal);
            tableRowTotal.addView(textViewBlank3);
            tableRowTotal.addView(textViewTotalAmount);


            tableLayout.addView(tableRowSubTotal);
            tableLayout.addView(tableRowTax);
            tableLayout.addView(tableRowTotal);
        }
    }
}
