package br.janioofi.vuttr.domain.repositories;

import br.janioofi.vuttr.domain.entities.Tools;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ToolsRepository extends JpaRepository<Tools, Long> {
    List<Tools> findToolsByTagsContains(String tag);
}
