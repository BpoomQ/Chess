/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

/**
 *
 * @author Luis Alejandro Tarazona
 */
public class Spot {

    private Piece piece;

    public Spot() {
        this.piece = null;
    }

    public boolean isAvailabe() {
        return piece == null;
    }

    public void insertPiece(Piece piece) {
        if (isAvailabe()) {
            this.piece = piece;
        }
    }

    public Piece getPiece() {
        return piece;
    }

    @Override
    public String toString() {
        return "" + piece.getType();
    }

}
