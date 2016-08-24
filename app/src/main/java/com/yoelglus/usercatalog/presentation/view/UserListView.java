package com.yoelglus.usercatalog.presentation.view;

import com.yoelglus.usercatalog.presentation.model.UserModel;

import java.util.List;

public interface UserListView {
    void showUsersList(List<UserModel> listOfUsers);
}
