function display(){
    let name="hello-suraj";
    alert(name);
}

const  form =document.getElementById('dataForm');

form.addEventListener('submit',function (event){
    event.preventDefault();

    //access form input values
    const name=document.getElementById('name').value;
    const email =document.getElementById('email').value;
    const phoneNumber =document.getElementById('phoneNumber').value;

    // //prepare data to send to the server
    const formData ={
        name :name,
        email:email,
        phoneNumber:phoneNumber
    }
    //send data using fetch
    fetch('/request-from',{
       method:'POST',
        headers:{
           'content-type':'application/json'
        },
        body:JSON.stringify(formData)//convert data into json
    }).then(response=>response.json()) //parse json response
        .then(data=>{
            console.log('success:',data);
            alert("data submitted successfully")
        })
        .catch(error=>{
            console.log("error:",error);
            alert("Error submitting form")
        })
})