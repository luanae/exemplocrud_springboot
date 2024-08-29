package br.edu.famper.exemplo1.model;

import jakarta.persistence.*;
import lombok.Data;

// a classe produto é uma copia da tabela produto
@Entity
@Table(name = "tbl_produto")
@Data
public class Produto {
    //as anotações tem que ficar acima da classe, atributo
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)  //para ser gerado automaticamento
    @Column(name = "produto_id")
    private Long codigo;

    @Column(name = "nome", length = 75)
    private String nome;

    @Column(name = "descricao", length = 150)
    private String descricao;

    @Column(name = "valor")   //nome da coluna
    private Double valor;

    @Column(name = "quantidade")
    private int quantidade;
}
