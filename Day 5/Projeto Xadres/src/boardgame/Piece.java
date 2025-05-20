package boardgame;

public class Piece {
    protected Position position;
    private Board board;

    public Piece(Position position) {
        this.position = position;
    }

    public Board getBoard() {
        return board;
    }
}
