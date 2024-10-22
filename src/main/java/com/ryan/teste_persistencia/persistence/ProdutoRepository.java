package com.ryan.teste_persistencia.persistence;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ryan.teste_persistencia.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    Optional<Produto> findByNome(String nome);
}

