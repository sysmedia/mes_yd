var prefix = "/report/common"
$(function() {
	//load();
});

function load() {
    $("#exampleTable").bootstrapTable('destroy');
    $('#exampleTable')
			.bootstrapTable(
					{
						method : 'get', // 服务器数据的请求方式 get or post
						url : prefix + "/list", // 服务器数据的加载地址
						// showRefresh : true,
						// showToggle : true,
						// showColumns : true,
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
						//pageSize : 10, // 如果设置了分页，每页数据条数
						//pageNumber : 1, // 如果设置了分布，首页页码
						 //search : true, // 是否显示搜索框
						//showColumns : false, // 是否显示内容下拉框（选择显示的列）
                        //初始化加载第一页，默认第一页
                        undefinedText:'',//定义空的时候值填充
                        pageNumber: 1,
                        //每页的记录行数
                        pageSize: 10,
                        //可供选择的每页的行数
                        pageList: [10,50, 100, 500,'All'],
                        //设置为false 将禁止所有列的排序。
                        sortable: true,
                        //设置默认排序为 name
                      //  sortName: 'userId',
                        //定义排序方式，'asc' 或者 'desc'。
                       // sortOrder: "desc",
                        //是否显示刷新按钮
                        showRefresh: true,
                        //是否显示内容列下拉框。
                        showColumns: true,
						sidePagination : "server", // 设置在哪里进行分页，可选值为"client" 或者
													// "server"
						queryParams : function(params) {
							return {
								// 说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
								limit : params.limit,
								offset : params.offset,
								palletCode : $('#searchName').val()
							};
						},
						// //请求服务器数据时，你可以通过重写参数的方式添加一些额外的参数，例如 toolbar 中的参数 如果
						// queryParamsType = 'limit' ,返回参数必须包含
						// limit, offset, search, sort, order 否则, 需要包含:
						// pageSize, pageNumber, searchText, sortName,
						// sortOrder.
						// 返回false将会终止请求
                        // showExport: true,                     //是否显示导出
                        // exportDataType: "all",              //basic', 'all', 'selected'.
                        //showToggle:true,
                        //>>>>>>>>>>>>>>导出excel表格设置
                        showExport: true,             //是否显示导出按钮(此方法是自己写的目的是判断终端是电脑还是手机,电脑则返回true,手机返回falsee,手机不显示按钮)
                        exportDataType:'all' ,             //basic', 'all', 'selected'.
                        exportTypes:['excel','doc','xlsx','csv', 'txt', 'sql'],	    //导出类型
                        //exportButton: $('#btn_export'),     //为按钮btn_export  绑定导出事件  自定义导出按钮(可以不用)
                        exportOptions:{
                            ignoreColumn: [0],            //忽略某一列的索引
                            fileName: '数据导出',              //文件名称设置
                            worksheetName: 'Sheet1',          //表格工作区名称
                            tableName: '数据表',
                            excelstyles: ['background-color', 'color', 'font-size', 'font-weight'],
                            //onMsoNumberFormat: DoOnMsoNumberFormat
                        },
                        //导出excel表格设置<<<<<<<<<<<<<<<<
                        columns : [
								{
									checkbox : true
								},
                            {
                                field: 'project',
                                title: 'PROJECT'
                            }
                            ,{
                                field : 'order', // 列字段名
                                title : 'ORDER' // 列标题
                            },{
                                field : 'palletcode', // 列字段名
                                title : 'PALLETCODE' // 列标题
                            },{
                                field : 'tp', // 列字段名
                                title : 'TP' // 列标题
                            },{
                                field : 'battery', // 列字段名
                                title : 'BATTERY' // 列标题
                            },{
                                field : 'batterysupplier', // 列字段名
                                title : 'BATTERYSUPPLIER' // 列标题
                            },{
                                field : 'frontcamera', // 列字段名
                                title : 'FRONTCAMERA' // 列标题
                            },{
                                field : 'frontcamerasupplier', // 列字段名
                                title : 'FRONTCAMERASUPPLIER' // 列标题
                            },{
                                field : 'backcamera', // 列字段名
                                title : 'BACKCAMERA' // 列标题
                            },{
                                field : 'backcamerasupplier', // 列字段名
                                title : 'BACKCAMERASUPPLIER' // 列标题
                            },{
                                field : 'weight', // 列字段名
                                title : 'WEIGHT' // 列标题
                            },{
                                field : 'imeiwritetime', // 列字段名
                                title : 'IMEIWRITETIME' // 列标题
                            },{
                                field : 'boxtime', // 列字段名
                                title : 'BOXTIME' // 列标题
                            },{
                                field : 'packtime', // 列字段名
                                title : 'PACKTIME' // 列标题
                            },{
                                field : 'encrypttime', // 列字段名
                                title : 'ENCRYPTTIME' // 列标题
                            },{
                                field : 'imei1', // 列字段名
                                title : 'IMEI1' // 列标题
                            },{
                                field : 'imei2', // 列字段名
                                title : 'IMEI2' // 列标题
                            },{
                                field : 'meid', // 列字段名
                                title : 'MEID' // 列标题
                            },{
                                field : 'pcbsn', // 列字段名
                                title : 'PCBSN' // 列标题
                            },{
                                field : 'bt', // 列字段名
                                title : 'BT' // 列标题
                            },{
                                field : 'wifi', // 列字段名
                                title : 'WIFI' // 列标题
                            },{
                                field : 'msn', // 列字段名
                                title : 'MSN' // 列标题
                            },{
                                field : 'netcode', // 列字段名
                                title : 'NETCODE' // 列标题
                            },{
                                field : 'colorid', // 列字段名
                                title : 'COLORID' // 列标题
                            },{
                                field : 'softver', // 列字段名
                                title : 'SOFTVER' // 列标题
                            },{
                                field : 'color', // 列字段名
                                title : 'COLOR' // 列标题
                            },{
                                field : 'flash', // 列字段名
                                title : 'FLASH' // 列标题
                            },{
                                field : 'model', // 列字段名
                                title : 'MODEL' // 列标题
                            },{
                                field : 'partno', // 列字段名
                                title : 'PARTNO' // 列标题
                            },{
                                field : 'eancode', // 列字段名
                                title : 'EANCODE' // 列标题
                            },{
                                field : 'destination', // 列字段名
                                title : 'DESTINATION' // 列标题
                            },{
                                field : 'boxno', // 列字段名
                                title : 'BOXNO' // 列标题
                            },{
                                field : 'suid', // 列字段名
                                title : 'SUID' // 列标题
                            },{
                                field : 'screen', // 列字段名
                                title : 'SCREEN' // 列标题
                            },{
                                field : 'secretkey', // 列字段名
                                title : 'SECRETKEY' // 列标题
                            },{
                                field : 'emmcsupplier', // 列字段名
                                title : 'EMMCSUPPLIER' // 列标题
                            },{
                                field : 'preno', // 列字段名
                                title : 'PRENO' // 列标题
                            },{
                                field : 'id5', // 列字段名
                                title : 'ID5' // 列标题
                            },{
                                field : 'id6', // 列字段名
                                title : 'ID6' // 列标题
                            },{
                                field : 'tsn', // 列字段名
                                title : 'TSN' // 列标题
                            },{
                                field : 'fan', // 列字段名
                                title : 'FAN' // 列标题
                            },{
                                field : 'obd', // 列字段名
                                title : 'OBD' // 列标题
                            },{
                                field : 'batterycover', // 列字段名
                                title : 'BATTERYCOVER' // 列标题
                            },{
                                field : 'frontcase', // 列字段名
                                title : 'FRONTCASE' // 列标题
                            },{
                                field : 'platelet', // 列字段名
                                title : 'PLATELET' // 列标题
                            }
                        ],
                        onLoadSuccess: function(){  //加载成功时执行
                          //  console.info("加载成功");
                        },
                        onLoadError: function(){  //加载失败时执行
                          //  console.info("加载数据失败");
                        }

                    });

}
function reLoad() {
    load();
	//$('#exampleTable').bootstrapTable('refresh');
}
// function add() {
// 	// iframe层
// 	layer.open({
// 		type : 2,
// 		title : '增加用户',
// 		maxmin : true,
// 		shadeClose : false, // 点击遮罩关闭层
// 		area : [ '800px', '520px' ],
// 		content : prefix + '/add' // iframe的url
// 	});
// }
// function remove(id) {
// 	layer.confirm('确定要删除选中的记录？', {
// 		btn : [ '确定', '取消' ]
// 	}, function() {
// 		$.ajax({
// 			url : "/sys/user/remove",
// 			type : "post",
// 			data : {
// 				'id' : id
// 			},
// 			success : function(r) {
// 				if (r.code == 0) {
// 					layer.msg(r.msg);
// 					reLoad();
// 				} else {
// 					layer.msg(r.msg);
// 				}
// 			}
// 		});
// 	})
// }
// function edit(id) {
// 	layer.open({
// 		type : 2,
// 		title : '用户修改',
// 		maxmin : true,
// 		shadeClose : true, // 点击遮罩关闭层
// 		area : [ '800px', '520px' ],
// 		content : prefix + '/edit/' + id // iframe的url
// 	});
// }
// function resetPwd(id) {
// 	layer.open({
// 		type : 2,
// 		title : '重置密码',
// 		maxmin : true,
// 		shadeClose : false, // 点击遮罩关闭层
// 		area : [ '400px', '260px' ],
// 		content : prefix + '/resetPwd/' + id // iframe的url
// 	});
// }
// function batchRemove() {
// 	var rows = $('#exampleTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
// 	if (rows.length == 0) {
// 		layer.msg("请选择要删除的数据");
// 		return;
// 	}
// 	layer.confirm("确认要删除选中的'" + rows.length + "'条数据吗?", {
// 		btn : [ '确定', '取消' ]
// 	// 按钮
// 	}, function() {
// 		var ids = new Array();
// 		// 遍历所有选择的行数据，取每条数据对应的ID
// 		$.each(rows, function(i, row) {
// 			ids[i] = row['userId'];
// 		});
// 		$.ajax({
// 			type : 'POST',
// 			data : {
// 				"ids" : ids
// 			},
// 			url : prefix + '/batchRemove',
// 			success : function(r) {
// 				if (r.code == 0) {
// 					layer.msg(r.msg);
// 					reLoad();
// 				} else {
// 					layer.msg(r.msg);
// 				}
// 			}
// 		});
// 	}, function() {
//
// 	});
//
// }