
package PracticaOriginal;

import java.util.*;

public class BuggyActividadOriginal {

    public static void main(String[] args) {

        // LISTA de nombres
        List<String> nombres = new ArrayList<>();
        nombres.add("Ana");
        nombres.add("Luis");
        nombres.add("Ana");

        // Error: índice fuera de rango
        System.out.println("Elemento en posición 3: " + nombres.get(3));

        // Error: comparación de cadenas con == en lugar de equals
        String buscado = new String("Ana");
        if (buscado == "Ana") {
            System.out.println("Encontrado");
        }

        // MAPA de teléfonos
        Map<String, String> telefonos = new HashMap<>();
        telefonos.put("Ana", "0991111111");
        telefonos.put("Luis", "0992222222");
        telefonos.put("Ana", "0993333333"); // sobrescribe sin control

        // Error: obtener clave inexistente sin validación
        System.out.println("Bea: " + telefonos.get("Bea").toString());

        // SET de inscritos (debería no permitir duplicados lógicos)
        Set<Alumno> inscritos = new HashSet<>();
        inscritos.add(new Alumno(1, "Ana"));
        inscritos.add(new Alumno(2, "Luis"));
        inscritos.add(new Alumno(1, "Ana")); // duplicado lógico

        System.out.println("Tamaño del Set: " + inscritos.size());
        System.out.println(inscritos);
    }
}

class Alumno {
    int id;
    String nombre;

    Alumno(int id, String nombre) { this.id = id; this.nombre = nombre; }

    public String toString() {
        return "Alumno{id=" + id + ", nombre='" + nombre + "'}";
    }
}
