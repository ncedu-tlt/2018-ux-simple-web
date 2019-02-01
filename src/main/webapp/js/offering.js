$('.delete').on('click',function(){

    var productTr = $(this).closest('tr');
    var officeId = productTr.find('.office_id').text();
    var productId = productTr.find('.product_id').text();


    var xhr = new XMLHttpRequest();

    xhr.open('DELETE', 'offerings/remove?productId=' + productId + '&officeId=' + officeId, false);
    xhr.send();

    if (xhr.status != 200) {
        alert( xhr.status + ': ' + xhr.statusText );
    } else {
        alert( xhr.responseText );
    }
    $.ajax({
        url: 'offerings/remove?productId=' + productId,
        type: 'DELETE',
        success: function (serverData) {
            if (serverData.isSuccess) {
                hideErrorMessage();
                productTr.remove();
            } else {
                showErrorMessage();
            }
        },
        error: showErrorMessage,
    });
});