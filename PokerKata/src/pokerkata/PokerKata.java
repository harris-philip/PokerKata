/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokerkata;

import java.util.Scanner;

/**
 *
 * @author phili
 */
public class PokerKata {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner bScan, wScan;
        String blackCards, whiteCards;
        Hand blackHand, whiteHand;
        Player black, white;

        bScan = new Scanner(System.in);
        wScan = new Scanner(System.in);

        System.out.println("Please enter the Cards for Player Black and Player White");
        System.out.print("Black: ");
        blackCards = bScan.nextLine();
        System.out.print("White: ");
        whiteCards = wScan.nextLine();
        System.out.println();

        blackHand = new Hand(blackCards);
        whiteHand = new Hand(whiteCards);

        black = new Player(blackHand);
        white = new Player(whiteHand);

        winningHand(black, white);

    }

    public static void winningHand(Player black, Player white) {
        int i = 0;
        int nextHighest = 0;
        if (white.compareHands(black, i) == 0) {
            System.out.println("Tie.");
        } 
        else if (white.compareHands(black, i) == -1) {
            if (black.getHand().isStraightFlush()) {
                System.out.println("Black wins. - with Straight Flush");
            } 
            else if (black.getHand().isFourOfAKind()) {
                System.out.println("Black wins. - with Four of a Kind");
            } 
            else if (black.getHand().isFullHouse()) {
                System.out.println("Black wins. - with Full House");
            } 
            else if (black.getHand().isFlush()) {
                System.out.println("Black wins. - with Flush");
            } 
            else if (black.getHand().isStraight()) {
                System.out.println("Black wins. - with Straight");
            } 
            else if (black.getHand().isThreeOfAKind()) {
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
        else {
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
