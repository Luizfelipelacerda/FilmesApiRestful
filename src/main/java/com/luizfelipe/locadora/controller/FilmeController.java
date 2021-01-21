package com.luizfelipe.locadora.controller;

import com.luizfelipe.locadora.services.FilmeService;
import com.luizfelipe.locadora.model.dto.FilmeDTO;
import com.luizfelipe.locadora.model.entity.Filme;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.WebApplicationType;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path="api/v1/filme")
@RequiredArgsConstructor
public class FilmeController {

    private final FilmeService filmeService;

    @CrossOrigin
    @GetMapping
    public List<FilmeDTO> getFilmes(){
        return this.filmeService.getFilmes();
    }

    @PostMapping
    public Filme addNewFilme(@RequestBody Filme filme){
        return this.filmeService.addFilmes(filme);
    }

    @DeleteMapping(path = "{idFilme}")
    public void deleteFilme(@PathVariable("idFilme") Integer id){
        this.filmeService.deleteFilme(id);
    }

    @PutMapping(path = "{id}")
    public void updateFilme(@Valid @RequestBody FilmeDTO filmeDTO){

        this.filmeService.updateFilme(filmeDTO.getId(),
                                        filmeDTO.getNome(),
                                        filmeDTO.getDiretor(),
                                        filmeDTO.getAno());
    }


}
