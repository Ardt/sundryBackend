package com.ardt.sundry.api;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.ardt.sundry.dto.UserDTO;
import com.ardt.sundry.model.User;
import com.ardt.sundry.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = { UserController.class })
class UserControllerTest {
    static final private String rootPath = "/api/v1/user/";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    private Gson gson = new Gson();
    private ObjectMapper mapper = new ObjectMapper();

    void getMockedUser(List<User> users) throws Exception {
        mockMvc.perform(get(rootPath)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(gson.toJson(users)))
                .andDo(print());
    }

    @DisplayName("Basic CRUD Test")
    @Test
    void basicCRUDTest() throws Exception {
        String testUserId = "TestUserId";
        String testEmail = "test@test.com";
        String testName = "TestName";
        UserDTO userDto = UserDTO.builder()
                .id(testUserId)
                .email(testEmail)
                .name(testName)
                .build();
        List<User> users = new ArrayList<User>();
        given(userService.findAll()).willReturn(users);

        getMockedUser(users);

        // Get all object API test
        mockMvc.perform(put(rootPath)
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.ALL)
        .content(mapper.writeValueAsString(userDto)))
        .andExpect(status().isOk())
        .andExpect(content().string(""))
        .andDo(print());

        // Add object
        users.add(userDto.toUser());
        getMockedUser(users);
        
        given(userService.findById(testUserId)).willReturn(
            users.stream()
                .filter(review -> review.getId() == testUserId)
                .findFirst());

        given(userService.findByEmail(testEmail)).willReturn(
            users.stream()
                .filter(review -> review.getEmail() == testEmail)
                .findFirst());
        
        mockMvc.perform(get(rootPath + "id/" + testUserId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(gson.toJson(users.get(0))))
                .andDo(print());

        mockMvc.perform(get(rootPath + "email/" + testEmail)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(gson.toJson(users.get(0))))
                .andDo(print());

        mockMvc.perform(get(rootPath + "id/" + testUserId + "dummy")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("null"))
                .andDo(print());

                // Delete object API Test
        mockMvc.perform(delete(rootPath)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.ALL)
                .content(testUserId))
                .andExpect(status().isOk())
                .andExpect(content().string(""))
                .andDo(print());

        users.remove(0);

        given(userService.findById(testUserId)).willReturn(
            users.stream()
                .filter(review -> review.getId() == testUserId)
                .findFirst());

        mockMvc.perform(get(rootPath + "id/" + testUserId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("null"))
                .andDo(print());
    }
}
