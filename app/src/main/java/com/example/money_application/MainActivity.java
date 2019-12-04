package com.example.money_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    float money = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button gelir = (Button) findViewById(R.id.gelir);
        Button gider = (Button) findViewById(R.id.gider);
        TextView show_money = (TextView) findViewById(R.id.show);
        show_money.setText("Balance : " + String.valueOf(money));
    }


    public void on_click_income(View view)
    {
        TextView show_money = (TextView) findViewById(R.id.show);
        EditText money_amount= (EditText) findViewById(R.id.input);
        money = money + Integer.parseInt(money_amount.getText().toString());
        show_money.setText("Balance : " + String.valueOf(money));
    }
    public void on_click_expense(View view)
    {
        TextView show_money = (TextView) findViewById(R.id.show);
        EditText money_amount= (EditText) findViewById(R.id.input);
        money = money - Integer.parseInt(money_amount.getText().toString());
        if(money > 0)
            show_money.setText("Balance : " + String.valueOf(money));
        else
            show_money.setText("Balance : 0");
    }
    public void on_click_transactions(View view)
    {
        Toast toast = Toast.makeText(getApplicationContext(),"transactions",Toast.LENGTH_SHORT);
        toast.show();
        startActivity(new Intent(MainActivity.this, islemler.class));
    }


}
