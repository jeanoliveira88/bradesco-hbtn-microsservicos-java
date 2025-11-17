package com.example.demo;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SongRepository {

    private List<Song> list = new ArrayList<Song>();

    public SongRepository(List<Song> list) {
        this.list = list;
        Song song1 = new Song(1, "Bohemian Rhapsody", "Queen", "A Night at the Opera", "1975");
        Song song2 = new Song(2, "Imagine", "John Lennon", "Imagine", "1971");
        list.add(song1);
        list.add(song2);
    }

    public List<Song> getAllSongs() {
        return list;
    }

    public Song getSongById(Integer id) {
        return list.stream().filter(s -> s.getId().equals(id)).findFirst().orElse(null);
    }

    public Song addSong(Song s) {
        list.add(s);
        return s;
    }

    public Song updateSong(Song s) {
        Song song = getSongById(s.getId());
        if (song != null) {
            song.setNome(s.getNome());
            song.setArtista(s.getArtista());
            song.setAlbum(s.getAlbum());
            song.setAnoLancamento(s.getAnoLancamento());
        }
        return song;
    }

    public void removeSong(Song s) {
        list.remove(s);
    }
}
