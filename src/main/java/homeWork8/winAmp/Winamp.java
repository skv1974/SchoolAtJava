package homeWork8.winAmp;

public class Winamp {
    public static void main(String[] args) {
        System.out.println("--- Инициализация Winamp --- \n");

        Playlist myPlaylist = new Playlist("Хиты 2000-х");

        //Добавление
        myPlaylist.addSong("Linkin Park - In the End");
        myPlaylist.addSong("Britney Spears - Toxic");
        myPlaylist.addSong("Rammstein - Du Hast");
        myPlaylist.addSong("Eminem - Lose Yourself");
        System.out.println();

        //Получение
        myPlaylist.getSong(1);
        System.out.println();

        //Обновление
        myPlaylist.updateSong(2, "Rammstein - Sonne");
        System.out.println();

        //Удаление
        myPlaylist.removeSong(0);
        System.out.println();

        //Финальный вывод
        System.out.println("--- Текущее состояние плейлиста ---");
        System.out.println(myPlaylist);
    }
}