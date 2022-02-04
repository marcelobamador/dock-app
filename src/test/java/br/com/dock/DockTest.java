package br.com.dock;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.dock.model.TerminalEntity;
import br.com.dock.repository.TerminalRepository;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class DockTest {

	@Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private TerminalRepository repository;
    
    @Test
    public void getAllTerminalsTest() {
        ResponseEntity<TerminalEntity[]> response = this.testRestTemplate
            .exchange("/v1/terminals", HttpMethod.GET, null, TerminalEntity[].class);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }
    
    @Test
    public void getAllTerminalsByIdTest() {
    	
    	TerminalEntity entity = new TerminalEntity();
    	entity.setLogic(55443322);
    	entity.setModel("PWWIN");
    	entity.setMxf(16777216);
    	entity.setMxr(0);
    	entity.setPlat(4);
    	entity.setPtid("F04A2E4088B");
    	entity.setPVERFM("PWWIN");
    	entity.setSam(0);
    	entity.setSerial("123");
    	entity.setVersion("8.00b3");
    	
    	TerminalEntity entityDB = this.repository.save(entity);
    	
        ResponseEntity<TerminalEntity> response = this.testRestTemplate
            .exchange("/v1/terminals/" + entityDB.getLogic(), HttpMethod.GET, null, TerminalEntity.class);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }
    
    @Test
    public void changeTerminalTest() {
    	
    	String body = "55223300;123;PWWIN;0;F04A2E4088B;4;8.00b3;0;16777216;PWWIN";
    	
    	HttpEntity<String> httpEntity = new HttpEntity<>(body);
    	
        ResponseEntity<TerminalEntity> response = this.testRestTemplate
            .exchange("/v1/terminals/", HttpMethod.POST, httpEntity, TerminalEntity.class);
        assertEquals(response.getStatusCode(), HttpStatus.CREATED);
    }
}
