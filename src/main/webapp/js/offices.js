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








