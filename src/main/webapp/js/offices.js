var deleteBtnsMas = document.getElementsByClassName('js_button_delete');

for (var i = 0; i < deleteBtnsMas.length; i++) {
    deleteBtnsMas[i].onclick = function () {
        var parent = this.closest('tr');
        var elem = parent.getElementsByClassName('js_id_th')[0];
        var id = elem.innerText;

        var xhr = new XMLHttpRequest();
        xhr.open('DELETE', 'offices/remove?officeId=' + id, true);

        xhr.onload = function () {
            var isSuccess = JSON.parse(xhr.responseText);
            if (isSuccess.isSuccess) {
                parent.remove();
            } else {
                alert('error')
            }
        };
        xhr.send();
    }
}

function isValidName(length) {
    if (length === 0) {
        document.getElementsByClassName('js_error_massage_name')[0].innerHTML = "Enter a value in this field!";
        return false;
    } else if (length > 30) {
        document.getElementsByClassName('js_error_massage_name')[0].innerHTML = "The name is too long. Enter a name of up to 30 characters";
        return false;
    } else {
        document.getElementsByClassName('js_error_massage_name')[0].innerHTML = "";
        return true;
    }
}

function isValidPhoneNumber(phone) {
    if (phone[0] === '+' && phone[1] === '7' && phone[2] === '9' && phone.match(/[0-9]/g).length===11) {
        document.getElementsByClassName('js_error_massage_phone_number')[0].innerHTML = "";
        return true;
    }
    else {
        document.getElementsByClassName('js_error_massage_phone_number')[0].innerHTML = "Wrong number format!";
        return false;
    }
}

function isValidCity(length) {
    if (length === 0) {
        document.getElementsByClassName('js_error_massage_city')[0].innerHTML = "Enter a value in this field!";
        return false;
    } else {
        document.getElementsByClassName('js_error_massage_city')[0].innerHTML = "";
        return true;
    }
}


document.getElementsByClassName('js_input_name')[0].onblur = function () {
    isValidName(this.value.length)
};

document.getElementsByClassName('js_input_phone_number')[0].onblur = function () {
    isValidPhoneNumber(this.value);
};

document.getElementsByClassName('js_select_city')[0].onblur = function () {
    isValidCity(this.value.length)
};


document.getElementsByClassName('js_add_button')[0].onclick = function () {
    var inputNameLength = document.getElementsByClassName('js_input_name')[0].value.length;
    var inputPhoneNumber = document.getElementsByClassName('js_input_phone_number')[0].value;
    var selectCityLength = document.getElementsByClassName('js_select_city')[0].value.length;
    isValidCity(selectCityLength);
    isValidPhoneNumber(inputPhoneNumber);
    isValidName(inputNameLength);
    var isValid = isValidCity(selectCityLength) && isValidPhoneNumber(inputPhoneNumber) && isValidName(inputNameLength);
    if (!isValid) {
        document.getElementsByClassName('js_error_massage')[0].classList.remove('error_message_no_active');
        return false;
    } else {
        return true;
    }
};






