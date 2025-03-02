/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mephi.b22901.aa.maven_3;

/**
 *
 * @author Andrey
 */
import com.github.javafaker.Faker;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Heretic {
    private String name;
    private List<String> crimes;
    private String lastSeenLocation;
    private String id;
    private String threatLevel;

    private static final String[] THREAT_LEVELS = {"Низкий", "Средний", "Высокий", "Критический"};
    private static final String[] POSSIBLE_CRIMES = {
            "Ересь", "Осквернение святынь", "Ведьмовство", "Призыв демонов", "Культистская деятельность",
            "Жертвоприношения", "Кража реликвий", "Подстрекательство к бунту"
    };

    public Heretic() {
        Faker faker = new Faker();
        Random random = new Random();

        this.name = faker.name().fullName();
        this.lastSeenLocation = faker.address().city();
        this.id = faker.idNumber().valid();

        // Выбираем случайный уровень угрозы
        this.threatLevel = THREAT_LEVELS[random.nextInt(THREAT_LEVELS.length)];

        // Определяем диапазон количества преступлений на основе уровня угрозы
        int minCrimes, maxCrimes;
        switch (threatLevel) {
            case "Низкий":
                minCrimes = 1; maxCrimes = 2;
                break;
            case "Средний":
                minCrimes = 2; maxCrimes = 3;
                break;
            case "Высокий":
                minCrimes = 3; maxCrimes = 4;
                break;
            case "Критический":
                minCrimes = 4; maxCrimes = 6;
                break;
            default:
                minCrimes = 1; maxCrimes = 2;
        }

        // Генерируем случайное количество преступлений в заданном диапазоне
        int crimeCount = minCrimes + random.nextInt(maxCrimes - minCrimes + 1);
        this.crimes = new ArrayList<>();
        for (int i = 0; i < crimeCount; i++) {
            this.crimes.add(POSSIBLE_CRIMES[random.nextInt(POSSIBLE_CRIMES.length)]);
        }
    }

    public String getName() {
        return name;
    }

    public List<String> getCrimes() {
        return crimes;
    }

    public String getLastSeenLocation() {
        return lastSeenLocation;
    }

    public String getId() {
        return id;
    }

    public String getThreatLevel() {
        return threatLevel;
    }

    @Override
    public String toString() {
        return name + " (" + threatLevel + ")";
    }
}