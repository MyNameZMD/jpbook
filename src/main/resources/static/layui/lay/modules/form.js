layui.define('layer', function(exports){
    "use strict";

    var $ = layui.$
        ,layer = layui.layer
        ,hint = layui.hint()
        ,device = layui.device()

        ,MOD_NAME = 'form', ELEM = '.layui-form', THIS = 'layui-this', SHOW = 'layui-show', HIDE = 'layui-hide', DISABLED = 'layui-disabled'

        ,Form = function(){
        this.config = {
            verify: {
                required: [
                    /[\S]+/
                    ,'必填项不能为空!'
                ]
                ,phone: [
                    /^1\d{10}$/
                    ,'请输入正确的手机号!'
                ]
                ,email: [
                    /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/
                    ,'邮箱格式不正确!'
                ]
                ,url: [
                    /(^#)|(^http(s*):\/\/[^\s]+\.[^\s]+)/
                    ,'链接格式不正确!'
                ]
                ,number: function(value){
                    if(!value || isNaN(value)) return '只能填写数字!'
                }
                ,date: [
                    /^(\d{4})[-\/](\d{1}|0\d{1}|1[0-2])([-\/](\d{1}|0\d{1}|[1-2][0-9]|3[0-1]))*$/
                    ,'日期格式不正确!'
                ]
                ,identity: [
                    /(^\d{15}$)|(^\d{17}(x|X|\d)$)/
                    ,'请输入正确的身份证号!'
                ]
            }
        };
    };

    //全局设置
    Form.prototype.set = function(options){
        var that = this;
        $.extend(true, that.config, options);
        return that;
    };

    //验证规则设定
    Form.prototype.verify = function(settings){
        var that = this;
        $.extend(true, that.config.verify, settings);
        return that;
    };

    //表单事件监听
    Form.prototype.on = function(events, callback){
        return layui.onevent.call(this, MOD_NAME, events, callback);
    };

    //表单控件渲染
    Form.prototype.render = function(type, filter){
        var that = this
            ,elemForm = $(ELEM + function(){
                return filter ? ('[lay-filter="' + filter +'"]') : '';
            }())
            ,items = {

            //下拉选择框
            select: function(){
                var TIPS = '请选择', CLASS = 'layui-form-select', TITLE = 'layui-select-title'
                    ,NONE = 'layui-select-none', initValue = '', thatInput

                    ,selects = elemForm.find('select'), hide = function(e, clear){
                    if(!$(e.target).parent().hasClass(TITLE) || clear){
                        $('.'+CLASS).removeClass(CLASS+'ed ' + CLASS+'up');
                        thatInput && initValue && thatInput.val(initValue);
                    }
                    thatInput = null;
                }

                    ,events = function(reElem, disabled, isSearch){
                    var select = $(this)
                        ,title = reElem.find('.' + TITLE)
                        ,input = title.find('input')
                        ,dl = reElem.find('dl')
                        ,dds = dl.children('dd')


                    if(disabled) return;

                    //展开下拉
                    var showDown = function(){
                        var top = reElem.offset().top + reElem.outerHeight() + 5 - win.scrollTop()
                            ,dlHeight = dl.outerHeight();
                        reElem.addClass(CLASS+'ed');
                        dds.removeClass(HIDE);

                        //上下定位识别
                        if(top + dlHeight > win.height() && top >= dlHeight){
                            reElem.addClass(CLASS + 'up');
                        }
                    }, hideDown = function(choose){
                        reElem.removeClass(CLASS+'ed ' + CLASS+'up');
                        input.blur();

                        if(choose) return;

                        notOption(input.val(), function(none){
                            if(none){
                                initValue = dl.find('.'+THIS).html();
                                input && input.val(initValue);
                            }
                        });
                    };

                    //点击标题区域
                    title.on('click', function(e){
                        reElem.hasClass(CLASS+'ed') ? (
                            hideDown()
                        ) : (
                            hide(e, true),
                                showDown()
                        );
                        dl.find('.'+NONE).remove();
                    });

                    //点击箭头获取焦点
                    title.find('.layui-edge').on('click', function(){
                        input.focus();
                    });

                    //键盘事件
                    input.on('keyup', function(e){
                        var keyCode = e.keyCode;
                        //Tab键
                        if(keyCode === 9){
                            showDown();
                        }
                    }).on('keydown', function(e){
                        var keyCode = e.keyCode;
                        //Tab键
                        if(keyCode === 9){
                            hideDown();
                        } else if(keyCode === 13){ //回车键
                            e.preventDefault();
                        }
                    });

                    //检测值是否不属于select项
                    var notOption = function(value, callback, origin){
                        var num = 0;
                        layui.each(dds, function(){
                            var othis = $(this)
                                ,text = othis.text()
                                ,not = text.indexOf(value) === -1;
                            if(value === '' || (origin === 'blur') ? value !== text : not) num++;
                            origin === 'keyup' && othis[not ? 'addClass' : 'removeClass'](HIDE);
                        });
                        var none = num === dds.length;
                        return callback(none), none;
                    };

                    //搜索匹配
                    var search = function(e){
                        var value = this.value, keyCode = e.keyCode;

                        if(keyCode === 9 || keyCode === 13
                            || keyCode === 37 || keyCode === 38
                            || keyCode === 39 || keyCode === 40
                        ){
                            return false;
                        }

                        notOption(value, function(none){
                            if(none){
                                dl.find('.'+NONE)[0] || dl.append('<p class="'+ NONE +'">无匹配项</p>');
                            } else {
                                dl.find('.'+NONE).remove();
                            }
                        }, 'keyup');

                        if(value === ''){
                            dl.find('.'+NONE).remove();
                        }
                    };

                    if(isSearch){
                        input.on('keyup', search).on('blur', function(e){
                            thatInput = input;
                            initValue = dl.find('.' + THIS).html();
                            setTimeout(function(){
                                notOption(input.val(), function(none){
                                    initValue || input.val(''); //none && !initValue
                                }, 'blur');
                            }, 200);
                        });
                    }

                    //选择
                    dds.on('click', function(){
                        var othis = $(this), value = othis.attr('lay-value');
                        var filter = select.attr('lay-filter'); //获取过滤器

                        if(othis.hasClass(DISABLED)) return false;

                        if(othis.hasClass('layui-select-tips')){
                            input.val('');
                        } else {
                            input.val(othis.text());
                            othis.addClass(THIS);
                        }

                        othis.siblings().removeClass(THIS);
                        select.val(value).removeClass('layui-form-danger')
                        layui.event.call(this, MOD_NAME, 'select('+ filter +')', {
                            elem: select[0]
                            ,value: value
                            ,othis: reElem
                        });

                        hideDown(true);
                        return false;
                    });

                    reElem.find('dl>dt').on('click', function(e){
                        return false;
                    });

                    //关闭下拉
                    $(document).off('click', hide).on('click', hide);
                }

                selects.each(function(index, select){
                    var othis = $(this)
                        ,hasRender = othis.next('.'+CLASS)
                        ,disabled = this.disabled
                        ,value = select.value
                        ,selected = $(select.options[select.selectedIndex]) //获取当前选中项
                        ,optionsFirst = select.options[0];

                    if(typeof othis.attr('lay-ignore') === 'string') return othis.show();

                    var isSearch = typeof othis.attr('lay-search') === 'string'
                        ,placeholder = optionsFirst ? (
                        optionsFirst.value ? TIPS : (optionsFirst.innerHTML || TIPS)
                    ) : TIPS;

                    //替代元素
                    var reElem = $(['<div class="'+ (isSearch ? '' : 'layui-unselect ') + CLASS + (disabled ? ' layui-select-disabled' : '') +'">'
                        ,'<div class="'+ TITLE +'"><input type="text" placeholder="'+ placeholder +'" value="'+ (value ? selected.html() : '') +'" '+ (isSearch ? '' : 'readonly') +' class="layui-input'+ (isSearch ? '' : ' layui-unselect') + (disabled ? (' ' + DISABLED) : '') +'">'
                        ,'<i class="layui-edge"></i></div>'
                        ,'<dl class="layui-anim layui-anim-upbit'+ (othis.find('optgroup')[0] ? ' layui-select-group' : '') +'">'+ function(options){
                            var arr = [];
                            layui.each(options, function(index, item){
                                if(index === 0 && !item.value){
                                    arr.push('<dd lay-value="" class="layui-select-tips">'+ (item.innerHTML || TIPS) +'</dd>');
                                } else if(item.tagName.toLowerCase() === 'optgroup'){
                                    arr.push('<dt>'+ item.label +'</dt>');
                                } else {
                                    arr.push('<dd lay-value="'+ item.value +'" class="'+ (value === item.value ?  THIS : '') + (item.disabled ? (' '+DISABLED) : '') +'">'+ item.innerHTML +'</dd>');
                                }
                            });
                            arr.length === 0 && arr.push('<dd lay-value="" class="'+ DISABLED +'">没有选项</dd>');
                            return arr.join('');
                        }(othis.find('*')) +'</dl>'
                        ,'</div>'].join(''));

                    hasRender[0] && hasRender.remove(); //如果已经渲染，则Rerender
                    othis.after(reElem);
                    events.call(this, reElem, disabled, isSearch);
                });
            }
            //复选框/开关
            ,checkbox: function(){
                var CLASS = {
                    checkbox: ['layui-form-checkbox', 'layui-form-checked', 'checkbox']
                    ,_switch: ['layui-form-switch', 'layui-form-onswitch', 'switch']
                }
                    ,checks = elemForm.find('input[type=checkbox]')

                    ,events = function(reElem, RE_CLASS){
                    var check = $(this);

                    //勾选
                    reElem.on('click', function(){
                        var filter = check.attr('lay-filter') //获取过滤器
                            ,text = (check.attr('lay-text')||'').split('|');

                        if(check[0].disabled) return;

                        check[0].checked ? (
                            check[0].checked = false
                                ,reElem.removeClass(RE_CLASS[1]).find('em').text(text[1])
                        ) : (
                            check[0].checked = true
                                ,reElem.addClass(RE_CLASS[1]).find('em').text(text[0])
                        );

                        layui.event.call(check[0], MOD_NAME, RE_CLASS[2]+'('+ filter +')', {
                            elem: check[0]
                            ,value: check[0].value
                            ,othis: reElem
                        });
                    });
                }

                checks.each(function(index, check){
                    var othis = $(this), skin = othis.attr('lay-skin')
                        ,text = (othis.attr('lay-text')||'').split('|'), disabled = this.disabled;
                    if(skin === 'switch') skin = '_'+skin;
                    var RE_CLASS = CLASS[skin] || CLASS.checkbox;

                    if(typeof othis.attr('lay-ignore') === 'string') return othis.show();

                    //替代元素
                    var hasRender = othis.next('.' + RE_CLASS[0]);
                    var reElem = $(['<div class="layui-unselect '+ RE_CLASS[0] + (
                        check.checked ? (' '+RE_CLASS[1]) : '') + (disabled ? ' layui-checkbox-disbaled '+DISABLED : '') +'" lay-skin="'+ (skin||'') +'">'
                        ,{
                            _switch: '<em>'+ ((check.checked ? text[0] : text[1])||'') +'</em><i></i>'
                        }[skin] || ((check.title.replace(/\s/g, '') ? ('<span>'+ check.title +'</span>') : '') +'<i class="layui-icon">'+ (skin ? '&#xe605;' : '&#xe618;') +'</i>')
                        ,'</div>'].join(''));

                    hasRender[0] && hasRender.remove(); //如果已经渲染，则Rerender
                    othis.after(reElem);
                    events.call(this, reElem, RE_CLASS);
                });
            }
            //单选框
            ,radio: function(){
                var CLASS = 'layui-form-radio', ICON = ['&#xe643;', '&#xe63f;']
                    ,radios = elemForm.find('input[type=radio]')

                    ,events = function(reElem){
                    var radio = $(this), ANIM = 'layui-anim-scaleSpring';

                    reElem.on('click', function(){
                        var name = radio[0].name, forms = radio.parents(ELEM);
                        var filter = radio.attr('lay-filter'); //获取过滤器
                        var sameRadio = forms.find('input[name='+ name.replace(/(\.|#|\[|\])/g, '\\$1') +']'); //找到相同name的兄弟

                        if(radio[0].disabled) return;

                        layui.each(sameRadio, function(){
                            var next = $(this).next('.'+CLASS);
                            this.checked = false;
                            next.removeClass(CLASS+'ed');
                            next.find('.layui-icon').removeClass(ANIM).html(ICON[1]);
                        });

                        radio[0].checked = true;
                        reElem.addClass(CLASS+'ed');
                        reElem.find('.layui-icon').addClass(ANIM).html(ICON[0]);

                        layui.event.call(radio[0], MOD_NAME, 'radio('+ filter +')', {
                            elem: radio[0]
                            ,value: radio[0].value
                            ,othis: reElem
                        });
                    });
                };

                radios.each(function(index, radio){
                    var othis = $(this), hasRender = othis.next('.' + CLASS), disabled = this.disabled;

                    if(typeof othis.attr('lay-ignore') === 'string') return othis.show();
                    hasRender[0] && hasRender.remove(); //如果已经渲染，则Rerender

                    //替代元素
                    var reElem = $(['<div class="layui-unselect '+ CLASS + (radio.checked ? (' '+CLASS+'ed') : '') + (disabled ? ' layui-radio-disbaled '+DISABLED : '') +'">'
                        ,'<i class="layui-anim layui-icon">'+ ICON[radio.checked ? 0 : 1] +'</i>'
                        ,'<div>'+ function(){
                            var title = radio.title || '';
                            if(typeof othis.next().attr('lay-radio') === 'string'){
                                title = othis.next().html();
                                othis.next().remove();
                            }
                            return title
                        }() +'</div>'
                        ,'</div>'].join(''));

                    othis.after(reElem);
                    events.call(this, reElem);
                });
            }
        };
        type ? (
            items[type] ? items[type]() : hint.error('不支持的'+ type + '表单渲染')
        ) : layui.each(items, function(index, item){
            item();
        });
        return that;
    };

    //表单提交校验
    var submit = function(){
        var button = $(this), verify = form.config.verify, stop = null
            ,DANGER = 'layui-form-danger', field = {} ,elem = button.parents(ELEM)

            ,verifyElem = elem.find('*[lay-verify]') //获取需要校验的元素
            ,formElem = button.parents('form')[0] //获取当前所在的form元素，如果存在的话
            ,fieldElem = elem.find('input,select,textarea') //获取所有表单域
            ,filter = button.attr('lay-filter'); //获取过滤器


        //开始校验
        layui.each(verifyElem, function(_, item){
            var othis = $(this)
                ,vers = othis.attr('lay-verify').split('|')
                ,verType = othis.attr('lay-verType') //提示方式
                ,value = othis.val();

            othis.removeClass(DANGER);
            layui.each(vers, function(_, thisVer){
                var isTrue //是否命中校验
                    ,errorText = '' //错误提示文本
                    ,isFn = typeof verify[thisVer] === 'function';

                //匹配验证规则
                if(verify[thisVer]){
                    var isTrue = isFn ? errorText = verify[thisVer](value, item) : !verify[thisVer][0].test(value);
                    errorText = errorText || verify[thisVer][1];

                    //如果是必填项或者非空命中校验，则阻止提交，弹出提示
                    if(isTrue){
                        //提示层风格
                        if(verType === 'tips'){
                            layer.tips(errorText, function(){
                                if(typeof othis.attr('lay-ignore') !== 'string'){
                                    if(item.tagName.toLowerCase() === 'select' || /^checkbox|radio$/.test(item.type)){
                                        return othis.next();
                                    }
                                }
                                return othis;
                            }(), {tips: 2});
                        } else if(verType === 'alert') {
                            layer.alert(errorText, {title: '提示', shadeClose: true});
                        } else {
                            layer.msg(errorText, {anim: 1});
                        }
                        if(!device.android && !device.ios) item.focus(); //非移动设备自动定位焦点
                        othis.addClass(DANGER);
                        return stop = true;
                    }
                }
            });
            if(stop) return stop;
        });

        if(stop) return false;

        var nameIndex = {}; //数组 name 索引
        layui.each(fieldElem, function(_, item){
            item.name = (item.name || '').replace(/^\s*|\s*&/, '');

            if(!item.name) return;

            //用于支持数组 name
            if(/^.*\[\]$/.test(item.name)){
                var key = item.name.match(/^(.*)\[\]$/g)[0];
                nameIndex[key] = nameIndex[key] | 0;
                item.name = item.name.replace(/^(.*)\[\]$/, '$1['+ (nameIndex[key]++) +']');
            }

            if(/^checkbox|radio$/.test(item.type) && !item.checked) return;
            field[item.name] = item.value;
        });

        //获取字段
        return layui.event.call(this, MOD_NAME, 'submit('+ filter +')', {
            elem: this
            ,form: formElem
            ,field: field
        });
    };

    //自动完成渲染
    var form = new Form()
        ,dom = $(document), win = $(window);

    form.render();

    //表单reset重置渲染
    dom.on('reset', ELEM, function(){
        var filter = $(this).attr('lay-filter');
        setTimeout(function(){
            form.render(null, filter);
        }, 50);
    });

    //表单提交事件
    dom.on('submit', ELEM, submit)
        .on('click', '*[lay-submit]', submit);

    exports(MOD_NAME, form);
});

/** layui-v2.3.0 MIT License By https://www.layui.com */
 ;layui.define("layer",function(e){"use strict";var i=layui.$,t=layui.layer,a=layui.hint(),n=layui.device(),l="form",r=".layui-form",s="layui-this",o="layui-hide",c="layui-disabled",u=function(){this.config={verify:{required:[/[\S]+/,"必填项不能为空"],phone:[/^1\d{10}$/,"请输入正确的手机号"],email:[/^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/,"邮箱格式不正确"],url:[/(^#)|(^http(s*):\/\/[^\s]+\.[^\s]+)/,"链接格式不正确"],number:function(e){if(!e||isNaN(e))return"只能填写数字"},date:[/^(\d{4})[-\/](\d{1}|0\d{1}|1[0-2])([-\/](\d{1}|0\d{1}|[1-2][0-9]|3[0-1]))*$/,"日期格式不正确"],identity:[/(^\d{15}$)|(^\d{17}(x|X|\d)$)/,"请输入正确的身份证号"]}}};u.prototype.set=function(e){var t=this;return i.extend(!0,t.config,e),t},u.prototype.verify=function(e){var t=this;return i.extend(!0,t.config.verify,e),t},u.prototype.on=function(e,i){return layui.onevent.call(this,l,e,i)},u.prototype.val=function(e,t){var a=i(r+'[lay-filter="'+e+'"]');a.each(function(e,a){var n=i(this);layui.each(t,function(e,i){var t,a=n.find('[name="'+e+'"]');a[0]&&(t=a[0].type,"checkbox"===t?a[0].checked=i:"radio"===t?a.each(function(){this.value===i&&(this.checked=!0)}):a.val(i))})}),f.render(null,e)},u.prototype.render=function(e,t){var n=this,u=i(r+function(){return t?'[lay-filter="'+t+'"]':""}()),d={select:function(){var e,t="请选择",a="layui-form-select",n="layui-select-title",r="layui-select-none",d="",f=u.find("select"),v=function(t,l){i(t.target).parent().hasClass(n)&&!l||(i("."+a).removeClass(a+"ed "+a+"up"),e&&d&&e.val(d)),e=null},y=function(t,u,f){var y,p=i(this),m=t.find("."+n),k=m.find("input"),g=t.find("dl"),x=g.children("dd"),b=this.selectedIndex;if(!u){var C=function(){var e=t.offset().top+t.outerHeight()+5-h.scrollTop(),i=g.outerHeight();b=p[0].selectedIndex,t.addClass(a+"ed"),x.removeClass(o),y=null,x.eq(b).addClass(s).siblings().removeClass(s),e+i>h.height()&&e>=i&&t.addClass(a+"up")},w=function(e){t.removeClass(a+"ed "+a+"up"),k.blur(),y=null,e||$(k.val(),function(e){e&&(d=g.find("."+s).html(),k&&k.val(d))})};m.on("click",function(e){t.hasClass(a+"ed")?w():(v(e,!0),C()),g.find("."+r).remove()}),m.find(".layui-edge").on("click",function(){k.focus()}),k.on("keyup",function(e){var i=e.keyCode;9===i&&C()}).on("keydown",function(e){var i=e.keyCode;9===i&&w();var t=function(i,a){var n,l;if(e.preventDefault(),a=function(){return a&&a[0]?a:y&&y[0]?y:x.eq(b)}(),l=a[i](),n=a[i]("dd"),l[0]){if(y=a[i](),!n[0]||n.hasClass(c))return t(i,y);n.addClass(s).siblings().removeClass(s);var r=g.children("dd.layui-this"),o=r.position().top,u=g.height(),d=r.height();o>u&&g.scrollTop(o+g.scrollTop()-u+d-5),o<0&&g.scrollTop(o+g.scrollTop())}};38===i&&t("prev"),40===i&&t("next"),13===i&&(e.preventDefault(),g.children("dd."+s).trigger("click"))});var $=function(e,t,a){var n=0;layui.each(x,function(){var t=i(this),l=t.text(),r=l.indexOf(e)===-1;(""===e||"blur"===a?e!==l:r)&&n++,"keyup"===a&&t[r?"addClass":"removeClass"](o)});var l=n===x.length;return t(l),l},T=function(e){var i=this.value,t=e.keyCode;return 9!==t&&13!==t&&37!==t&&38!==t&&39!==t&&40!==t&&($(i,function(e){e?g.find("."+r)[0]||g.append('<p class="'+r+'">无匹配项</p>'):g.find("."+r).remove()},"keyup"),void(""===i&&g.find("."+r).remove()))};f&&k.on("keyup",T).on("blur",function(t){var a=p[0].selectedIndex;e=k,d=i(p[0].options[a]).html(),setTimeout(function(){$(k.val(),function(e){d||k.val("")},"blur")},200)}),x.on("click",function(){var e=i(this),a=e.attr("lay-value"),n=p.attr("lay-filter");return!e.hasClass(c)&&(e.hasClass("layui-select-tips")?k.val(""):(k.val(e.text()),e.addClass(s)),e.siblings().removeClass(s),p.val(a).removeClass("layui-form-danger"),layui.event.call(this,l,"select("+n+")",{elem:p[0],value:a,othis:t}),w(!0),!1)}),t.find("dl>dt").on("click",function(e){return!1}),i(document).off("click",v).on("click",v)}};f.each(function(e,l){var r=i(this),o=r.next("."+a),u=this.disabled,d=l.value,f=i(l.options[l.selectedIndex]),v=l.options[0];if("string"==typeof r.attr("lay-ignore"))return r.show();var h="string"==typeof r.attr("lay-search"),p=v?v.value?t:v.innerHTML||t:t,m=i(['<div class="'+(h?"":"layui-unselect ")+a,(u?" layui-select-disabled":"")+'">','<div class="'+n+'">','<input type="text" placeholder="'+p+'" '+('value="'+(d?f.html():"")+'"')+(h?"":" readonly")+' class="layui-input'+(h?"":" layui-unselect")+(u?" "+c:"")+'">','<i class="layui-edge"></i></div>','<dl class="layui-anim layui-anim-upbit'+(r.find("optgroup")[0]?" layui-select-group":"")+'">',function(e){var i=[];return layui.each(e,function(e,a){0!==e||a.value?"optgroup"===a.tagName.toLowerCase()?i.push("<dt>"+a.label+"</dt>"):i.push('<dd lay-value="'+a.value+'" class="'+(d===a.value?s:"")+(a.disabled?" "+c:"")+'">'+a.innerHTML+"</dd>"):i.push('<dd lay-value="" class="layui-select-tips">'+(a.innerHTML||t)+"</dd>")}),0===i.length&&i.push('<dd lay-value="" class="'+c+'">没有选项</dd>'),i.join("")}(r.find("*"))+"</dl>","</div>"].join(""));o[0]&&o.remove(),r.after(m),y.call(this,m,u,h)})},checkbox:function(){var e={checkbox:["layui-form-checkbox","layui-form-checked","checkbox"],_switch:["layui-form-switch","layui-form-onswitch","switch"]},t=u.find("input[type=checkbox]"),a=function(e,t){var a=i(this);e.on("click",function(){var i=a.attr("lay-filter"),n=(a.attr("lay-text")||"").split("|");a[0].disabled||(a[0].checked?(a[0].checked=!1,e.removeClass(t[1]).find("em").text(n[1])):(a[0].checked=!0,e.addClass(t[1]).find("em").text(n[0])),layui.event.call(a[0],l,t[2]+"("+i+")",{elem:a[0],value:a[0].value,othis:e}))})};t.each(function(t,n){var l=i(this),r=l.attr("lay-skin"),s=(l.attr("lay-text")||"").split("|"),o=this.disabled;"switch"===r&&(r="_"+r);var u=e[r]||e.checkbox;if("string"==typeof l.attr("lay-ignore"))return l.show();var d=l.next("."+u[0]),f=i(['<div class="layui-unselect '+u[0],n.checked?" "+u[1]:"",o?" layui-checkbox-disbaled "+c:"",'"',r?' lay-skin="'+r+'"':"",">",function(){var e=n.title.replace(/\s/g,""),i={checkbox:[e?"<span>"+n.title+"</span>":"",'<i class="layui-icon layui-icon-ok"></i>'].join(""),_switch:"<em>"+((n.checked?s[0]:s[1])||"")+"</em><i></i>"};return i[r]||i.checkbox}(),"</div>"].join(""));d[0]&&d.remove(),l.after(f),a.call(this,f,u)})},radio:function(){var e="layui-form-radio",t=["&#xe643;","&#xe63f;"],a=u.find("input[type=radio]"),n=function(a){var n=i(this),s="layui-anim-scaleSpring";a.on("click",function(){var o=n[0].name,c=n.parents(r),u=n.attr("lay-filter"),d=c.find("input[name="+o.replace(/(\.|#|\[|\])/g,"\\$1")+"]");n[0].disabled||(layui.each(d,function(){var a=i(this).next("."+e);this.checked=!1,a.removeClass(e+"ed"),a.find(".layui-icon").removeClass(s).html(t[1])}),n[0].checked=!0,a.addClass(e+"ed"),a.find(".layui-icon").addClass(s).html(t[0]),layui.event.call(n[0],l,"radio("+u+")",{elem:n[0],value:n[0].value,othis:a}))})};a.each(function(a,l){var r=i(this),s=r.next("."+e),o=this.disabled;if("string"==typeof r.attr("lay-ignore"))return r.show();s[0]&&s.remove();var u=i(['<div class="layui-unselect '+e,l.checked?" "+e+"ed":"",(o?" layui-radio-disbaled "+c:"")+'">','<i class="layui-anim layui-icon">'+t[l.checked?0:1]+"</i>","<div>"+function(){var e=l.title||"";return"string"==typeof r.next().attr("lay-radio")&&(e=r.next().html(),r.next().remove()),e}()+"</div>","</div>"].join(""));r.after(u),n.call(this,u)})}};return e?d[e]?d[e]():a.error("不支持的"+e+"表单渲染"):layui.each(d,function(e,i){i()}),n};var d=function(){var e=i(this),a=f.config.verify,s=null,o="layui-form-danger",c={},u=e.parents(r),d=u.find("*[lay-verify]"),v=e.parents("form")[0],h=u.find("input,select,textarea"),y=e.attr("lay-filter");if(layui.each(d,function(e,l){var r=i(this),c=r.attr("lay-verify").split("|"),u=r.attr("lay-verType"),d=r.val();if(r.removeClass(o),layui.each(c,function(e,i){var c,f="",v="function"==typeof a[i];if(a[i]){var c=v?f=a[i](d,l):!a[i][0].test(d);if(f=f||a[i][1],c)return"tips"===u?t.tips(f,function(){return"string"==typeof r.attr("lay-ignore")||"select"!==l.tagName.toLowerCase()&&!/^checkbox|radio$/.test(l.type)?r:r.next()}(),{tips:1}):"alert"===u?t.alert(f,{title:"提示",shadeClose:!0}):t.msg(f,{icon:5,shift:6}),n.android||n.ios||l.focus(),r.addClass(o),s=!0}}),s)return s}),s)return!1;var p={};return layui.each(h,function(e,i){if(i.name=(i.name||"").replace(/^\s*|\s*&/,""),i.name){if(/^.*\[\]$/.test(i.name)){var t=i.name.match(/^(.*)\[\]$/g)[0];p[t]=0|p[t],i.name=i.name.replace(/^(.*)\[\]$/,"$1["+p[t]++ +"]")}/^checkbox|radio$/.test(i.type)&&!i.checked||(c[i.name]=i.value)}}),layui.event.call(this,l,"submit("+y+")",{elem:this,form:v,field:c})},f=new u,v=i(document),h=i(window);f.render(),v.on("reset",r,function(){var e=i(this).attr("lay-filter");setTimeout(function(){f.render(null,e)},50)}),v.on("submit",r,d).on("click","*[lay-submit]",d),e(l,f)});