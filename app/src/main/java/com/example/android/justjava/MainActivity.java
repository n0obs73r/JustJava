package com.example.android.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.MessageFormat;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    Integer i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    private int calculateprice(int i) {
        String k = "" + i;
        display(k);
        return i * 5;
    }

    public void submitOrder(View view) {

        CheckBox wphCreamcb = findViewById(R.id.wph_cream);
        boolean haswphcream = wphCreamcb.isChecked();
        CheckBox hasChoctop = findViewById(R.id.haschoctop);
        boolean haschoctop = hasChoctop.isChecked();
        int l;
        l = calculateprice(i);
        if(haschoctop)
        {
            l = l+2;
        }
        else if(haswphcream)
        {
            l = l+1;
        }
        String s = "Arigato Gozaimasu!";
        EditText name = findViewById(R.id.nameip);
        String realname = name.getText().toString();
        String message = "";
        message += "\nHas Whipped Cream? " + haswphcream;
        message += "\nHas Chocolate Topping? " + haschoctop;
        message += "\nQuantity: " + i;
        NumberFormat.getCurrencyInstance().format(i);
        message += "\nTotal: $" +l;
        message += "\n" +s;
        //displayMessage(message);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"aryan.prince999@gmail.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "JustJava Order for " + realname);
        intent.putExtra(Intent.EXTRA_TEXT, message);

        startActivity(intent);

    }


//    private void displayMessage(String priceFree) {
//        TextView ptv = findViewById(R.id.price_text_view);
//        ptv.setText(priceFree);
//    }

    private void display(int i) {
        TextView qtv = findViewById(R.id.quantity_text_view);
        qtv.setText(MessageFormat.format("{0}", i));
    }
    private void display(String i) {
        TextView qtv = findViewById(R.id.quantity_text_view);
        qtv.setText(MessageFormat.format("{0}", i));
    }

    public void sub(View view) {
        if(i>0){
        display(--i);}
        else
            display(i);

    }

    public void add(View view) {
        display(++i);
    }
}