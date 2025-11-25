public class Player {
    public final String Name;
    public final int Price;
    private boolean IsSold;

    public Player(String Name, int Price){
        this.Name = Name;
        this.Price = Price;
        this.IsSold = false;
    }

    public boolean isSold(){
        return this.IsSold;
    }

    public void setSoldCondition(){
        this.IsSold = true;
    }

    @Override
    public String toString(){
        return Name;
    }
}
