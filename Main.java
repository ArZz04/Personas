import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner rc = new Scanner(System.in);
    static ArrayList<Persona> personas = new ArrayList<>();

    public static void main(String[] args) {
        cargarPersonasDesdeArchivo();

        int op = 0;
        do {
            System.out.println("-----------------------------------------");
            System.out.println("---------------| PERSONA |---------------");
            System.out.println("1.- Agregar Persona");
            System.out.println("2.- Buscar Persona");
            System.out.println("3.- Modificar Persona");
            System.out.println("4.- Eliminar Persona ");
            System.out.println("0.- Salir");
            System.out.print("- Selecciona una opcion ->  ");
            op = rc.nextInt();
            switch (op) {
                case 0:
                    System.out.println("-----------------------------------------");
                    System.out.println("Programa finalizado con éxito!!...");
                    break;
                case 1:
                    addPerson();
                    break;
                case 2:
                    findPerson();
                    break;
                case 3:
                    modifyPerson();
                    break;
                case 4:
                    deletePerson();
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                    break;
            }

        } while (op != 0);
        guardarPersonasEnArchivo();
    }

    public static void addPerson(){
        int id;
        String nombre, apellidoP, apellidoM, ciudad;

        System.out.println("-----------------------------------------");
        System.out.println("-------------| REGISTRAR |---------------");
        System.out.print("ID: ");
        id = rc.nextInt();

        if (!Controller.verifyId(id)) {
            System.out.println("-----------| ID YA EXISTE |--------------");
            return;
        }

        System.out.print("Nombre: ");
        nombre = rc.next();
        System.out.print("Apellido Paterno: ");
        apellidoP = rc.next();
        System.out.print("Apellido Materno: ");
        apellidoM = rc.next();
        System.out.print("Ciudad: ");
        ciudad = rc.next();

        Persona nuevaPersona = new Persona(id, nombre.toUpperCase(), apellidoP.toUpperCase(), apellidoM.toUpperCase(), ciudad.toUpperCase());
        personas.add(nuevaPersona);
        Controller.agregarUsuario(nuevaPersona);
    }

    public static void findPerson(){
        int id;

        System.out.println("-----------------------------------------");
        System.out.println("-------------| ENCONTRAR |---------------");
        System.out.print("ID: ");
        id = (rc.nextInt());

        boolean personaEncontrada = false;
        for (Persona persona : personas) {
            if (persona.getId() == id) {
                personaEncontrada = true;
                System.out.println("-----------------------------------------");
                System.out.println("ID: " + persona.getId());
                System.out.println("Nombre: " + persona.getNombre());
                System.out.println("Apellido Paterno: " + persona.getApellidoP());
                System.out.println("Apellido Materno: " + persona.getApellidoM());
                System.out.println("Ciudad: " + persona.getCiudad());
                System.out.println("-----------------------------------------");
                break;
            }
        }
        if (!personaEncontrada) {
            System.out.println("-----------------------------------------");
            System.out.println("--------| PERSONA NO ENCONTRADA |--------");
        }
    }

    public static void modifyPerson(){
        int id;
        String nombre, apellidoP, apellidoM, ciudad;

        System.out.println("-----------------------------------------");
        System.out.println("-------------| MODIFICAR |---------------");
        System.out.print("ID: ");
        id = rc.nextInt();

        for (Persona persona : personas) {
            if (persona.getId() == id) {
                System.out.print("Nombre: ");
                nombre = rc.next();
                System.out.print("Apellido Paterno: ");
                apellidoP = rc.next();
                System.out.print("Apellido Materno: ");
                apellidoM = rc.next();
                System.out.print("Ciudad: ");
                ciudad = rc.next();

                persona.setNombre(nombre);
                persona.setApellidoP(apellidoP);
                persona.setApellidoM(apellidoM);
                persona.setCiudad(ciudad);
                Controller.modificarUsuario(persona);
                return;
            }
        }
        System.out.println("-----------------------------------------");
        System.out.println("-------| PERSONA NO ENCONTRADA |---------");
    }

    public static void deletePerson(){
        int id;

        System.out.println("-----------------------------------------");
        System.out.println("--------------| ELIMINAR |---------------");
        System.out.print("ID: ");
        id = rc.nextInt();

        for (Persona persona : personas) {
            if (persona.getId() == id) {
                personas.remove(persona);
                Controller.eliminarUsuario(id);
                return;
            }
        }
        System.out.println("-----------------------------------------");
        System.out.println("-------| PERSONA NO ENCONTRADA |---------");
    }

    private static void cargarPersonasDesdeArchivo() {
        ArrayList<Persona> personasCargadas = FileManager.leerUsuarios();
        if (personasCargadas != null) {
            personas.addAll(personasCargadas);
        }
    }

    private static void guardarPersonasEnArchivo() {
        FileManager.sobreescribirUsuarios(personas);
    }
}
