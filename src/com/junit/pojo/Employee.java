package com.junit.pojo;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Employee {


    static final String PATH = "src/com/junit/ui/sample.json";
    /**
        This will print the all information like: first_name, last_name, mobile, status, address, working_days
     */
    public void getInfo() throws IOException {

        File file=new File(PATH);
        ObjectMapper objectMapper= new ObjectMapper();
        JsonNode node=objectMapper.readTree(file);
        System.out.println(node.get("first_name"));
        System.out.println(node.get("last_name"));
        System.out.println(node.get("mobile"));
        System.out.println(node.get("status"));
        System.out.println(node.get("address"));
        System.out.println(node.get("working_days"));
    }

    /**
        This will update the value provided for the key name in parameters:
     */
    public void updateMobileInfo(String update, String value) throws IOException {
        File file=new File(PATH);
        ObjectMapper objectMapper= new ObjectMapper();
        JsonNode node=objectMapper.readTree(file);
        ((ObjectNode)node).put(update,value);
        Files.write(Paths.get(PATH),node.toString().getBytes(StandardCharsets.UTF_8));
        System.out.println(node.get(update));
    }

    /**
        This will delete the value provided for the key name in parameters:
     */
    public void deleteMobileInfo(String mobile) throws IOException {
        File file = new File(PATH);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode node = objectMapper.readTree(file);
        ((ObjectNode)node).put(mobile, "");
        Files.write(Paths.get(PATH), node.toString().getBytes(StandardCharsets.UTF_8));
        System.out.println(node.get(mobile));
    }

    /**
        This will fetch the value of findSecondWorkingDays:
     */
    public void findSecondWorkingDays() throws IOException {
        File file = new File(PATH);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode node = objectMapper.readTree(file);
        System.out.println(node.get("working_days").get(1));
    }
}
