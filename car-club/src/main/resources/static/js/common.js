var salt = "a1b2c3d4e5";

function md5Util(pass_word) {
    //md5加密
    var str = salt.charAt(0) + salt.charAt(2) + pass_word + salt.charAt(4) + salt.charAt(6);
    var md5Pass = md5(str);
    return md5Pass;
}


