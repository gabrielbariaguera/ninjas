package br.com.fatec.ninjas.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import lombok.Data;

@Data
@Entity
@Table (name = "missao")
public class Missao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_missao;
    @Column (name = "titulo_missao", nullable = false)
    private String titulo;
    @Column (name = "descricao_missao", nullable = false)
    private String descricao;
    @Column (name = "rank_missao", nullable = false)
    private String rank;
    @Column (name = "status_missao", nullable = false)
    private String status;
    @Column (name = "recompensa_missao", nullable = false)
    private Double recompensa;
}
