use test;

select count(distinct name) as num_of_employee from employee_tbl; # 근무하는 직원 수

select name, count(*) from employee_tbl group by name; # 일한 날짜

# 이 회사는 타이핑을 하는 회사라는 것을 알 수 있었다.
# 170 페이지 , 220 페이지, 250 페이지 작성한 열 출력
select * from employee_tbl
where daily_typing_pages = 170 or daily_typing_pages = 220 or daily_typing_pages = 250;

# 위의 문장과 같은 의미이지만 간결하게 쓸 수 있는 방법
select * from employee_tbl
where daily_typing_pages in (250,220,170);

# 170 페이지 이상 치고 300 페이지 아하로 친 열 출력
select * from employee_tbl
where daily_typing_pages >= 170 and daily_typing_pages <= 300;

# 위의 문장과 같은 의미이지만 간결하게 쓸 수 있는 방법
select * from employee_tbl
where daily_typing_pages between 170 and 300;

# union 사용법
select fname , lname , addr from prospect
union
select first_name, last_name , address from customer
union
select company,'',street from vendor;

# 잠재고객중에 고객이 됐는지 안됐는지
select a.first_name, a.last_name
from customer a, prospect b
where a.first_name = b.fname and a.last_name = b.lname;

# 직원 중에 제일 많이 타이핑한 페이지가 무엇인지
select max(daily_typing_pages) from employee_tbl;

# 직원 중에서 이름별로 최소 타이핑 페이지를 출력한다.( id , name, typing pages)
select name , min(daily_typing_pages)
from employee_tbl
group by  name;







 




