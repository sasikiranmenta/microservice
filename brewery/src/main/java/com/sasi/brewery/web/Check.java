package com.sasi.brewery.web;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class Check {
    private static final Logger LOG = LoggerFactory.getLogger(Check.class);

    public static String js(String value) {
        StringBuilder dataBuilder = new StringBuilder();
        dataBuilder.append("<p>").append(value).append("</p>");
        LOG.info(dataBuilder.toString());
        Map<String,String> map = new HashMap<>();

        JSONObject mainData = new JSONObject();
        try{
        mainData.put("title","Secondary Category");
        mainData.put("type","TextArea");
        mainData.put("data","<p>"+value+"</p>");
        }
        catch (JSONException e){
            System.out.println("Unable to parse the provided note"+e);
            return "";
        }
        return mainData.toString();
    }
    public static void main(String args[]){
        LOG.info(Check.js("testing"));
    }
}
