$(document).ready(function () {
    $("#people").submit(function (event) {
        event.preventDefault();

        let name=$("#name").val();
        let email=$("#email").val();
        let address=$("#address").val();
        let country=$("#country").val();
        let phoneNumber=$("#phoneNumber").val();

        let data={
            name:name,
            email:email,
            address:address,
            country:country,
            phoneNumber:phoneNumber
        }
        console.log(data)
        $.ajax({
            url: '/people/save',
            method: 'POST',
            contentType:'application/json',
            data: JSON.stringify(data),
            success: function (response) {
                console.log("success")
            },
            error: function (xhr, status, error) {
              console.log("error"+error)
            }

        });
    });
});
