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

function error(classTag, len) {
    if (len === 0) {
        document.getElementsByClassName(classTag)[0].innerHTML = "Enter a value in this field!";
    } else if (len > 30) {
        document.getElementsByClassName(classTag)[0].innerHTML = "The name is too long. Enter a name of up to 30 characters";
    } else {
        document.getElementsByClassName(classTag)[0].innerHTML = "";
    }
}


document.getElementsByClassName('js_input_name')[0].onblur = function () {
    error('js_error_massage_name', this.value.length);
};

document.getElementsByClassName('js_input_phone_number')[0].onblur = function () {
    error('js_error_massage_phone_number', this.value.length);
};

document.getElementsByClassName('js_select_city')[0].onblur = function () {
    if (this.value.length === 0) {
        document.getElementsByClassName('js_error_massage_city')[0].innerHTML = "Enter a value in this field!";
    }
};


// document.getElementsByClassName('js_error_message')[0].classList.remove('error_message');
console.log(document.getElementsByClassName('js_error_massage'));
console.log(document.getElementsByClassName('js_error_massage')[0]);
// console.log(document.getElementsByClassName('js_error_massage')[0].classList.length);
// console.log(document.getElementsByClassName('js_error_massage')[0].classList.remove('error_message'));
// console.log(document.getElementsByClassName('js_error_massage')[0].classList.length);



document.getElementsByClassName('js_add_button')[0].onsubmit = function () {
    var inputNameLength = document.getElementsByClassName('js_input_name')[0].value.length;
    var inputPhoneNumberLength = document.getElementsByClassName('js_input_phone_number')[0].value.length;
    var selectCityLength = document.getElementsByClassName('js_select_city')[0].value.length;
    var isValid = inputNameLength === 0 && inputNameLength > 30 && inputPhoneNumberLength === 0 && inputPhoneNumberLength > 30 && selectCityLength === 0;
    if (!isValid) {
        document.getElementsByClassName('js_error_massage')[0].classList.remove('error_message');
        return false;
    } else {
        document.getElementsByClassName('js_error_message')[0].classList.add('error_message');
        return true;
    }
};






