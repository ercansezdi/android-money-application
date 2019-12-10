package com.example.money_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    float money = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button gelir = (Button) findViewById(R.id.gelir);
        Button gider = (Button) findViewById(R.id.gider);
        TextView show_money = (TextView) findViewById(R.id.delete_show);
        show_money.setText("Balance : " + String.valueOf(money));

        SQLiteDatabase mydatabase = openOrCreateDatabase("test_x",MODE_PRIVATE,null);
        mydatabase.execSQL("CREATE TABLE IF NOT EXISTS TutorialsPoint(islem VARCHAR,para VARCHAR,tur VARCHAR);");

    }

    public void on_click_income(View view)
    {
        String islemler,paralar,turu;
        TextView show_money = (TextView) findViewById(R.id.delete_show);
        EditText money_amount= (EditText) findViewById(R.id.input);
        EditText money_operation = (EditText) findViewById(R.id.islem);
        if(money_operation.getText().toString().equals(""))
        {
            Toast toast_2 = Toast.makeText(getApplicationContext(),"Please input operation" ,Toast.LENGTH_SHORT);
            toast_2.show();
        }
        else {
            if (money_amount.getText().toString().equals("")) {
                Toast toast_2 = Toast.makeText(getApplicationContext(), "Please input money", Toast.LENGTH_SHORT);
                toast_2.show();
            }
            else {
                money = money + Integer.parseInt(money_amount.getText().toString());
                show_money.setText("Balance : " + String.valueOf(money));
                islemler = money_operation.getText().toString();
                paralar = money_amount.getText().toString();
                turu = "income";
                SQLiteDatabase mydatabase = openOrCreateDatabase("test_x",MODE_PRIVATE,null);
                String code = "INSERT INTO TutorialsPoint (islem,para,tur) VALUES('"+islemler+"', '"+paralar+"','"+turu+"');";
                mydatabase.execSQL(code);
                mydatabase.close();

            }
        }
    }
    public void on_click_expense(View view) {
        TextView show_money = (TextView) findViewById(R.id.delete_show);
        EditText money_amount = (EditText) findViewById(R.id.input);
        EditText money_operation = (EditText) findViewById(R.id.islem);
        String paralar,turu,islemler;
        if(money_operation.getText().toString().equals(""))
        {
            Toast toast_2 = Toast.makeText(getApplicationContext(),"Please input operation" ,Toast.LENGTH_SHORT);
            toast_2.show();
        }
        else {
            if (money_amount.getText().toString().equals("")) {
                Toast toast_2 = Toast.makeText(getApplicationContext(), "Please input money", Toast.LENGTH_SHORT);
                toast_2.show();
            }
            else {
                money = money - Integer.parseInt(money_amount.getText().toString());
                if (money > 0) {
                    show_money.setText("Balance : " + String.valueOf(money));
                    islemler = money_operation.getText().toString();
                    paralar = money_amount.getText().toString();
                    turu = "expense";
                    SQLiteDatabase mydatabase = openOrCreateDatabase("test_x", MODE_PRIVATE, null);
                    String code = "INSERT INTO TutorialsPoint (islem,para,tur) VALUES('" + islemler + "', '" + paralar + "','" + turu + "');";
                    mydatabase.execSQL(code);
                    mydatabase.close();
                }
                else {
                    show_money.setText("Balance : 0.0");
                    money = 0;
                }

            }
        }
    }
    public void on_click_transactions(View view)
    {
        Toast toast = Toast.makeText(getApplicationContext(),"transactions",Toast.LENGTH_SHORT);
        toast.show();

        startActivity(new Intent(MainActivity.this, islemler.class));
    }


}
