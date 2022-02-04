package br.com.dock.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import br.com.dock.beans.JsonSchemaBean;
import br.com.dock.exception.DuplicatedTerminalException;
import br.com.dock.exception.JsonValidationException;
import br.com.dock.model.TerminalEntity;
import br.com.dock.repository.TerminalRepository;
import br.com.dock.request.ChangeTerminalRequest;
import br.com.dock.service.TerminalService;
import br.com.dock.util.Util;

import static java.util.Objects.isNull;
import static br.com.dock.consts.DockConstants.*;

@Service
public class TerminalServiceImpl implements TerminalService {
	
	@Autowired
	private JsonSchemaBean jsonBean;
	
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
		JSONObject jsonObject = parseStringToJsonObject(body);
		jsonBean.validateJson(jsonObject, TERMINAL_SCHEMA);
		TerminalEntity terminalEntity = parseJsonObjectToEntity(jsonObject);
		
		if(existsTerminal(terminalEntity.getLogic())) {
			throw new DuplicatedTerminalException("Terminal already exists with logic: " + terminalEntity.getLogic());
		}
		
		return this.terminalRepository.save(terminalEntity);
	}
	
	private JSONObject parseStringToJsonObject(String payload) {
        String[] splitPayload = payload.split(SPLIT_DELIMITER);

        try {
            JSONObject jsonObject = new JSONObject();

            jsonObject.put(JSON_OBJECT_LOGIC, Integer.parseInt(splitPayload[JSON_OBJECT_INDEX_LOGIC]));
            jsonObject.put(JSON_OBJECT_SERIAL, splitPayload[JSON_OBJECT_INDEX_SERIAL]);
            jsonObject.put(JSON_OBJECT_MODEL, splitPayload[JSON_OBJECT_INDEX_MODEL]);
            jsonObject.put(JSON_OBJECT_SAM, Integer.parseInt(splitPayload[JSON_OBJECT_INDEX_SAM]));
            jsonObject.put(JSON_OBJECT_PTID, splitPayload[JSON_OBJECT_INDEX_PTID]);
            jsonObject.put(JSON_OBJECT_PLAT, Integer.parseInt(splitPayload[JSON_OBJECT_INDEX_PLAT]));
            jsonObject.put(JSON_OBJECT_VERSION, splitPayload[JSON_OBJECT_INDEX_VERSION]);
            jsonObject.put(JSON_OBJECT_MXR, Integer.parseInt(splitPayload[JSON_OBJECT_INDEX_MXR]));
            jsonObject.put(JSON_OBJECT_MXF, Integer.parseInt(splitPayload[JSON_OBJECT_INDEX_MXF]));
            jsonObject.put(JSON_OBJECT_VERFM, splitPayload[JSON_OBJECT_INDEX_VERFM]);

            return jsonObject;
        } catch (Exception e) {
            throw new JsonValidationException(e.getMessage());
        }
    }
	
	private TerminalEntity parseJsonObjectToEntity(JSONObject jsonObject) {
        return new Gson().fromJson(jsonObject.toString(), TerminalEntity.class);
    }
	
	public boolean existsTerminal(int logic) {
        return terminalRepository.findById(logic).isPresent();
    }

}
