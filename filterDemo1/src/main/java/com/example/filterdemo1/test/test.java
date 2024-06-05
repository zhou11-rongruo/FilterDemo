package com.example.filterdemo1.test;

import cn.hutool.json.*;

import java.util.List;

/**
 * @author zhou11
 * @version 1.0.0
 * @description TODO
 * @date 2024/5/21
 */
public class test {
    public static void main(String[] args)
    {

        String xml =
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                        "<NOTEDATA>\n" +
                        "<NOTE>\n" +
                        "    <TO>Tove</TO>\n" +
                        "    <FROM>Jani</FROM>\n" +
                        "    <HEADING>Reminder</HEADING>\n" +
                        "    <BODY>Don't forget me this weekend!</BODY>\n" +
                        "</NOTE>\n"+
                        "<NOTE>\n" +
                        "    <TO>To</TO>\n" +
                        "    <FROM>Ji</FROM>\n" +
                        "    <HEADING>Remi</HEADING>\n" +
                        "    <BODY>Don't forget me this weekend?</BODY>\n" +
                        "</NOTE>\n"
                        +"</NOTEDATA>\n";

        JSONObject object = XML.toJSONObject(xml);

        JSONArray array = (JSONArray) ((JSONObject)object.get("NOTEDATA")).get("NOTE");

        JSONArray jsonArray = new JSONArray();
        for (int i = 0; i < array.size(); i++) {
            JSONObject realJsonObject = new JSONObject();
            String key;
            JSONObject jsonObject = array.getJSONObject(i);
            for (String jsonKey : jsonObject.keySet()) {
                key = jsonKey.toLowerCase();
                realJsonObject.putIfAbsent(key, jsonObject.get(jsonKey));
            }
            jsonArray.add(realJsonObject);
        }


        List<TestDto> list = JSONUtil.toList(jsonArray, TestDto.class);
        for (TestDto testDto : list) {
            System.out.println(testDto.getTo());
            System.out.println(testDto.getFrom());
            System.out.println(testDto.getHeading());
            System.out.println(testDto.getBody());
        }


        System.out.println(object);
        System.out.println(array);
        System.out.println(jsonArray);
    }
}
