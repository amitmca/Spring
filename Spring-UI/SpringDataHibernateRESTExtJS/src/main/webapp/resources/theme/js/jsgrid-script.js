$(function() {
			
            // Basic Data
            $("#jsGrid-basic").jsGrid({
                height: "70%",
                width: "100%",
                filtering: true,
                editing: true,
                sorting: true,
                paging: true,
                autoload: true,
                pageSize: 10,
                pageButtonCount: 5,
                deleteConfirm: "Do you really want to delete the user?",
                controller: {
                    loadData: function (filter) {
                        return $.ajax({
                            type: "GET",
                            url: "/SpringDataHibernateRESTExtJS/JsGridEx/users",
                            data: filter
                        });
                    },
                    insertItem: function (item) {
                        return $.ajax({
                            type: "POST",
                            url: "/JsGridEx/ManageCars",
                            data: item
                        });
                    },
                    updateItem: function (item) {
                        return $.ajax({
                            type: "PUT",
                            url: "/JsGridEx/ManageCars",
                            data: item
                        });
                    },
                    deleteItem: function (item) {
                        return $.ajax({
                            type: "DELETE",
                            url: "/JsGridEx/ManageCars",
                            data: item
                        });
                    }
                },
                fields: [
                    { name: "Id", type: "number", width: 50 },
                    { name: "Name", type: "text", width: 150 },
                    { name: "Address", type: "text", width: 200 },
                    { name: "Email", type: "text", width: 200 }
                ]
            });
        });