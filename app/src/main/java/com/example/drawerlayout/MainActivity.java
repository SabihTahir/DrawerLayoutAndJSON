package com.example.drawerlayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    private NavigationView objNavigationView;
    private DrawerLayout objDrawerLayout;

    private View headerView;
    private ImageView profileIV;

    private ActionBarDrawerToggle objActionBarDrawerToggle;
    private Toolbar objToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Student student=new Student("Ali",1,"MAD");
        Gson objGson=new Gson();

        String StuInJSONFormate =objGson.toJson(student);
        String myJson="{\"name\":\"Sabih\",\"roll\":310," +
                "\"subject\":\"MAD\"}";

        Student objNewStudent=objGson.fromJson(myJson,Student.class);
        TextView textView=findViewById(R.id.TV);
        textView.setText("Name:"+objNewStudent.getStuName()+"\n"
        +"Roll No:"+objNewStudent.getStuRollNo()+"\n"
        +"Subject:"+objNewStudent.getStuSubject());

        StartedObjects();
    }
    private void StartedObjects() {
        try {
            objNavigationView = findViewById(R.id.navigationView);
            objDrawerLayout = findViewById(R.id.drawerLayout);

            headerView = objNavigationView.getHeaderView(0);
            profileIV = headerView.findViewById(R.id.header_IV);

            objToolbar = findViewById(R.id.toolBar);
            profileIV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(MainActivity.this, "Profile is clicked", Toast.LENGTH_SHORT).show();
                }
            });
            objNavigationView.setNavigationItemSelectedListener(
                    new NavigationView.OnNavigationItemSelectedListener() {
                        @Override
                        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                            if (item.getItemId() == R.id.item_home) {
                                Toast.makeText(MainActivity.this, "Home is here", Toast.LENGTH_SHORT).show();
                                closeDrawer();
                                return true;
                            } else if (item.getItemId() == R.id.item_about) {
                                Toast.makeText(MainActivity.this, "About is here", Toast.LENGTH_SHORT).show();
                                closeDrawer();
                                return true;
                            } else if (item.getItemId() == R.id.item_feedback) {
                                Toast.makeText(MainActivity.this, "Feedback is here", Toast.LENGTH_SHORT).show();
                                closeDrawer();
                                return true;
                            }
                            return false;
                        }
                    }
            );
            setUpHamBurgerIcon();
        }
        catch (Exception e)
        {
            Toast.makeText(this, "StartedObjects:"+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
    private void closeDrawer()
    {
        try
        {
            objDrawerLayout.closeDrawer(GravityCompat.START);
        }
        catch (Exception e)
        {
            Toast.makeText(this, "closeDrawer:"+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
    private void setUpHamBurgerIcon()
    {
        try
        {
            objActionBarDrawerToggle=new ActionBarDrawerToggle(
                    this,
                    objDrawerLayout,objToolbar,(R.string.open)
                    ,(R.string.close)
            );

            objActionBarDrawerToggle.getDrawerArrowDrawable().setColor(getResources().getColor(
                    R.color.colorPrimary
            ));

            objActionBarDrawerToggle.syncState();


        }
        catch (Exception e)
        {
            Toast.makeText(this, "setUpHamBurgerIcon:"+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}