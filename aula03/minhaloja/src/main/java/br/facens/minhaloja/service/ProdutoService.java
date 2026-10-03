package br.facens.minhaloja.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.facens.minhaloja.model.Produto;
import br.facens.minhaloja.model.dto.ProdutoDTO;
import br.facens.minhaloja.repository.ProdutoRepository;

@Service
public class ProdutoService {

    private ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public Optional<Produto> getProduto(int id) {
        return repository.findById(id);
    }

    public List<Produto> getAll() {
        return (List<Produto>) repository.findAll();
    }

    public Optional<Produto> add(ProdutoDTO produtoDTO) {
        // produto.setId(null);
        Produto novoProduto = repository.save(produtoDTO.toProduto());

        return Optional.of(novoProduto);
    }

    public boolean delete(int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        // repository.deleteById(id);
        return false;
        // return ! repository.existsById(id);
    }

    public Optional<Produto> update(int idProduto, ProdutoDTO produto) {
        Optional<Produto> optionalProd = getProduto(idProduto);
        if (optionalProd.isEmpty()) {
            return Optional.empty();
        }
        Produto produtoAtual = optionalProd.get();
        if (produto.getNome() != null) {
            produtoAtual.setNome(produto.getNome());
        }
        if (produto.getValor() > 0) {
            produtoAtual.setValor(produto.getValor());
        }
        Produto produtoAtualizado = repository.save(produtoAtual);
        return Optional.of(produtoAtualizado);
    }

    public Optional<Produto> updateAll(int idProduto, Produto produto) {
        Optional<Produto> optionalProd = getProduto(idProduto);
        if (optionalProd.isEmpty()) {
            return Optional.empty();
        }
        produto.setId(idProduto);
        Produto produtoAtualizado = repository.save(produto);
        return Optional.of(produtoAtualizado);
    }
}
