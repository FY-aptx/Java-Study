package com.fy.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.SimpleDateFormat;

public class JsonUtils {

    public static String getJson(Object object){
        return getJson(object,"yyyy-MM-dd HH:mm:dd");
    }


    public static String getJson(Object object,String dateFormat){
        //json
        ObjectMapper mapper = new ObjectMapper();

        //不适用时间戳定义时间
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);
        //定义日期格式
        SimpleDateFormat sdf=new SimpleDateFormat(dateFormat);
        mapper.setDateFormat(sdf);
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
