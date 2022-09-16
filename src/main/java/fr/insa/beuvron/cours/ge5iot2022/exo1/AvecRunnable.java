/*
    Copyright 2000- Francois de Bertrand de Beuvron

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

package fr.insa.beuvron.cours.ge5iot2022.exo1;

/**
 *
 * @author francois
 */
public class AvecRunnable {

    public static class Pair implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i <= 10; i = i + 2) {
                try {
                    Thread.sleep((int) (100));
                    System.out.println("executeur : "+ Thread.currentThread().getName() + " : " + i);
                } catch (InterruptedException ex) {
                    throw new Error("interuption non attendue : ne devrait jamais se produire");
                }
            }
        }
    }

    public static class Impair implements Runnable {

        @Override
        public void run() {
            for (int i = 1; i <= 10; i = i + 2) {
                try {
                    Thread.sleep((int) (200));
                    System.out.println("executeur : "+ Thread.currentThread().getName() + " : " + i);
                } catch (InterruptedException ex) {
                    throw new Error("interuption non attendue : ne devrait jamais se produire");
                }
            }
        }
    }

    public static void parallele() {
        Thread pair = new Thread(new Pair());
        Thread impair = new Thread(new Impair());
        pair.start();
        impair.start();
        try {
            pair.join();
            impair.join();
        } catch (InterruptedException ex) {
            throw new Error("interuption non attendue : ne devrait jamais se produire");
        }
        System.out.println("c'est fini");
    }

    public static void sequentiel() {
        Runnable pair = new Pair();
        Runnable impair = new Impair();
        pair.run();
        impair.run();
        System.out.println("c'est fini");
    }
    
    public static void main(String[] args) {
        System.out.println("------- parallele");
        parallele();
        System.out.println("------- sequentiel");
        sequentiel();
    }

}
