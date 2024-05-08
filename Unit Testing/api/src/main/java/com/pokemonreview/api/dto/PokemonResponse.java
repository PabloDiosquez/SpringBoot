package com.pokemonreview.api.dto;

import com.pokemonreview.api.models.Pokemon;
import lombok.Data;
import lombok.val;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
public class PokemonResponse {
    private List<PokemonDTO> content;
    private int pageNo;
    private int pageSize;
    private int totalElements;
    private int totalPages;
    private boolean last;

    public PokemonResponse(Page<Pokemon> pageable, List<PokemonDTO> pokemonsDTO){
        this.content = pokemonsDTO;
        this.pageNo = pageable.getNumber();
        this.pageSize = pageable.getSize();
        this.totalElements = pageable.getNumberOfElements();
        this.totalPages = pageable.getTotalPages();
        this.last = pageable.isLast();
    }
}
