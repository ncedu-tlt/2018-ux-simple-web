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
            if (JSON.parse(xhr.responseText).isSuccess) {
                row.remove();
            } else {
                var errorMessage = document.getElementsByClassName("js_error");
                errorMessage[0].style.display = "block";
            }
        };
    })
}


function validForPrice(offeringPrice) {
    if (offeringPrice.match(/^\d+$|^\d+\.\d+$/ig) === null) {
        document.getElementsByClassName("js_valid")[0].classList.remove("none");
        return false;
    } else {
        return true;
    }
}

if (document.getElementsByClassName("js_form_add")[0] !== undefined) {
    document.getElementsByClassName("js_form_add")[0].onsubmit = function () {
        var office = document.getElementsByClassName("js_office")[0].value;
        var product = document.getElementsByClassName("js_product")[0].value;
        var offeringPrice = document.getElementsByClassName("js_offering_price")[0].value;

        if (office.length === 0 || product.length === 0 || offeringPrice.length === 0) {
            document.getElementsByClassName("js_required")[0].classList.remove("none");
            return false;
        } else {
            return validForPrice(offeringPrice);
        }
    };
}

if (document.getElementsByClassName("js_form_edit")[0] !== undefined) {
    document.getElementsByClassName("js_form_edit")[0].onsubmit = function () {
        var offeringPrice = document.getElementsByClassName("js_offering_price")[0].value;
        if (offeringPrice.length === 0) {
            document.getElementsByClassName("js_required")[0].classList.remove("none");
            return false;
        } else {
            return validForPrice(offeringPrice);
        }
    };
}
