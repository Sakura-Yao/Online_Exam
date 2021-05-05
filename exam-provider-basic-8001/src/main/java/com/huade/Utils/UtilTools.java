package com.huade.Utils;

import com.huade.pojo.*;
import com.huade.service.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Name;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

import javax.annotation.PostConstruct;
import java.io.*;
import java.util.*;

@Component
public class UtilTools {

    public static UtilTools utilTools;

    @PostConstruct
    public void init(){
        utilTools = this;
    }

     private static final String PATH = "/Users/develop/Desktop/Online_Exam/file/";

    //定义调用的Service方法
     @Autowired
     private ClassInfoServiceImpl classInfoServiceImpl;
     @Autowired
     private CollegeInfoServiceImpl collegeInfoServiceImpl;
     @Autowired
     private CourseServiceImpl courseServiceImpl;
     @Autowired
     private QuestionTypeServiceImpl questionTypeServiceImpl;
     @Autowired
     private SpecialtyInfoServiceImpl specialtyInfoServiceImpl;
     @Autowired
     private StudentBasicServiceImpl studentBasicServiceImpl;
     @Autowired
     private UserServiceImpl userServiceImpl;
     @Autowired
     private UserTypeServiceImpl userTypeServiceImpl;
     @Autowired
     private ClassCourseInfoServiceImpl classCourseInfoServiceImpl;
     @Autowired
     private TeacherBasicServiceImpl teacherBasicServiceImpl;
     @Autowired
     private static KnowledgeServiceImpl knowledgeServiceImpl;


    /**
     * Spring提供的MD5加密方法
     * 将字符串转化为 32 位的MD5字符串
     * @param str 需要加密的字符串
     * @return String 加密后的MD5字符串
     */
    public static String Encrypted_MD5(String str){
        return DigestUtils.md5DigestAsHex(str.getBytes());
    }


    /**
     * 随机生成密码
     * 生成的密码共6位数字
     * @return String RandomPassword
     */
    public static String RandomPassword(){
        StringBuilder RandomPassword = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            int num = (int) (Math.random() * 99) + 1;
            if (num < 10)
                RandomPassword.append(0);
            RandomPassword.append(num);
        }
        return RandomPassword.toString();
    }

    /**
     * 随机生成课程编号
     * 课程编号共10位 2位大写字母 + 8位随机数字（例如'TC75491231'）
     * @return String cou_Id
     */
    public static String RandomCourseId(){
        String[] arr = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        StringBuilder CourseId = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            CourseId.append(arr[(int) ((Math.random())*26)]);
        }
        for (int i = 0; i < 4; i++) {
            int num = (int) (Math.random() * 99) + 1;
            if (num < 10)
                CourseId.append(0);
            CourseId.append(num);
        }
        return CourseId.toString();
    }

    /**
     * 字符串转字符数组
     * @param str 数组
     * @return String
     */
    public static String[] StringToStringArr(String str){
        return str.split(",");
    }


    /**
     * 获取1级知识点的Id
     * 如果正确获取，返回值为该知识点的Id
     * 若错误，则返回字符串 'Error'
     * @param cou_Id 课程编号
     * @param chapter_Num 章节号
     * @return String Id（正确） String 'Error'（错误）
     */
    private static String GetLevel_1_Id(String cou_Id,String chapter_Num){
        List<View_Knowledge> knowledges = utilTools.knowledgeServiceImpl.selectKnowledge("", cou_Id, "1", chapter_Num, "", 0, 1000);
        if (knowledges.size() == 1){
            return knowledges.get(0).getId();
        }
        else {
            return "Error";
        }
    }

    /**
     * 批量添加知识点信息
     * @param filePath 文件名
     * @param sheetName 表名
     * @return Map集合（总数目'Total_num' 成功数目'Success_num' 失败数目'Error_num' 所用时间'Time_spent'）
     */
    public static Map batch_knowledge (String filePath,String sheetName){
        Map<String,String> map = new HashMap<String, String>();
        ExcelData excelData = new ExcelData(filePath,sheetName);
        Integer Rows = excelData.sheet.getPhysicalNumberOfRows();
        Integer Success_num = 0;
        Integer Error_num = 0;
        long start_time = new Date().getTime();
        //首先执行一遍逐行获取行列信息，以检查Excel表的完整性和可阅读性
        for (int i = 0; i < Rows; i++) {
            XSSFRow row = excelData.sheet.getRow(i);
        }
        //然后在进行批量导入数据
        for (int i = 1; i < Rows; i++) {
            XSSFRow row = excelData.sheet.getRow(i);
            String cou_Id = row.getCell(0).toString();
            String kwl_Level = row.getCell(1).getRawValue();
            String chapter_Num = row.getCell(2).getRawValue();
            String section_Num = row.getCell(3).getRawValue();
            String kwl_Name = row.getCell(4).toString();
            String uuid = UUID.randomUUID().toString().replace("-","");
            Knowledge knowledge = new Knowledge(uuid,cou_Id,kwl_Level,chapter_Num,section_Num,kwl_Name,"");
            if (UtilTools.AddKnowledge(knowledge)==1)
                Success_num++;
            else
                Error_num++;
        }
        long end_time = new Date().getTime();
        Rows = Rows - 1;
        map.put("Total_num",Rows.toString());
        map.put("Success_num",Success_num.toString());
        map.put("Error_num",Error_num.toString());
        map.put("Time_spent",(end_time-start_time)+"");
        return map;
    }

    /**
     * 添加知识点信息
     * @param knowledge 实体类：知识点信息
     * @return 成功：int 1  失败：int 0
     */
    private static int AddKnowledge(Knowledge knowledge){
        if (utilTools.knowledgeServiceImpl.selectKnowledge("", knowledge.getCou_Id(), knowledge.getKwl_Level(), knowledge.getChapter_Num(), knowledge.getSection_Num(), 0, 1000).size() == 0) {
            if (knowledge.getKwl_Level().equals("2")) {
                if (!(UtilTools.GetLevel_1_Id(knowledge.getCou_Id(), knowledge.getChapter_Num()).equals("Error"))) {
                    knowledge.setParent_Id(UtilTools.GetLevel_1_Id(knowledge.getCou_Id(), knowledge.getChapter_Num()));
                    return utilTools.knowledgeServiceImpl.addKnowledge(knowledge);
                } else {
                    return 0;
                }
            } else {
                return utilTools.knowledgeServiceImpl.addKnowledge(knowledge);
            }
        } else {
            return 0;
        }
    }


    /**
     * 一级知识点排序，排序方法："冒泡" 按照章节编号（即字段'chapter_Num'）进行顺序排序
     * 使用该方法的时候，把该方法复制到相应的Controller，直接调用即可
     * 不能调用该工具类下的此方法，有bug
     * @param list_know
     * @return
     */
    public static List<View_Knowledge> Sort_Level_1 (List<View_Knowledge> list_know){
        for (int i = 0; i < list_know.size()-1; i++) {
            for (int j = 0; j < list_know.size()-i-1; j++) {
                if (list_know.get(j).getChapter_Num() > list_know.get(j + 1).getChapter_Num()) {
                    View_Knowledge view_knowledge = list_know.get(j);
                    list_know.remove(j);
                    list_know.add(j+1,view_knowledge);
                }
            }
        }
        return list_know;
    }


    /**
     * 二级知识点排序，排序方法："冒泡" 按照小节编号（即字段'section_Num'）进行顺序排序
     * 使用该方法的时候，把该方法复制到相应的Controller，直接调用即可
     * 不能调用该工具类下的此方法，有bug
     * @param list_know
     * @return
     */
    public static List<View_Knowledge> Sort_Level_2 (List<View_Knowledge> list_know){
        for (int i = 0; i < list_know.size()-1; i++) {
            for (int j = 0; j < list_know.size()-i-1; j++) {
                if (list_know.get(j).getSection_Num() > list_know.get(j + 1).getSection_Num()) {
                    View_Knowledge view_knowledge = list_know.get(j);
                    list_know.remove(j);
                    list_know.add(j+1,view_knowledge);
                }
            }
        }
        return list_know;
    }

    public static void GetKnowledgeTree(String cou_Id){
        System.out.println(cou_Id);
        System.out.println(knowledgeServiceImpl.selectKnowledge("", cou_Id, "1", "", "", 0, 0));
//        List<View_Knowledge> l1 = Sort_Level_1(knowledgeServiceImpl.selectKnowledge("", cou_Id, "1", "", "", 0, 0));
//        System.out.println(l1);

    }

    /**
     * 创建用户类型数据验证（创建批量导入模版使用）
     * @param sheet 所需要操作的表
     * @since 2021-01-09
     */
    private static void CreateUserTypeDataValidation(XSSFSheet sheet){
        int index = 0;
        String data[] = new String[utilTools.userTypeServiceImpl.selectAllUserType().size()];
        for (User_Type user_type : utilTools.userTypeServiceImpl.selectAllUserType()) {
            data[index] = user_type.getUser_Type();
            index++;
        }
        for (int i = 0; i < data.length; i++) {
            sheet.createRow(i).createCell(0).setCellValue(data[i]);
        }
    }

    /**
     * 创建学院专业信息数据验证
     * @param sheet 所需要操作的表
     * @param workbook 工作簿
     * @param sheetName 表名
     * @since 2021-01-09
     */
    private static void CreateColSpeInfoDataValidation(XSSFSheet sheet, Workbook workbook,String sheetName){
        String data[][] = UtilTools.GetCol_Spe_Name();
        String college_Id[] = new String [utilTools.collegeInfoServiceImpl.selectAllCollegeInfo().size()];
        int index = 0;
        for (CollegeInfo collegeInfo : utilTools.collegeInfoServiceImpl.selectAllCollegeInfo()) {
            college_Id[index] = collegeInfo.getId();
            index++;
        }
        for (int i = 0; i < UtilTools.getCellMaxNum()+1; i++) {
            Row row = sheet.createRow(i);
            for (int j = 0; j < utilTools.collegeInfoServiceImpl.selectAllCollegeInfo().size(); j++) {
                row.createCell(j).setCellValue(data[i][j]);
            }
        }
        for (int i = 0; i < utilTools.collegeInfoServiceImpl.selectAllCollegeInfo().size(); i++) {
            Name name = workbook.createName();
            name.setNameName(sheet.getRow(0).getCell(i).toString());
            String formula = sheetName+"!"+UtilTools.getRange(i,2,utilTools.specialtyInfoServiceImpl.selectSpecialty_col_Id(college_Id[i]).size()+1);
            name.setRefersToFormula(formula);
        }
    }

    /**
     * 创建班级信息数据验证
     * @param sheet 所需要操作的表
     * @since 2021-01-09
     */
    private static void CreateClassInfoDataValidation(XSSFSheet sheet){
        String [] classInfo = UtilTools.getClassInfo();
        for (int i = 0; i < classInfo.length; i++) {
            sheet.createRow(i).createCell(0).setCellValue(classInfo[i]);
        }
    }

    /**
     * 制作批量添加用户信息的Excel模版
     * @param in_Path 初始Excel模版的绝对路径
     * @return 返回生成Excel的绝对路径
     * @since 2021-01-10
     */
    public static String MakeBatchAddUserMode(String in_Path,String fileName){
        //String in_Path = "/Users/develop/Online_Exam/file/batch_mode/userInfo.xlsx";
        String out_Path = PATH+fileName;
        //文件读写操作
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new FileInputStream(new File(in_Path));
            out = new FileOutputStream(new File(out_Path));
            //设定每次进行读写的字符数量，即每次读写区块的大小
            byte[] buffer = new byte[10000];
            int len;
            while ((len = in.read(buffer)) > 0) {
                out.write(buffer,0,len);
            }
            //抛出读写异常 默认状态
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(out_Path));
            //创建用户类型数据验证（下拉菜单选项）
            CreateUserTypeDataValidation(workbook.getSheet("UserType"));

            //创建学院和专业信息数据验证
            CreateColSpeInfoDataValidation(workbook.getSheet("Col_SpeInfo"),workbook,"Col_SpeInfo");

            //创建班级信息数据验证
            CreateClassInfoDataValidation(workbook.getSheet("ClassInfo"));

            //创建写出Excel模版文件的输出流
            FileOutputStream fileOutputStream = new FileOutputStream(out_Path);
            //为Excel模版文件进行写入工作表
            workbook.write(fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            //抛出读写异常 默认状态
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out_Path;
    }


    /**
     * 制作批量上传班级信息Excel模版
     * @param in_Path 原模版路径
     * @return String out_Path 模版导出路径
     * @since 2021-01-09
     */
    public static String MakeBatchAddClassInfo(String in_Path,String fileName){
//        String in_Path = "/Users/develop/Online_Exam/file/batch_mode/userInfo.xlsx";
        String out_Path = PATH+fileName;
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new FileInputStream(new File(in_Path));
            out = new FileOutputStream(new File(out_Path));
            byte[] buffer = new byte[10000];
            int len;
            while ((len = in.read(buffer)) > 0) {
                out.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(out_Path));

            //创建学院和专业信息数据验证
            CreateColSpeInfoDataValidation(workbook.getSheet("Col_SpeInfo"),workbook,"Col_SpeInfo");

            FileOutputStream fileOutputStream = new FileOutputStream(out_Path);
            workbook.write(fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out_Path;
    }


    /**
     * 制作批量上传课程Excel模版
     * @param in_Path 原模版路径
     * @return String out_Path 模版导出路径
     * @since 2021-01-09
     */
    public static String MakeBatchAddCourseInfo(String in_Path,String fileName){
//        String in_Path = "/Users/develop/Online_Exam/file/courseInfo.xlsx";
        String out_Path = PATH+fileName;
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new FileInputStream(new File(in_Path));
            out = new FileOutputStream(new File(out_Path));
            byte[] buffer = new byte[10000];
            int len;
            while ((len = in.read(buffer)) > 0) {
                out.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(out_Path));

            //创建学院和专业信息数据验证
            CreateColSpeInfoDataValidation(workbook.getSheet("Col_SpeInfo"),workbook,"Col_SpeInfo");

            FileOutputStream fileOutputStream = new FileOutputStream(out_Path);
            workbook.write(fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out_Path;
    }


    /**
     * 批量添加用户信息
     *
     * @param file_Path 批量添加用户信息Excel表文件绝对路径
     * @return HashMap {Total_Num; Success_Num; Error_Message; Time_Spent}
     * @throws DuplicateKeyException 主键异常
     * @throws BadSqlGrammarException SQL语句语法错误检查对应的mapper.xml
     */
    public static Map<String ,String> BatchAddUserInfo(String file_Path){
        long start_time = new Date().getTime();
        String sheet_Name = "Sheet1";
        ExcelData excelData = new ExcelData(file_Path,sheet_Name);
        Map<String ,String> res_Map = new HashMap<>();
        int rows = excelData.sheet.getPhysicalNumberOfRows();
        Integer success_Num = null;
        String res_Message = null;
        List<Map<String,Object>> userList = new ArrayList<>();
        List<Map<String,Object>> studentBasicList = new ArrayList<>();
        List<Map<String,Object>> teacherBasicList = new ArrayList<>();
        //创建一个flag变量，学生为0 教师为1
        int flag = 0;
        for (int i = 1; i < rows; i++) {
            XSSFRow row = excelData.sheet.getRow(i);
            row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
            String user_Id = row.getCell(0).getStringCellValue();
            String password = UtilTools.Encrypted_MD5("123456");
            String user_Name = row.getCell(1).toString();
            String user_Type = utilTools.userTypeServiceImpl.selectUserType_Name(row.getCell(2).toString());
            String class_Id = "";
            if (row.getCell(3)!=null) {
                row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
                class_Id = utilTools.classInfoServiceImpl.selectId(row.getCell(3).getStringCellValue());
            }
            String user_Sex = row.getCell(4).toString();
            String user_Mobile = "";
            if (row.getCell(5)!=null){
                row.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
                user_Mobile = row.getCell(5).getStringCellValue();
            }
            String col_Id = utilTools.collegeInfoServiceImpl.selectCol_Id(row.getCell(6).toString());
            String spe_Id = utilTools.specialtyInfoServiceImpl.selectSpe_Id(row.getCell(7).toString());
            Map<String,Object> user = new HashMap<>();
            user.put("user_Id",user_Id);
            user.put("password",password);
            user.put("user_Name",user_Name);
            user.put("user_Type",user_Type);
            user.put("user_Sex",user_Sex);
            user.put("user_Mobile",user_Mobile);
            userList.add(user);
            if (row.getCell(2).toString().equals("学生")){
                Map<String,Object> studentBasic = new HashMap<>();
                studentBasic.put("user_Id",user_Id);
                studentBasic.put("stu_ClassId",class_Id);
                studentBasic.put("stu_College",col_Id);
                studentBasic.put("stu_Specialty",spe_Id);
                studentBasicList.add(studentBasic);
            }else {
                flag = 1;
                Map<String,Object> teacherBasic = new HashMap<>();
                teacherBasic.put("user_Id",user_Id);
                teacherBasic.put("college_Id",col_Id);
                teacherBasic.put("specialty_Id",spe_Id);
                teacherBasicList.add(teacherBasic);
            }
        }
        try {

        } catch (DuplicateKeyException e) {
            res_Message = "存在学工号相同的数据，本次批量插入操作未被执行，请检查！";
        } catch (BadSqlGrammarException e){
            for (Map<String, Object> map : userList) {
               utilTools.userServiceImpl.deleteUser(map.get("user_Id").toString());
            }
            res_Message = "内部错误，请联系开发人员！本次批量操作执行，但数据已被恢复。";
        }
        long end_time = new Date().getTime();
        res_Map.put("Total_num", String.valueOf(rows-1));
        if (success_Num != null) {
            res_Map.put("Success_num", success_Num.toString());
            res_Map.put("Error_Message",res_Message);
        }
        else {
            res_Map.put("Success_num", "0");
            res_Map.put("Error_Message",res_Message);
        }
        res_Map.put("Time_Spent", String.valueOf((end_time-start_time)));
        return res_Map;
    }

    /**
     * 批量添加学生基本信息
     * @param filePath
     * @return
     */
    public static Map<String,String > BatchAddStudentInfo(String filePath){
        long start_time = new Date().getTime();
        String sheet_Name = "Sheet1";
        ExcelData excelData = new ExcelData(filePath,sheet_Name);
        Map<String ,String> res_Map = new HashMap<>();
        int rows = excelData.sheet.getPhysicalNumberOfRows();
        Integer success_Num = null;
        String res_Message = null;
        List<Map<String,Object>> userList = new ArrayList<>();
        List<Map<String,Object>> studentBasicList = new ArrayList<>();
        for (int i = 1 ; i < rows; i++) {
            XSSFRow row = excelData.sheet.getRow(i);
            row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
            String user_Id = row.getCell(0).getStringCellValue();
            String password = UtilTools.Encrypted_MD5("123456");
            String user_Name = row.getCell(1).toString();
            String user_Type = utilTools.userTypeServiceImpl.selectUserType_Name(row.getCell(2).toString());
            String class_Id = "";
            if (row.getCell(3)!=null) {
                row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
                class_Id = utilTools.classInfoServiceImpl.selectId(row.getCell(3).getStringCellValue());
            }
            String user_Sex = row.getCell(4).toString();
            String user_Mobile = "";
            if (row.getCell(5)!=null){
                row.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
                user_Mobile = row.getCell(5).getStringCellValue();
            }
            String col_Id = utilTools.collegeInfoServiceImpl.selectCol_Id(row.getCell(6).toString());
            String spe_Id = utilTools.specialtyInfoServiceImpl.selectSpe_Id(row.getCell(7).toString());
            Map<String,Object> user = new HashMap<>();
            user.put("user_Id",user_Id);
            user.put("password",password);
            user.put("user_Name",user_Name);
            user.put("user_Type",user_Type);
            user.put("user_Sex",user_Sex);
            user.put("user_Mobile",user_Mobile);
            userList.add(user);
            Map<String,Object> studentBasic = new HashMap<>();
            studentBasic.put("user_Id",user_Id);
            studentBasic.put("stu_ClassId",class_Id);
            studentBasic.put("stu_College",col_Id);
            studentBasic.put("stu_Specialty",spe_Id);
            studentBasicList.add(studentBasic);
        }
        try {
            success_Num = utilTools.userServiceImpl.batchAddUser(userList);
            utilTools.studentBasicServiceImpl.batchAddStudentBasicInfo(studentBasicList);
        } catch (DuplicateKeyException e){
            res_Message = "存在学号相同的数据，本次批量操作未被执行，请检查";
        } catch (BadSqlGrammarException e){
            for (Map<String, Object> map : userList) {
                utilTools.userServiceImpl.deleteUser(map.get("user_Id").toString());
            }
            res_Message = "内部错误，请联系开发人员！本次批量操作执行，但数据已被恢复。";
        } catch (Exception e) {
            e.printStackTrace();
        }
        long end_time = new Date().getTime();
        res_Map.put("Total_num", String.valueOf(rows-1));
        if (success_Num != null) {
            res_Map.put("Success_num", success_Num.toString());
            res_Map.put("Error_Message",res_Message);
        }
        else {
            res_Map.put("Success_num", "0");
            res_Map.put("Error_Message",res_Message);
        }
        res_Map.put("Time_Spent", String.valueOf((end_time-start_time)));
        return res_Map;
    }

    /**
     * 批量添加教师信息
     * @param filePath
     * @return
     */
    public static Map<String,String> BatchAddTeacherInfo(String filePath){
        long start_time = new Date().getTime();
        String sheet_Name = "Sheet1";
        ExcelData excelData = new ExcelData(filePath,sheet_Name);
        Map<String ,String> res_Map = new HashMap<>();
        int rows = excelData.sheet.getPhysicalNumberOfRows();
        Integer success_Num = null;
        String res_Message = null;
        List<Map<String,Object>> userList = new ArrayList<>();
        List<Map<String,Object>> teacherBasicList = new ArrayList<>();
        for (int i = 1; i < rows; i++) {
            XSSFRow row = excelData.sheet.getRow(i);
            row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
            String user_Id = row.getCell(0).getStringCellValue();
            String password = UtilTools.Encrypted_MD5("123456");
            String user_Name = row.getCell(1).toString();
            String user_Type = utilTools.userTypeServiceImpl.selectUserType_Name(row.getCell(2).toString());
            String class_Id = "";
            String user_Sex = row.getCell(4).toString();
            String user_Mobile = "";
            if (row.getCell(5)!=null){
                row.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
                user_Mobile = row.getCell(5).getStringCellValue();
            }
            String col_Id = utilTools.collegeInfoServiceImpl.selectCol_Id(row.getCell(6).toString());
            String spe_Id = utilTools.specialtyInfoServiceImpl.selectSpe_Id(row.getCell(7).toString());
            Map<String,Object> user = new HashMap<>();
            user.put("user_Id",user_Id);
            user.put("password",password);
            user.put("user_Name",user_Name);
            user.put("user_Type",user_Type);
            user.put("user_Sex",user_Sex);
            user.put("user_Mobile",user_Mobile);
            userList.add(user);
            Map<String,Object> teacherBasic = new HashMap<>();
            teacherBasic.put("user_Id",user_Id);
            teacherBasic.put("college_Id",col_Id);
            teacherBasic.put("specialty_Id",spe_Id);
            teacherBasicList.add(teacherBasic);
        }
        try {
            success_Num = utilTools.userServiceImpl.batchAddUser(userList);
            utilTools.teacherBasicServiceImpl.batchAddTeacherBasicInfo(teacherBasicList);
        } catch (DuplicateKeyException e){
            res_Message = "存在工号相同的数据，本次批量操作未被执行，请检查";
        } catch (BadSqlGrammarException e){
            for (Map<String, Object> map : userList) {
                utilTools.userServiceImpl.deleteUser(map.get("user_Id").toString());
            }
            res_Message = "内部错误，请联系开发人员！本次批量操作执行，但数据已被恢复。";
        } catch (Exception e) {
            e.printStackTrace();
        }
        long end_time = new Date().getTime();
        res_Map.put("Total_num", String.valueOf(rows-1));
        if (success_Num != null) {
            res_Map.put("Success_num", success_Num.toString());
            res_Map.put("Error_Message",res_Message);
        }
        else {
            res_Map.put("Success_num", "0");
            res_Map.put("Error_Message",res_Message);
        }
        res_Map.put("Time_Spent", String.valueOf((end_time-start_time)));
        return res_Map;
    }


    /**
     * 批量添加班级信息
     * @param file_Path 批量添加班级信息Excel表文件绝对路径
     * @return HashMap {Total_Num; Success_Num; Error_Message; Time_Spent}
     * @throws BadSqlGrammarException SQL语句语法错误检查对应的mapper.xml
     * @since 2021-01-09
     */
    public static Map<String ,String> BatchAddClassInfo(String file_Path){
        long start_time = new Date().getTime();
        String sheet_Name = "Sheet1";
        ExcelData excelData = new ExcelData(file_Path,sheet_Name);
        Map<String ,String> res_Map = new HashMap<>();
        int rows = excelData.sheet.getPhysicalNumberOfRows();
        Integer success_Num = null;
        String res_Message = null;
        List<Map<String,Object>> classInfoList = new ArrayList<>();
        for (int i = 1; i < rows; i++) {
            XSSFRow row = excelData.sheet.getRow(i);
            row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
            String Id = UUID.randomUUID().toString().replace("-","");
            String class_Id = row.getCell(0).getStringCellValue();
            String people_Num = "0";
            String class_Col_Id = utilTools.collegeInfoServiceImpl.selectCol_Id(row.getCell(1).toString());
            String class_Spe_Id = utilTools.specialtyInfoServiceImpl.selectSpe_Id(row.getCell(2).toString());
            Map<String ,Object> classInfo = new HashMap<>();
            classInfo.put("Id",Id);
            classInfo.put("class_Id",class_Id);
            classInfo.put("people_Num",people_Num);
            classInfo.put("class_Col_Id",class_Col_Id);
            classInfo.put("class_Spe_Id",class_Spe_Id);
            classInfoList.add(classInfo);
        }
        try {
            success_Num = utilTools.classInfoServiceImpl.batchAddClassInfo(classInfoList);
        } catch (BadSqlGrammarException e){
            //遇到sql语句错误异常，将刚添加到数据库的数据信息恢复
            for (Map<String, Object> map : classInfoList) {
                utilTools.classInfoServiceImpl.deleteClassInfo(map.get("Id").toString());
            }
            res_Message = "内部错误，请联系开发人员！本次批量操作执行，但数据已被恢复。";
        } catch (Exception e) {
            e.printStackTrace();
        }
        long end_time = new Date().getTime();
        res_Map.put("Total_num", String.valueOf(rows-1));
        if (success_Num != null) {
            res_Map.put("Success_num", success_Num.toString());
            res_Map.put("Error_Message",res_Message);
        }
        else {
            res_Map.put("Success_num", "0");
            res_Map.put("Error_Message",res_Message);
        }
        res_Map.put("Time_Spent", String.valueOf((end_time-start_time)));
        return res_Map;
    }


    /**
     * 批量添加课程信息
     * @param file_Path 文件路径
     * @return HashMap {Total_Num; Success_Num; Error_Message; Time_Spent}
     * @throws Exception sql异常
     */
    public static Map<String ,String> BatchAddCourseInfo(String file_Path) throws Exception{
        long start_time = new Date().getTime();
        String sheet_Name = "Sheet1";
        ExcelData excelData = new ExcelData(file_Path,sheet_Name);
        Map<String ,String> res_Map = new HashMap<>();
        int rows = excelData.sheet.getPhysicalNumberOfRows();
        Integer success_Num = null;
        String res_Message = null;
        List<Map<String,Object>> courseInfoList = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            XSSFRow row = excelData.sheet.getRow(i);
            String Id = RandomCourseId();
            String cou_Name = row.getCell(0).toString();
            String course_Spe_Id = utilTools.specialtyInfoServiceImpl.selectSpe_Id(row.getCell(2).toString());
            Map<String ,Object> courseInfo = new HashMap<>();
            courseInfo.put("Id",Id);
            courseInfo.put("cou_Name",cou_Name);
            courseInfo.put("spe_Id",course_Spe_Id);
            courseInfoList.add(courseInfo);
        }
        try {
            success_Num = utilTools.courseServiceImpl.batchAddCourseInfo(courseInfoList);
        } catch (BadSqlGrammarException e){
            for (Map<String, Object> map : courseInfoList) {
                utilTools.courseServiceImpl.deleteCourseInfo(map.get("Id").toString());
            }
            res_Message = "内部错误，请联系开发人员！本次批量操作执行，但数据已被恢复。";
        }
        long end_time = new Date().getTime();
        res_Map.put("Total_num", String.valueOf(rows-1));
        if (success_Num != null) {
            res_Map.put("Success_num", success_Num.toString());
            res_Map.put("Error_Message",res_Message);
        }
        else {
            res_Map.put("Success_num", "0");
            res_Map.put("Error_Message",res_Message);
        }
        res_Map.put("Time_Spent", String.valueOf((end_time-start_time)));
        return res_Map;
    }


    //获取包含专业最大数目（用于生成批量添加用户信息Excel文件）
    private static int getCellMaxNum(){
        int index = 0;
        String college_Id[] = new String [utilTools.collegeInfoServiceImpl.selectAllCollegeInfo().size()];
        String college[] = new String [utilTools.collegeInfoServiceImpl.selectAllCollegeInfo().size()];
        for (CollegeInfo collegeInfo : utilTools.collegeInfoServiceImpl.selectAllCollegeInfo()) {
            college[index] = collegeInfo.getCol_Name();
            college_Id[index] = collegeInfo.getId();
            index++;
        }
        int max = 0;
        for (String s : college_Id) {
            int size = utilTools.specialtyInfoServiceImpl.selectSpecialty_col_Id(s).size();
            max = Math.max(size, max);
        }
        return max;
    }

    //获取全部学院和专业的名称信息（用于生成批量添加用户信息Excel文件）
    private static String[][] GetCol_Spe_Name(){
        int index = 0;
        int speMaxNum = getCellMaxNum();
        String college_Id[] = new String [utilTools.collegeInfoServiceImpl.selectAllCollegeInfo().size()];
        String college[] = new String [utilTools.collegeInfoServiceImpl.selectAllCollegeInfo().size()];
        for (CollegeInfo collegeInfo : utilTools.collegeInfoServiceImpl.selectAllCollegeInfo()) {
            college[index] = collegeInfo.getCol_Name();
            college_Id[index] = collegeInfo.getId();
            index++;
        }
        String [][] arr = new String [speMaxNum+1][utilTools.collegeInfoServiceImpl.selectAllCollegeInfo().size()];
        for (int i = 0; i < utilTools.collegeInfoServiceImpl.selectAllCollegeInfo().size(); i++) {
            arr[0][i] = college[i];
            index = 0;
            String specialty[] = new String [getCellMaxNum()];
            for (Specialty specialty1 : utilTools.specialtyInfoServiceImpl.selectSpecialty_col_Id(college_Id[i])) {
                specialty[index] = specialty1.getSpe_Name();
                index++;
            }
            for (int j = 0; j < speMaxNum; j++) {
                arr[j+1][i] = specialty[j];
            }
        }
//        测试代码
//        for (int i = 0; i < speMaxNum+1; i++) {
//            for (int j = 0; j < collegeInfoServiceImpl.selectAllCollegeInfo().size(); j++) {
//                System.out.print(arr[i][j]+"  ");
//            }
//            System.out.println();
//        }
        return arr;
    }


    /**
     *  计算formula（用于生成批量添加用户信息Excel文件）
     * @param rowId 第几行
     * @param rowCount 一共多少行
     * @return 如果给入参 1,1,10. 表示从B1-K1。最终返回 $B$1:$K$1
     *
     */
    public static String getRange(int colId, int rowId, int rowCount) {
        char res_letter = (char)('A'+colId);
        return "$"+res_letter+"$"+rowId+":$"+res_letter+"$"+rowCount;
    }


    //获取班级信息
    private static String[] getClassInfo(){
        int size = utilTools.classInfoServiceImpl.selectAllClassInfo().size();
        String[] classInfo = new String [size];
        int index = 0;
        for (View_ClassInfo info : utilTools.classInfoServiceImpl.selectAllClassInfo()) {
            classInfo[index] = info.getClass_Id();
            index++;
        }
        return classInfo;
    }



}
