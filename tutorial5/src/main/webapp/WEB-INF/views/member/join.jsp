<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<section class="inline-center content-margin">
	<h1>Join</h1>
	<form>
		<div class="content-margin">
			<input type="text" name="id" class="text text-lg" placeholder="ID" />
		</div>
		<div class="content-margin">
			<input name="password" type="password" class="text text-lg"
				placeholder="PASSWORD" />
		</div>
		<div class="content-margin">
			<input name="confirmPassword" type="password" class="text text-lg"
				placeholder="CONFIRM PASSWORD" />
		</div>
		<div class="content-margin">
			<input name="email" type="text" class="text text-lg"
				placeholder="EMAIL" />
		</div>
		<div class="content-margin">
			<input name="nickname" type="text" class="text text-lg"
				placeholder="NICKNAME" />
		</div>
		<div class="content-margin">
			<label>BIRTH </label> <input name="birth" class="text text-nm" type="date" />
		</div>
		<div class="content-margin">
			<label>PROFILE PICTURE </label> <input name="picture" type="file"
				class="hidden">
			<button type="button" class="button button-lg">SELECT</button>
		</div>
		<div>
			<img alt="" src="">
		</div>
		<div class="content-margin button-group">
			<button type="submit" class="button button-lg">SUBMIT</button>
			<button type="button" class="button button-lg">CANCEL</button>
		</div>
	</form>
</section>
