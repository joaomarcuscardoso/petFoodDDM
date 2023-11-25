package com.ddm.petfood.ui.meal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ddm.petfood.R;
import com.ddm.petfood.entity.Racao;
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
        editTextInfo = findViewById(R.id.edtInfo);
        Button btnSalvar = findViewById(R.id.btnSalvar);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = editTextNome.getText().toString();
                String info = editTextInfo.getText().toString();

                mealViewModel.addNewRacao(nome, info);

            }
        });

        setTitle("Add Meal");

    }

}