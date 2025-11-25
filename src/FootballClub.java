import java.util.*;

public class FootballClub implements Runnable{
    public int sum;
    public final String Name;
    public List<Player> clubPlayers = new ArrayList<>();
    public TransferMarket transferMarket;
    public FootballClub(int sum, String Name, TransferMarket transferMarket){
        this.sum = sum;
        this.transferMarket = transferMarket;
        this.Name = Name;
    }

    @Override
    public void run() {
        while (transferMarket.buyPlayer(this)) {}
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Остаток на счёте клуба" + Name + "после трансферного окна: " + sum + "\n");
        for(Player player : clubPlayers){
            sb.append(player.toString() + "\n");
        }
        return sb.toString();
    }
}
