$(document).ready(function (){
    $("#demo").submit(function (e){
        e.preventDefault();

         let data =$(this).serializeArray();


        let value = {};
        data.forEach(function (item) {
            value[item.name] = item.value;  // Assigning the field names and values to the object
        });

        console.log("Serialized Value: ", value);  //

         $.ajax({
             url:'/person/save',
             method:'POST',
             contentType:'application/x-www-form-urlencoded',
             data: data,
             success:function (response){
                 alert("successfully data is saved");
                 $("#demo")[0].reset();
             },
             error:function (xhr,success,error){
                 alert("error in saving data");
             }
         })

    })
})