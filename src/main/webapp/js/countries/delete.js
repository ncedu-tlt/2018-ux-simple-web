var deleteButtonsArray = document.querySelectorAll('.js_delete_button');
var deleteWindow = document.querySelector('.js_delete_window');
var tr;

deleteButtonsArray.forEach(function (button, index) {
    button.onclick = function () {
        tr = this.closest('tr');
        var countryName = tr.querySelector('.js_name_cell').innerText;
        deleteWindow.style.display = 'flex';
        deleteWindow.querySelector('.js_delete_message').innerText = 'Are you sure you want to delete ' + countryName;
    }
});

var cancelDeleteButton = deleteWindow.querySelector('.js_no_button');

cancelDeleteButton.onclick = function () {
    deleteWindow.style.display = '';
};

var deleteButton = deleteWindow.querySelector('.js_yes_button');

deleteButton.onclick = function () {

    var id = tr.id;

    var xhr = new XMLHttpRequest();
    xhr.open('DELETE', 'countries/remove?id=' + id, true);

    xhr.onload = function () {
        var response = JSON.parse(this.responseText);
        console.log(response);
        // if (response) {
        //     deleteWindow.style.display = '';
        //     tr.remove();
        // } else {
        //     deleteWindow.querySelector('.js_delete_message').innerText = 'Error from server';
        // }
    };
    xhr.send();
};