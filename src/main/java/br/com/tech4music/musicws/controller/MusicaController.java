package br.com.tech4music.musicws.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tech4music.musicws.model.Musica;
import br.com.tech4music.musicws.service.MusicaService;
import br.com.tech4music.musicws.shared.MusicaDTO;

@RestController
@RequestMapping("/api/musicws")
public class MusicaController {
    @Autowired
    private MusicaService servico;

    @GetMapping
    public ResponseEntity<List<Musica>> mostrarMusica(){
        return new ResponseEntity<>(servico.mostrarTodas(), HttpStatus.OK);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<MusicaDTO> exibirPorId(@PathVariable String id){
        Optional<MusicaDTO> msc = servico.exibirPorId(id);

        if (msc.isPresent()) {
            return new ResponseEntity<>(msc.get(), HttpStatus.FOUND);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<MusicaDTO> adicionarMusica(@RequestBody @Valid Musica musica){
        return new ResponseEntity<>(servico.adicionarMusica(musica), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletarMusica(@PathVariable String id){
        servico.deletarMusica(id);
        Optional<MusicaDTO> msc = servico.exibirPorId(id);

        if (msc.isPresent()){
            servico.deletarMusica(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<MusicaDTO> musicaAtualizada(@PathVariable String id, @RequestBody Musica updatedMusica) {
        return new ResponseEntity<>(servico.musicaAtualizada(id, updatedMusica), HttpStatus.OK);
    }

}
