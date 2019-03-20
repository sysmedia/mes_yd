var prefix = "/common/generator"
$(function() {
	load();
});

function load() {
	debugger;
	$('#exampleTable')
			.bootstrapTable(
					{
						method : 'get', // 服务器数据的请求方式 get or post
						url : prefix + "/list", // 服务器数据的加载地址
						showRefresh : true,
						showToggle : true,
						showColumns : true,
						iconSize : 'outline',
						toolbar : '#exampleToolbar',
						striped : true, // 设置为true会有隔行变色效果
						dataType : "json", // 服务器返回的数据类型
						pagination : true, // 设置为true会在底部显示分页条
						// queryParamsType : "limit",
						// //设置为limit则会发送符合RESTFull格式的参数
						singleSelect : false, // 设置为true将禁止多选
						// contentType : "application/x-www-form-urlencoded",
						// //发送到服务器的数据编码类型
						pageSize : 10, // 如果设置了分页，每页数据条数
						pageNumber : 1, // 如果设置了分布，首页页码
						search : true, // 是否显示搜索框
						showColumns : true, // 是否显示内容下拉框（选择显示的列）
						sidePagination : "client", // 设置在哪里进行分页，可选值为"client" 或者
						// "server"
						// queryParams : queryParams,
						// //请求服务器数据时，你可以通过重写参数的方式添加一些额外的参数，例如 toolbar 中的参数 如果
						// queryParamsType = 'limit' ,返回参数必须包含
						// limit, offset, search, sort, order 否则, 需要包含:
						// pageSize, pageNumber, searchText, sortName,
						// sortOrder.
						// 返回false将会终止请求
						//select a.OWNER owner,a.TABLE_NAME tableName,a.STATUS status状态,a.LAST_ANALYZED createTime from all_tables a where  a.OWNER=(select  b.OWNER from  all_tables b where b.TABLE_NAME='SYS_LOG')
						columns : [
                            {
                                checkbox: true
                            },
                               {
                                field: 'OWNER', // 列字段名
                                title: '拥有者' // 列标题
                                },
								{
									field : 'TABLENAME', // 列字段名
									title : '表名称' // 列标题
								},
								{
									field : 'STATUS',
									title : '表状态'

								},
								{
									field : 'CREATETIME',
									title : '创建时间',
                                    formatter: function (value, row, index) {
                                        return new Date(value).toLocaleString().substring(0,20);
                                    }
								},
								{
									title : '操作',
									field : 'TABLENAME',
									align : 'center',
									formatter : function(value, row, index) {
										var e = '<a class="btn btn-primary btn-sm" href="#" mce_href="#" title="生成代码" onclick="code(\''
												+ row.TABLENAME
												+ '\')"><i class="fa fa-code"></i></a> ';
										return e;
									}
								} ]
					});
}
function reLoad() {
	$('#exampleTable').bootstrapTable('refresh');
}
function code(tableName) {
	location.href = prefix + "/code/" + tableName;
}
function batchCode() {
	var rows = $('#exampleTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
	if (rows.length == 0) {
		layer.msg("请选择要生成代码的表");
		return;
	}
	var tables = new Array();
	// 遍历所有选择的行数据，取每条数据对应的ID
	$.each(rows, function(i, row) {
		tables[i] = row['tableName'];
	});
	location.href = prefix + "/batchCode?tables=" + JSON.stringify(tables);
}
