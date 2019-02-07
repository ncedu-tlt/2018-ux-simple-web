var deleteButtonsArray = document.querySelectorAll('.js_delete_button');
var deleteWindow = document.querySelector('.js_delete_window');

deleteButtonsArray.forEach(function (button, index) {
    button.onclick = function () {
        var tr = this.closest('tr');
        var countryName = tr.querySelector('.js_name_cell').innerText;
        deleteWindow.style.display = 'flex';
        deleteWindow.querySelector('.js_delete_message').innerText = 'Are you sure you want to delete ' + countryName;
    }
});

var cancelDeleteButton = deleteWindow.querySelector('.no_button');

cancelDeleteButton.onclick = function () {
    deleteWindow.style.display = '';
};