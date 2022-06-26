package tictactoe;

public class Player {
    private String name;
    private SignType signType;

    public Player(String name, SignType signType) {
        this.name = name;
        this.signType = signType;
    }

    public String getName() {
        return this.name;
    }
}
