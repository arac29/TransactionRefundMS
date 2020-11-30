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
    xhr.open("GET", url, true);
    xhr.send();

    /**    get MY requests */
    let xhr1 = new XMLHttpRequest();
    const url = "http://localhost:9094/readReimbursements";
    xhr1.onreadystatechange = function () {
        console.log(xhr1.readyState);
        if (this.readyState == 4 && this.status == 200){
            //console.log(xhr.responseText);
            let reimbursementList = JSON.parse(xhr1.responseText);
            console.log(reimbursementList);
            reimbursementList.forEach(element => {
                let table=document.getElementById("reimbursement-table");
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
    xhr1.open("GET", url, true);
    xhr1.send();


    

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
    function redirect_form(){
        window.location.replace("http://localhost:9094/newRequest");
    }

}