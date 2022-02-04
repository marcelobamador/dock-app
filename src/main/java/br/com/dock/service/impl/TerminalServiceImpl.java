package br.com.dock.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.dock.model.TerminalEntity;
import br.com.dock.repository.TerminalRepository;
import br.com.dock.request.ChangeTerminalRequest;
import br.com.dock.service.TerminalService;
import br.com.dock.util.Util;

import static java.util.Objects.isNull;

@Service
public class TerminalServiceImpl implements TerminalService {
	
	TerminalRepository terminalRepository;
	
	public TerminalServiceImpl(TerminalRepository terminalRepository) {
		this.terminalRepository = terminalRepository;
	}

	public List<TerminalEntity> getAllTerminals() {
		return this.terminalRepository.findAll();
	}

	public TerminalEntity getAllTerminalsById(Integer id) {
		return this.terminalRepository.getById(id);
	}
	
	@Transactional
	public TerminalEntity changeTerminal(Integer id, ChangeTerminalRequest changeTerminal) {
		TerminalEntity terminalEntityDb = this.terminalRepository.getById(id);
		
		if (isNull(terminalEntityDb)) {
			return null;
		}
		
		terminalEntityDb.setModel(changeTerminal.getModel());
		terminalEntityDb.setSerial(changeTerminal.getSerial());
		terminalEntityDb.setVersion(changeTerminal.getVersion());
		
		if(changeTerminal.getMxf() != null)
			terminalEntityDb.setMxf(changeTerminal.getMxf());
		
		if(changeTerminal.getMxr() != null)
			terminalEntityDb.setMxr(changeTerminal.getMxr());
		
		if(changeTerminal.getPlat() != null)
			terminalEntityDb.setPlat(changeTerminal.getPlat());
		
		if(changeTerminal.getPtid() == null || !changeTerminal.getPtid().isEmpty())
			terminalEntityDb.setPtid(changeTerminal.getPtid());
		
		if(changeTerminal.getPVERFM() == null || !changeTerminal.getPVERFM().isEmpty())
			terminalEntityDb.setPVERFM(changeTerminal.getPVERFM());
		
		if(changeTerminal.getSam() != null)
			terminalEntityDb.setSam(changeTerminal.getSam());
		
		return this.terminalRepository.save(terminalEntityDb);
	}
	
	public TerminalEntity addTerminal(String body) {
		TerminalEntity terminalEntity = Util.converString(body);
		return this.terminalRepository.save(terminalEntity);
	}

}
