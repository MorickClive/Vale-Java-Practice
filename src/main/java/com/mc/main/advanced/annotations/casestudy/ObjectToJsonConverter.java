package com.mc.main.advanced.annotations.casestudy;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

// Here we can take advantage of the implementation with Annotations.
public class ObjectToJsonConverter {
	
	// A simple method to convert our target class into a JSON string format.
    public static String convertToJson(Object object) throws Exception {
        try {
            isSerializable(object); // check
            prepareObject(object); // setup
            return getJsonString(object); // creation/release
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
    // Main method of translation using java reflection based around
    // Fields annotated with "JSONElement"
    private static String getJsonString(Object object) throws Exception {	
        Class<?> clazz = object.getClass();
        Map<String, String> jsonElementsMap = new HashMap<>();
        
        // Extract each field to Map for later management
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(JsonElement.class)) {
                jsonElementsMap.put(getKey(field), (String) field.get(object));
            }
        }		
         
        String jsonString = jsonElementsMap.entrySet()
            .stream()
            .map(entry -> String.format("%3$s%1$s%4$s%2$s%3$s", 
            		entry.getKey(), entry.getValue(), "\"", "\":\""))
            .collect(Collectors.joining(","));
        
        return "{" + jsonString + "}";
    }
    
    // Let's find any Method capability that is annotated to be a initialising process
    // Via reflection
    private static void prepareObject(Object object) throws Exception {
        Class<?> clazz = object.getClass();
        
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Init.class)) {
                method.setAccessible(true);
                method.invoke(object);
            }
        }
        
     }
    
    // Simple check to determine if the target object is annotated for the process
    // we are looking to achieve.
    private static void isSerializable(Object object) throws Exception {
    	
        if (Objects.isNull(object)) {
            throw new Exception("The object to serialize is null");
        }
            
        Class<?> clazz = object.getClass();
        
        if (!clazz.isAnnotationPresent(JsonSerializable.class)) {
            throw new Exception("The class " 
              + clazz.getSimpleName() 
              + " is not annotated with JsonSerializable");
        }
    }
    
    // Let's check if there's a key provided to us, if not - use field name instead!
    private static String getKey(Field field) {
        String value = field.getAnnotation(JsonElement.class).key();
        return value.isEmpty() ? field.getName() : value;
    }
	
}
