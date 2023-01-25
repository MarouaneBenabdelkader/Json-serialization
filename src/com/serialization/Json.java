package com.serialization;

import com.serialization.annotations.Marked;
import com.serialization.annotations.SerializableToJSON;


import java.lang.reflect.Field;

public class Json {

    public static String toJSON(Object obj) throws IllegalAccessException {
        String json = "";
        if(!obj.getClass().isAnnotationPresent(SerializableToJSON.class)) return json;

         json += "{ \n";
        Field[] fields = obj.getClass().getDeclaredFields();

        for (Field field:fields){
            field.setAccessible(true);
            if(field.isAnnotationPresent(Marked.class)) {

                if(field.getAnnotation(Marked.class).name().equals("")) json += "\"" + field.getName() + "\":";
                else json += "\"" + field.getAnnotation(Marked.class).name() + "\":";

                if ((field.getType().toString().equals("int")) || (field.getType().toString().equals("boolean")) || (field.getType().toString().equals("float")))
                    json += field.get(obj);
                else
                    json += "\"" + field.get(obj) + "\"";

                json += ", \n";
            }
        }

        json += "}";

        return  json;
    }
}
