/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.pieces;

import game.Piece;
import game.PieceType;
import game.Position;

/**
 *
 * @author luisa
 */
public class Pawn extends Piece {

    public Pawn(String Color) {
        super(Color);
        type = PieceType.P;
    }

    @Override
    public boolean isValidPath(Position start, Position end) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PieceType getType() {
        return type;
    }

}
