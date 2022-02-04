package br.com.dock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.dock.model.TerminalEntity;

@Repository
public interface TerminalRepository extends JpaRepository<TerminalEntity, Integer>{

	@Query(value = "SELECT * FROM TERMINAL t WHERE t.logic = ?1", 
			  nativeQuery = true)
	TerminalEntity getTerminal(Integer id);
}
