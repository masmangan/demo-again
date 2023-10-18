package com.example;

import java.util.HashSet;
import java.util.Set;

import java.awt.Point;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Conjuntos!" );

        // 1 ∈ {1,2,3}

        Set<Integer> s1 = new HashSet<>();
        s1.add(1);
        s1.add(2);
        s1.add(3);
        
        System.out.println(s1);

        System.out.println(s1.contains(1));

        // ∅ ⊂ {1,2,3}
        Set<Integer> empty = new HashSet<>();
        System.out.println(s1.containsAll(empty));

        // {1,2} ⊆ {1,2,3,4}
        Set<Integer> s2 = new HashSet<>();
        s2.add(1);
        s2.add(2);

        Set<Integer> s3 = new HashSet<>();
        s3.add(1);
        s3.add(2);
        s3.add(3);
        s3.add(4);
        System.out.println(s3.containsAll(s2));

        Set<Integer> dif = new HashSet<>(s3);
        dif.removeAll(s2);

        System.out.println( s3.containsAll(s2) && ! dif.isEmpty() );

        // {1,2,3,4} − {1,2,5} = {3,4} "diferença entre conjuntos"
        Set<Integer> s4 = new HashSet<>();
        s4.add(1);
        s4.add(2);
        s4.add(5);

        Set<Integer> dif2 = new HashSet<>(s3);
        dif2.removeAll(s4);

        System.out.println(dif2);

        // {1,2} × {3,4} = {(1,3), (1,4), (2,3), (2,4)} produto cartesiano
        Set<Integer> s5 = new HashSet<>();
        s5.add(1);
        s5.add(2);

        Set<Integer> s6 = new HashSet<>();
        s6.add(3);
        s6.add(4);

        Set<Point> prod = new HashSet<>();

        for (Integer a : s5) {
            for (Integer b : s6) {
                Point p = new Point(a, b);
                prod.add(p);
            }
        }

        System.out.println(prod);

        // 2 ^ {1,2} = {∅,{1},{2},{1,2}} ou seja, o conjunto de todos os subconjuntos de um conjunto
        Set<Integer> s7 = new HashSet<>();
        s7.add(1);
        s7.add(2);

        Set<Set<Integer>> sub = new HashSet<>();
        sub.add(new HashSet<>());
        Set<Set<Integer>> lote = new HashSet<>();
        for (int i = 0; i < Math.pow(2, s7.size()); i++) {
            for (Set<Integer> s: sub) {
                lote = new HashSet<>();
                for (Integer e : s7) {
                    HashSet<Integer> ss = new HashSet<>(s);
                    ss.add(e);
                    lote.add(ss);
                }
            }
            sub.addAll(lote);
        }
        System.out.println(sub);

    }
}
