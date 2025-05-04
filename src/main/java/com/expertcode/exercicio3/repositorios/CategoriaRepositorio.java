package com.expertcode.exercicio3.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.expertcode.exercicio3.entidades.Categoria;

@Repository
public interface CategoriaRepositorio extends JpaRepository<Categoria, Long>{

}
