(function ($, window, document) {
    /*最先初始化*/
    var action = $("#actionName").val();

    //提交标志
    function formSubmit() {
        $("#pageForm").attr("action", action);
        $("#pageForm").submit();
    }

    // 定义构造函数
    function Paging(el, options) {
        this.el = el;
        this.options = {
            pageNo: options.initPageNo || 1, // 初始页码
            totalPages: options.totalPages || 1, //总页数
            totalCount: options.totalCount || '', // 条目总数
            slideSpeed: options.slideSpeed || 0, // 缓动速度
            jump: options.jump || false, // 支持跳转
            callback: options.callback || function () {
            } // 回调函数
        };
        this.init();
    }

    // 给实例对象添加公共属性和方法
    Paging.prototype = {
        constructor: Paging,
        init: function () {
            this.createDom();
            this.bindEvents();
        },
        createDom: function () {
            var that = this,
                ulDom = '',
                jumpDom = '',
                content = '',
                liWidth = 60, // li的宽度
                totalPages = that.options.totalPages, // 总页数
                wrapLength = 0;
            totalPages > 5 ? wrapLength = 5 * liWidth : wrapLength = totalPages * liWidth;
            for (var i = 1; i <= that.options.totalPages; i++) {
                i != 1 ? ulDom += '<li id="btn_pageNum"' + i + '>' + i + '</li>' : ulDom += '<li class="sel-page" >' + i + '</li>';
            }
            that.options.jump ? jumpDom = '<input type="text" placeholder="1" class="jump-text" id="jumpText"><button type="button" class="jump-button" id="btn_jumpBtn">跳转</button>' : jumpDom = '';
            content = '<button type="button" id="btn_firstPage" class="turnPage first-page">首页</button>' +
                '<button class="turnPage" id="btn_prePage">上一页</button>' +
                '<div class="pageWrap" style="width:' + wrapLength + 'px">' +
                '<ul id="pageSelect" style="transition:all ' + that.options.slideSpeed + 'ms">' +
                ulDom +
                '</ul></div>' +
                '<button class="turnPage" id="btn_nextPage">下一页</button>' +
                '<button type="button" id="btn_lastPage" class="last-page">尾页</button>' +
                jumpDom +
                '<p class="total-pages">共&nbsp;' +
                that.options.totalPages +
                '&nbsp;页</p>' +
                '<p class="total-count">' +
                that.options.totalCount +
                '</p>';
            that.el.html(content);
        },
        bindEvents: function () {
            var that = this,
                pageSelect = $('#pageSelect'), // ul
                lis = pageSelect.children(), // li的集合
                liWidth = lis[0].offsetWidth, // li的宽度
                totalPages = that.options.totalPages, // 总页数
                pageIndex = that.options.pageNo, // 当前选择的页码
                distance = 0, // ul移动距离
                btn_prePage = $('#btn_prePage'),
                btn_nextPage = $('#btn_nextPage'),
                btn_firstPage = $('#btn_firstPage'),
                btn_lastPage = $('#btn_lastPage'),
                btn_jumpBtn = $('#btn_jumpBtn'),
                jumpText = $('#jumpText');

            btn_prePage.on('click', function () {
                pageIndex--;
                if (pageIndex < 1) {
                    pageIndex = 1;
                    handles(pageIndex);
                } else {
                    handles(pageIndex);
                    formSubmit();
                }

            })

            btn_nextPage.on('click', function () {
                pageIndex++;
                if (pageIndex > lis.length) {
                    pageIndex = lis.length;
                    handles(pageIndex);
                } else {
                    handles(pageIndex);
                    formSubmit();
                }


            })

            btn_firstPage.on('click', function () {
                pageIndex = 1;
                handles(pageIndex);
                formSubmit();
            })

            btn_lastPage.on('click', function () {
                pageIndex = totalPages;
                handles(pageIndex);
                formSubmit();
            })

            btn_jumpBtn.on('click', function () {
                var jumpNum = parseInt(jumpText.val().replace(/\D/g, ''));
                if (jumpNum && jumpNum >= 1 && jumpNum <= totalPages) {
                    pageIndex = jumpNum;
                    handles(pageIndex);
                    jumpText.val(jumpNum);
                }
                formSubmit();
            })

            lis.on('click', function () {
                pageIndex = $(this).index() + 1;
                handles(pageIndex);
                formSubmit();
            })

            function handles(pageIndex) {
                lis.removeClass('sel-page').eq(pageIndex - 1).addClass('sel-page');
                if (totalPages <= 5) {
                    that.options.callback(pageIndex);
                    return false;
                }
                if (pageIndex >= 3 && pageIndex <= totalPages - 2) distance = (pageIndex - 3) * liWidth;
                if (pageIndex == 2 || pageIndex == 1) distance = 0;
                if (pageIndex > totalPages - 2) distance = (totalPages - 5) * liWidth;
                pageSelect.css('transform', 'translateX(' + (-distance) + 'px)');
                pageIndex == 1 ? btn_firstPage.attr('disabled', true) : btn_firstPage.attr('disabled', false);
                pageIndex == 1 ? btn_prePage.attr('disabled', true) : btn_prePage.attr('disabled', false);
                pageIndex == totalPages ? btn_lastPage.attr('disabled', true) : btn_lastPage.attr('disabled', false);
                pageIndex == totalPages ? btn_nextPage.attr('disabled', true) : btn_nextPage.attr('disabled', false);
                that.options.callback(pageIndex);
            }

            handles(that.options.pageNo); // 初始化页码位置
        }
    }
    $.fn.paging = function (options) {
        return new Paging($(this), options);
    }
})(jQuery, window, document);