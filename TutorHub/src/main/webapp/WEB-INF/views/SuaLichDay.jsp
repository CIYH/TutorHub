<%-- 
    Document   : Sửa lịch học
    Created on : Jun 11, 2025, 3:13:30 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <title>Edukate - Online Education Website Template</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="Free HTML Templates" name="keywords">
        <meta content="Free HTML Templates" name="description">

        <!-- Favicon -->
        <link href="${pageContext.request.contextPath}/src/img/favicon.ico" rel="icon">

        <!-- Google Web Fonts -->
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Jost:wght@500;600;700&family=Open+Sans:wght@400;600&display=swap" rel="stylesheet"> 

        <!-- Font Awesome -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">

        <!-- Libraries Stylesheet -->
        <link href="${pageContext.request.contextPath}/src/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

        <!-- Customized Bootstrap Stylesheet -->
        <link href="${pageContext.request.contextPath}/src/css/style.css" rel="stylesheet">
        <!-- Lịch -->
        <link href="https://cdn.jsdelivr.net/npm/fullcalendar@6.1.11/index.global.min.css" rel="stylesheet">

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" rel="stylesheet">

        <style>
            #calendar {
                background: #fff;
                padding: 15px;
                border-radius: 5px;
                box-shadow: 0 5px 15px rgba(0,0,0,0.1);
            }
            #modal {
                width: 300px;
                max-width: 100%;
                height: auto;
            }
        </style>
    </head>

    <body>
        <!-- Topbar Start -->
        <div class="container-fluid bg-dark">
            <div class="row py-2 px-lg-5">
                <div class="col-lg-6 text-center text-lg-left mb-2 mb-lg-0">
                    <div class="d-inline-flex align-items-center text-white">
                        <small><i class="fa fa-phone-alt mr-2"></i>+012 345 6789</small>
                        <small class="px-3">|</small>
                        <small><i class="fa fa-envelope mr-2"></i>info@example.com</small>
                    </div>
                </div>
                <div class="col-lg-6 text-center text-lg-right">
                    <div class="d-inline-flex align-items-center">
                        <a class="text-white px-2" href="">
                            <i class="fab fa-facebook-f"></i>
                        </a>
                        <a class="text-white px-2" href="">
                            <i class="fab fa-twitter"></i>
                        </a>
                        <a class="text-white px-2" href="">
                            <i class="fab fa-linkedin-in"></i>
                        </a>
                        <a class="text-white px-2" href="">
                            <i class="fab fa-instagram"></i>
                        </a>
                        <a class="text-white pl-2" href="">
                            <i class="fab fa-youtube"></i>
                        </a>
                    </div>
                </div>
            </div>
        </div>
        <!-- Topbar End -->


        <!-- Navbar Start -->
        <div class="container-fluid p-0">
            <nav class="navbar navbar-expand-lg" style="background-color: #0066cc;">
                <a href="index.jsp" class="navbar-brand d-flex align-items-center text-white">
                    <h1 class="m-0"><i class="fa fa-book me-3"></i>Tutor Online</h1>
                </a>
                <button type="button" class="navbar-toggler text-white" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
                    <div class="navbar-nav mx-auto py-0">
                        <a href="${pageContext.request.contextPath}/" class="nav-item nav-link text-white">Home</a>
                        <div class="nav-item dropdown">
                            <a href="#" class="nav-link dropdown-toggle text-white" data-toggle="dropdown">Lịch dạy</a>
                            <div class="dropdown-menu m-0">
                                <a href="${pageContext.request.contextPath}/about" class="dropdown-item">Xem lịch dạy</a>
                                <a href="${pageContext.request.contextPath}/SuaLichDay" class="dropdown-item">Quản lý lịch dạy</a>
                            </div>
                        </div>
                    </div>
                    <a href="login.jsp" class="btn btn-light text-primary py-2 px-4 d-none d-lg-block">Hồ sơ</a>
                </div>
            </nav>
        </div>
        <!-- Navbar End -->

        <!-- Lịch -->
        <div class="container mt-4">
            <div id="calendar"></div>
        </div>


        <!-- Modal thêm/sửa/xóa sự kiện -->
        <div id="modal" style="display:none; position:fixed; z-index:1000; top:20%; left:30%; background:#fff; padding:20px; border:1px solid #ccc;">
            <h3 id="modal-title"></h3>
            <input type="hidden" id="event-id" />
            <div>
                <label>Tiêu đề:</label>
                <input type="text" id="title" />
            </div>
            <div>
                <label>Mô tả:</label>
                <textarea id="description"></textarea>
            </div>
            <div>
                <label>Bắt đầu:</label>
                <input type="datetime-local" id="start" />
            </div>
            <div>
                <label>Kết thúc:</label>
                <input type="datetime-local" id="end" />
            </div>
            <button id="saveBtn">Lưu</button>
            <button id="deleteBtn">Xóa</button>
            <button id="cancelBtn">Hủy</button>
        </div>

        <!-- Footer Start -->
        <div class="container-fluid position-relative overlay-top bg-dark text-white-50 py-5" style="margin-top: 90px;">
            <div class="container mt-5 pt-5">
                <div class="row">
                    <div class="col-md-6 mb-5">
                        <a href="index.html" class="navbar-brand">
                            <h1 class="mt-n2 text-uppercase text-white"><i class="fa fa-book-reader mr-3"></i>Edukate</h1>
                        </a>
                        <p class="m-0">Accusam nonumy clita sed rebum kasd eirmod elitr. Ipsum ea lorem at et diam est, tempor rebum ipsum sit ea tempor stet et consetetur dolores. Justo stet diam ipsum lorem vero clita diam</p>
                    </div>
                    <div class="col-md-6 mb-5">
                        <h3 class="text-white mb-4">Newsletter</h3>
                        <div class="w-100">
                            <div class="input-group">
                                <input type="text" class="form-control border-light" style="padding: 30px;" placeholder="Your Email Address">
                                <div class="input-group-append">
                                    <button class="btn btn-primary px-4">Sign Up</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-4 mb-5">
                        <h3 class="text-white mb-4">Get In Touch</h3>
                        <p><i class="fa fa-map-marker-alt mr-2"></i>123 Street, New York, USA</p>
                        <p><i class="fa fa-phone-alt mr-2"></i>+012 345 67890</p>
                        <p><i class="fa fa-envelope mr-2"></i>info@example.com</p>
                        <div class="d-flex justify-content-start mt-4">
                            <a class="text-white mr-4" href="#"><i class="fab fa-2x fa-twitter"></i></a>
                            <a class="text-white mr-4" href="#"><i class="fab fa-2x fa-facebook-f"></i></a>
                            <a class="text-white mr-4" href="#"><i class="fab fa-2x fa-linkedin-in"></i></a>
                            <a class="text-white" href="#"><i class="fab fa-2x fa-instagram"></i></a>
                        </div>
                    </div>
                    <div class="col-md-4 mb-5">
                        <h3 class="text-white mb-4">Our Courses</h3>
                        <div class="d-flex flex-column justify-content-start">
                            <a class="text-white-50 mb-2" href="#"><i class="fa fa-angle-right mr-2"></i>Web Design</a>
                            <a class="text-white-50 mb-2" href="#"><i class="fa fa-angle-right mr-2"></i>Apps Design</a>
                            <a class="text-white-50 mb-2" href="#"><i class="fa fa-angle-right mr-2"></i>Marketing</a>
                            <a class="text-white-50 mb-2" href="#"><i class="fa fa-angle-right mr-2"></i>Research</a>
                            <a class="text-white-50" href="#"><i class="fa fa-angle-right mr-2"></i>SEO</a>
                        </div>
                    </div>
                    <div class="col-md-4 mb-5">
                        <h3 class="text-white mb-4">Quick Links</h3>
                        <div class="d-flex flex-column justify-content-start">
                            <a class="text-white-50 mb-2" href="#"><i class="fa fa-angle-right mr-2"></i>Privacy Policy</a>
                            <a class="text-white-50 mb-2" href="#"><i class="fa fa-angle-right mr-2"></i>Terms & Condition</a>
                            <a class="text-white-50 mb-2" href="#"><i class="fa fa-angle-right mr-2"></i>Regular FAQs</a>
                            <a class="text-white-50 mb-2" href="#"><i class="fa fa-angle-right mr-2"></i>Help & Support</a>
                            <a class="text-white-50" href="#"><i class="fa fa-angle-right mr-2"></i>Contact</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="container-fluid bg-dark text-white-50 border-top py-4" style="border-color: rgba(256, 256, 256, .1) !important;">
            <div class="container">
                <div class="row">
                    <div class="col-md-6 text-center text-md-left mb-3 mb-md-0">
                        <p class="m-0">Copyright &copy; <a class="text-white" href="#">Your Site Name</a>. All Rights Reserved.
                        </p>
                    </div>
                    <div class="col-md-6 text-center text-md-right">
                        <p class="m-0">Designed by <a class="text-white" href="https://htmlcodex.com">HTML Codex</a> Distributed by <a href="https://themewagon.com" target="_blank">ThemeWagon</a></a>
                        </p>
                    </div>
                </div>
            </div>
        </div>
        <!-- Footer End -->


        <!-- Back to Top -->
        <a href="#" class="btn btn-lg btn-primary rounded-0 btn-lg-square back-to-top"><i class="fa fa-angle-double-up"></i></a>


        <!-- JavaScript Libraries -->
        <!--        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
                <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>-->
        <script src="${pageContext.request.contextPath}/src/lib/easing/easing.min.js"></script>
        <script src="${pageContext.request.contextPath}/src/lib/waypoints/waypoints.min.js"></script>
        <script src="${pageContext.request.contextPath}/src/lib/counterup/counterup.min.js"></script>
        <script src="${pageContext.request.contextPath}/src/lib/owlcarousel/owl.carousel.min.js"></script>

        <!-- Template Javascript -->
        <script src="${pageContext.request.contextPath}/src/js/main.js"></script>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

        <!-- Lịch -->
        <script src="https://cdn.jsdelivr.net/npm/fullcalendar@6.1.11/index.global.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

        <script>
            document.addEventListener('DOMContentLoaded', function () {
                let calendarEl = document.getElementById('calendar');
                let calendar = new FullCalendar.Calendar(calendarEl, {
                    initialView: 'timeGridWeek', // hiển thị theo tuần
                    selectable: true,
                    editable: true,
                    headerToolbar: {
                        left: 'prev,next today',
                        center: 'title',
                        right: 'timeGridWeek,timeGridDay'
                    },
                    events: [],

                    // Thêm sự kiện mới khi click vào ô trống
                    dateClick: function (info) {
                        openModal('Thêm lịch học', {
                            title: '',
                            description: '',
                            start: info.dateStr.slice(0, 16),
                            end: info.dateStr.slice(0, 16),
                        });
                    },

                    // Sửa hoặc xóa khi click vào sự kiện
                    eventClick: function (info) {
                        const event = info.event;
                        openModal('Sửa lịch học', {
                            id: event.id,
                            title: event.title,
                            description: event.extendedProps.description || '',
                            start: event.startStr.slice(0, 16),
                            end: event.endStr.slice(0, 16),
                        });
                    }
                });

                calendar.render();

                function openModal(titleText, data) {
                    document.getElementById('modal-title').innerText = titleText;
                    document.getElementById('event-id').value = data.id || '';
                    document.getElementById('title').value = data.title;
                    document.getElementById('description').value = data.description;
                    document.getElementById('start').value = data.start;
                    document.getElementById('end').value = data.end;
                    document.getElementById('modal').style.display = 'block';
                }

                // Đóng modal
                document.getElementById('cancelBtn').onclick = function () {
                    document.getElementById('modal').style.display = 'none';
                };

                // Lưu dữ liệu (thêm hoặc cập nhật)
                document.getElementById('saveBtn').onclick = function () {
                    const id = document.getElementById('event-id').value;
                    const title = document.getElementById('title').value;
                    const description = document.getElementById('description').value;
                    const start = document.getElementById('start').value;
                    const end = document.getElementById('end').value;

                    if (id) {
                        // Cập nhật
                        const event = calendar.getEventById(id);
                        if (event) {
                            event.setProp('title', title);
                            event.setExtendedProp('description', description);
                            event.setStart(start);
                            event.setEnd(end);
                        }
                    } else {
                        // Thêm mới
                        const newId = String(Date.now()); // Tạo ID đơn giản
                        calendar.addEvent({
                            id: newId,
                            title: title,
                            start: start,
                            end: end,
                            extendedProps: {
                                description: description
                            }
                        });
                    }

                    document.getElementById('modal').style.display = 'none';
                };

                // Xóa sự kiện
                document.getElementById('deleteBtn').onclick = function () {
                    const id = document.getElementById('event-id').value;
                    const event = calendar.getEventById(id);
                    if (event) {
                        event.remove();
                    }
                    document.getElementById('modal').style.display = 'none';
                };
            });
        </script>
    </body>
</html>
