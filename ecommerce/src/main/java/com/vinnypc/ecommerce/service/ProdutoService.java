package com.vinnypc.ecommerce.service;

import com.vinnypc.ecommerce.entitites.Produto;
import com.vinnypc.ecommerce.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService{

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto update(Long id, Produto produto){
        Produto updated = produtoRepository.findById(id).get();
        updated.setNome(produto.getNome());
        updated.setQuantidade(produto.getQuantidade());

        return produtoRepository.save(updated);
    }

    public Produto delete(Long id){
        Produto produto = produtoRepository.findById(id).get();
        produtoRepository.deleteById(id);
        return produto;
    }

}
