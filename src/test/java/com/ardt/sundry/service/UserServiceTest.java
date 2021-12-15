package com.ardt.sundry.service;

import static org.mockito.Mockito.verify;

import com.ardt.sundry.dao.UserDao;
import com.ardt.sundry.model.User;
import com.ardt.sundry.util.RandomModel;

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

    @Test
    public void basicTest() throws Exception {
        final User location = RandomModel.getRandomUser();

        locationService.insertUser(location);
        verify(userDao).insertUser(location);
        
        locationService.findAll();
        verify(userDao).findAll();
        
        locationService.findByEmail(location.getEmail());
        verify(userDao).findByEmail(location.getEmail());

        locationService.findById(location.getId());
        verify(userDao).findById(location.getId());
        
        locationService.deleteById(location.getId());
        verify(userDao).deleteById(location.getId());
    }
}
