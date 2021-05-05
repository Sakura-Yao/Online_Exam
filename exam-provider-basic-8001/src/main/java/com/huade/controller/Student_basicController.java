package com.huade.controller;

import com.huade.Utils.UtilTools;
import com.huade.pojo.Student_Basic;
import com.huade.pojo.User;
import com.huade.pojo.View_StudentBasicInfo;
import com.huade.service.StudentBasicServiceImpl;
import com.huade.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/Student_basic")
public class Student_basicController {
    @Autowired
    private StudentBasicServiceImpl studentBasicService;

    @Autowired
    private UserServiceImpl userService;



    @RequestMapping("/addStudentBasic")
    @ResponseBody
    public int addStudentBasic (@RequestParam("user_Id") String user_Id,
                                 @RequestParam("password") String password,
                                 @RequestParam("user_Name") String user_Name,
                                 @RequestParam("user_Type") String user_Type,
                                 @RequestParam("user_Sex")String user_Sex,
                                 @RequestParam("user_Mobile") String user_Mobile,
                                 @RequestParam("stu_ClassId") String stu_ClassId,
                                 @RequestParam("stu_College")String stu_College,
                                 @RequestParam("stu_Specialty")String stu_Specialty){
            User user = new User(user_Id, UtilTools.Encrypted_MD5(password),user_Name,user_Type,user_Sex,user_Mobile);
            Student_Basic student_basic = new Student_Basic(user_Id,stu_ClassId,stu_College,stu_Specialty);
        try {
            if ( userService.addUser(user) == 1 && studentBasicService.addStudentBasic(student_basic) == 1)
                return 1;
            else
                return 0;
        } catch (Exception e) {
            return 0;
        }
    }

    @RequestMapping("/deleteStudentBasic")
    @ResponseBody
    public int deleteStudentBasic(@RequestParam("user_Id")String user_Id) {
        if (studentBasicService.deleteStudentBasic(user_Id)==1 && userService.deleteUser(user_Id) == 1) {
            return 1;
        }else {
            return 0;
        }
    }

    @RequestMapping("/updateStudentBasic")
    @ResponseBody
    public int updateStudentBasic (@RequestParam("user_Id") String user_Id,
                                   @RequestParam("user_Name") String user_Name,
                                   @RequestParam("user_Type") String user_Type,
                                   @RequestParam("user_Sex")String user_Sex,
                                   @RequestParam("user_Mobile") String user_Mobile,
                                   @RequestParam("stu_ClassId") String stu_ClassId,
                                   @RequestParam("stu_College")String stu_College,
                                   @RequestParam("stu_Specialty")String stu_Specialty) {
        User user = new User(user_Id,"",user_Name,user_Type,user_Sex,user_Mobile);
        Student_Basic student_basic = new Student_Basic(user_Id,stu_ClassId,stu_College,stu_Specialty);
        if (userService.updateUser(user) == 1 && studentBasicService.updateStudentBasic(student_basic) == 1){
            return 1;
        }else {
            return 0;
        }
    }

    @RequestMapping("/selectStudentBasic")
    @ResponseBody
    public List<View_StudentBasicInfo> selectTeacher (@RequestParam("user_Id")String user_Id,
                                                      @RequestParam("user_Name")String user_Name,
                                                      @RequestParam("class_Id")String class_Id,
                                                      @RequestParam("col_Id")String col_Id,
                                                      @RequestParam("spe_Id")String spe_Id,
                                                      @RequestParam("current")String current,
                                                      @RequestParam("length") String length) {
        return studentBasicService.selectStudentBasic(user_Id,user_Name,class_Id,col_Id,spe_Id,Integer.parseInt(current),Integer.parseInt(length));
    }



}
