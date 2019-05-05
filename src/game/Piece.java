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
public abstract class Piece {

    public PieceType type;
    public String color;

    public Piece(String Color) {
        this.color = Color;
    }

    public abstract boolean isValidPath(Position start, Position end, Spot[][] board);

    @Override
    public String toString() {
        return type + color;
    }

    public abstract PieceType getType();
}
