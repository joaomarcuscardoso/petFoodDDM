package com.ddm.petfood.ui.pet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ddm.petfood.R;
import com.ddm.petfood.entity.Pet;
import com.ddm.petfood.repository.PetRepository;
import com.ddm.petfood.ui.home.HomeFragment;
import com.ddm.petfood.ui.home.HomeViewModel;
import com.ddm.petfood.ui.home.HomeViewModelFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class EditPetActivity extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextRace;
    private EditText editTextDate;
    private EditText editTextInfo;

    private HomeViewModel homeViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pet);

        Pet pet = (Pet) getIntent().getSerializableExtra("pet");

        PetRepository petRepository = new PetRepository(this);

        homeViewModel = new ViewModelProvider(this, new HomeViewModelFactory(petRepository)).get(HomeViewModel.class);

        editTextName = findViewById(R.id.edtNome);
        editTextRace = findViewById(R.id.edtRace);
        editTextDate = findViewById(R.id.edtDate);
        editTextInfo = findViewById(R.id.edtInfo);
        Button btnSalvar = findViewById(R.id.btnSalvar);

//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        String formattedDate = dateFormat.format(pet.getDataAniversario());

        editTextName.setText(pet.getNome());
        editTextRace.setText(pet.getRaca());
        editTextInfo.setText(pet.getInfo());
//        editTextDate.setText(formattedDate);

        // Use the 'date' variable as needed


        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                String race = editTextRace.getText().toString();
                String info = editTextInfo.getText().toString();

                if (name.isEmpty()) {
                    Toast.makeText(EditPetActivity.this, "Nome não pode ser vazio!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (race.isEmpty()) {
                    Toast.makeText(EditPetActivity.this, "Raça não pode ser vazio!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (info == null || info.isEmpty())
                    info = "";

//                try {
//                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//                    if (editTextDate.getText().toString().isEmpty()) {
//                        Toast.makeText(EditPetActivity.this, "Data inválida!", Toast.LENGTH_SHORT).show();
//                        return;
//                    }

//                    Date date = formatter.parse(editTextDate.getText().toString());

                    pet.setNome(name);
                    pet.setRaca(race);
                    pet.setInfo(info);
//                    pet.setDataAniversario(date);
                    System.out.println("PET: " + pet.toString());
                    homeViewModel.atualiarPet(pet);
                    // Use the 'date' variable as needed
//                } catch (ParseException e) {
//                    Toast.makeText(EditPetActivity.this, "Data inválida!", Toast.LENGTH_SHORT).show();
//                    return;
//                }
                Toast.makeText(EditPetActivity.this, "Pet adicionado com sucesso!", Toast.LENGTH_SHORT).show();
                // return to home
                replaceFragment(new HomeFragment());
            }
        });

        setTitle("Add Meal");
    }


    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frame_layout, fragment);
        transaction.commit();
    }
}