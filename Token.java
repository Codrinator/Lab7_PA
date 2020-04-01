public class Token{
    private int value;

    public Token(int token) {
        this.value = token;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "" + value;
    }
}