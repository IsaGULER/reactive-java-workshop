package io.javabrains.reactiveworkshop;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream
        StreamSources.intNumbersStream().forEach(number -> System.out.println(number));

        StreamSources.intNumbersStream().forEach(System.out::println);

        // Print numbers from intNumbersStream that are less than 5
        StreamSources.intNumbersStream().filter(number -> number < 5).forEach(number -> System.out.println(number));

        // Print the second and third numbers in intNumbersStream that's greater than 5
        StreamSources.intNumbersStream().filter(number -> number > 5)
                .skip(1L)
                .limit(2L)
                .forEach(number -> System.out.println(number)); //can do it better???

        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        StreamSources.intNumbersStream().filter(number -> number > 5)
                .findFirst()
                .ifPresentOrElse(number -> System.out.println(number), () -> System.out.println("-1"));

        Integer value = StreamSources.intNumbersStream().filter(number -> number > 5)
                .findFirst()
                .orElse(-1);
        System.out.println(value);

        // Print first names of all users in userStream
        StreamSources.userStream().map(User::getFirstName).forEach(firstName -> System.out.println(firstName));

        // Print first names in userStream for users that have IDs from number stream
        StreamSources.userStream().filter(user -> StreamSources.intNumbersStream().toList().contains(user.getId()))
                .forEach(user -> System.out.println(user.getFirstName()));

        StreamSources.userStream().filter(user -> StreamSources.intNumbersStream().anyMatch(number -> number == user.getId()))
                .forEach(System.out::println);

        StreamSources.intNumbersStream().flatMap(id -> StreamSources.userStream().filter(user -> user.getId() == id))
                .map(User::getFirstName)
                .forEach(firstName -> System.out.println(firstName)); //flatmap example


    }

}
