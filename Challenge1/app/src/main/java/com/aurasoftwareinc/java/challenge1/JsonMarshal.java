package com.aurasoftwareinc.java.challenge1;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class JsonMarshal
{
    public static JSONObject marshalJSON(Object object)
    {
        // declaring a new jsonobject holder
        JSONObject json = new JSONObject();

        // declaring a new instance of subclasstypes object
        SubclassTypes t = (SubclassTypes)object;

        // getting the fields of subclasstypes object
        Field[] fields = t.getClass().getDeclaredFields();

        // iterating through the fields
        for (Field field : fields) {

            // if there is a private member I change the accessibility to read its properties
            if (Modifier.isPrivate(field.getModifiers())) {
                field.setAccessible(true);
            }
            try {

                // read the classname of the current field
                String classname = (field.get(t) != null ?  field.get(t).getClass().getCanonicalName()  : "");

                // if it is a class of the current package is correct
                if(classname.contains("challenge1")){

                    // getting the fieldname to pass as a key for the final json
                    String fieldName = field.getName();

                    // getting the fields of the internal members
                    Field[] fields1 = field.get(t).getClass().getDeclaredFields();

                    // declaring a new jsonobject holder for the internal members to pass a value for the current key of the final json
                    JSONObject json1 = new JSONObject();

                    // iterating through the fields
                    for (Field field2 : fields1){

                        // if there is a private member I change the accessibility to read its properties
                        if (Modifier.isPrivate(field2.getModifiers())) {
                            field2.setAccessible(true);
                        }

                        // if the name of the member is valid it's ok to pass to the current json object
                        if(!(field2.getName().equals("serialVersionUID") || field2.getName().equals("$change"))) {
                            json1.put(field2.getName(), (field2.get(field.get(t))));
                        }
                    }

                    // after populating the value json I pass it as a value of the current json key
                    json.put(fieldName, json1);
                }
            } catch (Exception e) {

            }
        }

        return json;
    }

    public static boolean unmarshalJSON(Object object, JSONObject json)
    {

        try {
            // declaring an instance of the first member of the SubclassTypes object
            JSONObject primitiveTypes = json.getJSONObject("primitiveTypes");

            // reading the values of the first json key mapped as values for the first member of SubclassTypes object
            boolean primBoolean = primitiveTypes.getBoolean("primBoolean");
            byte primByte = (byte)primitiveTypes.getInt("primByte");
            byte[] primByteArray = (byte [])primitiveTypes.get("primByteArray");
            double primDouble = primitiveTypes.getDouble("primDouble");
            float primFloat = BigDecimal.valueOf(primitiveTypes.getDouble("primFloat")).floatValue();
            int primInt = primitiveTypes.getInt("primInt");
            long primLong = primitiveTypes.getLong("primLong");
            short primShort = (short)primitiveTypes.getInt("primShort");

            // assigning the first values to the first object member
            ((SubclassTypes)object).primitiveTypes =  new PrimitiveTypes(primByte, primShort, primInt, primLong, primFloat, primDouble, primBoolean, primByteArray);

            // declaring an instance of the second member of the SubclassTypes object
            JSONObject objectTypes = json.getJSONObject("objectTypes");

            // reading the values of the second json key mapped as values for the second member of SubclassTypes object
            Boolean objBoolean = objectTypes.getBoolean("objBoolean");
            Byte objByte = (Byte)objectTypes.get("objByte");
            Byte[] objByteArray = (Byte[])objectTypes.get("objByteArray");
            Double objDouble = objectTypes.getDouble("objDouble");
            Float objFloat = Float.parseFloat(objectTypes.getString("objFloat"));
            Integer objInt = Integer.getInteger(objectTypes.getString("objInt"));
            Long objLong = objectTypes.getLong("objLong");
            Short objShort = (Short)objectTypes.get("objShort");
            String objString = objectTypes.getString("objString");

            // assigning the second values to the second object member
            ((SubclassTypes)object).setObjectTypes(new ObjectTypes(objByte, objShort, objInt, objLong, objFloat, objDouble, null, objBoolean, null, objString, null, objByteArray, null));

            // declaring an instance of the third member of the SubclassTypes object
            JSONObject jsonTypes = json.getJSONObject("jsonTypes");

            // reading the values of the third json key mapped as values for the third member of SubclassTypes object
            JSONArray jsonArray = jsonTypes.getJSONArray("jsonArray");
            JSONObject jsonObject = jsonTypes.getJSONObject("jsonObject");

            // assigning the third values to the third object member
            ((SubclassTypes)object).jsonTypes = new JSONTypes(jsonObject, jsonArray);

        } catch (JSONException e) {

        }

        return true;
    }
}