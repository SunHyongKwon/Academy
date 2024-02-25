use education;

# 검색하기
SELECT * FROM professor; # 데이터 전체 불러오기 
select count(*) from professor where pdept = '컴퓨터공학과' and paddress = '서울'; #조건을 걸어서 그것에 해당되는 전체 열 불러오기


#데이터 입력하기
insert into professor
(pcode, pname, pdept, pphone)
values
('p002','안창호','컴퓨터공학과','0002'),
('p003','이육사','국문학과','0003'),
('p004','박종화','국문학과','0004');

# 수정하기
update professor set paddress = '서울' where pcode = 'p001';
update professor set paddress = '대전'
where pcode = 'p004';
update professor set paddress = '서울', pphone = '0011' where pcode = 'p001';

# 삭제하기
delete from professor where pcode = 'p001';

# 연산 할 때나 쓸모있는 method
select sqrt(3); # root
select sin(45); # sin 45도
select rand(); # 랜덤
select * from employee_tbl order by rand();
select concat(id, name, workdate) from employee_tbl; # 주어진 열을 하나의 열로 합치는 것이 concat()

select adddate('2022-01-12', 31); #addadate(날짜, 숫자) -> 날짜에 숫자만큼 더해진 날짜를 계산해 준다.
select curdate(); # 현재 날짜 가져온다. 
select curdate() + 1;
select curtime(); # 현재 시간 가져온다.
select curtime() + 60; # 초만큼의 숫자 추가
select datediff('2022-01-01',curdate()); # 날짜의 차이를 계산한다.
select dayname('2022-09-28'); # 무슨 요일인지
select now(); # 날짜와 시간을 모두 알려준다. 

select abs(-2); # 절대값
select ceiling(3.46); # 올림
select floor(7.55); # 버림
select truncate(5.60887,2); # 소수점 2째짜리까지 버림
select mod(29,3); # 나머지 값
select power(3,3); # 몇의 몇 승
select round(5.6); # 반올림
select round(5.60887, 2); #소수점 2째자리까지 보이게 반올림

select left('abcde',3); # 왼쪽에서 3번째까지만 표시
select right('abcde',3); # 오른쪽에서 3번째까지만 표시
select trim('       a bc         '); # 앞뒤의 공백 제거
select strcmp('abc','def'); # 두개의 문자열을 비교해서 같으면 0 , 다르면 -1
select strcmp('abc','abc');
select substring('abcdef',2); # 2번째 문자부터 표시
select substring('abcdefghi',3, 5); # 3번째부터 길이가 5인 문자열까지만 표시

select trim(both 'x' from 'xxxapplexxx'); # x라는 문자를 xxxapplexxx 에서 지운다. 
select trim(leading 'x' from 'xxxapplexxx'); # 앞에 x라는 문자 말고 다른 문자가 나올 때까지 x를 지운다. 
select trim(trailing 'x' from 'xxxapplexxx'); # 뒤에 x라는 문자 말고 다른 문자가 나올 때까지 x를 지운다. 



