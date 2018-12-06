window.addEventListener("load", ()=>{

    let joinForm = document.querySelector("#join-form");

    let photoButton = joinForm.querySelector(".photo-button");
    let fileButton = joinForm.querySelector("input[type='file']");
    let image = joinForm.querySelector(".image");

    
	fileButton.onchange = function(e){

		let file = fileButton.files[0];
		
		// 선택한 파일에 대한 조건 제어
		
		console.log(file.type); //image/jpeg
		
		if(file.type.indexOf("image/") < 0){
			alert("이미지가 아닙니다.");
			return;
		}
		
		if(file.size > 1024*1024*10){
			alert("죄송합니다. 10MB를 초과할 수 없습니다.")
			return;
		}
		
		// 브라우저 메모리에 파일이 올라감
		// html5 기능 로컬 이미지 불러들이기
		let reader = new FileReader();
		reader.onload = function(evt){ 
			image.src = evt.target.result; // 여기서 file 들어간다.
		};
		// 다 읽어 왔을 때.. background에서.. 
		reader.readAsDataURL(file);	
		console.log(file);

    };
    
    photoButton.onclick = function(e){
		let event = new MouseEvent("click",{
			"view" : window,
			"bubbles" : true,
			"cancelable" : true
		});
		fileButton.dispatchEvent(event);
	}


});