<%--
  Created by IntelliJ IDEA.
  User: 세정아이앤씨
  Date: 2022-08-03
  Time: 오후 4:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>main</title>
    <style id="applicationStylesheet" type="text/css">
        #main {
            position: absolute;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            width: 100%;
            height: 100%;
            background-color: rgba(39,53,72,1);
        }
        #SignInBox {
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            width: 300px;
            height: 300px;
            background-color: rgba(255,255,255);
            border-radius: 3px;
        }

        .inputBox{
            width: 100%;
            height: 25px;
            border: solid 1px #9F9F9F;
            cursor: pointer;
            font-size: 10px;
            box-sizing: border-box;
            padding-left: 2px;
        }

        .inputBox:focus{
            border: solid 1px #9F9F9F;
        }

        .btnSignIn{
            width: 100%;
            height: 25px;
            border: 0;
            cursor: pointer;
            font-size: 10px;
            color: white;
            background-color: rgba(39,53,72,1);
        }

        .contentBox{
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            width: 200px;
        }

    </style>
    <script id="applicationScript" type="text/javascript" src="main.js"></script>
</head>
<body>
<div id="main">
    <div id="SignInBox">
        <div class="contentBox">
            <input type="text" class="inputBox" placeholder="아이디" style="margin-bottom: 15px">
            <input type="text" class="inputBox" placeholder="비밀번호" style="margin-bottom: 15px">
            <button class="btnSignIn">로그인</button>
        </div>
    </div>
</div>
</body>
</html>