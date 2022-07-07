package corp.data.demoApi.models;

public class ClienteModel {

    private String nombre;
    private String apellidos;
    private long cedula;
    private String direccion;
    private int edad;

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public long getCedula() {
        return cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getEdad() {
        return edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setCedula(long cedula) {
        this.cedula = cedula;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return nombre+"*"+apellidos+"*"+cedula+"*"+direccion+"*"+edad;
    }
}
