var trArray = document.getElementsByTagName("tr");
for(var elem=0;elem<trArray.length;elem++){
    trArray[elem].addEventListener('click',function handler() {
        var product_id = this.getElementsByClassName("product_id");
        var office_id = this.getElementsByClassName("office_id");
        this.getElementsByClassName("delete")[0].addEventListener('click', function () {
                var product_id_str = (product_id[0].innerText);
                var office_id_str = (office_id[0].innerText);
                var xhr = new XMLHttpRequest();
                xhr.open('DELETE', 'offerings/remove?product_id='+product_id_str+'&office_id='+office_id_str, false);
                xhr.send();
                if(JSON.parse(xhr.responseText).isSuccess){
                    this.closest("tr").remove();
                }else{
                    alert("Bad request from server.");
                }
            } );
    })
}
