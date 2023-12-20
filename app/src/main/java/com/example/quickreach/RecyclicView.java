package com.example.quickreach;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class RecyclicView extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference database;
    MyAdapter myAdapter;
    ArrayList<User> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclic_view);

        recyclerView = findViewById(R.id.userList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        myAdapter = new MyAdapter(this, list);
        recyclerView.setAdapter(myAdapter);

        String databaseName = getIntent().getStringExtra("databaseName");

        if (databaseName != null && !databaseName.isEmpty()) {
            database = FirebaseDatabase.getInstance().getReference(databaseName);

            database.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    list.clear();

                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        User user = dataSnapshot.getValue(User.class);
                        list.add(user);
                    }

                    myAdapter.notifyDataSetChanged();
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(RecyclicView.this, "Error fetching data", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            Toast.makeText(this, "Database is null or empty", Toast.LENGTH_SHORT).show();
        }
    }
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

}
