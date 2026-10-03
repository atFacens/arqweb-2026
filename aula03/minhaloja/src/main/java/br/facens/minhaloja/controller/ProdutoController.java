package br.facens.minhaloja.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.facens.minhaloja.model.Produto;
import br.facens.minhaloja.model.dto.ProdutoDTO;
import br.facens.minhaloja.service.ProdutoService;

@RestController // É um Controller REST
@RequestMapping("/produto")
public class ProdutoController { // Bean

    private ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> getProduto(@PathVariable int id) {
        Optional<Produto> optProduto = service.getProduto(id);

        if (optProduto.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(optProduto.get());
    }

    @GetMapping
    public ResponseEntity<List<Produto>> getAll() {
        List<Produto> listaProdutos = service.getAll();

        if (listaProdutos.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(listaProdutos);
    }

    @PostMapping 
    public  ResponseEntity<Produto> addProduto(@RequestBody ProdutoDTO produtoDTO) {
        Optional<Produto> optProduto = service.add(produtoDTO);
        
        if (optProduto.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        return new ResponseEntity<Produto>(optProduto.get(), HttpStatus.CREATED);
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Produto> deleteProduto(@PathVariable int id) {
        boolean apagou = service.delete(id);

        if (apagou) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        
        return ResponseEntity.notFound().build();
    }

    @PatchMapping ("/{id}")
    public ResponseEntity<Produto> update(@PathVariable int id, @RequestBody ProdutoDTO produtoDTO) {
        Optional<Produto> optionalProd = service.update(id, produtoDTO);

         if (optionalProd.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(optionalProd.get());
    }

    // @PutMapping ("/{id}")
    // public ResponseEntity<Produto> updateAll(@PathVariable int id, @RequestBody ProdutoDTO produtoDTO) {
    //     Optional<Produto> optionalProd = service.updateAll(id, produtoDTO.toProduto());

    //      if (optionalProd.isEmpty()) {
    //         return ResponseEntity.notFound().build();
    //     }

    //     return ResponseEntity.ok(optionalProd.get());
    // }


}
