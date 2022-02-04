package br.com.dock.service;

import java.util.List;

import br.com.dock.model.TerminalEntity;
import br.com.dock.request.ChangeTerminalRequest;

public interface TerminalService {
	
	List<TerminalEntity> getAllTerminals();
	
	TerminalEntity getAllTerminalsById(Integer id);
	
	TerminalEntity changeTerminal(Integer id, ChangeTerminalRequest changeTerminal);
	
	TerminalEntity addTerminal(String body);

}
