import java.util.*;

public class Main {

    public static void main(String[] args) {
        LinkedList<Player> myPlayers = new LinkedList<>();

        Board myBoard = new Board(35);
        //adaugam players pe board
        Player p1 = new Player("Codrin", myBoard);
        Player p2 = new Player("Silviu", myBoard);
        Player p3 = new Player("George", myBoard);
        Player p4 = new Player("Vasile", myBoard);

        myPlayers.add(p1);
        myPlayers.add(p2);
        myPlayers.add(p3);
        myPlayers.add(p4);

        Game game = new Game(35, myBoard.getNumber(), 4, myPlayers, myBoard);

        System.out.println("\n");
        System.out.println(game); //se printeaza datele jocului : m, n, k
        System.out.println("\n");

        game.start(); //aici incepe jocul
    }
}