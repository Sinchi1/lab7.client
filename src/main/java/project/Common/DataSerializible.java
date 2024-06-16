package project.Common;

import project.Collections.Coordinates;
import project.Collections.MovieGenre;
import project.Collections.Person;


import java.io.Serializable;
import java.time.ZonedDateTime;

public class DataSerializible implements Serializable {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null@JacksonXmlProperty
    public java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Integer oscarsCount; //Значение поля должно быть больше 0, Поле не может быть nullprivate long goldenPalmCount; //Значение поля должно быть больше 0
    private long length; //Значение поля должно быть больше 0
    private MovieGenre genre; //Поле может быть null
    private Person operator; //Поле может быть null

    public DataSerializible(String name, Coordinates coordinates, ZonedDateTime creationDate, Integer oscarsCount, long length, MovieGenre genre, Person operator) {
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.oscarsCount = oscarsCount;
        this.length = length;
        this.genre = genre;
        this.operator = operator;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    public Integer getOscarsCount() {
        return oscarsCount;
    }

    public long getLength() {
        return length;
    }

    public MovieGenre getGenre() {
        return genre;
    }

    public Person getOperator() {
        return operator;
    }

}
