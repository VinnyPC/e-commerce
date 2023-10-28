package com.vinnypc.ecommerce.repository;

import com.vinnypc.ecommerce.entitites.Produto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
public interface ProdutoRepository extends MongoRepository<Produto, Long> {
}