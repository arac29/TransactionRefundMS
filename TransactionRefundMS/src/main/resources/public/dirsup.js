window.onload = function(){
/**GET OTHER EMPL REQUESTS */
    let xhr = new XMLHttpRequest();
    const url = "http://localhost:9094/reimbursementsReportsTo";
    xhr.onreadystatechange = function () {
        console.log(xhr.readyState);
        if (this.readyState == 4 && this.status == 200){
            //console.log(xhr.responseText);
            let reimbursementList = JSON.parse(xhr.responseText);
            console.log(reimbursementList);
            reimbursementList.forEach(element => {
                let table=document.getElementById("other-reimbursement");
                let tableRow = document.createElement("tr");
                let employeeId = document.createElement("td");
                let submit_date = document.createElement("td");
                let amount_requested = document.createElement("td");
                let notes = document.createElement("td");
                let add_notes=document.createElement("td");
                let dirsup=document.createElement("td");
                let dehead=document.createElement("td");
                let benco=document.createElement("td");
                let reimbursementStatusId= document.createElement("td");
                let uploads= document.createElement("td");

                //employeeId.innerHTML=element.employeeId;
                let id_link= document.createElement("a");
                gradelink.href="employee-info.html/"+"?employeeId="+element.employeeId;
                

                submit_date.innerHTML = element.dateSubmition;
                amount_requested.innerHTML ="$ "+ element.amountRequested;
                notes.innerHTML = element.notes;
                dirsup.innerHTML=element.directorSupervisorApprovalDate;
                dehead.innerHTML=element.departmentHeadApprovalDate;
                benco.innerHTML=element.benCoApprovalDate;
                /*hard code status*/
                let status=check_status(element.reimbursementStatusId);
                reimbursementStatusId.innerHTML=status;
                uploads.innerHTML=element.updateFileId;

                employeeId.appendChild(id_link);
                tableRow.appendChild(employeeId);
                tableRow.appendChild(submit_date);
                tableRow.appendChild(amount_requested);
                tableRow.appendChild(notes);
                tableRow.appendChild(dirsup);
                tableRow.appendChild(dehead);
                tableRow.appendChild(benco);
                tableRow.appendChild(reimbursementStatusId);
                tableRow.appendChild(uploads);
                tableRow.appendChild(add_notes);
                table.appendChild(tableRow);


                /********************* */
                let noteForm = document.createElement("form");
                noteForm.action = "request-information.html";
                let inputx = document.createElement("input");
                let inputy = document.createElement("input");

                inputx.type = "hidden";
                inputx.name = "reimbursementId";
                inputx.value = element.reimbursementId;

                inputy.type = "submit";
                inputy.className="btn btn-success";
                inputy.value = "Add note";

                noteForm.appendChild(inputx);
                noteForm.appendChild(inputy);

                // gradeCol.appendChild(addGrade);
                add_notes.appendChild(noteForm);
           });
        }
    }
    xhr.open("GET", url, true);
    xhr.send();

    /**    get MY requests */
    let xhr1 = new XMLHttpRequest();
    const url1 = "http://localhost:9094/readReimbursements";
    xhr1.onreadystatechange = function () {
        console.log(xhr1.readyState);
        if (this.readyState == 4 && this.status == 200){
            //console.log(xhr.responseText);
            let reimbursementList = JSON.parse(xhr1.responseText);
            console.log(reimbursementList);
            reimbursementList.forEach(element => {
                let table=document.getElementById("my-reimbursement");
                let tableRow = document.createElement("tr");
                let submit_date = document.createElement("td");
                let amount_requested = document.createElement("td");
                let notes = document.createElement("td");
                let reimbursementStatusId= document.createElement("td");
                let uploads= document.createElement("td");

                let removeCol = document.createElement("td");
                let updateCol = document.createElement("td");

                submit_date.innerHTML = element.dateSubmition;
                amount_requested.innerHTML ="$ "+ element.amountRequested;
                notes.innerHTML = element.notes;
                /*hard code status*/
                let status=check_status(element.reimbursementStatusId);
                reimbursementStatusId.innerHTML=status;
                uploads.innerHTML=element.updateFileId;

                tableRow.appendChild(submit_date);
                tableRow.appendChild(amount_requested);
                tableRow.appendChild(notes);
                tableRow.appendChild(reimbursementStatusId);
                tableRow.appendChild(uploads);
                tableRow.appendChild(removeCol);
                tableRow.appendChild(updateCol);
                table.appendChild(tableRow);


                let removeForm = document.createElement("form");
                removeForm.action = "http://localhost:9094/cancelReimbursement" ;
                removeForm.method = "DELETE";
                input1 = document.createElement("input");
                input2 = document.createElement("input");
                input1.type = "hidden";
                input1.name = "reimbursementId";
                input1.value = element.reimbursementId;

                input2.type = "submit";
                input2.className="btn btn-dark";
                input2.value = "Delete";
                removeForm.appendChild(input1);
                removeForm.appendChild(input2);

                /********************* */
                let updateForm = document.createElement("form");
                updateForm.action = "updateReimbursement.html";
                let inputx = document.createElement("input");
                let inputy = document.createElement("input");

                inputx.type = "hidden";
                inputx.name = "eventId";
                inputx.value = element.reimbursementId;

                inputy.type = "submit";
                inputy.className="btn btn-info";
                inputy.value = "Update";

                updateForm.appendChild(inputx);
                updateForm.appendChild(inputy);

                // gradeCol.appendChild(addGrade);
                removeCol.appendChild(removeForm);
                updateCol.appendChild(updateForm);
           });
        }
    }
    xhr1.open("GET", url1, true);
    xhr1.send();

    let xhr2 = new XMLHttpRequest();
    const url2 = "http://localhost:9094/readEvents";
    xhr2.onreadystatechange = function () {
        console.log(xhr2.readyState);
        if (this.readyState == 4 && this.status == 200){
            //console.log(xhr1.responseText);
            let eventList = JSON.parse(xhr2.responseText);
            console.log(eventList);
            eventList.forEach(element => {
                let table=document.getElementById("event-table");
                let tableRow = document.createElement("tr");
                let nameCol = document.createElement("td");
                let StartDate = document.createElement("td");
                let location= document.createElement("td");
                let gradeId= document.createElement("td");
                let description=document.createElement("td");
                let updateCol = document.createElement("td");

                let grade=check_grade(element.gradeId);
                
                nameCol.innerHTML = element.name;
                StartDate.innerHTML = element.startDate + " - "+ element.endDate;
                location.innerHTML = element.location;
                gradeId.innerHTML =grade;
                description.innerHTML=element.description;

                tableRow.appendChild(nameCol);
                tableRow.appendChild(StartDate);
                tableRow.appendChild(location);
                tableRow.appendChild(gradeId);
                tableRow.appendChild(updateCol);
                tableRow.appendChild(description);
                table.appendChild(tableRow);

                let updateForm = document.createElement("form");
                updateForm.action = "updateEvent.html";
                let inputx = document.createElement("input");
                let inputy = document.createElement("input");

                inputx.type = "hidden";
                inputx.name = "eventId";
                inputx.value = element.eventId;

                inputy.type = "submit";
                inputy.className="btn btn-info";
                inputy.value = "Update";

                updateForm.appendChild(inputx);
                updateForm.appendChild(inputy);
                updateCol.appendChild(updateForm);
           });
        }
    }
    xhr2.open("GET", url2, true);
    xhr2.send();
    

    document.getElementById("my").addEventListener("click",function(){
        let x=document.getElementById("other-requests");
        if (x.style.visibility==="hidden") {
            x.style.visibility="visible";
        }
        else{
            x.style.visibility="hidden";
        }
    });
    document.getElementById("review").addEventListener("click",function(){
        let x=document.getElementById("my-requests");
        if (x.style.visibility==="hidden") {
            x.style.visibility="visible";
        }
        else{
            x.style.visibility="hidden";
        }
    });


    function check_status(status){
        switch (status) {
        case 1:
            return "Pending";
        case 2:
            return "Grade Pending";
        case 3:
            return "Approval Pending";
        case 4:
            return "Awarded";
        case 5:
            return "Cancelled";
        case 6:
            return "Urgent";
        case 7:
            return "Denied";
        }
    }
    function check_grade(grade){
        switch(grade){
        case 0:
            return "None";
        case 1:
            return "A";
        case 2:
            return "B";
        case 3:
            return "C";
        case 4:
            return "D";
            case 5:
            return "F";
        }
    }
    

}
function redirect_form(){
    window.location.replace("http://localhost:9094/newRequest");
}