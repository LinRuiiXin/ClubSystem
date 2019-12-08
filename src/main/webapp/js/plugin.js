function change1(){
	var p = document.getElementById("promptReason");
	p.style.marginTop="-48px";
	p.style.zIndex="1";
}
function change1Back(){
	var p = document.getElementById("promptReason");
	var content = document.getElementById("applyReason").value;
	if(content==null||content==""){
		p.style.marginTop="-30px";
		p.style.zIndex="-1";
	}
}
function change2(){
	var user = document.getElementById("user");
	var p = document.getElementById("userName");
	p.style.opacity="0";
	user.style.opacity="0";
	p.style.visibility="hidden";
	user.style.visibility="hidden";
	p.style.transition="0.3s";
	user.style.transition="0.3s";
	var userInfo = document.getElementById("plugin-userInfo");
	userInfo.style.visibility="visible";
	userInfo.style.opacity="1";
	userInfo.style.marginTop="-40px";
	userInfo.style.transitionDelay="0.4s";
	var infoChange = document.getElementById("plugin-infoChange");
	infoChange.style.visibility="visible";
	infoChange.style.opacity="1";
	infoChange.style.marginTop="1px";
	infoChange.style.transitionDelay="0.5s";
	var back = document.getElementById("plugin-back");
	back.style.visibility="visible";
	back.style.opacity="1";
	back.style.marginTop="1px";
	back.style.transitionDelay="0.5s";
}
function change2Back(){
	var user = document.getElementById("user");
	var p = document.getElementById("userName");
	p.style.opacity="1";
	user.style.opacity="1";
	p.style.visibility="visible";
	user.style.visibility="visible";
	p.style.transitionDelay="0.5s";
	user.style.transitionDelay="0.5s";
	var userInfo = document.getElementById("plugin-userInfo");
	userInfo.style.opacity="0";
	userInfo.style.visibility="hidden";
	userInfo.style.transition="0.3s";
	userInfo.style.transitionDelay="0.3s";
	userInfo.style.marginTop="0";
	var infoChange = document.getElementById("plugin-infoChange");
	infoChange.style.opacity="0";
	infoChange.style.visibility="hidden";
	infoChange.style.transition="0.3s";
	infoChange.style.transitionDelay="0.2s";
	infoChange.style.marginTop="0";
	var back = document.getElementById("plugin-back");
	back.style.opacity="0";
	back.style.visibility="hidden";
	back.style.transition="0.3s";
	back.style.marginTop="0";
}