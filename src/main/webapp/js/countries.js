function showErrorMessage(message, duration) {
    var element = document.querySelector('.js_error_message');

    element.innerText = message;

    setTimeout(function () {
        element.innerText = '';
    }, duration)
}

document.querySelector('form').onsubmit = function () {

    var countryNameInput = document.querySelector('.js_country_name_input');
    var phoneExtensionInput = document.querySelector('.js_phone_extension_input');
    var flagLinkInput = document.querySelector('.js_flag_image_link_input');

    var name = countryNameInput.value;
    var phoneExtension = phoneExtensionInput.value;
    var flag = flagLinkInput.value;

    var COUNTRY_REGEX = /[0-9]/;
    var PHONE_REGEX = /^\+\d+/;
    var FLAG_URL_REGEX = /^https?:+/;

    var MESSAGE_DURATION = 3000;

    if (name.length === 0 || phoneExtension.length === 0 || flag.length === 0) {
        showErrorMessage('fill in all fields', MESSAGE_DURATION);
        return false;
    }

    var isNumber = COUNTRY_REGEX.test(name);

    if (isNumber) {
        showErrorMessage('Country name must not contain numbers', MESSAGE_DURATION);
        return false;
    }

    var isPhoneNumber = PHONE_REGEX.test(phoneExtension);

    if (!isPhoneNumber) {
        showErrorMessage('Incorrect phone number', MESSAGE_DURATION);
        return false;
    }

    var isUrl = FLAG_URL_REGEX.test(flag);

    if (!isUrl) {
        showErrorMessage('Incorrect link to flag image', MESSAGE_DURATION);
        return false;
    }

    return true;
};