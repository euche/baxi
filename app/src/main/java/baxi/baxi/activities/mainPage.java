package baxi.baxi.activities;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import baxi.baxi.R;
import baxi.baxi.fragments.customerFragment;
import baxi.baxi.fragments.overviewFragment;
import baxi.baxi.fragments.salesFragment;
import baxi.baxi.fragments.settingsFragment;
import baxi.baxi.fragments.transactionFragment;
import baxi.baxi.models.loginuser;

public class mainPage extends AppCompatActivity {








    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);


        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav);
        bottomNav.setOnNavigationItemSelectedListener(nl);

        getSupportFragmentManager().beginTransaction().replace(R.id.frag_container,new overviewFragment()).commit();
        //select Default Fragment

    }


    private BottomNavigationView.OnNavigationItemSelectedListener nl = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

            Fragment selectedFragment =  null;

            switch(menuItem.getItemId()){

                case R.id.overview:
                    selectedFragment = new overviewFragment();
                    break;

                case R.id.transaction:
                    selectedFragment = new transactionFragment();
                    break;

                case R.id.sales:
                    selectedFragment = new salesFragment();
                    break;

                case R.id.customer:
                    selectedFragment = new customerFragment();
                    break;

                case R.id.settings:
                    selectedFragment = new settingsFragment();
                    break;
            }


             getSupportFragmentManager().beginTransaction().replace(R.id.frag_container,selectedFragment).commit();


            return true;
        }
    };










}
