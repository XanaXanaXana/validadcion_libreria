# validadcion_libreria
Descripción del proyecto
Esta es una pequeña librería Java que permite generar datos fiscales de una persona mexicana, como el RFC, CURP, identificar si es persona física o moral, y calcular ISR e IMSS.
Incluye una interfaz gráfica (JFrame) para interactuar fácilmente con los métodos.

¿Qué hace la librería?
Contiene la clase Tramites que permite:

-Generar el RFC con base en nombre y fecha de nacimiento.
-Generar el CURP completo con entidad y sexo.
-Identificar si un RFC pertenece a una persona física o moral.
-Calcular el ISR según el tipo de contribuyente.
-Calcular la cuota del IMSS (seguro social) según salario.


Estructura del código
Clase: Tramites
Atributos:

nombre, apellidoPa, apellidoMa, feNac, sexo, estado (todos privados)

Métodos principales:

GenerarRFC(...): genera el RFC con las reglas básicas.

generarCURP(...): genera el CURP con vocales, consonantes internas y código de estado.

identificarContribuyente(String rfc): retorna “Persona Física” o “Moral”.

calcularISR(String rfc, double ingreso): calcula el ISR según tipo.

calcularCuota(String rfc, double salario): calcula el monto del IMSS.

Métodos auxiliares:

buscarVocal(String), buscarConsonante(String), obtenerCodigoEstado(String), obtenerPenultimo(String) y obtenerUltimoCaracter()

Interfaz Gráfica (Panel.java)
Formulario hecho con NetBeans GUI Builder que permite ingresar datos y presionar botones para:

Mostrar RFC generado

Mostrar CURP generado

Mostrar tipo de contribuyente

Calcular ISR con un ingreso dado

Calcular cuota IMSS con un salario dado

Clase MainPrueba
Pequeña clase main que prueba los métodos con valores predefinidos. Se puede usar para testeo rápido sin interfaz.


CREAR E IMPORTAR LIBRERÍA .JAR 
Video de YouTube 
https://youtu.be/TFg6V6OD6AA?si=VknYe2SwnAiD5bc1

