package com.luizfelipe.locadora.services;

import com.luizfelipe.locadora.dao.FilmeRepository;
import com.luizfelipe.locadora.model.dto.FilmeDTO;
import com.luizfelipe.locadora.model.entity.Filme;
import com.luizfelipe.locadora.util.MapperUtil;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class FilmeService {

    private final FilmeRepository filmeRepository;

    public FilmeService(FilmeRepository filmeRepository) {
        this.filmeRepository = filmeRepository;
    }

    public List<FilmeDTO> getFilmes(){
        List<Filme> all = filmeRepository.findAll();

        FilmeDTO filmeDTO = MapperUtil.mapper(all.stream().findFirst().get(), FilmeDTO.class);

        List<FilmeDTO> mapper = MapperUtil.mapper(filmeRepository.findAll(), FilmeDTO.class);
        return mapper;
    }

    public Filme addFilmes(Filme filme) {
        return filmeRepository.save(filme);
    }

    public void deleteFilme(Integer idFilme) {
        Optional<Filme> existe = filmeRepository.findById(idFilme);
        if(!existe.isPresent()){
            throw new IllegalStateException("O filme de id="+idFilme+" não existe");
        }
        filmeRepository.deleteById(idFilme);
    }

    @Transactional
    public void updateFilme(Integer idFilme, String nome, String diretor, Integer ano) {
        Filme filme = filmeRepository.findById(idFilme).orElseThrow(() ->
                new IllegalStateException("O filme de id="+idFilme+" não existe"));

        if(nome != null &&
                nome.length() >0 &&
                !Objects.equals(filme.getNome(), nome)){
            filme.setNome(nome);
        }
        if(diretor != null &&
                diretor.length() >0 &&
                !Objects.equals(filme.getDiretor(), diretor)){
            filme.setDiretor(diretor);
        }
        if(ano != null && !Objects.equals(filme.getAno(), ano)){
            filme.setAno(ano);
        }
    }
}
