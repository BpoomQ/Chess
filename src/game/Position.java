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
public class Position {

    private final int i;
    private final int j;

    public Position(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof Position && ((Position) o).getI() == this.i && ((Position) o).getJ() == this.j);
    }

    @Override
    public String toString() {
        return "{ i: " + i + " j: " + j + " }";
    }

}
