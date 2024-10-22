package com.ryan.teste_persistencia;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.ryan.teste_persistencia.model.Produto;
import com.ryan.teste_persistencia.persistence.ProdutoRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class ProdutoRepositoryTest {

    @Autowired
    private ProdutoRepository produtoRepository;

    @BeforeEach
    public void limparBanco() {
        produtoRepository.deleteAll();
    }

    @Test
    public void testPersistenciaProduto() {
        Produto produto = new Produto("Caneta", 2.50);
        produtoRepository.save(produto);

        Optional<Produto> encontradoPorId = produtoRepository.findById(produto.getCodigo());
        assertTrue(encontradoPorId.isPresent());
        assertEquals("Caneta", encontradoPorId.get().getNome());

        Optional<Produto> encontradoPorNome = produtoRepository.findByNome("Caneta");
        assertTrue(encontradoPorNome.isPresent());
        assertEquals(2.50, encontradoPorNome.get().getPreco());
    }
}