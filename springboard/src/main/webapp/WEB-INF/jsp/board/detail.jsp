<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.12.4.min.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>

<script>

/*  $(document).ready(function(){
		$(document).on('click','delBtn',function(){
		
			//
			let replyNo = $(this).attr('id');
			console.log(replyNo);
			
			
		})
		
		
		
	})
 */




	$(document).ready(function(){	
		
		$(document).on('click','.delBtn',function(){
			
			//
			let replyNo = $(this).attr('id');
			console.log(replyNo);
			//url 은 /reply/3/15
				$.ajax({
				url : '${pageContext.request.contextPath}/reply/${boardNo}/'+replyNo,
				method : 'delete',
				
			success: function(){
				alert('성공');
				//댓글 보여줘
				getAllReply();
				
			},
			error: function(){
				alert('실패');
				
			},
			complete : function(){
				r_content=' ';
				r_writer=' ';
				
			}					
			})
			
				
		}) 
		
		getAllReply();
		
		console.log("hhh");
		$('#AddReplyBtn').click(function(){
			let r_content = document.rform.content.value;
			let r_writer = document.rform.writer.value;
			console.log(r_content);
			console.log(r_writer);
			$.ajax({
				url : '${pageContext.request.contextPath}/reply' ,
				method : 'post',
				data: {
					boardNo: ${board.no},
					content: r_content,
					writer: r_writer
			},
			success: function(){
				alert('성공');
				//댓글 보여줘
				getAllReply();
				
			},
			error: function(){
				alert('실패');
				
			},
			complete : function(){
				r_content=' ';
				r_writer=' ';
				
			}
				/*complete는 finally같은 역할임  */
						
			})
		
		})

	})	
	
	
	function getAllReply(){
		$('#replyList').empty();
		
		$.ajax({
			url	: '${pageContext.request.contextPath}/reply/${board.no}',
			type : 'get',
			success : function(data){
				console.log(typeof data);
				console.log(data);
				let list = JSON.parse(data);
				console.log(list)
				$(list).each(function(){
					let str = ' '
				
					str +='<hr>'
					str +='<div>'
					str += this.content + ' '
					str += this.writer + ' '
					str += this.regDate + ' '
					str += '<button class="delBtn" id=' + this.no + '> 삭제</button>'
					str += '</div>'
					$('#replyList').append(str)
				})
				
			},
			error : function(){
				alert('실패');
				
			}

			
			
		})
		
		
		
	}
	
	
	
	
</script>



</head>
<body>

<header>
	<jsp:include page="/WEB-INF/jsp/include/topMenu.jsp"></jsp:include>
</header>
	
boardno${board.no}	
	<table>
		<tr>
			<th>작성자</th>
			<td>${board.writer }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${board.title }</td>
		</tr>
		<tr>
			<th>등록일</th>
			<td>${board.regDate }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>${board.content }</td>
		</tr>
	
	</table>
	<form action="${pageContext.request.contextPath}/reply" method="post" name="rform">	
		댓글 : <input type="text" size="30" name="content">
		작성자:<input type="text" size="20" name="writer"> 	
		<input type="button" value="댓글작성해봐" id ="AddReplyBtn">
	</form>
	
	<div id="replyList"></div>
	



</body>
</html>