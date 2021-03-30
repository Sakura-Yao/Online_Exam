package com.huade.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import com.huade.utils.UtilsTools;
import org.apache.catalina.connector.Response;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
public class FileController {

    @Autowired
    private RestTemplate restTemplate;

    private static final String UPLOAD_IMAGE_REALPATH = "/Users/develop/Desktop/online_exam/file/image/";
    private static final String FILE_REALPATH = "/Users/develop/Desktop/online_exam/file/";
    private static final String BATCH_FILE_REALPATH = "/Users/develop/Desktop/online_exam/file/batch_files/";

//    @RequestMapping(value="/uploadImage",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/uploadImage")
    @ResponseBody
    public Map<String,Object> uploadImage(MultipartFile upfile) throws IOException {
        Map<String,Object> map = new HashMap<String,Object>();
        String realName = null;
        String uuidName = null;
        String realPath = null;
        try {
            realName = getRealName(upfile.getOriginalFilename());
            uuidName = getUUIDFileName(upfile.getOriginalFilename());
            realPath = UPLOAD_IMAGE_REALPATH;
            InputStream in = new BufferedInputStream(upfile.getInputStream());
            OutputStream out = new BufferedOutputStream(new FileOutputStream(new File(realPath,uuidName)));
            //读写
            int len = 0;
            byte[] buffer = new byte[102400];
            while ((len = in.read(buffer)) != -1) {
                out.write(buffer,0,len);
                out.flush();
            }
            out.close();
            in.close();
            //IOUtils.copy(in,out);
            map.put("state", "SUCCESS");
            map.put("url","/api/images/"+uuidName);
            map.put("title",realName);
            map.put("original",realName);
        } catch (IOException e) {
            map.put("state", "文件上传失败,请联系管理员");
            map.put("url","");
            map.put("title","");
            map.put("original","");
        }
        //存入数据库方法
        return map;
    }

    private String getExtName(String s, char split) {
        int i = s.lastIndexOf(split);
        int leg = s.length();
        return i > 0 ? (i + 1) == leg ? " " : s.substring(i+1, s.length()) : " ";
    }

    private String getUUIDFileName(String fileName){
        UUID uuid = UUID.randomUUID();
        StringBuilder sb = new StringBuilder(100);
        sb.append(uuid.toString().replace("-","")).append(".").append(this.getExtName(fileName, '.'));
        return sb.toString();
    }

    private String getRealName(String originalName){
        //System.out.println(originalName.contains("."));

        if(originalName.contains(".")){
            String [] as = originalName.split("\\.");
            //System.out.println(as[0]);
            return as[0];
        }else {
            return originalName;
        }

    }

    /**
     * 上传配置：即不走config.json，模拟config.json里的内容，解决后端配置项不正确，无法上传的问题
     * @return
     */
    @RequestMapping("/ueditor/config")
    @ResponseBody
    public String uploadConfig() {
        String s = "{\n" +
                "            \"imageActionName\": \"uploadimage\",\n" +
                "                \"imageFieldName\": \"upfile\", \n" +
                "                \"imageMaxSize\": 2048000, \n" +
                "                \"imageAllowFiles\": [\".png\", \".jpg\", \".jpeg\", \".gif\", \".bmp\"], \n" +
                "                \"imageCompressEnable\": true, \n" +
                "                \"imageCompressBorder\": 1600, \n" +
                "                \"imageInsertAlign\": \"none\", \n" +
                "                \"imageUrlPrefix\": \"\",\n" +
                "                \"imagePathFormat\": \"/ueditor/jsp/upload/image/{yyyy}{mm}{dd}/{time}{rand:6}\" }";
        return s;
    }

    /**
     * 上传文件方法
     * @param file 文件
     * @return 文件路径（绝对路径）
     */
    public String uploadFile(MultipartFile file){
        if (file.isEmpty()) {
            return null;
        }
        String fileName = file.getOriginalFilename();
        String filePath = BATCH_FILE_REALPATH;
        String uuid = UUID.randomUUID().toString().replace("-","");
        File dest = new File(filePath + uuid + fileName);

        try {
            file.transferTo(dest);
            return filePath + uuid + fileName;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping("/batchKnowledge")
    @ResponseBody
    public JSON batchKnowledge(@RequestParam("file") MultipartFile file){
        JSONObject object = new JSONObject();
        String filePath = uploadFile(file);
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("filePath",filePath);
        Map res = restTemplate.postForObject("http://localhost:8001/knowledge/batchKnowledge", param, Map.class);
        object.put("Error_num",res.get("Error_num") );
        object.put("Total_num",res.get("Total_num") );
        object.put("Time_spent",res.get("Time_spent") );
        object.put("Success_num",res.get("Success_num") );
        return object;
    }

    /**
     * 制作批量添加班级信息的Excel模版
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/makeBatchClassInfoMode")
    public String makeBatchClassInfoMode(HttpServletResponse response) throws Exception{
        String filePath = "/Users/develop/Desktop/online_exam/file/batch_mode/classInfo.xlsx";
        String fileName = "批量添加班级信息模版.xlsx";
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("filePath",filePath);
        param.add("fileName",fileName);
        String res = restTemplate.postForObject("http://localhost:8001/classInfo/makeBatchClassInfoMode", param, String.class);
        System.out.println(res);
        //设置response响应头
        response.reset();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("multipart/form-date");//二进制传输数据

        //设置响应头
        response.setHeader("Content-Disposition","attachment;fileName="+ URLEncoder.encode(fileName,"UTF-8"));
        File file = new File(FILE_REALPATH,fileName);

        //读取文件--输入流
        InputStream inputStream = new FileInputStream(file);
        OutputStream outputStream = response.getOutputStream();

        byte[] buffer = new byte[10240];
        int index = 0;
        while ((index = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer,0,index);
            outputStream.flush();
        }
        outputStream.close();
        inputStream.close();
        return null;
    }

    /**
     * 制作批量添加课程信息
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/makeBatchCoursesInfo")
    public String makeBatchCoursesInfo(HttpServletResponse response) throws Exception{
        String filePath = "/Users/develop/Desktop/online_exam/file/batch_mode/courseInfo.xlsx";
        String fileName = "批量添加课程信息.xlsx";
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("filePath",filePath);
        param.add("fileName",fileName);
        String res = restTemplate.postForObject("http://localhost:8001/Course/makeBatchAddCourseInfo", param, String.class);
        System.out.println(res);
        //设置response响应头
        response.reset();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("multipart/form-date");//二进制传输数据

        //设置响应头
        response.setHeader("Content-Disposition","attachment;fileName="+ URLEncoder.encode(fileName,"UTF-8"));
        File file = new File(FILE_REALPATH,fileName);

        //读取文件--输入流
        InputStream inputStream = new FileInputStream(file);
        OutputStream outputStream = response.getOutputStream();

        byte[] buffer = new byte[10240];
        int index = 0;
        while ((index = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer,0,index);
            outputStream.flush();
        }
        outputStream.close();
        inputStream.close();
        return null;
    }

    /**
     * 制作批量添加用户信息模版
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/makeBatchUserInfo")
    public String makeBatchUserInfo(HttpServletResponse response) throws Exception{
        String filePath = "/Users/develop/Desktop/online_exam/file/batch_mode/userInfo.xlsx";
        String fileName = "批量添加用户信息.xlsx";
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("filePath",filePath);
        param.add("fileName",fileName);
        String res = restTemplate.postForObject("http://localhost:8001/User/makeBatchAddUserInfo", param, String.class);
        System.out.println(res);
        //设置response响应头
        response.reset();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("multipart/form-date");//二进制传输数据

        //设置响应头
        response.setHeader("Content-Disposition","attachment;fileName="+ URLEncoder.encode(fileName,"UTF-8"));
        File file = new File(FILE_REALPATH,fileName);

        //读取文件--输入流
        InputStream inputStream = new FileInputStream(file);
        OutputStream outputStream = response.getOutputStream();

        byte[] buffer = new byte[10240];
        int index = 0;
        while ((index = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer,0,index);
            outputStream.flush();
        }
        outputStream.close();
        inputStream.close();
        return null;
    }

    /**
     * 批量添加课程信息
     * @param file
     * @return
     */
    @PostMapping("/batchClassInfo")
    @ResponseBody
    public JSON batchClassInfo(@RequestParam("file") MultipartFile file){
        JSONObject object = new JSONObject();
        String filePath = uploadFile(file);
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("filePath",filePath);
        Map res = restTemplate.postForObject("http://localhost:8001/classInfo/batchClassInfo", param, Map.class);
        object.put("Total_num",res.get("Total_num"));
        object.put("Error_Message",res.get("Error_Message"));
        object.put("Success_num",res.get("Success_num"));
        object.put("Time_Spent",res.get("Time_Spent"));
        return object;
    }

    /**
     * 批量添加课程信息
     * @param file
     * @return
     */
    @PostMapping("/batchCourseInfo")
    @ResponseBody
    public JSON batchCourseInfo(@RequestParam("file")MultipartFile file){
        JSONObject object = new JSONObject();
        String filePath = uploadFile(file);
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("filePath",filePath);
        Map res = restTemplate.postForObject("http://localhost:8001/Course/batchCourseInfo", param, Map.class);
        object.put("Total_num",res.get("Total_num"));
        object.put("Error_Message",res.get("Error_Message"));
        object.put("Success_num",res.get("Success_num"));
        object.put("Time_Spent",res.get("Time_Spent"));
        return object;
    }

    /**
     * 批量添加学生信息
     * @param file
     * @return
     */
        @PostMapping("/batchStudentInfo")
    @ResponseBody
    public JSON batchStudentInfo(@RequestParam("file")MultipartFile file){
        JSONObject object = new JSONObject();
        String filePath = uploadFile(file);
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("filePath",filePath);
        Map res = restTemplate.postForObject("http://localhost:8001/User/batchStudentInfo", param, Map.class);
        object.put("Total_num",res.get("Total_num"));
        object.put("Error_Message",res.get("Error_Message"));
        object.put("Success_num",res.get("Success_num"));
        object.put("Time_Spent",res.get("Time_Spent"));
        return object;
    }

    /**
     * 批量添加教师信息
     * @param file
     * @return
     */
    @PostMapping("/batchTeacherInfo")
    @ResponseBody
    public JSON batchTeacherInfo(@RequestParam("file")MultipartFile file){
        JSONObject object = new JSONObject();
        String filePath = uploadFile(file);
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("filePath",filePath);
        Map res = restTemplate.postForObject("http://localhost:8001/User/batchTeacherInfo", param, Map.class);
        object.put("Total_num",res.get("Total_num"));
        object.put("Error_Message",res.get("Error_Message"));
        object.put("Success_num",res.get("Success_num"));
        object.put("Time_Spent",res.get("Time_Spent"));
        return object;
    }


    @RequestMapping("/download")
    public String downloads(HttpServletResponse response,
                            @Param("fileName")String fileName) throws Exception{
        String path = FILE_REALPATH;

        //设置response响应头
        response.reset();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("multipart/form-date");//二进制传输数据

        //设置响应头
        response.setHeader("Content-Disposition","attachment;fileName="+ URLEncoder.encode(fileName,"UTF-8"));
        File file = new File(path,fileName);

        //读取文件--输入流
        InputStream inputStream = new FileInputStream(file);
        OutputStream outputStream = response.getOutputStream();

        byte[] buffer = new byte[10240];
        int index = 0;
        while ((index = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer,0,index);
            outputStream.flush();
        }
        outputStream.close();
        inputStream.close();
        return null;
    }

}
