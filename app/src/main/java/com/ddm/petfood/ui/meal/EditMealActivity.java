package com.ddm.petfood.ui.meal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.ddm.petfood.R;
import com.ddm.petfood.databinding.ActivityMainBinding;
import com.ddm.petfood.entity.Pet;
import com.ddm.petfood.entity.Racao;
import com.ddm.petfood.repository.RacaoRepository;
import com.ddm.petfood.ui.home.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;

public class EditMealActivity extends AppCompatActivity {
    private EditText editTextNome;
    private EditText editTextInfo;
    private MealViewModel mealViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_meal);
        Racao meal = (Racao) getIntent().getSerializableExtra("meal");

        RacaoRepository racaoRepository = new RacaoRepository(this);

        mealViewModel = new ViewModelProvider(this, new MealViewModelFactory(racaoRepository)).get(MealViewModel.class);

        editTextNome = findViewById(R.id.edtNome);
        editTextInfo = findViewById(R.id.edtRace);
        Button btnSalvar = findViewById(R.id.btnSalvar);

        editTextNome.setText(meal.getNome());
        editTextInfo.setText(meal.getInfo());

        btnSalvar.setOnClickListener(v -> {
            String nome = editTextNome.getText().toString();
            String info = editTextInfo.getText().toString();
            if (nome.isEmpty()) {
                Toast.makeText(this, "Preencha o nome", Toast.LENGTH_SHORT).show();
                return;
            }
            if (info.isEmpty()) {
                Toast.makeText(this, "Preencha a informação", Toast.LENGTH_SHORT).show();
                return;
            }

            meal.setNome(nome);
            meal.setInfo(info);
            mealViewModel.atualiarRacao(meal);
            Toast.makeText(this, "Ração atualizada com sucesso!", Toast.LENGTH_SHORT).show();
            FrameLayout frameLayout = findViewById(R.id.frame_layout);

            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.frame_layout, new MealFragment());
            transaction.commit();
        });
    }
}