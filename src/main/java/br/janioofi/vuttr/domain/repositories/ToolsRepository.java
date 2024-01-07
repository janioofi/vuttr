package br.janioofi.vuttr.domain.repositories;

import br.janioofi.vuttr.domain.entities.Tools;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToolsRepository extends JpaRepository<Tools, Long> {
}
