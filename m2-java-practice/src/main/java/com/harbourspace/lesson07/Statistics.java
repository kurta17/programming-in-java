package com.harbourspace.lesson07;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
// Statistics interface
import java.util.Collection;

public interface Statistics {
    Collection<City> getTopCountryCities(String country, int size);
}
