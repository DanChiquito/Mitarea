package myapp.selectos.temas.chico.mitarea;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class mitarea2 extends AppCompatActivity {

    private ArrayList<Usuario> usuarios;
    private RecyclerView rcListaUsuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mitarea2);

        rcListaUsuarios = findViewById(R.id.rcUsuarios);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rcListaUsuarios.setLayoutManager(llm);

        IniciandoListaContactos();
        IniciandoAdaptador();

    }


    //Falta agregar las imagenes
    public void IniciandoListaContactos()
    {
        usuarios = new ArrayList<>();
        usuarios.add(new Usuario("La Nat", "9381335302",R.drawable.bmw_m4_dtm));
        usuarios.add(new Usuario("Daniel", "5527407658",R.drawable.evolutioneevee));
        usuarios.add(new Usuario("Eri", "5535178606",R.drawable.foxwinter));

    }

    public void IniciandoAdaptador()
    {
        UsuarioAdaptador adaptador = new UsuarioAdaptador(usuarios, this);
        rcListaUsuarios.setAdapter(adaptador);
    }
}
