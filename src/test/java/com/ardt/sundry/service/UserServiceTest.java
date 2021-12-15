package com.ardt.sundry.service;

import static org.mockito.Mockito.verify;

import com.ardt.sundry.dao.intf.UserDao;
import com.ardt.sundry.model.User;
import com.ardt.sundry.util.RandomModel;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserDao userDao;

    @InjectMocks
    private UserService locationService;

    @DisplayName("given object to save when save object using MongoDB template then object is saved")
    @Test
    public void makeNewUser() throws Exception {
        final User location = RandomModel.getRandomUser();

        locationService.insertUser(location);
        
        verify(userDao).insertUser(location);
        
        // assertEquals(locationService.findAll().get(0), location);
        // assertEquals(location.getId(), userDao.findAll().get(0).getId());
    }
}
