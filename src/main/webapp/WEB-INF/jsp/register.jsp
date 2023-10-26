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
                        <form class="pt-3">
                            <div class="form-group">
                                <input type="email" class="form-control form-control-lg" id="inputEmail"
                                       placeholder="이메일 : abc@collectors.co.kr">
                                <input type="button" onclick="" value="이메일 인증">
                            </div>
                            <div class="form-group">
                                <input type="password" class="form-control form-control-lg"
                                       id="inputPassword" placeholder="비밀번호">
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control form-control-lg"
                                       id="inputName" placeholder="이름">
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control form-control-lg"
                                       id="inputPhoneNo" placeholder="휴대폰번호">
                            </div>
                         <%--   부서--%>
                            <label for="department">부서</label>
                            <select name="department" id="department">
                                <option value="">마케팅</option>
                                <option value="">개발</option>
                            </select>





                            <div class="form-check">
                                <label class="form-check-label text-muted">
                                    <input type="checkbox" class="form-check-input">
                                    약관 동의
                                </label>
                            </div>
                            <div class="mt-3">
                                <a class="btn btn-block btn-primary btn-lg font-weight-medium auth-form-btn">회원가입</a>
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
<!-- endinject -->



</body>

<script>


</script>

</html>