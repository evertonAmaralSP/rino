(function(){
  var disabled = false;

  var getWindowSize = function() {
    /* code from:
       http://www.geekdaily.net/2007/07/04/javascript-cross-browser-window-size-and-centering/
    */
    var w = 0, h = 0;
    if(!window.innerWidth) { //ie
      if(!(document.documentElement.clientWidth == 0)) { //strict mode
        w = document.documentElement.clientWidth;
        h = document.documentElement.clientHeight;
      } else { //quirks mode
        w = document.body.clientWidth;
        h = document.body.clientHeight;
      }
    } else { //w3c
      w = window.innerWidth;
      h = window.innerHeight;
    }

    return {width:w, height:h};
  };

  var getCursorPosition = function(e) {
    /* code from:
       http://www.quirksmode.org/js/events_properties.html#position
    */
    var posx = 0, posy = 0;
    if (!e) var e = window.event;
    if (e.pageX || e.pageY) {
      posx = e.pageX;
      posy = e.pageY;
    }
    else if (e.clientX || e.clientY) {
      posx = e.clientX + document.body.scrollLeft + document.documentElement.scrollLeft;
      posy = e.clientY + document.body.scrollTop + document.documentElement.scrollTop;
    }

    return {x: posx, y: posy};
  };

  var getAttr = function(elm, attr) {
      var result = elm.getAttribute(attr) || elm[attr] || null;
      if(!result) {
          var attrs = elm.attributes;
          var length = attrs.length;
          for(var i = 0; i < length; i++)
              if(attr[i] && attr[i].nodeName === attr)
                  result = attr[i].nodeValue;
      }
      return result;
  };

  var buildQueryString = function(elm, image, pos, size) {
    params = "";

    if(image) {
      params += "image=" + encodeURIComponent(image);
    } else {
      params += "content=" + encodeURIComponent((elm.innerText || elm.textContent).substr(0, 300));
    }

    var href = getAttr(elm, 'href');
    if(href) { params += "&href=" + encodeURIComponent(href); }

    var title = getAttr(elm, 'title');
    if(title) { params += "&title=" + encodeURIComponent(title.substr(0, 300)); }

    var rel = getAttr(elm, 'rel');
    if(rel) { params += "&rel=" + encodeURIComponent(rel.substr(0, 100)); }

    params += "&x=" + pos.x;
    params += "&y=" + pos.y;
    params += "&width=" + size.width;
    params += "&height=" + size.height;
    params += "&ts=" + (new Date().getTime());

    return params;
  };

  var mouseDown = function(e) {
    if(disabled) { return; }

    var pos =  getCursorPosition(e),
        size = getWindowSize(),
        target = e.target || e.srcElement;

    if(!target) { return; }

    if(target.nodeName == 'IMG') {
      var image = target.src
    }

    while(target.parentNode != null && target.nodeName != 'A') {
      target = target.parentNode;
    }

    if(target.nodeType == 1) {
      var params = buildQueryString(target, image, pos, size);
      var img = new Image();
      img.src = "http://local.rino.abril.com.br/click?" + params;
    }

    disabled = true;
    setTimeout(function delay() {
      disabled = false;
    }, 500);
  };

  var initEvents = function() {
    if (document.addEventListener) {
        document.addEventListener('mousedown', mouseDown, false);
        return;
    } else if (document.attachEvent) {
        document.attachEvent('onmousedown', mouseDown);
    }
  };

  var init = function() {
    initEvents();
  };

  init();
})()
