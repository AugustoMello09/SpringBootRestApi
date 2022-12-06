package io.github.AugustoMello09.exception;

public class NegocioException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public NegocioException(String message) {
		super(message);
	}

}
