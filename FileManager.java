import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileManager {
    private static final String FILENAME = "data/persons.txt";

    public static ArrayList<Persona> leerUsuarios() {
        ArrayList<Persona> usuarios = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String nombre = parts[1];
                String apellidoPaterno = parts[2];
                String apellidoMaterno = parts[3];
                String ciudad = parts[4];
                Persona persona = new Persona(id, nombre, apellidoPaterno, apellidoMaterno, ciudad);
                usuarios.add(persona);
            }
        } catch (IOException e) {
            System.out.println("Error al leer usuarios: " + e.getMessage());
        }
        return usuarios;
    }

    public static void sobreescribirUsuarios(ArrayList<Persona> usuarios) {
        try (FileWriter writer = new FileWriter(FILENAME)) {
            for (Persona persona : usuarios) {
                writer.write(persona.getId() + "," + persona.getNombre() + "," +
                        persona.getApellidoP() + "," + persona.getApellidoM() + "," +
                        persona.getCiudad() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error al sobreescribir usuarios: " + e.getMessage());
        }
    }
}
