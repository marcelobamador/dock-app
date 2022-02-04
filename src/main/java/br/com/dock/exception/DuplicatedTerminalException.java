package br.com.dock.exception;

public class DuplicatedTerminalException  extends RuntimeException {
	public DuplicatedTerminalException(String message) {
        super(message);
    }
}
