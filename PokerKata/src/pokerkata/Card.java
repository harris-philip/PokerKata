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
public class Card {
    
    private int value;
    private String suite;
    private String name;
    
    Card()
    {
        
    }
    
    public Card (String str)
    {
        str = str.toUpperCase();
        
        if (str.length() == 3)
        {
            value = Integer.valueOf(str.substring(0, 2));
            name = Integer.toString(value);
            
            if (str.substring(2).equals("S"))
            {
                suite = "Spades";
            }
            else if (str.substring(2).equals("C"))
            {
                suite = "Clubs";
            }
            else if (str.substring(2).equals("H"))
            {
                suite = "Hearts";
            }
            else if (str.substring(2).equals("D"))
            {
                suite = "Diamonds";
            }
        }
        
        else
        {
            if (str.substring(0, 1).equals("A"))
            {
                value = 14;
                name = "Ace";
            }
            else if (str.substring(0, 1).equals("K"))
            {
                value = 13;
                name = "King";
            }
            else if (str.substring(0, 1).equals("Q"))
            {
                value = 12;
                name = "Queen";
            }
            else if (str.substring(0, 1).equals("J"))
            {
                value = 11;
                name = "Jack";
            }
            else
            {
                value = Integer.valueOf(str.substring(0, 1));
                name = Integer.toString(value);
            }
            
            if (str.substring(1).equals("S"))
            {
                suite = "Spades";
            }
            else if (str.substring(1).equals("C"))
            {
                suite = "Clubs";
            }
            else if (str.substring(1).equals("H"))
            {
                suite = "Hearts";
            }
            else if (str.substring(1).equals("D"))
            {
                suite = "Diamonds";
            }
        }
        
    }
    /**
     * @return the value
     */
    public int getValue() {
        return value;
    }

    /**
     * @return the suite
     */
    public String getSuite() {
        return suite;
    }

    /**
     * @return the name
     */
    public String getName() {        
        return name;
    }

    /**
     * @param value the value to set
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * @param suite the suite to set
     */
    public void setSuite(String suite) {
        this.suite = suite;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    public int compareSuites(Card o) {
        if (this.getSuite().equals(o.getSuite()))
            return 1;
        else
            return 0;
    }
   
     public int compareValue(Card o) {
        if (this.getValue() == o.getValue())
            return 0;
        else if (this.getValue() < o.getValue())
            return -1;
        else
            return 1;
    }
    
}
