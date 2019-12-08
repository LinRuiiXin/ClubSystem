var locations = ["index.html", "checkin.html", "task.html", "share.html", "apply.html", "noticlist.html"];
var index = document.getElementById("jump-index");
var checkIn = document.getElementById("jump-checkIn");
var task = document.getElementById("jump-task");
var share = document.getElementById("jump-share");
var apply = document.getElementById("jump-apply");
var notic = document.getElementById("jump-notic");
var logout = document.getElementById("logout");
index.onclick = function() {
    window.location.href = locations[0];
}
checkIn.onclick = function() {
    window.location.href = locations[1];
}
task.onclick = function() {
    window.location.href = locations[2];
}
share.onclick = function() {
    window.location.href = locations[3];
}
apply.onclick = function() {
    window.location.href = locations[4];
}
notic.onclick = function() {
    window.location.href = locations[5];
}
logout.onclick = function() {
    window.location.href = "login.html";
}