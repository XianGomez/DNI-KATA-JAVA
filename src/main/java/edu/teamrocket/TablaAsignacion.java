package edu.teamrocket;

public class TablaAsignacion {
    
    public char[] tabla = {'T', 'R', 'W', 'A', 'G', 'M', 
					 		'Y', 'F', 'P', 'D', 'X', 'B', 
							'N', 'J', 'Z', 'S', 'Q', 'V', 
							'H', 'L', 'C', 'K', 'E'};

    public TablaAsignacion() {};

    public char getLetra(int posicion) {        
        return this.tabla[posicion];
    }

    public boolean isLetraPermitida(char letra) {
        return new String(this.tabla).indexOf(letra) != -1;
    }

    public int getModulo() {
        return this.tabla.length;
    }

    public char calcularLetra(String DNI){
        int dni = Integer.parseInt(DNI);
		int posicion = dni % getModulo();
		return getLetra(posicion);
    }

    
}
