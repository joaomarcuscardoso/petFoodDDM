package com.ddm.petfood.ui.pet.edit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.ddm.petfood.R;
import com.ddm.petfood.ui.pet.edit.EditPetFragment;

public class EditPetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_pet);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, EditPetFragment.newInstance())
                    .commitNow();
        }
    }
}