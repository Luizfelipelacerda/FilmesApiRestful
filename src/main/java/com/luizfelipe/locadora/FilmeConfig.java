package com.luizfelipe.locadora;

import com.luizfelipe.locadora.dao.FilmeRepository;
import com.luizfelipe.locadora.model.entity.Filme;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class FilmeConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            FilmeRepository repository) {
        return args -> {
            Filme brzinhas = new Filme(
                    1,
                    "brasileirinhas",
                    "frota",
                    2010
            );
            Filme tropical = new Filme(
                    2,
                    "tropical thunder",
                    "sei la",
                    2010
            );
            Filme batman = new Filme(
                    3,
                    "batman",
                    "nolan",
                    2012
            );

            repository.saveAll(
                    List.of(brzinhas, tropical, batman)
            );
        };
    }



}
