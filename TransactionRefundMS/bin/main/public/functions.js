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
        let xhr = new XMLHttpRequest();
        const url = "http://localhost:9094/readReimbursementStatus";
        xhr.onreadystatechange = function () {
            console.log(xhr.readyState);
            if (this.readyState == 4 && this.status == 200){

            console.log(xhr.responseText);
            //let guestList = JSON.parse(xhr.responseText);
            
            //console.log(guestList[0]);
            }
        }
        xhr.open("GET", url, true);
        xhr.send();
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