package com.ddm.petfood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

<<<<<<< Updated upstream
import com.ddm.petfood.databinding.ActivityMainBinding;
import com.ddm.petfood.ui.CalendarFragment;
import com.ddm.petfood.ui.HomeFragment;
import com.ddm.petfood.ui.PetFragment;
import com.ddm.petfood.ui.UserFragment;
=======
import com.ddm.petfood.entity.Usuario;
import com.ddm.petfood.repository.UsuarioRepository;
>>>>>>> Stashed changes

public class CadastroActivity extends AppCompatActivity {

    private EditText edNome;
    private EditText edEmail;
    private EditText edSenha;

    private Usuario usuario;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstaceState){
        View view = inflater.inflate(R.layout.activity_cadastro, container, false);

        edNome = view.findViewById(R.id.edNome);
        edEmail = view.findViewById(R.id.edEmail);
        edSenha = view.findViewById(R.id.edSenha);

        Button btnCadastrar = view.findViewById(R.id.btnCadastrar);
        btnCadastrar.setOnClickListener(v ->{
            String nome = edNome.getText().toString();
            String email = edEmail.getText().toString();
            String senha = edSenha.getText().toString();

            usuario = criarUsuario(nome, email, senha);
            salvarUsuario(usuario);
            Toast.makeText(context, "salvo com sucesso", Toast.LENGTH_SHORT).show();
        });
        return view;
    }

    private Usuario getUsuario(int id){
        UsuarioRepository usuarioRepository = new UsuarioRepository(this);
        return usuarioRepository.getUsuario(id);
    }

    public void salvarUsuario(Usuario usuario){
        UsuarioRepository usuarioRepository = new UsuarioRepository(this);
        if (usuarioRepository.salvarUsuario(usuario)){
            Toast.makeText(this, usuario.toString(), Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Error ao salvar usuario", Toast.LENGTH_SHORT).show();
        }
    }

    public Usuario criarUsuario(String nome, String email, String senha){
        return new Usuario(nome, email, senha);
    }
}