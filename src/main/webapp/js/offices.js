
var btns = document.getElementsByTagName('tr');

for (var i=0; i<btns.length; i++){
    btns[i].onclick = function () {
        var row = this;
        var elem = this.getElementsByClassName('id_th')[0];
        var id = elem.innerText;

        var xhr = new XMLHttpRequest();
        xhr.open('DELETE', 'offices/remove?officeId=' + id, true);

        xhr.onload = function () {
            var isSuccess = JSON.parse(xhr.responseText);
            if (isSuccess.isSuccess) {
               row.remove();
            } else {

            }
        };
        xhr.send(null);
    }
}








