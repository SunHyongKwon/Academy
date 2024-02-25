<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%!
		public String result(String height, String weight){
		
		String str = "입력한 키는 " + height + " 이고 <br>" + "입력한 몸무게는 " + weight + "이므로 <br>";
		
		double hei = Double.parseDouble(height);
		double wei = Double.parseDouble(weight);
		double bmi = wei / ((hei/100) *(hei/100));
			
		str += "당신의 bmi 수치는 " + String.format("%.2f",bmi) + " 이며<br> 결과는 ";
		
		if(bmi >= 30){
			// 고도비만
			str += "고도비만 입니다.<br>";
			str += "<input type = \"image\" src = \"bmi/고도비만.png\" width=\"500\" height=\"500\">" ;
		}else if(bmi >= 25){
			// 비만
			str += "비만 입니다.<br>";
			str += "<input type = \"image\" src = \"bmi/비만.png\" width=\"500\" height=\"500\">" ;
		}else if(bmi >= 23){
			// 과체중
			str += "과체중 입니다.<br>";
			str += "<input type = \"image\" src = \"bmi/과체중.png\" width=\"500\" height=\"500\">" ;
		}else if(bmi >= 18.5){
			// 정상체중
			str += "정상체중 입니다.<br>";
			str += "<input type = \"image\" src = \"bmi/정상체중.png\" width=\"500\" height=\"500\">" ;
		}else if(bmi >= 0){
			// 저체중
			str += "저체중 입니다.<br>";
			str += "<input type = \"image\" src = \"bmi/저체중.png\" width=\"500\" height=\"500\">" ;
		}else{
			// 사람 아님
			str += "사람이 아닙니다.<br>";
			str += "<input type = \"image\" src = \"bmi/노사람.png\" width=\"500\" height=\"500\">" ;
		}
		return str;
	}
	%>
	
	<%=result(request.getParameter("height"),request.getParameter("weight")) %>
</body>
</html>