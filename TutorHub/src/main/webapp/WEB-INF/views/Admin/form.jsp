<%-- 
    Document   : form
    Created on : Jun 11, 2025, 2:56:01 PM
    Author     : qnhat
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Thêm Môn Học Mới</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f5f5f5;
                margin: 0;
                padding: 20px;
            }
            .form-container {
                max-width: 500px;
                margin: 0 auto;
                background: #ffffff;
                padding: 20px;
                border-radius: 8px;
                box-shadow: 0 2px 10px rgba(0,0,0,0.1);
            }
            h2 {
                text-align: center;
                color: #2c3e50;
                margin-bottom: 20px;
            }
            .form-group {
                margin-bottom: 15px;
            }
            label {
                display: block;
                font-weight: bold;
                color: #34495e;
                margin-bottom: 5px;
            }
            input[type="text"], textarea {
                width: 100%;
                padding: 10px;
                border: 1px solid #dcdcdc;
                border-radius: 4px;
                box-sizing: border-box;
                font-size: 14px;
                display: block; /* Ensure visibility */
            }
            textarea {
                height: 100px;
                resize: vertical;
            }
            input[type="submit"] {
                background-color: #3498db;
                color: #ffffff;
                padding: 10px 20px;
                border: none;
                border-radius: 4px;
                cursor: pointer;
                font-size: 16px;
                width: 100;
            }
            input[type="submit"]:hover {
                background-color: #2980b9;
            }
            .error {
                color: #e74c3c;
                font-size: 12px;
                margin-top: 5px;
                display: block;
            }
            .back-link {
                display: block;
                margin-top: 15px;
                color: #3498db;
                text-align: center;
                text-decoration: none;
            }
            .back-link:hover {
                text-decoration: underline;
            }
            .btn-add {
                background-color: #5D87FF;
                border: none;
                padding: 8px 15px;
            }
        </style>
    </head>
    <body>
        <div class="form-container">
            <h2><c:choose> 
                    <c:when test="${subject.subId == 0}">Thêm môn học mới</c:when> 
                    <c:otherwise>Chỉnh sửa môn học</c:otherwise> 
                </c:choose></h2> 
            <!-- Debug: Check if form is rendering -->
            <% if (request.getAttribute("subject") == null) { %>
            <p style="color: red;">Error: 'subject' model attribute is not set!</p>
            <% }%>
            <form:form modelAttribute="subject" 
                       action="${pageContext.request.contextPath}/subject/save" 
                       method="post">
                <div class="form-group">
                    <label for="su_Name">Tên môn học:</label>
                    <form:input path="su_Name" id="su_Name" maxlength="100" placeholder="Nhập tên môn học" />
                    <form:errors path="su_Name" cssClass="error" />
                </div>
                <div class="form-group">
                    <label for="su_Description">Mô tả:</label>
                    <form:textarea path="su_Description" id="su_Description" maxlength="200" placeholder="Nhập mô tả môn học" />
                    <form:errors path="su_Description" cssClass="error" />
                </div>
                <button type="submit" class = "btn btn-add text-white"> Save </button>
            </form:form>
            <a href="${pageContext.request.contextPath}/subject" class="back-link">Quay lại danh sách</a>
        </div>
    </body>
</html>
