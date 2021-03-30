package com.huade.controller;

import com.huade.pojo.User_Type;
import com.huade.service.UserTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/UserType")
public class UserTypeController {
    @Autowired
    private UserTypeServiceImpl userTypeService;

    @RequestMapping("/SelectUserType_Id")
    @ResponseBody
    public String selectUserType_Id(@RequestParam("Id")String Id){
        return userTypeService.selectUserType_Id(Id);
    }

    @RequestMapping("/SelectAllUserType")
    @ResponseBody
    public List<User_Type> selectAllUserType(){
        return userTypeService.selectAllUserType();
    }

//    @RequestMapping("/AddUserType")
//    @ResponseBody
//    public String addUserType(HttpSession session)throws JsonProcessingException{
//        JSONObject object = new JSONObject();
//        ObjectMapper mapper = new ObjectMapper();
//        if (session.getAttribute("login_session") != null) {
//                object.put("code", 1);
//                object.put("message", "success");
//                object.put("data",session.getAttribute("login_session"));
//                return mapper.writeValueAsString(object);
//        }else {
//            object.put("code",-1);
//            object.put("message","登录状态失效！请重新登录！");
//            return mapper.writeValueAsString(object);
//        }
//    }

    @RequestMapping("/AddUserType")
    @ResponseBody
    public int addUserType(@RequestParam("user_Type")String user_Type){
        User_Type user_type = new User_Type(UUID.randomUUID().toString().replace("-",""),user_Type);
        return userTypeService.addUserType(user_type);
    }

    @RequestMapping("/DeleteUserType")
    @ResponseBody
    public int deleteUserType(@RequestParam("Id")String Id){
        return userTypeService.deleteUserType(Id);
    }

    @RequestMapping("/UpdateUserType")
    @ResponseBody
    public int updateUserType(@RequestParam("Id")String Id,
                              @RequestParam("user_Type")String user_Type){
        User_Type user_type = new User_Type(Id,user_Type);
        return userTypeService.updateUserType(user_type);
    }

}
