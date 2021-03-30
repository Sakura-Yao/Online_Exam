let curWwwPath = window.document.location.href;
let pathname= window.document.location.pathname;
let pos = curWwwPath.indexOf(pathname);
let localhostPath = curWwwPath .substring(0,pos);

/**
 * 获取url请求中的一个字段值
 * @returns {Object}
 * @constructor
 */
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

function get_student_courses(){
    let student_courses = [];
    $.ajax({
        url:localhostPath+"/api/study/getStudentCourses",
        type:"POST",
        data:{

        },
        dataType:"json",
        async:false,
        success:function (res){
            student_courses = res.data
        }
    })
    return student_courses;
}

function set_student_courses_element(elementId){
    let student_courses = get_student_courses();
    let html = "";
    for (let i = 0; i < student_courses.length; i++) {
        html += "<div class=\"col-sm-6 col-lg-3\">\n" +
            "            <div class=\"card\">\n" +
            "              <div class=\"card-header bg-primary\">\n" +
            "                <h4 id="+student_courses[i].cou_Id+">"+student_courses[i].cou_Name+"</h4>\n" +
            "                <ul class=\"card-actions\">\n" +
            "                  <li>\n" +
            "                    <button type=\"button\"><i class=\"mdi mdi-more\"></i></button>\n" +
            "                  </li>\n" +
            "                </ul>\n" +
            "              </div>\n" +
            "              <div class=\"card-body\">\n" +
            "                  <a class=\"masonry-item\" href=\"knowledge_student.html?course_id="+student_courses[i].cou_Id+"\">\n" +
            "                      <img name=\"class_img\" src=\"../images/gallery/1.jpg\" alt=\"class_name\" style=\"width: 100%;height: 100%;\">\n" +
            "                  </a>\n" +
            "                  <footer>教师 <cite title=\"text\">"+student_courses[i].user_Name+"</cite></footer>\n" +
            "              </div>\n" +
            "            </div>\n" +
            "          </div>"
    }
    $("#"+elementId).empty()
    $("#"+elementId).append(html);
}

/**
 * 内部调用方法，获取1级知识点
 * @param cou_Id
 * @returns {[]}
 */
function get_knowledge_level1(cou_Id){
    var level1 = [];
    $.ajax({
        url:localhostPath+"/api/basic/selectKnowledge",
        type:"POST",
        async:false,
        data:{
            cou_Id:cou_Id,
            kwl_Level:1,
            chapter_Num:""
        },
        dataType: "json",
        success:function (res) {
            level1 = res;
        }
    });
    return level1;
}

/**
 * 内部调用方法，获取2级知识点
 * @param cou_Id
 * @param chapter_Num
 * @returns {[]}
 */
function get_knowledge_level2(cou_Id,chapter_Num){
    var level2 = [];
    $.ajax({
        url:localhostPath+"/api/basic/selectKnowledge",
        type:"POST",
        async:false,
        data:{
            cou_Id:cou_Id,
            kwl_Level:2,
            chapter_Num:chapter_Num
        },
        dataType: "json",
        success:function (res) {
            level2 = res;
        }
    });
    return level2;
}

/**
 * 获取某个科目的知识点信息并封装
 * 对应页面：课程管理-课程知识点管理
 * @param cou_Id
 * @param elementId
 */
function get_course_knowledge(cou_Id,elementId) {
    var panel = ["panel panel-dark","panel panel-cyan","panel panel-danger","panel panel-success","panel panel-info","panel panel-warning","panel panel-pink","panel panel-purple"];
    if (cou_Id !== '0' && cou_Id !== '' && cou_Id !== null){
        var l1 = get_knowledge_level1(cou_Id);
        var html = "";
        for (let num = 0; num < l1.length; num++) {
            html +="<div class=\"panel-group\" id=\"accordion\" role=\"tablist\" aria-multiselectable=\"true\">\n"+
                "<div class='"+panel[num%panel.length]+"'>" +
                "<div class=\"panel-heading\" role=\"tab\" id='heading"+num+"'>" +
                "<h4 class=\"panel-title\">" +
                "<a role=\"button\" data-toggle=\"collapse\" data-parent=\"#accordion\" href='#collapse"+num+"' aria-expanded=\"false\" aria-controls='collapse"+num+"' class=\"collapsed\">\n" +
                "第 "+(num+1)+" 章 "+l1[num].kwl_Name+
                "</a></h4></div>" +
                "<div id='collapse"+num+"' class=\"panel-collapse collapse\" role=\"tabpanel\" aria-labelledby='heading"+num+"' aria-expanded=\"false\" style=\"height: 0px;\">" +
                "<div class=\"panel-body\" id='kwl"+num+"'>"
            var l2 = get_knowledge_level2(cou_Id,num+1);
            for (var num_l2 = 0; num_l2 < l2.length; num_l2++) {
                html += "<a href=\"practice_questions.html?kwl_id="+l2[num_l2].id+"\">"+l2[num_l2].chapter_Num+"."+l2[num_l2].section_Num+"\t"+l2[num_l2].kwl_Name+"</a>"+"<br>"
            }
            html+="</div>" +
                "</div>" +
                "</div>"
        }
        $("div").remove("#accordion");
        $("#"+elementId).append(html);
    }
}

function get_knowledge_questions(kwl_Id){
    let questions = [];
    $.ajax({
        url: localhostPath + "/api/question/selectQuestionInfo",
        type: "POST",
        data: {
            question_Id: "",
            cou_Id: "",
            type_Id: "",
            subject: "",
            degree: "",
            kwl_Id: kwl_Id,
            current: "-1",
            length: "-1",
        },
        async:false,
        dataType: "json",
        success: function (res){
            questions = res.data
        }
    })
    return questions;
}

function set_knowledge_questions_element(kwl_Id,elementId){
    console.log(get_knowledge_questions(kwl_Id));
    let questions = get_knowledge_questions(kwl_Id);
    let html = "";
    for (let i = 0; i < questions.length; i++) {
        html += "<div class='card'>" +
            "<div class='card-header'>" +
			"<div class='col-sm-9'  id='"+questions[i].id+"'>" +
            "<h3><strong>"+questions[i].subject+"</strong></h3></div>" +
            "<h4 class='col-sm-3 text-right' >题目类型：<mark><em>"+questions[i].type_Name+"</em></mark></h4>" +
            "</div>" +
            "<div class='card-body'> " ;
        if(questions[i].type_Id == "1f45bd0005c541b998731546b3b8909a"){
            html += "<div class='example-box'> " +
                "<label class='lyear-radio radio-inline radio-primary'><input type='radio' name='e'> " +
                "<span>A"+questions[i].choice_A+"</span></label>" +
                "<label class='lyear-radio radio-inline radio-primary'><input type='radio' name='e'> " +
                "<span>B"+questions[i].choice_B+"</span></label>" +
                "<label class='lyear-radio radio-inline radio-primary'><input type='radio' name='e'> " +
                "<span>C"+questions[i].choice_C+"</span></label>" +
                "<label class='lyear-radio radio-inline radio-primary'><input type='radio' name='e'> " +
                "<span>D"+questions[i].choice_D+"</span></label>" +
                "</div>" ;
        }
        html += "<p>参考答案："+questions[i].answer+"</p>" +
            "<p>参考解析："+questions[i].analysis+"</p>" +
            "<p>所属科目："+questions[i].cou_Name+"</p>" +
            "<p>所属知识点："+questions[i].kwl_Name+"</p>" +
            "</div></div>" ;
    }
    $("#"+elementId).empty();
    $("#"+elementId).html(html);
}