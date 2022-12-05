<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bbs.BbsDAO" %>
<%@ page import="meet.MeetDAO" %>
<%@ page import="java.io.PrintWriter" %>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="bbs" class="bbs.Bbs" scope="page" />
<jsp:setProperty name="bbs" property="bbsTitle" />
<jsp:setProperty name="bbs" property="bbsContent" />
<jsp:useBean id="meet" class="meet.Meet" scope="page" />
<jsp:setProperty name="meet" property="meetTitle" />
<jsp:setProperty name="meet" property="meetDate" />
<jsp:setProperty name="meet" property="meetPlace" />
<jsp:setProperty name="meet" property="maxcount" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>다목적 모임 웹 사이트</title>
</head>
<body>
	<%
		String userID = null;
		if(session.getAttribute("userID") != null){
			userID = (String) session.getAttribute("userID");
		}
		if(userID == null){
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('로그인을 하세요.')");
			script.println("location.href = 'login.jsp'");
			script.println("</script>");
		}else{
			if(bbs.getBbsTitle() == null || bbs.getBbsContent() == null){
						PrintWriter script = response.getWriter();
						script.println("<script>");
						script.println("alert('입력이 안 된 사항이 있습니다.')");
						script.println("history.back()");
						script.println("</script>");
					} 
			else{
						BbsDAO BbsDAO = new BbsDAO();
						MeetDAO MeetDAO = new MeetDAO();
						int result;
						String category="글";
						if(meet.getMeetDate() != null)
						{
							category = "모임";
						}
						int bbsid = BbsDAO.getNext();
						result = BbsDAO.write(bbs.getBbsTitle(), userID, bbs.getBbsContent(),category);
						
						if(meet.getMeetDate() != null && meet.getMeetTitle() != null && meet.getMeetPlace() != null && meet.getMaxcount() != 0)
						{
							result = MeetDAO.write(bbsid, meet.getMeetDate(), meet.getMeetTitle(), meet.getMeetPlace(),meet.getMaxcount());
						}
						
						if(result == -1){
							PrintWriter script = response.getWriter();
							script.println("<script>");
							script.println("alert('글쓰기에 실패했습니다.')");
							script.println("history.back()");
							script.println("</script>");
						}
						else{
							PrintWriter script = response.getWriter();
							script.println("<script>");
							script.println("location.href = 'bbs.jsp'");
							script.println("</script>");
						}
					}	
		
		}
	%>
</body>
</html>