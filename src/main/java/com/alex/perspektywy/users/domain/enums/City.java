package com.alex.perspektywy.users.domain.enums;

public enum City {
    WARSAW, KRAKOW, LODZ, WROCLAW, POZNAN, GDANSK, SZCZECIN, BYDGOSZCZ, LUBLIN, KATOWICE;


    public static City fromString(String cityName) {
        for (City city : City.values()) {
            if (city.name().equalsIgnoreCase(cityName)) {
                return city;
            }
        }
        throw new IllegalArgumentException("No enum constant " + cityName + " found in City");
    }


}
