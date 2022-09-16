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
 * Effectue un trie séquentiel, mais présenté comme un Thread (donc on peut
 * en exécuter plusieurs en parallèle.
 * Voir TriDecoupeParNbrCoeurs pour un exemple d'utilisation.
 * @author francois
 */
public class TrieDirectBorne extends Thread {
    
    private int[] tab;
    private int min;
    private int max;

    /**
     *
     * @param tab
     * @param min
     * @param max
     */
    public TrieDirectBorne(int[] tab, int min, int max) {
        this.tab = tab;
        this.min = min;
        this.max = max;
    }
    
    /** todoDoc. */
    @Override
    public void run() {
        TriSequentiel.triBorne(tab, min, max-1);
    }

    /**
     * @return the tab
     */
    public int[] getTab() {
        return tab;
    }

    /**
     * @return the min
     */
    public int getMin() {
        return min;
    }

    /**
     * @return the max
     */
    public int getMax() {
        return max;
    }


    
}
