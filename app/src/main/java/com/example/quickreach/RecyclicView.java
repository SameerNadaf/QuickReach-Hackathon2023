package com.example.quickreach;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class RecyclicView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclic_view);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);

        List<item> items = new ArrayList<item>();
        items.add(new item("John wick","john.wick@email.com",R.drawable.a));
        items.add(new item("Robert j","robert.j@email.com",R.drawable.a));
        items.add(new item("James Gunn","james.gunn@email.com",R.drawable.a));
        items.add(new item("Ricky tales","rickey.tales@email.com",R.drawable.a));
        items.add(new item("Micky mose","mickey.mouse@email.com",R.drawable.a));
        items.add(new item("Pick War","pick.war@email.com",R.drawable.a));
        items.add(new item("Leg piece","leg.piece@email.com",R.drawable.a));
        items.add(new item("Apple Mac","apple.mac@email.com",R.drawable.a));
        items.add(new item("John wick","john.wick@email.com",R.drawable.a));
        items.add(new item("Robert j","robert.j@email.com",R.drawable.a));
        items.add(new item("James Gunn","james.gunn@email.com",R.drawable.a));
        items.add(new item("Ricky tales","rickey.tales@email.com",R.drawable.a));
        items.add(new item("Micky mose","mickey.mouse@email.com",R.drawable.a));
        items.add(new item("Pick War","pick.war@email.com",R.drawable.a));
        items.add(new item("Leg piece","leg.piece@email.com",R.drawable.a));
        items.add(new item("Apple Mac","apple.mac@email.com",R.drawable.a));


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(getApplicationContext(),items));

    }
}