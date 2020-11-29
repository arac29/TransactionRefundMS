window.onload=function(){

    // create a reimbursement class
    class Reimbursement{
        constructor(reimb_id,event_id,date,cancel,amount, status_id, notes, file_id){
        this.reimb_id=reimb_id;
        this.event_id=event_id;
        this.date=date;
        this.cancel=cancel;
        this.amount=amount;
        this.status_id=status_id;
        this.notes=notes;
        this.file_id=file_id;
        }
    }
// ********************* SHOW TABLE WITH REIMBURSEMENTS BY EMPLOYEE ID****/
    let xhr = new XMLHttpRequest();
    const url = "http://localhost:9094/readReimbursements";
    xhr.onreadystatechange = function () {
        console.log(xhr.readyState);
        if (this.readyState == 4 && this.status == 200){
            console.log(xhr.responseText);
            let reimbursementList = JSON.parse(xhr.responseText);

            reimbursementList.forEach(element => {
                let table=document.getElementById("reimbursement-table");
                let tableRow = document.createElement("tr");
                //let employee_id = document.createElement("td");
                submit_date = document.createElement("td");
                amount_requested = document.createElement("td");
                notes = document.createElement("td");
                event_id= document.createElement("td");

                submit_date.innerHTML = element.dateSubmition;
                amount_requested.innerHTML ="$ "+ element.amountRequested;
                notes.innerHTML = element.notes;
                //event_id.innerHTML = element.eventId;

                var reim=new Reimbursement(null,element.eventId,element.dateSubmition,null,element.amountRequested,null,element.notes,null);
                event_id.innerHTML = reim.event_id;
                tableRow.appendChild(submit_date);
                tableRow.appendChild(amount_requested);
                tableRow.appendChild(notes);
                tableRow.appendChild(event_id);
                table.appendChild(tableRow);
           });
        }
    }
    xhr.open("GET", url, true);
    xhr.send();



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



