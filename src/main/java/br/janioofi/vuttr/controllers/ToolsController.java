package br.janioofi.vuttr.controllers;

import br.janioofi.vuttr.domain.DTO.ToolsDto;
import br.janioofi.vuttr.domain.entities.Tools;
import br.janioofi.vuttr.domain.services.ToolsService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Tools", description = "API Tools")
@RestController
@RequestMapping("/tools")
public class ToolsController {
    private final ToolsService service;

    public ToolsController(ToolsService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Tools>> findAll(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @PostMapping
    public ResponseEntity<Tools> create(@RequestBody ToolsDto tools){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(tools));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/tag")
    public ResponseEntity<List<Tools>> findByTag(@RequestParam String tag){
        return ResponseEntity.ok().body(service.findByTag(tag));
    }
}
