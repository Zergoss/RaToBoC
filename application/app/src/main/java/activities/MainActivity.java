package activities;

import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import ca.uottawa.cohab.R;
import fragment.ProfileView;
import fragment.TaskList;
import fragment.UserList;
import fragment.UserSwitch;
import helpers.Input;
import sql.DatabaseHelper;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private final AppCompatActivity activity = MainActivity.this;
    DatabaseReference databaseReference;
    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        databaseReference = FirebaseDatabase.getInstance().getReference("user");

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        defaultDrawer();
        initViews();
        initNav();
    }

    private void initNav() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        navigationView.setNavigationItemSelectedListener(this);
        View header = navigationView.getHeaderView(0);
        TextView usernameTextMain = (TextView) header.findViewById(R.id.usernameTextMain);
        usernameTextMain.setText(username);
    }
    private void initViews() {
        username = getIntent().getStringExtra("USERNAME");
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FragmentManager fragmentManager = getFragmentManager();

        if (id == R.id.nav_task_list) {
            getSupportActionBar().setTitle("Task list");
            fragmentManager.beginTransaction().replace(R.id.content_frame, new TaskList()).commit();
        } else if (id == R.id.nav_user_list) {
            getSupportActionBar().setTitle("User list");
            fragmentManager.beginTransaction().replace(R.id.content_frame, new UserList()).commit();
        } else if (id == R.id.nav_profile) {
            getSupportActionBar().setTitle("Profile");
            fragmentManager.beginTransaction().replace(R.id.content_frame, new ProfileView()).commit();
        } else if (id == R.id.nav_user_switch) {
            getSupportActionBar().setTitle("Switch user");
            fragmentManager.beginTransaction().replace(R.id.content_frame, new UserSwitch()).commit();
        } else if (id == R.id.nav_log_off) {
            Intent MainIntent = new Intent (MainActivity.this, Login.class);
            startActivity(MainIntent);
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void defaultDrawer() {
        FragmentManager fragmentManager = getFragmentManager();
        getSupportActionBar().setTitle("Task list");
        fragmentManager.beginTransaction().replace(R.id.content_frame, new TaskList()).commit();
    }

    public String getUsername() {
        return this.username;
    }

}