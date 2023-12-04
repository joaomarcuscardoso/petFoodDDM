package com.ddm.petfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ddm.petfood.entity.Usuario;

public class LoginActivity extends AppCompatActivity {

    private Usuario usuario;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);
        context = this;

        Button btnEntrar = findViewById(R.id.btnEntrar);
        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText edLogin = findViewById(R.id.edLogin);
                EditText edSenha = findViewById(R.id.edSenha1);

                String login = edLogin.getText().toString();
                String senha = edSenha.getText().toString();

                // linha temporaria para navegar entre as telas
                login = "usuario";
                senha = "suasenha";

                if (login.equals("usuario") && senha.equals("suasenha")){
                    Intent intent = new Intent(v.getContext(), MainActivity.class);
                    intent.putExtra("usuario", "nomeUsuario");
                    startActivity(intent);
                }else{
                    Toast.makeText(v.getContext(), "Usuario ou senha incorretos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button btnCadastre_se = findViewById(R.id.btnCadastre_se);
        btnCadastre_se.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), CadastroActivity.class);
                intent.putExtra("cadastro", "novoCadastro");
                startActivity(intent);
            }
        });

    }
}