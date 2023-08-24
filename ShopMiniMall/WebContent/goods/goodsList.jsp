<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<%@page import="com.dto.GoodsDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<table width="100%" cellspacing="0" cellpadding="0">
	<tr>
		<td>
			<table align="center" width="710" cellspacing="0" cellpadding="0"
				border="0">
				
				<tr>
					<td height="5"></td>
				</tr>
				<tr>
					<td height="1" colspan="8" bgcolor="CECECE"></td>
				</tr>
				<tr>
					<td height="10"></td>
				</tr>

				<tr>
						
<!--  for 시작 -->
<!-- JSTL 버전 -->
<c:forEach var="dto" items="${goodsList}" varStatus="status">
	<c:set var="gCode" value="${dto.gCode}" />
	<c:set var="gName" value="${dto.gName}" />
	<c:set var="gCategory" value="${dto.gCategory}" />
	<c:set var="gContent" value="${dto.gContent}" />
	<c:set var="gPrice" value="${dto.gPrice}" />
	<c:set var="gImage" value="${dto.gImage}" />

						<td>
							<table style='padding:15px'>
								<tr>
									<td>
										<a href="GoodsRetrieveServlet?gCode=${gCode}"> 
											<img src="images/items/${gImage}.gif" border="0" align="center" width="200">
										</a>
									</td>
								</tr>
								<tr>
								
									<td height="10">
								</tr>
								<tr>
									<td class= "td_default" align ="center">
										<a class= "a_black" href="GoodsRetrieveServlet?gCode=${gCode}"> 
										${gName }<br>
										</a>
										<font color="gray">
										 --------------------
										</font>
									</td>
									
								</tr>
								<tr>
									<td height="10">
								</tr>
								<tr>
									<td class="td_gray" align ="center">
										${gContent}
									</td>
								</tr>
								<tr>
									<td height="10">
								</tr>
								<tr>
									<td class="td_red" align ="center"><font color="red"><strong>
									${gPrice }	</strong></font></td>
								</tr>
							</table>
						</td>

  					
  					        
  						<!-- if 시작 -->
  						<c:if test="${status.count%4==0}">
  						
						            <tr>
								<td height="10">
							</tr>
						</c:if>					
		                <!-- if 끝 -->

</c:forEach>
<!--  for 끝 -->
			</table>
		</td>
	</tr>
	<tr>
		<td height="10">
	</tr>
</table>