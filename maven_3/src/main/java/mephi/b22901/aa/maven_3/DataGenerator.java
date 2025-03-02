/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mephi.b22901.aa.maven_3;

import com.github.javafaker.Faker;
import java.util.Random;

public class DataGenerator {
    private static final Faker faker = new Faker();
    private static final String[] threatLevels = {"Низкий", "Средний", "Высокий", "Критический"};

    public static Heretic generateHeretic() {
        String name = faker.name().fullName();
        String crimes = faker.lorem().sentence();
        String lastSeenLocation = faker.address().city();
        String id = faker.idNumber().valid();
        String threatLevel = threatLevels[new Random().nextInt(threatLevels.length)];

        return new Heretic();
    }
}