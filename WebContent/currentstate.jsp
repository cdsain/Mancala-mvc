<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type='text/css' href='css/opmaak.css' rel='stylesheet'>
<title>Mancala</title>
</head>
<body>
	<form method ="post" action="/MancalaWeb2/MancalaServlet.html">
	<div id="Player1">
		<c:forEach var="i" begin="0" end="5">
   				<button class = "FieldButtonsPlayer1" name = "${i}" value="${i}">${currentState.stones[i]} </button>
		</c:forEach>
  		 <button class = "kalaha" id = "KalahaButtonPlayer1" name = "6" value="${i}">${currentState.stones[6]} </button>
	</div> 
</form>
<form method ="post" action="/MancalaWeb2/MancalaServlet.html">
	<div id="Player2">
			<c:forEach var="i" begin="7" end="12">
   				<button class = "FieldButtonsPlayer2" name = "${i}" value="${i}">${currentState.stones[i]} </button>
			</c:forEach>
   		<button class = "kalaha" id= "KalahaButtonPlayer2" name = "13" value="${i}">${currentState.stones[13]} </button>
	</div>
</form>
<div class = "showWinner">
<c:choose>
    <c:when test="${currentState.winner == 'No_Decision'}">
        The game is not decided yet.
    </c:when>
    <c:when test="${currentState.winner == 'Player1'}">
        Congratulations Player 1, You Win!
    </c:when>   
    <c:when test="${currentState.winner == 'Player2'}">
        Congratulations Player 2, You Win!
    </c:when>   
    <c:when test="${currentState.winner == 'Draw'}">
        The game ended in a draw!
    </c:when>       
</c:choose>
</div>
<div class = "showPlayer">
It is player <c:out value="${currentState.turn}" />'s turn
</div>
</body>
</html>