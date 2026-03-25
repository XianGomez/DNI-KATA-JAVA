package edu.teamrocket;

public class Dni {

    private final String dni;
    private Boolean numeroSano = false;
    private Boolean letraSana = false;
    private Boolean dniCifSano = false;
    private final byte LONGITUD_DNI = 9;
    
    // Relación de composición: "Dni tiene una TablaAsignacion"
    private TablaAsignacion tabla = new TablaAsignacion();

    public Dni(String dni) {
        this.dni = dni;
    }

    private String getDni() {
        return this.dni;
    }

    private void setNumeroSano(Boolean valor) {
        this.numeroSano = valor;
    }

    private Boolean isNumeroSano() {
        return this.numeroSano;
    }

    private void setLetraSana(Boolean valor) {
        this.letraSana = valor;
    }

    private Boolean isLetraSana() {
        return this.letraSana;
    }

    public Boolean checkDni() {
        setDniSano(checkNumeroDni() && checkLetra());
        return isDniSano();
    }

    private void setDniSano(Boolean valor) {
        this.dniCifSano = valor;
    }

    private Boolean isDniSano() {
        return this.dniCifSano;
    }
    
    private TablaAsignacion getTablaAsignacion(){
        return this.tabla;
    }

    
    @Override
    public String toString() {
        return getDni();
    }

    

    public Boolean checkNumeroDni() {
        setNumeroSano(checkLongitudDni() 
                        && isDniNumero(extraerParteNumericaDni()));
        return isNumeroSano();
    }

    public Boolean checkLetra() {
        if (checkNumeroDni()) {
            // Verificamos que sea mayúscula y que sea la letra que corresponde legalmente
            setLetraSana(Character.isUpperCase(extraerParteAlfabeticaDni()) 
                            && checkLetraValida());
            return isLetraSana();
        } else {
            return false;
        }
    }

    public Character obtenerLetra() {
        // Solo calculamos si la parte numérica es válida
        if (checkNumeroDni()) {
            return getTablaAsignacion().calcularLetra(extraerParteNumericaDni());
        } else {
            // Valor nulo/vacío si el DNI no permite cálculo
            return Character.MIN_VALUE;
        }
    }

    /*
     * Implementación interna
     */

    private Boolean checkLongitudDni() {
        return getDni().length() == this.LONGITUD_DNI;
    }

    public Boolean isDniNumero(String cadena) {
        for (int i = 0; i < cadena.length(); i++) {
            if (!Character.isDigit(cadena.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public String extraerParteNumericaDni() {
        // substring devuelve un String, no hace falta (String) delante
        return dni.substring(0, dni.length() - 1);
    }

    public Character extraerParteAlfabeticaDni() {
        return dni.charAt(dni.length() - 1);
    }

    private Boolean checkLetraValida() {
        // Comparamos la letra del String con la letra calculada por la Tabla
        return extraerParteAlfabeticaDni().equals(obtenerLetra());
    }
}
