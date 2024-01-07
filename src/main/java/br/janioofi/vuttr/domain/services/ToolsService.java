package br.janioofi.vuttr.domain.services;

import br.janioofi.vuttr.domain.entities.Tools;
import br.janioofi.vuttr.domain.repositories.ToolsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToolsService {

    private final ToolsRepository repository;

    public ToolsService(ToolsRepository repository) {
        this.repository = repository;
    }

    public List<Tools> findAll(){
        return repository.findAll();
    }
}
