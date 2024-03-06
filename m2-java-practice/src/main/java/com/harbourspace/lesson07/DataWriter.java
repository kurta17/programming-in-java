package com.harbourspace.lesson07;

import java.nio.file.Path;
import java.util.List;

// DataWriter interface
public interface DataWriter {
    void writeData(List<City> cities, String filePath);
}

