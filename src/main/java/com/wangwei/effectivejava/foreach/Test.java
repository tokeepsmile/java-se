package com.wangwei.effectivejava.foreach;


import java.util.*;

/**
 * @auther wangwei
 * @date 2019-05-28 23:07
 */
public class Test {
    public static void main(String[] args) {
        EnumSet<Face> faces = EnumSet.allOf(Face.class);

/*        for (Iterator<Face> i = faces.iterator(); i.hasNext();)
            for (Iterator<Face> j = faces.iterator(); j.hasNext();)
                System.out.println(i.next() + " " + j.next());  */

        for (Iterator<Face> i = faces.iterator(); i.hasNext();) {
            Face face = i.next();
            for (Iterator<Face> j = faces.iterator(); j.hasNext(); )
                System.out.println(face + " " + j.next());
        }


        List<Suit> suits = Arrays.asList(Suit.values());
        List<Rank> ranks = Arrays.asList(Rank.values());

        ArrayList<Card> deck = new ArrayList<>();
/*        for (Iterator<Suit> i = suits.iterator(); i.hasNext();)
            for (Iterator<Rank> j = ranks.iterator(); j.hasNext(); )
                deck.add(new Card(i.next(), j.next()));   */

        for (Iterator<Suit> i = suits.iterator(); i.hasNext();) {
            Suit suit = i.next();
            for (Iterator<Rank> j = ranks.iterator(); j.hasNext(); )
                deck.add(new Card(suit, j.next()));
        }

        suits.forEach( suit -> {
            ranks.forEach( rank -> {
                deck.add(new Card(suit, rank));
            });
        });

    }
}
