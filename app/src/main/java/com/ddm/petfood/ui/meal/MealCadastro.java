package com.ddm.petfood.ui.meal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ddm.petfood.R;
import com.ddm.petfood.entity.Racao;

public class MealCadastro extends AppCompatActivity {
    private EditText editTextNome;
    private EditText editTextInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_cadastro);

        editTextNome = findViewById(R.id.edtNome);
        editTextNome = findViewById(R.id.edtInfo);
        Button btnSalvar = findViewById(R.id.btnSalvar);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = editTextNome.getText().toString();
                String info = editTextInfo.getText().toString();

                Racao meal = criarMeal(nome, info);
                salvarMeal(meal);
            }
        });

        setTitle("Add Meal");

    }

    public Racao criarMeal(String nome, String info){
        return new Racao(nome, info);
    }

    public void salvarMeal(Racao racao){

    }
}