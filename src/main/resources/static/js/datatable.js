$(document).ready( function () {
    var table = $('#rmaTable').DataTable({
        "sAjaxSource": "/rmas",
        "sAjaxDataProp": "",
        "order": [[ 0, "asc" ]],
        "aoColumns": [
            { "mData": "id"},
            { "mData": "name" },
            { "mData": "lastName" },
            { "mData": "email" },
            { "mData": "phone" },
            { "mData": "active" }
        ]
    })
});