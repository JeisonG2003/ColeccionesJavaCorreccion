
package Practica;

import java.util.*;

public class BuggyActividad {

    public static void main(String[] args) {

        // LISTA de nombres
        List<String> nombres = new ArrayList<>();
        nombres.add("Ana");
        nombres.add("Luis");
        nombres.add("Ana");

        // CAMBIO: índice válido (antes era 3, ahora 2)
        System.out.println("Elemento en posición 2: " + nombres.get(2));

        // CAMBIO: comparación de cadenas usando equals en lugar de ==
        String buscado = new String("Ana");
        if (buscado.equals("Ana")) {
            System.out.println("Encontrado");
        }

        // MAPA de teléfonos
        Map<String, String> telefonos = new HashMap<>();
        telefonos.put("Ana", "0991111111");
        telefonos.put("Luis", "0992222222");
        telefonos.put("Ana", "0993333333"); // sobrescribe el número anterior, comportamiento normal de HashMap

        // CAMBIO: validación de existencia antes de imprimir
        String numeroBea = telefonos.get("Bea");
        if (numeroBea != null) {
            System.out.println("Bea: " + numeroBea);
        } else {
            System.out.println("Bea no tiene número registrado");
        }

        // SET de inscritos (evitar duplicados lógicos)
        Set<Alumno> inscritos = new HashSet<>();
        inscritos.add(new Alumno(1, "Ana"));
        inscritos.add(new Alumno(2, "Luis"));
        inscritos.add(new Alumno(1, "Ana")); // duplicado lógico, ahora será ignorado

        System.out.println("Tamaño del Set: " + inscritos.size());
        System.out.println(inscritos);
    }
}

// CAMBIO: sobrescribir equals y hashCode para evitar duplicados lógicos
class Alumno {

    int id;
    String nombre;

    Alumno(int id, String nombre) { 
        this.id = id; 
        this.nombre = nombre; 
    }

    @Override
    public String toString() {
        return "Alumno{id=" + id + ", nombre='" + nombre + "'}";
    }

    @Override
    public boolean equals(Object obj) { // CAMBIO
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Alumno alumno = (Alumno) obj;
        return id == alumno.id && Objects.equals(nombre, alumno.nombre);
    }

    @Override
    public int hashCode() { // CAMBIO
        return Objects.hash(id, nombre);
    }
}
