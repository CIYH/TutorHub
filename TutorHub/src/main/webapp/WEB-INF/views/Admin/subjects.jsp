<%-- 
    Document   : subjects
    Created on : Jun 10, 2025, 6:59:17 PM
    Author     : qnhat
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<%-- 
    Document   : subjects
    Created on : Jun 10, 2025, 6:59:17 PM
    Author     : qnhat
--%>

<!-- Custom CSS -->
<style>
    .subject-table-container {
        padding: 20px;
        background-color: #fff;
        border-radius: 10px;
        box-shadow: 0 0 10px rgba(0,0,0,0.1);
        margin: 20px;
    }

    .table-header {
        background-color: #5D87FF;
        color: white;
    }

    .table-header th {
        padding: 15px;
        font-weight: 500;
    }

    .btn-add {
        background-color: #5D87FF;
        border: none;
        padding: 8px 15px;
    }

    .btn-add:hover {
        background-color: #4a6fd6;
    }

    .btn-edit {
        background-color: #49BEFF;
        border: none;
        margin-right: 5px;
    }

    .btn-delete {
        background-color: #FA896B;
        border: none;
    }

    .table-responsive {
        margin-top: 20px;
    }

    .page-title {
        font-size: 1.5rem;
        font-weight: 600;
        color: #2A3547;
    }

    .card {
        border: none;
        box-shadow: none;
    }
    .container{
        margin-top: 50px;
    }
</style>

<body>
    <div class="container">
        <div class="card">
            <div class="card-body">
                <div class="subject-table-container">
                    <div class="d-flex justify-content-between align-items-center mb-4">
                        <h4 class="page-title">Danh sách môn học</h4>
                        <!--                        <button type="button" class="btn btn-add text-white">
                                                    <i class="ti ti-plus me-1"></i>Thêm mới
                                                </button>-->
                        <a href ="${pageContext.request.contextPath}/subject/add" class="btn btn-add text-white">
                            <i class="ti ti-plus me-1"></i>Thêm mới
                        </a> 
                    </div>

                    <div class="table-responsive">
                        <table class="table table-striped table-hover">
                            <thead class="table-header">
                                <tr>
                                    <th scope="col">ID</th>
                                    <th scope="col">Tên môn học</th>
                                    <th scope="col">Mô tả</th>
                                    <th scope="col">Hành động</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="subject" items="${subject}">
                                    <tr>
                                        <td>${subject.subId}</td>
                                        <td>${subject.su_Name}</td>
                                        <td>${subject.su_Description}</td>
                                        <td>
                                            <a href ="${pageContext.request.contextPath}/subject/edit/${subject.subId}" class="btn btn-sm btn-edit text-white">
                                                <i class="ti ti-plus me-1"></i>Sửa
                                            </a>
                                            <a href ="${pageContext.request.contextPath}/subject/delete/${subject.subId}" class="btn btn-sm btn-delete text-white">
                                                <i class="ti ti-trash me-1"></i> Xóa
                                            </a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>

<!-- Bootstrap 5 JS and Popper.js (optional, can be moved to header.jsp if already included) -->
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"></script>