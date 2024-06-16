package project.Collections;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.io.Serial;
import java.io.Serializable;

/**
 * A class that is part of the collection
 */
public class Coordinates implements Serializable {

    @Serial
    private static final long serialVersionUID = 12345L;
    @JacksonXmlProperty(localName = "x")
    private int x; //Максимальное значение поля: 985
    @JacksonXmlProperty(localName = "y")
    private long y;
    public Coordinates(int x, long y) {
        this.x = x;
        this.y = y;
    }

    public Coordinates(){
    }
    public int getX() {
        return x;
    }
    public long getY() {
        return y;
    }


}