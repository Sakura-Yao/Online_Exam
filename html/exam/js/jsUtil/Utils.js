//程序等待 单位：ms
function sleep(numberMillis) {
    var now = new Date();
    var exitTime = now.getTime() + numberMillis;
    while (true) {
        now = new Date();
        if (now.getTime() > exitTime)
            return;
    }
}

//接收到url后的一个值
function get_oneValues(){
    var result;
    var url=window.location.search; //获取url中"?"符后的字串
    if(url.indexOf("?")!=-1){
        result = url.substr(url.indexOf("=")+1);
    }
    return result;
}

//获取某name的checkbox的值   参数：Name
function get_checkBox_values(checkBox_name) {
    obj = document.getElementsByName(checkBox_name);
    check_val = [];
    for(k in obj){
        if (obj[k].checked)
            check_val.push(obj[k].value);
    }
    return check_val;
}

//时间转换 （时间戳转yy-MM-dd HH:mm:ss）
function format_time(date) {
    var param = {
        r_date:"",
        r_time:""
    };
    var date = new Date(date);
    var YY = date.getFullYear() + '-';
    var MM = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1) + '-';
    var DD = (date.getDate() < 10 ? '0' + (date.getDate()) : date.getDate());
    var hh = (date.getHours() < 10 ? '0' + date.getHours() : date.getHours()) + ':';
    var mm = (date.getMinutes() < 10 ? '0' + date.getMinutes() : date.getMinutes()) + ':';
    var ss = (date.getSeconds() < 10 ? '0' + date.getSeconds() : date.getSeconds());
    param.r_date = YY + MM + DD;
    param.r_time = hh + mm + ss;
    return param;
}