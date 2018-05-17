Ext.require(['Ext.data.*', 'Ext.grid.*']);

Ext.define('User', {
    extend: 'Ext.data.Model',
    fields: [{
            name: 'id',
            type: 'int',
            useNull: true
        }, 'username', 'address','email'],
    validations: [{
            type: 'length',
            field: 'username',
            min: 1
        },{
            type: 'length',
            field: 'address',
            min: 1
        }, {
            type: 'length',
            field: 'email',
            min: 1
        }]
});

Ext.onReady(function() {

    var store = Ext.create('Ext.data.Store', {
        autoLoad: true,
        autoSync: true,
        model: 'User',
        proxy: {
            type: 'rest',
            url: 'users',
            format: 'json',
            headers: {
                'Content-Type': 'application/json'
            },
            reader: {
                type: 'json',
                root: 'data'
            },
            writer: {
                type: 'json'
            },
            api: {
                create: 'users/create/',
                read: '',
                update: 'users/edit/',
                destroy: 'users/delete/'
            }
        }
    });

    var rowEditing = Ext.create('Ext.grid.plugin.RowEditing');

    var grid = Ext.create('Ext.grid.Panel', {
        renderTo: document.body,
        plugins: [rowEditing],
        width: 400,
        height: 300,
        frame: true,
        title: 'Users',
        store: store,
        columns: [{
                text: 'ID',
                width: 40,
                sortable: true,
                dataIndex: 'id'
            }, {
                text: 'Name',
                flex: 1,
                sortable: true,
                dataIndex: 'username',
                field: {
                    xtype: 'textfield'
                }
            }, {
                text: 'Address',
                flex: 1,
                sortable: true,
                dataIndex: 'address',
                field: {
                    xtype: 'textfield'
                }
            }, {
                header: 'Email',
                width: 80,
                sortable: true,
                dataIndex: 'email',
                field: {
                    xtype: 'textfield'
                }
            }],
        dockedItems: [{
                xtype: 'toolbar',
                items: [{
                        text: 'Add',
                        iconCls: 'icon-add',
                        handler: function() {
                            // empty record
                            store.insert(0, new User());
                            rowEditing.startEdit(0, 0);
                        }
                    }, '-', {
                        text: 'Delete',
                        iconCls: 'icon-delete',
                        handler: function() {
                            var selection = grid.getView().getSelectionModel().getSelection()[0];
                            if (selection) {
                                store.remove(selection);
                            }
                        }
                    }]
            }]
    });
});