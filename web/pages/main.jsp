<%@page import="com.library.genre.Genre"%>
<%@page import="com.library.genre.GenreList"%>
<%@page import="com.library.author.Author"%>
<%@page import="com.library.author.AuthorList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Online Библиотека</title>
<meta http-equiv="content-type" content="text/html; charset=iso-8859-1">
<meta name="generator" content="Web Page Maker">
<style type="text/css">
/*----------Text Styles----------*/
.ws6 {font-size: 8px;}
.ws7 {font-size: 9.3px;}
.ws8 {font-size: 11px;}
.ws9 {font-size: 12px;}
.ws10 {font-size: 13px;}
.ws11 {font-size: 15px;}
.ws12 {font-size: 16px;}
.ws14 {font-size: 19px;}
.ws16 {font-size: 21px;}
.ws18 {font-size: 24px;}
.ws20 {font-size: 27px;}
.ws22 {font-size: 29px;}
.ws24 {font-size: 32px;}
.ws26 {font-size: 35px;}
.ws28 {font-size: 37px;}
.ws36 {font-size: 48px;}
.ws48 {font-size: 64px;}
.ws72 {font-size: 96px;}
.wpmd {font-size: 13px;font-family: Arial,Helvetica,Sans-Serif;font-style: normal;font-weight: normal;}
/*----------Para Styles----------*/
DIV,UL,OL /* Left */
{
 margin-top: 0px;
 margin-bottom: 0px;
}
</style>

</head>
<body>
<div id="image1" style="position:absolute; overflow:hidden; left:56px; top:9px; width:234px; height:169px; z-index:0"><img src="images/logo.jpg" alt="" title="" border=0 width=234 height=169></div>

<div id="text1" style="position:absolute; overflow:hidden; left:354px; top:50px; width:858px; height:98px; z-index:1">
<div class="wpmd">
<div><font color="#FF6600" face="Wide Latin" class="ws48"><I>Online Library</I></font></div>
</div></div>

<input name="searchLine" type="text" style="position:absolute;width:443px;left:365px;top:179px;z-index:2">
<input name="searchButton" type="submit" value="Найти" style="position:absolute;left:830px;top:179px;z-index:3">
<select name="formselect1" style="position:absolute;left:907px;top:179px;width:200px;z-index:4">
<option value="0">Автор</option>
<option value="1">Книга</option>
</select>
<div id="text2" style="position:absolute; overflow:hidden; left:90px; top:280px; width:158px; height:63px; z-index:5">
<div class="wpmd">
<div><font color="#FF6600" face="Times New Roman" class="ws28"><I>Жанр:</I></font></div>
</div></div>
<%  GenreList list = new GenreList();
    int i = 0;
    String k;
    
    for(Genre temp: list.getGenrelist()){%>
<div id="text3" style="position:absolute; overflow:hidden; left:90px; top:<%=335+35*i%>px; width:507px; height:46px; z-index:6">
<div class="wpmd">
    <a href="#"><div><font color="#FF0000" face="Times New Roman" class="ws18"><%=temp.getName().charAt(0)%></font><font color="#000000" face="Times New Roman" class="ws18"><%=temp.getName().substring(1)%></font></div></a>
</div></div>
<%i++;}%>

</body>
</html>
