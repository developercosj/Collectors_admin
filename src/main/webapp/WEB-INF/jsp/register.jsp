<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">

    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Collectors </title>
    <!-- plugins:css -->
    <link rel="stylesheet" href="resources/template/collectors_css/feather.css">
    <link rel="stylesheet" href="resources/template/collectors_css/materialdesignicons.min.css">
    <link rel="stylesheet" href="resources/template/collectors_css/themify-icons.css">
    <link rel="stylesheet" href="resources/template/collectors_css/typicons.css">
    <link rel="stylesheet" href="resources/template/collectors_css/simple-line-icons.css">
    <link rel="stylesheet" href="resources/template/collectors_css/vendor.bundle.base.css">
    <!-- endinject -->
    <!-- Plugin css for this page -->
    <!-- End plugin css for this page -->
    <!-- inject:css -->
    <link rel="stylesheet" href="resources/template/collectors_css/style.css">
    <link rel="stylesheet" href="resources/template/collectors_css/style-detail.css">
    <!-- endinject -->
    <link rel="shortcut icon" href="resources/template/collectors_image/favicon.png" />
</head>

<body>
<div class="container-scroller">
    <div class="container-fluid page-body-wrapper full-page-wrapper">
        <div class="content-wrapper d-flex align-items-center auth px-0">
            <div class="row w-100 mx-0">
                <div class="col-lg-4 mx-auto">
                    <div class="auth-form-light text-left py-5 px-4 px-sm-5">
                        <div class="brand-logo">
                            <img src="resources/template/collectors_image/collectors_logo.svg" alt="logo">
                        </div>
                        <h2 class="fw-light">Collectors 어드민 회원가입</h2>
                        <form action="./signInAdmin" name="signInForm" method="post" class="pt-3" >
                            <div class="form-group">
                                <input type="text" class="form-control form-control-lg" id="emailAddress" name="email" placeholder="이메일 : abc@collectors.co.kr">
                                <div class="mt-3" >
                                    <input type="button" class="btn btn-warning dropdown-toggle" id="authCodeButton" onclick="checkEmailAddress()" value="인증번호 전송">
                                    <input type="button" class="btn btn-warning dropdown-toggle"  id="confirmCodeButton" onclick="confirmEmail()" value="인증완료">
                                </div>

                            </div>
                            <div class="form-group">
                                <input type="password" class="form-control form-control-lg" id="inputPassword" name="pass" placeholder="비밀번호" oninput="checkPassword()">
                                <span id="passInfo"></span>
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control form-control-lg"
                                       id="inputName" name="name" placeholder="이름">
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control form-control-lg"
                                       id="inputPhoneNo" placeholder="휴대폰번호" oninput="phoneForm()">
                                <input type="hidden" value="" name="phone"  id="phoneNo">
                            </div>
                         <%--   부서--%>
                            <div class="form-group" id="deptDiv">

                            </div>
                            <div class="form-check">
                                <label class="form-check-label text-muted">
                                    <input type="checkbox" id="termsCheck" class="form-check-input">
                                    약관 동의
                                </label>
                            </div>
                            <div class="mt-3">
                                <a class="btn btn-block btn-primary btn-lg font-weight-medium auth-form-btn" onclick="signIn()">회원가입</a>
                            </div>


                            <!-- <div class="mb-2">
                            <button type="button" class="btn btn-block btn-facebook auth-form-btn">
                            <i class="ti-facebook me-2"></i>Connect using facebook
                            </button>
                            </div> -->
                            <div class="text-center mt-4 fw-light">
                                비밀번호가 생각이 안나세요? <a href="register.html" class="text-primary"> 비밀번호 찾기</a>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!-- content-wrapper ends -->
    </div>
    <!-- page-body-wrapper ends -->
</div>
<!-- container-scroller -->
<!-- plugins:js -->
<script src="resources/template/collectors_js/vendor.bundle.base.js"></script>
<!-- endinject -->
<!-- Plugin js for this page -->
<script src="resources/template/collectors_js/bootstrap-datepicker.min.js"></script>
<!-- End plugin js for this page -->
<!-- inject:js -->
<script src="resources/template/collectors_js/off-canvas.js"></script>
<script src="resources/template/collectors_js/hoverable-collapse.js"></script>
<script src="resources/template/collectors_js/template.js"></script>
<script src="resources/template/collectors_js/settings.js"></script>
<script src="resources/template/collectors_js/todolist.js"></script>
<script src="resources/template/collectors_js/jquery.cookie.js"></script>
<!-- endinject -->
<%--<script src="resources/template/collectors_common/common.js"></script>--%>


</body>


<script>
$(document).ready(function() {
    console.log("ready!");

    // 팀부서 관련 리스트 조회
    $.ajax({
        type : "GET",
        url : "/selectDeptList",
        contentType: "application/json; charset=UTF-8",
        dataType: "json",
        success : function (data, status) {
            console.log(data);
            var html = '';
            html += '<label htmlFor="department" style="display:block;">부서</label>';
            html += '<select name="department" id="department">';
            for (var i = 0; i < data.length; i++) {
                html += '<option value="'+ data[i].idx +'">' + data[i].teamName + '</option>';
            }
            html += '</select>'
            $('#deptDiv').html(html);
            

        },
        error : function (status) {
            alert(status + "error!");
        }
    });
});


// 회원가입시 이메일 인증번호 전송
function emailAuth() {
    var data = {"emailAddress" : $('#emailAddress').val()
    };
    $.ajax({
        type : "POST",
        url : "/sendEmailCode",
        contentType: "application/json; charset=UTF-8",
        dataType: "json",
        data : JSON.stringify(data),
        success : function (data, status) {

            $("#authCodeButton").hide();
            $("#confirmCodeButton").show();
            $("#confirmCodeButton").before('<input type="text" id="emailCode" class="form-control" placeholder="인증번호 입력">');

        },
        error : function (status) {
            alert(status + "error!");
        }
    });
}

// 이메일 정규표현식 확인
function checkEmailAddress() {
    let regex = new RegExp('[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]+\.[a-zA-Z]{2,3}$');
    let address = $('#emailAddress').val();
    if (address == '') {
        alert("이메일을 입력해 주세요");
    }
    let testEmails = regex.test(address);
    console.log(testEmails);

    if (testEmails == false) {
        alert("올바른 이메일 형식으로 작성해주세요");
    } else if (testEmails == true) {
        emailAuth();
    }
}


// 이메일 인증 인증번호 확인
function confirmEmail() {
    let code = $('#emailCode').val();
    let address = $('#emailAddress').val();
    var data = {"pass" : code,
                "email" : address
    };
    if (code == '') {
        alert("이메일 코드를 입력해 주세요");
    }

    $.ajax({
        type : "POST",
        url : "/confirmEmailCode",
        contentType: "application/json; charset=UTF-8",
        dataType: "json",
        data : JSON.stringify(data),
        success : function (data, status) {
            alert(data.message);
            $('#confirmCodeButton').hide();
            $('#emailCode').hide();
            $("#emailAddress" ).prop('readonly', true);
            $("#emailAddress").after('<a class="checkIcon" style="float: right;"></a>');
        },
        error : function (status) {
            alert(status + "error!");
        }
    });



}

// 휴대폰 번호 - 하이픈 추가
function phoneForm() {
    let phone = $('#inputPhoneNo').val();
    //phone = '01012345678';
    // 0-9 숫자가 아닐시 공백으로 전환해줌
    phone = phone.replace(/[^0-9]/, '')
    phone = phone.replace(/^(\d{2,3})(\d{3,4})(\d{4})$/, `$1-$2-$3`);
    console.log(phone);
    $('#inputPhoneNo').val(phone);
}

// 비밀번호 형식 체크
function checkPassword() {

    let regex = new RegExp(/^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,15}$/);
    let password = $('#inputPassword').val();
    let testEmails = regex.test(password);
    if (testEmails == false) {
        $('#passInfo').text('8 ~ 15자리의 숫자,영문,특수문자 조합으로 설정해주세요');
        $('#passInfo').attr("style", "float: left")
    } else {
        $('#passInfo').text('사용 가능한 비밀번호 입니다.');
        $('#passInfo').attr("style", "float: right")
    }

}

// 회원가입 최종 버튼 클릭

function signIn() {
    // 약관 체크 검사
    if ($('#termsCheck').is(':checked') == false) {
        alert('약관에 동의해주세요');
        return false;
    }
    // 휴대폰 번호 숫자만 추출

    let phone = $('#inputPhoneNo').val();
    //phone = '01012345678';
    // 0-9 숫자가 아닐시 공백으로 전환해줌
    let hiddenPhone =  phone.replace('-', '');
    $('#phoneNo').val(hiddenPhone);

    document.signInForm.submit();




}






</script>

</html>