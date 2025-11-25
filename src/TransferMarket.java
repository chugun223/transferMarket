import java.util.*;

public class TransferMarket {
    List<Player> players;

    public TransferMarket(List<Player> players){
        this.players = players;
    }

    public List<Player> availablePlayers(int sum){
        return this.players.stream()
                .filter(player -> player.Price <= sum && !player.isSold())
                .toList();
    }

    public synchronized boolean buyPlayer(FootballClub footballClub){
        List<Player> available = availablePlayers(footballClub.sum);
        if (available.isEmpty()){
            return false;
        }
        Player player = available.getFirst();
        player.setSoldCondition();
        footballClub.clubPlayers.add(player);
        footballClub.sum -= player.Price;
        return true;
    }
}
