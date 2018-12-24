function isValidForm() {
    var productName = document.getElementById('productName').value;

    var categoryElement = document.getElementById('category');
    var categoryName = categoryElement.options[categoryElement.selectedIndex].text;

    var productDescription = document.getElementById('productDescription').value;

    var isValid = (productName !== "") && (categoryName !== "") && (productDescription !== "");

    if(!isValid){
        errorInfo("Please, fill up all fields before submitting the form");
        return false;
    }
    else{
        return true;
    }
}

function errorInfo(message){
    var div = document.createElement('div');
    div.className = "form__error";
    div.innerHTML = message;

    var errorElement = document.getElementById('error');
    errorElement.appendChild(div);
}

