use madang;
# 1. 도서번호가 1인 도서의 이름
select * from book where bookid = 1;

# 2. 가격이 20,000원 이상인 도서의 이름
select * from book where price >= 20000;

# 3. 고객별로 총 구매액은 얼마인가? 
select c.name ,sum(o.saleprice) as 판매_금액
from customer c, orders o
where o.custid = c.custid
group by c.name;

# 4. 고객이 구매한 도서의 수는? 
select c.name , count(o.bookid) as 구매한_도서의_수
from customer c, orders o
where o.custid = c.custid
group by c.name;

# 5. 고객이 구매한 도서의 출판사 수는? 
select c.name , count(distinct(b.publisher)) as 출판사_수
from customer c, orders o, book b 
where o.custid = c.custid and o.bookid = b.bookid
group by c.custid;

# 6. 고객이 구매한 도서의 이름 가격, 정가와 판매가격의 차이를 출력하는 문장을 작성하시오. 
select c.name , b.price, o.saleprice, b.price - o.saleprice
from customer c, book b, orders o
where o.custid = c.custid and b.bookid = o.bookid;

# 7. 고객이 구매한 도서의 총 가격과 그것들의 정가 그리고 판매가격의 차이를 출력하는 문장을 작성하시오. 
select c.name, 
sum(b.price) as total_list_price, sum(o.saleprice) as total_sale_price, 
sum(b.price - o.saleprice) as total_discounted_amount
from customer c, book b, orders o
where o.custid = c.custid and b.bookid = o.bookid
group by c.custid;

# 8. 마당 도서의 총 갯수는?
select count(bookid) from book;

# 9. 모든 고객의 이름, 주소 출력하기
select name, address from customer;

# 10. 2014년 7월 4일 부터 7월 7일 사이에 주문 받은 도서의 주문번호 출력
select orderid
from orders
where date(orderdate) between '2014-07-04' and '2014-07-07';

# 11. 2014년 7월 4일 부터 7월 7일 사이에 주문 받은 도서를 제외한 주문번호 출력
select orderid
from orders
where date(orderdate) not between '2014-07-04' and '2014-07-07';

# 12. 성이 김씨인 고객의 이름과 주소를 출력
select name , address
from customer 
where name like '김%';

# 13. 성이 김씨이고 이름이 아로 끝나는 고객의 이름과 주소를 출력
select name, address
from customer
where name like '김%아';

# 14. 주문하지 않은 고객의 이름을 출력
select c.name from customer c
where c.name not in (
select distinct c.name from orders o 
where c.custid = o.custid);

# 15. 주문 금액의 총액과 주문의 평균 금액
select sum(saleprice) as total , avg(saleprice) as average from orders;

# 16. 고객의 이름과 고객별 구매액 출력하기
select c.name , sum(o.saleprice)
from customer c, orders o
where c.custid = o.custid
group by c.custid;

# 17. 고객의 이름과 고객이 구매한 도서 목록 출력하기
select c.name , b.bookname
from customer c, orders o , book b
where c.custid = o.custid and o.bookid = b.bookid
order by c.name;

# 18. 


