function handler(productId, officeId) {
    var xhr = new XMLHttpRequest();
    xhr.open('DELETE', 'offerings/remove?product_id='+productId+'&office_id='+officeId, false);
    xhr.send();
}