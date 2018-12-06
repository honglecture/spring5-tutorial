<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript" src="/resources/js/member/profile.js"></script>	
<section id="profile-section" class="content-margin">
	<h1 class="inline-center">Profile</h1>
	<div class="content-margin border-box">
		<span>ID : ${member.id }</span>
	</div>
	<div class="content-margin border-box">
		<span>EMAIL : ${member.email }</span>
	</div>
	<div class="content-margin border-box">
		<span>NICKNAME : ${member.nickname }</span>
	</div>
	<div class="content-margin border-box">
		<span>REGDATE : ${member.regDate }</span>
	</div>
	<div class="content-margin border-box">
		<span>PHOTO : </span> <img src="/resources/members/${member.id }/${member.photo}" />
	</div>
	<div class="content-margin inline-center button-group">
		<button type="button" class="button button-lg cancel-button">CANCEL</button>
		<button type="button" class="button button-lg logout-button">LOGOUT</button>
	</div>
</section>