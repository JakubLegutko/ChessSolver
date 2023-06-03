package created;

import edu.uj.po.interfaces.Position;

public class MoveMore {
    Position from;
    Position to;


    Boolean enPassant;
    public boolean isEnPassant() {
        return enPassant;
    }

    public Position getFrom() {
        return from;
    }

    public void setFrom(Position from) {
        this.from = from;
    }

    public Position getTo() {
        return to;
    }

    public void setTo(Position to) {
        this.to = to;
    }

    public boolean isHit() {
        return isHit;
    }

    public void setHit(boolean hit) {
        isHit = hit;
    }

    boolean isHit; // Move can be executed only if to contains enemy piece, checker command will be complex!
    public MoveMore(Position from, Position to, boolean isHit) {
        this.from = from;
        this.to = to;
        this.isHit = isHit;
        this.enPassant = false;
    }
}
