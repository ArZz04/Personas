public class Persona {

    // ID, NOMBRE, APELLIDO PATERNO, APELLIDO MATERNO, CIUDAD
    private int id;
    private String nombre, apellidoP, apellidoM, ciudad;

    public Persona(int id, String nombre, String apellidoP, String apellidoM, String ciudad){
        this.id = id;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.ciudad = ciudad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre.toUpperCase();
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP.toUpperCase();
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM.toUpperCase();
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad.toUpperCase();
    }
}
