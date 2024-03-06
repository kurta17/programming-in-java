package com.harbourspace.lesson10;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

public class Json {
    public static String toJSON(Object obj) throws Exception {
        Map<String, Object> jsonMap = getJsonMap(obj);

        // Define the order of fields for consistent JSON output
        String[] fieldOrder = {"id", "fullName", "course", "isEnrolled", "admissionDate", "graduationDate", "grade"};

        StringBuilder json = new StringBuilder("{");
        for (String fieldName : fieldOrder) {
            if (jsonMap.containsKey(fieldName)) {
                Object value = jsonMap.get(fieldName);
                json.append("\"").append(fieldName).append("\":");
                if (value instanceof String) {
                    json.append("\"").append(value).append("\",");
                } else {
                    json.append(value).append(",");
                }
            }
        }
        if (json.length() > 1) {
            json.deleteCharAt(json.length() - 1); // Remove the last comma
        }
        json.append("}");
        return json.toString();
    }

    private static Map<String, Object> getJsonMap(Object obj) throws IllegalAccessException {
        Map<String, Object> jsonMap = new LinkedHashMap<>(); // Use LinkedHashMap for maintaining insertion order
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
        return jsonMap;
    }
}
