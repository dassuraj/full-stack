$(document).ready(function () {
    // Attach the submit handler to the form
    $("#authorForm").submit(function (event) {
        event.preventDefault();  // Prevent the form from submitting the traditional way

        // Get the form data inside the submit function
        let formInstance = $("#authorForm");
        let name = formInstance.find("#name").val();
        let bio = formInstance.find("#bio").val();
        let birthDate = formInstance.find("#birthdate").val();

        // Prepare the data object
        var author = {
            name: name,
            bio: bio,
            birthDate: birthDate
        };

        // Send the data via AJAX
        $.ajax({
            url: "/author/save",
            method: "POST",
            contentType: "application/json",
            data: JSON.stringify(author),  // Send the data as JSON
            success: function (response) {
                alert("Successfully data is saved");
            },
            error: function (xhr, status, error) {
                alert("Error saving data: " + error);
            }
        });
    });
});
