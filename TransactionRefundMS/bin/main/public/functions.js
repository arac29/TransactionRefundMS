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
// ********************* SHOW TABLE WITH REIMBURSEMENTS BY EMPLOYEE ID****/
function getRequestById(){
    //create table in DIV
    let div=document.getElementById("reimbursement-table");
    let table= document.createElement("table");
    table.className="table";
    table.id="reimbursement-table";
    //let trow1=document.createElement("th"); //employee id
    let trow2=document.createElement("th"); // sumbit date
    let trow3=document.createElement("th"); // amount requested
    let trow4=document.createElement("th"); // notes
    let trow5=document.createElement("th"); //event_id
    div.appendChild(table);
    //trow1.innerHTML="Employee ID"
    trow2.innerHTML="Submit Date";
    trow3.innerHTML="amount requested";
    trow4.innerHTML="notes";
    trow5.innerHTML="event_id";
    //table.appendChild (trow1);
    table.appendChild (trow2);
    table.appendChild (trow3);
    table.appendChild (trow4);
    table.appendChild (trow5);
    

    let xhr = new XMLHttpRequest();
    const url = "http://localhost:9094/readReimbursements";
    xhr.onreadystatechange = function () {
        console.log(xhr.readyState);
        if (this.readyState == 4 && this.status == 200){
            console.log(xhr.responseText);
            let reimbursementList = JSON.parse(xhr.responseText);
            //console.log(reimbursementList);
            //console.log(reimbursementList[0]);
            reimbursementList.forEach(element => {
                //let table= document.getElementById("reimbursement-table");
                let tableRow = document.createElement("tr");
                //let employee_id = document.createElement("td");
                let submit_date = document.createElement("td");
                let amount_requested = document.createElement("td");
                let notes = document.createElement("td");
                let event_id= document.createElement("td");

                //employee_id.innerHTML = myObj.employeeId;
                submit_date.innerHTML = element.dateSubmition;
                amount_requested.innerHTML = element.amountRequested;
                notes.innerHTML = element.notes;
                event_id.innerHTML = element.eventId;

                //tableRow.appendChild(employee_id);
                tableRow.appendChild(submit_date);
                tableRow.appendChild(amount_requested);
                tableRow.appendChild(notes);
                tableRow.appendChild(event_id);
                table.appendChild(tableRow);



            //addRow(element);
           });
        }
    }
    xhr.open("GET", url, true);
    xhr.send();
}
let addRow=function (myObj){
    let table= document.getElementById("reimbursement-table");
    let tableRow = document.createElement("tr");
    //let employee_id = document.createElement("td");
    let submit_date = document.createElement("td");
    let amount_requested = document.createElement("td");
    let notes = document.createElement("td");
    let event_id= document.createElement("td");



    //employee_id.innerHTML = myObj.employeeId;
    submit_date.innerHTML = myObj.dateSubmition;
    amount_requested.innerHTML = myObj.amountRequested;
    notes.innerHTML = myObj.notes;
    event_id.innerHTML = myObj.eventId;

    //tableRow.appendChild(employee_id);
    tableRow.appendChild(submit_date);
    tableRow.appendChild(amount_requested);
    tableRow.appendChild(notes);
    tableRow.appendChild(event_id);
    table.appendChild(tableRow);
}

