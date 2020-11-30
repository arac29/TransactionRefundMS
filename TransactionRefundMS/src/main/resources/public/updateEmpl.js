window.onload = function(){

    let parameters = location.search.substring(1).split("?");
    let param = parameters[0].split("=");

    let eventId = param[1];
    console.log(parameters);

    let xhr = new XMLHttpRequest();
    const url = "http://localhost:9094/readReimbursementById";
    xhr.onreadystatechange = function () {
        console.log(xhr.readyState);
        if (this.readyState == 4 && this.status == 200){
            //console.log(xhr.responseText);
            let reimbursemen = JSON.parse(xhr.responseText);
            console.log(reimbursement);
            reimbursement.forEach(element => {
                plugin_data(element);
            });
        }
        
    }
    xhr.open("GET", url, true);

    xhr.send();

}
