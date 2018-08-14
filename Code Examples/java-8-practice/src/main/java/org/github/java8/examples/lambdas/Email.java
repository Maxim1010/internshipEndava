package org.github.java8.examples.lambdas;

import java.util.function.Function;

public class Email {

    public static String withHeader(String text){
        return "Hello," + text;
    }

    public static String withFooter(String text){
        return text + "Best regards";
    }

    public static String withBody(String text){
        return "Intro: " + text + "Outro: ";
    }


    public static void main(String...args){
        Function<String, String> addHeader = Email::withHeader;
        Function<String, String> transformationPipeline
                = addHeader.andThen(Email::withBody)
                .andThen(Email::withFooter);

        System.out.println(transformationPipeline.apply("I am contacting you regarding the java 8 lambda chaining"));
    }

}
