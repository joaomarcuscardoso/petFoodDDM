package com.ddm.petfood.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.ddm.petfood.R;
import com.ddm.petfood.ui.pet.add.AddPetFragment;

public class AddPetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pet);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, AddPetFragment.newInstance())
                    .commitNow();
        }
    }
}