import java.util.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Player> players = new ArrayList<>(List.of(
                new Player("Мэсси", 50),
                new Player("Роналдо", 55),
                new Player("Неймар", 45),
                new Player("Салах", 25),
                new Player("Мбаппе", 42),
                new Player("Кейн", 13),
                new Player("Кен", 25),
                new Player("Кент", 34),
                new Player("Брёйне", 14),
                new Player("Холланд", 24),
                new Player("Коля", 13),
                new Player("Валя", 35),
                new Player("Толя", 27),
                new Player("Поля", 17),
                new Player("Доля", 20),
                new Player("Воля", 19),
                new Player("Бомбардир", 5),
                new Player("Дор", 10),
                new Player("Вор", 7),
                new Player("Сор", 9),
                new Player("Двор", 24),
                new Player("Упор", 17),
                new Player("Напор", 19),
                new Player("Запор", 25),
                new Player("ТОр", 34),
                new Player("Фтор", 33)));
        Collections.shuffle(players);
        TransferMarket transferMarket = new TransferMarket(players);

        List<FootballClub> footballClubs = new ArrayList<>(List.of(
                new FootballClub(140, "Реал Мадрид", transferMarket),
                new FootballClub(130, "ПСЖ", transferMarket),
                new FootballClub(100, "Челси", transferMarket),
                new FootballClub(80, "Динамо Москва", transferMarket),
                new FootballClub(90, "Динамо Киев", transferMarket)
        ));
        List<Thread> threads = new ArrayList<>();
        for(FootballClub footballClub : footballClubs){
            Thread thread = new Thread(footballClub);
            threads.add(thread);
            thread.start();
        }
        for(Thread thread : threads){
            thread.join();
        }
        for(FootballClub footballClub : footballClubs){
            System.out.println(footballClub.toString());
        }
        System.out.println("Игроки, оставшиеся без команды: \n");
        players.stream()
                .filter(player -> !player.isSold())
                .forEach(player -> System.out.println(player + "\n"));
    }
}
