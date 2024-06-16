package project.Collections;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.io.Serial;
import java.io.Serializable;

/**
 * A class that is part of the collection
 */
public class Person implements Serializable {
    @Serial
    private static final long serialVersionUID = 1234562132L;

    @JacksonXmlProperty(localName = "personName")
    private String name; //Поле не может быть null, Строка не может быть пустой
    @JacksonXmlProperty(localName = "height")
    private Double height; //Поле может быть null, Значение поля должно быть больше 0
    @JacksonXmlProperty(localName = "eyecolor")
    private Color eyeColor; //Поле не может быть null
    @JacksonXmlProperty(localName = "haircolor")
    private Color hairColor; //Поле не может быть null
    @JacksonXmlProperty(localName = "nationality")
    private Country nationality; //Поле может быть null
    @JacksonXmlProperty(localName = "location")
    private Location location; //Поле не может быть null
    
    public Person(String name, Double height, Color eyeColor, Color hairColor, Country nationality, Location location) {
        this.name = name;
        this.height = height;
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
        this.nationality = nationality;
        this.location = location;
    }

    public Person(){

    }

    public String getName() {
        return name;
    }

    public Double getHeight() {
        return height;
    }

    public Color getEyeColor() {
        return eyeColor;
    }

    public Color getHairColor() {
        return hairColor;
    }

    public Country getNationality() {
        return nationality;
    }

    public Location getLocation() {
        return location;
    }
}