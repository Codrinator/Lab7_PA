
import java.util.*;

public class Player implements Runnable {

    private String name;
    private int myTurn;
    private List<Token> myTokens = new ArrayList<>();
    private Board board;


    public Player(String name, Board board) {
        this.name = name;
        this.board = board;
    }

    public void setTurn(int turn) {
        this.myTurn = turn;
    }

    @Override
    public void run() {
        while (board.free()) {
            //facem RUN cat timp avem return fals la metoda free a board-ului
            if (!board.isEmpty()) {
                Token t = board.extractToken(myTurn);
                myTokens.add(t);
                if (myTokens.size() > 2) { //a ales macar 2 tokens
                    boolean canAdvance = true; //se poate avansa, fiindca a trecut testul
                    int auxiliar = myTokens.get(1).getValue() - myTokens.get(0).getValue();
                    //auxiliar tine minte diferenta dintre o valoare si succesoarea
                    //mai intai initializam acest auxiliar si apoi verificam pentru restul tokenilor playerului
                    for (int index = 2; index < myTokens.size(); index++)
                        if ((myTokens.get(index).getValue() - myTokens.get(index - 1).getValue()) != auxiliar) {
                            canAdvance = false; //facem loc pentru urmatorul player
                            break; //iesim fortat
                        }
                    if (canAdvance)
                        board.win(myTokens, myTurn);
                } //end verificarea de alegere
            } //end board.EMPTY
        } //end WHILE
    } //end method

    @Override
    public String toString() {
        return "Nume_Player = '" +
                name + '\'';
    }
}