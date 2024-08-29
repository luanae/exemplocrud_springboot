package br.edu.famper.exemplo1.controller;

import br.edu.famper.exemplo1.model.Produto;
import br.edu.famper.exemplo1.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<Produto>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.findAll());
    }

    @GetMapping("/{id}")                //quando é entre {} significa q é uma variavel
    public ResponseEntity<Optional<Produto>> findById(@PathVariable Long id) { //é optional pq talvez nao encontre um produto
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Produto> create(@RequestBody Produto produto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.salvar(produto));
    }

    @PutMapping     //pra fazer o update
    public ResponseEntity<Produto> update(@RequestBody Produto produto) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(produtoService.update(produto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        produtoService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
