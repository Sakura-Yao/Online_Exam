//document.write("<script language=javascript src='DateUtils.js'></script>");

var college_info={
    college:"电子信息工程学院,机电与材料工程学院,机器人工程学院,数据科学与人工智能学院,智能汽车与航空学院,建筑与土木工程学院,服装学院,艺术与传媒学院,经济管理学院,外语学院",
    0:"电子信息工程,通信工程,信息工程",
    1:"机械设计制造及其自动化,焊接技术与工程,材料成型与控制工程,工业设计",
    2:"机器人工程,自动化,电器工程及其自动化,机械电子工程,智能制造工程",
    3:"计算机科学与技术,软件工程,物联网科学与大数据技术,信息管理与信息系统,大数据",
    4:"交通运输,车辆工程,汽车服务工程",
    5:"土木工程,建筑学,工程管理,工程造价",
    6:"服装设计与工程,服装与服装设计",
    7:"视觉传达设计,环境设计,广播电视编导,动画,数字媒体艺术",
    8:"财务管理,工商管理,人力资源管理,市场营销,国际经济与贸易",
    9:"英语,俄语"
};
function GetRequest() {
    /*用法如下
    var request = new Object();
    request = GetRequest();
    var email = request['email'];
    var name = request['name'];*/
    var url = location.search; //获取url中"?"符后的字串
    var theRequest = new Object();
    if (url.indexOf("?") != -1) {
        var str = url.substr(1);
        // alert(str);
        strs = str.split("&");
        for (var i = 0; i < strs.length; i++) {
            theRequest[strs[i].split("=")[0]] = unescape(strs[i].split("=")[1]);
        }
    }
    return theRequest;
}

$(".url").click(function () {
    $("#left_menu_title").html($(this).text());
    var targetURL = $(this).attr("url");
    if(targetURL == null){
        alert("功能暂未发布");
    }
    document.getElementById("Location").src = targetURL;
})

//将字符串转换为select选择形式 courses
function get_courses(teach_courses,ElementId) {
    var type = teach_courses.split(",");
    for (var x = 0; x < type.length; x++){
        var option = "<option name='courses' value=" + type[x] +">"+type[x]+"</option>";
        document.getElementById(ElementId).innerHTML += option;
    }
}

//将字符串转换为select选择形式 class
function get_class(teach_class,ElementId) {
    var type = teach_class.split(",");
    for (var x = 0; x < type.length; x++){
        var option = "<option name='courses' value=" + type[x] +">"+type[x]+"</option>";
        document.getElementById(ElementId).innerHTML += option;
    }
}

//获取学院和专业的关联关系
function get_college_info(){
    var type = college_info.college.split(",");
    for (var x = 0; x < type.length; x++){
        var option = "<option name='specianlty' value=" + x +">"+type[x]+"</option>";
        document.getElementById('college').innerHTML += option;
    }
}

function get_specianlty_info(college_index){
    $("#specianlty").empty();
    var type = college_info[parseInt(college_index)].split(",");
    for (var x = 0; x < type.length; x++){
        var option = "<option value=" + x +">"+type[x]+"</option>";
        document.getElementById('specialty').innerHTML += option;
    }
}

function Login(use_id,password) {
    console.log("Login_function:"+use_id+password);
    $.ajax({
        url:"/UserLogin",
        type:"POST",
        data:{
            user_id:use_id,
            password:password
        },
        dataType:"json",
        success:function (res) {
            console.log(res);
            if (res.code === 1){
                window.location.href="../index.html";
            }
            else{
                alert(res.message);
                window.location.href="../Login.html";
            }
        }
    })
}

function get_session() {
    var User = "";
    $.ajax({
        url:"/getSession",
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

//添加学生信息方法
function DoAddStudentInfo (param) {
    console.log(param);
    $.ajax({
        url:"/User/addUser",
        type:"POST",
        data:{
            user_id:param.user_id,
            password:param.password,
            type:param.type,
            name:param.name,
            stu_class:param.stu_class,
            sex:param.sex,
            mobile:param.mobile,
            stu_college:param.stu_college,
            stu_specialty:param.stu_specialty
        },
        dataType:"json",
        success:function (res) {
            console.log(res);
            //insert code
            alert(res.message);
        }
    })
}

//删除用户信息方法
function deleteUser(user_id) {
    var delete_message = "您确定删除该行数据吗？";
    if (confirm(delete_message) == true){
        $.ajax({
            url:"/User/DeleteUser",
            type:"POST",
            data:{
                user_id:user_id
            },
            dataType:"json",
            success:function (res) {
                console.log(res);
                if (res.code === 1){
                    alert("删除成功");
                    window.location.href="/Student/select_stu.html"
                }
            }
        })
    }
}

//查询学生信息方法
function selectStudentInfo(param) {
    console.log(param);
    $.ajax({
        url:"/User/SelectUser",
        type:"POST",
        data:{
            user_id:param.user_id,
            type:param.type,
            stu_class:param.stu_class,
            name:param.name,
            sex:param.sex,
            stu_college:param.stu_college,
            stu_specialty:param.stu_specialty
        },
        dataType:"json",
        success:function (res) {
            console.log(res);
            if (res.code === -1){
                alert("登录状态过期！请重新登录！");
                window.location.href="/Login.html";
            }
            var html = "";
            for (var num in res.data) {
                html += '<tr id="info">' +
                    '<td><input type="checkbox" value="'+res.data[num].user_id+'"/></td> ' +
                    '<td>' + res.data[num].user_id + '</td>' +
                    '<td>' + res.data[num].stu_class + '</td>' +
                    '<td>' + res.data[num].name + '</td>' +
                    '<td>' + res.data[num].sex + '</td>' +
                    '<td>' + res.data[num].stu_college + '</td>' +
                    '<td>' + res.data[num].stu_specialty + '</td>' +
                    '<td>' + '<a class="link-update" href="javascript:void(0);" onclick="updateStudentInfo(' +
                    res.data[num].user_id+')">修改'+'</a>'+'<span> </span>'+
                    '<a class="link-update" href="javascript:void(0);" onclick="deleteUser(' +
                    res.data[num].user_id+')">删除'+'</a>'+ '</td></tr>';
            }
            $("tr").remove("#info");
            $("#student").append(html);
        }
    })
}

function updateStudentInfo(user_id) {
    window.location.href="../Student/update_stu.html?user_id="+user_id;
}

function doUpdateStudentInfo(param) {
    console.log(param);
    $.ajax({
        url:"/User/UpdateUser",
        type:"POST",
        data:{
            user_id:param.user_id,
            password:param.password,
            type:param.type,
            name:param.name,
            stu_class:param.stu_class,
            sex:param.sex,
            mobile:param.mobile,
            stu_college:param.stu_college,
            stu_specialty:param.stu_specialty
        },
        dataType:"json",
        success:function (res) {
            //insert code
            alert(res.message);
            window.location.href="/Student/select_stu.html"
        }
    })
}

function select_user_id(user_id) {
    var user="";
    $.ajax({
        url:"/User/SelectByUserId",
        type:"POST",
        async:false,
        data:{
            user_id:user_id
        },
        dataType:"json",
        success:function (res) {
            user = res.data[0];
        }
    });
    return user;
}

//添加教师信息
function addTeacherInfo(param) {
    console.log(param);
    $.ajax({
        url:"/Teacher/addTeacher",
        type:"POST",
        data:{
            user_id:param.user_id,
            password:param.password,
            type:param.type,
            name:param.name,
            sex:param.sex,
            mobile:param.mobile,
            college:param.college,
            specialty:param.specialty,
            teach_courses:param.teach_courses,
            teach_class:param.teach_class
        },
        dataType:"json",
        success:function (res) {
            console.log(res);
            //insert code
            alert(res.message);
        }
    })
}

//查询教师信息
function selectTeacherInfo(user_id) {
    $.ajax({
        url:"/Teacher/selectTeacher",
        type:"POST",
        data:{
            user_id:user_id,
            name:"",
        },
        dataType:"json",
        success:function (res) {
            console.log(res);
            if (res.code === -1){
                alert("登录状态过期！请重新登录！");
                window.location.href="/Login.html";
            }
            var html = "";
            for (var num in res.data) {
                html += '<tr id="info">' +
                    '<td><input type="checkbox" value="'+res.data[num].user_id+'"/></td> ' +
                    '<td>' + res.data[num].user_id + '</td>' +
                    '<td>' + res.data[num].name + '</td>' +
                    '<td>' + res.data[num].sex + '</td>' +
                    '<td>' + res.data[num].college + '</td>' +
                    '<td>' + res.data[num].specialty + '</td>' +
                    '<td>' + '<a class="link-update" href="javascript:void(0);" onclick="updateTeacherInfo(' +
                    res.data[num].user_id+')">修改'+'</a>'+'<span> </span>'+
                    '<a class="link-update" href="javascript:void(0);" onclick="delete_teacherInfo(' +
                    res.data[num].user_id+')">删除'+'</a>'+ '</td></tr>';
            }
            $("tr").remove("#info");
            $("#teacher").append(html);
        }
    })
}

//删除教师信息
function delete_teacherInfo(user_id) {
    var delete_message = "您确定删除该行数据吗？";
    if (confirm(delete_message) == true){
        $.ajax({
            url:"/Teacher/deleteTeacher",
            type:"POST",
            data:{
                user_id:user_id
            },
            dataType:"json",
            success:function (res) {
                console.log(res);
                if (res.code === 1){
                    alert("删除成功");
                    window.location.href="/Teacher/select_teacher.html"
                }
            }
        })
    }
}

function updateTeacherInfo(user_id) {
    window.location.href="../Teacher/update_teacher.html?user_id="+user_id;
}

function doupdate_teacher(param) {
    console.log(param);
    $.ajax({
        url:"/Teacher/updateTeacher",
        type:"POST",
        data:{
            user_id:param.user_id,
            password:param.password,
            type:"Teacher",
            name:param.name,
            sex:param.sex,
            mobile:param.mobile,
            college:param.college,
            specialty:param.specialty,
            teach_courses:param.teach_courses,
            teach_class:param.teach_class
        },
        dataType:"json",
        success:function (res) {
            console.log(res);
            //insert code
            alert(res.message);
        }
    })
}

//获取某个教师信息
function selectTeacherInfoReturnUser(user_id) {
    console.log("zoule____________");
    var user = "";
    $.ajax({
        url: "/Teacher/selectTeacher",
        type: "POST",
        async:false,
        data: {
            user_id: user_id,
            name: "",
        },
        dataType: "json",
        success: function (res) {
            user = res.data[0];
        }
    })
    return user;
}

//模糊查询试题
function select_question(param) {
    $.ajax({
        url: "/Question/SelectByKeyWord",
        type: "POST",
        data: {
            category: param.category,
            type: param.type,
            subject: param.subject,
            degree: param.degree,
            point: param.point
        },
        dataType: "json",
        success: function (res) {
            console.log(res);
            if (res.code === -1) {
                alert("登录状态过期！请重新登录！");
                window.location.href = "/Login.html";
            }
            var html = "";
            for (var num in res.data) {
                html += '<tr id="info">' +
                    '<td><input type="checkbox" value="'+res.data[num].question_id+'"></td>' +
                    '<td>' + res.data[num].subject + '</td>' +
                    '<td>' + res.data[num].answer + '</td>' +
                    '<td>' + res.data[num].category + '</td>' +
                    '<td>' + res.data[num].type + '</td>' +
                    '<td>' + res.data[num].degree + '</td>' +
                    '<td>' + res.data[num].point + '</td>' +
                    '<td>' + '<a class="link-update" href="javascript:void(0);" onclick="updateQuestionInfo(' +
                    res.data[num].question_id + ')">修改' + '</a>' + '<span> </span>' +
                    '<a class="link-update" href="javascript:void(0);" onclick="deleteQuestion(' +
                    res.data[num].question_id + ')">删除' + '</a>' + '</td></tr>';
            }
            $("tr").remove("#info");
            $("#question").append(html);
            // $("span#question_count").append(res.data.length);
        }
    })
}

//修改试题
function updateQuestionInfo(question_id) {
    window.location.href="../Question/update_question.html?question_id="+question_id;
}

function selectQuestionByQuestion_id(question_id) {
    var question="";
    $.ajax({
        url:"/Question/SelectQuestionById",
        type:"POST",
        async: false,
        data:{Question_id:question_id},
        dataType:"json",
        success:function (res) {
            question = res.data;
        }
    });
    return question;
}

function doUpdateQuestionInfo(param) {
    $.ajax({
        url:"/Question/DoUpdateQuestion",
        type:"POST",
        data:{
            question_id:param.question_id,
            category:param.category,
            type:param.type,
            subject:param.subject,
            choice_a:param.choice_a,
            choice_b:param.choice_b,
            choice_c:param.choice_c,
            choice_d:param.choice_d,
            answer:param.answer,
            degree:param.degree,
            point:param.point,
            analysis:param.analysis
        },
        dataType:"json",
        success:function (res) {
            console.log(res);
            if (res.code === 1){
                alert("修改成功！");
                window.location.href="../Question/Questions.html";
            }
            //insert code
        }
    })
}

//删除试题
function deleteQuestion(question_id) {
    var delete_message = "您确定删除该试题吗？";
    if (confirm(delete_message) == true){
        $.ajax({
            url:"/Question/DeleteQuestion",
            type:"POST",
            data:{
                question_id:question_id
            },
            dataType:"json",
            success:function (res) {
                console.log(res);
                //insert code
                if (res.code === 1){
                    alert(res.message);
                }
            }
        })
    }
}

//添加试题
function DoAddQuestion(param) {
    if (param.type === "选择题"){
        $.ajax({
            url:"/Question/DoAddQuestion_choice",
            type:"POST",
            data:{
                category:param.category,
                type:param.type,
                subject:param.subject,
                choice_a:param.choice_a,
                choice_b:param.choice_b,
                choice_c:param.choice_c,
                choice_d:param.choice_d,
                answer:param.answer,
                degree:param.degree,
                point:param.point,
                analysis:param.analysis
            },
            dataType:"json",
            success:function (res) {
                console.log(res);
                //insert code
                if (res.code === 1){
                    alert("添加成功！");

                }
            }
        })
    }
    else if (param.type === "填空题"){
        $.ajax({
            url:"/Question/DoAddQuestion_fill",
            type:"POST",
            data:{
                category:param.category,
                type:param.type,
                subject:param.subject,
                choice_a:"--",
                choice_b:"--",
                choice_c:"--",
                choice_d:"--",
                answer:param.answer,
                degree:param.degree,
                point:param.point,
                analysis:param.analysis
            },
            dataType:"json",
            success:function (res) {
                console.log(res);
                //insert code
                if (res.code === 1){
                    alert("添加成功！");

                }
            }
        })
    }
    else if (param.type === "判断题"){
        $.ajax({
            url:"/Question/DoAddQuestion_tf",
            type:"POST",
            data:{
                category:param.category,
                type:param.type,
                subject:param.subject,
                choice_a:"--",
                choice_b:"--",
                choice_c:"--",
                choice_d:"--",
                answer:param.answer,
                degree:param.degree,
                point:param.point,
                analysis:param.analysis
            },
            dataType:"json",
            success:function (res) {
                console.log(res);
                //insert code
                if (res.code === 1){
                    alert("添加成功！");

                }
            }
        })
    }
    else if (param.type === "简答题"){
        $.ajax({
            url:"/Question/DoAddQuestion_essay",
            type:"POST",
            data:{
                category:param.category,
                type:param.type,
                subject:param.subject,
                choice_a:"--",
                choice_b:"--",
                choice_c:"--",
                choice_d:"--",
                answer:param.answer,
                degree:param.degree,
                point:param.point,
                analysis:param.analysis
            },
            dataType:"json",
            success:function (res) {
                console.log(res);
                //insert code
                if (res.code === 1){
                    alert("添加成功！");

                }
            }
        })
    }
    else {
        alert("请输入完整信息！");
    }
}

function get_Paper_name() {
    $.ajax({
        url:"/Paper/SelectAllPaper",
        type:"POST",
        data:{},
        dataType:"json",
        success:function (res) {
            console.log(res);
            for (var num in res.data){
                var option = "<option value='" + res.data[num].paper_id + "'>"+res.data[num].paper_name+"</option>";
                document.getElementById('Paper_name').innerHTML += option;
            }
        }
    })
}

function add_Exam_Function(param) {
    $.ajax({
        url: "/TextPaper/DoAddTextPaper",
        type:"POST",
        data:{
            test_paper_name: param.test_paper_name,
            paper_id: param.paper_id,
            test_begin_time: param.test_begin_time,
            test_end_time: param.test_end_time,
            test_length: param.test_length,
            test_times: param.test_times,
            passing_mark: param.passing_mark,
            class_id: param.class_id,
            paper_maker: param.paper_maker,
            test_placr: param.test_placr,
            invigilation: param.invigilation
        },
        dataType:"json",
        success:function (res) {
            console.log(res);
            if(res.code === 1){
                successPostAlert();
                alert("添加成功！");
                window.location.href="mainExam.html";
                console.log(res.data.type);
            }if (res.code === 0){
                errorAlert();
                window.location.href="addExam.html";
            }
        },
        error:function(arg1){

            alert("请填写完整的正确信息！");

        }
    })
}

function SelectExam(param) {
    $.ajax({
        url:"/TextPaper/SelectTextPaper",
        type:"GET",
        data:{
            testpaper_id:param.testpaper_id,
            testpaper_name:param.testpaper_name,
            paper_id:param.paper_id,
            class_id:param.class_id,
            paper_maker:param.paper_maker,
            test_placr:param.test_placr
        },
        dataType:"json",
        success:function (res) {
            if (res.code === -1){
                alert("登录状态过期！请重新登录！");
                window.location.href="/Login.html";
            }
            var html = "";
            if (res.code === 0){
                alert(res.message);
                return null;
            }
            for (var num in res.data) {
                html += '<tr id="info">' +
                    '<td><input type="checkbox" value="'+res.data[num].test_paper_id+'"></td>' +
                    '<td>' + res.data[num].test_paper_id + '</td>' +
                    '<td>' + res.data[num].test_paper_name + '</td>' +
                    '<td>' + res.data[num].paper_id + '</td>' +
                    '<td>' + formatDate(new Date(res.data[num].test_begin_time))+ '</td>' +
                    '<td>' + formatDate(new Date(res.data[num].test_end_time)) + '</td>' +
                    '<td>' + res.data[num].class_id + '</td>' +
                    '<td>' + get_Exam_State(res.data[num].test_begin_time,res.data[num].test_end_time,res.data[num].test_paper_id)+'</td>' +
                    '<td>' + '<button class="btn btn-success" onclick="updateExamModal(' +
                    res.data[num].test_paper_id+')" id="Exam' +
                    res.data[num].test_paper_id+'" >修改'+'</button>'+'<span> </span>'+
                    '<button class="btn btn-primary" onclick="deleteTextPaper(' +
                    res.data[num].test_paper_id+')">删除'+'</button>' +
                    '<span> </span>'+ '<button class="btn btn-pink" onclick="goToJudgmentExam('+res.data[num].test_paper_id+','+ res.data[num].class_id +')">阅卷</button> ' +
                    '</td>' +
                    '</tr>';
            }
            $("tr").remove("#info");
            $("#Exam").append(html);
            // $("span#question_count").append(res.data.length);
            // if (res.data!=null){
            //     document.getElementById("exam_count").innerText=res.data.length;
            // }
            // else {
            //     document.getElementById("exam_count").innerText="0";
            // }
        }
    })
}
// function updateExamModal(text_paper_id){
//     window.location.href="../Exam/updateExam.html?text_paper_id="+text_paper_id;
// }

/*start here*/

function goToJudgmentExam(text_paper_id,class_id){
    window.location.href="../Exam/judgmentExam.html?text_paper_id="+text_paper_id+"&class_id="+class_id;
}

function selectUserAndTextPaper(text_paper_id,class_id) {
    $.ajax({
        url:"/TextPaper/SelectClassIdTextPaper",
        type:"POST",
        data:{
            text_paper_id:text_paper_id,
            class_id:class_id,
        },
        dataType:"json",
        success:function (res) {
            console.log(res);
            if (res.code === -1){
                alert("登录状态过期！请重新登录！");
                window.location.href="/Login.html";
            }
            if(res.t_student_id)
                var html = "";
            for (var num in res.data) {
                html += '<tr id="info">' +
                    '<td><input type="checkbox" value="'+res.data[num].user_id+'"/></td> ' +
                    '<td>' + res.data[num].user_id + '</td>' +
                    '<td>' + res.data[num].name + '</td>' +
                    '<td>' + res.textPaperName + '</td>' +
                    '<td>' + res.data[num].stu_class + '</td>' +
                    '<td id="JudgmentInfo">未批阅</td>' +

                    '<td>' +
                    '<a class="link-update" href="javascript:void(0);" onclick="JudgmentUser(' +
                    res.data[num].user_id+','+text_paper_id+')">阅卷'+'</a>'+ '</td></tr>';
            }
            $("tr").remove("#info");
            $("#Student_Exam_judgment").append(html);
        }
    })

}

function JudgmentUser(user_id,text_paper_id) {
    $("#stu_idLabel").text(user_id);
    $('#judgemtModal').modal('toggle');
    $.ajax({
        url:"/TextPaper/SelectExaminfoByStuId",
        type:"POST",
        data:{
            Stu_id:user_id,
            TextPaper_id:text_paper_id,
        },
        dataType:"json",
        success:function (res) {
            console.log(res);
            if (res.code === -1){
                alert("登录状态过期！请重新登录！");
                window.location.href="/Login.html";
            }
            if(res.code === 1){
                var html = "";
                var points = res.paperPoints.split(",");
                for (var num in res.data) {


                    if (checkthis(res.Questions[num].type,res.data[num].answer,res.data[num].stu_answer,points[num],num) === 1){
                        html += '<tbody id="tq">+' +
                            '<tr id="infoQuestion">' +
                            '<td name="question_id">' + res.Questions[num].question_id + '</td>' +
                            '<td>' + res.Questions[num].type + '</td>' +
                            '<td>' + res.Questions[num].subject + '</td>' +
                            '<td>' + res.data[num].answer + '</td>' +
                            '<td>' + res.data[num].stu_answer + '</td>' +
                            '<td>' + points[num] + '</td>' +
                            '<td>' + '<input type="number" id="question_point_'+num+'" value="'+points[num]+'" readonly name="questionPoint"/>' + '</td>' +
                            '</tr></tbody>';
                    }else if (checkthis(res.Questions[num].type,res.data[num].answer,res.data[num].stu_answer,points[num],num) === 2){
                        html += '<tbody id="tq">+' +
                            '<tr id="infoQuestion">' +
                            '<td name="question_id">' + res.Questions[num].question_id + '</td>' +
                            '<td>' + res.Questions[num].type + '</td>' +
                            '<td>' + res.Questions[num].subject + '</td>' +
                            '<td>' + res.data[num].answer + '</td>' +
                            '<td>' + res.data[num].stu_answer + '</td>' +
                            '<td>' + points[num] + '</td>' +
                            '<td>' + '<input type="number" id="question_point_'+num+'" readonly value="0" name="questionPoint"/>' + '</td>' +
                            '</tr></tbody>';
                    } else {
                        html += '<tbody id="tq">+' +
                            '<tr id="infoQuestion">' +
                            '<td name="question_id">' + res.Questions[num].question_id + '</td>' +
                            '<td>' + res.Questions[num].type + '</td>' +
                            '<td>' + res.Questions[num].subject + '</td>' +
                            '<td>' + res.data[num].answer + '</td>' +
                            '<td>' + res.data[num].stu_answer + '</td>' +
                            '<td>' + points[num] + '</td>' +
                            '<td>' + '<input type="number" id="question_point_'+num+'" oninput="if (value>'+points[num]+') value='+points[num]+'" name="questionPoint"/>' + '</td>' +
                            '</tr></tbody>';
                    }

                }
                $("tr").remove("#infoQuestion");
                $("#StudentId_judgment").append(html);
            }if(res.code === 0) {
                alert("该考生未参加考试!");
            }

        }
    })
}

function checkthis(type,answer,stu_answer,points,point_num) {
    if(type !== "简答题"){
        if(answer === stu_answer){
            return 1;
        }else {
            return 2;
        }
    }else {
        return 3;
    }
}

function updateJudgmentWithStu_id(JudgmentParam) {
    $.ajax({
        url:"/TextPaper/JudgmentTextPaper",
        type:"POST",
        data:{
            TextPaper_id:JudgmentParam.TextPaper_id,
            Stu_id:JudgmentParam.Stu_id,
            question_id:JudgmentParam.question_id,
            ScoreString:JudgmentParam.ScoreString
        },
        dataType:"json",
        success:function (res) {
            console.log(res);
            //insert code
            alert(res.message);
        }
    })
}


function selectExamInfo_testpaperid(test_paper_id) {
    var ExamInfo = "";
    $.ajax({
        url:"/TextPaper/UpDateTextPaper",
        type:"POST",
        async: false,
        data:{
            test_paper_id:test_paper_id
        },
        dataType:"json",
        success:function (res) {
            ExamInfo = res.data;
        }
    });
    return ExamInfo;
}

function updateExamModal(test_paper_id){
    $("#test_paper_id").empty();
    $('#test_paper_id').append(test_paper_id);
    $('#changeModal').modal('toggle');
    get_Paper_name();
    exam = selectExamInfo_testpaperid(test_paper_id);
    $("#test_paper_name").val(exam.test_paper_name);
    $("#Paper_name").find("option[value="+exam.test_paper_id+"]").attr("selected",true);
    $("#test_begin_time").val(new Date(exam.test_begin_time));
    $("#test_end_time").val(new Date(exam.test_end_time));
    $("#test_length").val(exam.test_length);
    $("#passing_mark").val(exam.passing_mark);
    $("#class_id").find("option[value="+exam.class_id+"]").attr("selected",true);
    $("#paper_maker").val(exam.paper_maker);
    $("#testPlacr").val(exam.test_placr);
    $("#invigilation").val(exam.invigilation);

}

// function updateExamInfo(test_paper_id){
//     $.ajax({
//         url:"/TextPaper/UpDateTextPaper",
//         type:"POST",
//         data:{
//             test_paper_id:test_paper_id
//         },
//         dataType:"json",
//         success:function (res) {
//             console.log(res);
//             if (res.code === 1){
//                 $('#changeModal').modal('toggle');
//             }
//             else if (res.code === -1) {
//                 window.location.href="../Login.html"
//             }
//             else {
//                 alert("无法修改该试卷！");
//             }
//         }
//     })
// }

function doUpdateTextPaper(paramUpdate) {
    $.ajax({
        url:"/TextPaper/DoUpDateTextPaper",
        type:"POST",
        data:{
            test_paper_id:paramUpdate.test_paper_id,
            test_paper_name:paramUpdate.test_paper_name,
            paper_id:paramUpdate.paper_id,
            test_begin_time:paramUpdate.test_begin_time,
            test_end_time:paramUpdate.test_end_time,
            test_length:paramUpdate.test_length,
            test_times:paramUpdate.test_times,
            passing_mark:paramUpdate.passing_mark,
            class_id:paramUpdate.class_id,
            paper_maker:paramUpdate.paper_maker,
            test_placr:paramUpdate.test_placr,
            invigilation:paramUpdate.invigilation,
        },
        dataType:"json",
        success:function (res) {
            console.log(res);
            //insert code

            window.location.href="../Exam/mainExam.html";
        }
    })
}



function deleteTextPaper (test_paper_id) {
    var delete_message = "您确定删除该考试信息吗？";
    if (confirm(delete_message) == true){
        $.ajax({
            url:"/TextPaper/DeleteTextPaper",
            type:"POST",
            data:{
                test_paper_id: test_paper_id
            },
            dataType:"json",
            success:function (res) {
                console.log(res);
                //insert code
                if (res.code === 1){
                    alert(res.message);
                    window.location.href="mainExam.html";
                }
            }
        })
    }
}

function get_Exam_State(begin_time,end_time,test_paper_id) {
    if (Date.now() < begin_time){
        return "未发布";
    }
    else if (Date.now() >= begin_time && Date.now() <= end_time ){
        $("#Exam"+test_paper_id).attr('disabled',true);
        return "正在考试";
    }
    else{
        console.log("Exam"+test_paper_id);
        $("#Exam"+test_paper_id).attr('disabled',true);
        return "已结束";
    }

}

function SelectAllPaper() {
    $.ajax({
        url:"/Paper/SelectAllPaper",
        type:"GET",
        dataType:"json",
        success:function (res) {
            if (res.code === -1){
                alert("登录状态过期！请重新登录！");
                window.location.href="../Login.html";
            }
            var html = "";
            if (res.code === 0){
                alert(res.message);
                return null;
            }
            for (var num in res.data) {
                html += '<tr id="info">' +
                    '<td><input type="checkbox" value="'+res.data[num].paper_id+'"></td>' +
                    '<td>' + res.data[num].paper_id + '</td>' +
                    '<td>' + res.data[num].paper_name + '</td>' +
                    '<td>' + res.data[num].paper_category + '</td>' +
                    '<td>' + '<button class="btn btn-success" onclick="updatePaper(' +
                    res.data[num].paper_id+')" id="Exam' +
                    res.data[num].paper_id+'" >修改'+'</button>'+'<span> </span>'+
                    '<button class="btn btn-primary" onclick="deletePaper(' +
                    res.data[num].paper_id+')">删除'+'</button>'+ '</td></tr>';
            }
            $("tr").remove("#info");
            $("#paper").append(html);
        }
    })
}

function updatePaper(paper_id) {
    alert(paper_id);
    window.location.href="../Paper/paper_update.html?paper_id="+paper_id;
}

function SelectPaperById(Paper_id) {
    var Paper="";
    $.ajax({
        url:"/Paper/UpdatePaperInfo",
        type:"POST",
        async: false,
        data:{Paper_id:Paper_id},
        dataType:"json",
        success:function (res) {
            Paper = res.data;
        }
    });
    return Paper;
}

function selectPaperQuestion(paper_questions) {
    var questions = paper_questions.split(",");
    var html=""
    for(questionid in questions){
        console.log(questions[questionid]);
        $.ajax({
            url:"/Question/SelectQuestionById",
            type:"POST",
            async: false,
            data:{Question_id:questions[questionid]},
            dataType:"json",
            success:function (res) {
                html += '<tbody id="tb">'+
                    '<tr id="info" name="info'+res.data.question_id+'">' +
                    '<td><input type="checkbox" value="'+res.data.question_id+'"></td>' +
                    '<td>' + res.data.question_id +'</td>' +
                    '<td>' + res.data.subject + '</td>' +
                    '<td>' + res.data.answer + '</td>' +
                    '<td>' + res.data.category + '</td>' +
                    '<td>' + res.data.type + '</td>' +
                    '<td>' + res.data.degree + '</td>' +
                    '<td>' + res.data.point + '</td>' +
                    '<td>'+'<input type="Number" name="point" id=point oninput="if(value>100)value=100;if(value<0)valu=0" required="required"/> '+'</td>' +
                    '<td>' +
                    '<button class="btn btn-primary" type="button" onclick="removeQuestionInPaper(' +
                    res.data.question_id + ')">删除' + '</button>' + '</td></tr></tbody>';
                $("tr").remove("#info");
                //console.log(res.data);
                $("#paper_questions").append(html);
            }
        });
    }


}

function removeQuestionInPaper(question_id) {
    var delete_message = "您确定删除该试题吗？";
    if (confirm(delete_message) == true){
        $("tr[name='info"+question_id+"']").remove();
    }
}

function updateThePaper(param) {
    $.ajax({
        url:"/Paper/DoUpdatePaperInfo",
        type:"POST",
        data:{
            Paper_id:param.paper_id,
            Paper_name:param.paper_name,
            Paper_category:param.paper_category,
            Paper_questions:param.paper_questions,
            Paper_points:param.question_point
        },
        dataType:"json",
        success:function (res) {
            console.log(res);
            if (res.code === 1){
                alert("修改成功！");
                window.location.href="../Paper/paper_library.html";
            }
            //insert code
        }
    })
}


function deletePaper(paper_id) {
    var delete_message = "您确定删除该试卷吗？";
    if (confirm(delete_message) == true){
        $.ajax({
            url:"/Paper/DeletePaper",
            type:"POST",
            data:{
                Paper_id:paper_id
            },
            dataType:"json",
            success:function (res) {
                console.log(res);
                if (res.code === 1){
                    alert("删除成功!");
                    window.location.href="../Paper/paper_library.html"
                }
            }
        })
    }
}

function SelectAllResults() {
    $.ajax({
        url:"/Results/ShowAllResults",
        type:"GET",
        dataType:"json",
        success:function (res) {
            if (res.code === -1){
                alert("登录状态过期！请重新登录！");
                window.location.href="../Login.html";
            }
            var html = "";
            if (res.code === 0){
                alert(res.message);
                return null;
            }
            for (var num in res.data) {
                html += '<tr id="info">' +
                    '<td><input type="checkbox" value="'+res.data[num].paper_id+'"></td>' +
                    '<td>' + res.data[num].stu_id + '</td>' +
                    '<td>' + res.data[num].stu_name + '</td>' +
                    '<td>' + res.data[num].stu_classid + '</td>' +
                    '<td>' + res.data[num].test_paper_name + '</td>' +
                    '<td>' + res.data[num].disciplinary + '</td>' +
                    '<td>' + res.data[num].results + '</td>' +
                    '/tr>';
            }
            $("tr").remove("#info");
            $("#resultsTable").append(html);
        }
    })
}