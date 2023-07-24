var1 <- 2
2 -> var2
var3 = 2

head(iris)
sum(iris$Sepal.Length)
iris$Sepal.Length[1]
iris$Sepal.Length[1:10]
sum(1:100)
sum(10,20,30)
var1[2]

num2 <- c(10 , 20 , 30)

num2[1] + num2[2]

num3 <- c(10,20,30,NA)
is.na(num3)
sum(is.na(num3))
sum(10,20,30,NA,na.rm=T)

# 자료형 확인
is.numeric(iris$Sepal.Length) # 숫자냐
is.integer(iris$Sepal.Length) # 정수냐
is.double(iris$Sepal.Length) # 실수냐
class(iris$Species)
is.data.frame(iris)
class(iris)
sum(is.na(iris$Sepal.Length)) 

# 자료구조
str(iris)
# factor 카테고리라고 생각하면 된다. 
gender <- c("man" , "woman" , "woman" , "woman" , "man")
class(gender)

# 빈도수 확인
table(gender)
# plot(gender)
# 문자열 데이터를 factor로 변환하기
Ngender <- as.factor(gender)
class(Ngender)
plot(Ngender)

str(Ngender)

# 날짜형 변환
date1 <- "17-02-28"
as.Date(date1,"%y-%m-%d")

# 진짜 요일 데이터인지 확인하기
dates <- c("02/28/17" , "02/29/17" , "03/01/17")
dates
as.Date(dates,"%m/%d/%y")

#날짜 계산 
mydates <- as.Date(c("2007-06-22" , "2010-01-30"))
mydates
mydates[2] - mydates[1]

# 현재 일자 기준으로 날짜 계산하기
Sys.Date()
class(Sys.Date())

Sys.Date() - as.Date("1993-11-14")
num1 <- 1234
as.character(num1)

# vector 자료 구조
# 1차원 선형 자료 구조 형태 
# 구성 : 변수[첨자] , 첨자는 1부터 시작
# 동일한 자료형의 데이터만 저장 할 수 있다. 
# 벡터 생성 함수 :  c() , seq() , rep() , :
# 벡터 처리 함수 : sum() , mean() , sd() , union()

head(iris)
irisSepalLength <- iris$Sepal.Length
irisSepalLength

# 벡터인지 확인하기
is.vector(irisSpealLength)
sum(irisSpealLength)
mean(irisSpealLength)
max(irisSpealLength)
min(irisSpealLength)

irisPetalLength <- iris$Petal.Length
irisPetalLength
max(irisSpealLength) - max(irisPetalLength)
mean(irisSpealLength) - mean(irisPetalLength)
sd(irisPetalLength)
sd(irisSpealLength)
median(irisSpealLength) / mean(irisSpealLength)
range(irisSpealLength)[c(1,10,11)] == min(irisSpealLength)
irisPetalLength[c(1,10,11)]
sum(irisPetalLength[c(1,10,11)])
irisPetalLength[c(1:20 , 30, 40)]
sum(irisPetalLength[c(1:20 , 30, 40)])

# 벡터형 자료의 일부를 변경
x<- c(10,20,30,40,50)
x
y <- replace(x,c(2,4),c(200,400))
y
x <-replace(x,c(2,3,4),3)
x

# 초기값, 최종값, 증가값으로 구성되는 벡터함수 생성
seq(1,10,0.5)

# 1에서 10까지의 홀수 , 1에서 10 
seq(1,10,2)
x <- c(seq(1,10,1) , 50, 60)
x

#repeat
rep(1:3,3)
c(rep("red",4),"grean")
rep(c(1,4,7,9),3)
rep(1:3, each=3)

#1~20까지의 숫자중 짝수만 2번 반복하여 벡터를 만들고 합꼐 구하기

x <- rep(seq(0,20,2),2)
x
sum(x)


#합집합

x <- c(1,3,5,7,9)
y <- c(3,5)
union(x,y)

#교집합
intersect(x,y)

#차집합
setdiff(x,y)

#
sample(1:10,2)

sample(1:10, 10)
sample(1:45, 6)

sample(x,3)
sort(sample(1:45, 6))

#iris의 Sepal.Length와 Petal.Length의 교집합의 갯수
length(intersect(irisSepalLength,irisPetalLength))

#iris의 Sepal.Length와 Petal.Length의 합집합의 갯수
length(union(irisSepalLength,irisPetalLength))

#1차원 벡터 Data에 이름 설정하기
age <- c(30,35,40); age
names(age) <- c("yubee", "kwanwoo" , "jangbi"); age


# 중복값을 제거하기
unique(iris$Sepal.Length)

x <- rep(c("a","b","c"),4)
x

# 벡터에 a가 있으면 1을 보여준다.
match(x, "a")
sum(match(x,"a"), na.rm = T)
table(match(x,"a"))
match(x, c("a" , "b"))
table(match(x,c("a","b","c")))
hist(match(x,c("a" , "b")))

name <- c("apple" , "computer" , "samsung" , "communication")

# name에서 co를 가지고 있는 단어의 번지수
grep("co",name)
name = name[-grep("co",name)]
name
name[grep("om",name)]

a <- 1:500
a

# 10번 ~ 전체 Data 중 끝에서 5개는 빼고 출력
a[10:(length(a)-5)]

a<-10:50
# 1번지 값 지우기
a<-a[c(-1,-2,-3)]
a

# 10, 11, 12 번지 값 지우기
a<-a[-c(10:12)]
a

a<-10:50

# 모가 들어올지 모르는 데이터다
# a의 홀수 번재 data의 합계 구하기
seq(1,length(a),2)
sum(a[seq(1,length(a),2)])

max(a) - min(a) > 3
