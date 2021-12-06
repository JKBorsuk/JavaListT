package com.company;

public class Main {

    public static void main(String[] args) {

        WzimList<Integer> list = new WzimList<Integer>();

        for(int i = 0; i<=9; i++)
        {
            list.add(i);
        }

        WzimList<Integer> druga = new WzimList<Integer>();

        for(int i = 20; i<=29; i++)
        {
            druga.add(i);
        }
        list.addAll(druga);

        // ITERATOR
        System.out.println("list + druga: ");
        for (Integer znak : list)
            System.out.print(znak + " ");

        Integer[] CZESCWSPOLNA = {3,8,9,24};
        WzimList<Integer> CZESCWSPOLNA_L = new WzimList<Integer>(CZESCWSPOLNA);


        System.out.println("\n\n Po wymuszeniu czesci wspolnej: ");
        list.retainAll(CZESCWSPOLNA_L);


        for (Integer znak : list)
            System.out.print(znak + " ");

        list.addAll(druga);
        System.out.println("\n\n Po Dodaniu 'druga'");
        for (Integer znak : list)
            System.out.print(znak + " ");

        list.removeAll(CZESCWSPOLNA_L);
        System.out.println("\n\n Po usunieciu czesci wspolnej'");
        for (Integer znak : list)
            System.out.print(znak + " ");


        System.out.println("Element tablicy o indeksie 5: " + list.get(5));

        System.out.println("Czy pusta? " + list.isEmpty());

        System.out.println("Czy zawiera 23? " + list.contains(23));

        System.out.println("Dodaj elementy z CZESCWSPOLNA na początek listy: ");
        list.addAll(0,CZESCWSPOLNA_L);

        for (Integer znak : list)
            System.out.print(znak + " ");

        System.out.println("\n\n Podaj ostatni indeks '24': ");
        System.out.println(list.lastIndexOf(24));

        System.out.println("\n\n Wyświetl sublistę o przedziałach indeksowych <4,9>:");
        for (Object znak : list.subList(4,9).toArray())
            System.out.print(znak + " ");

        System.out.println("\n\n Z 'list' usunę znak 24 w trakcie odczytu przez Iterator: ");
        for (Integer znak : list)
        {
            if(znak == 24)
                list.remove((Object)24);
            else System.out.print(znak + " ");
        }
    }
}
