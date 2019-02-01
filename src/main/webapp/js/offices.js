function deleteItem(id) {
    // $.ajax({
    //     url: 'offices/remove?officeId=' + id,
    //     type: 'DELETE',
    //     success: function (serverData) {
    //         if (serverData.isSuccess) {
    //             // hideErrorMessage();
    //             document.getElementById("tr"+id).remove();
    //         } else {
    //             // showErrorMessage();
    //         }
    //     }
    //     // error: showErrorMessage
    // });


    var xhr = new XMLHttpRequest();
    xhr.open('DELETE', 'offices/remove?officeId=' + id, true);

    xhr.onload = function () {
        var isSuccess = JSON.parse(xhr.responseText);
        if (isSuccess.isSuccess) {
            document.getElementById("tr" + id).remove();
        } else {
        }
    };

    xhr.send(null);

}