document.getElementsByClassName('form')[0].onsubmit = function () {
    var productName = document.getElementsByClassName('js_productName')[0].value;

    var categoryElement = document.getElementsByClassName('js_category')[0];
    var categoryName = categoryElement.options[categoryElement.selectedIndex].value;

    var productDescription = document.getElementsByClassName('js_productDescription')[0].value;

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
    var errorElement = document.getElementsByClassName('js_error')[0];
    errorElement.classList.remove('_hidden');
}

