package com.aurasoftwareinc.java.challenge1;

import org.json.JSONObject;

public class ObjectTypes implements JsonMarshalInterface
{
    public Byte objByte;
    private Short objShort;
    public Integer objInt;
    private Long objLong;

    private Float objFloat;
    private Double objDouble;
    private Double objDoubleNull;

    public Boolean objBoolean;
    public Boolean objBooleanNull;

    public String objString;
    public String objStringNull;

    public Byte[] objByteArray;
    public Byte[] objByteArrayNull;

    public ObjectTypes(Byte objByte, Short objShort, Integer objInt, Long objLong, Float objFloat, Double objDouble, Double objDoubleNull, Boolean objBoolean, Boolean objBooleanNull, String objString, String objStringNull, Byte[] objByteArray, Byte[] objByteArrayNull) {
        this.objByte = objByte;
        this.objShort = objShort;
        this.objInt = objInt;
        this.objLong = objLong;
        this.objFloat = objFloat;
        this.objDouble = objDouble;
        this.objDoubleNull = objDoubleNull;
        this.objBoolean = objBoolean;
        this.objBooleanNull = objBooleanNull;
        this.objString = objString;
        this.objStringNull = objStringNull;
        this.objByteArray = objByteArray;
        this.objByteArrayNull = objByteArrayNull;
    }

    public ObjectTypes() {
    }

    public void populateTestData()
    {
        objByte = 42;
        objShort = 4242;
        objInt = 47114711;
        objLong = 12345678901234567L;
        objFloat = 42.5f;
        objDouble = 42.123456789012345;
        objBoolean = true;
        objString = "abcdefghijk";
        objByteArray = new Byte[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 14};
    }

    @Override
    public JSONObject marshalJSON()
    {
        return JsonMarshal.marshalJSON(this);
    }

    @Override
    public boolean unmarshalJSON(JSONObject json)
    {
        return JsonMarshal.unmarshalJSON(this, json);
    }
}
