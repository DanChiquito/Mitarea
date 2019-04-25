package myapp.selectos.temas.chico.mitarea;

public class Usuario {

    private String nombre;
    private String telefono;
    private int idFoto;

    public Usuario(String nombre, String telefono, int idFoto) {
        this.setNombre(nombre);
        this.setTelefono(telefono);
        this.setIdFoto(idFoto);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getIdFoto() {
        return idFoto;
    }

    public void setIdFoto(int idFoto) {
        this.idFoto = idFoto;
    }
}
