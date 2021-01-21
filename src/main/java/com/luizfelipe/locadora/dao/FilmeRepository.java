package com.luizfelipe.locadora.dao;

import com.luizfelipe.locadora.model.entity.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Integer> {



    @Query("SELECT f " +
            "FROM Filme f " +
            "WHERE 1=1 " +
            "AND f.id = :id")
    Optional<Filme> findById(@Param("id") Integer id);

}
