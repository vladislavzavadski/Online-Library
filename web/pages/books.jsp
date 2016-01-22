<%-- 
    Document   : books
    Created on : 19.01.2016, 21:54:21
    Author     : Владислав
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.library.book.Book"%>
<%@page import="com.library.book.BookList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../WEB-INF/jspf/left_menu.jspf"%>
<%@include file="../WEB-INF/jspf/letters.jspf" %>
<!DOCTYPE html>
<%request.setCharacterEncoding("UTF-8");%>
<div id="text3" style="position:absolute; overflow:hidden; left:610px; top:240px; width:300px; height:34px; z-index:7">
<div class="wpmd">
    

<%
 BookList bookList = new BookList();
 ArrayList<Book> booklist =null;
 if(request.getParameter("id")!=null){
    long id = Long.valueOf(request.getParameter("id"));
    booklist = bookList.getBooksByGenre(id);
 }
 if(request.getParameter("letter")!=null){
     booklist = bookList.getBooksByLetter(request.getParameter("letter"));
 }
 if(request.getParameter("searchLine")!=null){
     booklist = bookList.getBooksBySearch(request.getParameter("searchLine"), Integer.parseInt(request.getParameter("search_type")));
 }
 session.setAttribute("bookArrayList", booklist);
%>

<div><font color="#800000" face="Times New Roman" class="ws22"><I>Результатов: <%=booklist.size()%></I></font></div>
</div></div>
<%
 for(int bookNum = 0; bookNum<booklist.size(); bookNum++){
%>
<div id="text2" style="position:absolute; overflow:hidden; left:370px; top:<%=310+bookNum*200%>px; width:510px; height:300px; z-index:5">
<div class="wpmd">
<div align=center><font color="#3366FF" face="Times New Roman" class="ws16"><I>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <%=booklist.get(bookNum).getName()%></I></font></div>
<div align=center><font color="#3366FF" face="Times New Roman" class="ws16"><I><BR></I></font></div>
<div><font color="#800000" face="Times New Roman" class="ws14">ISBN: </font><font color="#FF0000" face="Times New Roman" class="ws14"><I><%=booklist.get(bookNum).getIsbn()%></I></font></div>
<div><font color="#800000" face="Times New Roman" class="ws14">Издательство: </font><font color="#FF0000" face="Times New Roman" class="ws14"><I><%=booklist.get(bookNum).getPublisher()%></I></font></div>
<div><font color="#800000" face="Times New Roman" class="ws14">Количество страниц: </font><font color="#FF0000" face="Times New Roman" class="ws14"><I><%=booklist.get(bookNum).getPageCount()%></I></font></div>
<div><font color="#800000" face="Times New Roman" class="ws14">Дата издания: </font><font color="#FF0000" face="Times New Roman" class="ws14"><I><%=booklist.get(bookNum).getPublishDate()%></I></font></div>
<div><font color="#800000" face="Times New Roman" class="ws14">Автор: </font><font color="#FF0000" face="Times New Roman" class="ws14"><I><%=booklist.get(bookNum).getAuthor()%></I></font></div>
<div><font color="#0000FF" face="Times New Roman" class="ws14"><U><I>Читать</U></I></font></div>
</div></div>

<div id="image2" style="position:absolute; overflow:hidden; left:920px; top:<%=340+bookNum*200%>px; width:178px; height:300px; z-index:6"><img src="<%=request.getContextPath()%>/ImageServlet?index=<%=bookNum%>" alt="" title="" border=0 width=178 height=141></div>
<%}%>


