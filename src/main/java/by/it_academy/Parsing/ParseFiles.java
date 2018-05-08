package by.it_academy.Parsing;

import by.it_academy.Weather.Weather;

import java.io.IOException;
import java.util.List;

public interface ParseFiles {
    List<Weather> read() throws IOException, Exception;
}
