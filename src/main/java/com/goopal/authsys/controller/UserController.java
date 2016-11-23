package com.goopal.authsys.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.google.common.base.Optional;
import com.goopal.authsys.domain.User;
import com.goopal.authsys.service.UserService;
import com.goopal.authsys.utils.DateUtil;

/**
 * 用户信息
 * 
 * @author zhangxianglong
 */
@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserService userService;

    /**
     * 添加用户
     * 
     * @param userMap
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public Map<String, Object> createUser(@RequestBody Map<String, Object> userMap){
        User user = new User(userMap.get("userNum").toString(),
                             userMap.get("password").toString(), 
                             userMap.get("realName").toString(), 
                             Byte.valueOf(userMap.get("sex").toString()),
                             userMap.get("userEmail").toString(), 
                             userMap.get("innerEmail").toString(), 
                             userMap.get("mobile").toString(), 
                             Integer.valueOf(userMap.get("departmentId").toString()), 
                             DateUtil.stringToDate(userMap.get("entryDatetime").toString()), 
                             DateUtil.stringToDatetime(userMap.get("createTime").toString()), 
                             DateUtil.stringToDatetime(userMap.get("updateTime").toString())
                             );

        Map<String, Object> response = new LinkedHashMap<String, Object>();
        response.put("message", "User created successfully");
        response.put("user", userService.insertSelective(user));
        return response;
    }

    /**
     * 获取用户详情
     * 
     * @param userId
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/{userId}")
    public User getUserDetails(@PathVariable("userId") Integer userId){
        Optional<Integer> optUserId = Optional.fromNullable(userId);
        if (!optUserId.isPresent()) {
            return null;
        }
        return userService.selectByPrimaryKey(userId);
    }

    /**
     * 编辑用户信息
     * 
     * @param userId
     * @param userMap
     * @return
     */
    @RequestMapping(method = RequestMethod.PUT, value = "/{userId}")
    public Map<String, Object> editUser(@PathVariable("userId") Integer userId,
                                        @RequestBody Map<String, Object> userMap){
        User user = new User();
        user.setDepartmentId(Integer.valueOf(userMap.get("departmentId").toString()));
        user.setEntryDatetime(DateUtil.stringToDate(userMap.get("entryDatetime").toString()));
        user.setMobile(userMap.get("mobile").toString());
        user.setId(userId);
        
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        response.put("message", "User updated successfully");
        response.put("user", userService.updateByPrimaryKeySelective(user));
        return response;
    }

    /**
     * 删除用户
     * 
     * @param userId
     * @return
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/{userId}")
    public Map<String, String> deleteUser(@PathVariable("userId") Integer userId){
        userService.deleteByPrimaryKey(userId);
        Map<String, String> response = new HashMap<String, String>();
        response.put("message", "User deleted successfully");
        return response;
    }

    /**
     * 获取全部用户
     * 
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public Map<String, Object> getAllUsers(){
        List<User> users = userService.getAllUsers();
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        response.put("totalUsers", response.size());
        response.put("users", users);
        return response;
    }

}
