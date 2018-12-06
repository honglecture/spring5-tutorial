<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<main id="main" class="content-container">
	<section>
		<h1>main</h1>
		<ul>
			<security:authorize access="!isAuthenticated()">
				<li><a href="member/login">go to login</a></li>
			</security:authorize>
			<security:authorize access="isAuthenticated()">
				<li><a href="member/profile">go to profile</a></li>
			</security:authorize>
			<li><a href="board/list">go to board</a></li>
		</ul>
	</section>
</main>