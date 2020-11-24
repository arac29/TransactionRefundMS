window.onload=function(){

document.getElementById("info").addEventListener("click",function(){
    let x=document.getElementById("submit-info");
    if (x.style.visibility==="hidden") {
        x.style.visibility="visible";
    }
    else{
        x.style.visibility="hidden";
    }
   
});

document.getElementById("status").addEventListener("click",function(){
    let x=document.getElementById("check-status");
    if (x.style.visibility==="hidden") {
        x.style.visibility="visible";
    }
    else{
        x.style.visibility="hidden";
    }
   
});


};
// NEEED TOOOO CHANGE THIS WHEN DEPLOYING TO AZURE
function redirect_form(){
    window.location.replace("http://localhost:9094/newRequest");
}