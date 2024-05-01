import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Controller {
    private static final String FILENAME = "data/persons.txt";

    public static void agregarUsuario(Persona persona) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME, true))) {
            writer.write(persona.getId() + "," + persona.getNombre() + "," +
                    persona.getApellidoP() + "," + persona.getApellidoM() + "," +
                    persona.getCiudad());
            writer.newLine();
            System.out.println("--------------| GUARDADO |---------------");
        } catch (IOException e) {
            System.out.println("Error al agregar usuario: " + e.getMessage());
        }
    }

    public static void modificarUsuario(Persona persona) {
        ArrayList<Persona> personas = FileManager.leerUsuarios();
        boolean encontrado = false;
        for (int i = 0; i < personas.size(); i++) {
            if (personas.get(i).getId() == persona.getId()) {
                personas.set(i, persona);
                encontrado = true;
                break;
            }
        }
        if (encontrado) {
            FileManager.sobreescribirUsuarios(personas);
            System.out.println("-------------| MODIFICADO |--------------");
        } else {
            System.out.println("----------| EL ID NO EXISTE |------------");
        }
    }

    public static void eliminarUsuario(int id) {
        ArrayList<Persona> personas = FileManager.leerUsuarios();
        boolean encontrado = false;
        for (int i = 0; i < personas.size(); i++) {
            if (personas.get(i).getId() == id) {
                personas.remove(i);
                encontrado = true;
                break;
            }
        }
        if (encontrado) {
            FileManager.sobreescribirUsuarios(personas);
            System.out.println("-----------------------------------------");
            System.out.println("--------------| ELIMINADO |--------------");
        } else {
            System.out.println("----------| EL ID NO EXISTE |------------");
        }
    }

    static boolean verifyId(int id) {
        ArrayList<Persona> usuarios = FileManager.leerUsuarios();
        for (Persona usuario : usuarios) {
            if (usuario.getId() == id) {
                return false;
            }
        }
        return true;
    }
}
