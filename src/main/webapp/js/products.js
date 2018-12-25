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

function showErrorMessage(){
    var errorElement = document.querySelector('.js_error');
    errorElement.classList.remove('_hidden');
}

