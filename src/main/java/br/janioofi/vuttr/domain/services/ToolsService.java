package br.janioofi.vuttr.domain.services;

import br.janioofi.vuttr.domain.DTO.ToolsDto;
import br.janioofi.vuttr.domain.entities.Tools;
import br.janioofi.vuttr.domain.repositories.ToolsRepository;
import br.janioofi.vuttr.exceptions.RecordNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ToolsService {
    private final ToolsRepository repository;

    public List<Tools> findAll(){
        return repository.findAll();
    }

    public Tools create(ToolsDto tools){
        Tools data = new Tools();
        data.setDescription(tools.description());
        data.setLink(tools.link());
        data.setTitle(tools.title());
        data.setTags(tools.tags().stream().map(e ->  e.toLowerCase()).toList());
        return repository.save(data);
    }

    public List<Tools> findByTag(String tag){
        return repository.findToolsByTagsContains(tag);
    }

    public void deleteById(Long id){
        if(repository.findById(id).isEmpty()){
            throw new RecordNotFoundException(id);
        }
        repository.deleteById(id);
    }

    public Tools findById(Long id){
        return repository.findById(id).orElseThrow(() -> {
            throw new RecordNotFoundException(id);
        });
    }
}
