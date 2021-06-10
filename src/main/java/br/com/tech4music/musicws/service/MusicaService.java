package br.com.tech4music.musicws.service;

import java.util.List;
import java.util.Optional;

import br.com.tech4music.musicws.model.Musica;
import br.com.tech4music.musicws.shared.MusicaDTO;

public interface MusicaService {
    MusicaDTO adicionarMusica(Musica musica);
    List<Musica> mostrarTodas();
    Optional<MusicaDTO> exibirPorId(String id);
    void deletarMusica(String id);
    MusicaDTO musicaAtualizada(String id, Musica updatedMusica);
}
