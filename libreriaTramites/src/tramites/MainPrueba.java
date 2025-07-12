/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tramites;

/**
 * Clase principal para probar las funcionalidades de la clase {@link Tramites}.
 * 
 * Ejecuta pruebas con datos de ejemplo para generar RFC, CURP,
 * identificar el tipo de contribuyente, calcular ISR y cuota del IMSS.
 * 
 * @author INGRID-XANA
 */
public class MainPrueba {

    /**
     * Método principal que ejecuta la prueba de la clase Tramites.
     *
     * @param args Argumentos desde línea de comandos (no se usan aquí)
     */
    public static void main(String[] args) {

        // Datos de ejemplo
        String nombre = "Fernanda";
        String apellidoPa = "Ramirez";
        String apellidoMa = "Lopez";
        String fechaNacimiento = "15/08/2000";
        char sexo = 'F';
        String estado = "JALISCO";

        // Crear objeto de Tramites
        Tramites persona = new Tramites(nombre, apellidoPa, apellidoMa, fechaNacimiento, sexo, estado);

        // Generar RFC
        String rfc = persona.GenerarRFC(nombre, apellidoPa, apellidoMa, fechaNacimiento);
        System.out.println("RFC: " + rfc);
        System.out.println("Tipo de Contribuyente: " + persona.identificarContribuyente(rfc));

        // Generar CURP
        String curp = persona.generarCURP(nombre, apellidoPa, apellidoMa, fechaNacimiento, sexo, estado);
        System.out.println("CURP: " + curp);

        // Calcular ISR
        double ingreso = 12000.00;
        double isr = persona.calcularISR(rfc, ingreso);
        System.out.println("ISR: $" + isr);

        // Calcular cuota IMSS
        double salario = 9000.00;
        double cuota = persona.calcularCuota(rfc, salario);
        System.out.println("Cuota IMSS: $" + cuota);
    }
}
