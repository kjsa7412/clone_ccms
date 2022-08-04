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
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            width: 100%;
            height: 100%;
            background-color: rgba(39,53,72,1);
        }
        #SignInBox {
            width: 500px;
            height: 500px;
        }
        #bg_SignInBox {
            fill: rgba(255,255,255,1);
            stroke: rgba(112,112,112,1);
            stroke-width: 1px;
            stroke-linejoin: miter;
            stroke-linecap: butt;
            stroke-miterlimit: 4;
            shape-rendering: auto;
        }
        .bg_SignInBox {
            width: 500px;
            height: 500px;
        }
        #inputbox_password {
            fill: rgba(255,255,255,1);
            stroke: rgba(112,112,112,1);
            stroke-width: 1px;
            stroke-linejoin: miter;
            stroke-linecap: butt;
            stroke-miterlimit: 4;
            shape-rendering: auto;
        }
        .inputbox_password {
            position: absolute;
            overflow: visible;
            width: 300px;
            height: 50px;
            left: 100px;
            top: 345px;
        }
        #inputbox_name {
            fill: rgba(255,255,255,1);
            stroke: rgba(112,112,112,1);
            stroke-width: 1px;
            stroke-linejoin: miter;
            stroke-linecap: butt;
            stroke-miterlimit: 4;
            shape-rendering: auto;
        }
        .inputbox_name {
            position: absolute;
            overflow: visible;
            width: 300px;
            height: 50px;
            left: 100px;
            top: 280px;
        }
        #gb_signIn {
            position: absolute;
            width: 300px;
            height: 50px;
            left: 100px;
            top: 410px;
            overflow: visible;
        }
        #bg_signIn {
            fill: rgba(89,160,255,1);
        }
        .bg_signIn {
            position: absolute;
            overflow: visible;
            width: 300px;
            height: 50px;
            left: 0px;
            top: 0px;
        }
        #txt_signIn {
            left: 115px;
            top: 12px;
            position: absolute;
            overflow: visible;
            width: 71px;
            white-space: nowrap;
            text-align: left;
            font-family: Arial;
            font-style: normal;
            font-weight: bold;
            font-size: 21px;
            color: rgba(255,255,255,1);
        }
        .button{
            cursor: pointer;
        }
    </style>
</head>
<body>
<div id="main">
    <div id="SignInBox">
        <svg class="bg_SignInBox">
            <rect id="bg_SignInBox" rx="43" ry="43" x="0" y="0" width="500" height="500">
            </rect>
        </svg>
        <svg class="inputbox_password">
            <rect id="inputbox_password" rx="0" ry="0" x="0" y="0" width="300" height="50">
            </rect>
        </svg>
        <svg class="inputbox_name">
            <rect id="inputbox_name" rx="0" ry="0" x="0" y="0" width="300" height="50">
            </rect>
        </svg>
        <button class="button">
        <div id="gb_signIn">
            <svg class="bg_signIn">
                <rect id="bg_signIn" rx="10" ry="10" x="0" y="0" width="300" height="50">
                </rect>
            </svg>
            <div id="txt_signIn">
                <span>Sign In</span>
            </div>
        </div>
        </button>
    </div>
</div>
</body>
</html>