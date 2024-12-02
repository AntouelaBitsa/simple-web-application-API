package com.simple.web.application.SimpleWebApplicationAPI.Utils;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.simple.web.application.SimpleWebApplicationAPI.Entity.HomeAddress;
import com.simple.web.application.SimpleWebApplicationAPI.Entity.Users;
import com.simple.web.application.SimpleWebApplicationAPI.Entity.WorkAddress;

import java.io.IOException;
import java.time.LocalDate;

//public class UsersDeserializer extends JsonDeserializer<UsersDTO> {
//    @Override
//    public UsersDTO deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
//        ObjectMapper mapper = (ObjectMapper) jsonParser.getCodec();
//        JsonNode node = mapper.readTree(jsonParser);
//
//        UsersDTO users = new UsersDTO();
//        users.setUserID(node.get("userId").asInt());
//        users.setName(node.get("name").asText());
//        users.setSurname(node.get("surname").asText());
//        users.setGender(node.get("gender").asText());
//        users.setBirthDate(LocalDate.parse(node.get("birthDate").asText()));
//
//        WorkAddressDTO workAddress = new WorkAddressDTO();
//        workAddress.setWorkAddress(node.get("workAdd").get("workAddress").asText());
//        users.setWorkAdd(workAddress);
//
//        HomeAddressDTO homeAddress = new HomeAddressDTO();
//        homeAddress.setHomeAddress(node.get("homeAdd").get("homeAddress").asText());
//        users.setHomeAdd(homeAddress);
//
//        return users;
//    }
//}
