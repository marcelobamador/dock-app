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
			returnDTO.setPVERFM(termEntity.getPVERFM());
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
		returnDTO.setPVERFM(terminalEntity.getPVERFM());
		returnDTO.setSam(terminalEntity.getSam());
		returnDTO.setSerial(terminalEntity.getSerial());
		returnDTO.setVersion(terminalEntity.getVersion());
		return returnDTO;
	}
	
	public static TerminalEntity converString(String body) {
		String array[] = new String[10];
		array = body.split(";");
		TerminalEntity terminalEntity = new TerminalEntity();
		terminalEntity.setLogic(Integer.parseInt(array[0]));
		terminalEntity.setSerial(array[1]);
		terminalEntity.setModel(array[2]);
		terminalEntity.setSam(Integer.parseInt(array[3]));
		terminalEntity.setPtid(array[4]);
		terminalEntity.setPlat(Integer.parseInt(array[5]));
		terminalEntity.setVersion(array[6]);
		terminalEntity.setMxr(Integer.parseInt(array[7]));
		terminalEntity.setMxf(Integer.parseInt(array[8]));
		terminalEntity.setPVERFM(array[9]);
		return terminalEntity;
	}
}
