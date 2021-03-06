var deleteButtonsArray = document.querySelectorAll('.js_delete_button');
var deleteWindow = document.querySelector('.js_delete_window');

deleteButtonsArray.forEach(function (button, index) {
    button.addEventListener('click', function () {
        var tr = this.closest('.js_table_row');
        var countryName = tr.querySelector('.js_name_cell').innerText;
        deleteWindow.classList.add('delete_window_show');
        deleteWindow.id = tr.id;
        deleteWindow.querySelector('.js_delete_message').innerText = 'Are you sure you want to delete ' + countryName;
    })
});

var cancelDeleteButton = deleteWindow.querySelector('.js_no_button');

cancelDeleteButton.addEventListener('click', function () {
    deleteWindow.classList.remove('delete_window_show');
});

var rows = document.querySelectorAll('.js_table_row');
var deleteButton = deleteWindow.querySelector('.js_yes_button');

deleteButton.addEventListener('click', function () {

    var id = deleteWindow.id;

    var xhr = new XMLHttpRequest();
    xhr.open('DELETE', 'countries/remove?id=' + id, true);

    xhr.onload = function () {
        if (xhr.readyState !== 4) {
            deleteWindow.querySelector('.js_delete_message').innerText = 'Error from server';
            return;
        }

        var isSuccess = JSON.parse(this.responseText).isSuccess;

        if (isSuccess) {
            deleteWindow.classList.remove('delete_window_show');
            rows.forEach(function (row) {
                if(row.id === id){
                    row.remove();
                }
            });
        } else {
            deleteWindow.querySelector('.js_delete_message').innerText = 'Error from server';
        }
    };
    xhr.send();
});