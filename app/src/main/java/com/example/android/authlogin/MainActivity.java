package com.example.android.authlogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private Toolbar main_toolbar;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        main_toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(main_toolbar);

        getSupportActionBar().setTitle("Home");





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.item_logout:
            logout();
                return true;

                default: return false;
        }


    }

    private void logout() {

        mAuth.signOut();
        Toast.makeText(this,"Logged out successfully",Toast.LENGTH_SHORT).show();
        sendToLogin();

    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser loggedInUser = FirebaseAuth.getInstance().getCurrentUser();
        if (loggedInUser == null) {

            sendToLogin();

        }
    }
    private void sendToLogin() {

        Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(loginIntent);
        finish();

    }
    }
