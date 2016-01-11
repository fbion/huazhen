<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/4/10
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <div class="row">
            <div style="position: absolute;left: 300px">
                <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0" width="500" height="400">
                    <param name="movie" value="${message}">
                    <param name="align" value="middle">
                    <param name="quality" value="high">
                    <param name="menu" value="false">
                    <param name="wmode" value="opaque">
                    <param name="FlashVars" value="vcastr_file=${filePath}&vcastr_title=video&vcastr_config=0:自动播放|1:连续播放|100:默认音量|0:控制栏位置|2:控制栏显示|0x000033:主体颜色|60:主体透明度|0x66ff00:光晕颜色|0xffffff:图标颜色|0xffffff:文字颜色|:logo文字|:logo地址|:结束swf地址">
                    <embed wmode="opaque" src="${message}" width="600" height="400" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" quality="high" menu="false" flashvars="vcastr_file=${filePath}&vcastr_title=video&vcastr_config=0:自动播放|1:连续播放|100:默认音量|0:控制栏位置|2:控制栏显示|0x000033:主体颜色|60:主体透明度|0x66ff00:光晕颜色|0xffffff:图标颜色|0xffffff:文字颜色|:logo文字|:logo地址|:结束swf地址">
                </object>
            </div>
</div>
