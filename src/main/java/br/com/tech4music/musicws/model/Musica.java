package br.com.tech4music.musicws.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;

import org.springframework.data.annotation.Id;

public class Musica {
    @Id
    private String id;
    @NotEmpty(message = "O título da música não foi inserido.")
    @NotBlank(message = "O título está em branco e/ou não possui caracteres válidos")
    private String titulo;
    @NotEmpty(message = "Nenhum artista foi inserido.")
    @NotBlank(message = "O campo 'artista' está em branco e/ou não possui caracteres válidos")
    private String artista;
    @NotEmpty(message = "Nenhum album foi inserido.")
    @NotBlank(message = "O campo 'album' está em branco e/ou não possui caracteres válidos")
    private String album;
    @NotEmpty(message = "Nehum gênero foi inserido.")
    @NotBlank(message = "O campo 'genero' está em branco e/ou não possui caracteres válidos")
    private String genero;
    @Min(value = 1700, message = "Ano mínimo 1700 (mil e setecentos)")
    @NotNull(message = "o campo 'anoLancamento' não pode ser nulo.")
    @Positive(message = "Este campo é uma data(ano) e por isso deve conter somente algarismos positivos")
    @PastOrPresent(message = "Não é permitido o preenchimento de um ano além do atual")
    private int anoLancamento;
    @NotEmpty(message = "Nenhum compositor foi inserido.")
    @NotBlank(message = "O campo 'compositor' está em branco e/ou não possui caracteres válidos")
    private String compositor;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getArtista() {
        return artista;
    }
    public void setArtista(String artista) {
        this.artista = artista;
    }
    public String getAlbum() {
        return album;
    }
    public void setAlbum(String album) {
        this.album = album;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public int getAnoLancamento() {
        return anoLancamento;
    }
    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }
    public String getCompositor() {
        return compositor;
    }
    public void setCompositor(String compositor) {
        this.compositor = compositor;
    }

    @Override
    public String toString() {
        return "Musica [album=" + album + ", anoLancamento=" + anoLancamento + ", artista=" + artista + ", compositor="
                + compositor + ", genero=" + genero + ", id=" + id + ", titulo=" + titulo + "]";
    }
}
