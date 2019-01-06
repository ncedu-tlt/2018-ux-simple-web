document.querySelector('.js_delete').onclick = function() {
    var productId = document.querySelector(".js_productId").innerHTML;
    var data = {"productId": productId};
    $.ajax({
        type: "POST",
        data: data,
        url: 'products/remove',
        success: function (serverData)
        {
            if(serverData.serverInfo === "success") {
                $('.js_' + productId).remove();
            }
            else{
                showErrorMessage();
            }
        },
        error: function (e)
        {
            showErrorMessage();
        }
    });
};

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




