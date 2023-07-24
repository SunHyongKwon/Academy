use shoes_project;

# 12번 메소드 해결법
# cart에 있는 목록들을 pay table에 insert 해준다. 닉네임에 맞게
insert into
pay
(p_guest_id,pd_detail_no,pd_product_no,date,time,amount,price)
select c_guest_id,cd_detail_no,cd_product_no,curdate(),curtime(),amount,price 
from cart
where c_guest_id = 'mikekwon' and order_date is null;

# cart table에 order date를 업데이트 해준다. 
update cart set order_date = now() where c_guest_id = 'mikekwon' and order_date is null;

select * from pay;
