var btns = document.getElementsByTagName('tr');

for (var i = 1; i < btns.length; i++) {
    var del_btn = btns[i].getElementsByClassName('button_delete')[0];

    del_btn.onclick = function () {
        var parent = this.closest('tr');
        var elem = parent.getElementsByClassName('id_th')[0];
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
        xhr.send(null);
    }
}








