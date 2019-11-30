
$(document).ready(function() {
    $('#userResultsDiv').jtable({
        title :'List of Employees',
        actions : {
//          listAction : 'get',
            listAction : function (postData, jtParams) {
                return $.Deferred(function ($dfd) {
                    $.ajax({
                        url: 'get',
                        type: 'GET',
                        dataType: 'json',
                        data: postData,
                        success: function (data) {
                            $dfd.resolve(data);
                        },
                        error: function () {
                            $dfd.reject();
                        }
                    });
                });
            },
            createAction : 'save-edit',
            updateAction : 'save-edit',
            deleteAction : 'delete'
        },
        fields : {
            id : {
                title : 'User ID',
                key : true,
                width : '15%'
            },
            username : {
                title : 'Username',
                width : '30%',
                type : 'hidden-edit'
            },
            address : {
                title : 'Address',
                width : '15%'
            },
            email : {
                title : 'Email',
                width : '25%'
            }
        }
    });
    $('#userResultsDiv').jtable('load');
});