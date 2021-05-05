package com.huade.service;

import com.huade.Utils.UtilTools;
import com.huade.mapper.UserMapper;
import com.huade.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper mapper;

    public int addUser(User user) throws Exception {
        return mapper.addUser(user);
    }

    public int batchAddUser(List<Map<String, Object>> userList) throws Exception {
        return mapper.batchAddUser(userList);
    }

    public int deleteUser(String user_Id) {
        return mapper.deleteUser(user_Id);
    }

    public int updateUser(User user) {
        return mapper.updateUser(user);
    }

    public List<User> selectAllUser() {
        return mapper.selectAllUser();
    }

    public User Login(String user_Id, String password) {
        return mapper.Login(user_Id, UtilTools.Encrypted_MD5(password));
    }

    @Override
    public int editPassword(String user_Id, String newPassword) {
        return mapper.editPassword(user_Id, UtilTools.Encrypted_MD5(newPassword));
    }
}
