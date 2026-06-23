package br.edu.ifsc.pps.gv.exceptions;

public class InvalidEntityException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public InvalidEntityException(String message) {
		super(message);
	}
}
