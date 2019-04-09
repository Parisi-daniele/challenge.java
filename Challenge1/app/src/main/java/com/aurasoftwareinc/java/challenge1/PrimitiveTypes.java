package com.aurasoftwareinc.java.challenge1;

import org.json.JSONObject;

public class PrimitiveTypes implements JsonMarshalInterface
{
    public byte primByte;
    private short primShort;
    public int primInt;
    private long primLong;
    public float primFloat;
    private double primDouble;
    public boolean primBoolean;

    public byte[] primByteArray;

    public PrimitiveTypes(byte primByte, short primShort, int primInt, long primLong, float primFloat, double primDouble, boolean primBoolean, byte[] primByteArray) {
        this.primByte = primByte;
        this.primShort = primShort;
        this.primInt = primInt;
        this.primLong = primLong;
        this.primFloat = primFloat;
        this.primDouble = primDouble;
        this.primBoolean = primBoolean;
        this.primByteArray = primByteArray;
    }

    public PrimitiveTypes() {
    }

    public void populateTestData()
    {
        primByte = 42;
        primShort = 4242;
        primInt = 47114711;
        primLong = 12345678901234567L;
        primFloat = 42.5f;
        primDouble = 42.123456789012345;
        primBoolean = true;
        primByteArray = new byte[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 14};
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
