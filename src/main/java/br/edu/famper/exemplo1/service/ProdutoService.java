package br.edu.famper.exemplo1.service;

import br.edu.famper.exemplo1.model.Produto;
import br.edu.famper.exemplo1.repository.ProdutoReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service      //classe responsavel por prover as informações
public class ProdutoService {

    @Autowired          //cria a variavel automatico quando iniciada a aplicação
    private ProdutoReposity produtoReposity;

    public Produto salvar(Produto produto) {
        return produtoReposity.save(produto);
    }

    public List<Produto> findAll(){
        return produtoReposity.findAll();
    }

    public Optional<Produto> findById(Long id) {
        return produtoReposity.findById(id);    //procura por um ID especifico
    }

    public Produto update(Produto produto) {
        return produtoReposity.save(produto);
    }

    public void deleteById(Long id) {
        produtoReposity.deleteById(id);
    }
}
