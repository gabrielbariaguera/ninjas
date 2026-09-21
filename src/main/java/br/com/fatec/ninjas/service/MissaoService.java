package br.com.fatec.ninjas.service;

import br.com.fatec.ninjas.model.Missao;
import br.com.fatec.ninjas.repository.MissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissaoService {

    @Autowired
    private MissaoRepository missaoRepository;

    public Missao cadastrarMissao(Missao missao) {
        return missaoRepository.save(missao);
    }

    public List<Missao> listarMissoes() {
        return missaoRepository.findAll();
    }

    public Optional<Missao> pesquisarMissao(Long id) {
        return missaoRepository.findById(id);
    }

    public Missao pesquisarMissaoPorTitulo(String titulo) {
        return missaoRepository.findByTitulo(titulo);
    }

    public List<Missao> pesquisarMissaoPorDescricao(String descricao) {
        return missaoRepository.findByDescricaoContaining(descricao);
    }

    public Missao atualizarMissao(Long id, Missao missaoAtualizada){
        Optional<Missao> missaoCadastrada = missaoRepository.findById(id);
        if (missaoCadastrada.isPresent()){
            Missao missao = missaoCadastrada.get();
            missao.setTitulo(missaoAtualizada.getTitulo());
            missao.setDescricao(missaoAtualizada.getDescricao());
            missao.setRank(missaoAtualizada.getRank());
            missao.setStatus(missaoAtualizada.getStatus());
            missao.setRecompensa(missaoAtualizada.getRecompensa());
            return missaoRepository.save(missao);
        }
        return null;
    }

    public void deletarMissao(Long id){
        missaoRepository.deleteById(id);
    }
}
