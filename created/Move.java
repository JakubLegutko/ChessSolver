package created;

import edu.uj.po.interfaces.Position;

public class Move {
    Position from;
    Position to;
    boolean isHit; // Move can be executed only if to contains enemy piece, checker command will be complex!
    public Move(Position from, Position to, boolean isHit) {
        this.from = from;
        this.to = to;
        this.isHit = isHit;
    }
}
