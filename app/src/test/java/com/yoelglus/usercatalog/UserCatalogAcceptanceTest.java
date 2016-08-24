package com.yoelglus.usercatalog;

import com.yoelglus.usercatalog.data.model.UserData;
import com.yoelglus.usercatalog.data.respository.UsersRepository;
import com.yoelglus.usercatalog.presentation.model.UserModel;
import com.yoelglus.usercatalog.presentation.presenter.UserDetailsPresenter;
import com.yoelglus.usercatalog.presentation.presenter.UserListPresenter;
import com.yoelglus.usercatalog.presentation.view.UserDetailsView;
import com.yoelglus.usercatalog.presentation.view.UserListView;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class UserCatalogAcceptanceTest {

    private UsersRepository usersRepository;

    @Before
    public void setUp() throws Exception {
        usersRepository = mock(UsersRepository.class);
    }

    @Test
    public void show_the_users_list() throws Exception {
        UserListView view = mock(UserListView.class);
        List<UserData> listOfUsers = userListContaining();
        given(usersRepository.getUsersList()).willReturn(listOfUsers);

        UserListPresenter presenter = new UserListPresenter();
        presenter.getUsersList();

        List<UserModel> listOfUserModels = userModelsListContaining();
        verify(view).showUsersList(listOfUserModels);
    }

    @Test
    public void show_specific_user_details() throws Exception {
        UserModel userDetails = new UserModel();
        UserDetailsView view = mock(UserDetailsView.class);
        UserData userData = new UserData();
        given(usersRepository.getUserDetails()).willReturn(userData);

        UserDetailsPresenter presenter = new UserDetailsPresenter();
        presenter.getUserDetails();

        verify(view).showUserDetails(userDetails);
    }

    private List<UserData> userListContaining(UserData... userDatas) {
        return asList(userDatas);
    }

    private List<UserModel> userModelsListContaining(UserModel... userModels) {
        return asList(userModels);
    }
}
