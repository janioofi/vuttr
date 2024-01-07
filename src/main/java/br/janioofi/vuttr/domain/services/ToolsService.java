package br.janioofi.vuttr.domain.services;

import br.janioofi.vuttr.domain.DTO.ToolsDto;
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

    public Tools create(ToolsDto tools){
        Tools data = new Tools();
        data.setDescription(tools.description());
        data.setLink(tools.link());
        data.setTitle(tools.title());
        data.setTags(tools.tags());
        return repository.save(data);
    }
}
