package com.GestionVacunas.Utils;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ModelUtil {

	/**
	 * Metodo para validación de String vacios
	 * 
	 * @param cadena
	 * @return
	 */
	public static boolean verificarStringVacio(String cadena) {
		if (cadena.isEmpty() || cadena == null)
			return true;
		return false;
	}

	public static boolean verificarFechaNull(Date fecha) {
		if (fecha == null)
			return true;
		return false;
	}

	/**
	 * 
	 * Metodo para comprobar si los caracteres introducidos en una cadena son
	 * 
	 * SOLO letras o no.
	 * 
	 * @param cadena String a comprobar
	 * 
	 * @return true si solo contiene letras, false en caso contrario
	 * 
	 */

	public static boolean esSoloLetras(String cadena) {
		// Recorremos cada caracter de la cadena y comprobamos si son letras.

		// Para comprobarlo, lo pasamos a mayuscula y consultamos su numero ASCII.

		// Si está fuera del rango 65 - 90, es que NO son letras.

		// Para ser más exactos al tratarse del idioma español, tambien comprobamos

		// el valor 165 equivalente a la Ñ
		for (int i = 0; i < cadena.length(); i++) {
			char caracter = cadena.toUpperCase().charAt(i);

			int valorASCII = (int) caracter;

			if (valorASCII != 32 && valorASCII != 165 && (valorASCII < 65 || valorASCII > 90))

				return false; // Se ha encontrado un caracter que no es letra

		}
		// Terminado el bucle sin que se hay retornado false, es que todos los
		// caracteres son letras
		return true;
	}

	/**
	 * Valida si es correcta la dirección de correo electrónica dada.
	 * 
	 * @param email
	 * @return true si es correcta o false si no lo es.
	 * @throws Exception
	 */
	public static void esEmailCorrecto(String email) throws Exception {
		// Patrón para validar el email
		Pattern pattern = Pattern.compile(
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

		Matcher mather = pattern.matcher(email);

		if (!mather.find())
			throw new Exception("112");
	}

	/**
	 * Metodo para validadicón de cedula ecuatoriana.
	 * 
	 * @param idCard
	 * @return
	 * @throws Exception
	 */
	public static boolean verificarCedulaEcuador(String idCard) throws Exception {
		int suma = 0;
		if (idCard.length() != 10) {
			throw new Exception("110");
		} else {
			int a[] = new int[idCard.length() / 2];
			int b[] = new int[(idCard.length() / 2)];
			int c = 0;
			int d = 1;
			for (int i = 0; i < idCard.length() / 2; i++) {
				a[i] = Integer.parseInt(String.valueOf(idCard.charAt(c)));
				c = c + 2;
				if (i < (idCard.length() / 2) - 1) {
					b[i] = Integer.parseInt(String.valueOf(idCard.charAt(d)));
					d = d + 2;
				}
			}
			for (int i = 0; i < a.length; i++) {
				a[i] = a[i] * 2;
				if (a[i] > 9) {
					a[i] = a[i] - 9;
				}
				suma = suma + a[i] + b[i];
			}
			int aux = suma / 10;
			int dec = (aux + 1) * 10;
			if ((dec - suma) == Integer.parseInt(String.valueOf(idCard.charAt(idCard.length() - 1))))
				return true;
			else if (suma % 10 == 0 && idCard.charAt(idCard.length() - 1) == '0') {
				return true;
			} else {
				throw new Exception("111");
			}
		}
	}
}
