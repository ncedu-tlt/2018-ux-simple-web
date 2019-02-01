var trArray = document.getElementsByClassName("js_row");
for (var elem = 0; elem < trArray.length; elem++) {
    trArray[elem].getElementsByClassName("js_delete")[0].addEventListener('click', function () {
        var row = this.closest(".js_row");
        var productId = row.getElementsByClassName("js_product_id");
        var officeId = row.getElementsByClassName("js_office_id");
        var productIdStr = (productId[0].innerText);
        var officeIdStr = (officeId[0].innerText);
        var xhr = new XMLHttpRequest();
        xhr.open('DELETE', 'offerings/remove?product_id=' + productIdStr + '&office_id=' + officeIdStr, true);
        xhr.send();
        xhr.onreadystatechange = function () {
            if (xhr.readyState != 4) return;
            if (JSON.parse(xhr.responseText).isSuccess){
                row.remove();
            } else {
                var errorMessage = document.getElementsByClassName("js_error");
                errorMessage[0].style.display="block";
            }
        };
    })
}