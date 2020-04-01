import java.util.*;

public class Board {

    private volatile boolean canItDoIt = true;
    private volatile boolean empty = false;
    private LinkedList<Token> tokens = new LinkedList<>();
    private int n;

    public synchronized boolean isEmpty() {
        return tokens.isEmpty();
    }

    public synchronized boolean free() {
        return canItDoIt;
    }

    public Board(int n) {
        for (int i = 1; i <= n; i++) {
            Token token = new Token(i);
            this.tokens.add(token);
        }
        this.n = n;
    }

    public int getNumber() {
        return n;
    }

    @Override
    public String toString() {
        return "(new board here){" +
                tokens + "}";
    }

    public synchronized Token extractToken(int turn) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (!tokens.isEmpty()) {
            Token thisToken;
            thisToken = tokens.getFirst();
            tokens.removeFirst();
            notifyAll();
            System.out.println("Player " + (turn + 1) + " has chosen the following token: " + thisToken);
            return thisToken;
        }
        System.out.println("Out of tokens. Game stopped, no winners. Play again, why not?");
        canItDoIt = false;
        empty=true;
        notifyAll();
        return null;
    }

    public synchronized void win(List<Token> theseTokens, int turn){
        canItDoIt = false;
        notifyAll();
        System.out.println("Player " + (turn+1) + " with the following tokens = " + theseTokens + " has won the game!");

    }
}
