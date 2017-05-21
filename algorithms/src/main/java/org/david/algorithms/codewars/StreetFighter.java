package org.david.algorithms.codewars;

/**
 * Created by David Marques on 21/05/2017.
 */

/**
 * Some of you might remember spending afternoons playing Street Fighter 2 in some Arcade back in the 90s or emulating it nowadays with the numerous emulators for retro consoles.
 * <p>
 * Can you solve this kata? Suuure-You-Can!
 * <p>
 * UPDATE: a new kata's harder version is available here.
 * <p>
 * The Kata
 * <p>
 * You'll have to simulate the video game's character selection screen behaviour, more specifically the selection grid. Such screen looks like this:
 * Selection Grid Layout in text:
 * <p>
 * | Ryu  | E.Honda | Blanka  | Guile   | Balrog | Vega    |
 * | Ken  | Chun Li | Zangief | Dhalsim | Sagat  | M.Bison |
 * Input
 * <p>
 * the list of game characters in a 2x6 grid;
 * the initial position of the selection cursor (top-left is (0,0));
 * a list of moves of the selection cursor (which are up, down, left, right);
 * Output
 * <p>
 * the list of characters who have been hovered by the selection cursor after all the moves (ordered and with repetition, all the ones after a move, wether successful or not, see tests);
 * Rules
 * <p>
 * Selection cursor is circular horizontally but not vertically!
 * <p>
 * As you might remember from the game, the selection cursor rotates horizontally but not vertically; that means that if I'm in the leftmost and I try to go left again I'll get to the rightmost (examples: from Ryu to Vega, from Ken to M.Bison) and vice versa from rightmost to leftmost.
 * <p>
 * Instead, if I try to go further up from the upmost or further down from the downmost, I'll just stay where I am located (examples: you can't go lower than lowest row: Ken, Chun Li, Zangief, Dhalsim, Sagat and M.Bison in the above image; you can't go upper than highest row: Ryu, E.Honda, Blanka, Guile, Balrog and Vega in the above image).
 * <p>
 * Test
 * <p>
 * For this easy version the fighters grid layout and the initial position will always be the same in all tests, only the list of moves change.
 * <p>
 * Notice : changing some of the input data might not help you.
 * <p>
 * Examples
 * <p>
 * 1.
 * <p>
 * fighters = [
 * ["Ryu", "E.Honda", "Blanka", "Guile", "Balrog", "Vega"],
 * ["Ken", "Chun Li", "Zangief", "Dhalsim", "Sagat", "M.Bison"]
 * ]
 * initial_position = (0,0)
 * moves = ['up', 'left', 'right', 'left', 'left']
 * then I should get:
 * <p>
 * ['Ryu', 'Vega', 'Ryu', 'Vega', 'Balrog']
 * as the characters I've been hovering with the selection cursor during my moves. Notice: Ryu is the first just because it "fails" the first up See test cases for more examples.
 * <p>
 * 2.
 * <p>
 * fighters = [
 * ["Ryu", "E.Honda", "Blanka", "Guile", "Balrog", "Vega"],
 * ["Ken", "Chun Li", "Zangief", "Dhalsim", "Sagat", "M.Bison"]
 * ]
 * initial_position = (0,0)
 * moves = ['right', 'down', 'left', 'left', 'left', 'left', 'right']
 * Result:
 * <p>
 * ['E.Honda', 'Chun Li', 'Ken', 'M.Bison', 'Sagat', 'Dhalsim', 'Sagat']
 */
public class StreetFighter {

    public static String[] streetFighterSelection(String[][] fighters, int[] position, String[] moves) {

        String[] selection = new String[moves.length];
        int x = position[1];
        int y = position[0];
        int index = 0;
        for (String move : moves) {
            if (move.equalsIgnoreCase("down")) {
                y = (y + 1) == fighters.length ? y : y + 1;
            } else if (move.equalsIgnoreCase("up")) {
                y = (y - 1) == -1 ? y : y - 1;
            } else if (move.equalsIgnoreCase("left")) {
                x = (x + fighters[y].length - 1) % fighters[y].length;
            } else if (move.equalsIgnoreCase("right")) {
                x = (x + 1) % fighters[y].length;
            }
            selection[index] = fighters[y][x];
            index++;
        }


        return selection;
    }
}
