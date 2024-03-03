package com.harbourspace.lesson10;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Json {
    public static String toJSON(Object obj) throws Exception {
        Map<String, Object> jsonMap = new HashMap<>();
        for (Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Object value = field.get(obj);
            if (value != null) {
                if (value instanceof LocalDate) {
                    // Convert LocalDate to String in ISO-8601 format
                    value = ((LocalDate) value).toString();
                }
                jsonMap.put(field.getName(), value);
            }
        }
        StringBuilder json = new StringBuilder("{");
        for (Map.Entry<String, Object> entry : jsonMap.entrySet()) {
            json.append("\"").append(entry.getKey()).append("\":\"");
            json.append(entry.getValue()).append("\",");
        }
        if (!jsonMap.isEmpty()) {
            json.deleteCharAt(json.length() - 1); // Remove the last comma
        }
        json.append("}");
        return json.toString();
    }
}
