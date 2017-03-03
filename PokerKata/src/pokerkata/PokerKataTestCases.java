/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokerkata;

/**
 *
 * @author phili
 */
public class PokerKataTestCases {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Player white1 = new Player(new Hand("2C 3H 4S 8C AH"));
        Player white2 = new Player(new Hand("2S 8S AS QS 3S"));
        Player white3 = new Player(new Hand("2C 3H 4S 8C KH"));
        Player white4 = new Player(new Hand("2D 3H 5C 9S KH"));

        Player black1 = new Player(new Hand("2H 3D 5S 9C KD"));
        Player black2 = new Player(new Hand("2H 4S 4C 2D 4H"));
        Player black3 = new Player(new Hand("2H 3D 5S 9C KD"));
        Player black4 = new Player(new Hand("2H 3D 5S 9C KD"));

        winningHand(black1, white1);
        winningHand(black2, white2);
        winningHand(black3, white3);
        winningHand(black4, white4);

    }

    public static void winningHand(Player black, Player white) 
    {
        int i = 0;
        int nextHighest = 0;
        if (white.compareHands(black, i) == 0) {
            System.out.println("Tie.");
        } 
        else if (white.compareHands(black, i) == -1) {
            if (black.getHand().isStraightFlush()) {
                System.out.println("Black wins. - with Straight Flush");
            } else if (black.getHand().isFourOfAKind()) {
                System.out.println("Black wins. - with Four of a Kind");
            } else if (black.getHand().isFullHouse()) {
                System.out.println("Black wins. - with Full House");
            } else if (black.getHand().isFlush()) {
                System.out.println("Black wins. - with Flush");
            } else if (black.getHand().isStraight()) {
                System.out.println("Black wins. - with Straight");
            } else if (black.getHand().isThreeOfAKind()) {
                System.out.println("Black wins. - with Three of a Kind");
            } 
            else if (black.getHand().isTwoPair()) {
                System.out.println("Black wins. - with Two Pair");
            } 
            else if (black.getHand().isPair()) {
                System.out.println("Black wins. - with Pair");
            } 
            else if (white.getHand().getHighCard().compareValue(black.getHand().getHighCard()) != 0) {
                System.out.println("Black wins. - with High Card: " + black.getHand().getHighCard().getName());
            } 
            else {
                white.sortHand(white.getHand());
                black.sortHand(black.getHand());
                for (int j = 1; j < black.getHand().crd.length; j++) {
                    if (black.getHand().getCard(j).compareValue(white.getHand().getCard(j)) == 1) {
                        nextHighest = j;
                        break;
                    }
                }
                System.out.println("Black wins. - with High Card: " + black.getHand().getCard(nextHighest).getName());
            }
        } 
        else{
            if (white.getHand().isStraightFlush()) {
                System.out.println("White wins. - with Straight Flush");
            } 
            else if (white.getHand().isFourOfAKind()) {
                System.out.println("White wins. - with Four of a Kind");
            } 
            else if (white.getHand().isFullHouse()) {
                System.out.println("White wins. - with Full House");
            } 
            else if (white.getHand().isFlush()) {
                System.out.println("White wins. - with Flush");
            } 
            else if (white.getHand().isStraight()) {
                System.out.println("White wins. - with Straight");
            } 
            else if (white.getHand().isThreeOfAKind()) {
                System.out.println("White wins. - with Three of a Kind");
            } 
            else if (white.getHand().isTwoPair()) {
                System.out.println("White wins. - with Two Pair");
            } 
            else if (white.getHand().isPair()) {
                System.out.println("White wins. - with Pair");
            } 
            else if (white.getHand().getHighCard().compareValue(black.getHand().getHighCard()) != 0) {
                System.out.println("White wins. - with High Card: " + white.getHand().getHighCard().getName());
            }
            else {
                white.sortHand(white.getHand());
                black.sortHand(black.getHand());
                for (int j = 1; j < black.getHand().crd.length; j++) {
                    if (white.getHand().getCard(j).compareValue(black.getHand().getCard(j)) == 1) {
                        nextHighest = j;
                        break;
                    }
                }
                System.out.println("White wins. - with High Card: " + white.getHand().getCard(nextHighest).getName());
            }
        }
    }
}
