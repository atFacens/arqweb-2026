package br.facens.minhaloja.repository;

import org.springframework.data.repository.CrudRepository;

import br.facens.minhaloja.model.Produto;

// CRUD = Create, Read, Update, Delete
public interface ProdutoRepository extends CrudRepository<Produto, Integer> {


}
