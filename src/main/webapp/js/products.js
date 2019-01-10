$('.js_delete').on('click',function(){
    var productId = $(this).closest('tr').find('.js_productId').text();

    $.ajax({
        url: 'products/remove?productId=' + productId,
        type: 'DELETE',
        success: function (serverData) {
            if (serverData.serverInfo === "success") {
                $('.js_product' + productId).remove();
            } else {
                showErrorMessage();
            }
        },
        error: showErrorMessage,
    });
});


function showErrorMessage(){
    var errorElement = document.querySelector('.js_error');
    errorElement.classList.remove('_hidden');
}

document.querySelector('.form').onsubmit = function () {
    var productName = document.querySelector('.js_productName').value;

    var categoryElement = document.querySelector('.js_category');
    var categoryName = categoryElement.options[categoryElement.selectedIndex].value;

    var productDescription = document.querySelector('.js_productDescription').value;

    var isValid = productName && categoryName && productDescription;
    if(!isValid){
        showErrorMessage();
        return false;
    }
    else{
        return true;
    }
};




