function errorMessage(text) {
    var form = document.querySelector('form');
    var position = {
        top: form.getBoundingClientRect().top + pageYOffset,
        left: form.getBoundingClientRect().left + pageXOffset
    };

    var message = document.createElement('div');
    message.innerText = text;
    message.style.position = 'absolute';
    message.style.top = position.top - 20 + 'px';
    message.style.left = position.left + 'px';
    message.style.color = 'red';
    message.style.zIndex = '200';

    return message;
}

function deleteMessage(message) {
    setTimeout(function () {
        document.body.removeChild(message)
    }, 3000);
}

document.querySelector('form').onsubmit = function () {

    var countryNameInput = document.querySelector('.CountryNameInput');
    var phoneExtensionInput = document.querySelector('.PhoneExtensionInput');
    var flagLinkInput = document.querySelector('.FlagImageLinkInput');

    var name = countryNameInput.value;
    var phoneExtension = phoneExtensionInput.value;
    var flag = flagLinkInput.value;

    var isNumber = /[0-9]/.test(name);

    var message = document.createElement('div');

    if (name.length === 0 || phoneExtension.length === 0 || flag.length === 0) {
        message = errorMessage('fill in all fields');
        document.body.appendChild(message);
        deleteMessage(message);
        return false;
    } else {
        if (isNumber) {
            message = errorMessage('Country name must not contain numbers');
            document.body.appendChild(message);
            deleteMessage(message);
            return false;
        } else {
            if (phoneExtension.substring(0, 1) !== '+') {
                message = errorMessage('Phone extension must start with +');
                document.body.appendChild(message);
                deleteMessage(message);
                return false;
            } else {
                if (!Number(phoneExtension.substring(1))) {
                    message = errorMessage('Phone extension must contain just numbers with +');
                    document.body.appendChild(message);
                    deleteMessage(message);
                    return false;
                } else {
                    if (flag.substring(0, 4) !== 'http') {
                        message = errorMessage('Incorrect link to flag image');
                        document.body.appendChild(message);
                        deleteMessage(message);
                        return false;
                    }
                }
            }
        }
    }
};