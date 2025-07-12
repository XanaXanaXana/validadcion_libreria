/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tramites;

/**
 * Clase final que representa los trámites relacionados con un ciudadano.
 * Permite generar RFC, CURP, identificar tipo de contribuyente y calcular impuestos.
 * 
 * @author INGRID-XANA
 */
public final class Tramites {
    private String nombre;
    private String apellidoPa;
    private String apellidoMa;
    private String feNac;
    private char sexo;
    private String estado;

    /**
     * Constructor que inicializa los datos del trámite.
     * 
     * @param nombre Nombre del ciudadano
     * @param apellidoPa Apellido paterno
     * @param apellidoMa Apellido materno
     * @param feNac Fecha de nacimiento en formato DD/MM/AAAA
     * @param sexo Sexo del ciudadano ('H' o 'M')
     * @param estado Estado de nacimiento
     */
    public Tramites(String nombre, String apellidoPa, String apellidoMa, String feNac, char sexo, String estado) {
        this.nombre = nombre.toUpperCase();
        this.apellidoPa = apellidoPa.toUpperCase();
        this.apellidoMa = apellidoMa.toUpperCase();
        this.feNac = feNac;
        this.sexo = Character.toUpperCase(sexo);
        this.estado = estado.toUpperCase();
    }

    // Métodos getters y setters

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setApellidoPa(String apellidoPa) {
        this.apellidoPa = apellidoPa;
    }

    public String getApellidoPa() {
        return apellidoPa;
    }

    public void setApellidoMa(String apellidoMa) {
        this.apellidoMa = apellidoMa;
    }

    public String getApellidoMa() {
        return apellidoMa;
    }

    public void setFecha_nacimiento(String feNac) {
        this.feNac = feNac;
    }

    public String getFecha_nacimiento() {
        return feNac;
    }

    /**
     * Genera el RFC del ciudadano a partir de sus datos personales.
     *
     * @param nombre Nombre
     * @param apellidoPa Apellido paterno
     * @param apellidoMa Apellido materno
     * @param feNac Fecha de nacimiento (DD/MM/AAAA)
     * @return Cadena con el RFC generado
     */
    public String GenerarRFC(String nombre, String apellidoPa, String apellidoMa, String feNac) {
        nombre = nombre.toUpperCase();
        apellidoPa = apellidoPa.toUpperCase();
        apellidoMa = apellidoMa.toUpperCase();

        char nom = nombre.charAt(0);
        char ap = apellidoPa.charAt(0);
        char ap2 = apellidoPa.charAt(1);
        char apm = apellidoMa.charAt(0);
        String dia = feNac.substring(0, 2);
        String mes = feNac.substring(3, 5);
        String anio = feNac.substring(8, 10);
        String val = "XXX";

        return "" + ap + ap2 + apm + nom + anio + mes + dia + val;
    }

    /**
     * Identifica si un RFC corresponde a una persona física o moral.
     *
     * @param rfc Cadena del RFC
     * @return Tipo de contribuyente ("Persona Física", "Persona Moral" o "Desconocido")
     */
    public String identificarContribuyente(String rfc) {
        if (rfc == null) return "Desconocido";

        int longitud = rfc.trim().length();

        if (longitud == 13) {
            return "Persona Física";
        } else if (longitud == 12) {
            return "Persona Moral";
        } else {
            return "Desconocido";
        }
    }

    /**
     * Calcula el ISR según el tipo de contribuyente.
     *
     * @param rfc RFC del ciudadano o empresa
     * @param ingreso Ingreso declarado
     * @return Monto del ISR calculado
     */
    public double calcularISR(String rfc, double ingreso) {
        String tipo = identificarContribuyente(rfc);

        if (tipo.equals("Persona Física")) {
            return ingreso * 0.10;
        } else if (tipo.equals("Persona Moral")) {
            return ingreso * 0.30;
        } else {
            System.out.println("No es persona contribuyente");
            return 0.0;
        }
    }

    /**
     * Calcula la cuota del seguro social dependiendo del tipo de contribuyente.
     *
     * @param rfc RFC del ciudadano o empresa
     * @param salarioMensual Salario mensual
     * @return Cuota calculada
     */
    public double calcularCuota(String rfc, double salarioMensual) {
        String tipo = identificarContribuyente(rfc);

        if (tipo.equals("Persona Física")) {
            return salarioMensual * 0.07;
        } else if (tipo.equals("Persona Moral")) {
            return salarioMensual * 0.15;
        } else {
            System.out.println("RFC inválido o desconocido para calcular seguro social.");
            return 0.0;
        }
    }

    /**
     * Genera el CURP del ciudadano a partir de sus datos.
     *
     * @param nombre Nombre
     * @param apPa Apellido paterno
     * @param apMa Apellido materno
     * @param feNac Fecha de nacimiento (DD/MM/AAAA)
     * @param sexo Sexo ('H' o 'M')
     * @param estado Estado de nacimiento
     * @return CURP generado
     */
    public String generarCURP(String nombre, String apPa, String apMa, String feNac, char sexo, String estado) {
        nombre = nombre.toUpperCase();
        apPa = apPa.toUpperCase();
        apMa = apMa.toUpperCase();
        estado = estado.toUpperCase();
        sexo = Character.toUpperCase(sexo);

        char apeP = apPa.charAt(0);
        char vocPa = buscarVocal(apPa);
        char apeMa = apMa.charAt(0);
        char iniNom = nombre.charAt(0);

        String dia = feNac.substring(0, 2);
        String mes = feNac.substring(3, 5);
        String anio = feNac.substring(8, 10);

        char consP = buscarConsonante(apPa);
        char consM = buscarConsonante(apMa);
        char consN = buscarConsonante(nombre);

        String val = "XX";

        return "" + apeP + vocPa + apeMa + iniNom + anio + mes + dia +
                sexo + obtenerCodigoEstado(estado) + consP + consM + consN + val;
    }

    /**
     * Busca la primera vocal interna (no inicial) en una cadena.
     *
     * @param texto Texto a analizar
     * @return Primera vocal encontrada o 'X' si no hay
     */
    public char buscarVocal(String texto) {
        for (int i = 1; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if ("AEIOU".indexOf(c) != -1) {
                return c;
            }
        }
        return 'X';
    }

    /**
     * Busca la primera consonante interna (no inicial) en una cadena.
     *
     * @param texto Texto a analizar
     * @return Consonante encontrada o 'X'
     */
    public char buscarConsonante(String texto) {
        for (int i = 1; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if ("AEIOU".indexOf(c) == -1 && Character.isLetter(c)) {
                return c;
            }
        }
        return 'X';
    }

    /**
     * Devuelve el código del estado en formato oficial para el CURP.
     *
     * @param estado Nombre del estado
     * @return Código de dos letras correspondiente al estado
     */
    public String obtenerCodigoEstado(String estado) {
        switch (estado) {
            case "AGUASCALIENTES": return "AS";
            case "BAJA CALIFORNIA": return "BC";
            case "BAJA CALIFORNIA SUR": return "BS";
            case "CAMPECHE": return "CC";
            case "COAHUILA": return "CL";
            case "COLIMA": return "CM";
            case "CHIAPAS": return "CS";
            case "CHIHUAHUA": return "CH";
            case "CIUDAD DE MEXICO": return "DF";
            case "DURANGO": return "DG";
            case "GUANAJUATO": return "GT";
            case "GUERRERO": return "GR";
            case "HIDALGO": return "HG";
            case "JALISCO": return "JC";
            case "MEXICO": return "MC";
            case "MICHOACAN": return "MN";
            case "MORELOS": return "MS";
            case "NAYARIT": return "NT";
            case "NUEVO LEON": return "NL";
            case "OAXACA": return "OC";
            case "PUEBLA": return "PL";
            case "QUERETARO": return "QT";
            case "QUINTANA ROO": return "QR";
            case "SAN LUIS POTOSI": return "SP";
            case "SINALOA": return "SL";
            case "SONORA": return "SR";
            case "TABASCO": return "TC";
            case "TAMAULIPAS": return "TS";
            case "TLAXCALA": return "TL";
            case "VERACRUZ": return "VZ";
            case "YUCATAN": return "YN";
            case "ZACATECAS": return "ZS";
            case "NACIDO EN EL EXTRANJERO": return "NE";
            default: return "XX";
        }
    }

    /**
     * Genera un carácter aleatorio como penúltimo dígito del CURP, dependiendo del año.
     *
     * @param fechaNacimiento Fecha de nacimiento en formato DD/MM/AAAA
     * @return Carácter al azar dependiendo del año (letra si es >=2000)
     */
    public static char obtenerPenultimo(String fechaNacimiento) {
        int feNac = Integer.parseInt(fechaNacimiento.substring(6, 10));

        if (feNac >= 2000) {
            String letras = "ABCDEFGHIJ";
            int pos = (int)(Math.random() * letras.length());
            return letras.charAt(pos);
        } else {
            int num = (int)(Math.random() * 10);
            return Integer.toString(num).charAt(0);
        }
    }

    /**
     * Genera un último carácter numérico aleatorio para el CURP.
     *
     * @return Dígito aleatorio del 0 al 9
     */
    public static char obtenerUltimoCaracter() {
        int num = (int)(Math.random() * 10);
        return Integer.toString(num).charAt(0);
    }
}
