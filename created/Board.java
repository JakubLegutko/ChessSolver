package created;

import created.commands.ResultDrawCommand;
import created.commands.ResultWinCommand;
import edu.uj.po.interfaces.*;
import util.result;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Board  {
    List<Piece> pieces;
    List<Position> fields = new ArrayList<>();
    ResultCheckerCommand resultCheckerCommand;
    public void setFields(List<Position> fields) {
        this.fields = fields;
    }
    public List<Position> getFields() {
        return fields;
    }
    public void setPieces(List<Piece> pieces) {
        this.pieces = pieces;
    }
    public List<Piece> getPieces() {
        return pieces;
    }
    public Board() {
        this.pieces = new ArrayList<>();
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++)
                fields.add(new Position(File.values()[i], Rank.values()[j]));
        setFields(fields);

    }
    public BoardSaveState createSaveState() {
        return new BoardSaveState(this, pieces, fields);
    }

    public Optional<Move> checkResult(Color color, result result) {
        if(result == result.CHECKMATE)
            resultCheckerCommand = new ResultWinCommand();
        else //(result == result.STALEMATE)
            resultCheckerCommand = new ResultDrawCommand();
        return resultCheckerCommand.checkResult(color, this);
    }



    public void addChessPiece(Position position, Color color, ChessPiece chessPiece) {
        Piece piece = new Piece(chessPiece, color, position);
        pieces.add(piece);
    }
}
