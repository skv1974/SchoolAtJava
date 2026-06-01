package homeWork8.winAmp;

import java.util.ArrayList;

public class Playlist {
    // Поля класса
    private String name;
    private ArrayList<String> songs;

    // Конструктор
    public Playlist(String name) {
        this.name = name;
        this.songs = new ArrayList<>();
    }

    //Добавление песни в плейлист
    public void addSong(String songName) {
        songs.add(songName);
        System.out.println("[LOG] Добавлена песня: \"" + songName + "\"");
    }

    //Удаление песни по индексу
    public void removeSong(int index) {
        String removedSong = songs.remove(index);
        System.out.println("[LOG] Удалена песня: \"" + removedSong + "\" (индекс: " + index + ")");
    }

    //Обновление песни по индексу
    public void updateSong(int index, String newSongName) {
        String oldSong = songs.set(index, newSongName);
        System.out.println("[LOG] Песня \"" + oldSong + "\" заменена на \"" + newSongName + "\" (индекс: " + index + ")");
    }

    //Получение песни по индексу
    public String getSong(int index) {
        String song = songs.get(index);
        System.out.println("[LOG] Получена песня: \"" + song + "\" (индекс: " + index + ")");
        return song;
    }

    //Представление объекта в строку
    @Override
    public String toString() {
        return "Плейлист: '" + name + "' | Всего песен: " + songs.size() + " | Содержимое: " + songs;
    }
}