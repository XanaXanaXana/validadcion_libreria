# validadcion_libreria
# Librería de Trámites Fiscales en Java 🇲🇽

Esta es una pequeña librería Java que permite generar datos fiscales de una persona mexicana, como el **RFC**, **CURP**, identificar si es **persona física o moral**, y calcular **ISR** e **IMSS**.  
Incluye además una **interfaz gráfica (JFrame)** para interactuar fácilmente con los métodos.

---

## ¿Qué hace la librería?

Contiene la clase `Tramites` que permite:

- Generar el **RFC** con base en nombre y fecha de nacimiento.  
- Generar el **CURP completo** considerando entidad federativa y sexo.  
- Identificar si un RFC pertenece a una **persona física o moral**.  
- Calcular el **ISR** según el tipo de contribuyente.  
- Calcular la cuota del **IMSS (seguro social)** según salario.

---

## Estructura del código

### Clase principal: `Tramites`

#### Atributos (privados):

- `nombre`  
- `apellidoPa`  
- `apellidoMa`  
- `feNac`  
- `sexo`  
- `estado`  

#### Métodos principales:

- `generarRFC(...)`: genera el RFC con las reglas básicas.  
- `generarCURP(...)`: genera el CURP con vocales, consonantes internas y código de estado.  
- `identificarContribuyente(String rfc)`: retorna “Persona Física” o “Moral”.  
- `calcularISR(String rfc, double ingreso)`: calcula el ISR según tipo.  
- `calcularCuota(String rfc, double salario)`: calcula el monto del IMSS.

#### Métodos auxiliares:

- `buscarVocal(String)`  
- `buscarConsonante(String)`  
- `obtenerCodigoEstado(String)`  
- `obtenerPenultimo(String)`  
- `obtenerUltimoCaracter()`

---

## Interfaz gráfica (`Panel.java`)

Formulario hecho con NetBeans GUI Builder que permite ingresar datos y presionar botones para:

- Mostrar RFC generado  
- Mostrar CURP generado  
- Mostrar tipo de contribuyente  
- Calcular ISR con un ingreso dado  
- Calcular cuota IMSS con un salario dado

---

## Clase `MainPrueba`

Pequeña clase `main` que prueba los métodos con valores predefinidos.  
Sirve para testear la librería rápidamente sin necesidad de usar la interfaz gráfica.

---

## Crear e importar la librería `.jar`

1. Compila el proyecto en NetBeans.
2. Haz clic en **"Clean and Build Project"** para generar el archivo `.jar` (lo encontrarás en la carpeta `/dist` del proyecto).
3. En otro proyecto, ve a:  
   **Project Properties > Libraries > Add JAR/Folder**, y selecciona tu `.jar`.
4. ¡Listo! Ya puedes usar la librería en cualquier proyecto Java.

---
##Documentación javadoc
file:///C:/Users/Manzana/OneDrive/Documentos/NetBeansProjects/Tramites/dist/javadoc/tramites/Tramites.html
---

## 🎥 Video de demostración

📺 [Ver video en YouTube](https://youtu.be/TFg6V6OD6AA?si=VknYe2SwnAiD5bc1)

---
## Créditos

- 👩‍🎨 **Ingrid Arcadio Aparicio**  
- 👩‍🎨 **Xana Amalinalli Pérez Jiménez**


