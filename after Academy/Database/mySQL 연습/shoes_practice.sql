use shoes;
select * from product;
select * from customer;
select * from orders;

# 제품 등록 및 수정 하기  
insert into product
(code, count, price, brand, date)
values
('balance black',40,250000,'new balance','2022-08-15');

insert into product
(code, count, price, brand)
values
('nike white air',30,230000,'new balanace'),
('proactive',30,100000,'prospecs');

update product set code = 'nike white air' , count = 30 where code = 'nike air';

update product set price = 100000 where code = 'proactive';

alter table product auto_increment = 4;

update product set count = 20 , date = '2022-03-01' where brand = 'prospecs';

update product set count = count + 50 where brand = 'prospecs';

# 유저 등록 및 수정
insert into customer
(code,name,password,phone,date)
values
('yubee','유비','1234','010-1111-2222','2022-09-28');

insert into customer
(code,name,password,phone,date)
values
('kwanwoo','관우','2234','010-1111-2223','2022-09-29'),
('jangbee','장비','3234','010-1111-2224','2022-09-30');

update customer set password = '8978' ,date = curdate() where code = 'yubee';
update customer set changedate = curdate() where code = 'yubee';
update customer set deletedate = curdate() where code = 'jangbee';

# 고객의 id와 password를 확인하여 로그인 확인 과정
# count값이 1이면 통과 0이면 틀렸다.
select count(*)
from customer 
where code ='yoobee' and password = '2222';

select count(*)
from customer 
where code = 'yubee' and password = '8978';

# 신발 정보 목록 보여주기 
# orders에 제품에 대한 주문이 없으면 표에 나타나지 않는 문제가 있다. 이걸 해결하면 재고를 업데이트 하지 않아도 된다.
# 해결방안
# 재고는 이렇게 관리하는 것이 아니다. 업데이트를 통해서 재고를 줄여나가는 것이 맞는 것이다.
# 재고는 그대로 유지하고, orders.amount를 빼서 보여주는 것은 수행능력 측면에서 좋지 않다. (조건이 많아지고, join도 들어가기 때문에)
# 만약 이런 식으로 하고 싶다면 temporary table을 만들어서 product.code , product.count - sum(orders.amount)를 
# column으로 받아서 검색을 통해서만 처리해 주면 된다. 
# 그럼 주문한 개수는 왜 알아야 되는가? 는 재고가 0이 되거나 없을 때 더블 체크하기 위한 용도 + 재고에서 뺏을 때 체크하기 위한 용도
# 라고 생각하면 된다.
select p.model, p.count , p.count - sum(o.amount) as remaining_product
from product p , orders o
where p.code = o.product_code or product in #(select product.code 
											#from product 
											#where not product.code = orders.product_code);

# 유비가 현재일자에 nike 제품 5개를 구매했다. 결과값으로 결재금액을 보여주자. 
# 일단 5개 구매했다는 order를 넣어야 한다. 
insert into orders
(amount, product_code, orderprice , date, time,customer_code)
values
(5, 2 , 230000 , curdate() , curtime(),'yubee');

select orderprice * amount as 결재금액 
from orders
where customer_code = 'yubee';

# 궁금증 -> 지금 product_code랑 orderprice와 customer_code를 내가 직접 넣었는데 이 부분은 애플리케이션에서 받아와서 하는 것이 맞는지
# 해결함 -> 이건 코드로 값을 받아오는 거임

# 유비가 현재일자에 prospecs 제품 2개 구매했음 
# 유비가 현재일자에 new balance 제품 3개 구매했음
insert into orders
(amount, product_code, orderprice , date, time,customer_code)
values
(2, 3 , 100000 , curdate() , curtime(),'yubee');

insert into orders
(amount, product_code, orderprice , date, time,customer_code)
values
(3, 1 , 250000 , curdate() , curtime(),'yubee');

# 장비가 탈퇴 했는데 로그인 시도
select count(*)
from customer 
where code ='jangbee' and password = '3234' and deletedate is null;

# 관우가 현재일자에 new balance 제품 5개 구매했음
# 제품수를 5로 바꾸는 것을 까먹어서 3개 사고 2개 더 산걸로 했음 
insert into orders
(amount, product_code, orderprice , date, time,customer_code)
values
(3, 1 , 250000 , curdate() , curtime(),'kwanwoo');
insert into orders
(amount, product_code, orderprice , date, time,customer_code)
values
(2, 1 , 250000 , curdate() , curtime(),'kwanwoo');

# 현재 일자 판매금액의 합은?
select sum(orderprice * amount) as 판매금액
from orders	
where date = curdate();

# 고객 id 별 매출금액을 매출금액 순으로 출력하기 
select c.code, sum(o.orderprice * o.amount) as sale_price
from orders	o , customer c
where c.code = o.customer_code
group by c.code
order by sale_price desc;

# 제품별 매출금액 순으로 출력
select p.model, sum(o.orderprice * o.amount) as sale_price
from orders	o , product p
where p.code = o.product_code
group by p.code
order by sale_price desc;
