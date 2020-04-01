import java.util.LinkedList;

public class Game {
    private int m;
    private int n;
    private int k;
    private LinkedList<Player> players;
    private Board board;

    @Override
    public String toString() {
        return "The game has begun: " +
                "\nm=" + m +
                ", n=" + n +
                ", k=" + k +
                ", with the following players: " + players +
                ", on the following board:\n " + board +
                '.';
    }

    public Game(int m, int n, int k, LinkedList<Player> players, Board board) {
        this.m = m;
        this.n = n;
        this.k = k;
        this.players = players;
        this.board = board;
    }

    public void start() {
        for (int index = 0; index < players.size(); index++) {
            players.get(index).setTurn(index);
            new Thread(players.get(index)).start();
        }

    }
}