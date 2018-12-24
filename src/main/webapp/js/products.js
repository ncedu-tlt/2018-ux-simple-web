document.getElementById('form').onsubmit = function () {
    var productName = document.getElementById('productName').value;

    var categoryElement = document.getElementById('category');
    var categoryName = categoryElement.options[categoryElement.selectedIndex].value;

    var productDescription = document.getElementById('productDescription').value;

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
    document.getElementById('error').style.display = "block";
}

