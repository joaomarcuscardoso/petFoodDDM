package com.ddm.petfood.ui.meal;

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
import com.ddm.petfood.repository.RacaoRepository;

public class MealCadastro extends AppCompatActivity {
    private EditText editTextNome;
    private EditText editTextInfo;
    private MealViewModel mealViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_cadastro);

        RacaoRepository racaoRepository = new RacaoRepository(this);

        mealViewModel = new ViewModelProvider(this, new MealViewModelFactory(racaoRepository)).get(MealViewModel.class);

        editTextNome = findViewById(R.id.edtNome);
        editTextInfo = findViewById(R.id.edtRace);
        Button btnSalvar = findViewById(R.id.btnSalvar);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = editTextNome.getText().toString();
                String info = editTextInfo.getText().toString();

                if(nome.isEmpty()){
                    Toast.makeText(MealCadastro.this, "O nome não foi informado!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(info.isEmpty()){
                    Toast.makeText(MealCadastro.this, "A informação sobre a ração não oi informada!", Toast.LENGTH_SHORT).show();
                    return;
                }


                mealViewModel.addNewRacao(nome, info);

                Toast.makeText(MealCadastro.this,"Ração adicionada com sucesso!", Toast.LENGTH_SHORT).show();
                replaceFragment(new MealFragment());

            }
        });

        setTitle("Add Meal");

    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frame_layout, fragment);
        transaction.commit();
    }

}