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
public class Hand {

    protected Card[] crd = new Card[5];

    public Hand(String str) {
        String[] sCrd = str.split(" ");
        for (int i = 0; i < crd.length; i++) {
            crd[i] = new Card(sCrd[i]);
        }
    }

    public Card getCard(int i) {
        return crd[i];
    }

    public Card getHighCard() {
        int highCard = 0;
        if (this.isHighCard()) {
            for (int i = 0; i < crd.length; i++) {
                for (int j = i + 1; j < crd.length; j++) {
                    if (crd[i].getValue() < crd[j].getValue()) {
                        highCard = j;
                    } 
                    else {
                        highCard = i;
                    }
                }
            }
        }
        return crd[highCard];
    }

    public void setCard(Card card, int place) {
        crd[place] = card;
    }

    public boolean isHighCard() {
        if (this.isStraightFlush()
                || this.isFourOfAKind()
                || this.isFullHouse()
                || this.isFlush()
                || this.isStraight()
                || this.isThreeOfAKind()
                || this.isTwoPair()
                || this.isPair()) {
            return false;
        } 
        else {
            return true;
        }
    }

    public boolean isPair() {
        int valueCounter = 0;
        for (int i = 0; i < crd.length; i++) {
            for (int j = i + 1; j < crd.length; j++) {
                if (crd[i].compareValue(crd[j]) == 1) {
                    valueCounter++;
                }
            }
        }
        if (valueCounter != 1) {
            return false;
        } 
        else {
            return true;
        }
    }

    public boolean isTwoPair() {
        int valueCounter = 0;
        for (int i = 0; i < crd.length; i++) {
            for (int j = i + 1; j < crd.length; j++) {
                if (crd[i].compareValue(crd[j]) == 1) {
                    valueCounter++;
                }
            }
        }
        if (valueCounter != 2) {
            return false;
        } 
        else {
            return true;
        }
    }

    public boolean isThreeOfAKind() {
        int valueCounter = 0;
        for (int i = 0; i < crd.length; i++) {
            for (int j = i + 1; j < crd.length; j++) {
                if (crd[i].compareValue(crd[j]) == 1) {
                    valueCounter++;
                }
            }
        }
        if (valueCounter != 3) {
            return false;
        } 
        else {
            return true;
        }
    }

    public boolean isStraight() {
        int valueCounter = 0;
        int suiteCounter = 0;
        for (int i = 0; i < crd.length; i++) {
            for (int j = i + 1; j < crd.length; j++) {
                if (crd[i].compareSuites(crd[j]) == 1) {
                    suiteCounter++;
                }
            }
        }

        if (suiteCounter == 10) {
            return false;
        }

        for (int i = 0; i < crd.length; i++) {
            for (int j = i + 1; j < crd.length; j++) {
                if (crd[i].compareValue(crd[j]) == 0) {
                    if (crd[i].getValue() - crd[j].getValue() == 1 || crd[i].getValue() - crd[j].getValue() == -1) {
                        valueCounter++;
                    }
                }
            }
        }
        if (valueCounter != 4) {
            return false;
        } 
        else {
            return true;
        }
    }

    public boolean isFlush() {
        int suiteCounter = 0;
        for (int i = 0; i < crd.length; i++) {
            for (int j = i + 1; j < crd.length; j++) {
                if (crd[i].compareSuites(crd[j]) == 1) {
                    suiteCounter++;
                }
            }
        }
        if (suiteCounter != 10) {
            return false;
        } 
        else {
            return true;
        }
    }

    public boolean isFullHouse() {
        int valueCounter = 0;
        for (int i = 0; i < crd.length; i++) {
            for (int j = i + 1; j < crd.length; j++) {
                if (crd[i].compareValue(crd[j]) == 1) {
                    valueCounter++;
                }
            }
        }
        if (valueCounter != 4) {
            return false;
        } 
        else {
            return true;
        }
    }

    public boolean isFourOfAKind() {
        int valueCounter = 0;
        for (int i = 0; i < crd.length; i++) {
            for (int j = i + 1; j < crd.length; j++) {
                if (crd[i].compareValue(crd[j]) == 1) {
                    valueCounter++;
                }
            }
        }

        if (valueCounter != 6) {
            return false;
        } 
        else {
            return true;
        }
    }

    public boolean isStraightFlush() {
        int valueCounter = 0;
        for (int i = 0; i < crd.length; i++) {
            for (int j = i + 1; j < crd.length; j++) {
                if (crd[i].compareSuites(crd[j]) == 0) {
                    return false;
                }
            }
        }
        for (int i = 0; i < crd.length; i++) {
            for (int j = i + 1; j < crd.length; j++) {
                if (crd[i].compareValue(crd[j]) == 0) {
                    if (crd[i].getValue() - crd[j].getValue() == 1 || crd[i].getValue() - crd[j].getValue() == -1) {
                        valueCounter++;
                    }
                }
            }
        }

        if (valueCounter != 4) {
            return false;
        } 
        else {
            return true;
        }
    }
    
    
    
}
