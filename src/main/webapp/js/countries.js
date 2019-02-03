function showErrorMessage(container, message, duration) {

    container.innerText = message;

    setTimeout(function () {
        container.innerText = '';
    }, duration)
}

function inputsValidation(name, phoneExtension, flag, errorContainer){

    var COUNTRY_REGEX = /[0-9]/;
    var PHONE_REGEX = /^\+\d+/;
    var FLAG_URL_REGEX = /^https?:+/;

    var MESSAGE_DURATION = 3000;

    if (name.length === 0 || phoneExtension.length === 0 || flag.length === 0) {
        showErrorMessage(errorContainer, 'fill in all fields', MESSAGE_DURATION);
        return false;
    }

    var isNumber = COUNTRY_REGEX.test(name);

    if (isNumber) {
        showErrorMessage(errorContainer, 'Country name must not contain numbers', MESSAGE_DURATION);
        return false;
    }

    var isPhoneNumber = PHONE_REGEX.test(phoneExtension);

    if (!isPhoneNumber) {
        showErrorMessage(errorContainer, 'Incorrect phone number', MESSAGE_DURATION);
        return false;
    }

    var isUrl = FLAG_URL_REGEX.test(flag);

    if (!isUrl) {
        showErrorMessage(errorContainer, 'Incorrect link to flag image', MESSAGE_DURATION);
        return false;
    }

    return true;
}

var forms = document.querySelectorAll('form');

forms.forEach(function (form, index) {

    form.onsubmit = function () {

        var countryNameInput = document.querySelector('.js_country_name_input');
        var phoneExtensionInput = document.querySelector('.js_phone_extension_input');
        var flagLinkInput = document.querySelector('.js_flag_image_link_input');
        var errorContainer = document.querySelector('.js_error_message');

        var name = countryNameInput.value;
        var phoneExtension = phoneExtensionInput.value;
        var flag = flagLinkInput.value;

        return inputsValidation(name, phoneExtension, flag, errorContainer);
    };
});



