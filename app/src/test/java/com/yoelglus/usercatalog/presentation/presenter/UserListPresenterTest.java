package com.yoelglus.usercatalog.presentation.presenter;

import com.yoelglus.usercatalog.data.respository.UsersRepository;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class UserListPresenterTest {

    @Test
    public void get_the_users_list_from_the_repository() throws Exception {
        UsersRepository usersRepository = mock(UsersRepository.class);

        UserListPresenter presenter = new UserListPresenter();
        presenter.getUsersList();

        verify(usersRepository).getUsersList();
    }
}