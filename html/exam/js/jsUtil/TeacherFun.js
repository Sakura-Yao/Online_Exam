var curWwwPath = window.document.location.href;
var pathname= window.document.location.pathname;
var pos = curWwwPath.indexOf(pathname);
var localhostPath = curWwwPath .substring(0,pos);
/*
$.ajax({
        url:"",
        type:"POST",
        data:{

        },
        dataType:"json",
        success:function (res){

        }
    })
 */

/**
 * 验证提交表单的完整性 (空值：'' /空值：null /未定义：undefined)
 * 显示提示 需要加载相对应的js文件
 * @param obj
 * @returns {boolean}
 */
function check_question_submit(obj){
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
}

/**
 * 检查难度系数是否按照要求输入
 * @param elementId
 */
function check_degree_val(elementId) {
    let val = $('#'+elementId).val();
    let check_num = /^(([1-9][0-9]*)|(([0]\.\d{1,2}|[1-9][0-9]*\.\d{1,2})))$/;
    if (!check_num.test(val)){
        lightyear.loading('show');
        setTimeout(function (){
            lightyear.loading('hide');
            lightyear.notify('数值仅需保留两位小数！请重新填写！','danger',100);
        }, 200);
        $('#'+elementId).val(0.30);
        return false;
    }else if (val < 0.3 || val > 0.9){
        lightyear.loading('show');
        setTimeout(function (){
            lightyear.loading('hide');
            lightyear.notify('难度系数应介于 0.30 ~ 0.90！请重新填写！','danger',100);
        }, 200);
        $('#'+elementId).val(0.30);
        return false;
    } else {
        return true;
    }

}

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

/**
 * 初始化分页插件
 */
function init_pager(totalData){
    $("#pager").empty();
    if (totalData !== 0){
        $("#pager").zPager({
            totalData: totalData,
            pageData: 15,
            btnShow: true,
            ajaxSetData: false
        });
    }
}

/**
 * 获取登录Session
 * @returns {string}
 */
function get_session() {
    let User = "";
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
 * 获取当前教师所教授的全部科目，将其封装到select选择列表
 * @param elementId
 */
function get_teachCourse(elementId){
    var User = get_session();
    $.ajax({
        url:localhostPath+"/api/basic/selectAllTeachCourse",
        type:"POST",
        data:{
            user_Id:User.user_Id,
            cou_Name:"",
            current:"-1",
            length:"-1"
        },
        dataType: "json",
        success:function (res) {
            for (var i = 0; i < res.length; i++) {
                var option = "<option value="+res[i].cou_Id+">"+res[i].cou_Name+"</option>";
                document.getElementById(elementId).innerHTML += option;
            }
        }
    });
}

/**
 *获取当前教师所教授的全部班级，将其封装到select选择列表
 * @param elementId
 */
function get_teachClasses(elementId){
    var User = get_session();
    $.ajax({
        url:localhostPath+"/api/basic/selectAllTeachClasses",
        type:"POST",
        data:{
            user_Id:User.user_Id
        },
        dataType: "json",
        success:function (res) {
            for (var i = 0; i < res.length; i++) {
                var label = "<label class='checkbox-inline'>\n" +
                    "<input type='checkbox' name='class-checkbox' value='"+res[i].class_Id+"'/>\n" +
                    ""+res[i].class_Id+"" +
                    "</label>"
                document.getElementById(elementId).innerHTML += label
            }
        }
    });
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
 * 调用dTree框架，生成知识点树
 * @param cou_Id
 * @returns {dTree}
 */
function get_knowledge(cou_Id){
    var l1 = get_knowledge_level1(cou_Id);
    d = new dTree('d', true);   //参数一: 树名称。参数二：单选多选 true多选  false单选  默认单选
    d.add(0, -1, l1[0].cou_Name);
    for (var i = 0; i < l1.length; i++) {
        d.add(l1[i].id,0,'knowledge',l1[i].id,l1[i].kwl_Name,true,false);
        var l2 = get_knowledge_level2(cou_Id,i+1);
        for (var j = 0; j < l2.length; j++) {
            console.log(l2[j])
            d.add(l2[j].id,l2[j].parent_Id,'knowledge',l2[j].id,l2[j].kwl_Name,false,false);
        }
    }
    // dTree实例属性以此为：  节点ID，父类ID，checkbox的名称，checkbox的值，checkbox的显示名称，
    //checkbox是否被选中--默认是不选，checkbox是否可用：默认是可用，节点链接：默认是虚链接

    // document.write(d);
    // d.openAll();
    return d;
}

/**
 * dTree框架 搜索节点并展开相对应的节点
 */
function nodeSearching() {
    var dosearch = $.trim($("#dosearch_text").val());//获取要查询的文字
    var dtree_div = $("#dtree_div").find(".dtree_node").show().filter(":contains('" + dosearch + "')");//获取所有包含文本的节点
    $.each(dtree_div, function (index, element) {
        var s = $(element).attr("node_id");
        d.openTo(s);//根据id打开节点
    });
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
                html += "<p>"+l2[num_l2].chapter_Num+"."+l2[num_l2].section_Num+"\t"+l2[num_l2].kwl_Name+"</p>"+"\n"
            }
            html+="</div>" +
                "</div>" +
                "</div>"
        }
        $("div").remove("#accordion");
        $("#"+elementId).append(html);
    }
}

/**
 * 获取某个科目的知识点并封装到select
 * @param cou_Id
 * @param elementId
 */
function get_knowledge_select(cou_Id,elementId){
    if (cou_Id !== '0' && cou_Id !== '' && cou_Id !== null){
        let l1 = get_knowledge_level1(cou_Id);
        let html = "<option value=''>请选择所属知识点</option>";
        for (let i = 0; i < l1.length; i++) {
            html += "<optgroup label='第"+(i+1)+"章"+l1[i].kwl_Name+"'></optgroup>"
            let l2 = get_knowledge_level2(cou_Id,i+1);
            for (let j = 0; j < l2.length; j++) {
                html += "<option value='"+l2[j].id+"'>"+l2[j].chapter_Num+"."+l2[j].section_Num+"\t"+l2[j].kwl_Name+"</option>"
            }
        }
        $("#"+elementId).empty();
        $("#"+elementId).append(html);

    }
}

/**
 * 获取教师某个课程所需教授的班级
 * @param cou_Id
 * @returns {string}
 */
function get_teachCourse_classes(cou_Id){
    var res1 = "";
    $.ajax({
        url:localhostPath+"/api/basic/selectTeachClasses_course",
        type:"POST",
        data:{
            cou_Id:cou_Id
        },
        async:false,
        success:function (res){
            res1 = res.toString();
        }
    })
    return res1;
}

/**
 * 获取教师课程信息总条数
 * @param cou_Name
 * @returns {number}
 */
function get_teachCourse_itemsNum(cou_Name){
    let User = get_session();
    let num = 0;
    $.ajax({
        url: localhostPath + "/api/basic/selectAllTeachCourse",
        type: "POST",
        data: {
            user_Id: User.user_Id,
            cou_Name: cou_Name,
            current: "-1",
            length: "-1"
        },
        async:false,
        success:function (res){
            num = res.length;
        }
    })
    return num;
}

/**
 * 获取该教师教授的课程
 * @param cou_Name
 * @param current
 * @param length
 */
function select_teachCourse(cou_Name,current,length){
    var User = get_session();
    $.ajax({
        url:localhostPath+"/api/basic/selectAllTeachCourse",
        type:"POST",
        data:{
            user_Id:User.user_Id,
            cou_Name:cou_Name,
            current:current,
            length:length
        },
        success:function (res){
            var html = "";
            for (var num in res){
                html+= "<tr id='info'><td>"+res[num].cou_Id+"</td>" +
                    "<td>"+res[num].cou_Name+"</td>" +
                    "<td>"+get_teachCourse_classes(res[num].cou_Id)+"</td>" +
                    "<td><a>课程知识点管理</a></td></tr>"
            }
            $("tr").remove("#info");
            $("#teachCourseInfo").append(html);
        }
    });
}

/**
 * 获取全部试题类型并封装
 * @param elementId
 */
function get_question_type(elementId) {
    $.ajax({
        url:localhostPath+"/api/basic/selectQuestionType",
        type:"POST",
        data:{

        },
        dataType:"json",
        success:function (res){
            for (var i = 0; i < res.length; i++) {
                var option = "<option value="+res[i].id+">"+res[i].type_Name+"</option>";
                document.getElementById(elementId).innerHTML += option;
            }
        }
    })
}

/**
 * 获取查询题目信息的总条数
 * @param param
 * @returns {number}
 */
function get_question_info_itemsNum(param){
    let num = 0;
    $.ajax({
        url: localhostPath + "/api/question/showCountNum",
        type: "POST",
        data: {
            question_Id: "",
            cou_Id: param.cou_Id,
            type_Id: param.type_Id,
            subject: param.subject,
            degree: param.degree,
            kwl_Id: param.kwl_Id,
        },
        async:false,
        dataType: "json",
        success: function (res){
            num = res.count;
        }
    })
    return num;
}

/**
 * 获取试题信息并封装
 * @param param
 * @param temp
 */
function get_question_info(param,temp) {
    if (temp === 1){
        lightyear.loading('show');
        setTimeout(function (){
            lightyear.loading('hide');
            lightyear.notify('查询成功！','success',1000);
        },1000);
    }
        $.ajax({
            url: localhostPath + "/api/question/selectQuestionInfo",
            type: "POST",
            data: {
                question_Id: "",
                cou_Id: param.cou_Id,
                type_Id: param.type_Id,
                subject: param.subject,
                degree: param.degree,
                kwl_Id: param.kwl_Id,
                current: param.current,
                length: param.length,
            },
            dataType: "json",
            success: function (res) {
                var html = "";
                for (var num in res.data) {
                    html += "<tr id='info'><td>" + res.data[num].subject + "</td>" +
                        "<td>" + res.data[num].cou_Name + "</td>" +
                        "<td>" + res.data[num].type_Name + "</td>" +
                        "<td>" + res.data[num].kwl_Name + "</td>" +
                        "<td>" + res.data[num].degree + "</td>" +
                        "<td><a onclick=\"updateQuestion('" + res.data[num].id + "');\">修改</a></td></tr>"
                }
                $("tr").remove("#info");
                $("#teachCourseInfo").append(html);
            }
        })
}

/**
 * 添加试题
 * @param param
 */
function add_question_info(param){
    if (check_question_submit(param)){
        $.ajax({
            url:localhostPath+"/api/question/addQuestionInfo",
            type:"POST",
            data:{
                cou_Id:param.cou_Id,
                type_Id:param.type_Id,
                subject:param.subject,
                choice_A:param.choice_a,
                choice_B:param.choice_b,
                choice_C:param.choice_c,
                choice_D:param.choice_d,
                answer:param.answer,
                degree:param.degree,
                kwl_Id:param.kwl_Id,
                analysis:param.analysis,
            },
            async:false,
            dataType:"json",
            success:function (res){
                if (res.code === 1){
                    lightyear.loading('show');
                    setTimeout(function (){
                        setTimeout(function (){
                            window.location.href  = "admin.html";
                        },1000);
                        lightyear.loading('hide');
                        lightyear.notify("试题添加成功！页面即将自动跳转！",'success',1000);
                    }, 1000);

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
 * 将需要更改的试题ID进行url形式传递值
 * 用于在修改试题页面获取需修改试题的ID
 * @param question_Id
 */
function updateQuestion(question_Id){
    window.location.href="question_update.html?question_Id="+question_Id
}

/**
 * 根据url传来的试题ID进行查找试题，并返回查找到的试题结果
 * @param question_Id
 * @returns {{}}
 */
function get_updateQuestionInfo_Val(question_Id){
    let question = {};
    $.ajax({
        url:localhostPath+"/api/question/selectQuestionInfo",
        type:"POST",
        data:{
            question_Id:question_Id,
            cou_Id:"",
            type_Id:"",
            subject:"",
            degree:"",
            kwl_Id:"",
            current:"-1",
            length:"-1",
        },
        async:false,
        dataType:"json",
        success:function (res){
            question = res.data[0];
        }
    })
    return question;
}

/**
 * 修改试题
 * @param param
 */
function update_question(param){
    if (check_question_submit(param)){
        $.ajax({
            url:localhostPath+"/api/question/updateQuestionInfo",
            type:"POST",
            data:{
                Id:param.Id,
                cou_Id:param.cou_Id,
                type_Id:param.type_Id,
                subject:param.subject,
                choice_A:param.choice_a,
                choice_B:param.choice_b,
                choice_C:param.choice_c,
                choice_D:param.choice_d,
                answer:param.answer,
                degree:param.degree,
                kwl_Id:param.kwl_Id,
                analysis:param.analysis,
            },
            async:false,
            dataType:"json",
            success:function (res){
                if (res.code === 1){
                    lightyear.loading('show');
                    setTimeout(function (){
                        lightyear.loading('hide');
                        lightyear.notify(res.message,'success',3000);
                        window.location.href = "admin.html";
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