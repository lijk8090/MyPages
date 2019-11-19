<%@ page language="java" pageEncoding="utf-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>MyPages</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

	<c:url value="css/pagination.css" var="jstlcss"/>
    <link href="${jstlcss}" rel="stylesheet" type="text/css"/>

    <script src="js/jquery.min.js" type="text/javascript"></script>
    <script src="js/pagination.min.js" type="text/javascript"></script>
</head>

<body>
    <h1>MyPages</h1>
    <div>
    <!-- 
		<table>
		    <thead>
		        <tr>
		            <th>UUID</th>
		            <th>账号</th>
		            <th>密码</th>
		        </tr>
		    </thead>
		    <tbody>
		    	<c:set value="${pageEntity.totalNO}" var="totalNO"/>
		        <c:forEach items="${pageEntity.data}" var="userEntity">
		            <tr>
		                <td>${userEntity.uuid}</td>
		                <td>${userEntity.username}</td>
		                <td>${userEntity.password}</td>
		           </tr>
		        </c:forEach>
		    </tbody>
		</table>
	-->
    </div>
    <div id="dataID"></div>
    <div id="pageID"></div>

	<!-- pageNumber : pageNO -->
	<!-- totalNumber : totalNO -->
    <script type="text/javascript">
    	var url = 'getUsers.do?username=operator';

        $('#pageID').pagination({
            dataSource: url,
            locator: 'data',
            totalNumberLocator: function(response) {
                return Math.floor(response.totalNO);
            },
            pageNumber: 1,
            pageSize: 10,
            pageRange: 2,
            showPrevious: true,
            showNext: true,
            showPageNumbers: true,
            showNavigator: true,
            showGoInput: true,
            showGoButton: true,
            showFirstOnEllipsisShow: true,
            showLastOnEllipsisShow: true,
            autoHidePrevious: false,
            autoHideNext: false,
            prevText: '上一页',
            nextText: '下一页',
            goButtonText: '跳转',
            className: 'paginationjs-theme-blue',
            ajax: {
                beforeSend: function() {
                    console.log('Loading ...');
                }
            },
            callback: function(data, pagination) {
                console.log(data);
                console.log(pagination);

                var dataHtml = '<ul>';
                $.each(data, function (index, value) {
                  dataHtml += '<li>' + value.uuid + '-' + value.username + '-' + value.password + '</li>';
                });
                dataHtml += '</ul>';

                $('#dataID').html(dataHtml);
            }
        });
    </script>
</body>
</html>
