$(document).ready(function (){
    $("#bookForm").submit(function (event){
        event.preventDefault();

        var title=$("#title").val();
        var isbn=$("#isbn").val();
        var publicationYear=$("#publicationYear").val();
        var publisher =$("#publisher").val();

        var authors =[];
        $('input[name="authors"]:checked').each(function (){
            authors.push($(this).val());
        });
        var categories =[];
        $('input[name="categories"]:checked').each(function (){
            categories.push($(this).val());
        })

        var book={
            title:title,
            isbn:isbn,
            publicationYear:publicationYear,
            publisher:publisher,
            authors:authors,
            categories:categories
        }

        $.ajax({
            url:"book/save",
            method:"POST",
            contentType:"application/json",
            data:JSON.stringify(book),
            success:function (response){
                alert('Book saved successfully!');
                $('#bookForm')[0].reset();
            },
            error: function(xhr, status, error) {
                alert('An error occurred: ' + error);
            }

        })
    })
})