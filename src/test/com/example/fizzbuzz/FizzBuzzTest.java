package com.example.fizzbuzz;

import org.junit.Assert;
import org.junit.Test;

public class FizzBuzzTest {

    @Test
    public void testFizzBuzz(){
        Assert.assertEquals("2", FizzBuzz.calculate(2));
    }

    @Test
    public void testFizzBuzzMultipleOf3(){
        Assert.assertEquals("Fizz", FizzBuzz.calculate(3));
    }

    @Test
    public void testFizzBuzzMultipleOf5(){
        Assert.assertEquals("Buzz", FizzBuzz.calculate(5));
    }

    @Test
    public void testFizzBuzzMultipleOf3And5(){
        Assert.assertEquals("FizzBuzz", FizzBuzz.calculate(15));
    }
}

/**
 * Primo requisito: Creare una funzione FizzBuzz che accetta un numero in input e restituisce una stringa in output
 * Assert.assertEquals("3", FizzBuzz.calculate(3));
 * Test fallisce perchè non c'è la classe ed il method
 * Ho implementato la classe e la funzione che ritorna il numero in stringa
 * Ora il test funziona
 * Secondo requisito: Per multipli di tre la funzione restituisce "Fizz" invece del numero
 * Aggiungo un test
 * Assert.assertEquals("Fizz", FizzBuzz.calculate(3));
 * Il test fallisce e modifico l'implementazione
 * Ora il nuovo test passa, ma fallisce l'altro in quanto ci aspettiamo erroneamente che passando 3 ci restituisca 3
 * Aggiorno il test che adesso passa, secondo requisito completato
 * Terzo requisito: Per multipli di 5 restituire "Buzz"
 * Aggiungo un test
 * Assert.assertEquals("Buzz", FizzBuzz.calculate(5));
 * Il test fallisce, procedo con l'implementazione
 * Tutti i test vanno a buon fine, non c'è bisogno di fare refactor quindi procedo
 * Quarto requisito: Per numeri multipli sia di 3 che di 5 restituire "FizzBuzz"
 * Aggiungo un test
 * Assert.assertEquals("FizzBuzz", FizzBuzz.calculate(15));
 * Il test fallisce in quanto manca l'implementazione, procedo
 * Ora il test passa ma non mi piace l'implementazione attuale
 *      public static String calculate(int number) {
 *         if(number % 3 == 0 && number % 5 == 0){
 *             return "FizzBuzz";
 *         } else if(number % 3 == 0){
 *             return "Fizz";
 *         } else if (number % 5 == 0){
 *             return "Buzz";
 *         } else {
 *             return String.valueOf(number);
 *         }
 *     }
 * Ci sono dei duplicati nelle condizioni che voglio eliminare, faccio refactor fino ad arrivare alla versione attuale
 *      public static String calculate(int number) {
 *         StringBuilder sb = new StringBuilder();
 *         if(number % 3 == 0) sb.append("Fizz");
 *         if(number % 5 == 0) sb.append("Buzz");
 *         if(sb.length() == 0) sb.append(number);
 *         return sb.toString();
 *     }
 * La versione attuale risulta più pulita e sono soddisfatto, quindi concludo con le modifiche
 */