$(document).ready(function () {
    $("#categoryForm").submit(function (event){

        event.preventDefault();

        let data=$("#categoryForm");
        let name=data.find("#name").val();
        let description=data.find("#description").val();

        console.log(name);
        console.log(description);

        var category={
            name:name,
            description:description
        };

        $.ajax({
           url:"/category/save",
            method:"POST",
            contentType:"application/json",
            data:JSON.stringify(category),
            success:function (){
               alert("successfully saved")
            },
            error:function (xhr,status,error){
               alert("Error saving data:" +error);
            }

        });
    });
});