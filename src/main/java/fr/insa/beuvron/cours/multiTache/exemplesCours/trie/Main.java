/*
Copyright 2000-2014 Francois de Bertrand de Beuvron

This file is part of CoursBeuvron.

CoursBeuvron is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

CoursBeuvron is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with CoursBeuvron.  If not, see <http://www.gnu.org/licenses/>.
 */
package fr.insa.beuvron.cours.multiTache.exemplesCours.trie;

/**
 *
 * @author francois
 */
public class Main {

    /** todoDoc. */
    public static void testAll() {
        System.out.println("------------- sequentiel");
        TriSequentiel.test(TriSequentiel.SIZE,TriSequentiel.BMAX);
        System.out.println("------------- recursif complet");
//        System.out.println("trop long --> pas fait");
        TriParallele.test(TriSequentiel.SIZE,TriSequentiel.BMAX);
        System.out.println("------------- recursif partiel");
//        System.out.println("trop long --> pas fait");
        TriSemiParallele.test(TriSequentiel.SIZE,TriSequentiel.BMAX);
        System.out.println("------------- decoupe par nbr coeur");
        TriDecoupeParNbrCoeurs.test(TriSequentiel.SIZE,TriSequentiel.BMAX);
    }
    
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        testAll();
    }

}
