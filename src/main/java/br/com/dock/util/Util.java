package br.com.dock.util;

import java.util.ArrayList;
import java.util.List;

import br.com.dock.dto.TerminalDTO;
import br.com.dock.model.TerminalEntity;

public class Util {
	public static List<TerminalDTO> parseFindAllTerminalsList(List<TerminalEntity> terminalEntity) {
		List<TerminalDTO> listReturn = new ArrayList<TerminalDTO>();
		TerminalDTO returnDTO;
		for(TerminalEntity termEntity : terminalEntity) {
			returnDTO = new TerminalDTO();
			returnDTO.setLogic(termEntity.getLogic());
			returnDTO.setModel(termEntity.getModel());
			returnDTO.setMxf(termEntity.getMxf());
			returnDTO.setMxr(termEntity.getMxr());
			returnDTO.setPlat(termEntity.getPlat());
			returnDTO.setPtid(termEntity.getPtid());
			returnDTO.setPVERFM(termEntity.getPverfm());
			returnDTO.setSam(termEntity.getSam());
			returnDTO.setSerial(termEntity.getSerial());
			returnDTO.setVersion(termEntity.getVersion());
			listReturn.add(returnDTO);
		}
		
		return listReturn;
	}
	
	public static TerminalDTO parseFindAllTerminals(TerminalEntity terminalEntity) {
		TerminalDTO returnDTO = new TerminalDTO();
		returnDTO.setLogic(terminalEntity.getLogic());
		returnDTO.setModel(terminalEntity.getModel());
		returnDTO.setMxf(terminalEntity.getMxf());
		returnDTO.setMxr(terminalEntity.getMxr());
		returnDTO.setPlat(terminalEntity.getPlat());
		returnDTO.setPtid(terminalEntity.getPtid());
		returnDTO.setPVERFM(terminalEntity.getPverfm());
		returnDTO.setSam(terminalEntity.getSam());
		returnDTO.setSerial(terminalEntity.getSerial());
		returnDTO.setVersion(terminalEntity.getVersion());
		return returnDTO;
	}
}
