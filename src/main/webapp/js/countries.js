
function showErrorMessage(message, duration){
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

    var isNumber = /[0-9]/.test(name);

    var isPhoneNumber =  /^\+\d+/.test(phoneExtension);

    var isUrl = /^https?:+/.test(flag);

    if (name.length === 0 || phoneExtension.length === 0 || flag.length === 0) {
        showErrorMessage('fill in all fields', 3000);
        return false;
    } else {
        if (isNumber) {
            showErrorMessage('Country name must not contain numbers', 3000);
            return false;
        } else {
            if (!isPhoneNumber) {
                showErrorMessage('Incorrect phone number', 3000);
                return false;
            } {
                    if (!isUrl) {
                        showErrorMessage('Incorrect link to flag image', 3000);
                        return false;
                    }
                }
            }
        }
};