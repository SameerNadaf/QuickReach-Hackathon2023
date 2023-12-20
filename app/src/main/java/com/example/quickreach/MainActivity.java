package com.example.quickreach;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth auth;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageA = findViewById(R.id.chef);
        ImageView imageB = findViewById(R.id.maker);
        ImageView imageC = findViewById(R.id.worker);
        ImageView sign = findViewById(R.id.signout);
        ImageView about = findViewById(R.id.about);

        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        if (user == null) {
            Intent intent = new Intent(getApplicationContext(), Login.class);
            startActivity(intent);
            finish();
        }

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), About.class);
                startActivity(intent);
                finish();

            }
        });

        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                auth.signOut();
                Toast.makeText(MainActivity.this, "LogOut successful", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
                finish();
            }
        });

        imageA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startRecyclicViewActivity("Food");
            }
        });

        imageB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startRecyclicViewActivity("Crafts");
            }
        });

        imageC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startRecyclicViewActivity("Services");
            }
        });


    }

    private void startRecyclicViewActivity(String databaseName) {
        Intent intent = new Intent(this, RecyclicView.class);
        intent.putExtra("databaseName", databaseName);
        startActivity(intent);

    }
}
