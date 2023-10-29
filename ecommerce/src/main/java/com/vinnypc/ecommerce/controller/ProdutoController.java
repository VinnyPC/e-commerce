package com.vinnypc.ecommerce.controller;

import com.vinnypc.ecommerce.entitites.Produto;
import com.vinnypc.ecommerce.repository.ProdutoRepository;
import com.vinnypc.ecommerce.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    ProdutoService produtoService;

    @GetMapping
    public List<Produto> getAll(){
        return produtoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Produto> getById(@PathVariable("id") Long id){
        return produtoRepository.findById(id);
    }

    @PostMapping
    public Produto create(@RequestBody Produto produto){
        return produtoRepository.save(produto);
    }

    @PutMapping("/{id}")
    public Produto update(@PathVariable("id") Long id, @RequestBody Produto produto){
        return produtoService.update(id, produto);
    }

    @DeleteMapping("/{id}")
    public Produto delete(@PathVariable("id") Long id){
        return produtoService.delete(id);
    }




}
