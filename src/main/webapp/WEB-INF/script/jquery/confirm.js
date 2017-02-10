//<!-- JS files are loaded at the bottom of the page -->
$(document).ready(function(){
    var confirmDiv = $('<div id="jxt-confirm"></div>'); //创建一个父DIV
    $('<div class="header"><span>温馨提示</span></div>').appendTo(confirmDiv); //将子DIV添加到父DIV中
//    $('<div class="message"></div>').appendTo(confirmDiv);
//    $('<div class="buttons"><div class="no simplemodal-close"></div><div class="yes"></div></div>').appendTo(confirmDiv);
    $('<div class="msg-icon-cet"><div class="icon icon-warning"></div><div class="message"></div></div>').appendTo(confirmDiv);
    $('<div class="buttons"><span class="yes"></span><span class="no simplemodal-close"></span></div>').appendTo(confirmDiv);
    confirmDiv.appendTo('body');            //将父DIV添加到BODY中
    $('<div id="msgLoad"></div>').appendTo("body");
    $(".modal-close").click(function() {
		modal.close(), $.isFunction(callback)&& callback.apply();
	});
});

function messageLoading(a, b, c) {
	var d = $("#msgLoad");
	void 0 != a && "" != a ? d.text(a) : d.text("操作错误！"), d.fadeIn(250)
			.fadeOut(void 0 != b && "" != b ? b : 550), $.isFunction(c)
			&& c.apply();
}

function confirm(message, callback) {
	$('#jxt-confirm').modal({
		closeHTML: "<a href='#' title='Close' class='modal-close'>x</a>",
		position: ["30%",],
		overlayId: 'confirm-overlay',
		containerId: 'confirm-container', 
		onShow: function (dialog) {
			var modal = this;
			//判断图标
			$('#jxt-confirm .icon').attr('class','icon icon-doubt');//加载是否操作图标
			
			$('#jxt-confirm .no').text('取消');
			$('#jxt-confirm .yes').text('确认');
			$('.message', dialog.data[0]).append(message);

			// if the user clicks "yes"
			$('.yes', dialog.data[0]).click(function () {
				// close the dialog
				modal.close(); // or $.modal.close();
				// call the callback
				if ($.isFunction(callback)) {
					callback.apply();
				}
			});
		}
	});
}

function confirm(message, callback, btn) {
	$('#jxt-confirm').modal({
		closeHTML: "<a href='#' title='Close' class='modal-close'>x</a>",
		position: ["30%",],
		overlayId: 'confirm-overlay',
		containerId: 'confirm-container', 
		onShow: function (dialog) {
			var modal = this;
			//判断图标
			$('#jxt-confirm .icon').attr('class','icon icon-doubt');//加载是否操作图标
			$('#jxt-confirm .no').text('取消');
			$('#jxt-confirm .yes').text('确认');
			$('.message', dialog.data[0]).append(message);

			// if the user clicks "yes"
			$('.yes', dialog.data[0]).click(function () {
				// close the dialog
				modal.close(); // or $.modal.close();
				// call the callback
				if ($.isFunction(callback)) {
					callback.apply();
				}
			});
			
			// if the user clicks "no"
			$('.no', dialog.data[0]).click(function () {
				// close the dialog
				modal.close(); // or $.modal.close();
				// call the callback
				if ($.isFunction(btn)) {
					btn.apply();
				}
			});
		}
	});
}
	
function alert(message, callback) {
	$('#jxt-confirm').modal({
		closeHTML: "<a href='#' title='Close' class='modal-close'>x</a>",
		position: ["20%",],
		overlayId: 'confirm-overlay',
		containerId: 'confirm-container', 
		onShow: function (dialog) {
			var modal = this;
//			$('#jxt-confirm .header').html('<span>信息</span>');
			//判断图标
			if(message.indexOf('成功') != -1){
				$('#jxt-confirm .icon').attr('class','icon icon-success');//加载操作成功图标
			}else if(message.indexOf('失败') != -1){
				$('#jxt-confirm .icon').attr('class','icon icon-failure');//加载操作失败图标
			}else{
				$('#jxt-confirm .icon').attr('class','icon icon-warning');//加载引导提示图标
			}
			
			$('#jxt-confirm .no').hide();
			$('#jxt-confirm .yes').text('确认');
			
			$('.message', dialog.data[0]).append(message);

			// if the user clicks "ok"
			$('.yes', dialog.data[0]).click(function () {
				// close the dialog
				modal.close(); // or $.modal.close();
				// call the callback
				if ($.isFunction(callback)) {
					callback.apply();
				}
			});
		}
	});
}

//-->

/** modal content 
<div id='jxt-confirm'>
	<div class='header'><span>Confirm</span></div>
	<div class='message'></div>
	<div class='buttons'><div class='no simplemodal-close'>No</div><div class='yes'>Yes</div></div>
</div>
**/
