<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<section class="content-margin">
	<h1>Board Detail</h1>
	<div class="content-margin border-box">
		<span>{{board.title}}</span>
	</div>
	<div class="content-margin border-box">
		<span>{{board.content}}</span>
	</div>
	<div class="content-margin button-group inline-center">
		<button type="button" class="button button-lg">Edit</button>
		<button type="button" class="button button-lg">Delete</button>
		<button type="button" class="button button-lg">Back</button>
	</div>
</section>
<section id="comment">
	<h1>Comment</h1>
	<div class="insert-form">
		<textarea></textarea>
		<button>등록</button>
	</div>
	<section id="comment-item">
		<h1>CommentItem</h1>
		<div class="comment">
			<div>{{comment.content}}</div>
			<span>{{comment.writer}} | {{comment.regDate}}</span>
			<button>삭제</button>
		</div>
	</section>
</section>