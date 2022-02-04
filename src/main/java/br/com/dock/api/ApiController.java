package br.com.dock.api;

import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.Produces;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.dock.model.TerminalEntity;
import br.com.dock.request.ChangeTerminalRequest;
import br.com.dock.service.TerminalService;

@RestController
@RequestMapping("v1/terminals")
public class ApiController {

	TerminalService terminalService;

	public ApiController(TerminalService terminalService) {
		this.terminalService = terminalService;
	}

	@GetMapping
	public List<TerminalEntity> getAllTerminals() {
		return terminalService.getAllTerminals();
	}

	@GetMapping("/{id}")
	public TerminalEntity getAllTerminalsById(@PathVariable Integer id) {
		return terminalService.getAllTerminalsById(id);
	}

	@PatchMapping("/{id}")
	public TerminalEntity changeTerminal(@PathVariable Integer id,
			@Valid @RequestBody ChangeTerminalRequest changeTerminal) {
		return terminalService.changeTerminal(id, changeTerminal);
	}

	@PostMapping(value = "", consumes = MediaType.TEXT_HTML_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	@Produces(MediaType.TEXT_HTML_VALUE)
	public TerminalEntity addTerminal(@RequestBody String body) {
		return terminalService.addTerminal(body);
	}

}
