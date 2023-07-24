# 1번 sql 문장
# 0이면 로그인 안되고, 1이면 로그인 된다. 
select count(id and password)
from guest
where id = 'mikekwon23' and password = 'tnstjd12';

# 2번 sql 문장
# 0이면 생성할 수 있고, 1이면 생성할 수 없는 것 
select count(id)
from guest
where id = 'asdfgsadf';

# 3번 sql 문장
# 텍스트 필드에 넣은 값들 안에 넣어서 버튼 누를 시에 데이터 베이스에 들어오게
insert into guest
(id, password, address, name, phone, email, init_date)
values
('dldlmam','aosdjf','경기도 부천','오늘도','010-423-2485','dkaf@naver.com',now());
