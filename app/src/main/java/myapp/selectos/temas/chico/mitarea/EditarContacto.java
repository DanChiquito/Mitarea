package myapp.selectos.temas.chico.mitarea;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class EditarContacto extends AppCompatActivity {

    private EditText edtNombre;
    private EditText edtNumero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_contacto);


        edtNombre =  findViewById(R.id.edtNombre);
        edtNumero = findViewById(R.id.editTel);
        Bundle extras = getIntent().getExtras();
        String telefono = extras.getString("telefono");
        String nombre = extras.getString("nombre");

        edtNombre.setText(nombre,TextView.BufferType.EDITABLE);
        edtNumero.setText(telefono, TextView.BufferType.EDITABLE);
    }

    public void OnClickLlamarC(View view)
    {
        String telefono = edtNumero.getText().toString();
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
        {
            return;
        }
        startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel "+ telefono)));
    }
}
