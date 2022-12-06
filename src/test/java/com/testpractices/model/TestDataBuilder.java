package com.testpractices.model;

import com.github.javafaker.Faker;

public class TestDataBuilder {

    private static final Faker FAKER = Faker.instance();

    public static RegisterUserData getRegisterUserData(){
        return RegisterUserData.builder().firstName(FAKER.name().firstName())
                .lastName(FAKER.name().lastName())
                .email(FAKER.internet().emailAddress())
                .telephone(String.valueOf(FAKER.number()
                        .numberBetween(4000000L,5999999L)))
                .build();
    }
}
