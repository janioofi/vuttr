package br.janioofi.vuttr.domain.DTO;

import java.util.List;

public record ToolsDto(
        String title,
        String link,
        String description,
        List<String> tags) {
}
