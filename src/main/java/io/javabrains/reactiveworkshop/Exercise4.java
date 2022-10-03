package io.javabrains.reactiveworkshop;

import java.io.IOException;
import java.util.Optional;

public class Exercise4 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono()

        // Print the value from intNumberMono when it emits
        ReactiveSources.intNumberMono().subscribe(integer -> System.out.println(integer));

        // Get the value from the Mono into an integer variable
        Integer value = ReactiveSources.intNumberMono().block();
        System.out.println(value);

        Optional<Integer> optionalValue = ReactiveSources.intNumberMono().blockOptional();
        optionalValue.ifPresentOrElse(integer -> System.out.println(integer), () -> System.out.println("null"));


        System.out.println("Press a key to end");
        System.in.read();
    }

}
