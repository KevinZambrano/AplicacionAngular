/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.keanzato.app.exceptions;

/**
 *
 * @author Kevin Zambrano
 */
public class ConexionException extends RuntimeException {

	private static final long serialVersionUID = -1889162374796376031L;

	/**
	 * @param message
	 * @param cause
	 */
	public ConexionException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public ConexionException(String message) {
		super(message);
	}
	
	
	
	
}
