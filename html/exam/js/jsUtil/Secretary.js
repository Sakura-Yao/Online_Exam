let curWwwPath = window.document.location.href;
let pathname= window.document.location.pathname;
let pos = curWwwPath.indexOf(pathname);
let localhostPath = curWwwPath .substring(0,pos);

/**
 * 初始化分页插件
 */
function init_pager_secretary(totalData){
    $("#pager").empty();
    if (totalData !== 0){
        $("#pager").zPager({
            totalData: totalData,
            pageData: 10,
            btnShow: true,
            ajaxSetData: false
        });
    }
}

/**
 * 验证提交表单的完整性 (空值：'' /空值：null /未定义：undefined)
 * 显示提示 需要加载相对应的js文件
 * @param obj
 * @returns {boolean}
 */
function check_submit(obj){
    if (Object.values(obj).indexOf("") === -1 && Object.values(obj).indexOf(undefined) === -1 && Object.values(obj).indexOf(null) === -1){
        return true;
    } else {
        lightyear.loading('show');
        setTimeout(function (){
            lightyear.loading('hide');
            lightyear.notify('存在未填写的表单信息，请检查','warning',1000);
        }, 200)
        return false;
    }
    // return Object.values(obj).indexOf("") === -1;
}

/**
 * 获取登录Session
 * @returns {string}
 */
function get_session() {
    var User = "";
    $.ajax({
        url:localhostPath+"/api/getSession",
        type:"POST",
        async:false,
        data:{
            key:'login_session'
        },
        dataType: "json",
        success:function (res) {
            User = res.session_data;
        }
    });
    return User;
}

/**
 * 获取学院信息
 * @returns {[]}
 */
function get_collegeInfo(col_Id){
    let collegeInfo = [];
    $.ajax({
        url:localhostPath+"/api/basic/selectCollegeInfo",
        type:"POST",
        data:{
            "col_Id" : col_Id
        },
        async:false,
        dataType:"json",
        success:function (res){
            collegeInfo = res;
        }
    })
    return collegeInfo;
}

/**
 * 学院信息封装select
 * @param col_Id
 * @param elementId
 */
function get_collegeInfo_elementId(col_Id,elementId){
    let collegeInfo = get_collegeInfo(col_Id);
    let html ="";
    for (let i = 0; i < collegeInfo.length; i++) {
        html += "<option value='"+collegeInfo[i].id+"'>"+collegeInfo[i].col_Name+"</option>"
    }
    $("#"+elementId).append(html);
}

/**
 * 获取某个学院的专业信息
 * @param col_Id
 * @returns {[]}
 */
function get_specialtyInfo(col_Id){
    let specialtyInfo = [];
    $.ajax({
        url:localhostPath+"/api/basic/selectSpecialtyInfo",
        type:"POST",
        data:{
            "col_Id" : col_Id
        },
        async:false,
        dataType:"json",
        success:function (res){
            specialtyInfo = res;
        }
    })
    return specialtyInfo;
}

/**
 * 专业信息封装select
 * @param col_Id
 * @param elementId
 */
function get_specialtyInfo_elementId(col_Id,elementId){
    let specialtyInfo = get_specialtyInfo(col_Id);
    let html = "<option value=''>请选择所属专业</option>";
    for (let i = 0; i < specialtyInfo.length; i++) {
        html += "<option value='"+specialtyInfo[i].id+"'>"+specialtyInfo[i].spe_Name+"</option>";
    }
    $("#"+elementId).empty();
    $("#"+elementId).append(html);
}

/**
 * 获取班级信息
 * @param Id
 * @param cou_Id
 * @param spe_Id
 * @param current
 * @param length
 * @returns {[]}
 */
function get_classesInfo(Id,cou_Id,spe_Id,current,length) {
    let classesInfo = [];
    $.ajax({
        url:localhostPath+"/api/basic/selectClassesInfo",
        type:"POST",
        data:{
            "Id":Id,
            "cou_Id":cou_Id,
            "spe_Id":spe_Id,
            "current":current,
            "length":length
        },
        dataType:"json",
        async:false,
        success:function (res){
            classesInfo = res;
        }
    })
    return classesInfo;
}

/**
 * 班级信息封装select
 * @param spe_Id
 * @param elementId
 */
function get_classesInfo_elementId(spe_Id,elementId) {
    let classesInfo = get_classesInfo('','',spe_Id,-1,-1);
    let html = "<option value=''>请选择所属班级</option>";
    for (let i = 0; i < classesInfo.length; i++) {
        html += "<option value='"+classesInfo[i].id+"'>"+classesInfo[i].class_Id+"</option>";
    }
    $("#"+elementId).empty();
    $("#"+elementId).append(html);
}

/**
 * 添加学生基本信息
 * @param param
 */
function add_studentInfo(param) {
    if (check_submit(param)){
        console.log("验证通过！");
        $.ajax({
            url:localhostPath+"/api/Student_basic/addStudentBasic",
            type:"POST",
            data:{
                "user_Id":param.user_Id,
                "user_Name":param.user_Name,
                "user_Type":param.user_Type,
                "user_Sex":param.user_Sex,
                "user_Mobile":param.user_Mobile,
                "stu_ClassId":param.stu_ClassId,
                "stu_College":param.stu_College,
                "stu_Specialty":param.stu_Specialty
            },
            dataType:"json",
            success:function (res){
                if (res.code === 1){
                    lightyear.loading('show');
                    setTimeout(function (){
                        lightyear.loading('hide');
                        lightyear.notify(res.message,'success',3000);
                    }, 1e3)
                } else {
                    lightyear.loading('show');
                    setTimeout(function (){
                        lightyear.loading('hide');
                        lightyear.notify(res.message,'danger',100);
                    }, 1e3)
                }
            }
        })
    }

}

/**
 * 获取查询学生信息总行数
 * @param param
 * @returns {number}
 */
function get_studentsInfo_itemsNum(param){
    let num = 0;
    $.ajax({
        url:localhostPath+"/api/Student_basic/selectStudentBasic",
        type:"POST",
        data:{
            "user_Id":param.user_Id,
            "user_Name":param.user_Name,
            "class_Id":param.class_Id,
            "col_Id":param.col_Id,
            "spe_Id":param.spe_Id,
            "current":"-1",
            "length":"-1"
        },
        async:false,
        dataType:"json",
        success:function (res){
            num = res.data.length;
        }
    })
    return num;
}

/**
 * 获取查询学生结果
 * @param param
 * @returns {[]}
 */
function get_studentsInfo(param){
    let studentsInfo = [];
    $.ajax({
        url:localhostPath+"/api/Student_basic/selectStudentBasic",
        type:"POST",
        data:{
            "user_Id":param.user_Id,
            "user_Name":param.user_Name,
            "class_Id":param.class_Id,
            "col_Id":param.col_Id,
            "spe_Id":param.spe_Id,
            "current":param.current,
            "length":param.length
        },
        async:false,
        dataType:"json",
        success:function (res){
            studentsInfo = res.data;
        }
    })
    return studentsInfo;
}

/**
 * 根据user_Id 将需要修改的学生信息的信息放到相对应的标签内
 * @param user_Id
 * @returns {{}}
 */
function set_changeStudentInfo_val(user_Id){
    let student = {};
    $.ajax({
        url:localhostPath+"/api/Student_basic/selectStudentBasic",
        type:"POST",
        data:{
            "user_Id":user_Id,
            "user_Name":'',
            "class_Id":'',
            "col_Id":'',
            "spe_Id":'',
            "current":-1,
            "length":-1
        },
        async:false,
        dataType:"json",
        success:function (res){
            student = res.data[0];
        }
    })
    $("#studentChangeId").val(student.user_Id);
    $("#studentChangeName").val(student.user_Name);
    $("input:radio[name=statusChange]")['男'===student.user_Sex?0:1].checked=true;
    $("#studentChangeCollegeSelect").val(student.col_Id);
    get_specialtyInfo_elementId(student.col_Id,'studentChangeSpecialtySelect');
    $("#studentChangeSpecialtySelect").val(student.spe_Id);
    get_classesInfo_elementId(student.spe_Id,'studentChangeClassSelect');
    $("#studentChangeClassSelect").val(student.classes_Id);
    $("#studentChangeMobile").val(student.user_Mobile);
}

/**
 * 修改学生基本信息
 * @param param
 */
function studentInfo_update(param) {
    $.ajax({
        url:localhostPath+"/api/Student_basic/updateStudentBasic",
        type:"POST",
        data:{
            "user_Id":param.user_Id,
            "user_Name":param.user_Name,
            "user_Type":param.user_Type,
            "user_Sex":param.user_Sex,
            "user_Mobile":param.user_Mobile,
            "stu_ClassId":param.stu_ClassId,
            "stu_College":param.stu_College,
            "stu_Specialty":param.stu_Specialty
        },
        dataType:"json",
        success:function (res){
            if (res.code === 1){
                lightyear.loading('show');
                setTimeout(function (){
                    lightyear.loading('hide');
                    lightyear.notify(res.message,'success',3000);
                }, 1e3)
            } else {
                lightyear.loading('show');
                setTimeout(function (){
                    lightyear.loading('hide');
                    lightyear.notify(res.message,'danger',100);
                }, 1e3)
            }
        }
    })
}

/**
 * 查询学生数据封装
 * @param param
 * @param elementId
 */
function get_studentsInfo_elementId(param,elementId) {
    let studentsInfo = get_studentsInfo(param);
    let html = "";
    for (let i = 0; i < studentsInfo.length; i++) {
        html += "<tr>\n" +
            "                      <td><label class=\"lyear-checkbox checkbox-primary\">\n" +
            "                          <input type=\"checkbox\" name=\"permission\"  value=\"1\">\n" +
            "                          <span></span> </label></td>" +
            "<td>"+studentsInfo[i].user_Id+"</td>" +
            "<td>"+studentsInfo[i].user_Name+"</td>" +
            "<td>"+studentsInfo[i].user_Sex+"</td>" +
            "<td>"+studentsInfo[i].col_Name+"</td>" +
            "<td>"+studentsInfo[i].spe_Name+"</td>" +
            "<td>"+studentsInfo[i].class_Id+"</td>" +
            "<td>"+studentsInfo[i].user_Mobile+"</td>" +
            "<td><div class=\"btn-group\"> <a class=\"btn btn-xs btn-default\" href=\"#!\" title=\"编辑\" onclick='set_changeStudentInfo_val("+studentsInfo[i].user_Id+")' data-toggle=\"modal\" data-target=\"#changeModal\"><i class=\"mdi mdi-pencil\"></i></a>  </div></td>\n</tr>";
            // "<td><div class=\"btn-group\"> <a class=\"btn btn-xs btn-default\" href=\"#!\" title=\"编辑\" onclick='set_changeStudentInfo_val("+studentsInfo[i].user_Id+")' data-toggle=\"modal\" data-target=\"#changeModal\"><i class=\"mdi mdi-pencil\"></i></a> <a class=\"btn btn-xs btn-default\" href=\"#!\" title=\"删除\" data-toggle=\"tooltip\"><i class=\"mdi mdi-window-close\"></i></a> </div></td>\n</tr>";
    }
    $("#"+elementId).empty();
    $("#"+elementId).append(html);
}

/**
 * 添加教师信息
 * @param param
 */
function add_teacherInfo(param) {
    if (check_submit(param)){
        $.ajax({
            url:localhostPath+"/api/Teacher_basic/addTeacherBasicInfo",
            type:"POST",
            data:{
                "user_Id":param.user_Id,
                "user_Name":param.user_Name,
                "user_Type":param.user_Type,
                "user_Sex":param.user_Sex,
                "user_Mobile":param.user_Mobile,
                "college_Id":param.college_Id,
                "specialty_Id":param.specialty_Id
            },
            dataType:"json",
            success:function (res){
                if (res.code === 1){
                    lightyear.loading('show');
                    setTimeout(function (){
                        lightyear.loading('hide');
                        lightyear.notify(res.message,'success',3000);
                    }, 1e3)
                } else {
                    lightyear.loading('show');
                    setTimeout(function (){
                        lightyear.loading('hide');
                        lightyear.notify(res.message,'danger',100);
                    }, 1e3)
                }
            }
        })
    }
}

/**
 * 获取查询教师信息的总行数
 * @param param
 */
function get_teachersInfo_itemsNum(param){
    let num = 0;
    $.ajax({
        url:localhostPath+"/api/Teacher_basic/selectTeacher",
        type:"POST",
        data:{
            "user_Id":param.user_Id,
            "user_Name":param.user_Name,
            "col_Id":param.col_Id,
            "spe_Id":param.spe_Id,
            "current":"-1",
            "length":"-1"
        },
        async:false,
        dataType:"json",
        success:function (res){
            num = res.data.length;
        }
    })
}
/**
 * 获取查询教师结果
 * @param param
 * @returns {[]}
 */
function get_teachersInfo(param){
    let teachersInfo = [];
    $.ajax({
        url:localhostPath+"/api/Teacher_basic/selectTeacher",
        type:"POST",
        data:{
            "user_Id":param.user_Id,
            "user_Name":param.user_Name,
            "col_Id":param.col_Id,
            "spe_Id":param.spe_Id,
            "current":param.current,
            "length":param.length
        },
        async:false,
        dataType:"json",
        success:function (res){
            teachersInfo = res.data;
        }
    })
    return teachersInfo;
}

/**
 * 查询教师数据封装
 * @param param
 * @param elementId
 */
function get_teachersInfo_elementId(param,elementId) {
    let teachersInfo = get_teachersInfo(param);
    let html = "";
    for (let i = 0; i < teachersInfo.length; i++) {
        html += "<tr>\n" +
            "                      <td><label class=\"lyear-checkbox checkbox-primary\">\n" +
            "                          <input type=\"checkbox\" name=\"permission\"  value=\"1\">\n" +
            "                          <span></span> </label></td>" +
            "<td>"+teachersInfo[i].user_Id+"</td>" +
            "<td>"+teachersInfo[i].user_Name+"</td>" +
            "<td>"+teachersInfo[i].user_Sex+"</td>" +
            "<td>"+teachersInfo[i].col_Name+"</td>" +
            "<td>"+teachersInfo[i].spe_Name+"</td>" +
            "<td>"+teachersInfo[i].user_Mobile+"</td>" +
            "<td><div class=\"btn-group\"> <a class=\"btn btn-xs btn-default\" href=\"#!\" title=\"编辑\" onclick='set_changeTeacherInfo_val("+teachersInfo[i].user_Id+")' data-toggle=\"modal\" data-target=\"#changeModal\"><i class=\"mdi mdi-pencil\"></i></a>  </div></td>\n</tr>";
        // "<td><div class=\"btn-group\"> <a class=\"btn btn-xs btn-default\" href=\"#!\" title=\"编辑\" onclick='set_changeStudentInfo_val("+studentsInfo[i].user_Id+")' data-toggle=\"modal\" data-target=\"#changeModal\"><i class=\"mdi mdi-pencil\"></i></a> <a class=\"btn btn-xs btn-default\" href=\"#!\" title=\"删除\" data-toggle=\"tooltip\"><i class=\"mdi mdi-window-close\"></i></a> </div></td>\n</tr>";
    }
    $("#"+elementId).empty();
    $("#"+elementId).append(html);
}

/**
 * 修改教师基本信息
 * @param param
 */
function teacherInfo_update(param) {
    $.ajax({
        url:localhostPath+"/api/Teacher_basic/updateTeacherBasicInfo",
        type:"POST",
        data:{
            "user_Id":param.user_Id,
            "user_Name":param.user_Name,
            "user_Type":param.user_Type,
            "user_Sex":param.user_Sex,
            "user_Mobile":param.user_Mobile,
            "college_Id":param.college_Id,
            "specialty_Id":param.specialty_Id
        },
        dataType:"json",
        success:function (res){
            if (res.code === 1){
                lightyear.loading('show');
                setTimeout(function (){
                    lightyear.loading('hide');
                    lightyear.notify(res.message,'success',3000);
                }, 1e3)
            } else {
                lightyear.loading('show');
                setTimeout(function (){
                    lightyear.loading('hide');
                    lightyear.notify(res.message,'danger',100);
                }, 1e3)
            }
        }
    })
}

/**
 * 根据user_Id 将需要修改的教师信息的信息放到相对应的标签内
 * @param user_Id
 * @returns {{}}
 */
function set_changeTeacherInfo_val(user_Id){
    let teacher = {};
    $.ajax({
        url:localhostPath+"/api/Teacher_basic/selectTeacher",
        type:"POST",
        data:{
            "user_Id":user_Id,
            "user_Name":'',
            "col_Id":'',
            "spe_Id":'',
            "current":-1,
            "length":-1
        },
        async:false,
        dataType:"json",
        success:function (res){
            teacher = res.data[0];
        }
    })
    $("#teacherChangeId").val(teacher.user_Id);
    $("#teacherChangeName").val(teacher.user_Name);
    $("input:radio[name=statusChange]")['男'===teacher.user_Sex?0:1].checked=true;
    $("#teacherCollegeChangeSelect").val(teacher.col_Id);
    get_specialtyInfo_elementId(teacher.col_Id,'teacherSpecialtyChangeSelect');
    $("#teacherSpecialtyChangeSelect").val(teacher.spe_Id);
    $("#teacherChangeMobile").val(teacher.user_Mobile);
}

/**
 * 添加课程信息
 * @param param
 */
function add_courseInfo(param) {
    if (check_submit(param)){
        $.ajax({
            url:localhostPath+"/api/Course/addCourseInfo",
            type:"POST",
            data:{
                "cou_Name":param.cou_Name,
                "spe_Id":param.spe_Id
            },
            dataType:"json",
            success:function (res){
                if (res.code === 1){
                    lightyear.loading('show');
                    setTimeout(function (){
                        lightyear.loading('hide');
                        lightyear.notify(res.message,'success',3000);
                    }, 1e3)
                } else {
                    lightyear.loading('show');
                    setTimeout(function (){
                        lightyear.loading('hide');
                        lightyear.notify(res.message,'danger',100);
                    }, 1e3)
                }
            }
        })
    }
}

/**
 * 获取查询课程信息的总条数
 * @param param
 */
function get_coursesInfo_itemsNum(param){
    let num = 0;
    $.ajax({
        url: localhostPath + "/api/Course/selectCourseInfo",
        type: "POST",
        data: {
            "cou_Id": param.cou_Id,
            "cou_Name": param.cou_Name,
            "col_Id": param.col_Id,
            "spe_Id": param.spe_Id,
            "current": "-1",
            "length": "-1"
        },
        async: false,
        dataType: "json",
        success: function (res) {
            num = res.data.length;
        }
    })
    return num;
}

/**
 * 获取查询课程结果
 * @param param
 * @returns {[]}
 */
function get_coursesInfo(param){
    let coursesInfo = [];
    $.ajax({
        url:localhostPath+"/api/Course/selectCourseInfo",
        type:"POST",
        data:{
            "cou_Id":param.cou_Id,
            "cou_Name":param.cou_Name,
            "col_Id":param.col_Id,
            "spe_Id":param.spe_Id,
            "current":param.current,
            "length":param.length
        },
        async:false,
        dataType:"json",
        success:function (res){
            coursesInfo = res.data;
        }
    })
    return coursesInfo;
}

/**
 * 查询课程数据封装
 * @param param
 * @param elementId
 */
function get_coursesInfo_elementId(param,elementId) {
    let coursesInfo = get_coursesInfo(param);
    let html = "";
    for (let i = 0; i < coursesInfo.length; i++) {
        html += "<tr>\n" +
            "                      <td><label class=\"lyear-checkbox checkbox-primary\">\n" +
            "                          <input type=\"checkbox\" name=\"permission\"  value=\"1\">\n" +
            "                          <span></span> </label></td>" +
            "<td>"+coursesInfo[i].id+"</td>" +
            "<td>"+coursesInfo[i].cou_Name+"</td>" +
            "<td>"+coursesInfo[i].col_Name+"</td>" +
            "<td>"+coursesInfo[i].spe_Name+"</td>" +
            "<td><div class=\"btn-group\"> <a class=\"btn btn-xs btn-default\" href=\"#!\" title=\"编辑\" onclick=\"set_changeCourseInfo_val('"+coursesInfo[i].id+"')\" data-toggle=\"modal\" data-target=\"#changeModal\"><i class=\"mdi mdi-pencil\"></i></a>  </div></td>\n</tr>";
        // "<td><div class=\"btn-group\"> <a class=\"btn btn-xs btn-default\" href=\"#!\" title=\"编辑\" onclick='set_changeStudentInfo_val("+studentsInfo[i].user_Id+")' data-toggle=\"modal\" data-target=\"#changeModal\"><i class=\"mdi mdi-pencil\"></i></a> <a class=\"btn btn-xs btn-default\" href=\"#!\" title=\"删除\" data-toggle=\"tooltip\"><i class=\"mdi mdi-window-close\"></i></a> </div></td>\n</tr>";
    }
    $("#"+elementId).empty();
    $("#"+elementId).append(html);
}

/**
 * 根据id 将需要修改的课程信息的信息放到相对应的标签内
 * @returns {{}}
 * @param cou_Id
 */
function set_changeCourseInfo_val(cou_Id){
    let course = {};
    $.ajax({
        url:localhostPath+"/api/Course/selectCourseInfo",
        type:"POST",
        data:{
            "cou_Id":cou_Id,
            "cou_Name":"",
            "col_Id":"",
            "spe_Id":"",
            "current":"-1",
            "length":"-1"
        },
        async:false,
        dataType:"json",
        success:function (res){
            course = res.data[0];
        }
    })
    $("#changeCourseId").val(course.id);
    $("#ChangeCollegeSelect").val(course.col_Id);
    get_specialtyInfo_elementId(course.col_Id,'ChangeSpecialtySelect');
    $("#ChangeSpecialtySelect").val(course.spe_Id);
    $("#changeCourseName").val(course.cou_Name);
}

/**
 * 修改课程基本信息
 * @param param
 */
function courseInfo_update(param) {
    $.ajax({
        url:localhostPath+"/api/Course/updateCourseInfo",
        type:"POST",
        data:{
            "Id":param.Id,
            "cou_Name":param.cou_Name,
            "spe_Id":param.spe_Id
        },
        dataType:"json",
        success:function (res){
            if (res.code === 1){
                lightyear.loading('show');
                setTimeout(function (){
                    lightyear.loading('hide');
                    lightyear.notify(res.message,'success',3000);
                }, 1e3)
            } else {
                lightyear.loading('show');
                setTimeout(function (){
                    lightyear.loading('hide');
                    lightyear.notify(res.message,'danger',100);
                }, 1e3)
            }
        }
    })
}

/**
 * 学院信息封装用于分配课程
 * @param col_Id
 * @param elementId
 */
function get_collegeInfo_elementId_distribution(col_Id,elementId){
    let collegeInfo = get_collegeInfo(col_Id);
    let html ="<option value=''>不限学院</option>";
    for (let i = 0; i < collegeInfo.length; i++) {
        html += "<option value='"+collegeInfo[i].id+"'>"+collegeInfo[i].col_Name+"</option>"
    }
    $("#"+elementId).append(html);
}

/**
 * 专业信息封装用于分配课程
 * @param col_Id
 * @param elementId
 */
function get_specialtyInfo_elementId_distribution(col_Id,elementId){
    let specialtyInfo = get_specialtyInfo(col_Id);
    let html = "<option value=''>不限专业</option>";
    for (let i = 0; i < specialtyInfo.length; i++) {
        html += "<option value='"+specialtyInfo[i].id+"'>"+specialtyInfo[i].spe_Name+"</option>";
    }
    $("#"+elementId).empty();
    $("#"+elementId).append(html);
}

/**
 * 查询课程信息，用于分配课程
 * @param col_Id
 * @param spe_Id
 * @param elementId
 */
function get_coursesInfo_elementId_distribution(col_Id,spe_Id,elementId){
    $.ajax({
        url:localhostPath+"/api/Course/selectCourseInfo",
        type:"POST",
        data:{
            "cou_Id":"",
            "cou_Name":"",
            "col_Id":col_Id,
            "spe_Id":spe_Id,
            "current":"-1",
            "length":"-1"
        },
        async:false,
        dataType:"json",
        success:function (res){
            let coursesInfo = res.data;
            let html = "";
            if (elementId === 'courses'){
                html += "<option value=''>不限课程</option>";
            } else {
                html += "<option value=''>请选择课程信息</option>";
            }
            for (let i = 0; i < coursesInfo.length; i++) {
                html += "<option value='"+coursesInfo[i].id+"'>"+coursesInfo[i].cou_Name+"</option>"
            }
            $("#"+elementId).empty();
            $("#"+elementId).append(html);
        }
    })
}

/**
 * 查询教师信息，用于分配课程
 * @returns {[]}
 * @param col_Id
 * @param spe_Id
 * @param elementId
 */
function get_teachersInfo_element_distribution(col_Id,spe_Id,elementId){
    $.ajax({
        url:localhostPath+"/api/Teacher_basic/selectTeacher",
        type:"POST",
        data:{
            "user_Id":"",
            "user_Name":"",
            "col_Id":col_Id,
            "spe_Id":spe_Id,
            "current":"-1",
            "length":"-1"
        },
        async:false,
        dataType:"json",
        success:function (res){
            let teachersInfo = res.data;
            let html = "";
            if (elementId === 'teachers'){
                html += "<option value=''>不限教师</option>";
            } else {
                html += "<option value=''>请选择教师信息</option>";
            }
            for (let i = 0; i < teachersInfo.length; i++) {
                html += "<option value='"+teachersInfo[i].user_Id+"'>"+teachersInfo[i].user_Name+"</option>";
            }
            $("#"+elementId).empty();
            $("#"+elementId).append(html);
        }
    })
}

function get_classesInfo_element_distribution(col_Id,spe_Id,elementId){
    $.ajax({
        url:localhostPath+"/api/classInfo/selectClassInfo",
        type:"POST",
        data:{
            "Id":"",
            "class_Id":"",
            "col_Id":col_Id,
            "spe_Id":spe_Id,
            "current":"-1",
            "length":"-1"
        },
        async:false,
        dataType:"json",
        success:function (res){
            let classesInfo = res.data;
            let html = "";
            if (elementId === 'classes'){
                html += "<option value=''>不限班级</option>";
            } else {
                html += "<option value=''>请选择班级信息</option>";
            }
            for (let i = 0; i < classesInfo.length; i++) {
                html += "<option value='"+classesInfo[i].id+"'>"+classesInfo[i].class_Id+"</option>";
            }
            $("#"+elementId).empty();
            $("#"+elementId).append(html);
        }
    })
}

/**
 * 添加分配课程信息
 * @param param
 */
function add_classCourseInfo(param) {
    if (check_submit(param)){
        $.ajax({
            url:localhostPath+"/api/classCourseInfo/addClassCourseInfo",
            type:"POST",
            data:{
                "classes_Id":param.classes_Id,
                "user_Id":param.user_Id,
                "cou_Id":param.cou_Id
            },
            dataType:"json",
            success:function (res){
                if (res.code === 1){
                    lightyear.loading('show');
                    setTimeout(function (){
                        lightyear.loading('hide');
                        lightyear.notify(res.message,'success',3000);
                    }, 1e3)
                } else {
                    lightyear.loading('show');
                    setTimeout(function (){
                        lightyear.loading('hide');
                        lightyear.notify(res.message,'danger',100);
                    }, 1e3)
                }
            }
        })
    }
}

/**
 * 获取查询到分配课程信息的总行数
 * @param param
 * @returns {number}
 */
function get_distributionsInfo_itemsNum(param){
    let num = 0;
    $.ajax({
        url: localhostPath + "/api/classCourseInfo/selectDistributionInfo",
        type: "POST",
        data: {
            "class_Id": param.class_Id,
            "user_Id": param.user_Id,
            "cou_Id": param.cou_Id,
            "current": "-1",
            "length": "-1"
        },
        async: false,
        dataType: "json",
        success: function (res) {
            num = res.data.length;
        }
    })
    return num;
}

/**
 * 获取分配课程信息
 * @param param
 * @returns {[]}
 */
function get_distributionsInfo(param) {
    let distributionsInfo = [];
    $.ajax({
        url:localhostPath+"/api/classCourseInfo/selectDistributionInfo",
        type:"POST",
        data:{
            "class_Id":param.class_Id,
            "user_Id":param.user_Id,
            "cou_Id":param.cou_Id,
            "current":param.current,
            "length":param.length
        },
        async:false,
        dataType:"json",
        success:function (res){
            distributionsInfo = res.data;
        }
    })
    return distributionsInfo;
}

/**
 * 获取分配信息封装
 * @param param
 * @param elementId
 */
function get_distributionsInfo_elementId(param,elementId) {
    let distributionsInfo = get_distributionsInfo(param);
    let html = "";
    for (let i = 0; i < distributionsInfo.length; i++) {
        html += "<tr>\n" +
            "                      <td><label class=\"lyear-checkbox checkbox-primary\">\n" +
            "                          <input type=\"checkbox\" name=\"permission\"  value=\"1\">\n" +
            "                          <span></span> </label></td>" +
            "<td>"+distributionsInfo[i].class_Id+"</td>" +
            "<td>"+distributionsInfo[i].cou_Name+"</td>" +
            "<td>"+distributionsInfo[i].user_Name+"</td>" +
            "<td><div class=\"btn-group\"> <a class=\"btn btn-xs btn-default\" href=\"#!\" title=\"编辑\" onclick=\"distribution_update();set_changeDistribution_Val('"+distributionsInfo[i].classes_Id+"','"+distributionsInfo[i].cou_Id+"','"+distributionsInfo[i].user_Id+"');\" data-toggle=\"modal\" data-target=\"#changeModal\"><i class=\"mdi mdi-pencil\"></i></a>  </div></td>\n</tr>";
        // "<td><div class=\"btn-group\"> <a class=\"btn btn-xs btn-default\" href=\"#!\" title=\"编辑\" onclick='set_changeStudentInfo_val("+studentsInfo[i].user_Id+")' data-toggle=\"modal\" data-target=\"#changeModal\"><i class=\"mdi mdi-pencil\"></i></a> <a class=\"btn btn-xs btn-default\" href=\"#!\" title=\"删除\" data-toggle=\"tooltip\"><i class=\"mdi mdi-window-close\"></i></a> </div></td>\n</tr>";
    }
    $("#"+elementId).empty();
    $("#"+elementId).append(html);
}

function distribution_update(){
    get_coursesInfo_elementId_distribution($('#changeCollegeSelect').val(),$('#changeSpecialtySelect').val(),'changeCourseSelect');
    get_teachersInfo_element_distribution($('#changeCollegeSelect').val(),$('#changeSpecialtySelect').val(),'changeTeacherSelect');
    get_classesInfo_element_distribution($('#changeCollegeSelect').val(),$('#changeSpecialtySelect').val(),'changeClassSelect');
}

/**
 * 根据classId\cou_Id\user_Id 将需要修改的分配课程信息的信息放到相对应的标签内
 * @param classId
 * @param cou_Id
 * @param user_Id
 */
function set_changeDistribution_Val(classId,cou_Id,user_Id) {
    let distributionInfo = {};
    $.ajax({
        url:localhostPath+"/api/classCourseInfo/selectDistributionInfo",
        type:"POST",
        data:{
            "class_Id":classId,
            "user_Id":user_Id,
            "cou_Id":cou_Id,
            "current":"-1",
            "length":"-1"
        },
        async:false,
        dataType:"json",
        success:function (res){
            distributionInfo = res.data[0];
        }
    })
    $("#old_classes_Id").val(distributionInfo.classes_Id);
    $("#old_cou_Id").val(distributionInfo.cou_Id);
    $("#old_user_Id").val(distributionInfo.user_Id);

    $("#changeClassSelect").val(distributionInfo.classes_Id);
    $("#changeCourseSelect").val(distributionInfo.cou_Id);
    $("#changeTeacherSelect").val(distributionInfo.user_Id);
}

/**
 * 更新分配课程信息
 * @param param
 */
function classCourseInfo_update(param){
    $.ajax({
        url:localhostPath+"/api/classCourseInfo/updateClassCourseInfo",
        type:"POST",
        data:{
            "new_classes_Id":param.new_classes_Id,
            "new_user_Id":param.new_user_Id,
            "new_cou_Id":param.new_cou_Id,
            "old_classes_Id":param.old_classes_Id,
            "old_user_Id":param.old_user_Id,
            "old_cou_Id":param.old_cou_Id
        },
        dataType:"json",
        success:function (res){
            if (res.code === 1){
                lightyear.loading('show');
                setTimeout(function (){
                    lightyear.loading('hide');
                    lightyear.notify(res.message,'success',3000);
                }, 1e3)
            } else {
                lightyear.loading('show');
                setTimeout(function (){
                    lightyear.loading('hide');
                    lightyear.notify(res.message,'danger',100);
                }, 1e3)
            }
        }
    })
}

/**
 * 添加班级信息
 * @param param
 */
function add_ClassInfo(param){
    if (check_submit(param)){
        $.ajax({
            url:localhostPath+"/api/classInfo/addClassInfo",
            type:"POST",
            data:{
                class_Id:param.class_Id,
                people_Num: "0",
                class_Col_Id: param.class_Col_Id,
                class_Spe_Id: param.class_Spe_Id
            },
            dataType:"json",
            success:function (res){
                if (res.code === 1){
                    lightyear.loading('show');
                    setTimeout(function (){
                        lightyear.loading('hide');
                        lightyear.notify(res.message,'success',3000);
                    }, 1e3)
                } else {
                    lightyear.loading('show');
                    setTimeout(function (){
                        lightyear.loading('hide');
                        lightyear.notify(res.message,'danger',100);
                    }, 1e3)
                }
            }
        })
    }
}

/**
 * 获取查询班级信息的数目
 * @param param
 * @returns {number}
 */
function get_classesInfo_count(param){
    let num = 0;
    $.ajax({
        url:"",
        type:"POST",
        data:{
            Id:param.Id,
            class_Id:param.class_Id,
            col_Id:param.col_Id,
            spe_Id:param.spe_Id,
        },
        dataType:"json",
        async:false,
        success:function (res){
            num = res.count;
        }
    })
    return num;
}

/**
 * 查询班级信息
 * @param param
 */
function get_classes_info(param){
    let infos = [];
    $.ajax({
        url:localhostPath+"/api/classInfo/select_classInfo_keywords",
        type:"POST",
        data:{
            Id:param.Id,
            class_Id:param.class_Id,
            col_Id:param.col_Id,
            spe_Id:param.spe_Id,
            current:param.current,
            length:param.length
        },
        async:false,
        dataType:"json",
        success:function (res){
            infos = res.data;
        }
    })
    return infos;
}

/**
 * 将查询到的班级信息封装
 * @param param
 * @param elementId
 */
function get_class_info_elementId(param,elementId){
    let infos = get_classes_info(param);
    let html = "";
    for (let i = 0; i < infos.length; i++) {
        html += "<tr>\n" +
            "                      <td><label class=\"lyear-checkbox checkbox-primary\">\n" +
            "                          <input type=\"checkbox\" name=\"permission\"  value=\"1\">\n" +
            "                          <span></span> </label></td>" +
            "<td>"+infos[i].col_Name+"</td>" +
            "<td>"+infos[i].spe_Name+"</td>" +
            "<td>"+infos[i].class_Id+"</td>" +
            "<td>"+infos[i].people_Num+"</td>" +
            "<td><div class=\"btn-group\"> <a class=\"btn btn-xs btn-default\" href=\"#!\" title=\"编辑\" onclick=\"setChangeClassInfo_Val('"+infos[i].id+"')\" data-toggle=\"modal\" data-target=\"#changeModal\"><i class=\"mdi mdi-pencil\"></i></a>  </div></td>\n</tr>";
    }
    $("#"+elementId).empty();
    $("#"+elementId).append(html);
}

/**
 * 将需要修改的班级信息其值放入对应的标签内
 * @param Id
 */
function setChangeClassInfo_Val(Id){
    let temp_param = {
        Id:Id,
        class_Id:"",
        col_Id:"",
        spe_Id:"",
        current:"-1",
        length:"-1"
    }
    let classInfo = get_classes_info(temp_param)[0];
    console.log(classInfo);
    $('#ChangeCollegeSelect').val(classInfo.col_Id);
    get_specialtyInfo_elementId(classInfo.col_Id,'ChangeSpecialtySelect');
    $('#ChangeSpecialtySelect').val(classInfo.spe_Id);
    $('#classChangeNum').val(classInfo.class_Id);
    $('#changeClassId').val(classInfo.id);
}

/**
 * 修改班级信息
 * @param param
 */
function update_classInfo(param){
    if (check_submit(param)){
        $.ajax({
            url:localhostPath+"/api/classInfo/updateClassInfo",
            type:"POST",
            data:{
                Id:param.Id,
                class_Id:param.class_Id,
                people_Num:"0",
                class_Col_Id:param.col_Id,
                class_Spe_Id:param.spe_Id
            },
            dataType:"json",
            success:function (res){
                if (res.code === 1){
                    lightyear.loading('show');
                    setTimeout(function (){
                        lightyear.loading('hide');
                        lightyear.notify(res.message,'success',3000);
                    }, 1e3)
                } else {
                    lightyear.loading('show');
                    setTimeout(function (){
                        lightyear.loading('hide');
                        lightyear.notify(res.message,'danger',100);
                    }, 1e3)
                }
            }
        })
    }
}