use subway;

insert into menu
(name, price,length)
values
('eggmayo',3000,15),
('eggmayo',5000,30);

insert into menu
(name, price, length)
values
('bmt',4000,15),
('bmt',7000,30);

select * from menu;

select * from choose;

# 메뉴 테이블의 가격을 choose 테이블로 옮겨 온다. 
update choose c, menu m set c.price = m.price where c.menu_no1 = m.no;

# add가 된게 있는지 확인을 한다. add 항목 별로 다 한다. 
select count(addmeat)
from choose
where no = 1;

# 이 처럼 추가 항목이 있다면 이걸 pay에 insert 할 때 올려준다. 
select count(addeggmayo)
from choose 
where no = 1;
