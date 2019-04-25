package myapp.selectos.temas.chico.mitarea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edtCorreo;
    private EditText edtPassword;
    private String valorCorreo;
    private String valorPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtCorreo = findViewById(R.id.edtCorreo);

    }

    public void onClickIngresar(View v){

        String usuario = "daniel";
        String pass = "daniel";
        edtPassword = findViewById(R.id.edtPassword);
        valorCorreo =  edtCorreo.getText().toString();
        valorPassword = edtPassword.getText().toString();

            if(edtCorreo.getText().toString().equals(usuario) && edtPassword.getText().toString().equals(pass))
            {
                Intent intent = new Intent(this, mitarea2.class);
                startActivity(intent);
            }
            else
            {
                Toast.makeText(this,"Compruebe que el correo y contraseña existan y no deje campos vacios",Toast.LENGTH_LONG).show();
            }


    }
}
