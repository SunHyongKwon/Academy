use education;

# 전체 교수 리스트를 출력 하시오 
select * from professor;
select count(*) from professor where paddress = '서울';

# 전체 교수 리스트를 이름 오름차순으로 정렬하여 출력하기
select * from professor order by pname asc; # asc은 default 값이기 때문에 안넣어도 된다. 
 
# 전체 교수 리스트를 이름 내림차순으로 정렬하여 출력하기
 select * from professor order by pname desc;
 
 # 전체 교수 리스트를 학과별로 출력
 select * from professor order by pdept , pname;
 
 # 국문학과 교수 리스트를 이름 순서로 출력
 select * from professor where pdept = '국문학과' order by pname;
 
 # 전체 교수 리스트를 이름 역순으로 출력
 select * from professor order by pname desc;
 
 # 각 학과별 교수님은 몇 분인지 구하는 검색 문장을 작성하시오 
 select pdept,paddress,count(*) from professor group by pdept,paddress;
 
 # 김씨 성의 교수이름만 출력
 select * from professor where pname like '%김%';
 
 # mySQL 과목을 강의하는 교수님의 이름, 전화번호와 강의실을 검색하는 문장을 작성하시오.
 select p.pname, p.pphone, c.croom 
 from professor p,course c,lecture l
 where c.ccode = l.lccode and l.lpcode = p.pcode;
 
 select s.sname, c.cname
 from student s, course c, register r
 where s.scode = r.rscode and c.ccode = r.rccode
 and s.sname = '박소명';
 
 # 김구 교수님이 강의하는 과목명, 강의시간과 강의실을 검색하는 문장을 작성하시오.
 select p.pname, c.cname, c.ctime, c.croom
 from course c, lecture l, professor p
 where c.ccode = l.lccode and p.pcode = l.lpcode and p.pname = '김구';
 
 # 각 학생이 수강 신청한 과목에 대해서 학생이름, 과목명, 강의실, 강의시간을 검색하는 문장을 작성하시오.
 select s.sname, c.cname, c.croom, c.ctime 
 from student s, register r, course c
 where s.scode = r.rscode and c.ccode = r.rccode;

select * from course;
select sum(ctime) from course;
select avg(ctime) from course;
select count(ctime) from course; # column 하나만 넣기 때문에 count 시에 이게 훨씬 빠르다.
select count(*) from course;

# 각 학생이 신청한 총 학점을 구하는 검색 문장을 작성 하시오. (학생이름 , 전공, 신청학점 합계)
select s.sname,s.sdept, sum(c.ctime)
from student s, course c, register r
where s.scode = r.rscode and c.ccode = r.rccode
group by r.rscode;

# database에서 불러와서 계산을 한 뒤에 java로 넘길 때 column 이름을 알맞게 바꿔주기 위해서 사용한다. 
select 10 * 20 as result;

# 강의 시간이 2인 과목들의 강의시간을 한시간 증가시키고 강의실을 Lab1으로 변경하기
update course set ctime = ctime + 1, croom = 'Lab1' where ctime = 2;
select * from course;



