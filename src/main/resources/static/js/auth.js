const signInBtn = document.getElementById("signIn");
const signUpBtn = document.getElementById("signUp");
const container = document.querySelector(".container");
const signUp = document.querySelector('#sign-up');
const entrance = document.querySelector('#entrance');

signUp.addEventListener('click', saveAtLocalStorage);
entrance.addEventListener('click', saveAtLocalStorage);

function hide(){
	errorMessage.style.display = 'none';
}

signInBtn.addEventListener("click", () => {
	container.classList.remove("right-panel-active");
});

signUpBtn.addEventListener("click", () => {
	container.classList.add("right-panel-active");
});

function saveAtLocalStorage(e){
	e.preventDefault();
	console.log(signUp.innerHTML)
	if(e.target===signUp){

		localStorage.setItem('login',document.querySelector('#email').value)
		document.forms[0].submit()
	}else if(e.target===entrance){

		localStorage.setItem('login',document.querySelector('#em').value)
		document.forms[1].submit()
	}
}
