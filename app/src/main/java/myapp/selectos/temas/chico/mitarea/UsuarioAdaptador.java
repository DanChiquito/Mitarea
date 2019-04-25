package myapp.selectos.temas.chico.mitarea;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class UsuarioAdaptador extends RecyclerView.Adapter<UsuarioAdaptador.UsuarioViewHolder>
{
    ArrayList<Usuario> usuarios;
    Activity activity;

    public UsuarioAdaptador(ArrayList<Usuario> usuarios, Activity activity)
    {
        this.usuarios = usuarios;
        this.activity = activity;
    }

    public static class UsuarioViewHolder extends RecyclerView.ViewHolder
    {
        private Toolbar tlbCardView;
        private TextView txtvUsuario;
        private TextView txtvTelefono;
        private ImageButton imgbLlamar;
        private ImageView imgvFoto;

        public UsuarioViewHolder(@NonNull View itemView){
            super(itemView);

            tlbCardView = itemView.findViewById(R.id.tlbCardView);
            txtvTelefono = itemView.findViewById(R.id.txtvTelefono);
            txtvUsuario = itemView.findViewById(R.id.txtvUsuario);
            imgbLlamar = itemView.findViewById(R.id.imbLlamar);
            imgvFoto = itemView.findViewById(R.id.imvFoto);

        }
    }


    @NonNull
    @Override
    public UsuarioViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_usuarios,viewGroup,false);
        return new UsuarioViewHolder(v);
    }

    @Override
    public int getItemCount() {
        return usuarios.size();
    }


    @Override
    public void onBindViewHolder(@NonNull UsuarioViewHolder usuarioViewHolder, int posicion) {
        final Usuario usuario1 =usuarios.get(posicion);

        usuarioViewHolder.txtvUsuario.setText(usuario1.getNombre());
        usuarioViewHolder.txtvTelefono.setText(usuario1.getTelefono());
        usuarioViewHolder.imgvFoto.setImageResource(usuario1.getIdFoto());
        usuarioViewHolder.tlbCardView.inflateMenu(R.menu.menu_editar_usuario);

        usuarioViewHolder.tlbCardView.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId())
                {
                    case R.id.btnEditar:
                        Intent edtIntent = new Intent(activity, EditarContacto.class);
                        edtIntent.putExtra("telefono", usuario1.getTelefono());
                        edtIntent.putExtra("nombre", usuario1.getNombre());
                        activity.startActivity(edtIntent);
                        break;
                }
                return false;
            }
        });

        usuarioViewHolder.imgbLlamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String telefono = usuario1.getTelefono();
                if (ActivityCompat.checkSelfPermission(v.getContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
                {
                    return;
                }
                activity.startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel "+ telefono)));
            }
        });
    }





}
