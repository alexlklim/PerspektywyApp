package com.alex.perspektywy.users.domain.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum City {
    WARSAW("Warszawa"),
    KRAKOW("Kraków"),
    LODZ("Łódź"),
    WROCLAW("Wrocław"),
    POZNAN("Poznań"),
    GDANSK("Gdańsk"),
    SZCZECIN("Szczecin"),
    BYDGOSZCZ("Bydgoszcz"),
    LUBLIN("Lublin"),
    KATOWICE("Katowice");


    private final String cityName;

    City(String cityName) {
        this.cityName = cityName;
    }


    public static City fromString(String cityName) {
        for (City city : City.values()) {
            if (city.name().equalsIgnoreCase(cityName)) {
                return city;
            }
        }
        throw new IllegalArgumentException("No enum constant " + cityName + " found in City");
    }
    public static List<String> getAll() {
        return Arrays.stream(City.values())
                .map(City::getCityName)
                .collect(Collectors.toList());
    }

    public String getCityName() {
        return cityName;
    }

}
