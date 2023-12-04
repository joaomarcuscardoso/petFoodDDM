package com.ddm.petfood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ddm.petfood.entity.Usuario;
import com.ddm.petfood.repository.UsuarioRepository;
import com.ddm.petfood.util.ConfigFireBase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;

public class CadastroActivity extends AppCompatActivity {

    private EditText edNome;
    private EditText edEmail;
    private EditText edSenha;
    Button btnCadastrar;

    private Usuario usuario;
    FirebaseAuth autenticacao;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        inicializar();
    }



    private void inicializar(){
        edNome = findViewById(R.id.edNome);
        edEmail = findViewById(R.id.edEmail);
        edSenha = findViewById(R.id.edSenha);

        btnCadastrar = findViewById(R.id.btnCadastrar);
    }

    public void validarCampos(View v){
        String nome = edNome.getText().toString();
        String email = edEmail.getText().toString();
        String senha  = edSenha.getText().toString();

        if(!nome.isEmpty()){
            if (!email.isEmpty()){
                if (!senha.isEmpty()){
                    usuario = new Usuario();

                    usuario.setNome(nome);
                    usuario.setEmail(email);
                    usuario.setSenha(senha);
                    cadastrarUsuario();
                }else{
                    Toast.makeText(this, "Preencha o campo senha", Toast.LENGTH_SHORT).show();
                }
            }else {
                Toast.makeText(this, "Preencha o campo email", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "Preencha o campo nome", Toast.LENGTH_SHORT).show();
        }
    }

    public void cadastrarUsuario(){
        autenticacao = ConfigFireBase.FireBaseAuth();
        autenticacao.createUserWithEmailAndPassword(usuario.getEmail(), usuario.getSenha())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(context, "sucesso ao cadastrar usuario", Toast.LENGTH_SHORT).show();
                        }else{
                            String excecao = "";

                            try {
                                throw task.getException();
                            }catch (FirebaseAuthWeakPasswordException e){
                                excecao = "Digite uma senha mais forte";
                            }catch (FirebaseAuthInvalidCredentialsException e){
                                excecao = "Digite um email valido";
                            }catch (FirebaseAuthUserCollisionException e){
                                excecao = "Esta conta ja existe";
                            }catch (Exception e){
                                excecao = "Erro ao cadastrar usuario" + e.getMessage();
                                e.printStackTrace();
                            }
                            Toast.makeText(context, excecao, Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }









    //public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstaceState){
//        View view = inflater.inflate(R.layout.activity_cadastro, container, false);
//
//        edNome = view.findViewById(R.id.edNome);
//        edEmail = view.findViewById(R.id.edEmail);
//        edSenha = view.findViewById(R.id.edSenha);
//
//        Button btnCadastrar = view.findViewById(R.id.btnCadastrar);
//        btnCadastrar.setOnClickListener(v ->{
//            String nome = edNome.getText().toString();
//            String email = edEmail.getText().toString();
//            String senha = edSenha.getText().toString();
//            usuario = criarUsuario(nome, email, senha);
//            salvarUsuario(usuario);
//            validarCampos(v);
//            Toast.makeText(context, "salvo com sucesso", Toast.LENGTH_SHORT).show();
//        });
//        return view;
//    }

//    private Usuario getUsuario(int id){
//        UsuarioRepository usuarioRepository = new UsuarioRepository(this);
//        return usuarioRepository.getUsuario(id);
//    }
//
//    public void salvarUsuario(Usuario usuario){
//        UsuarioRepository usuarioRepository = new UsuarioRepository(this);
//        if (usuarioRepository.salvarUsuario(usuario)){
//            Toast.makeText(this, usuario.toString(), Toast.LENGTH_SHORT).show();
//        }else {
//            Toast.makeText(this, "Error ao salvar usuario", Toast.LENGTH_SHORT).show();
//        }
//    }
//
//    public Usuario criarUsuario(String nome, String email, String senha){
//        return new Usuario();
//    }
}