package com.ddm.petfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.ddm.petfood.databinding.ActivityMainBinding;
import com.ddm.petfood.ui.calendar.CalendarFragment;
import com.ddm.petfood.ui.home.HomeFragment;
import com.ddm.petfood.ui.pet.PetFragment;
import com.ddm.petfood.ui.user.UserFragment;

public class cadastro_activity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new HomeFragment());
        binding.bottomNavigationView.getMenu().getItem(2).setChecked(true);

        // setContentView(R.layout.activity_main);
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();

            if (itemId == R.id.home) {
                replaceFragment(new HomeFragment());
            } else if (itemId == R.id.pet) {
                replaceFragment(new PetFragment());
            } else if (itemId == R.id.calendar) {
                replaceFragment(new CalendarFragment());
            } else if (itemId == R.id.user) {
                replaceFragment(new UserFragment());
            }

            return true;
        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frame_layout, fragment);
        transaction.commit();
    }
}