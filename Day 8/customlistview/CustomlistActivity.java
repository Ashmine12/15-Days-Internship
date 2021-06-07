package com.example.customlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class CustomlistActivity extends AppCompatActivity {
    ListView lv1;
    int image[]={R.drawable.i,R.drawable.mi,R.drawable.r,R.drawable.s};
    String []name={"iphone ","mi","realme","samsung"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv1=findViewById(R.id.lv1);
        Myadpter myadpter=new Myadpter(CustomlistActivity.this,image,name);
        lv1.setAdapter(myadpter);

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(CustomlistActivity.this,Listviewdetail.class);
                intent.putExtra("i1",image[position]);
                intent.putExtra("t1",name[position]);
                startActivity(intent);
            }
        });

    }
}
