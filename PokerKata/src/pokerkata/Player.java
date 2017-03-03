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
public class Player {

    private Hand hnd;

    public Player(Hand hand) {
        hnd = hand;
    }

    /**
     * @return the hnd
     */
    public Hand getHand() {
        return hnd;
    }
    
    public void printHand()
    {
        for (int i = 0; i < this.getHand().crd.length; i++)
        {
            System.out.println(this.getHand().getCard(i).getName());
        }
    }
    
    public void sortHand(Hand hand)
    {
        Hand handCopy = hand;
        
        
        for (int i = 0; i < handCopy.crd.length; i++)
        {
            for (int j = i+1; j < handCopy.crd.length; j++)
            {
                if (handCopy.crd[i].getValue() < handCopy.crd[j].getValue())
                {
                    Card temp = handCopy.crd[i];
                    handCopy.crd[i] = handCopy.crd[j];
                    handCopy.crd[j] = temp;
                }
            }
        }
        
    }
    

    public int compareHands(Player player, int ran) {
        if (this.getHand().isStraightFlush()) {
            if (!player.getHand().isStraightFlush()) {
                ran = 1;
            }
            else {
                ran = 0;
            }
        } 
        else if (this.getHand().isFourOfAKind()) {
            if (player.getHand().isStraightFlush()) {
                ran = -1;
            }
            else if (player.getHand().isFourOfAKind()) {
                ran = 0;
            }
            else {
                ran = 1;
            }
        } 
        else if (this.getHand().isFullHouse()) {
            if (player.getHand().isStraightFlush() || player.getHand().isFourOfAKind()) {
                ran = -1;
            }
            else if (player.getHand().isFullHouse()) {
                ran = 0;
            }
            else {
                ran = 1;
            }
        } 
        else if (this.getHand().isFlush()) {
            if (player.getHand().isStraightFlush() || player.getHand().isFourOfAKind()
                    || player.getHand().isFullHouse()) {
                ran = -1;
            }
            else if (player.getHand().isFlush()) {
                ran = 0;
            } 
            else {
                ran = 1;
            }
        } 
        else if (this.getHand().isStraight()) {
            if (player.getHand().isStraightFlush() || player.getHand().isFourOfAKind()
                    || player.getHand().isFullHouse() || player.getHand().isFlush()) {
                ran = -1;
            } 
            else if (player.getHand().isStraight()) {
                ran = 0;
            } 
            else {
                ran = 1;
            }
        } 
        else if (this.getHand().isThreeOfAKind()) {
            if (player.getHand().isStraightFlush() || player.getHand().isFourOfAKind()
                    || player.getHand().isFullHouse() || player.getHand().isFlush()
                    || player.getHand().isStraight()) {
                ran = -1;
            } else if (player.getHand().isThreeOfAKind()) {
                ran = 0;
            } else {
                ran = 1;
            }
        } 
        else if (this.getHand().isTwoPair()) {
            if (player.getHand().isStraightFlush() || player.getHand().isFourOfAKind()
                    || player.getHand().isFullHouse() || player.getHand().isFlush()
                    || player.getHand().isStraight() || player.getHand().isThreeOfAKind()) {
                ran = -1;
            } 
            else if (player.getHand().isTwoPair()) {
                ran = 0;
            } 
            else {
                ran = 1;
            }
        } 
        else if (this.getHand().isPair()) {
            if (player.getHand().isStraightFlush() || player.getHand().isFourOfAKind()
                    || player.getHand().isFullHouse() || player.getHand().isFlush()
                    || player.getHand().isStraight() || player.getHand().isThreeOfAKind()
                    || player.getHand().isTwoPair()) {
                ran = -1;
            } 
            else if (player.getHand().isPair()) {
                ran = 0;
            } 
            else {
                ran = 1;
            }
        } 
        else if (this.getHand().isHighCard()) {
            if (player.getHand().isHighCard()) {
                if (this.getHand().getHighCard().getValue() > player.getHand().getHighCard().getValue()) {
                    ran = 1;
                } 
                else if (this.getHand().getHighCard().getValue() < player.getHand().getHighCard().getValue())
                    ran = -1;
                 
                else {                    
                    for (int i = 1; i < this.getHand().crd.length; i++)
                    {
                        if (this.getHand().getCard(i).getValue() > player.getHand().getCard(i).getValue())
                            ran = 1;
                        else if (this.getHand().getCard(i).getValue() < player.getHand().getCard(i).getValue())
                        {
                            ran = -1;
                        }                            
                    }   
                }
            } 
        }
        
        return ran;
    }
}
