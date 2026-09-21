package br.com.fatec.ninjas.controller;

import br.com.fatec.ninjas.model.Missao;
import br.com.fatec.ninjas.service.MissaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/missao")
public class MissaoController {

    @Autowired
    private MissaoService missaoService;

    @PostMapping
    public Missao cadastrarMissao(@RequestBody Missao missao) {
        return missaoService.cadastrarMissao(missao);
    }

    @GetMapping
    public List<Missao> listarMissoes() {
        return missaoService.listarMissoes();
    }

    @GetMapping("/id/{id}")
    public Optional<Missao> pesquisarMissao(@PathVariable Long id) {
        return missaoService.pesquisarMissao(id);
    }

    @GetMapping("/titulo/{titulo}")
    public Missao pesquisarMissaoPorTitulo(@PathVariable String titulo) {
        return missaoService.pesquisarMissaoPorTitulo(titulo);
    }

    @GetMapping("/descricao/{descricao}")
    public List<Missao> pesquisarMissaoPorDescricao(@PathVariable String descricao) {
        return missaoService.pesquisarMissaoPorDescricao(descricao);
    }

    @PutMapping("/{id}")
    public Missao atualizarMissao(@PathVariable Long id, @RequestBody Missao missao){
        return missaoService.atualizarMissao(id, missao);
    }

    @DeleteMapping("/{id}")
    public void deletarMissao(@PathVariable long id){
        missaoService.deletarMissao(id);
    }
}
