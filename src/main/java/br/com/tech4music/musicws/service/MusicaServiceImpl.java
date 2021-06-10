package br.com.tech4music.musicws.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.modelmapper.ModelMapper;

import br.com.tech4music.musicws.model.Musica;
import br.com.tech4music.musicws.repository.MusicaRepository;
import br.com.tech4music.musicws.shared.MusicaDTO;

@Service
public class MusicaServiceImpl implements MusicaService{
    @Autowired
    private MusicaRepository repositorio;

    @Override
    public MusicaDTO adicionarMusica(Musica musica) {
        repositorio.save(musica);

        return new ModelMapper().map(musica, MusicaDTO.class);
    }

    @Override
    public List<Musica> mostrarTodas() {
        return repositorio.findAll();
    }

    @Override
    public Optional<MusicaDTO> exibirPorId(String id) {
        Optional<Musica> msc = repositorio.findById(id);

        if(msc.isPresent()) {
            return Optional.of(new ModelMapper().map(msc.get(), MusicaDTO.class));
        }

        return Optional.empty();
    }

    @Override
    public void deletarMusica(String id) {
        repositorio.deleteById(id);
    }

    @Override
    public MusicaDTO musicaAtualizada(String id, Musica updatedMusica) {
        updatedMusica.setId(id);
        repositorio.save(updatedMusica);
        return new ModelMapper().map(updatedMusica, MusicaDTO.class);
    }
    
}
