package com.nirodha.converter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.nirodha.converter.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    EditText id;
    Button erase;
    Button submit;
    TextView bd_view;
    TextView age,gen;
    ImageButton re;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        id=(EditText) findViewById(R.id.etid);
        re=(ImageButton) findViewById(R.id.refresh);
       // erase=(Button) findViewById(R.id.erase);
        submit=(Button) findViewById(R.id.submit);
        bd_view=(TextView) findViewById(R.id.bd_view);
        age =(TextView) findViewById(R.id.age);
        gen=(TextView) findViewById(R.id.gen);



    }

    public void submit(View v)
    {
        boolean g;
        int y=0,days = 0,d=0,m=0;

        String id1=id.getText().toString();


        Date c = Calendar.getInstance().getTime();
        SimpleDateFormat df=new SimpleDateFormat("yyyy");
        String cyear=df.format(c);
        int cyear2=Integer.parseInt(cyear);
        int age_y=0;


        int x =id1.length();
        if(x==10) {
            days = Integer.parseInt(id1.substring(2, 5));
            y=1900+(Integer.parseInt(id1.substring(0, 2)));
            age_y=cyear2-(1900+Integer.parseInt(id1.substring(0,2)));


        }

        else if(x==11)
        {
            days = Integer.parseInt(id1.substring(4, 7));
            y=Integer.parseInt(id1.substring(0, 4));
            age_y=cyear2-(Integer.parseInt(id1.substring(0,4)));

        }




        if(days>500)
        {
                days = days - 500;
                g=true;
        }
        else
        {
            g=false;
        }

                int arr[]={31,29,31,30,31,30,31,31,30,31,30,31};
                for(int i=0;i<arr.length;i++)
                {
                    if(days<=arr[i])
                    {
                        m=i+1;
                        d=days;
                        break;
                    }
                    else
                    {
                        days=days-arr[i];
                    }
                }
                String month=Integer.toString(m);

            String year=Integer.toString(y)+"."+m+"."+d;

        if(id1.isEmpty())
        {
            Toast.makeText(this, "Empty Try Again!", Toast.LENGTH_SHORT).show();
        }
        else if(x<10 || x>11)
        {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
            bd_view.setText("");
            age.setText("");
            gen.setText("");
        }


        else
        {
            bd_view.setText(year);
            age.setText(Integer.toString(age_y));//set age

            if(g==true)
            {
                gen.setText("FEMALE");
            }
            else
            {
                gen.setText("MALE");
            }
        }

        }



        public void refresh (View v)
        {
            id.setText("");
            bd_view.setText("");
            age.setText("");
            gen.setText("");
        }





    }

